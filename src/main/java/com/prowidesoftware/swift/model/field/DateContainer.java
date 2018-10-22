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

import java.util.Calendar;
import java.util.List;

/**
 * Interface to mark fields whose definition contain a date.
 * Note that if a field has a date and it is optional, and the actual 
 * field has not set the optional date/s then
 * the call dates() will return an empty list
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public interface DateContainer {

	/**
	 * Get a calendar for every date found
	 * 
	 */
	List<Calendar> dates();
	
	// Maybe times() datetimes()?
}
