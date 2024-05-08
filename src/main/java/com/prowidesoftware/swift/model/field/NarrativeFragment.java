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
    private String text;
    private int lineIndex;
    private int lineLength;

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

    public int getLineIndex() {
        return lineIndex;
    }

    public int getLineLength() {
        return lineLength;
    }

    public String toString() {
        return text;
    }
}
