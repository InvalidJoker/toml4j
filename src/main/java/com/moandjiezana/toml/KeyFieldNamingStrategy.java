package com.moandjiezana.toml;

import com.google.gson.FieldNamingStrategy;

import java.lang.reflect.Field;

/**
 * @since 2025/10/9
 * @author Frish2021
 * <p>
 *
 * Example:
 * <code>
 *     class AClass {
 *         {@code @TomlKey("test-name")}
 *         String testName;
 *     }
 * </code>
 */
public enum KeyFieldNamingStrategy implements FieldNamingStrategy {
    INSTANCE;

    @Override
    public String translateName(Field field) {
        if (!field.isAnnotationPresent(TomlKey.class)) {
            return field.getName();
        }

        return field.getAnnotation(TomlKey.class).value();
    }
}
