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
package com.prowidesoftware.swift.model.field;


/**
 * Interface to mark generic fields and add method related to DSS and qualifiers.
 * 
 * @author www.prowidesoftware.com
 * @since 6.4
 */
public interface GenericField {
	   /**
	    * Returns the issuer code (or Data Source Scheme or DSS).
	    * The DSS is only present in some generic fields, when present, is equals to component two.
	    *
	    * @return DSS component value or <code>null</code> if the DSS is not set or not available for this field.
	    */
	   public String getDSS();
	   
	   /**
	    * Checks if the issuer code (or Data Source Scheme or DSS) is present.
	    *
	    * @see #getDSS()
	    * @return true if DSS is present, false otherwise.
	    */
	   public boolean isDSSPresent();
	   
	   /**
	    * Gets the conditional qualifier.<br />
	    * The conditional qualifier is the the component following the DSS of generic fields, being component 2 or 3 depending on the field structure definition.
	    *
	    * @return for generic fields returns the value of the conditional qualifier or <code>null</code> if not set or not applicable for this kind of field.
	    */
	   public String getConditionalQualifier();
}
