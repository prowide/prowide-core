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
package com.prowidesoftware.deprecation;

/**
 * Target year for which a deprecation operation is scheduled.
 * Mainly used for tracking items in codebase.
 *
 * @author miguel
 * @since 7.8.1
 */
public enum TargetYear {
    SRU2022,
    SRU2023,
    SRU2024
}
