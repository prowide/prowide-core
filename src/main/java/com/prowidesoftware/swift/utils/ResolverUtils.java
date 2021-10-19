package com.prowidesoftware.swift.utils;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class ResolverUtils {

    /**
     * Returns a subset of components based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param types a string with the wanted types
     * @param components the list of component values
     * @return the list of pairs {type, value} that match any of the wanted types, including nulls
     */
    public static List<Pair<Character, String>> findWantedType(String pattern, String types, List<String> components) {

        final List<Pair<Character, String>> result = new ArrayList<>();
        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (types.indexOf(pattern.charAt(i)) != -1) {
                result.add(new Pair<>(pattern.charAt(i), components.get(i)));
            }
        }
        return result;
    }

    /**
     * Returns a subset of components based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param types a string with the wanted types
     * @param components the list of component values
     * @return the list of pairs {type, value} that match any of the wanted types, including nulls
     */
    public static List<Pair<Character, String>> findNonNullWantedType(String pattern, String types, List<String> components) {

        final List<Pair<Character, String>> result = new ArrayList<>();
        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (components.get(i) != null && types.indexOf(pattern.charAt(i)) != -1) {
                result.add(new Pair<>(pattern.charAt(i), components.get(i)));
            }
        }
        return result;
    }

    /**
     * Returns the first component based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param types the wanted types
     * @param components the list of component values
     * @return a pair containing the first <em>NON-NULL</em> component's type and the value
     */
    public static Pair<Character, String> findFirstWantedType(String pattern, String types, List<String> components) {

        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (types.indexOf(pattern.charAt(i)) != -1) {
                return new Pair<Character, String>(pattern.charAt(i), components.get(i));
            }
        }
        return null;
    }

    /**
     * Returns the first <em>NON-NULL</em> component based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param types the wanted types
     * @param components the list of component values
     * @return a pair containing the first <em>NON-NULL</em> component's type and the value
     */
    public static Pair<Character, String> findFirstNonNullWantedType(String pattern, String types, List<String> components) {

        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (components.get(i) != null && types.indexOf(pattern.charAt(i)) != -1) {
                return new Pair<>(pattern.charAt(i), components.get(i));
            }
        }
        return null;
    }

    /**
     * Returns a subset of components based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param type the wanted type
     * @param components the list of component values
     * @return the list of components that match any of the wanted types, including nulls
     */
    public static List<String> findWantedType(String pattern, char type, List<String> components) {

        final List<String> result = new ArrayList<>();
        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (type == pattern.charAt(i)) {
                result.add(components.get(i));
            }
        }
        return result;
    }

    /**
     * Returns a subset of <em>NON-NULL</em> components based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param type the string list
     * @param components the list of component values
     * @return the list of components that match any of the wanted types, <em>NOT</em> including nulls
     */
    public static List<String> findNonNullWantedType(String pattern, char type, List<String> components) {

        final List<String> result = new ArrayList<>();
        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (components.get(i) != null && type == pattern.charAt(i)) {
                result.add(components.get(i));
            }
        }
        return result;
    }

    /**
     * Returns the first component based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param type the wanted type
     * @param components the list of component values
     * @return the value of the component that match any of the wanted types, <em>CAN BE NULL</em>
     */
    public static String findFirstWantedType(String pattern, char type, List<String> components) {

        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (type == pattern.charAt(i)) {
                return components.get(i);
            }
        }
        return null;
    }

    /**
     * Returns the first <em>NON-NULL</em> component based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param type the wanted type
     * @param components the list of component values
     * @return the value of the component that match any of the wanted types, <em>CANNOT BE NULL</em>
     */
    public static String findFirstNonNullWantedType(String pattern, char type, List<String> components) {

        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (components.get(i) != null && type == pattern.charAt(i)) {
                return components.get(i);
            }
        }
        return null;
    }

    /**
     * Returns the position of the first component based on the Types Pattern string and the wanted types
     *
     * @param pattern the Types Pattern as indicated in member TYPES_PATTERN
     * @param type the string list
     * @return the number of the first component that match any of the wanted types
     */
    public static int findFirstWantedTypePosition(String pattern, char type) {

        int len = pattern != null ? pattern.length() : 0;
        for(int i = 0; i < len; i++) {
            if (type == pattern.charAt(i)) {
                return i + 1;
            }
        }
        return -1;
    }


}
