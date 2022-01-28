/*
 * Copyright 2006-2021 Prowide
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
package com.prowidesoftware.swift.constraints;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Bean validation for BIC numbers.
 *
 * <p>It will validate true for null, empty or blank values to bypass validation when
 * the field is optional. If you require a BIC to be mandatory, combine this constraint
 * with @NotBlank.
 *
 * @see com.prowidesoftware.swift.model.BIC#validate() for implementation details
 * @since 7.10.3
 */
@Documented
@Constraint(validatedBy = BicValidator.class)
@Target({METHOD, FIELD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface BicConstraint {
    String message() default "Invalid BIC code";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}