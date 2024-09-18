package com.prowidesoftware.swift.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Stream;
import org.apache.commons.lang3.Validate;

/**
 * Utility class for escaping EcmaScript and Java control characters.
 * This class provides methods for translating characters into their
 * escaped equivalents, specifically for EcmaScript.
 */
public class ConstraintUtils {

    // Map for Java control characters that need to be escaped
    private static final Map<CharSequence, CharSequence> JAVA_CTRL_CHARS_ESCAPE;

    static {
        final Map<CharSequence, CharSequence> initialMap = new HashMap<>();
        initialMap.put("\b", "\\b");
        initialMap.put("\n", "\\n");
        initialMap.put("\t", "\\t");
        initialMap.put("\f", "\\f");
        initialMap.put("\r", "\\r");
        JAVA_CTRL_CHARS_ESCAPE = Collections.unmodifiableMap(initialMap);
    }

    /**
     * Escapes the given input string using EcmaScript rules.
     * The method escapes control characters and symbols such as single quotes, double quotes,
     * backslashes, and forward slashes, making the string safe for use in EcmaScript contexts.
     *
     * @param input the string to escape, may be null
     * @return the escaped string or null if the input is null
     */
    public static String escapeEcmaScript(final String input) {
        if (input == null) {
            return null;
        }

        Map<CharSequence, CharSequence> escapeEcmaScriptMap = new HashMap<>();
        escapeEcmaScriptMap.put("'", "\\'");
        escapeEcmaScriptMap.put("\"", "\\\"");
        escapeEcmaScriptMap.put("\\", "\\\\");
        escapeEcmaScriptMap.put("/", "\\/");

        CharSequenceTranslator translator = new AggregateTranslator(
                new LookupTranslator(Collections.unmodifiableMap(escapeEcmaScriptMap)),
                new LookupTranslator(JAVA_CTRL_CHARS_ESCAPE),
                JavaUnicodeEscaper.outsideOf(32, 0x7f));

        return translator.translate(input);
    }
}

abstract class CharSequenceTranslator {

    /**
     * Array containing the hexadecimal alphabet.
     */
    static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /**
     * Returns an upper case hexadecimal {@code String} for the given
     * character.
     *
     * @param codePoint The code point to convert.
     * @return An upper case hexadecimal {@code String}
     */
    static String hex(final int codePoint) {
        return Integer.toHexString(codePoint).toUpperCase(Locale.ENGLISH);
    }

    /**
     * Helper for non-Writer usage.
     * @param input CharSequence to be translated
     * @return String output of translation
     */
    final String translate(final CharSequence input) {
        if (input == null) {
            return null;
        }
        try {
            final StringWriter writer = new StringWriter(input.length() * 2);
            translate(input, writer);
            return writer.toString();
        } catch (final IOException ioe) {
            // this should never ever happen while writing to a StringWriter
            throw new UncheckedIOException(ioe);
        }
    }

    /**
     * Translate a set of code points, represented by an int index into a CharSequence,
     * into another set of code points. The number of code points consumed must be returned,
     * and the only IOExceptions thrown must be from interacting with the Writer so that
     * the top level API may reliably ignore StringWriter IOExceptions.
     *
     * @param input CharSequence that is being translated
     * @param index int representing the current point of translation
     * @param writer Writer to translate the text to
     * @return int count of code points consumed
     * @throws IOException if and only if the Writer produces an IOException
     */
    abstract int translate(CharSequence input, int index, Writer writer) throws IOException;

    /**
     * Translate an input onto a Writer. This is intentionally final as its algorithm is
     * tightly coupled with the abstract method of this class.
     *
     * @param input CharSequence that is being translated
     * @param writer Writer to translate the text to
     * @throws IOException if and only if the Writer produces an IOException
     */
    final void translate(final CharSequence input, final Writer writer) throws IOException {
        Validate.isTrue(writer != null, "The Writer must not be null");
        if (input == null) {
            return;
        }
        int pos = 0;
        final int len = input.length();
        while (pos < len) {
            final int consumed = translate(input, pos, writer);
            if (consumed == 0) {
                // inlined implementation of Character.toChars(Character.codePointAt(input, pos))
                // avoids allocating temp char arrays and duplicate checks
                final char c1 = input.charAt(pos);
                writer.write(c1);
                pos++;
                if (Character.isHighSurrogate(c1) && pos < len) {
                    final char c2 = input.charAt(pos);
                    if (Character.isLowSurrogate(c2)) {
                        writer.write(c2);
                        pos++;
                    }
                }
                continue;
            }
            // contract with translators is that they have to understand code points
            // and they just took care of a surrogate pair
            for (int pt = 0; pt < consumed; pt++) {
                pos += Character.charCount(Character.codePointAt(input, pos));
            }
        }
    }

    /**
     * Helper method to create a merger of this translator with another set of
     * translators. Useful in customizing the standard functionality.
     *
     * @param translators CharSequenceTranslator array of translators to merge with this one
     * @return CharSequenceTranslator merging this translator with the others
     */
    final CharSequenceTranslator with(final CharSequenceTranslator... translators) {
        final CharSequenceTranslator[] newArray = new CharSequenceTranslator[translators.length + 1];
        newArray[0] = this;
        System.arraycopy(translators, 0, newArray, 1, translators.length);
        return new AggregateTranslator(newArray);
    }
}

class AggregateTranslator extends CharSequenceTranslator {

    /**
     * Translator list.
     */
    private final List<CharSequenceTranslator> translators = new ArrayList<>();

    /**
     * Specify the translators to be used at creation time.
     *
     * @param translators CharSequenceTranslator array to aggregate
     */
    AggregateTranslator(final CharSequenceTranslator... translators) {
        if (translators != null) {
            Stream.of(translators).filter(Objects::nonNull).forEach(this.translators::add);
        }
    }

    /**
     * The first translator to consume code points from the input is the 'winner'.
     * Execution stops with the number of consumed code points being returned.
     * {@inheritDoc}
     */
    @Override
    int translate(final CharSequence input, final int index, final Writer writer) throws IOException {
        for (final CharSequenceTranslator translator : translators) {
            final int consumed = translator.translate(input, index, writer);
            if (consumed != 0) {
                return consumed;
            }
        }
        return 0;
    }
}

class LookupTranslator extends CharSequenceTranslator {

    /** The mapping to be used in translation. */
    private final Map<String, String> lookupMap;

    /** The first character of each key in the lookupMap. */
    private final BitSet prefixSet;

    /** The length of the shortest key in the lookupMap. */
    private final int shortest;

    /** The length of the longest key in the lookupMap. */
    private final int longest;

    /**
     * Constructs the lookup table to be used in translation
     *
     * Note that, as of Lang 3.1 (the origin of this code), the key to the lookup
     * table is converted to a java.lang.String. This is because we need the key
     * to support hashCode and equals(Object), allowing it to be the key for a
     * HashMap. See LANG-882.
     *
     * @param lookupMap Map&lt;CharSequence, CharSequence&gt; table of translator
     *                  mappings
     */
    LookupTranslator(final Map<CharSequence, CharSequence> lookupMap) {
        if (lookupMap == null) {
            throw new InvalidParameterException("lookupMap cannot be null");
        }
        this.lookupMap = new HashMap<>();
        this.prefixSet = new BitSet();
        int currentShortest = Integer.MAX_VALUE;
        int currentLongest = 0;

        for (final Map.Entry<CharSequence, CharSequence> pair : lookupMap.entrySet()) {
            this.lookupMap.put(pair.getKey().toString(), pair.getValue().toString());
            this.prefixSet.set(pair.getKey().charAt(0));
            final int sz = pair.getKey().length();
            if (sz < currentShortest) {
                currentShortest = sz;
            }
            if (sz > currentLongest) {
                currentLongest = sz;
            }
        }
        this.shortest = currentShortest;
        this.longest = currentLongest;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    int translate(final CharSequence input, final int index, final Writer writer) throws IOException {
        // check if translation exists for the input at position index
        if (prefixSet.get(input.charAt(index))) {
            int max = longest;
            if (index + longest > input.length()) {
                max = input.length() - index;
            }
            // implement greedy algorithm by trying maximum match first
            for (int i = max; i >= shortest; i--) {
                final CharSequence subSeq = input.subSequence(index, index + i);
                final String result = lookupMap.get(subSeq.toString());

                if (result != null) {
                    writer.write(result);
                    return Character.codePointCount(subSeq, 0, subSeq.length());
                }
            }
        }
        return 0;
    }
}

abstract class CodePointTranslator extends CharSequenceTranslator {

    @Override
    final int translate(final CharSequence input, final int index, final Writer writer) throws IOException {
        final int codePoint = Character.codePointAt(input, index);
        final boolean consumed = translate(codePoint, writer);
        return consumed ? 1 : 0;
    }

    /**
     * Translates the specified code point into another.
     *
     * @param codePoint int character input to translate
     * @param writer Writer to optionally push the translated output to
     * @return boolean as to whether translation occurred or not
     * @throws IOException if and only if the Writer produces an IOException
     */
    abstract boolean translate(int codePoint, Writer writer) throws IOException;
}

class UnicodeEscaper extends CodePointTranslator {

    /**
     * Constructs a {@code UnicodeEscaper} above the specified value (exclusive).
     *
     * @param codePoint above which to escape
     * @return The newly created {@code UnicodeEscaper} instance
     */
    static UnicodeEscaper above(final int codePoint) {
        return outsideOf(0, codePoint);
    }
    /**
     * Constructs a {@code UnicodeEscaper} below the specified value (exclusive).
     *
     * @param codePoint below which to escape
     * @return The newly created {@code UnicodeEscaper} instance
     */
    static UnicodeEscaper below(final int codePoint) {
        return outsideOf(codePoint, Integer.MAX_VALUE);
    }
    /**
     * Constructs a {@code UnicodeEscaper} between the specified values (inclusive).
     *
     * @param codePointLow above which to escape
     * @param codePointHigh below which to escape
     * @return The newly created {@code UnicodeEscaper} instance
     */
    static UnicodeEscaper between(final int codePointLow, final int codePointHigh) {
        return new UnicodeEscaper(codePointLow, codePointHigh, true);
    }

    /**
     * Constructs a {@code UnicodeEscaper} outside of the specified values (exclusive).
     *
     * @param codePointLow below which to escape
     * @param codePointHigh above which to escape
     * @return The newly created {@code UnicodeEscaper} instance
     */
    static UnicodeEscaper outsideOf(final int codePointLow, final int codePointHigh) {
        return new UnicodeEscaper(codePointLow, codePointHigh, false);
    }

    /** The lowest code point boundary. */
    private final int below;

    /** The highest code point boundary. */
    private final int above;

    /** Whether to escape between the boundaries or outside them. */
    private final boolean between;

    /**
     * Constructs a {@code UnicodeEscaper} for all characters.
     */
    UnicodeEscaper() {
        this(0, Integer.MAX_VALUE, true);
    }

    /**
     * Constructs a {@code UnicodeEscaper} for the specified range. This is
     * the underlying method for the other constructors/builders. The {@code below}
     * and {@code above} boundaries are inclusive when {@code between} is
     * {@code true} and exclusive when it is {@code false}.
     *
     * @param below int value representing the lowest code point boundary
     * @param above int value representing the highest code point boundary
     * @param between whether to escape between the boundaries or outside them
     */
    protected UnicodeEscaper(final int below, final int above, final boolean between) {
        this.below = below;
        this.above = above;
        this.between = between;
    }

    /**
     * Converts the given code point to a hexadecimal string of the form {@code "\\uXXXX"}.
     *
     * @param codePoint
     *            a Unicode code point
     * @return The hexadecimal string for the given code point
     */
    protected String toUtf16Escape(final int codePoint) {
        return "\\u" + hex(codePoint);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    boolean translate(final int codePoint, final Writer writer) throws IOException {
        if (between) {
            if (codePoint < below || codePoint > above) {
                return false;
            }
        } else if (codePoint >= below && codePoint <= above) {
            return false;
        }

        if (codePoint > 0xffff) {
            writer.write(toUtf16Escape(codePoint));
        } else {
            writer.write("\\u");
            writer.write(HEX_DIGITS[codePoint >> 12 & 15]);
            writer.write(HEX_DIGITS[codePoint >> 8 & 15]);
            writer.write(HEX_DIGITS[codePoint >> 4 & 15]);
            writer.write(HEX_DIGITS[codePoint & 15]);
        }
        return true;
    }
}

class JavaUnicodeEscaper extends UnicodeEscaper {

    /**
     * Constructs a {@code JavaUnicodeEscaper} above the specified value (exclusive).
     *
     * @param codePoint
     *            above which to escape
     * @return The newly created {@code UnicodeEscaper} instance
     */
    static JavaUnicodeEscaper above(final int codePoint) {
        return outsideOf(0, codePoint);
    }

    /**
     * Constructs a {@code JavaUnicodeEscaper} below the specified value (exclusive).
     *
     * @param codePoint
     *            below which to escape
     * @return The newly created {@code UnicodeEscaper} instance
     */
    static JavaUnicodeEscaper below(final int codePoint) {
        return outsideOf(codePoint, Integer.MAX_VALUE);
    }

    /**
     * Constructs a {@code JavaUnicodeEscaper} between the specified values (inclusive).
     *
     * @param codePointLow
     *            above which to escape
     * @param codePointHigh
     *            below which to escape
     * @return The newly created {@code UnicodeEscaper} instance
     */
    static JavaUnicodeEscaper between(final int codePointLow, final int codePointHigh) {
        return new JavaUnicodeEscaper(codePointLow, codePointHigh, true);
    }

    /**
     * Constructs a {@code JavaUnicodeEscaper} outside of the specified values (exclusive).
     *
     * @param codePointLow
     *            below which to escape
     * @param codePointHigh
     *            above which to escape
     * @return The newly created {@code UnicodeEscaper} instance
     */
    static JavaUnicodeEscaper outsideOf(final int codePointLow, final int codePointHigh) {
        return new JavaUnicodeEscaper(codePointLow, codePointHigh, false);
    }

    /**
     * Constructs a {@code JavaUnicodeEscaper} for the specified range. This is the underlying method for the
     * other constructors/builders. The {@code below} and {@code above} boundaries are inclusive when
     * {@code between} is {@code true} and exclusive when it is {@code false}.
     *
     * @param below
     *            int value representing the lowest code point boundary
     * @param above
     *            int value representing the highest code point boundary
     * @param between
     *            whether to escape between the boundaries or outside them
     */
    JavaUnicodeEscaper(final int below, final int above, final boolean between) {
        super(below, above, between);
    }

    /**
     * Converts the given code point to a hexadecimal string of the form {@code "\\uXXXX\\uXXXX"}.
     *
     * @param codePoint
     *            a Unicode code point
     * @return The hexadecimal string for the given code point
     */
    @Override
    protected String toUtf16Escape(final int codePoint) {
        final char[] surrogatePair = Character.toChars(codePoint);
        return "\\u" + hex(surrogatePair[0]) + "\\u" + hex(surrogatePair[1]);
    }
}
