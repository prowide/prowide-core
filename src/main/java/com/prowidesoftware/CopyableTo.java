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
package com.prowidesoftware;

/**
 * Interface implemented by classes that can be copied to another live object.
 * Implementors of this interface define copyTo(...) which is a deep copy of the current object.
 *  
 * @author mgriffa
 * @since 7.8
 *
 * @param <T>
 */
public interface CopyableTo<T> {

	/**
	 * Copy recursively all attributes of this object to target.
	 * If an attribute implements {@link CopyableTo}, then copyTo is invoked also in that attribute.
	 * 
	 * @param target the object where these attributes will be copied. may be null, in which case nothing happens.
	 * @since 7.8
	 */
	void copyTo(T target);
}
