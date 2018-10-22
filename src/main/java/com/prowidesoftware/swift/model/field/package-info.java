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
/**
 * Base package for classes that model SWIFT MT message fields.
 * 
 * <p>This package provides classes to parse and model every possible field and letter option of a SWIFT MT message.
 * 
 * <p>The constructor of each field class accepts the field's literal value and parses its content into a list of components with a simple and generic API of getComponent1() ... getComponentN().<br>
 * Components are modeled as string, but if the component represents a date or number, additional API is provided to get the component parsed into a Calendar and Number with methods like getComponent1AsCalendar() and getComponent3AsNumber().
 */
package com.prowidesoftware.swift.model.field;