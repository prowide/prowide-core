/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of private license agreements
 * between Prowide Inc. and its commercial customers and partners.
 *******************************************************************************/
/**
 * Base package for classes that model SWIFT MT message fields.
 * 
 * <p>This package provides classes to parse and model every possible field and letter option of a SWIFT MT message.</p>
 * 
 * <p>The constructor of each field class accepts the field's literal value and parses its content into a list of components with a simple and generic API of getComponent1() ... getComponentN().<br />
 * Components are modeled as string, but if the component represents a date or number, additional API is provided to get the component parsed into a Calendar and Number with methods like getComponent1AsCalendar() and getComponent3AsNumber().</p>
 */
package com.prowidesoftware.swift.model.field;