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
package com.prowidesoftware.swift.io;

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @deprecated use {@link PPCReader} instead
 * @author www@prowidesoftware.com
 */
@Deprecated
@ProwideDeprecated(phase4=TargetYear._2019)
public class PPCFileReader extends PPCReader {
	
	public PPCFileReader(final File file) throws FileNotFoundException {
		super(file);
		DeprecationUtils.phase3(getClass(), null, "Use PPCReader instead.");
	}
	
}
