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
package com.prowidesoftware;

/**
 * Interface implemented by classes that can be copied to another live object.
 * Implementors of this interface define copyTo(...) which is a deep copy of the current object.
 *
 * @param <T> the type of target
 * @author mgriffa
 * @since 7.8
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
