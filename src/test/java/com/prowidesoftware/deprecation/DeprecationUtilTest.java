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

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.prowidesoftware.deprecation.DeprecationUtils.EnvironmentVariableKey;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.JRE;

/**
 * Test cases for the deprecation policy implementation
 *
 * @author sebastian
 * @since 7.8.9
 */
public class DeprecationUtilTest {

    /**
     * Default behavior
     */
    @Test
    public void testPhase2_default() {
        long t0 = System.currentTimeMillis();
        DeprecationUtils.phase2(this.getClass(), "method", "phase 2 message");
        long t1 = System.currentTimeMillis();
        long diff = t1 - t0;
        assertTrue(diff >= 3990);
    }

    /**
     * Log and delay switched off
     */
    @Test
    @DisabledForJreRange(min = JRE.JAVA_17, disabledReason="Consider rewrite or removal. Due to JPMS this case requires: --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED")
    public void testPhase2_off() {
        DeprecationUtils.setEnv(EnvironmentVariableKey.NOLOG, EnvironmentVariableKey.NODELAY);
        long t0 = System.currentTimeMillis();
        DeprecationUtils.phase2(this.getClass(), null, "another phase 2 message");
        long t1 = System.currentTimeMillis();
        assertTrue(t1 - t0 < 4000);
        DeprecationUtils.clearEnv();
    }

    /**
     * Default behavior
     */
    @Test
    public void testPhase3_default() {
        Assertions.assertThrows(UnsupportedOperationException.class, () -> DeprecationUtils.phase3(this.getClass(), null, "phase 3 message"));
    }


    /**
     * Exception switched off
     */
    @Test
    @DisabledForJreRange(min = JRE.JAVA_17, disabledReason="Consider rewrite or removal. Due to JPMS this case requires: --add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.util=ALL-UNNAMED")
    public void testPhase3_off() {
        DeprecationUtils.setEnv(EnvironmentVariableKey.NOLOG, EnvironmentVariableKey.NODELAY, EnvironmentVariableKey.NOEXCEPTION);
        DeprecationUtils.phase3(this.getClass(), null, "phase 3 message");
        DeprecationUtils.clearEnv();
    }

}
