/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
 package com.prowidesoftware.swift.model.mt.mt5xx;

import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.internal.*;
import com.prowidesoftware.swift.internal.SequenceStyle.Type;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * MT 564<br />
 * Corporate Action Notification<br />
 <h1>MT564 Format</h1>
 <pre>
 <div class="mainsequence">
<em>Main Sequence main</em><br/>
<div class="sequence">
<em>Sequence A</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 28</em>
Letter options: E<br/></div><div class="fieldset">
<em>Fieldset 20</em><br/>
<blockquote><ul><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it><it><em>FieldsetItem 20 C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 23</em>
Letter options: G<br/></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 98</em>
Letter options: A,C<br/></div><div class="field"><em>Field 25</em>
Letter options: D<br/></div><div class="sequence">
<em>Sequence A1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="field"><em>Field 13</em>
Letter options: A,B<br/></div><div class="field"><em>Field 20</em>
Letter options: C<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence B</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="sequence">
<em>Sequence B1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 94</em>
Letter options: B<br/></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="fieldset">
<em>Fieldset 12</em><br/>
<blockquote><ul><it><em>FieldsetItem 12 A,C</em><br/>
</it><it><em>FieldsetItem 12 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 11</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 D</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 36</em><br/>
<blockquote><ul><it><em>FieldsetItem 36 B</em><br/>
</it><it><em>FieldsetItem 36 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence B2</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 95</em>
Letter options: P,R<br/></div><div class="field"><em>Field 97</em>
Letter options: A,C<br/></div><div class="field"><em>Field 94</em>
Letter options: B,C,F<br/></div><div class="fieldset">
<em>Fieldset 93</em><br/>
<blockquote><ul><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it><it><em>FieldsetItem 93 B,C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence C</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="field"><em>Field 36</em>
Letter options: B,E<br/></div><div class="fieldset">
<em>Fieldset 93</em><br/>
<blockquote><ul></ul></blockquote></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 92</em>
Letter options: D<br/></div><div class="field"><em>Field 90</em>
Letter options: B<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,B</em><br/>
</it><it><em>FieldsetItem 98 A,B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 69</em>
Letter options: A,B,C,D,E,F<br/></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence D</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B</em><br/>
</it><it><em>FieldsetItem 98 A,B</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 69</em><br/>
<blockquote><ul><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 99</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K,P</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,F</em><br/>
</it><it><em>FieldsetItem 92 A,F</em><br/>
</it><it><em>FieldsetItem 92 A,F</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 90</em><br/>
<blockquote><ul><it><em>FieldsetItem 90 A,B,E,L</em><br/>
</it><it><em>FieldsetItem 90 A,B,E,L</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 36</em><br/>
<blockquote><ul><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 13</em>
Letter options: A,B<br/></div><div class="fieldset">
<em>Fieldset 17</em><br/>
<blockquote><ul><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 94</em><br/>
<blockquote><ul><it><em>FieldsetItem 94 E</em><br/>
</it><it><em>FieldsetItem 94 E</em><br/>
</it><it><em>FieldsetItem 94 E</em><br/>
</it><it><em>FieldsetItem 94 E</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 70</em><br/>
<blockquote><ul><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E,G</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence E</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 13</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 94</em><br/>
<blockquote><ul><it><em>FieldsetItem 94 C</em><br/>
</it><it><em>FieldsetItem 94 C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 11</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 17</em><br/>
<blockquote><ul><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it><it><em>FieldsetItem 17 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E,F</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E,J,K</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 69</em><br/>
<blockquote><ul><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it><it><em>FieldsetItem 69 A,B,C,D,E,F,J</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 F,H,J,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K,R</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,J,K</em><br/>
</it><it><em>FieldsetItem 92 F,J,K</em><br/>
</it><it><em>FieldsetItem 92 F,H,J,K</em><br/>
</it><it><em>FieldsetItem 92 B</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K,R</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 90</em><br/>
<blockquote><ul><it><em>FieldsetItem 90 A,B,E</em><br/>
</it><it><em>FieldsetItem 90 A,B,E</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 36</em><br/>
<blockquote><ul><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it><it><em>FieldsetItem 36 B,C</em><br/>
</it></ul></blockquote></div><div class="sequence">
<em>Sequence E1</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 H</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 H</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 35</em>
Letter options: B<br/></div><div class="sequence">
<em>Sequence E1a</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="field"><em>Field 94</em>
Letter options: B<br/></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="fieldset">
<em>Fieldset 12</em><br/>
<blockquote><ul><it><em>FieldsetItem 12 A,C</em><br/>
</it><it><em>FieldsetItem 12 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 11</em>
Letter options: A<br/></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it><it><em>FieldsetItem 98 A</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 90</em>
Letter options: A,B,E<br/></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 36</em><br/>
<blockquote><ul><it><em>FieldsetItem 36 B</em><br/>
</it><it><em>FieldsetItem 36 B</em><br/>
</it><it><em>FieldsetItem 36 B</em><br/>
</it><it><em>FieldsetItem 36 B</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="field"><em>Field 36</em>
Letter options: B<br/></div><div class="fieldset">
<em>Fieldset 94</em><br/>
<blockquote><ul><it><em>FieldsetItem 94 B,C,F</em><br/>
</it><it><em>FieldsetItem 94 C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 22</em>
Letter options: F<br/></div><div class="field"><em>Field 11</em>
Letter options: A<br/></div><div class="field"><em>Field 69</em>
Letter options: A,B,C,D,E,F,J<br/></div><div class="fieldset">
<em>Fieldset 90</em><br/>
<blockquote><ul><it><em>FieldsetItem 90 A,B,E</em><br/>
</it><it><em>FieldsetItem 90 A,B,E</em><br/>
</it><it><em>FieldsetItem 90 A,B,E,F,J,L</em><br/>
</it><it><em>FieldsetItem 90 A,B,E,K</em><br/>
</it><it><em>FieldsetItem 90 B,E</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 D,K,L</em><br/>
</it><it><em>FieldsetItem 92 D,K,L,M,N</em><br/>
</it><it><em>FieldsetItem 92 D,K,L</em><br/>
</it><it><em>FieldsetItem 92 A</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,J,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence E2</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 22</em><br/>
<blockquote><ul><it><em>FieldsetItem 22 H</em><br/>
</it><it><em>FieldsetItem 22 H</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it><it><em>FieldsetItem 22 F</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 94</em>
Letter options: C<br/></div><div class="field"><em>Field 97</em>
Letter options: A,E<br/></div><div class="fieldset">
<em>Fieldset 19</em><br/>
<blockquote><ul><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it><it><em>FieldsetItem 19 B</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 98</em><br/>
<blockquote><ul><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it><it><em>FieldsetItem 98 A,B,C,E</em><br/>
</it><it><em>FieldsetItem 98 A,B,C</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 92</em><br/>
<blockquote><ul><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 F,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K,M</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 F,H,J,K</em><br/>
</it><it><em>FieldsetItem 92 B</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,J,K</em><br/>
</it><it><em>FieldsetItem 92 F,H,J,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K,M</em><br/>
</it><it><em>FieldsetItem 92 A,F,J,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K,R</em><br/>
</it><it><em>FieldsetItem 92 A,F,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,K</em><br/>
</it><it><em>FieldsetItem 92 A,F,K,R</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 90</em><br/>
<blockquote><ul><it><em>FieldsetItem 90 A,B,E,F,J,L</em><br/>
</it><it><em>FieldsetItem 90 A,B,E,K</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="fieldset">
<em>Fieldset 70</em><br/>
<blockquote><ul><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
<div class="sequence">
<em>Sequence F</em><br/>
<div class="field"><em>Field 16</em>
Letter options: R<br/></div><div class="fieldset">
<em>Fieldset 70</em><br/>
<blockquote><ul><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it><it><em>FieldsetItem 70 E</em><br/>
</it></ul></blockquote></div><div class="fieldset">
<em>Fieldset 95</em><br/>
<blockquote><ul><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it><it><em>FieldsetItem 95 P,Q,R</em><br/>
</it></ul></blockquote></div><div class="field"><em>Field 16</em>
Letter options: S<br/></div></blockquote>
</div>

 </pre>
 * <em>This source code is specific to release SRU 2016</em><br /> 
 *
 *		 
 *
 * @author www.prowidesoftware.com
 */
@Generated
public class MT564 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;
	private static final long serialVersionUID = 1L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT564.class.getName());
	
	/**
	* Constant for MT name, this is part of the classname, after <code>MT</code>
	*/
	public static final String NAME = "564";
	
// begin qualifiers constants	

	/**
	* Constant for qualifier with value ACCTINFO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACCTINFO
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACCTINFO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ACCTINFO = "ACCTINFO";

	/**
	* Constant for qualifier with value ACIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACIN
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ACIN = "ACIN";

	/**
	* Constant for qualifier with value ACOW 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACOW
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACOW
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ACOW = "ACOW";

	/**
	* Constant for qualifier with value ACRU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ACRU
	* @see com.prowidesoftware.swift.SchemeConstantsA#ACRU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ACRU = "ACRU";

	/**
	* Constant for qualifier with value ADDB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ADDB
	* @see com.prowidesoftware.swift.SchemeConstantsA#ADDB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ADDB = "ADDB";

	/**
	* Constant for qualifier with value ADDINFO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ADDINFO
	* @see com.prowidesoftware.swift.SchemeConstantsA#ADDINFO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ADDINFO = "ADDINFO";

	/**
	* Constant for qualifier with value ADEX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ADEX
	* @see com.prowidesoftware.swift.SchemeConstantsA#ADEX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ADEX = "ADEX";

	/**
	* Constant for qualifier with value ADSR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ADSR
	* @see com.prowidesoftware.swift.SchemeConstantsA#ADSR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ADSR = "ADSR";

	/**
	* Constant for qualifier with value ADTX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ADTX
	* @see com.prowidesoftware.swift.SchemeConstantsA#ADTX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ADTX = "ADTX";

	/**
	* Constant for qualifier with value AFFB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AFFB
	* @see com.prowidesoftware.swift.SchemeConstantsA#AFFB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AFFB = "AFFB";

	/**
	* Constant for qualifier with value ANOU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ANOU
	* @see com.prowidesoftware.swift.SchemeConstantsA#ANOU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ANOU = "ANOU";

	/**
	* Constant for qualifier with value APLI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.APLI
	* @see com.prowidesoftware.swift.SchemeConstantsA#APLI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String APLI = "APLI";

	/**
	* Constant for qualifier with value AREV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AREV
	* @see com.prowidesoftware.swift.SchemeConstantsA#AREV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AREV = "AREV";

	/**
	* Constant for qualifier with value ATAX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.ATAX
	* @see com.prowidesoftware.swift.SchemeConstantsA#ATAX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ATAX = "ATAX";

	/**
	* Constant for qualifier with value AVAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsA.AVAL
	* @see com.prowidesoftware.swift.SchemeConstantsA#AVAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String AVAL = "AVAL";

	/**
	* Constant for qualifier with value BAIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BAIN
	* @see com.prowidesoftware.swift.SchemeConstantsB#BAIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BAIN = "BAIN";

	/**
	* Constant for qualifier with value BASE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BASE
	* @see com.prowidesoftware.swift.SchemeConstantsB#BASE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BASE = "BASE";

	/**
	* Constant for qualifier with value BIDI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BIDI
	* @see com.prowidesoftware.swift.SchemeConstantsB#BIDI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BIDI = "BIDI";

	/**
	* Constant for qualifier with value BLOK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BLOK
	* @see com.prowidesoftware.swift.SchemeConstantsB#BLOK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BLOK = "BLOK";

	/**
	* Constant for qualifier with value BOCL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BOCL
	* @see com.prowidesoftware.swift.SchemeConstantsB#BOCL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BOCL = "BOCL";

	/**
	* Constant for qualifier with value BOLQ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BOLQ
	* @see com.prowidesoftware.swift.SchemeConstantsB#BOLQ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BOLQ = "BOLQ";

	/**
	* Constant for qualifier with value BORD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BORD
	* @see com.prowidesoftware.swift.SchemeConstantsB#BORD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BORD = "BORD";

	/**
	* Constant for qualifier with value BORR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BORR
	* @see com.prowidesoftware.swift.SchemeConstantsB#BORR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BORR = "BORR";

	/**
	* Constant for qualifier with value BWIT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsB.BWIT
	* @see com.prowidesoftware.swift.SchemeConstantsB#BWIT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String BWIT = "BWIT";

	/**
	* Constant for qualifier with value CACN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CACN
	* @see com.prowidesoftware.swift.SchemeConstantsC#CACN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CACN = "CACN";

	/**
	* Constant for qualifier with value CADETL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CADETL
	* @see com.prowidesoftware.swift.SchemeConstantsC#CADETL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CADETL = "CADETL";

	/**
	* Constant for qualifier with value CAEP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CAEP
	* @see com.prowidesoftware.swift.SchemeConstantsC#CAEP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CAEP = "CAEP";

	/**
	* Constant for qualifier with value CAEV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CAEV
	* @see com.prowidesoftware.swift.SchemeConstantsC#CAEV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CAEV = "CAEV";

	/**
	* Constant for qualifier with value CALD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CALD
	* @see com.prowidesoftware.swift.SchemeConstantsC#CALD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CALD = "CALD";

	/**
	* Constant for qualifier with value CAMV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CAMV
	* @see com.prowidesoftware.swift.SchemeConstantsC#CAMV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CAMV = "CAMV";

	/**
	* Constant for qualifier with value CANC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CANC
	* @see com.prowidesoftware.swift.SchemeConstantsC#CANC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CANC = "CANC";

	/**
	* Constant for qualifier with value CAON 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CAON
	* @see com.prowidesoftware.swift.SchemeConstantsC#CAON
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CAON = "CAON";

	/**
	* Constant for qualifier with value CAOP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CAOP
	* @see com.prowidesoftware.swift.SchemeConstantsC#CAOP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CAOP = "CAOP";

	/**
	* Constant for qualifier with value CAOPTN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CAOPTN
	* @see com.prowidesoftware.swift.SchemeConstantsC#CAOPTN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CAOPTN = "CAOPTN";

	/**
	* Constant for qualifier with value CAPG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CAPG
	* @see com.prowidesoftware.swift.SchemeConstantsC#CAPG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CAPG = "CAPG";

	/**
	* Constant for qualifier with value CASH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CASH
	* @see com.prowidesoftware.swift.SchemeConstantsC#CASH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CASH = "CASH";

	/**
	* Constant for qualifier with value CASHMOVE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CASHMOVE
	* @see com.prowidesoftware.swift.SchemeConstantsC#CASHMOVE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CASHMOVE = "CASHMOVE";

	/**
	* Constant for qualifier with value CAVA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CAVA
	* @see com.prowidesoftware.swift.SchemeConstantsC#CAVA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CAVA = "CAVA";

	/**
	* Constant for qualifier with value CEFI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CEFI
	* @see com.prowidesoftware.swift.SchemeConstantsC#CEFI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CEFI = "CEFI";

	/**
	* Constant for qualifier with value CERT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CERT
	* @see com.prowidesoftware.swift.SchemeConstantsC#CERT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CERT = "CERT";

	/**
	* Constant for qualifier with value CETI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CETI
	* @see com.prowidesoftware.swift.SchemeConstantsC#CETI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CETI = "CETI";

	/**
	* Constant for qualifier with value CHAN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CHAN
	* @see com.prowidesoftware.swift.SchemeConstantsC#CHAN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CHAN = "CHAN";

	/**
	* Constant for qualifier with value CHAR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CHAR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CHAR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CHAR = "CHAR";

	/**
	* Constant for qualifier with value CINL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CINL
	* @see com.prowidesoftware.swift.SchemeConstantsC#CINL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CINL = "CINL";

	/**
	* Constant for qualifier with value CLAS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLAS
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLAS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLAS = "CLAS";

	/**
	* Constant for qualifier with value CLCP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CLCP
	* @see com.prowidesoftware.swift.SchemeConstantsC#CLCP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CLCP = "CLCP";

	/**
	* Constant for qualifier with value COAF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COAF
	* @see com.prowidesoftware.swift.SchemeConstantsC#COAF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COAF = "COAF";

	/**
	* Constant for qualifier with value COAP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COAP
	* @see com.prowidesoftware.swift.SchemeConstantsC#COAP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COAP = "COAP";

	/**
	* Constant for qualifier with value CODO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CODO
	* @see com.prowidesoftware.swift.SchemeConstantsC#CODO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CODO = "CODO";

	/**
	* Constant for qualifier with value CODS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CODS
	* @see com.prowidesoftware.swift.SchemeConstantsC#CODS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CODS = "CODS";

	/**
	* Constant for qualifier with value CODU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CODU
	* @see com.prowidesoftware.swift.SchemeConstantsC#CODU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CODU = "CODU";

	/**
	* Constant for qualifier with value COIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COIN
	* @see com.prowidesoftware.swift.SchemeConstantsC#COIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COIN = "COIN";

	/**
	* Constant for qualifier with value COLI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLI
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLI = "COLI";

	/**
	* Constant for qualifier with value COLO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COLO
	* @see com.prowidesoftware.swift.SchemeConstantsC#COLO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COLO = "COLO";

	/**
	* Constant for qualifier with value COMP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COMP
	* @see com.prowidesoftware.swift.SchemeConstantsC#COMP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COMP = "COMP";

	/**
	* Constant for qualifier with value CONS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CONS
	* @see com.prowidesoftware.swift.SchemeConstantsC#CONS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CONS = "CONS";

	/**
	* Constant for qualifier with value CONT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CONT
	* @see com.prowidesoftware.swift.SchemeConstantsC#CONT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CONT = "CONT";

	/**
	* Constant for qualifier with value CONV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CONV
	* @see com.prowidesoftware.swift.SchemeConstantsC#CONV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CONV = "CONV";

	/**
	* Constant for qualifier with value COPY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COPY
	* @see com.prowidesoftware.swift.SchemeConstantsC#COPY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COPY = "COPY";

	/**
	* Constant for qualifier with value CORP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CORP
	* @see com.prowidesoftware.swift.SchemeConstantsC#CORP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CORP = "CORP";

	/**
	* Constant for qualifier with value COUP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.COUP
	* @see com.prowidesoftware.swift.SchemeConstantsC#COUP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String COUP = "COUP";

	/**
	* Constant for qualifier with value CRDB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CRDB
	* @see com.prowidesoftware.swift.SchemeConstantsC#CRDB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CRDB = "CRDB";

	/**
	* Constant for qualifier with value CSPD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CSPD
	* @see com.prowidesoftware.swift.SchemeConstantsC#CSPD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CSPD = "CSPD";

	/**
	* Constant for qualifier with value CVPR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsC.CVPR
	* @see com.prowidesoftware.swift.SchemeConstantsC#CVPR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String CVPR = "CVPR";

	/**
	* Constant for qualifier with value DAAC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DAAC
	* @see com.prowidesoftware.swift.SchemeConstantsD#DAAC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DAAC = "DAAC";

	/**
	* Constant for qualifier with value DDTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DDTE
	* @see com.prowidesoftware.swift.SchemeConstantsD#DDTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DDTE = "DDTE";

	/**
	* Constant for qualifier with value DECL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DECL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DECL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DECL = "DECL";

	/**
	* Constant for qualifier with value DENO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DENO
	* @see com.prowidesoftware.swift.SchemeConstantsD#DENO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DENO = "DENO";

	/**
	* Constant for qualifier with value DEVI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DEVI
	* @see com.prowidesoftware.swift.SchemeConstantsD#DEVI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DEVI = "DEVI";

	/**
	* Constant for qualifier with value DFLT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DFLT
	* @see com.prowidesoftware.swift.SchemeConstantsD#DFLT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DFLT = "DFLT";

	/**
	* Constant for qualifier with value DISC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DISC
	* @see com.prowidesoftware.swift.SchemeConstantsD#DISC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DISC = "DISC";

	/**
	* Constant for qualifier with value DISF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DISF
	* @see com.prowidesoftware.swift.SchemeConstantsD#DISF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DISF = "DISF";

	/**
	* Constant for qualifier with value DITY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DITY
	* @see com.prowidesoftware.swift.SchemeConstantsD#DITY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DITY = "DITY";

	/**
	* Constant for qualifier with value DIVI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DIVI
	* @see com.prowidesoftware.swift.SchemeConstantsD#DIVI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DIVI = "DIVI";

	/**
	* Constant for qualifier with value DIVR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DIVR
	* @see com.prowidesoftware.swift.SchemeConstantsD#DIVR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DIVR = "DIVR";

	/**
	* Constant for qualifier with value DOMI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DOMI
	* @see com.prowidesoftware.swift.SchemeConstantsD#DOMI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DOMI = "DOMI";

	/**
	* Constant for qualifier with value DROP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DROP
	* @see com.prowidesoftware.swift.SchemeConstantsD#DROP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DROP = "DROP";

	/**
	* Constant for qualifier with value DSBT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSBT
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSBT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSBT = "DSBT";

	/**
	* Constant for qualifier with value DSDA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSDA
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSDA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSDA = "DSDA";

	/**
	* Constant for qualifier with value DSDE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSDE
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSDE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSDE = "DSDE";

	/**
	* Constant for qualifier with value DSPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSPL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSPL = "DSPL";

	/**
	* Constant for qualifier with value DSSE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSSE
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSSE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSSE = "DSSE";

	/**
	* Constant for qualifier with value DSWA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSWA
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSWA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSWA = "DSWA";

	/**
	* Constant for qualifier with value DSWN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSWN
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSWN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSWN = "DSWN";

	/**
	* Constant for qualifier with value DSWO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSWO
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSWO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSWO = "DSWO";

	/**
	* Constant for qualifier with value DSWS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DSWS
	* @see com.prowidesoftware.swift.SchemeConstantsD#DSWS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DSWS = "DSWS";

	/**
	* Constant for qualifier with value DUPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DUPL
	* @see com.prowidesoftware.swift.SchemeConstantsD#DUPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DUPL = "DUPL";

	/**
	* Constant for qualifier with value DVCP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsD.DVCP
	* @see com.prowidesoftware.swift.SchemeConstantsD#DVCP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String DVCP = "DVCP";

	/**
	* Constant for qualifier with value EARD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EARD
	* @see com.prowidesoftware.swift.SchemeConstantsE#EARD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EARD = "EARD";

	/**
	* Constant for qualifier with value EARL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EARL
	* @see com.prowidesoftware.swift.SchemeConstantsE#EARL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EARL = "EARL";

	/**
	* Constant for qualifier with value ECDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ECDT
	* @see com.prowidesoftware.swift.SchemeConstantsE#ECDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ECDT = "ECDT";

	/**
	* Constant for qualifier with value ECIO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ECIO
	* @see com.prowidesoftware.swift.SchemeConstantsE#ECIO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ECIO = "ECIO";

	/**
	* Constant for qualifier with value ECPD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ECPD
	* @see com.prowidesoftware.swift.SchemeConstantsE#ECPD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ECPD = "ECPD";

	/**
	* Constant for qualifier with value ECRD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ECRD
	* @see com.prowidesoftware.swift.SchemeConstantsE#ECRD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ECRD = "ECRD";

	/**
	* Constant for qualifier with value EFFD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EFFD
	* @see com.prowidesoftware.swift.SchemeConstantsE#EFFD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EFFD = "EFFD";

	/**
	* Constant for qualifier with value ELCT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ELCT
	* @see com.prowidesoftware.swift.SchemeConstantsE#ELCT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ELCT = "ELCT";

	/**
	* Constant for qualifier with value ELIG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ELIG
	* @see com.prowidesoftware.swift.SchemeConstantsE#ELIG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ELIG = "ELIG";

	/**
	* Constant for qualifier with value ENTL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ENTL
	* @see com.prowidesoftware.swift.SchemeConstantsE#ENTL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ENTL = "ENTL";

	/**
	* Constant for qualifier with value EQUL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EQUL
	* @see com.prowidesoftware.swift.SchemeConstantsE#EQUL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EQUL = "EQUL";

	/**
	* Constant for qualifier with value ESOF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ESOF
	* @see com.prowidesoftware.swift.SchemeConstantsE#ESOF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ESOF = "ESOF";

	/**
	* Constant for qualifier with value ESTA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ESTA
	* @see com.prowidesoftware.swift.SchemeConstantsE#ESTA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ESTA = "ESTA";

	/**
	* Constant for qualifier with value ETPD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ETPD
	* @see com.prowidesoftware.swift.SchemeConstantsE#ETPD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ETPD = "ETPD";

	/**
	* Constant for qualifier with value ETYP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.ETYP
	* @see com.prowidesoftware.swift.SchemeConstantsE#ETYP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ETYP = "ETYP";

	/**
	* Constant for qualifier with value EUTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EUTR
	* @see com.prowidesoftware.swift.SchemeConstantsE#EUTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EUTR = "EUTR";

	/**
	* Constant for qualifier with value EXCH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXCH
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXCH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXCH = "EXCH";

	/**
	* Constant for qualifier with value EXEC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXEC
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXEC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXEC = "EXEC";

	/**
	* Constant for qualifier with value EXPI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsE.EXPI
	* @see com.prowidesoftware.swift.SchemeConstantsE#EXPI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String EXPI = "EXPI";

	/**
	* Constant for qualifier with value FDAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FDAT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FDAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FDAT = "FDAT";

	/**
	* Constant for qualifier with value FIA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FIA
	* @see com.prowidesoftware.swift.SchemeConstantsF#FIA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FIA = "FIA";

	/**
	* Constant for qualifier with value FILL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FILL
	* @see com.prowidesoftware.swift.SchemeConstantsF#FILL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FILL = "FILL";

	/**
	* Constant for qualifier with value FISC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FISC
	* @see com.prowidesoftware.swift.SchemeConstantsF#FISC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FISC = "FISC";

	/**
	* Constant for qualifier with value FLFR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FLFR
	* @see com.prowidesoftware.swift.SchemeConstantsF#FLFR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FLFR = "FLFR";

	/**
	* Constant for qualifier with value FOLQ 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FOLQ
	* @see com.prowidesoftware.swift.SchemeConstantsF#FOLQ
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FOLQ = "FOLQ";

	/**
	* Constant for qualifier with value FRNR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FRNR
	* @see com.prowidesoftware.swift.SchemeConstantsF#FRNR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FRNR = "FRNR";

	/**
	* Constant for qualifier with value FTCA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FTCA
	* @see com.prowidesoftware.swift.SchemeConstantsF#FTCA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FTCA = "FTCA";

	/**
	* Constant for qualifier with value FXDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsF.FXDT
	* @see com.prowidesoftware.swift.SchemeConstantsF#FXDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String FXDT = "FXDT";

	/**
	* Constant for qualifier with value GENL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GENL
	* @see com.prowidesoftware.swift.SchemeConstantsG#GENL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GENL = "GENL";

	/**
	* Constant for qualifier with value GRSS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GRSS
	* @see com.prowidesoftware.swift.SchemeConstantsG#GRSS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GRSS = "GRSS";

	/**
	* Constant for qualifier with value GUPA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsG.GUPA
	* @see com.prowidesoftware.swift.SchemeConstantsG#GUPA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String GUPA = "GUPA";

	/**
	* Constant for qualifier with value HEAR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsH.HEAR
	* @see com.prowidesoftware.swift.SchemeConstantsH#HEAR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String HEAR = "HEAR";

	/**
	* Constant for qualifier with value IDFX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IDFX
	* @see com.prowidesoftware.swift.SchemeConstantsI#IDFX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String IDFX = "IDFX";

	/**
	* Constant for qualifier with value IFIX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.IFIX
	* @see com.prowidesoftware.swift.SchemeConstantsI#IFIX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String IFIX = "IFIX";

	/**
	* Constant for qualifier with value INBA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INBA
	* @see com.prowidesoftware.swift.SchemeConstantsI#INBA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INBA = "INBA";

	/**
	* Constant for qualifier with value INCE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INCE
	* @see com.prowidesoftware.swift.SchemeConstantsI#INCE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INCE = "INCE";

	/**
	* Constant for qualifier with value INCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INCO
	* @see com.prowidesoftware.swift.SchemeConstantsI#INCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INCO = "INCO";

	/**
	* Constant for qualifier with value INCR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INCR
	* @see com.prowidesoftware.swift.SchemeConstantsI#INCR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INCR = "INCR";

	/**
	* Constant for qualifier with value INDC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INDC
	* @see com.prowidesoftware.swift.SchemeConstantsI#INDC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INDC = "INDC";

	/**
	* Constant for qualifier with value INDM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INDM
	* @see com.prowidesoftware.swift.SchemeConstantsI#INDM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INDM = "INDM";

	/**
	* Constant for qualifier with value INDX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INDX
	* @see com.prowidesoftware.swift.SchemeConstantsI#INDX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INDX = "INDX";

	/**
	* Constant for qualifier with value INFA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INFA
	* @see com.prowidesoftware.swift.SchemeConstantsI#INFA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INFA = "INFA";

	/**
	* Constant for qualifier with value INFO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INFO
	* @see com.prowidesoftware.swift.SchemeConstantsI#INFO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INFO = "INFO";

	/**
	* Constant for qualifier with value INPE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INPE
	* @see com.prowidesoftware.swift.SchemeConstantsI#INPE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INPE = "INPE";

	/**
	* Constant for qualifier with value INTP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INTP
	* @see com.prowidesoftware.swift.SchemeConstantsI#INTP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INTP = "INTP";

	/**
	* Constant for qualifier with value INTR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INTR
	* @see com.prowidesoftware.swift.SchemeConstantsI#INTR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INTR = "INTR";

	/**
	* Constant for qualifier with value INTSEC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.INTSEC
	* @see com.prowidesoftware.swift.SchemeConstantsI#INTSEC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String INTSEC = "INTSEC";

	/**
	* Constant for qualifier with value ISAG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISAG
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISAG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISAG = "ISAG";

	/**
	* Constant for qualifier with value ISSU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ISSU
	* @see com.prowidesoftware.swift.SchemeConstantsI#ISSU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ISSU = "ISSU";

	/**
	* Constant for qualifier with value ITYP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsI.ITYP
	* @see com.prowidesoftware.swift.SchemeConstantsI#ITYP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ITYP = "ITYP";

	/**
	* Constant for qualifier with value LAPD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LAPD
	* @see com.prowidesoftware.swift.SchemeConstantsL#LAPD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LAPD = "LAPD";

	/**
	* Constant for qualifier with value LAST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LAST
	* @see com.prowidesoftware.swift.SchemeConstantsL#LAST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LAST = "LAST";

	/**
	* Constant for qualifier with value LEOG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LEOG
	* @see com.prowidesoftware.swift.SchemeConstantsL#LEOG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LEOG = "LEOG";

	/**
	* Constant for qualifier with value LINK 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LINK
	* @see com.prowidesoftware.swift.SchemeConstantsL#LINK
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LINK = "LINK";

	/**
	* Constant for qualifier with value LOAN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOAN
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOAN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOAN = "LOAN";

	/**
	* Constant for qualifier with value LOCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOCO
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOCO = "LOCO";

	/**
	* Constant for qualifier with value LOTO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LOTO
	* @see com.prowidesoftware.swift.SchemeConstantsL#LOTO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LOTO = "LOTO";

	/**
	* Constant for qualifier with value LTRD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsL.LTRD
	* @see com.prowidesoftware.swift.SchemeConstantsL#LTRD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String LTRD = "LTRD";

	/**
	* Constant for qualifier with value MAEX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MAEX
	* @see com.prowidesoftware.swift.SchemeConstantsM#MAEX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MAEX = "MAEX";

	/**
	* Constant for qualifier with value MATU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MATU
	* @see com.prowidesoftware.swift.SchemeConstantsM#MATU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MATU = "MATU";

	/**
	* Constant for qualifier with value MAXP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MAXP
	* @see com.prowidesoftware.swift.SchemeConstantsM#MAXP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MAXP = "MAXP";

	/**
	* Constant for qualifier with value MCTD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MCTD
	* @see com.prowidesoftware.swift.SchemeConstantsM#MCTD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MCTD = "MCTD";

	/**
	* Constant for qualifier with value MEE3 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MEE3
	* @see com.prowidesoftware.swift.SchemeConstantsM#MEE3
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MEE3 = "MEE3";

	/**
	* Constant for qualifier with value MEET 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MEET
	* @see com.prowidesoftware.swift.SchemeConstantsM#MEET
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MEET = "MEET";

	/**
	* Constant for qualifier with value MEET2 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MEET2
	* @see com.prowidesoftware.swift.SchemeConstantsM#MEET2
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MEET2 = "MEET2";

	/**
	* Constant for qualifier with value MEOR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MEOR
	* @see com.prowidesoftware.swift.SchemeConstantsM#MEOR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MEOR = "MEOR";

	/**
	* Constant for qualifier with value MERE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MERE
	* @see com.prowidesoftware.swift.SchemeConstantsM#MERE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MERE = "MERE";

	/**
	* Constant for qualifier with value MET2 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MET2
	* @see com.prowidesoftware.swift.SchemeConstantsM#MET2
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MET2 = "MET2";

	/**
	* Constant for qualifier with value MET3 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MET3
	* @see com.prowidesoftware.swift.SchemeConstantsM#MET3
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MET3 = "MET3";

	/**
	* Constant for qualifier with value MFDV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MFDV
	* @see com.prowidesoftware.swift.SchemeConstantsM#MFDV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MFDV = "MFDV";

	/**
	* Constant for qualifier with value MFIX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MFIX
	* @see com.prowidesoftware.swift.SchemeConstantsM#MFIX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MFIX = "MFIX";

	/**
	* Constant for qualifier with value MICO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MICO
	* @see com.prowidesoftware.swift.SchemeConstantsM#MICO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MICO = "MICO";

	/**
	* Constant for qualifier with value MIEX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MIEX
	* @see com.prowidesoftware.swift.SchemeConstantsM#MIEX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MIEX = "MIEX";

	/**
	* Constant for qualifier with value MILT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MILT
	* @see com.prowidesoftware.swift.SchemeConstantsM#MILT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MILT = "MILT";

	/**
	* Constant for qualifier with value MINO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MINO
	* @see com.prowidesoftware.swift.SchemeConstantsM#MINO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MINO = "MINO";

	/**
	* Constant for qualifier with value MINP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MINP
	* @see com.prowidesoftware.swift.SchemeConstantsM#MINP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MINP = "MINP";

	/**
	* Constant for qualifier with value MKDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MKDT
	* @see com.prowidesoftware.swift.SchemeConstantsM#MKDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MKDT = "MKDT";

	/**
	* Constant for qualifier with value MKTC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MKTC
	* @see com.prowidesoftware.swift.SchemeConstantsM#MKTC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MKTC = "MKTC";

	/**
	* Constant for qualifier with value MORE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MORE
	* @see com.prowidesoftware.swift.SchemeConstantsM#MORE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MORE = "MORE";

	/**
	* Constant for qualifier with value MQSO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MQSO
	* @see com.prowidesoftware.swift.SchemeConstantsM#MQSO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MQSO = "MQSO";

	/**
	* Constant for qualifier with value MRKT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsM.MRKT
	* @see com.prowidesoftware.swift.SchemeConstantsM#MRKT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String MRKT = "MRKT";

	/**
	* Constant for qualifier with value NAME 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstants_N._NAME
	* @see com.prowidesoftware.swift.SchemeConstants_N#_NAME
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String _NAME = "NAME";

	/**
	* Constant for qualifier with value NBLT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NBLT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NBLT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NBLT = "NBLT";

	/**
	* Constant for qualifier with value NDOM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NDOM
	* @see com.prowidesoftware.swift.SchemeConstantsN#NDOM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NDOM = "NDOM";

	/**
	* Constant for qualifier with value NELP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NELP
	* @see com.prowidesoftware.swift.SchemeConstantsN#NELP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NELP = "NELP";

	/**
	* Constant for qualifier with value NETT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NETT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NETT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NETT = "NETT";

	/**
	* Constant for qualifier with value NEWD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWD
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NEWD = "NEWD";

	/**
	* Constant for qualifier with value NEWM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWM
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NEWM = "NEWM";

	/**
	* Constant for qualifier with value NEWO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NEWO
	* @see com.prowidesoftware.swift.SchemeConstantsN#NEWO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NEWO = "NEWO";

	/**
	* Constant for qualifier with value NOMI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NOMI
	* @see com.prowidesoftware.swift.SchemeConstantsN#NOMI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NOMI = "NOMI";

	/**
	* Constant for qualifier with value NPLI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NPLI
	* @see com.prowidesoftware.swift.SchemeConstantsN#NPLI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NPLI = "NPLI";

	/**
	* Constant for qualifier with value NRAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NRAT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NRAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NRAT = "NRAT";

	/**
	* Constant for qualifier with value NRES 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NRES
	* @see com.prowidesoftware.swift.SchemeConstantsN#NRES
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NRES = "NRES";

	/**
	* Constant for qualifier with value NSER 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NSER
	* @see com.prowidesoftware.swift.SchemeConstantsN#NSER
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NSER = "NSER";

	/**
	* Constant for qualifier with value NSIS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NSIS
	* @see com.prowidesoftware.swift.SchemeConstantsN#NSIS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NSIS = "NSIS";

	/**
	* Constant for qualifier with value NWFC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NWFC
	* @see com.prowidesoftware.swift.SchemeConstantsN#NWFC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NWFC = "NWFC";

	/**
	* Constant for qualifier with value NXRT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsN.NXRT
	* @see com.prowidesoftware.swift.SchemeConstantsN#NXRT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String NXRT = "NXRT";

	/**
	* Constant for qualifier with value OAPD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OAPD
	* @see com.prowidesoftware.swift.SchemeConstantsO#OAPD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OAPD = "OAPD";

	/**
	* Constant for qualifier with value OBAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OBAL
	* @see com.prowidesoftware.swift.SchemeConstantsO#OBAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OBAL = "OBAL";

	/**
	* Constant for qualifier with value OCMT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OCMT
	* @see com.prowidesoftware.swift.SchemeConstantsO#OCMT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OCMT = "OCMT";

	/**
	* Constant for qualifier with value OFFE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OFFE
	* @see com.prowidesoftware.swift.SchemeConstantsO#OFFE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OFFE = "OFFE";

	/**
	* Constant for qualifier with value OFFO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OFFO
	* @see com.prowidesoftware.swift.SchemeConstantsO#OFFO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OFFO = "OFFO";

	/**
	* Constant for qualifier with value OFFR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OFFR
	* @see com.prowidesoftware.swift.SchemeConstantsO#OFFR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OFFR = "OFFR";

	/**
	* Constant for qualifier with value ONLY 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.ONLY
	* @see com.prowidesoftware.swift.SchemeConstantsO#ONLY
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String ONLY = "ONLY";

	/**
	* Constant for qualifier with value OPST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPST
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OPST = "OPST";

	/**
	* Constant for qualifier with value OPTF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPTF
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPTF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OPTF = "OPTF";

	/**
	* Constant for qualifier with value OPTN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OPTN
	* @see com.prowidesoftware.swift.SchemeConstantsO#OPTN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OPTN = "OPTN";

	/**
	* Constant for qualifier with value OSTA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OSTA
	* @see com.prowidesoftware.swift.SchemeConstantsO#OSTA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OSTA = "OSTA";

	/**
	* Constant for qualifier with value OSUB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OSUB
	* @see com.prowidesoftware.swift.SchemeConstantsO#OSUB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OSUB = "OSUB";

	/**
	* Constant for qualifier with value OVEP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsO.OVEP
	* @see com.prowidesoftware.swift.SchemeConstantsO#OVEP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String OVEP = "OVEP";

	/**
	* Constant for qualifier with value PACO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PACO
	* @see com.prowidesoftware.swift.SchemeConstantsP#PACO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PACO = "PACO";

	/**
	* Constant for qualifier with value PAMM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PAMM
	* @see com.prowidesoftware.swift.SchemeConstantsP#PAMM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PAMM = "PAMM";

	/**
	* Constant for qualifier with value PARL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PARL
	* @see com.prowidesoftware.swift.SchemeConstantsP#PARL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PARL = "PARL";

	/**
	* Constant for qualifier with value PAYA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PAYA
	* @see com.prowidesoftware.swift.SchemeConstantsP#PAYA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PAYA = "PAYA";

	/**
	* Constant for qualifier with value PAYD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PAYD
	* @see com.prowidesoftware.swift.SchemeConstantsP#PAYD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PAYD = "PAYD";

	/**
	* Constant for qualifier with value PEND 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PEND
	* @see com.prowidesoftware.swift.SchemeConstantsP#PEND
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PEND = "PEND";

	/**
	* Constant for qualifier with value PENR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PENR
	* @see com.prowidesoftware.swift.SchemeConstantsP#PENR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PENR = "PENR";

	/**
	* Constant for qualifier with value PLDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PLDT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PLDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PLDT = "PLDT";

	/**
	* Constant for qualifier with value PLIS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PLIS
	* @see com.prowidesoftware.swift.SchemeConstantsP#PLIS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PLIS = "PLIS";

	/**
	* Constant for qualifier with value PODT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PODT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PODT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PODT = "PODT";

	/**
	* Constant for qualifier with value POST 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.POST
	* @see com.prowidesoftware.swift.SchemeConstantsP#POST
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String POST = "POST";

	/**
	* Constant for qualifier with value PPDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PPDT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PPDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PPDT = "PPDT";

	/**
	* Constant for qualifier with value PREP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PREP
	* @see com.prowidesoftware.swift.SchemeConstantsP#PREP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PREP = "PREP";

	/**
	* Constant for qualifier with value PREV 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PREV
	* @see com.prowidesoftware.swift.SchemeConstantsP#PREV
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PREV = "PREV";

	/**
	* Constant for qualifier with value PRFC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRFC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRFC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRFC = "PRFC";

	/**
	* Constant for qualifier with value PRIC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRIC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRIC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRIC = "PRIC";

	/**
	* Constant for qualifier with value PRIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRIN
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRIN = "PRIN";

	/**
	* Constant for qualifier with value PROC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PROC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PROC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PROC = "PROC";

	/**
	* Constant for qualifier with value PROD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PROD
	* @see com.prowidesoftware.swift.SchemeConstantsP#PROD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PROD = "PROD";

	/**
	* Constant for qualifier with value PROR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PROR
	* @see com.prowidesoftware.swift.SchemeConstantsP#PROR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PROR = "PROR";

	/**
	* Constant for qualifier with value PRPP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PRPP
	* @see com.prowidesoftware.swift.SchemeConstantsP#PRPP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PRPP = "PRPP";

	/**
	* Constant for qualifier with value PSAG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PSAG
	* @see com.prowidesoftware.swift.SchemeConstantsP#PSAG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PSAG = "PSAG";

	/**
	* Constant for qualifier with value PTSC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PTSC
	* @see com.prowidesoftware.swift.SchemeConstantsP#PTSC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PTSC = "PTSC";

	/**
	* Constant for qualifier with value PUTT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PUTT
	* @see com.prowidesoftware.swift.SchemeConstantsP#PUTT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PUTT = "PUTT";

	/**
	* Constant for qualifier with value PWAL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsP.PWAL
	* @see com.prowidesoftware.swift.SchemeConstantsP#PWAL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String PWAL = "PWAL";

	/**
	* Constant for qualifier with value QINT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsQ.QINT
	* @see com.prowidesoftware.swift.SchemeConstantsQ#QINT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String QINT = "QINT";

	/**
	* Constant for qualifier with value QTSO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsQ.QTSO
	* @see com.prowidesoftware.swift.SchemeConstantsQ#QTSO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String QTSO = "QTSO";

	/**
	* Constant for qualifier with value RATE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RATE
	* @see com.prowidesoftware.swift.SchemeConstantsR#RATE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RATE = "RATE";

	/**
	* Constant for qualifier with value RCHG 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RCHG
	* @see com.prowidesoftware.swift.SchemeConstantsR#RCHG
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RCHG = "RCHG";

	/**
	* Constant for qualifier with value RDDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RDDT
	* @see com.prowidesoftware.swift.SchemeConstantsR#RDDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RDDT = "RDDT";

	/**
	* Constant for qualifier with value RDIS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RDIS
	* @see com.prowidesoftware.swift.SchemeConstantsR#RDIS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RDIS = "RDIS";

	/**
	* Constant for qualifier with value RDTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RDTE
	* @see com.prowidesoftware.swift.SchemeConstantsR#RDTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RDTE = "RDTE";

	/**
	* Constant for qualifier with value REDP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REDP
	* @see com.prowidesoftware.swift.SchemeConstantsR#REDP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REDP = "REDP";

	/**
	* Constant for qualifier with value REGF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGF
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REGF = "REGF";

	/**
	* Constant for qualifier with value REGI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGI
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REGI = "REGI";

	/**
	* Constant for qualifier with value REGO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGO
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REGO = "REGO";

	/**
	* Constant for qualifier with value REGR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REGR
	* @see com.prowidesoftware.swift.SchemeConstantsR#REGR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REGR = "REGR";

	/**
	* Constant for qualifier with value REIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REIN
	* @see com.prowidesoftware.swift.SchemeConstantsR#REIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REIN = "REIN";

	/**
	* Constant for qualifier with value RELA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RELA
	* @see com.prowidesoftware.swift.SchemeConstantsR#RELA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RELA = "RELA";

	/**
	* Constant for qualifier with value REPE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPE
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPE = "REPE";

	/**
	* Constant for qualifier with value REPL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REPL
	* @see com.prowidesoftware.swift.SchemeConstantsR#REPL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REPL = "REPL";

	/**
	* Constant for qualifier with value RESA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RESA
	* @see com.prowidesoftware.swift.SchemeConstantsR#RESA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RESA = "RESA";

	/**
	* Constant for qualifier with value RESU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RESU
	* @see com.prowidesoftware.swift.SchemeConstantsR#RESU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RESU = "RESU";

	/**
	* Constant for qualifier with value REVO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.REVO
	* @see com.prowidesoftware.swift.SchemeConstantsR#REVO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String REVO = "REVO";

	/**
	* Constant for qualifier with value RHDI 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RHDI
	* @see com.prowidesoftware.swift.SchemeConstantsR#RHDI
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RHDI = "RHDI";

	/**
	* Constant for qualifier with value RINR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RINR
	* @see com.prowidesoftware.swift.SchemeConstantsR#RINR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RINR = "RINR";

	/**
	* Constant for qualifier with value RLOS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RLOS
	* @see com.prowidesoftware.swift.SchemeConstantsR#RLOS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RLOS = "RLOS";

	/**
	* Constant for qualifier with value RMDR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RMDR
	* @see com.prowidesoftware.swift.SchemeConstantsR#RMDR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RMDR = "RMDR";

	/**
	* Constant for qualifier with value RSPR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RSPR
	* @see com.prowidesoftware.swift.SchemeConstantsR#RSPR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RSPR = "RSPR";

	/**
	* Constant for qualifier with value RTUN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsR.RTUN
	* @see com.prowidesoftware.swift.SchemeConstantsR#RTUN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String RTUN = "RTUN";

	/**
	* Constant for qualifier with value SAFE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SAFE
	* @see com.prowidesoftware.swift.SchemeConstantsS#SAFE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SAFE = "SAFE";

	/**
	* Constant for qualifier with value SECMOVE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SECMOVE
	* @see com.prowidesoftware.swift.SchemeConstantsS#SECMOVE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SECMOVE = "SECMOVE";

	/**
	* Constant for qualifier with value SELL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SELL
	* @see com.prowidesoftware.swift.SchemeConstantsS#SELL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SELL = "SELL";

	/**
	* Constant for qualifier with value SEME 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SEME
	* @see com.prowidesoftware.swift.SchemeConstantsS#SEME
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SEME = "SEME";

	/**
	* Constant for qualifier with value SETT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SETT
	* @see com.prowidesoftware.swift.SchemeConstantsS#SETT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SETT = "SETT";

	/**
	* Constant for qualifier with value SHIP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SHIP
	* @see com.prowidesoftware.swift.SchemeConstantsS#SHIP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SHIP = "SHIP";

	/**
	* Constant for qualifier with value SHRT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SHRT
	* @see com.prowidesoftware.swift.SchemeConstantsS#SHRT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SHRT = "SHRT";

	/**
	* Constant for qualifier with value SIZE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SIZE
	* @see com.prowidesoftware.swift.SchemeConstantsS#SIZE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SIZE = "SIZE";

	/**
	* Constant for qualifier with value SOFE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SOFE
	* @see com.prowidesoftware.swift.SchemeConstantsS#SOFE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SOFE = "SOFE";

	/**
	* Constant for qualifier with value SOIC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SOIC
	* @see com.prowidesoftware.swift.SchemeConstantsS#SOIC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SOIC = "SOIC";

	/**
	* Constant for qualifier with value SOLA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SOLA
	* @see com.prowidesoftware.swift.SchemeConstantsS#SOLA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SOLA = "SOLA";

	/**
	* Constant for qualifier with value SPLP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SPLP
	* @see com.prowidesoftware.swift.SchemeConstantsS#SPLP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SPLP = "SPLP";

	/**
	* Constant for qualifier with value SPLT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SPLT
	* @see com.prowidesoftware.swift.SchemeConstantsS#SPLT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SPLT = "SPLT";

	/**
	* Constant for qualifier with value SPOS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SPOS
	* @see com.prowidesoftware.swift.SchemeConstantsS#SPOS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SPOS = "SPOS";

	/**
	* Constant for qualifier with value STAM 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STAM
	* @see com.prowidesoftware.swift.SchemeConstantsS#STAM
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STAM = "STAM";

	/**
	* Constant for qualifier with value STEX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STEX
	* @see com.prowidesoftware.swift.SchemeConstantsS#STEX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STEX = "STEX";

	/**
	* Constant for qualifier with value STIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.STIN
	* @see com.prowidesoftware.swift.SchemeConstantsS#STIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String STIN = "STIN";

	/**
	* Constant for qualifier with value SUBS 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SUBS
	* @see com.prowidesoftware.swift.SchemeConstantsS#SUBS
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SUBS = "SUBS";

	/**
	* Constant for qualifier with value SUSP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SUSP
	* @see com.prowidesoftware.swift.SchemeConstantsS#SUSP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SUSP = "SUSP";

	/**
	* Constant for qualifier with value SXDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsS.SXDT
	* @see com.prowidesoftware.swift.SchemeConstantsS#SXDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String SXDT = "SXDT";

	/**
	* Constant for qualifier with value TAXB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TAXB
	* @see com.prowidesoftware.swift.SchemeConstantsT#TAXB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TAXB = "TAXB";

	/**
	* Constant for qualifier with value TAXC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TAXC
	* @see com.prowidesoftware.swift.SchemeConstantsT#TAXC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TAXC = "TAXC";

	/**
	* Constant for qualifier with value TAXE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TAXE
	* @see com.prowidesoftware.swift.SchemeConstantsT#TAXE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TAXE = "TAXE";

	/**
	* Constant for qualifier with value TAXR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TAXR
	* @see com.prowidesoftware.swift.SchemeConstantsT#TAXR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TAXR = "TAXR";

	/**
	* Constant for qualifier with value TDMT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TDMT
	* @see com.prowidesoftware.swift.SchemeConstantsT#TDMT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TDMT = "TDMT";

	/**
	* Constant for qualifier with value TDTA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TDTA
	* @see com.prowidesoftware.swift.SchemeConstantsT#TDTA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TDTA = "TDTA";

	/**
	* Constant for qualifier with value TEMP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TEMP
	* @see com.prowidesoftware.swift.SchemeConstantsT#TEMP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TEMP = "TEMP";

	/**
	* Constant for qualifier with value TPDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TPDT
	* @see com.prowidesoftware.swift.SchemeConstantsT#TPDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TPDT = "TPDT";

	/**
	* Constant for qualifier with value TRAD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAD
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAD = "TRAD";

	/**
	* Constant for qualifier with value TRAN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAN
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAN = "TRAN";

	/**
	* Constant for qualifier with value TRAT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAT
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAT = "TRAT";

	/**
	* Constant for qualifier with value TRAX 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRAX
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRAX
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRAX = "TRAX";

	/**
	* Constant for qualifier with value TRDP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TRDP
	* @see com.prowidesoftware.swift.SchemeConstantsT#TRDP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TRDP = "TRDP";

	/**
	* Constant for qualifier with value TSDT 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TSDT
	* @see com.prowidesoftware.swift.SchemeConstantsT#TSDT
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TSDT = "TSDT";

	/**
	* Constant for qualifier with value TXAP 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TXAP
	* @see com.prowidesoftware.swift.SchemeConstantsT#TXAP
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TXAP = "TXAP";

	/**
	* Constant for qualifier with value TXDF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TXDF
	* @see com.prowidesoftware.swift.SchemeConstantsT#TXDF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TXDF = "TXDF";

	/**
	* Constant for qualifier with value TXFR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TXFR
	* @see com.prowidesoftware.swift.SchemeConstantsT#TXFR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TXFR = "TXFR";

	/**
	* Constant for qualifier with value TXIN 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TXIN
	* @see com.prowidesoftware.swift.SchemeConstantsT#TXIN
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TXIN = "TXIN";

	/**
	* Constant for qualifier with value TXNR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TXNR
	* @see com.prowidesoftware.swift.SchemeConstantsT#TXNR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TXNR = "TXNR";

	/**
	* Constant for qualifier with value TXPR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TXPR
	* @see com.prowidesoftware.swift.SchemeConstantsT#TXPR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TXPR = "TXPR";

	/**
	* Constant for qualifier with value TXRC 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsT.TXRC
	* @see com.prowidesoftware.swift.SchemeConstantsT#TXRC
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String TXRC = "TXRC";

	/**
	* Constant for qualifier with value UNAF 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNAF
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNAF
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UNAF = "UNAF";

	/**
	* Constant for qualifier with value UNBA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNBA
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNBA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UNBA = "UNBA";

	/**
	* Constant for qualifier with value UNCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNCO
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UNCO = "UNCO";

	/**
	* Constant for qualifier with value UNFR 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.UNFR
	* @see com.prowidesoftware.swift.SchemeConstantsU#UNFR
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String UNFR = "UNFR";

	/**
	* Constant for qualifier with value USECU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsU.USECU
	* @see com.prowidesoftware.swift.SchemeConstantsU#USECU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String USECU = "USECU";

	/**
	* Constant for qualifier with value VALU 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VALU
	* @see com.prowidesoftware.swift.SchemeConstantsV#VALU
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VALU = "VALU";

	/**
	* Constant for qualifier with value VATA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsV.VATA
	* @see com.prowidesoftware.swift.SchemeConstantsV#VATA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String VATA = "VATA";

	/**
	* Constant for qualifier with value WAPA 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WAPA
	* @see com.prowidesoftware.swift.SchemeConstantsW#WAPA
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String WAPA = "WAPA";

	/**
	* Constant for qualifier with value WEBB 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WEBB
	* @see com.prowidesoftware.swift.SchemeConstantsW#WEBB
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String WEBB = "WEBB";

	/**
	* Constant for qualifier with value WITH 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WITH
	* @see com.prowidesoftware.swift.SchemeConstantsW#WITH
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String WITH = "WITH";

	/**
	* Constant for qualifier with value WITL 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WITL
	* @see com.prowidesoftware.swift.SchemeConstantsW#WITL
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String WITL = "WITL";

	/**
	* Constant for qualifier with value WTHD 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WTHD
	* @see com.prowidesoftware.swift.SchemeConstantsW#WTHD
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String WTHD = "WTHD";

	/**
	* Constant for qualifier with value WUCO 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsW.WUCO
	* @see com.prowidesoftware.swift.SchemeConstantsW#WUCO
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String WUCO = "WUCO";

	/**
	* Constant for qualifier with value XDTE 
	* @deprecated use instead com.prowidesoftware.swift.SchemeConstantsX.XDTE
	* @see com.prowidesoftware.swift.SchemeConstantsX#XDTE
	*/
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	public static final String XDTE = "XDTE";

// end qualifiers constants	

	/**
	 * Creates an MT564 initialized with the parameter SwiftMessage
	 * @param m swift message with the MT564 content
	 */
	public MT564(SwiftMessage m) {
		super(m);
		// TODO issue warning if incorrect message type or illegal argument if different
	}

	/**
	 * Creates an MT564 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT564 content, the parameter can not be <code>null</code>
	 * @see #MT564(String)
	 */
	public MT564(MtSwiftMessage m) {
		this();
		super.m = super.getSwiftMessageNotNullOrException();
		// TODO issue warning if incorrect message type or illegal argument if different
	}
	
	/**
	 * Creates an MT564 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT564 content
	 * @return the created object or <code>null</code> if the parameter is <code>null</code>
	 * @see #MT564(String)
	 * @since 7.7
	 */
	public static MT564 parse(MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT564(m.message());
	}
	
	/**
	 * Creates and initializes a new MT564 input message setting TEST BICS as sender and receiver.<br />
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT564() {
		super(564);
	}
	
	/**
	 * Creates and initializes a new MT564 input message from sender to receiver.<br />
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT564(final String sender, final String receiver) {
		super(564, sender, receiver);
	}
	
	/**
	* <em>DO NOT USE THIS METHOD</em>
	* It is kept for compatibility but will be removed very soon, since the
	* <code>messageType</code> parameter is actually ignored.
	* Use instead <code>new MT564(sender, receiver)</code>
	* @see #MT564(String, String)
	* @deprecated
	*/
	@Deprecated
	public MT564(final int messageType, final String sender, final String receiver) {
		super(564, sender, receiver);
	}
	
	/**
	 * Creates a new MT564 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT564(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
			}
		}
    }
	
	/**
	 * Creates a new MT564 by parsing a String with the message content in its swift FIN format.<br />
	 * If the fin parameter cannot be parsed, the returned MT564 will have its internal message object
	 * initialized (blocks will be created) but empty.<br />
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be <code>null</code> in which case this method returns null</em>
	 * @return a new instance of MT564 or null if fin is null 
	 * @since 7.7
	 */
	public static MT564 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT564(fin);
    }
    
    /**
	 * Creates a new MT564 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT564(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT564 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.<br />
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT564 or null if stream is null or the message cannot be parsed 
	 * @since 7.7
	 */
	public static MT564 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT564(stream);
    }
    
    /**
	 * Creates a new MT564 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @since 7.7
	 */
	public MT564(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT564 by parsing a file with the message content in its swift FIN format.<br />
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT564 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @since 7.7
	 */
	public static MT564 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT564(file);
    }
    
	/**
	 * Returns this MT number
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "564";
	}
	
	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT564 append(final SwiftTagListBlock block) {
		super.append(block);
		return this;
	}
	
	/**
	 * Add all tags to the end of the block4.
	 *
	 * @param tags to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT564 append(final Tag ... tags) {
		super.append(tags);
		return this;
	}
	
	/**
	 * Add all the fields to the end of the block4.
	 *
	 * @param fields to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT564 append(final Field ... fields) {
		super.append(fields);
		return this;
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 28E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 28E at MT564 is expected to be the only one.
	 * 
	 * @return a Field28E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field28E getField28E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("28E");
			if (t == null) {
				log.fine("field 28E not found");
				return null;
			} else {
				return new Field28E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 23G, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 23G at MT564 is expected to be the only one.
	 * 
	 * @return a Field23G object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field23G getField23G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("23G");
			if (t == null) {
				log.fine("field 23G not found");
				return null;
			} else {
				return new Field23G(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 25D, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 25D at MT564 is expected to be the only one.
	 * 
	 * @return a Field25D object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field25D getField25D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("25D");
			if (t == null) {
				log.fine("field 25D not found");
				return null;
			} else {
				return new Field25D(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 36E, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 36E at MT564 is expected to be the only one.
	 * 
	 * @return a Field36E object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field36E getField36E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("36E");
			if (t == null) {
				log.fine("field 36E not found");
				return null;
			} else {
				return new Field36E(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 99A, 
	 * or <code>null</code> if none is found.<br />
	 * The first occurrence of field 99A at MT564 is expected to be the only one.
	 * 
	 * @return a Field99A object or <code>null</code> if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field99A getField99A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			final Tag t = _m.getBlock4().getTagByName("99A");
			if (t == null) {
				log.fine("field 99A not found");
				return null;
			} else {
				return new Field99A(t.getValue());
			}
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 20C at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20C> getField20C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("20C");
			final List<Field20C> result = new ArrayList<Field20C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field20C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22F at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22F> getField22F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22F");
			final List<Field22F> result = new ArrayList<Field22F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 16R at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16R> getField16R() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("16R");
			final List<Field16R> result = new ArrayList<Field16R>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field16R(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 13A at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13A> getField13A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("13A");
			final List<Field13A> result = new ArrayList<Field13A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field13A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 13B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 13B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field13B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field13B> getField13B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("13B");
			final List<Field13B> result = new ArrayList<Field13B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field13B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16S, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 16S at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16S objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16S> getField16S() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("16S");
			final List<Field16S> result = new ArrayList<Field16S>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field16S(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 12A at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12A> getField12A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("12A");
			final List<Field12A> result = new ArrayList<Field12A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field12A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 12C at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12C> getField12C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("12C");
			final List<Field12C> result = new ArrayList<Field12C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field12C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 12B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 12B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field12B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field12B> getField12B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("12B");
			final List<Field12B> result = new ArrayList<Field12B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field12B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98A at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98A> getField98A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98A");
			final List<Field98A> result = new ArrayList<Field98A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92A at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92A> getField92A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92A");
			final List<Field92A> result = new ArrayList<Field92A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92K, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92K at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92K> getField92K() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92K");
			final List<Field92K> result = new ArrayList<Field92K>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92K(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92D at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92D> getField92D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92D");
			final List<Field92D> result = new ArrayList<Field92D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 36B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36B> getField36B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("36B");
			final List<Field36B> result = new ArrayList<Field36B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field36B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95P at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95P> getField95P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95P");
			final List<Field95P> result = new ArrayList<Field95P>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95P(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95R at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95R> getField95R() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95R");
			final List<Field95R> result = new ArrayList<Field95R>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95R(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 97A at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97A> getField97A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("97A");
			final List<Field97A> result = new ArrayList<Field97A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field97A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 97C at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97C> getField97C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("97C");
			final List<Field97C> result = new ArrayList<Field97C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field97C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94B> getField94B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94B");
			final List<Field94B> result = new ArrayList<Field94B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94C at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94C> getField94C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94C");
			final List<Field94C> result = new ArrayList<Field94C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94F at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94F> getField94F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94F");
			final List<Field94F> result = new ArrayList<Field94F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 93B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 93B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field93B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field93B> getField93B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("93B");
			final List<Field93B> result = new ArrayList<Field93B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field93B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 93C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 93C at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field93C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field93C> getField93C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("93C");
			final List<Field93C> result = new ArrayList<Field93C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field93C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 35B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 35B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field35B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field35B> getField35B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("35B");
			final List<Field35B> result = new ArrayList<Field35B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field35B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98B> getField98B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98B");
			final List<Field98B> result = new ArrayList<Field98B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98C at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98C> getField98C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98C");
			final List<Field98C> result = new ArrayList<Field98C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98E at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98E> getField98E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98E");
			final List<Field98E> result = new ArrayList<Field98E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 69A at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69A> getField69A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("69A");
			final List<Field69A> result = new ArrayList<Field69A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field69A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 69B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69B> getField69B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("69B");
			final List<Field69B> result = new ArrayList<Field69B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field69B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 69C at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69C> getField69C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("69C");
			final List<Field69C> result = new ArrayList<Field69C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field69C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69D, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 69D at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69D> getField69D() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("69D");
			final List<Field69D> result = new ArrayList<Field69D>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field69D(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 69E at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69E> getField69E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("69E");
			final List<Field69E> result = new ArrayList<Field69E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field69E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 69F at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69F> getField69F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("69F");
			final List<Field69F> result = new ArrayList<Field69F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field69F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 69J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 69J at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field69J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field69J> getField69J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("69J");
			final List<Field69J> result = new ArrayList<Field69J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field69J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92F at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92F> getField92F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92F");
			final List<Field92F> result = new ArrayList<Field92F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92P, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92P at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92P objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92P> getField92P() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92P");
			final List<Field92P> result = new ArrayList<Field92P>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92P(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90B> getField90B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90B");
			final List<Field90B> result = new ArrayList<Field90B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90A at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90A> getField90A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90A");
			final List<Field90A> result = new ArrayList<Field90A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90E at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90E> getField90E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90E");
			final List<Field90E> result = new ArrayList<Field90E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90L at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90L> getField90L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90L");
			final List<Field90L> result = new ArrayList<Field90L>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90L(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 36C, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 36C at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field36C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field36C> getField36C() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("36C");
			final List<Field36C> result = new ArrayList<Field36C>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field36C(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 17B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 17B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field17B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field17B> getField17B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("17B");
			final List<Field17B> result = new ArrayList<Field17B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field17B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 94E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 94E at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field94E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field94E> getField94E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("94E");
			final List<Field94E> result = new ArrayList<Field94E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field94E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 70E at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70E> getField70E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("70E");
			final List<Field70E> result = new ArrayList<Field70E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field70E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 70G, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 70G at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field70G objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field70G> getField70G() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("70G");
			final List<Field70G> result = new ArrayList<Field70G>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field70G(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 11A, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 11A at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field11A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field11A> getField11A() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("11A");
			final List<Field11A> result = new ArrayList<Field11A>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field11A(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98F at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98F> getField98F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98F");
			final List<Field98F> result = new ArrayList<Field98F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98J at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98J> getField98J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98J");
			final List<Field98J> result = new ArrayList<Field98J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 98K, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 98K at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field98K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field98K> getField98K() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("98K");
			final List<Field98K> result = new ArrayList<Field98K>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field98K(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92B> getField92B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92B");
			final List<Field92B> result = new ArrayList<Field92B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92H at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92H> getField92H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92H");
			final List<Field92H> result = new ArrayList<Field92H>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92H(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92J at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92J> getField92J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92J");
			final List<Field92J> result = new ArrayList<Field92J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92R, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92R at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92R objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92R> getField92R() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92R");
			final List<Field92R> result = new ArrayList<Field92R>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92R(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 22H, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 22H at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field22H objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field22H> getField22H() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("22H");
			final List<Field22H> result = new ArrayList<Field22H>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field22H(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90F, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90F at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90F> getField90F() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90F");
			final List<Field90F> result = new ArrayList<Field90F>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90F(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90J, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90J at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90J objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90J> getField90J() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90J");
			final List<Field90J> result = new ArrayList<Field90J>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90J(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 90K, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 90K at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field90K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field90K> getField90K() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("90K");
			final List<Field90K> result = new ArrayList<Field90K>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field90K(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92L, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92L at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92L objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92L> getField92L() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92L");
			final List<Field92L> result = new ArrayList<Field92L>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92L(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92M, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92M at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92M objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92M> getField92M() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92M");
			final List<Field92M> result = new ArrayList<Field92M>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92M(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 92N, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 92N at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field92N objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field92N> getField92N() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("92N");
			final List<Field92N> result = new ArrayList<Field92N>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field92N(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 97E, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 97E at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field97E objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field97E> getField97E() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("97E");
			final List<Field97E> result = new ArrayList<Field97E>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field97E(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 19B, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 19B at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field19B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field19B> getField19B() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("19B");
			final List<Field19B> result = new ArrayList<Field19B>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field19B(tags[i].getValue()));
			}
			return result;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 95Q, 
	 * or <code>Collections.emptyList()</code> if none is found.<br />
	 * Multiple occurrences of field 95Q at MT564 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field95Q objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field95Q> getField95Q() {
		final SwiftMessage _m = super.getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return Collections.emptyList();
		} else {
			final Tag[] tags = _m.getBlock4().getTagsByName("95Q");
			final List<Field95Q> result = new ArrayList<Field95Q>();
			for (int i=0; i<tags.length; i++) {
				result.add(new Field95Q(tags[i].getValue()));
			}
			return result;
		}
	}
	

/*
 * sequences code
 *
 */ 


// BaseSequenceCodeGenerator [seq=A]
	/**
	* Class for Sequence "A" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceA extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceA() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceA(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>GENL</em>
		*/
		public static final String START_END_16RS = "GENL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceA newInstance(final Tag ... tags) {
			final SequenceA result = new SequenceA();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceA newInstance() {
			final SequenceA result = new SequenceA();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceA newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceA result = new SequenceA();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceA(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceA delimited by 16R/16S the value of SequenceA#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceA</code> is returned</em>
	* @see SequenceA#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceA getSequenceA() {
		return new SequenceA(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceA delimited by 16R/16S the value of SequenceA#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceA</code> is returned</em>  
	* @see SequenceA#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceA within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceA getSequenceA(SwiftTagListBlock parentSequence) {
		final SequenceA s = new SequenceA();
		s.setTags(parentSequence.getSubBlock(SequenceA.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=A1]
	/**
	* Class for Sequence "A1" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceA1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceA1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceA1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>LINK</em>
		*/
		public static final String START_END_16RS = "LINK";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceA1 newInstance(final Tag ... tags) {
			final SequenceA1 result = new SequenceA1();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceA1 newInstance() {
			final SequenceA1 result = new SequenceA1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceA1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceA1 result = new SequenceA1();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceA1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceA1 delimited by 16R/16S with value specified in SequenceA1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceA1#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceA1> getSequenceA1List() {
		return getSequenceA1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceA1 delimited by 16R/16S with value specified in SequenceA1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceA1#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceA1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceA1> getSequenceA1List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceA1.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceA1> result = new ArrayList<SequenceA1>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceA1 s = new SequenceA1();
				s.setTags(b.getSubBlock(SequenceA1.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=B]
	/**
	* Class for Sequence "B" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceB() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceB(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>USECU</em>
		*/
		public static final String START_END_16RS = "USECU";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB newInstance(final Tag ... tags) {
			final SequenceB result = new SequenceB();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceB newInstance() {
			final SequenceB result = new SequenceB();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceB newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB result = new SequenceB();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceB delimited by 16R/16S the value of SequenceB#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceB</code> is returned</em>
	* @see SequenceB#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceB getSequenceB() {
		return new SequenceB(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceB delimited by 16R/16S the value of SequenceB#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceB</code> is returned</em>  
	* @see SequenceB#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceB getSequenceB(SwiftTagListBlock parentSequence) {
		final SequenceB s = new SequenceB();
		s.setTags(parentSequence.getSubBlock(SequenceB.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=B1]
	/**
	* Class for Sequence "B1" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	@com.prowidesoftware.swift.internal.NonUniqueSeparator
	public static class SequenceB1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceB1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceB1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>FIA</em>
		*/
		public static final String START_END_16RS = "FIA";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
	@com.prowidesoftware.swift.internal.NonUniqueSeparator
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB1 newInstance(final Tag ... tags) {
			final SequenceB1 result = new SequenceB1();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceB1 newInstance() {
			final SequenceB1 result = new SequenceB1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceB1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB1 result = new SequenceB1();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceB1 delimited by 16R/16S the value of SequenceB1#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceB1</code> is returned</em>
    *
    * <div><em><b>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
    * present inside it&apos;s parent sequences</em></b>
    * </div>
    *
    * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	* @see SequenceB1#START_END_16RS
	*/
	@com.prowidesoftware.swift.internal.NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceB1 getSequenceB1() {
		/*
		*  the delimiter FIA is not unique across all sequences, this api can not be resolved without considering nested sequences
		* In Sequence B1 
		*/ 
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT564GetSequenceB1_sru2016(this);
	}
	
	/**
	* Get the single occurrence of SequenceB1 delimited by 16R/16S the value of SequenceB1#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceB1</code> is returned</em>  
	* @see SequenceB1#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB1 within the complete message
	* @since 7.7
    *
    * <div><em><b>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
    * present inside it&apos;s parent sequences</em></b>
    * </div>
    *
    * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	*/
	@com.prowidesoftware.swift.internal.NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceB1 getSequenceB1(SwiftTagListBlock parentSequence) {
		/*
		* The delimiter FIA is not unique across all sequences, this api can not be resolved without considering nested sequences
		* In Sequence B1 
		*/ 
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT564GetSequenceB1_sru2016(new MT564().append(parentSequence));
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=B2]
	/**
	* Class for Sequence "B2" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceB2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceB2() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceB2(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>ACCTINFO</em>
		*/
		public static final String START_END_16RS = "ACCTINFO";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceB2 newInstance(final Tag ... tags) {
			final SequenceB2 result = new SequenceB2();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceB2 newInstance() {
			final SequenceB2 result = new SequenceB2();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceB2 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceB2 result = new SequenceB2();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceB2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceB2 delimited by 16R/16S with value specified in SequenceB2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceB2#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceB2> getSequenceB2List() {
		return getSequenceB2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceB2 delimited by 16R/16S with value specified in SequenceB2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceB2#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceB2 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceB2> getSequenceB2List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceB2.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceB2> result = new ArrayList<SequenceB2>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceB2 s = new SequenceB2();
				s.setTags(b.getSubBlock(SequenceB2.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=C]
	/**
	* Class for Sequence "C" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceC extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceC() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceC(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>INTSEC</em>
		*/
		public static final String START_END_16RS = "INTSEC";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceC newInstance(final Tag ... tags) {
			final SequenceC result = new SequenceC();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceC newInstance() {
			final SequenceC result = new SequenceC();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceC newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceC result = new SequenceC();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceC(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceC delimited by 16R/16S the value of SequenceC#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceC</code> is returned</em>
	* @see SequenceC#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceC getSequenceC() {
		return new SequenceC(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceC delimited by 16R/16S the value of SequenceC#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceC</code> is returned</em>  
	* @see SequenceC#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceC within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceC getSequenceC(SwiftTagListBlock parentSequence) {
		final SequenceC s = new SequenceC();
		s.setTags(parentSequence.getSubBlock(SequenceC.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=D]
	/**
	* Class for Sequence "D" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceD extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceD() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceD(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CADETL</em>
		*/
		public static final String START_END_16RS = "CADETL";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceD newInstance(final Tag ... tags) {
			final SequenceD result = new SequenceD();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceD newInstance() {
			final SequenceD result = new SequenceD();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceD newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceD result = new SequenceD();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceD(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceD delimited by 16R/16S the value of SequenceD#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceD</code> is returned</em>
	* @see SequenceD#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceD getSequenceD() {
		return new SequenceD(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceD delimited by 16R/16S the value of SequenceD#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceD</code> is returned</em>  
	* @see SequenceD#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceD within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceD getSequenceD(SwiftTagListBlock parentSequence) {
		final SequenceD s = new SequenceD();
		s.setTags(parentSequence.getSubBlock(SequenceD.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=E]
	/**
	* Class for Sequence "E" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceE extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CAOPTN</em>
		*/
		public static final String START_END_16RS = "CAOPTN";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceE newInstance(final Tag ... tags) {
			final SequenceE result = new SequenceE();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceE newInstance() {
			final SequenceE result = new SequenceE();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceE newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE result = new SequenceE();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceE(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceE delimited by 16R/16S with value specified in SequenceE#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceE> getSequenceEList() {
		return getSequenceEList(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceE delimited by 16R/16S with value specified in SequenceE#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceE> getSequenceEList(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceE.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceE> result = new ArrayList<SequenceE>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceE s = new SequenceE();
				s.setTags(b.getSubBlock(SequenceE.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=E1]
	/**
	* Class for Sequence "E1" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceE1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE1() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE1(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>SECMOVE</em>
		*/
		public static final String START_END_16RS = "SECMOVE";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceE1 newInstance(final Tag ... tags) {
			final SequenceE1 result = new SequenceE1();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceE1 newInstance() {
			final SequenceE1 result = new SequenceE1();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceE1 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE1 result = new SequenceE1();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceE1(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceE1 delimited by 16R/16S with value specified in SequenceE1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE1#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceE1> getSequenceE1List() {
		return getSequenceE1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceE1 delimited by 16R/16S with value specified in SequenceE1#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE1#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE1 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceE1> getSequenceE1List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceE1.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceE1> result = new ArrayList<SequenceE1>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceE1 s = new SequenceE1();
				s.setTags(b.getSubBlock(SequenceE1.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=E1a]
	/**
	* Class for Sequence "E1a" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	@com.prowidesoftware.swift.internal.NonUniqueSeparator
	public static class SequenceE1a extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE1a() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE1a(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>FIA</em>
		*/
		public static final String START_END_16RS = "FIA";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
	@com.prowidesoftware.swift.internal.NonUniqueSeparator
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceE1a newInstance(final Tag ... tags) {
			final SequenceE1a result = new SequenceE1a();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceE1a newInstance() {
			final SequenceE1a result = new SequenceE1a();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceE1a newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE1a result = new SequenceE1a();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceE1a(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceE1a delimited by 16R/16S with value specified in SequenceE1a#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
    *
    * <div><em><b>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
    * present inside it&apos;s parent sequences</em></b>
    * </div>
    *
    * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	* @see SequenceE1a#START_END_16RS 
	*/
	@com.prowidesoftware.swift.internal.NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceE1a> getSequenceE1aList() {
  	   /*
		* The delimiter FIA is not unique across all sequences, in this MT.
		* The usual generated API for accessing this can not be used for sequence E1a.
		* So we call a special method to resolve this situation until we find a better approach.
		*
		*/
		if (this.getSwiftMessage() == null) {
			return null;
		}
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT564GetSequenceE1aList_sru2016(this);
	}
	/**
	* Get the list of SequenceE1a delimited by 16R/16S with value specified in SequenceE1a#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
    *
    * <div><em><b>This sequence does not have a unique 16R/S delimiter. In order to be uniquely identified it must be
    * present inside it&apos;s parent sequences</em></b>
    * </div>
    *
    * @see com.prowidesoftware.swift.model.mt.SequenceUtils
     *
	* @see SequenceE1a#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE1a within the complete message
	* @since 7.7
	*/
	@com.prowidesoftware.swift.internal.NonUniqueSeparator
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceE1a> getSequenceE1aList(final SwiftTagListBlock parentSequence) {
  		/*
		* The delimiter FIA is not unique across all sequences, in this MT.
		* The usual generated API for accessing this can not be used for sequence E1a.
		* So we call a special method to resolve this situation until we find a better approach.
		*
		*/
		return com.prowidesoftware.swift.model.mt.SequenceUtils.resolveMT564GetSequenceE1aList_sru2016(new MT564().append(parentSequence));

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=E2]
	/**
	* Class for Sequence "E2" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceE2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceE2() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceE2(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>CASHMOVE</em>
		*/
		public static final String START_END_16RS = "CASHMOVE";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceE2 newInstance(final Tag ... tags) {
			final SequenceE2 result = new SequenceE2();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceE2 newInstance() {
			final SequenceE2 result = new SequenceE2();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceE2 newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceE2 result = new SequenceE2();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceE2(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}

	/**
	* Get the list of SequenceE2 delimited by 16R/16S with value specified in SequenceE2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE2#START_END_16RS 
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public List<SequenceE2> getSequenceE2List() {
		return getSequenceE2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	/**
	* Get the list of SequenceE2 delimited by 16R/16S with value specified in SequenceE2#START_END_16RS 
	* The presence of this methods indicates that this sequence can occur more than once according to the Standard.
	* If message is empty or nor sequences are found <em>an empty list</em> is returned.
	* @see SequenceE2#START_END_16RS 
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceE2 within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static List<SequenceE2> getSequenceE2List(final SwiftTagListBlock parentSequence) {
		final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocks(SequenceE2.START_END_16RS);
		if (blocks != null && !blocks.isEmpty()) {
			final List<SequenceE2> result = new ArrayList<SequenceE2>(blocks.size());
			for (final SwiftTagListBlock b:blocks) {
				final SequenceE2 s = new SequenceE2();
				s.setTags(b.getSubBlock(SequenceE2.START_END_16RS).getTags());
				result.add(s);
			}
			return result; 
		}
		// TODO if is is mandatory issue a warning log
		return Collections.emptyList();

	} 	
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator


// BaseSequenceCodeGenerator [seq=F]
	/**
	* Class for Sequence "F" of MT 564
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static class SequenceF extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence
		 */
	        private SequenceF() {
			super(new ArrayList<Tag>());
		}
		/**
		* Creates a sequence with the given content.
		* @see SwiftTagListBlock
		*/
		private SequenceF(final SwiftTagListBlock content) {
			super(content.getTags());
		}
		/**
		* Value for the qualifier of the 16R / 16S tag that indicates start and end of this sequence <em>ADDINFO</em>
		*/
		public static final String START_END_16RS = "ADDINFO";
		public static final Tag START_TAG = new Tag(Field16R.NAME, START_END_16RS);
		public static final Tag END_TAG = new Tag(Field16S.NAME, START_END_16RS);
		/**
		* Creates a new instance of this sequence with the given tags inside.
		* @param tags may be null, an empty sequence containing only start and end sequence tags will be returned
		*/
		@SequenceStyle(Type.GENERATED_16RS)
		public static SequenceF newInstance(final Tag ... tags) {
			final SequenceF result = new SequenceF();

			result.append(START_TAG);

			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}

			result.append(END_TAG);

			return result;
		}

		/**
		* Create an empty $sequenceClassname.
		* This method is intended to avoid disambiguation for the newInstance() with variable list of blocks or tags
		* @since 7.6
		*/
		public static SequenceF newInstance() {
			final SequenceF result = new SequenceF();

			result.append(START_TAG);
			
			result.append(END_TAG);

			return result;
		}

		/**
		* Create a new instance of $sequenceClassname and add the contents of all sequences given inside.
		* Mainly intended to create a sequence by adding subsequences
		* @since 7.6
		*/
		public static SequenceF newInstance(final SwiftTagListBlock ... sequences) {
			final SequenceF result = new SequenceF();

			result.append(START_TAG);

			if (sequences != null && sequences.length > 0) {
				for (final SwiftTagListBlock s : sequences) {
					result.addTags(s.getTags());
				}
			}

			result.append(END_TAG);

			return result;

		}

		@SequenceStyle(Type.GENERATED_16RS)
		private SequenceF(final SwiftMessage m) {
			super();
			if (m.getBlock4() != null) {
				setTags(m.getBlock4().getSubBlock(START_END_16RS).getTags());
			}
		}
	}
	/**
	* Get the single occurrence of SequenceF delimited by 16R/16S the value of SequenceF#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceF</code> is returned</em>
	* @see SequenceF#START_END_16RS
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public SequenceF getSequenceF() {
		return new SequenceF(super.getSwiftMessageNotNullOrException());
	}
	
	/**
	* Get the single occurrence of SequenceF delimited by 16R/16S the value of SequenceF#START_END_16RS.
	* The presence of this methods indicates that this sequence can occur only once according to the Standard.
	* <em>NOTE: this method never returns <code>null</code>. If the sequence is not found an empty instance
	* of <code>SequenceF</code> is returned</em>  
	* @see SequenceF#START_END_16RS
	* @param parentSequence an optional parent sequence or <code>null</code> to find SequenceF within the complete message
	* @since 7.7
	*/
	@SequenceStyle(Type.GENERATED_16RS)
	public static SequenceF getSequenceF(SwiftTagListBlock parentSequence) {
		final SequenceF s = new SequenceF();
		s.setTags(parentSequence.getSubBlock(SequenceF.START_END_16RS).getTags());
		return s;
	}
 	// Slice debug: com.prowidesoftware.swift.codegen.DelimitedSequenceCodeGenerator





}
