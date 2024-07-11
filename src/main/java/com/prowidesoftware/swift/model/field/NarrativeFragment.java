/*
 * Copyright 2006-2023 Prowide
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

/**
 * Simple POJO for a fragment in a StructuredNarrative.
 *
 * <p>This model contains the narrative text, the line index (1 based) and the line length.
 *
 * <p>It is used by the {@link StructuredNarrative} class to get additional information of each line in the narrative.
 *
 * @since 9.4.16
 */
public class NarrativeFragment {
    private final String text;
    private final int lineIndex;
    private final int lineLength;

    /**
     * Creates a new fragment without line index or length.
     *
     * @param text narrative line text
     */
    public NarrativeFragment(final String text) {
        this(text, 0, 0);
    }

    /**
     * Creates a new fragment.
     *
     * @param text narrative line text
     * @param lineIndex complete narrative line index
     * @param lineLength complete line length
     */
    public NarrativeFragment(final String text, final int lineIndex, final int lineLength) {
        this.text = text;
        this.lineIndex = lineIndex;
        this.lineLength = lineLength;
    }

    public String getText() {
        return text;
    }

    /**
     * This is the 1-based index of the line in the complete narrative. Thus, regardless of the codeword position and
     * on the number of line continuations, this index reflects this particular fragment position in the original
     * field value before parsing. And it can be used for example to know if the fragment was located in the first
     * line of the field value.
     *
     * @return 1-based index of the line this fragment belongs to, in the complete field value
     */
    public int getLineIndex() {
        return lineIndex;
    }

    /**
     * This is the length of the complete line in the original field value before parsing. Thus, this number could
     * contain for example the length of the codeword and slash separators before the actual narrative fragment, or
     * when it is not the first fragment for a given codeword this could contain the length of the double slash used
     * as continuation indicator. All in all, this value will be at least the size of the fragment, and in most cases
     * it will be more. The purpose of this value is to provide a hint of the original line length, which could be used
     * when reassembling the complete narrative for a codeword.
     *
     * @return the length of the complete line in the original field value before parsing
     */
    public int getLineLength() {
        return lineLength;
    }

    @Override
    public String toString() {
        return text;
    }
}
