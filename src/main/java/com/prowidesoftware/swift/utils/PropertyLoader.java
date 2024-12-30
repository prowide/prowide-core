/*
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
package com.prowidesoftware.swift.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Helper class to load properties from a file.
 *
 * @since 9.3.18
 */
class PropertyLoader {
    private static final java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(PropertyLoader.class.getName());
    static final String PROPERTIES_FILE = "pw-swift-core.properties";
    private static Properties properties = null;
    private static final ReentrantLock lock = new ReentrantLock();

    private PropertyLoader() {
        // prevent instantiation
    }

    static Properties loadProperties() {
        if (properties == null) {
            lock.lock();
            try {
                if (properties == null) {
                    Properties tempProperties = new Properties();
                    try (InputStream inputStream =
                            PropertyLoader.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {
                        if (inputStream != null) {
                            tempProperties.load(inputStream);
                        }
                    } catch (IOException e) {
                        log.log(java.util.logging.Level.WARNING, "Error loading properties from " + PROPERTIES_FILE, e);
                    }
                    properties = tempProperties;
                }
            } finally {
                lock.unlock();
            }
        }
        return properties;
    }

    static String[] getPropertyArray(String key) {
        Properties loadedProperties = loadProperties();
        String propertyValue = loadedProperties.getProperty(key);

        if (propertyValue != null) {
            return propertyValue.split(",");
        }

        return new String[0];
    }

    static String getProperty(String key) {
        Properties loadedProperties = loadProperties();
        return loadedProperties.getProperty(key);
    }
}
