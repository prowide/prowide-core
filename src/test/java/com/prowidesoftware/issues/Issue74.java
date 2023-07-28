/*
 * Copyright 2006-2023 Prowide
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
package com.prowidesoftware.issues;

import com.prowidesoftware.swift.model.Tag;
import org.junit.jupiter.api.Test;

/**
 * https://github.com/prowide/prowide-core/issues/41
 */
public class Issue74 {

    @Test
    public void testField48() {

        Tag swift48Tag = new Tag("48:30/BUT WITHIN L/C VALIDITY");

        String formattedValue = swift48Tag.getValue();

        System.out.println("swift48Tag.getValue: " + formattedValue);
        assert "30/BUT WITHIN L/C VALIDITY".equals(formattedValue);

        if (swift48Tag.asField() != null) {
            formattedValue = swift48Tag.asField().getValue();
        }
        System.out.println("swift48Tag.asField.getValue: " + formattedValue);
        assert "30/BUT WITHIN L/C VALIDITY".equals(formattedValue);
    }
}
