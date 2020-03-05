/*
 * Copyright 2006-2018 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.model.field;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.prowidesoftware.JsonSerializable;
import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.logging.Level;


/**
 * Base class implemented by classes that provide a general access to field components.
 *
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public abstract class Field implements PatternContainer, JsonSerializable {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Field.class.getName());

	/**
	 * Zero based list of field components in String format.<br>
	 * For example: for field content ":FOO//EUR1234 will be components[0]=FOO, components[1]=EUR and components[1]=1234
	 */
	protected List<String> components;

	/**
	 * @deprecated use {@link #Field(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3=TargetYear.SRU2020)
	protected Field() {
		DeprecationUtils.phase2(getClass(), "Field() no args constructor", "Use the constructor Field(int) with the number of components parameter instead");
	}

	/**
	 * Creates a field with the list of components initialized to the given number of components.
	 * @see #init(int)
	 * @param components the number of components to initialize
	 */
	protected Field(final int components) {
		super();
		init(components);
	}

	/**
	 * Initialize the list of components to the indicated size and sets all values to null
	 * @param components the number of components to initialize
	 * @since 7.8
	 */
	protected void init(final int components) {
		this.components = new ArrayList<>(components);
		for (int i=0;i<components;i++) {
			this.components.add(null);
		}
	}

	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @param value complete field value including separators and CRLF
	 */
	protected Field(final String value) {
		super();
		parse(value);
		/*
		 * trim empty components to null
		 */
		for (int i=0; i<this.components.size(); i++) {
			if (StringUtils.isEmpty(this.components.get(i))) {
				this.components.set(i, null);
			}
		}
	}
	
	/**
	 * Parses the parameter value into the internal components structure.
	 * Used to update all components from a full new value, as an alternative
	 * to setting individual components. Previous components value is overwritten.
	 * <br>
	 * Implemented by subclasses with logic for each specific field structure. 
	 * 
	 * @param value complete field value including separators and CRLF
	 * @since 7.8
	 */
	public abstract void parse(final String value);

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	protected Field(final Field source) {
		this.components = new ArrayList<String>(source.getComponents());
	}

	/**
	 * Implementation of toString using ToStringBuilder from commons-lang
	 */
	@Override
	public String toString() {
		return org.apache.commons.lang3.builder.ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Implementation of equals using EqualsBuilder from commons-lang
	 */
	@Override
	public boolean equals(final Object obj) {
		return org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals(this, obj);
	}

	/**
	 * Implementation of hashCode using HashCodeBuilder from commons-lang
	 */
	@Override
	public int hashCode() {
		return org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode(this);
	}

	/**
	 * Format the given object as a money number without currency information in format
	 * @param aValue
	 * @return the formatted amount as String
	 */
	protected static String formatNumber(final Object aValue) {
		//create formatter for financial amounts
		final DecimalFormat fmt = new DecimalFormat("#,###.00");

		final NumberFormat f = NumberFormat.getInstance(Locale.getDefault());
		if (f instanceof DecimalFormat) {
			((DecimalFormat) f).setDecimalSeparatorAlwaysShown(true);
			fmt.setDecimalFormatSymbols(((DecimalFormat) f).getDecimalFormatSymbols());
		}
		final String formatted = fmt.format(aValue);
		return formatted;
	}


	/**
	 * @param d Date object to format
	 * @return the formatted date as dd/MM/yyyy or empty if exception occurs during formatting
	 */
	protected static String format(final Calendar d) {
		if (d != null) {
			try {
				return DateFormatUtils.format(d.getTime(), "dd/MM/yyyy");
			} catch (final Exception e) {
				log.log(Level.WARNING, "error formatting date", e);
			}
		}
		return StringUtils.EMPTY;
	}

	/**
	 * A formatted account with a fixed format nnnn-nnnnn-nnn-n
	 * @param a string with an account number or null
	 * @return the formatted account or an empty String if param is null
	 */
	// TODO support user formatting masks from property file
	protected static String formatAccount(final String a) {
		if (a != null) {
			final StringBuilder result = new StringBuilder(a);
			try {
				result.insert(4, '-');
				result.insert(9, '-');
				result.insert(12, '-');
				return result.toString();
			} catch (final Exception e) {
				log.log(Level.WARNING, "error formatting account", e);
			}
		}
		return StringUtils.EMPTY;
	}

	/**
	 * Append each lines in a new lines, empty lines are ignored
	 * @param sb must not be null, target buffer
	 * @param lines may be null or empty, nothing is done in this case
	 */
	protected void appendInLines(final StringBuilder sb, final String... lines) {
		Validate.notNull(sb);
		if (lines==null) {
			log.finest("lines is null");
		} else {
			for (int i=0;i<lines.length;i++) {
				if (StringUtils.isNotBlank(lines[i])) {
					if (i != 0 || StringUtils.isNotBlank(sb.toString())) {
						sb.append(FINWriterVisitor.SWIFT_EOL);
					}
					sb.append(lines[i]);
				}
			}
		}
	}

	/**
	 * Append each component between componentStart and componentEnd in a new lines, empty components are ignored
	 * @param sb must not be null, target buffer
	 * @param componentStart starting component number to add
	 * @param componentEnd ending component number to add
	 */
	protected void appendInLines(final StringBuilder sb, final int componentStart, final int componentEnd) {
		Validate.notNull(sb);
		boolean first = true;
		for (int i=componentStart; i<=componentEnd; i++) {
			final String c = getComponent(i);
			if (StringUtils.isNotBlank(c)) {
				if (!first || StringUtils.isNotBlank(sb.toString())) {
					sb.append(FINWriterVisitor.SWIFT_EOL);
				}
				sb.append(c);
				first = false;
			}
		}
	}

	/**
	 * @return comopnents list
	 */
	public List<String> getComponents() {
		return components;
	}

	/**
	 * @param components list to set
	 */
	public void setComponents(final List<String> components) {
		this.components = components;
	}

	/**
	 * Inserts a component String value into the list of components, using the component number to position the value into the List.
	 * @param number component number, first component of a field should be number one
	 * @param value String value of the parsed component (without component separators ':', '/', '//')
	 */
	public void setComponent(final int number, final String value) {
		Validate.isTrue(number > 0, "components are numerated starting at 1, cannot insert a component with number "+number);

		//internal position index is zero based
		final int position = number - 1;

		if (this.components == null) {
			this.components = new ArrayList<>();
		}
		if (position >= this.components.size()) {
			log.warning("component number "+number+" is out of bound for field "+getName());
		} else {
			this.components.set(position, value);
		}
	}

	/**
	 * Gets a specific component from the components list.
	 * @param number one-based index of component, first component of a field should be number one
	 * @return found component or null
	 */
	public String getComponent(final int number) {
		//internal position index is zero based
		final int position = number - 1;

		if (this.components != null) {
			if ((position >= 0) && (position < this.components.size())) {
				return this.components.get(position);
			}
		}
		return null;
	}

	/**
	 * @see #getValueDisplay(Locale)
	 */
	public String getValueDisplay() {
		return getValueDisplay(null);
	}
		
	/**
	 * Get a localized, suitable for showing to humans string of the field values.
	 * This method is overwritten when necessary by subclasses.
	 * 
	 * @param locale optional locale to format date and amounts, if null, the default locale is used
	 * @return a concatenation of formated components with " " separator
	 * @see #getValueDisplay(int, Locale)
	 * @since 7.8
	 */
	public String getValueDisplay(Locale locale) {
		final StringBuilder result = new StringBuilder();
		for (int i=1; i<=components.size(); i++) {
			final String s = getValueDisplay(i, locale);
			if (s != null) {
				if (result.length() > 0) {
					result.append(" ");
				}
				result.append(s);
			}
		}
		return result.toString();
	}

	/**
	 * Returns a localized suitable for showing to humans string of a field component.
	 *
	 * @param component number of the component to display
	 * @param locale optional locale to format date and amounts, if null, the default locale is used
	 * @return formatted component value or null if component number is invalid or not present
	 * @throws IllegalArgumentException if component number is invalid for the field
	 * @since 7.8
	 */
	public abstract String getValueDisplay(int component, Locale locale);
	
	/**
	 * Get the given component as the given object type.
	 * If the class is not recognized, it returns null, as well as if conversion fails.
	 * @param component one-based index of the component to retrieve
	 * @see #getComponent(int)
	 * @throws IllegalArgumentException if c is not any of: String, BIC, Currency, Number, BigDecimal Character or Integer
	 */
	public Object getComponentAs(final int component, @SuppressWarnings("rawtypes") final Class c) {
		try {
			final String s = getComponent(component);
			log.finest("converting string value: "+s);

			if (c.equals(String.class)) {
				return s;

			} else if (c.equals(Number.class) || c.equals(BigDecimal.class) ) {
				return SwiftFormatUtils.getNumber(s);

			} else if (c.equals(BIC.class)) {
				return new BIC(s);

			} else if (c.equals(Currency.class)) {
				return Currency.getInstance(s);

			} else if (c.equals(Character.class)) {
				return SwiftFormatUtils.getSign(s);

			} else if (c.equals(Integer.class)) {
				return Integer.valueOf(s);

			} else {
				throw new IllegalArgumentException("Can't handle "+c.getName());
			}
		} catch (final Exception e) {
			log.severe("Error converting component content: "+e);
		}
		return null;
	}
	
	/**
	 * Get the given component as a number object
	 * This method internall y calls {@link #getComponentAs(int, Class)}, and casts the result
	 * @since 7.8
	 */
	public Number getComponentAsNumber(final int component) {
		return (Number)getComponentAs(component, Number.class);
	}

	/**
	 * Returns a string with joined components values.
	 *
	 * @param start starting index of components to join (zero based)
	 * @param skipLast if true the last component will not be included in the join, and where
	 * the "last" component is understood as the last not empty component (this is not necessary
	 * the last component of the field's component list.
	 *
	 * @return s
	 */
	public String joinComponents(final int start, final boolean skipLast) {
		// FIXME para que se crea el list intermedio toAdd? no le veo razon de ser, se podria iterar en el segundo loop directo sobre this.components
		final List<String> toAdd = new ArrayList<>();
		for (int i = start; i < this.componentsSize(); i++) {
			if (StringUtils.isNotEmpty(this.components.get(i))) {
				toAdd.add(this.components.get(i));
			}
		}
		final int end = skipLast ? toAdd.size() - 1 : toAdd.size();
		final StringBuilder result = new StringBuilder();
		for (int i = 0; i < end; i++) {
			result.append(toAdd.get(i));
		}
		return result.toString();
	}

	/**
	 * Returns a string with all field's components joined.
	 * @param skipLast
	 * @return s
	 * @see #joinComponents(int, boolean)
	 */
	public String joinComponents(final boolean skipLast) {
		return joinComponents(0, skipLast);
	}

	/**
	 * Returns a string with all field's components joined
	 * @param start
	 * @return s
	 * @see #joinComponents(int, boolean)
	 */
	public String joinComponents(final int start) {
		return joinComponents(start, false);
	}

	/**
	 * Returns a string with all field's components joined.
	 * @return s
	 * @see #joinComponents(int, boolean)
	 */
	public String joinComponents() {
		return joinComponents(0, false);
	}

	/**
	 * Gets a BigDecimal from a generic Number argument
	 * @param number
	 * @return BigDecimal value of number parameter
	 */
	static public BigDecimal getAsBigDecimal(final Number number) {
		if (number instanceof BigDecimal) {
			return (BigDecimal)number;
		} else if (number instanceof Long) {
			return new BigDecimal(((Long)number).longValue());
		} else if (number instanceof Integer) {
			return new BigDecimal(((Integer)number).intValue());
		} else if (number instanceof Short) {
			return new BigDecimal(((Short)number).intValue());
		} else if (number instanceof Double) {
			return new BigDecimal(number.toString());
		} else {
			throw new IllegalArgumentException("class "+number.getClass().getName()+" is not supported");
		}
	}

	/**
	 * Returns the first component starting with the given prefix value or null if not found.
	 * @param prefix
	 * @return s
	 */
	public String findComponentStartingWith(final String prefix) {
		for (int i=0; i<this.components.size(); i++) {
			final String c = this.components.get(i);
			if (StringUtils.startsWith(c, prefix)) {
				return c;
			}
		}
		return null;
	}

	/**
	 * Finds the first component starting with the given codeword between slashes, and returns the component subvalue.
	 * For example, for the following field value<br>
	 * /ACC/BLABLABLA CrLf<br>
	 * //BLABLABLA CrLf<br>
	 * /INS/CITIUS33MIA CrLf<br>
	 * //BLABLABLA CrLf<br>
	 * A call to this method with parameter "INS" will return "CITIUS33MIA"
	 *
	 * @param codeword
	 * @see #findComponentStartingWith(String)
	 * @return the found value or null if not found
	 */
	public String getValueByCodeword(final String codeword) {
		final String key = "/"+codeword+"/";
		final String c = findComponentStartingWith(key);
		if (c != null) {
			return StringUtils.substringAfter(c, key);
		}
		return null;
	}

	/**
	 * Serializes the components into the a plain string value in SWIFT format.
	 * 
	 * <p>This method implementation is specific for each field. All not null
	 * components are appended to the result string with proper components
	 * separators like ':', slashes and CRLF.
	 * 
	 * <p>For any <strong>valid</strong> field this is always true: 
	 * <code>new Field(v)).getValue() = v</code>
	 * meaning plain value integrity must be preserved after parsing the value
	 * into components and serializing it back into the plain value.
	 * Conversely this may not be true when the parsed field value is invalid 
	 * because the parser will do a best effort to gather as many valid components
	 * as possible and the serialization will also do a best effort to generate
	 * valid content.
	 *  
	 * @return SWIFT formatted value
	 */
	public abstract String getValue();

	/**
	 * Returns true if all field's components are blank or null
	 * @return true if all field's components are blank or null
	 */
	public boolean isEmpty() {
		for (final String c : getComponents()) {
			if ((c != null) && StringUtils.isNotBlank(c)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Creates a Field instance for the given Tag object, using reflection.
	 * The created object is populated with parsed components data from the Tag.
	 * @param t a tag with proper name and value content
	 * @return a specific field object, ex: Field32A. Or null if exceptions occur during object creation.
	 */
	static public Field getField(final Tag t) {
		return getField(t.getName(), t.getValue());
	}

	/**
	 * Creates a Field instance for the given it's name and and optional value, using reflection.
	 * 
	 * @param name a proper field name, ex: 32A, 22F, 20
	 * @param value an optional field value or null to create the field with no initial content
	 * @return a specific field object (example: Field32A) or null if exceptions occur during object creation.
	 * @since 7.8
	 */
	static public Field getField(final String name, final String value) {
		Object r = null;
		try {
			final Class<?> c = Class.forName("com.prowidesoftware.swift.model.field.Field" + name);
			@SuppressWarnings("rawtypes")
			final Class[] argsClass = new Class[] { String.class };
			@SuppressWarnings("rawtypes")
			final Constructor ct = c.getConstructor(argsClass);
			final Object arglist[] = new Object[] { value };
			r = ct.newInstance(arglist);
		} catch (final ClassNotFoundException e) {
			log.warning("Field class for Field" + name
			        + " not found. This is normally caused by an unrecognized field in the message or a malformed message block structure.");
		} catch (final Exception e) {
			log.log(Level.WARNING, "An error occurred while creating an instance of " + name, e);
		}
		return (Field) r;
	}

	/**
	 * Same as {@link #getLabel(String, String, String, Locale)} using default locale
	 * @since 7.8
	 */
	static public String getLabel(final String fieldName, final String mt, final String sequence) {
		return getLabel(fieldName, mt, sequence, Locale.getDefault());
	}
	
	/**
	 * Returns the field business description name, using resource bundle from pw_swift_labels property files.
	 * Field names may be generic for all usages, or may differ for particular letter option, message type
	 * or even sequence of a message type. The property supports all this kind of definitions with generic
	 * labels and specific ones. The following example illustrate the precedence of bundle keys that are checked for
	 * field 50:<br>
	 * <ul>
	 * <li>50K[103][B]</li>
	 * <li>50a[103][B]</li>
	 * <li>50K[103]</li>
	 * <li>50a[103]</li>
	 * <li>50K</li>
	 * <li>50a</li>
	 * <li>50</li>
	 * </ul>
	 * 
	 * @param fieldName field name of the field to retrieve its label, if the combination of number and letter option
	 * is provided then a specific label is returned; is the letter option is omitted then a more generic label is returned.
	 * @param mt optional indication of message type or null.
	 * @param sequence optional indication of sequence or null if does not apply for the specific MT and field.
	 * @param locale the locale for which a resource bundle is desired
	 *
	 * @return a resource bundle based label for the given locale or the tag name, or the resource key if not found
	 */
	static public String getLabel(final String fieldName, final String mt, final String sequence, final Locale locale) {
		return _getLabel(fieldName, mt, sequence, locale, "name");
	}
	
	/**
	 * Similar to {@link #getLabelComponents(String, String, String, Locale)} but returning the components property in bundle
	 * @since 7.8.4
	 */
	static public String getLabelComponents(final String fieldName, final String mt, final String sequence, final Locale locale) {
		Locale l = locale != null? locale : Locale.getDefault();
		return _getLabel(fieldName, mt, sequence, l, "components");
	}
	
	static private String _getLabel(final String fieldName, final String mt, final String sequence, final Locale locale, final String prop) {
		final String bundle = "pw_swift_labels";
		String key = null;
		String result = null;
		//try {
		final ResourceBundle labels = ResourceBundle.getBundle(bundle, locale);
		if (labels != null) {
			if ((sequence != null) && (mt != null)) {
				/*
				 * sequence + mt
				 */
				key = "field" + fieldName + "["+mt+"]["+sequence+"]."+prop;
				result = getString(labels, key);
				if (result == null) {
					/*
					 * sequence + mt + generic letter option
					 */
					key = "field" + getNumber(fieldName) + "a["+mt+"]["+sequence+"]."+prop;
					result = getString(labels, key);
				}
			}
			if ((result == null) && (mt != null)) {
				/*
				 * mt only
				 */
				key = "field" + fieldName + "["+mt+"]."+prop;
				result = getString(labels, key);
				if (result == null) {
					/*
					 * mt + generic letter option
					 */
					key = "field" + getNumber(fieldName) + "a["+mt+"]."+prop;
					result = getString(labels, key);
				}
			}
			if (result == null) {
				/*
				 * tag only
				 */
				key = "field" + fieldName + "."+prop;
				result = getString(labels, key);
				if (result == null) {
					/*
					 * tag + generic letter option
					 */
					key = "field" + getNumber(fieldName) + "a."+prop;
					result = getString(labels, key);
				}
			}
			if (result == null) {
				/*
				 * number only
				 */
				key = "field" + getNumber(fieldName) + "."+prop;
				result = getString(labels, key);
			}
		}
		//} catch (MissingResourceException e) {
		//	e.printStackTrace();
		//}
		if (result != null) {
			return result;
		}
		return key;
	}

	/**
	 * Helper implementation of getString from bundle without throwing exception
	 * @param labels
	 * @param key
	 * @return the found resource or null if not found for the given key
	 */
	private static String getString(final ResourceBundle labels, final String key) {
		try {
			return labels.getString(key);
		} catch (final MissingResourceException ignored) {
			return null;
		}
	}

	private static String getNumber(final String fieldName) {
		if (fieldName != null) {
			final StringBuilder sb = new StringBuilder();
			for (int i=0; i<fieldName.length(); i++) {
				final char c = fieldName.charAt(i);
				if (Character.isDigit(c)) {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				return sb.toString();
			}
		}
		return null;
	}

	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of FieldNN.NAME
	 */
	public abstract String getName();
	
	
	/**
	 * Returns the field's components pattern
	 * @since 7.8
	 */
	public abstract String componentsPattern();
	/**
	 * Returns the field's validator pattern
	 * @since 7.8
	 */
	public abstract String validatorPattern() ;

	public abstract boolean isOptional(int component);
	public abstract boolean isGeneric();

	/**
	 * Moved to GenericField Interface
	 */
	@Deprecated
	@ProwideDeprecated(phase3=TargetYear.SRU2020)
	public String getDSS() {
		return null;
	}

	/**
	 * Moved to GenericField Interface
	 */
	@Deprecated
	@ProwideDeprecated(phase3=TargetYear.SRU2020)
	public boolean isDSSPresent() {
		return false;
	}

	/**
	 * Moved to GenericField Interface
	 */
	@Deprecated
	@ProwideDeprecated(phase3=TargetYear.SRU2020)
	public String getConditionalQualifier() {
		return null;
	}

	// FIXME debido a esto: el nombre del field deberia ser validado y eliminado como atributo dinamico
	/**
	 * Return the letter option of this field as given by it classname or null if this field has no letter option
	 */
	public Character letterOption() {
		final String cn = getClass().getName();
		final char c = cn.charAt(cn.length()-1);
		if (Character.isLetter(c)) {
			return c;
		}
		return null;
	}

	/**
	 * Tell if this field is of a given letter option.
	 * letter is case sensitive
	 */
	public boolean isLetterOption(final char c) {
		final Character l = letterOption();
		if (l!=null) {
			return l.charValue() == c;
		}
		return false;
	}

	/**
	 * @deprecated confusing name, use {@link #isNameAnyOf(String...)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public boolean isAnyOf(final String ... names) {
		DeprecationUtils.phase3(getClass(), "isAnyOf(String...)", "Use isNameAnyOf(String...) instead.");
		return isNameAnyOf(names);
	}

	/**
	 * Compares the this fields's name with a list of names to check
	 * @param names must not be null nor empty
	 * @return true if this field names equals one in the list of names and false otherwise
	 * @throws IllegalArgumentException if names is null or empty
	 */
	public boolean isNameAnyOf(final String ... names) {
		Validate.isTrue(names != null && names.length>0, "name list must have at least one element");
		for (final String n:names) {
			if (StringUtils.equals(getName(), n)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Compares this field component 1 with the parameter value
	 * <br>
	 * Same as <code>is(1, compare)</code>
	 * <br>
	 * If the field has only one component this is the same as comparing against field value
	 * @param compare string to compare
	 * @return true if the first component is equal to the parameter
	 */
	public boolean is(final String compare) {
		return StringUtils.equals(compare, getComponent(1));
	}
	/**
	 * Compares a specific component with the parameter value
	 * @param componentNumber component number 1-based
	 * @param compare string to compare
	 * @return true if the indicated component value is equal to the parameter
	 */
	public boolean is(final int componentNumber, final String compare) {
		return StringUtils.equals(compare, getComponent(componentNumber));
	}

	/**
	 * Compares this field components 1 and 2 with the parameter values.
	 * @param compare1 string to compare with component 1
	 * @param compare2 string to compare with component 2
	 * @return true if components 1 and 2 are equal the parameter values respectively
	 */
	public boolean is(final String compare1, final String compare2) {
		return StringUtils.equals(compare1, getComponent(1)) && StringUtils.equals(compare2, getComponent(2));
	}

	/**
	 * Compares this field component 1 with the parameter values.
	 * <br>
	 * If the field has only one component this is the same as comparing against the field value
	 * @param values the values to compare
	 * @return true if the first component is equal to any of the given values
	 * @since 7.9.7
	 */
	public boolean is(final String ... values) {
		final String comp1 = getComponent(1);
		if (values != null) {
			for (String value : values) {
				if (StringUtils.equals(comp1, value)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Get the generic tag object of this field.
	 */
	public Tag asTag() {
		return new Tag(getName(), getValue());
	}

	/**
	 * Returns the defined amount of components.<br>
	 * This is not the amount of components present in the field instance, but the total amount of components
	 * that this field accepts as defined.
	 */
	public abstract int componentsSize();

	/**
	 * Base implementation for subclasses getLine API.
	 *
	 * Notice that line instance numbers are static and relevant to the
	 * field components definition, and not relative to the particular
	 * instance value. For example field 35B Line[1] will be the line with the
	 * ISIN number, regardless of the ISIN number present or not in the particular
	 * field instance. If that ISIN line is not present in the parameter field,
	 * the method will return null.<br><br>
	 *
	 * Also notice that a line may be composed by several components, there is
	 * no linear relation between component numbers and lines numbers.<br>
	 *
	 * @param cp a copy of the subclass (this object is altered during method execution)
	 * @param start a reference to a specific line in the field, first line being 1; if null returns all found lines.
	 * @param end a reference to a specific line in the field, first line being 1; if null returns all found lines.
	 * @param offset an optional component number used as offset when counting lines
	 * @return found line content or null
	 */
	protected String getLine(final Field cp, final Integer start, final Integer end, final int offset) {
		final String hash = UUID.randomUUID().toString();
		for (int i=1; i<=componentsSize(); i++) {
			if (i < offset) {
				/*
				 * blank fields below the offset
				 */
				cp.setComponent(i, null);
			} else if (getComponent(i) == null) {
				/*
				 * fill empty components above offset
				 */
				cp.setComponent(i, hash);
			}
		}

		/*
		 * get all meaningful lines from value
		 */
		final List<String> lines = new ArrayList<>();
		for (final String l : SwiftParseUtils.getLines(cp.getValue())) {
			if (StringUtils.isNotEmpty(l) && !onlySlashes(l)) {
				lines.add(l);
			}
		}

		/*
		 * if the query includes a component offset above 1, we remove meaningless prefix separators from result.
		 */
		boolean removeSeparators = offset > 1;
		if (start != null) {
			if (lines.size() >= start) {
				if (end != null) {
					if (end >= start) {
						Integer trimmedEnd = end;
						if (end > lines.size()) {
							trimmedEnd = lines.size() - 1;
						}
						/*
						 * return line subset
						 */
						return asString(hash, lines.subList(start - 1, trimmedEnd), removeSeparators);
					} else {
						log.warning("invalid lines range [" + start + "-" + end
								+ "] the ending line number (" + end + ") must be greater or equal to the starting line number (" + start + ")");
					}
				} else {
					/*
					 * return a single line
					 */
					return clean(hash, lines.get(start - 1), removeSeparators);
				}
			}
		} else {
			/*
			 * return all lines from offset
			 */
			return asString(hash, lines, removeSeparators);
		}
		return null;
	}

	/**
	 * Returns true if the value only contains '/' characters
	 * (one or many but only that character)
	 */
	private boolean onlySlashes(final String value) {
		for (int i = 0; i < value.length(); i++) {
			if (value.charAt(i) != '/') {
				return false;
			}
		}
		return true;
	}

	/**
	 * Creates a string from the list of lines, replacing the hash by blank, and ignoring empty lines
	 * @param hash hash used during getLine process
	 * @param list list of lines
	 * @param removeSeparators true to remove meaningless prefix separators, 
	 * @return a string with the final, cleaned, joined lines
	 */
	private String asString(final String hash, final List<String> list, boolean removeSeparators) {
		final StringBuilder result = new StringBuilder();
		for (int i=0; i<list.size(); i++) {
			final String l = list.get(i);
			boolean b = i==0? removeSeparators : false; //remove prefix only for first line
			final String trimmed = clean(hash, l, b);	
			if (trimmed != null) {
				if (result.length() > 0) {
					result.append(FINWriterVisitor.SWIFT_EOL);
				}
				result.append(trimmed);
			}
		}
		if (result.length() == 0) {
			return null;
		} else {
			return result.toString();
		}
	}

	/**
	 * Replaces the hash by empty and trims to null.<br>
	 *
	 * It also can remove meaningless component separators (If the resulting string only
	 * contains the component separator "/", or starts with ":" or starts with "/" separators
	 * all of them will also be removed).
	 *
	 * @param hash hash string used by the get lines method
	 * @param value current value to clean
	 * @param removeSeparators if true, meaningless starting separators (: and /) are removed
	 * @return proper final line value or null if the original field didn't contained content for such line
	 */
	private String clean(final String hash, final String value, boolean removeSeparators) {
		/*
		 * try to replace /hash first just in case the component is optional
		 * then replace the hash only if present
		 */
		String trimmed = StringUtils.trimToNull(StringUtils.replace(StringUtils.replace(value, "/" + hash, ""), hash, ""));
		if (trimmed != null && !onlySlashes(trimmed)) {
			/*
			 * sebastian Oct 2015
			 * La logica para remover separadores debiera depender de si el offset
			 * abarca la linea entera o si el componente del offset esta en al mitad 
			 * de una linea, y removerlo solo en este ultimo caso.
			 * Esto es dificil de implementar porque no esta modelada la relacion
			 * entre componentes y lineas.
			 * Por lo tanto de momento se deja el parametro removeSeparators pero
			 * con el codigo de aca abajo comentado. Y se coloca a cambio el patch
			 * para el caso especifico de :// que es el que aparentemente no esta
			 * contemplado segun los test.
			 * 
			if (removeSeparators) {
				for (int i = 0; i < trimmed.length(); i++) {
					char c = trimmed.charAt(i);
					if (c != ':' && c != '/') {
						return trimmed.substring(i);
					}
				}
			} else {
				return trimmed;
			}
			*/
			if (trimmed.startsWith("://")) {
				return StringUtils.substringAfter(trimmed, "://");
			} else if (removeSeparators && (trimmed.startsWith(":") || trimmed.startsWith("/"))) {
				return StringUtils.trimToNull(StringUtils.substring(trimmed, 1));
			} else {
				return trimmed;
			}
		}
		/*
		 * otherwise return null
		 */
		return null;
	}

	/**
	 * Returns true if the field name is valid. 
	 * Valid field names are for example: 20, 20C, 108
	 * @param name a field name to validate
	 * @return true if valid, false otherwise
	 * @since 7.8
	 */
	public static boolean validName(final String name) {
		if (name == null) {
			return false;
		}
		if (name.length() < 2 || name.length() > 3) {
			//log.warning("field name must be present and have 2 or 3 characters length and found: "+field);
			return false;
		}
		if (!StringUtils.isNumeric(name.substring(0, 2))) {
			//log.warning("field name should start with a numeric prefix and found: "+field.substring(0, 2));
			return false;
		}
		if ((name.length() == 3 && !(Character.isDigit(name.charAt(2)) || name.charAt(2) == 'a' || Character.isUpperCase(name.charAt(2))))) {
			//log.warning("letter option if present should be a single capital letter or an 'a' for all letter options, and found: "+field.charAt(2));
			return false;
		}
		return true;
	}
	
	/**
	 * Returns english label for components.
	 * <br>
	 * The index in the list is in sync with specific field component structure.
	 * @see #getComponentLabel(int)
	 * @since 7.8.4
	 */
	protected abstract List<String> getComponentLabels();

	/**
	 * Returns english label for the component.
	 * <br>
	 * @param number one-based index of component, first component of a field should be number one
	 * @return found label or null if it is not defined
	 * @since 7.8.4
	 */
	public String getComponentLabel(final int number) {
		//internal position index is zero based
		final int position = number - 1;
		final List<String> labels = getComponentLabels();
		if (labels != null) {
			if ((position >= 0) && (position < labels.size())) {
				return labels.get(position);
			}
		}
		return null;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	protected abstract Map<Integer, String> getComponentMap();

	/**
	 * Returns english label for the component in camel case format.
	 * <br>
	 * @param number one-based index of component, first component of a field should be number one
	 * @return found label or <code>null</code> if it is not defined
	 * @since 7.10.3
	 */
	private String getComponentLabelCamelCase(final int number) {
		final Map<Integer, String> labels = getComponentMap();
		if (labels != null) {
			if (number >= 0) {
				return labels.get(number);
			}
		}
		return null;
	}

	/**
	 * Ensures a not-null locale parameter.
	 * @param locale a locale or null
	 * @return the parameter locale if it is not null or the default locale
	 * @since 7.8.8
	 */
	protected final Locale notNull(final Locale locale) {
		if (locale != null) {
			return locale;
		} else {
			return Locale.getDefault();
		}
	}
	

	/**
	 * Appends a not null field component to the builder.
	 * <br>
	 * This helper method is used by subclasses implementation of {@link #getValue()}
	 * 
	 * @param result string where component content is appended
	 * @param component component number
	 * @since 7.9.3
	 */
	protected void append(StringBuilder result, int component) {
		final String value = getComponent(component);
		if (value != null && result != null) {
			result.append(value);
		}
	}
	
	/*
	 * TO DO: 
	 * this will take the result of getLabelComponents
	 * and use that as key to access bundle with translations.
	 * For example Name And Address will be name-and-address key
	 * in resource bundle
	 */
	//public abstract List<String> getComponentLabels(Locale locale);
	//public String getComponentLabel(Locale locale);

	/**
	 * Get a json representation of this message with expanded fields content.
	 * <p>
	 * The JSON representation for fields contains the field name and the components with camel case labels, for example:
	 * <pre>{"name":"32A","date":"010203","currency":"USD","amount":"123"}</pre>
	 *
	 * @since 7.10.3
	 */
	@Override
	public String toJson() {
		JsonObject field = new JsonObject();
		field.addProperty("name", this.getName());
		for (int i=1; i<=this.getComponents().size(); i++){
			if (this.getComponent(i) != null) {
				String label = this.getComponentLabelCamelCase(i);
				if (label == null) {
					label = "value";
				}
				field.addProperty(label, this.getComponent(i));
			}
		}
		return field.toString();
	}

	/**
	 * Creates a specific field instance from its JSON representation.
	 *
	 * <p>The implementation reads the "name" property in the JSON data, then calls the fromJson method in the specific
	 * Field subclass
	 *
	 * @return a specific field, for example Field32A, or null if the JSON data is not well-formed or contains an unrecognized field name
	 * @see #toJson()
	 */
	public static Field fromJson(final String json) {
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		JsonElement nameElement = jsonObject.get("name");
		if (nameElement != null) {
			String name = nameElement.getAsString();
			Object r = null;
			try {
				final Class<?> c = Class.forName("com.prowidesoftware.swift.model.field.Field" + name);
				Method method = c.getMethod("fromJson", String.class);
				return (Field) method.invoke(null, json);
			} catch (final ClassNotFoundException e) {
				log.warning("Field class for Field" + name + " not found. This is normally caused by an unrecognized field in the message or a malformed message block structure.");
			} catch (final Exception e) {
				log.log(Level.WARNING, "An error occured while creating an instance of " + name, e);
			}
			return (Field) r;
		}
		return null;
	}

}