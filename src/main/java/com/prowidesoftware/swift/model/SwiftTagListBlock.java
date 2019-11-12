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
package com.prowidesoftware.swift.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.field.Field16R;
import com.prowidesoftware.swift.model.field.Field16S;
import com.prowidesoftware.swift.model.field.GenericField;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;

/**
 * Base class for SWIFT blocks that contain and arbitrary <b>set of fields</b> (3, 4, 5 and user blocks).<br>
 * Specific block classes for each block should be instantiated.
 *
 * @since 4.0
 */
public class SwiftTagListBlock extends SwiftBlock implements Serializable, Iterable<Tag> {
    private static final long serialVersionUID = -3753513588165638610L;
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftTagListBlock.class.getName());
	private static final String TAG_VALIDATION_MESSAGE = "parameter 'tag' cannot not be null";
	private static final String NAME_VALIDATION_MESSAGE = "parameter 'name' cannot not be null";
	/**
	 * <em>Immutable</em>empty instance of this class.
	 */
	public static final SwiftTagListBlock EMPTY_LIST = emptyList();

	/**
	 * Contains instances of Tag in this block, used to store the block's fields.
	 * @see Tag
	 */
	private List<Tag> tags = new ArrayList<>();

	/**
	 * Default constructor, shouldn't be used normally.
	 * present only for subclasses
	 */
	public SwiftTagListBlock() {
		super();
	}
	
	/**
	 * Intended to be used by search results in this class
	 */
	public SwiftTagListBlock(final List<Tag> tags) {
		this();
		this.tags = tags;
	}

	/**
	 * Return an <em>immutable</em> empty list
	 * Only to initialize EMPTY_LIST constant private to avoid creating new objects for empty immutable lists
	 * @since 7.7
	 */
	private static SwiftTagListBlock emptyList() {
		final List<Tag> tagList = Collections.emptyList();
		return new SwiftTagListBlock(tagList);
	}

	/**
	 * Empty iterator to be used when an API that returns an Iterator does not return null.
	 */
	private static final class EmptyItr implements Iterator<Tag> {
		public boolean hasNext() {
			return false;
		}

		public Tag next() {
			throw new NoSuchElementException();
		}

		public void remove() {
			throw new UnsupportedOperationException("Can't remove on an empty iterator");
		}
	}

	/**
	 * Gets the internal List of tags in block.
	 * @return a List of Tag
	 * @see Tag
	 */
	public List<Tag> getTags() {
		return this.tags;
	}

	/**
	 * Iterate through tags in this block and return the first tag whose name matches the parameter.
	 *
	 * @param name the tag name to search, for example "32A" or "58" (letter option wildcard 'a' is not supported)
	 * @return the first tag with the given name or null if none is found
	 * @throws IllegalArgumentException if the name parameter is null
	 */
	public Tag getTagByName(final String name) {
		Validate.notNull(name, NAME_VALIDATION_MESSAGE);
		for (Tag tag : this.tags) {
			if (StringUtils.equals(tag.getName(),  name)) {
				return tag;
			}
		}
		return null;
	}
	
	/**
	 * Gets the Tag at the given index in this block.
	 *
	 * @param index the index position of the tag to retrieve (zero based)
	 * @return the Tag at the given index
	 * @throws IndexOutOfBoundsException if the index is out of range
	 * @see List#get(int)
	 */
	public Tag getTag(final int index) {
		return this.tags.get(index);
	}

	/**
	 * Tells if this block contains at least one tag with the given name.
	 *
	 * @see #getTagByName(String)
	 * @param name the tag name to search, for example "32A" or "58" (letter option wildcard 'a' is not supported)
	 * @return true if a tag matching the given name is found
	 * @throws IllegalArgumentException if the name parameter is null
	 */
	public boolean containsTag(final String name) {
		return getTagByName(name) != null;	
	}

	/**
	 * Tells if this block contains at least one tag with the given number (ignoring the letter option).
	 * For example: <code>containsTag(59)</code> will return true if there is any variant of 59, 59A, 59F, etc...
	 *
	 * @see #getTagByNumber(int)
	 * @param tagNumber the tag number to search
	 * @return true if there is a tag with the given number regardless of the letter option
	 */
	public boolean containsTag(final int tagNumber) {
		return getTagByNumber(tagNumber) != null;
	}
	 
	/**
	 * Gets the value of the given tag or null if that tag is not found.<br>
	 * If the tag is present more than once, then this method retrieves the value of the first occurrence.
	 *
	 * @see #getTagByName(String)
	 * @param name the tag name to search, for example "32A" or "58" (letter option wildcard 'a' is not supported)
	 * @return a String containing the value null if the tag is not found
	 * @throws IllegalArgumentException if the name parameter is null
	 */
	public String getTagValue(final String name) {
		final Tag tag = this.getTagByName(name);
		return tag != null ? tag.getValue() : null;
	}

	/**
	 * Gets all tags with the given name.
	 * If name is null all tags that contain block data will be returned.
	 * 
	 * @param name the tags name to search, for example "32A" or "58" (letter option wildcard 'a' is not supported)
	 * @return an array of tags or an empty array if no tags are found
	 * @throws IllegalArgumentException if the name parameter is null
     * @see #getTagsByName(String, String) to find tags with letter option wildcard
	 */
	public Tag[] getTagsByName(final String name) {
		Validate.notNull(name, NAME_VALIDATION_MESSAGE);
		final List<Tag> l = new ArrayList<>();
		for (Tag tag : this.tags) {
			if (StringUtils.equals(tag.getName(), name)) {
				l.add(tag);
			}
		}
		return l.toArray(new Tag[l.size()]);
	}

	/**
	 * Get the first field with the given name, matching the given values for components 1 and 2.
	 * 
	 * @param name the tag name to search, for example "32A" or "58" (letter option wildcard 'a' is not supported)
	 * @param component1 the string to match as component 1.
	 * @param component2 the string to match as component 2.
	 * @return the first tag found matching the name and components values or null if none is found
	 * @throws IllegalArgumentException if the name parameter is null
	 * @since 7.8
	 */
	public Tag getTagByName(final String name, final String component1, final String component2) {
		for (final Tag tag : getTagsByName(name)) {
			final Field f = tag.asField();
			if (f != null && f.is(component1) && StringUtils.equals(f.getComponent(2), component2)) {
				return tag;
			}
		}
		return null;
	}

	/**
	 * Search and retrieve the first tag with the given number.
	 * For example: For 59 will return any of 59, 59A, 59F, etc...
 	 * 
 	 * @param tagNumber the tags number to search
 	 * @return the first tag with the given number or null if no tag is found.
	 */
	public Tag getTagByNumber(final int tagNumber) {
		for (Tag tag : this.tags) {
			if (tag.isNumber(tagNumber)) {
				return tag;
			}
		}
		return null;
	}
	
	/**
	 * Get all tags with a given number, regardless of the letter options.
	 * 
 	 * @param tagNumber the tags number to search
	 * @return the tags matching the given number or an empty list if none is found.	 
	 */
	public List<Tag> getTagsByNumber(final int tagNumber) {
		final List<Tag> result = new ArrayList<>();
		for (Tag tag : this.tags) {
			if (tag.isNumber(tagNumber)) {
				result.add(tag);
			}
		}
		return result;
	}

	/**
	 * Returns the tags having the exact specified content as value, regardless of the tag name.<br>
	 * For example the field :98A::XDTE//20090818 will be included for parameter :XDTE//20090818
	 * <p>For partial match see {@link #getTagsByContent(String)}
	 *
	 * @param value the value of tags to find
	 * @return an list of tags or an empty list if none is found
	 * @since 6.0
	 */
	public List<Tag> getTagsByValue(final String value) {
		final List<Tag> result = new ArrayList<>();
		for (Tag tag : this.tags) {
			if (StringUtils.equals(tag.getValue(), value)) {
				result.add(tag);
			}
		}
		return result;
	}

	/**
	 * Returns the tags having the specified content as part of its value, regardless of the tag name.<br>
	 * For example the field :98A::XDTE//20090818 will be included for parameter XDTE
	 * <p>For exact value match see {@link #getTagsByValue(String)}
	 *
	 * @param content partial value of the tags to find
	 * @return an list of tags or an empty list if none is found
	 * @since 6.0
	 */
	public List<Tag> getTagsByContent(final String content) {
		final List<Tag> result = new ArrayList<>();
		for (Tag tag : this.tags) {
			if (StringUtils.contains(tag.getValue(), content)) {
				result.add(tag);
			}
		}
		return result;
	}

	/**
	 * Gets the values for all tags matching the given name. 
	 * The tag list is searched in order, the value of all tag matching the name are added to the result.
	 * @see #getTagsByName(String)
	 * 
	 * @param name the tag name to search, for example "32A" or "58" (letter option wildcard 'a' is not supported)
	 * @return and array containing the values of all the matching tags or an empty array if none is found
	 * @throws IllegalArgumentException if the name parameter is null
	 */
	public String[] getTagValues(final String name) {
		Validate.notNull(name, NAME_VALIDATION_MESSAGE);
		final ArrayList<String> result = new ArrayList<>();
		for (Tag tag : getTagsByName(name)) {
			result.add(tag.getValue());
		}
		return result.toArray(new String[result.size()]);
	}

	/**
	 * Gets a Map that contains the the tag names as keys and the values as map value.
	 * If a field is present more than once, then the first instance is processed and the rest is ignored.
	 *
	 * @return a Map for the tags name and values
	 */
	public Map<String, String> getTagMap() {
		final Map<String, String> map = new HashMap<>(this.tags.size());
		for (Tag tag : this.tags) {
			if (!map.containsKey(tag.getName())) {
				map.put(tag.getName(), tag.getValue());
			}
		}
		return map;
	}

	/**
	 * Gets the first field matching the given name.
	 *
	 * @param name the name of the field to match, may end with 'a' as wildcard to select any letter option, for example 50a will match both 50A and 50B
	 * @return the found field instance or null if none is found with the given name
	 * @throws IllegalArgumentException if the name parameter is null
	 */
	public Field getFieldByName(final String name) {
		return getFieldByName(name, null);
	}

	/**
	 * Gets all fields matching the given name.
	 * 
	 * @param name the name of the field to match, may end with 'a' as wildcard to select any letter option, for example 50a will match both 50A and 50B
	 * @return an array of matched fields or an empty array if none is found
	 * @throws IllegalArgumentException if the name parameter is null
	 */
	public Field[] getFieldsByName(final String name) {
		final List<? extends Field> fields = getFieldsByName(name, null);
		return fields.toArray(new Field[fields.size()]);
	}

	/**
	 * Gets the first field matching the given name and first component value.
	 * This is particularly helpful to find generic field by its qualifier.
	 *
	 * @param name the name of the field to match, may end with 'a' as wildcard to select any letter option, for example 50a will match both 50A and 50B
	 * @param componentValue expected value for component 1 in the matched field, or null to return the first field matching the name
	 * @return the first matching field or null if none is found
	 *
	 * @since 7.5
	 * @throws IllegalArgumentException if name parameter is null
	 */
	public Field getFieldByName(final String name, final String componentValue) {
		Validate.notNull(name, NAME_VALIDATION_MESSAGE);
		
		final boolean wildcard = name.endsWith("a");
		for (Tag tag : this.tags) {
			if (matchesName(wildcard, tag.getName(), name)) {
				final Field field = tag.asField();
				if (field == null) {
					log.warning("Could not create field instance of "+tag);
				} else if (componentValue == null || field.is(componentValue)) {
					return field;
				}
			}
		}
		return null;
	}

	/**
	 * Gets all fields matching the given name and first component value.
	 * 
	 * @param name the name of the field to match, may end with 'a' as wildcard to select any letter option, for example 50a will match both 50A and 50B
	 * @param componentValue expected value for component 1 in the matched fields, or null to return all fields matching the name
	 * @return a list of matching fields or an empty list if none is found
	 * @since 7.6
	 * @throws IllegalArgumentException if name parameter is null
	 */
	public List<? extends Field> getFieldsByName(final String name, final String componentValue) {
		Validate.notNull(name, NAME_VALIDATION_MESSAGE);
		
		final boolean wildcard = name.endsWith("a");
		final List<Field> l = new ArrayList<>();
		for (Tag tag : this.tags) {
			if (matchesName(wildcard, tag.getName(), name)) {
				final Field field = tag.asField();
				if (field == null) {
					log.warning("Could not create field instance of "+tag);
				} else if (componentValue == null || field.is(componentValue)) {
					l.add(field);
				}
			}
		}
		return l;
	}

    /**
     * Gets all tag instances matching the given name and first component value.
     *
     * @param name the name of the field to match, may end with 'a' as wildcard to select any letter option, for example 50a will match both 50A and 50B
     * @param componentValue expected value for component 1 in the matched fields, or null to return all fields matching the name
     * @return a list of matching tags or an empty list if none is found
     * @since 7.10.6
     * @throws IllegalArgumentException if name parameter is null
     */
	public List<Tag> getTagsByName(final String name, final String componentValue) {
        Validate.notNull(name, NAME_VALIDATION_MESSAGE);

        final boolean wildcard = name.endsWith("a");
		final List<Tag> l = new ArrayList<>();
		for (Tag tag : this.tags) {
			if (matchesName(wildcard, tag.getName(), name)) {
			    if (componentValue == null) {
			        l.add(tag);
                } else {
                    final Field field = tag.asField();
                    if (field != null && field.is(componentValue)) {
                        l.add(tag);
                    }
                }
			}
		}
		return l;
	}

	/**
	 * Returns true if the found fieldname matches the expected name
	 * @param wildcard if true the match will ignore letter options
	 * @param found current field name
	 * @param expected the expected value
	 * @return true if matches considering the optional wildcard
	 * @since 7.9.7
	 */
	private boolean matchesName(boolean wildcard, final String found, final String expected) {
		if (wildcard) {
			return StringUtils.startsWith(found, expected.substring(0, expected.length()-1));
		} else {
			return StringUtils.equals(found, expected);
		}
	}
	
	/**
	 * Shortcut to {@link #getTag(int)}.getField()
	 * @see #getTag(int)
	 * 
	 * @param index the index position of the field to retrieve (zero based)
	 * @return the field at the given index
	 * @throws IndexOutOfBoundsException if the index is out of range
	 */
	public Field getField(final int index) {
		final Tag tag = getTag(index);
		if (tag != null) {
			return tag.asField();
		}
		return null;
	}
	
	/**
	 * Gets all fields matching the given name, matching also the first and second component values.<br>
	 * For example, for parameters 22F, OPTF and FOO it will match 22F::OPTF/FOO/QCAS but not 22F::OPTF//QCAS
	 * 
	 * @see #getFieldByQualifiers(String, String, String)
	 * @param name the name of the field to match, may end with 'a' as wildcard to select any letter option, for example 50a will match both 50A and 50B
	 * @param component1 the expected value for the component 1 of the matched field
	 * @param component2 the expected value for the component 2 of the matched field
	 * @return the first matching field or null if none is found with the given name and component values
	 * @since 7.5
	 */
	public Field getFieldByName(final String name, final String component1, final String component2) {
		for (Field field : getFieldsByName(name, component1)) {
			if (StringUtils.equals(field.getComponent(2), component2)) {
				return field;
			}
		}
		return null;
	}
	
	/**
	 * Gets all generic fields matching the given name and qualifiers.<br>
	 * For example, for parameters 22F, OPTF and QCAS it will match 22F::OPTF//QCAS or 22F::OPTF/DSS/QCAS
	 * 
	 * @see #getFieldByName(String, String)
	 * @see GenericField
	 * @param name the name of the field to match, may end with 'a' as wildcard to select any letter option, for example 50a will match both 50A and 50B
	 * @param qualifier the expected value for the component 1 of the matched field
	 * @param conditionalQualifier the expected value for the conditional qualifier component (usually 2 or 3) of the matched field
	 * @return the first matching field or null if none is found with the given name and expected component values
	 */
	public Field getFieldByQualifiers(final String name, final String qualifier, final String conditionalQualifier) {
		for (Field field : getFieldsByName(name, qualifier)) {
			if (field instanceof GenericField) {
				if (StringUtils.equals(((GenericField)field).getConditionalQualifier(), conditionalQualifier)) {
					return field;
				}
			}
		}
		return null;
	}	
	
	/**
	 * Search and retrieve the first Field with the given number.
	 * For example: for 59 will return any of 59, 59A, 59F, etc...
	 * 
	 * @param fieldNumber the field number to search
	 * @return the first instance of the given field in the message or null if none is found
	 * @see #getTagByNumber(int)
	 */
	public Field getFieldByNumber(final int fieldNumber) {
		final Tag t = getTagByNumber(fieldNumber);
		if (t != null) {
			return t.asField();
		}
		return null;
	}

	/**
	 * Get all Fields of a given number.<br>
	 * For example: for 59 will return any of 59, 59A, 59F, etc...
	 * 
	 * @param fieldNumber the field number to search
	 * @return the fields matching the given number or an empty list if none is found.
	 *
	 * @see #getTagsByNumber(int)
	 */
	public List<? extends Field> getFieldsByNumber(final int fieldNumber) {
		final List<Field> result = new ArrayList<>();
		for (Tag tag : getTagsByNumber(fieldNumber)) {
			final Field f = tag.asField();
			if (f == null) {
				throw new IllegalArgumentException("Unable to create field for tagname "+tag.getName());
			} else {
				result.add(f);
			}
		}
		return result;
	}

	/**
	 * Gets the first field matching the given number and component value.
	 * For example: for 59 will return any of 59, 59A, 59F, etc...
	 *
	 * @param fieldNumber the field number to search
 	 * @param componentValue expected value for component 1 in the matched field
	 * @return the first matching field or null if none is found
	 */
	public Field getFieldByNumber(final int fieldNumber, final String componentValue) {
		for(Field field : getFieldsByNumber(fieldNumber)) {
			if (field.is(componentValue)) {
				return field;
			}
		}
		return null;
	}

	/**
	 * Tell if this block contains at least a field with the given name
	 * @param name the name of the field to match, may end with 'a' as wildcard to select any letter option, for example 50a will match both 50A and 50B
	 * @return true if this field exists at lease once, false in other case
	 * @see #getFieldsByName(String)
	 */
	public boolean containsField(final String name) {
		final Field[] arr = getFieldsByName(name);
		return (arr != null) && arr.length > 0;
	}

	/**
	 * Counts how many tags with the given name are present in the block.
	 *
	 * @param name the name of the tag
	 * @return the amount of tags with the given name in the block
	 * @throws IllegalArgumentException if tagname key is null
	 */
	public int countByName(final String name) {
		Validate.notNull(name, NAME_VALIDATION_MESSAGE);
		int count = 0;
		for (final Tag tag : this.tags) {
			if (StringUtils.equals(tag.getName(), name)) {
				count++;
			}
		}
		return count;
	}

	/**
	 * convert this to string
	 */
	public String toString() {
		return new StringBuilder()
		.append(getClass().getName()).append("[")
		.append(tags == null ? "tags=null" : tags.toString())
		.append("]")
		.toString();
	}

	/**
	 * Remove the tag with the given name in the block.
	 * If more than one instance of the given name is
	 * found the first instance is removed while the
	 * rest remains untouched.
	 *
	 * @param name the name of the tag to remove must not be null
	 * @return the value of the removed tag
	 * @throws IllegalArgumentException if parameter name is null
	 * @see #removeAll(String)
	 */
	public String removeTag(final String name) {
		Validate.notNull(name, NAME_VALIDATION_MESSAGE);
		int i = 0;
		for (Tag t : tags) {
			if (StringUtils.equals(t.getName(), name)) {
				final Tag r = tags.remove(i);
				return r.getValue();
			}
			i++;
		}
		return null;
	}

	/**
	 * Remove all tags in the current block that match the given name.
	 * If name is an invalid tag no error is thrown. There is no difference by using this method
	 * to tell if a tag was present or not. for quering the block for existing tags
	 * {@link #containsTag(String)} must be used.
	 *
	 * @param name the name of the tag to remove. may be null in which case the tags containing 'block data' will be removed
	 * @return the amount of tags removed
	 * @throws IllegalArgumentException if parameter name is null
	 * @see #removeTag(String)
	 */
	public int removeAll(final String name) {
		Validate.notNull(name, "parameter 'name' cannot not be null");
		int removed = 0;
		for (Tag t : getTagsByName(name)) {
			this.tags.remove(t);
			removed++;
		}
		return removed;
	}

	/**
	 * Gets a Iterator for the tags in this block or null if no tags are present on the block an empty iterator is returned.
	 *
	 * @return an Iterator that may or may not contain objects of type Tag
	 * @see Tag
	 */
	public Iterator<Tag> tagIterator() {
		if (this.tags == null || this.tags.isEmpty()) {
			if (log.isLoggable(Level.FINE)) {
				log.fine("No tags in block, returning empty iterator");
			}
			return new EmptyItr();
		}
		return this.tags.iterator();
	}

	/**
	 * Add all tags in the List argument to the current blocks. Current tags will not be removed.
	 * @param tags the list of tags to add
	 * @throws IllegalArgumentException if parameter name is null
	 */
	public void addTags(final List<Tag> tags) {
		Validate.notNull(tags, "parameter 'tags' cannot not be null");
		thisTagsNotNull().addAll(tags);
	}

    /**
     * Adds a tag at the specified position in this tag list.
	 * Shifts the element currently at that position (if any) and any subsequent elements to the right (adds one to their indices).
     * @param tag the tag to add
     * @param index index at which the specified tag is to be inserted (zero based)
     * @throws IllegalArgumentException if parameter name is null
	 * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt;= size())
	 * @since 7.9.7
     */
    public void addTag(int index, final Tag tag) {
        // sanity check
        Validate.notNull(tag, TAG_VALIDATION_MESSAGE);
        thisTagsNotNull().add(index,tag);
    }

	/**
	 * returns this.tags checking before if it is null, and then creating a new array list for it
	 */
	private List<Tag> thisTagsNotNull() {
		if (this.tags == null) {
			this.tags = new ArrayList<>();
		}
		return this.tags;
	}
	
	/**
	 * @deprecated use {@link #countAll()} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public int getTagCount() {
		DeprecationUtils.phase3(getClass(), "getTagCount()", "Use countAll() instead." );
		return countAll();
	}
	
	/**
	 * Gets the number of tags in this taglist
	 * @return zero or the amount of tags contained in the block
	 */	public int countAll() {
		 return (this.tags == null ? 0 : tags.size());
	 }

	 /**
	  * Replaces the tag at the specified position in this tag list with the specified tag.
      *
      * @param index index of the tag to replace (zero based)
      * @param tag tag to be stored at the specified position
      * @return the tag previously at the specified position
	  * @throws IllegalArgumentException if parameter name is null
	  * @throws IndexOutOfBoundsException if the index is out of range (index &lt; 0 || index &gt;= size())
      * @since 7.9.7
	  */
	 public Tag setTag(int index, Tag tag) {
         // sanity check
         Validate.notNull(tag, TAG_VALIDATION_MESSAGE);
		 return this.tags.set(index,tag);
	 }

    /**
     * Set tag in the list of tags of this block.
     *
     * @param tags the tags of the block, may be null to remove all the tags of the block
     * @throws IllegalArgumentException if parameter tags is not null and contains elements of class other than Tag
     */
    public void setTags(final List<Tag> tags) {
        this.tags = tags;
    }

	 /**
	  * @param tags tags to set
	  * @see #setTags(List)
	  */
	 public void setTags(final Tag[] tags) {
		 List<Tag> list = new ArrayList<>();
		 list.addAll(Arrays.asList(tags));
		 setTags(list);
	 }

	 /**
	  * Tells if the block contains at least one Tag.
	  *
	  * @return true if the block contains at least one Tag and false in other case
	  */
	 public boolean isEmpty() {
		 return (this.tags == null || this.tags.isEmpty());
	 }

	 /**
	  * Tells the amount of fields contained in the block, may be zero.
	  * @return zero if tags is null or empty or the amount of tags in this object
	  */
	 public int size() {
		 return (this.tags == null ? 0 : this.tags.size());
	 }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		SwiftTagListBlock tags1 = (SwiftTagListBlock) o;
		return Objects.equals(tags, tags1.tags);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), tags);
	}

	/**
	  * Get all sub blocks using the starting and ending Tags as block boundaries.<br>
	  * The starting and end tags are included in the resulting sub blocks.
	  * <br>
	  * Tag compare is done using {@link Tag#equalsIgnoreCR(Tag)} (not object references).
	  *
	  * @param start starting tag
	  * @param end ending tag
	  * @return a list of <code>SwiftTagListBlock</code> new blocks containing the found tags (the list can be empty if no tags are found)
	  *
	  * @since 6.0
	  */
	 public List<SwiftTagListBlock> getSubBlocks(final Tag start, final Tag end) {
		 final List<SwiftTagListBlock> result = new ArrayList<>();

		 SwiftTagListBlock toAdd = null;
		 boolean blockFound = false;
		 for (Tag t : this.tags) {
			 if (blockFound) {
				 toAdd.append(t);
				 if (end != null && end.equalsIgnoreCR(t)) {
					 result.add(toAdd);
					 blockFound = false;
					 toAdd = null;
				 }
			 } else {
				 if (start.equalsIgnoreCR(t)) {
					 toAdd = new SwiftTagListBlock();
					 toAdd.append(t);
					 blockFound = true;
				 }
			 }
		 }
		 //if necessary, we add the last found sub block
		 if (toAdd != null) {
			 result.add(toAdd);
		 }

		 return result;
	 }

    /**
     * Gets all sub blocks with a specific name, using ISO 15022 FIN block structure definitions.
     * It searches for a starting 16R field (with blockName as value) and its correspondent 16S
     * field (with blockName as value) as block boundaries.
     *
     * @param blockName block name, used for block
     * @return a list containing the found tags (the list can be empty if no tags are found)
     * @see #getSubBlocks(Tag, Tag)
     *
     * @since 6.0
     */
     public List<SwiftTagListBlock> getSubBlocks(final String blockName) {
        return getSubBlocks(new Tag("16R", blockName), new Tag("16S", blockName));
     }

	 /**
	  * Get all sub blocks using the starting and ending Tag names as block boundaries (Tag values are ignored).
	  * The starting and end tags are included in the resulting sub blocks.<br>
	  * This method is particularly useful to get sub blocks that are not bounded by 16R and 16S fields.
	  *
	  * @param startTagName starting tag name
	  * @param endTagName ending tag name
	  * @return a list of <code>SwiftTagListBlock</code> new blocks containing the found tags (the list can be empty if no tags are found)
	  *
	  * @since 6.0
	  */
	 public List<SwiftTagListBlock> getSubBlocks(final String startTagName, final String endTagName) {
		 final Tag start = new Tag(startTagName, "");
		 final Tag end = new Tag(endTagName, "");
		 return _getSubBlocks(start.getNumber(), start.getLetterOption(), end.getNumber(), end.getLetterOption());
	 }

	 /**
	  * Get all sub blocks using the starting and ending Tag numbers as block boundaries (Tag values are ignored).
	  * The starting and end tags are included in the resulting sub blocks.<br>
	  * This method is particularly useful to get sub blocks that are not bounded by 16R and 16S fields.
	  *
	  * @param startTagNumber starting tag number regardless of the letter option
	  * @param endTagNumber ending tag number regardless of the letter option
	  * @return a list of <code>SwiftTagListBlock</code> new blocks containing the found tags (the list can be empty if no tags are found)
	  *
	  * @since 6.2
	  */
	 public List<SwiftTagListBlock> getSubBlocks(final int startTagNumber, final int endTagNumber) {
		 return _getSubBlocks(startTagNumber, null, endTagNumber, null);
	 }

	 /**
	  * Get all sub blocks using the starting Tag name and ending Tag number as block boundaries (Tag values are ignored).
	  * The starting and end tags are included in the resulting sub blocks.<br>
	  *
	  * @param startTagName starting tag name
	  * @param endTagNumber ending tag number regardless of the letter option
	  * @return a list of <code>SwiftTagListBlock</code> new blocks containing the found tags (the list can be empty if no tags are found)
	  *
	  * @since 6.2
	  */
	 public List<SwiftTagListBlock> getSubBlocks(final String startTagName, final int endTagNumber) {
		 final Tag start = new Tag(startTagName, "");
		 return _getSubBlocks(start.getNumber(), start.getLetterOption(), endTagNumber, null);
	 }

	 /**
	  * Get all sub blocks using the starting Tag number and ending Tag name as block boundaries (Tag values are ignored).
	  * The starting and end tags are included in the resulting sub blocks.<br>
	  *
	  * @param startTagNumber starting tag name number regardless of the letter option
	  * @param endTagName ending tag name
	  * @return a list of <code>SwiftTagListBlock</code> new blocks containing the found tags (the list can be empty if no tags are found)
	  *
	  * @since 6.2
	  */
	 public List<SwiftTagListBlock> getSubBlocks(final int startTagNumber, final String endTagName) {
		 final Tag end = new Tag(endTagName, "");
		 return _getSubBlocks(startTagNumber, null, end.getNumber(), end.getLetterOption());
	 }

    /**
     * Helper method to get subblocks on different boundaries combinations
     * @param startTagNumber mandatory starting tag number paramenter
     * @param startTagLetter optional starting tag letter option
     * @param endTagNumber mandatory ending tag number paramenter
     * @param endTagLetter optional ending tag letter option
     * @return the found subblocks
     */
    private List<SwiftTagListBlock> _getSubBlocks(final int startTagNumber, final String startTagLetter, final int endTagNumber, final String endTagLetter) {
        final List<SwiftTagListBlock> result = new ArrayList<>();

        SwiftTagListBlock toAdd = null;
        boolean blockFound = false;
        for (Tag t : this.tags) {
            if (blockFound) {
                toAdd.append(t);
                if ((endTagLetter != null && StringUtils.equals(t.getName(), endTagNumber+endTagLetter)) ||
                        (endTagLetter == null && t.isNumber(endTagNumber))) {
                    result.add(toAdd);
                    blockFound = false;
                    toAdd = null;
                }
            } else {
                if ((startTagLetter != null && StringUtils.equals(t.getName(), startTagNumber+startTagLetter)) ||
                        (startTagLetter == null && t.isNumber(startTagNumber))) {
                    toAdd = new SwiftTagListBlock();
                    toAdd.append(t);
                    blockFound = true;
                }
            }
        }
        //if necessary, we add the last found sub block
        if (toAdd != null) {
            result.add(toAdd);
        }

        return result;
    }

    /**
     * Get all tags between the first occurrence of the starting Tag name and the first occurrence of an optional ending Tag name.
     * If the ending Tag name is null or not found after the starting Tag name, it returns all tags until end of block.
     * The starting and end tags are included in the resulting block.
     *
     * @param startTagName starting tag name
     * @param endTagName ending tag name or null
     * @return a new block containing the found tags (the block can be empty if no tags are found)
     *
     * @since 6.0
     */
    public SwiftTagListBlock getSubBlock(final String startTagName, final String endTagName) {
        final List<SwiftTagListBlock> l = getSubBlocks(startTagName, endTagName);
        if (l.isEmpty()) {
            return new SwiftTagListBlock();
        } else {
            return l.get(0);
        }
    }

    /**
     * Gets all tags of a specific sub block, searching for the first occurrence of the starting 16R field (with blockName as value)
     * and its correspondent 16S field (with blockName as value).
     *
     * @param blockName block name, used for block
     * @return a new block containing the found tags (the block can be empty if no tags are found)
     * @see #getSubBlock(Tag, Tag)
     *
     * @since 6.0
     */
    public SwiftTagListBlock getSubBlock(final String blockName) {
        return getSubBlock(new Tag("16R", blockName), new Tag("16S", blockName));
    }

    /**
     * Get all tags between the first occurrence of the starting Tag and the first occurrence of an optional ending Tag.
     * If the ending Tag is null or not found after the starting Tag, it returns all tags until end of block.
     * The starting and end tags are included in the resulting block.
     *
     * @param start starting tag
     * @param end ending tag or null
     * @return a new block containing the found tags (the block can be empty if no tags are found)
     *
     * @since 6.0
     */
    public SwiftTagListBlock getSubBlock(final Tag start, final Tag end) {
        final List<SwiftTagListBlock> l = getSubBlocks(start, end);
        if (l.isEmpty()) {
            return new SwiftTagListBlock();
        } else {
            return l.get(0);
        }
    }

    /**
	 * Creates a new block containing the list of tags between the given indexes: from, inclusive, and to, exclusive.<br>
     * Similar to the substring method of String, but for a list of Tag instead of an array of characters.
     * For getting a 'view' only sublist use {@link List#subList(int, int)}
	 * For a new block containing both boundary elements included use {@link #sublist(Integer, Integer)}
     *
     * @param from may be null in which case is equivalent to zero
     * @param to may be null or larger than the list size, in which case is equivalent to the index of the last available item.
     * @return a <em>new</em> list with the tags found between given indexes in this tag list
     * @throws IllegalArgumentException if from is bigger than to.
     * @see List#subList(int, int)
     */
    public SwiftTagListBlock getSubBlock(final Integer from, final Integer to) {
        final int f = from == null ? 0 : from;
        final int t = to == null || to >this.tags.size()-1 ? this.tags.size() : to;
        if (f > t) {
            throw new IllegalArgumentException("from index ("+f+") cannot be bigger than to index ("+t+")");
        }
        final SwiftTagListBlock result = new SwiftTagListBlock();
        result.addTags(this.tags.subList(f, t));
        return result;
    }

    /**
	 * @since 6.5
	 * @deprecated use #getSubBlock(Integer, Integer) instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public SwiftTagListBlock getSubBlockByIndex(final Integer startIndex, final Integer endIndex) {
		DeprecationUtils.phase2(getClass(), "getSubBlockByIndex(Integer, Integer", "use getSubBlock(Integer, Integer) instead");
		return getSubBlock(startIndex, endIndex);
	}

	/**
	 * Get a new list with the elements contained between start and end, both inclusive.
	 * Both start and end <em>may be null</em>.
	 * For a new block excluding the end index use {@link #getSubBlock(Integer, Integer)}
	 *
	 * @param start start index, zero based. if null = zero
	 * @param end last index, zero based, null means last element
	 */
	public SwiftTagListBlock sublist(final Integer start, final Integer end) {
		if (tags == null || tags.isEmpty()) {
			throw new IllegalStateException("No tags in this list");
		}
		if ((start!=null && start<0) || (end != null && (end+1)>this.tags.size()) || (start!=null && end!=null && start>end)) {
			throw new IllegalArgumentException("start: "+start+", end: "+end+", size="+this.tags.size());
		}
		final SwiftTagListBlock result = new SwiftTagListBlock();
		final int s = start == null ? 0 : start;
		final int e = end == null ? this.tags.size()-1 : end;
		for (int i=s; i<=e ; i++) {
			result.append(this.tags.get(i));
		}
		return result;
	}

	/**
	 * To indicate which part of the data is selected
	 */
	private enum SearchSelection {
		BEFORE,
		AFTER
	}

	/**
	 * To indicate how the boundary to find
	 */
	private enum SearchBoundary {
		/*
		 * search using tag name
		 */
		FIRST_TAG_NAME,
		/*
		 * search using tag and ignore CR method
		 */
		FIRST_TAG_IGNORE_CR,
		/*
		 * search using tag name
		 */
		LAST_TAG_NAME
	}

	/**
	 * Helper method to get subblocks on different search criteria
	 * @param tag mandatory tag paramenter
	 * @param includeDelimiterInResult if true, the found boundary tag will be the first item in the returned block
	 * @param searchSelection mandatory search selection criteria.
	 * @param searchBoundary mandatory limit search criteria.
	 * @return the found subblocks
	 */
    private SwiftTagListBlock _searchSubBlockByCriteria(final Tag tag, final boolean includeDelimiterInResult, SearchSelection searchSelection, SearchBoundary searchBoundary) {

        SwiftTagListBlock result = new SwiftTagListBlock();

        int index = getIndexByCriteria(searchBoundary, tag);

        if (index >= 0) {
        	//boundary tag found
            if (includeDelimiterInResult) {
            	if (searchSelection == SearchSelection.AFTER){
                    result = getSubBlock(index, null);
                } else {
                    result = getSubBlock(null, index+1);
                }
            } else {

                boolean hasDelimiterCriteria = (searchSelection == SearchSelection.AFTER && index<this.tags.size()-1) || (searchSelection == SearchSelection.BEFORE && index<this.tags.size());

                if (hasDelimiterCriteria) {
                    if (searchSelection == SearchSelection.AFTER){
                        result = getSubBlock(index+1, null);
                    } else {
                        if (index != 0){
                            result = getSubBlock(null, index);
                        }
                    }
                }
            }
        } else if (searchSelection == SearchSelection.BEFORE) {
        	result.addTags(this.tags);
        }

        return result;
    }

     /**
     * Get the index by search criteria tag or -1 if not found or precondition is not meet
     * @param criteria mandatory search criteria see (FIRST, FIRST_IGNORE_CR or LAST).
     * @param tag the tag that will be used to calculate the index of the list of tags.
	 * @return a 0-based index of the found tag or -1 if not found
     */
    private int getIndexByCriteria(SearchBoundary criteria, final Tag tag){
		switch(criteria) {
			case FIRST_TAG_NAME:
				return indexOfFirst(tag.name);
			case FIRST_TAG_IGNORE_CR:
				return indexOfFirstIgnoreCR(tag);
			case LAST_TAG_NAME:
				return indexOfLast(tag.name);
			default:
				return -1;
		}
    }

    /**
     * Gets a subblock after the first tag with the given tagname.
     * The given separator tag is included in the result
     * @deprecated use {@link #getSubBlockAfterFirst(String, boolean)} instead
     */
    @Deprecated
    @ProwideDeprecated(phase4=TargetYear.SRU2020)
    public SwiftTagListBlock getSubBlockAfterFirst(final String tagname) {
    	DeprecationUtils.phase3(getClass(), "getSubBlockAfterFirst(String)", "Use getSubBlockAfterFirst(String, boolean) instead.");
        return getSubBlockAfterFirst(tagname, true);
    }

	/**
	 * Gets a subblock after the first tag with the given name.
	 * <br>
	 * Creates a new {@link SwiftTagListBlock} that contains all tags after the first instance
	 * of a tag with the given tagname.
	 *
	 * @param tagname the tag that will be used for splitting
	 * @param includeBoundaryInResult if true, the found boundary tag will be the first item in the returned block
	 * @return a new block with the trimmed content
	 */
	public SwiftTagListBlock getSubBlockAfterFirst(final String tagname, final boolean includeBoundaryInResult) {
		final Tag tag = new Tag(tagname, "");
		return _searchSubBlockByCriteria(tag, includeBoundaryInResult, SearchSelection.AFTER, SearchBoundary.FIRST_TAG_NAME);
	}

	/**
	 * Gets the subblock after the first instance of a given tag boundary.
	 * <br>
	 * All elements after the first instance of the given tag will be included in the result.
	 * If the boundary tag is null or not found in the block, an empty block will be returned.
	 * <br>
	 * Tag compare is done using {@link Tag#equalsIgnoreCR(Tag)} (not object references).
	 *
	 * @param tag the tag that will be used for splitting
	 * @param includeBoundaryInResult if true, the found boundary tag will be the first item in the returned block
	 * @return a new block with the trimmed content
	 * @since 7.9.3
	 */
	public SwiftTagListBlock getSubBlockAfterFirst(final Tag tag, final boolean includeBoundaryInResult) {
		return _searchSubBlockByCriteria(tag, includeBoundaryInResult, SearchSelection.AFTER, SearchBoundary.FIRST_TAG_IGNORE_CR);
	}

	/**
	 * Gets the subblock after the last tag with the given name.
	 * <br>
	 * All elements after the last instance of a tag with the given name will be included in the result.
	 * If the tag name is null or no tag with the given name is found in the block, an empty block will be returned.
	 *
	 * @param tagname the name of the tag that will be used for for splitting
	 * @param includeBoundaryInResult if true, the found boundary tag will be the first item in the returned block
	 * @return a new block with the trimmed content
	 */
	public SwiftTagListBlock getSubBlockAfterLast(final String tagname, final boolean includeBoundaryInResult) {
		final Tag tag = new Tag(tagname, "");
		return _searchSubBlockByCriteria(tag, includeBoundaryInResult, SearchSelection.AFTER, SearchBoundary.LAST_TAG_NAME);
	}

	/**
     * Gets the subblock before the first tag with the given tagname.
     * <br>
     * Creates a new {@link SwiftTagListBlock} that contains all tags before the first instance
     * of a tag with the given tagname.
     *
     * @param tagname the name of the tag that will be used for splitting
     * @param includeBoundaryInResult if true, the found boundary tag will be the last item in the returned block
     * @return a new block with the trimmed content
     */
    public SwiftTagListBlock getSubBlockBeforeFirst(final String tagname, final boolean includeBoundaryInResult) {
		final Tag tag = new Tag(tagname, "");
        return _searchSubBlockByCriteria(tag, includeBoundaryInResult, SearchSelection.BEFORE, SearchBoundary.FIRST_TAG_NAME);
    }

    /**
     * Gets the subblock with all tags until tha last tag with the given name
     *
     * @param tagname the name of the tag that will be used for splitting
	 * @param includeBoundaryInResult if true, the found boundary tag will be the last item in the returned block
     * @return the tags contained until the first instance of tagname
     */
    public SwiftTagListBlock getSubBlockBeforeLast(final String tagname, final boolean includeBoundaryInResult) {
		final Tag tag = new Tag(tagname, "");
        return  _searchSubBlockByCriteria(tag, includeBoundaryInResult, SearchSelection.BEFORE, SearchBoundary.LAST_TAG_NAME);
    }

    /**
     * Get the index of the given tag in the list.
     *
     * @param startTagNumber the number of the tag, without any letter option
     * @param letterOptions list of letter options to search, an empty string is accepted to search no letter option
     * @return the index inside the internal list of the given tag, null if the tag is not  found
     * @since 6.5
     */
    public Integer getTagIndex(final String startTagNumber, final String [] letterOptions) {
        for (int i=0; i<this.tags.size(); i++) {
            final Tag t = this.tags.get(i);
            if (StringUtils.startsWith(t.getName(), startTagNumber)) {
                // check letter options
                if (letterOptions == null || letterOptions.length < 1) {
                    return i;
                } else {
                    for (final String l:letterOptions) {
                        if (StringUtils.equals(t.getName(), startTagNumber+l)) {
                            return i;
                        }
                    }
                }
            }
        }
        return null;
    }

	 /**
	  * Iterates the internal list of tags and returns true if there is at least one tag equals to the given one.
	  *
	  * @param t the tag to search in tags
	  * @return true if tag is found
	  * @since 6.0
	  */
	 public boolean containsTag(final Tag t) {
		 if (this.tags == null || this.tags.isEmpty()) {
			 return false;
		 }
		 for (Tag tag : this.tags) {
			 if (tag.equals(t)) {
				 return true;
			 }
		 }
		 return false;
	 }

	 /**
	  * Split the given list with the given tagname.
	  * Beware if the tagname is not found the entire list of tags is returned.
	  *
	  * @deprecated use {@link #splitByTagName(int, String)} instead where the result is empty when the boundary field is not found
	  */
	 @Deprecated
	 @ProwideDeprecated(phase2 = TargetYear.SRU2020)
	 public List<SwiftTagListBlock> splitByTagName(final String tagName) {
		 final List<SwiftTagListBlock> result = new ArrayList<>();
		 if (this.tags.isEmpty() || !containsTag(tagName)) {
			 result.add(this);
		 } else {
			 SwiftTagListBlock b = new SwiftTagListBlock();
			 b.append(tags.get(0));
			 for (int i=1;i<tags.size();i++) {
				 final Tag t = tags.get(i);
				 if (StringUtils.equals(tagName, t.getName())) {
					 result.add(b);
					 b = new SwiftTagListBlock();
				 }
				 b.append(t);
			 }
			 // el ultimo no queda agregado
			 if (!result.contains(b)) {
				 result.add(b);
			 }
		 }
		 return result;
	 }

	 /**
	  * Get the index of the last tagname in the list or -1 if not found or any precondition is not met
	  * @return a 0-based index of the found tag or -1 if not found
	  */
	 public int indexOfLast(final String tagname) {
		 int result = -1;
		 if (this.tags != null && !this.tags.isEmpty()) {

			 for (int i=0;i<this.tags.size();i++) {
				 if (StringUtils.equals(tagname, this.tags.get(i).getName())) {
					 result = i;
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * Get the index of the last tagname with the given value in the list or -1 if not found or any precondition is not met
	  * @return a 0-based index of the found tag or -1 if not found
	  * @since 7.8
	  */
	 public int indexOfLastValue(final String tagname, final String value) {
		 int result = -1;
		 if (this.tags != null && !this.tags.isEmpty()) {
			 
			 for (int i=0;i<this.tags.size();i++) {
				 if (StringUtils.equals(tagname, this.tags.get(i).getName())
						 && StringUtils.equals(value, this.tags.get(i).getValue())) {
					 result = i;
				 }
			 }
		 }
		 return result;
	 }
	 
	/**
	 * Get the index of the last of any tagnames in the list or -1 if not found or any precondition is not met.
	 * @param tagnames a variable list of tagnames to search. <em>Exact match only, wildcards NOT accepted</em>
	 * @return the <em>zero based</em> index of the last tag found with the given name or <em>-1 if not found</em>
	 */
	 public int indexOfAnyLast(final String ... tagnames) {
		 int result = -1;
		 if (this.tags != null && !this.tags.isEmpty()) {
			 for (int i=0;i<this.tags.size();i++) {
				 for (final String tn : tagnames) {
					 if (StringUtils.equals(tn, this.tags.get(i).getName())) {
						 result = i;
					 }
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * Get the index of the last of any tagnames after the given index in the list or -1 if not found or any precondition is not met
	  */
	 public int indexOfAnyLastAfterIndex(final int index, final String ... tagnames) {
		 int result = -1;
		 if (this.tags != null && !this.tags.isEmpty()) {
			 for (int i=index;i<this.tags.size();i++) {
				 for (final String tn : tagnames) {
					 if (StringUtils.equals(tn, this.tags.get(i).getName())) {
						 result = i;
					 }
				 }
			 }
		 }
		 return result;
	 }
	 
	 /**
	  * Gets the index of the first tag with the same name and value of in th list ignoring carriage returns characters in tag values, or -1 if not found or any precondition is not met
	  * @return a 0-based index of the found tag or -1 if not found
	  */
	 private int indexOfFirstIgnoreCR(final Tag tag) {
		 if (this.tags != null && !this.tags.isEmpty()) {

		     for (int i=0;i<this.tags.size();i++) {
				 if (this.tags.get(i).equalsIgnoreCR(tag)) {
					 return i;
				 }
			 }
		 }
		 return -1;
	 }

	/**
	 * Gets the index of the first tag with the given name in this tag list
	 * @return a 0-based index of the found tag or -1 if not found
	 */
	public int indexOfFirst(final String tagname) {
		if (this.tags != null && !this.tags.isEmpty()) {

			for (int i=0;i<this.tags.size();i++) {
				if (StringUtils.equals(tagname, this.tags.get(i).getName())) {
					return i;
				}
			}
		}
		return -1;
	}
	 
	 /**
	  * Gets the index of the first tag in this tag list, with the given name and value
	  * @param tagname the name of the tag to find
	  * @param value the value of the tag to find
	  * @return a 0-based index of the found tag or -1 if not found
	  * @since 7.8
	  */
	 public int indexOfFirstValue(final String tagname, final String value) {
	 	return indexOfFirstValue(tagname, value, false);
	 }

	/**
	 * Gets the index of the first tag in this tag list, with the given name and value
	 * @param tagname the name of the tag to find
	 * @param value the value of the tag to find
	 * @param ignoreCR if true the compare will ignore combination of CR and LF when comparing the value
	 * @return a 0-based index of the found tag or -1 if not found
	 * @since 7.9.7
	 */
	private int indexOfFirstValue(final String tagname, final String value, boolean ignoreCR) {
		if (this.tags != null && !this.tags.isEmpty()) {
			for (int i=0; i<this.tags.size(); i++) {
				final Tag t = this.tags.get(i);
				if ((ignoreCR && t.equalsIgnoreCR(new Tag(tagname, value))) ||
						(!ignoreCR && StringUtils.equals(tagname, t.getName()) && StringUtils.equals(value, t.getValue()))) {
					return i;
				}
			}
		}
		return -1;
	}

	/**
	  * Gets the index of the first tag matching any of the given names
	  * @return a 0-based index of the found tag or -1 if not found
	  */
	 public int indexOfAnyFirst(final String ... tagnames) {
		 if (this.tags != null && !this.tags.isEmpty()) {
			 for (int i=0; i<this.tags.size(); i++) {
				 for (final String tn : tagnames) {
					 if (StringUtils.equals(tn, this.tags.get(i).getName())) {
						 return i;
					 }
				 }
			 }
		 }
		 return -1;
	 }

	 /**
	  * Gets the index of the first tag matching any of the given names after the given index in the tag list
	  * @return a 0-based index of the found tag or -1 if not found
	  */
	 public int indexOfAnyFirstAfterIndex(final int index, final String ... tagnames) {
		 if (this.tags != null && !this.tags.isEmpty()) {
			 for (int i=index; i<this.tags.size(); i++) {
				 for (final String tn : tagnames) {
					 if (StringUtils.equals(tn, this.tags.get(i).getName())) {
						 return i;
					 }
				 }
			 }
		 }
		 return -1;
	 }

    /**
     * @deprecated use {@link #getSubBlockBeforeFirst(String, boolean)} instead
     */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public SwiftTagListBlock trimAfterFirst(final String tagname, final boolean includeBoundaryInResult) {
    	DeprecationUtils.phase2(getClass(), "trimAfterFirst(String, boolean)", "use getSubBlockBeforeFirst(String, boolean) instead");
		return getSubBlockBeforeFirst(tagname, includeBoundaryInResult);
	 }

  /**
   * Removes a sub block using fields 16R and 16S with the given block name as boundary.
	 *
	 * <p>It searches for a starting 16R field (with blockName as value) and its correspondent 16S
	 * field (with blockName as value) as block boundaries and removes those fields from the result.
	 * <p>If the searched block is not found (starting field 16R not present) the result will be just
	 * a copy from this block. If the end boundary is not found (ending field field 16S not present),
	 * trims all fields after the start boundary 16R.
	 * <p>If several instances of the searched block are present, only the first one will be removed.
	 * <p>The boundary fields 16R and 16S are also removed from the result.
	 *
	 * @param blockName block name, for example "SUBBAL" to search for 16R:SUBBAL and 16S:SUBBAL as boundaries
	 * @return a new block with the trimmed content
	 * @since 7.4
   */
	public SwiftTagListBlock removeSubBlock(final String blockName) {
		return removeSubBlock(blockName, false);
	}

	/**
	 * Remove all sub blocks with the given name (using fields 16R and 16S as boundaries).
	 * <p>
	 * The implementation is similar to {@link #removeSubBlock(String)} but will remove all found
	 * instances of the sub block.
	 *
	 * @see #removeSubBlock(String)
	 * @param blockName block name, for example "SUBBAL" to search for 16R:SUBBAL and 16S:SUBBAL as boundaries
	 * @return a new block with the trimmed content
	 * @since 7.10.3
	 */
	public SwiftTagListBlock removeSubBlocks(final String blockName) {
		return removeSubBlock(blockName, true);
	}

	private SwiftTagListBlock removeSubBlock(final String blockName, boolean removeAll) {
		final SwiftTagListBlock result = new SwiftTagListBlock();
		boolean inBlock = false;
		boolean blockRemoved = false;
		for (Tag t : this.tags) {
			if (blockRemoved && !removeAll) {
		 		// sub block already removed, keep all remaining tags
		 		result.append(t);
			} else {
				if (Field16R.tag(blockName).equals(t) && !inBlock) {
					// start boundary found
					inBlock = true;
				} else if (Field16S.tag(blockName).equals(t) && inBlock) {
					// end boundary found
					inBlock = false;
					// we are done
					blockRemoved = true;
				} else if (!inBlock) {
					// keep all tags but the one in the searched block
					result.append(t);
				}
			}
		}
		return result;
	}

	 /**
	  * Tell if this block contains any of the given name tags.
	  * this is a shorthand for avoiding repeated calls to {@link #containsTag(String)}.
	  * @param name the list of tags to check, if null or empty this method will return false without further action
	  * @since 7.0
	  * @see #containsTag(String)
	  * @see #containsAllOf(String...)
	  */
	 public boolean containsAnyOf(final String ... name) {
		 if (name != null && name.length>0) {
			 for (final String s:name) {
				 if (containsTag(s)) {
					 return true;
				 }
			 }
		 }
		 return false;
	 }
	 
	 /**
	  * Tell if this block contains all of the given name tags.
	  * this is a shorthand for avoiding repeated calls to {@link #containsTag(String)}.
	  * @param name the list of tags to check, if null or empty this method will return false without further action
	  * @since 7.4
	  * @see #containsTag(String)
	  * @see #containsAnyOf(String...)
	  */
	 public boolean containsAllOf(final String ... name) {
		 if (name != null && name.length>0) {
			 for (final String s:name) {
				 if (!containsTag(s)) {
					 return false;
				 }
			 }
			 return true;
		 }
		 return false;
	 }

	 /**
	  * Returns a new block that includes (true) or excludes (false), depending on <code>includeOrExclude</code> flag
	  * all tags with names matching any of the parameter names.<br>
	  * Once a tagname is matched, it is removed from the list of tags to be matched, causing to be only included/excluded the first instance of every tagname.<br>
	  * For example: 1, 2, 3, 4, 5, 6 filter by names 2, 4, 5 will return 1, 3, 6.
	  *
	  * @param include if true include all tags with given names, if false include all tags with a name <em>not</em> in names
	  * @param names list of tagnames to match
	  * @return a new list, an empty list if empty message, preconditions not met or nothing found
	  * @since 7.2
	  */
	 public SwiftTagListBlock filterByName(final boolean include, final String ... names) {
		 final SwiftTagListBlock result = new SwiftTagListBlock();
		 if (names.length == 0) {
			 if (include) {
				 // do nothing, will return empty list later
			 } else {
				 // return all current tags since none is to be excluded
				 result.setTags(getTags());
			 }
		 } else {
			 String[] tagnames = names;
			 for (Tag t : this.tags) {
				 // see if tag names is matched first
				 boolean matched = false;
				 for (int j=0; !matched && j<tagnames.length; j++) {
					 if (StringUtils.equals(t.getName(), tagnames[j])) {
						 matched = true;
						 tagnames = ArrayUtils.remove(tagnames, j);
					 }
				 }
				 if (matched && include) {
					 result.append(t);
				 }
				 if ((!matched) && !include) {
					 result.append(t);
				 }
			 }
		 }
		 return result;
	 }

	 /**
	  * Returns a new block that includes all tags with names matching any of the parameter names until a non matching tag is found.<br>
	  * Once a tagname is matched, it is removed from the list of tags to be matched, causing to be only included/excluded the first instance of every tagname.<br>
	  * For example: 1, 2, 3, 9, 4, 5, 6 filter by names 1, 2, 3, 4 will return 1, 2, 3.
	  *
	  * @param names list of tagnames to match
	  * @return a new list, an empty list if empty message, preconditions not met or nothing found
	  * @since 7.2
	  */
	 public SwiftTagListBlock filterByNameOrdered(final String ... names) {
		 String[] tagnames = names;
		 final SwiftTagListBlock result = new SwiftTagListBlock();
		 for (final Tag t : getTags()) {
			 boolean matched = false;
			 for (int j=0; !matched && j<tagnames.length; j++) {
				 if (StringUtils.equals(t.getName(), tagnames[j])) {
					 matched = true;
					 tagnames = (String[]) ArrayUtils.remove(tagnames, j);
					 result.append(t);
				 }
			 }
			 if (!matched) {
				 break;
			 }
		 }
		 return result;
	 }

	/**
	 * @deprecated use {@link #getSubBlockBeforeFirst(String, boolean)}
	 */
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public SwiftTagListBlock removeAfterFirst(final String tagname, final boolean includeBoundaryInResult) {
		DeprecationUtils.phase3(getClass(), "removeAfterFirst(String, boolean)", "Use getSubBlockBeforeFirst(String, boolean) instead.");
		return getSubBlockBeforeFirst(tagname, includeBoundaryInResult);
	}

    /**
     * @deprecated use {@link #getSubBlockAfterFirst(String, boolean)}
     */
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
    public SwiftTagListBlock removeUntilFirst(final String tagname, final boolean includeBoundaryInResult) {
		DeprecationUtils.phase3(getClass(), "removeUntilFirst(String, boolean)", "Use getSubBlockAfterFirst(String, boolean) instead.");
		return getSubBlockAfterFirst(tagname, includeBoundaryInResult);
	}

	 /**
	  * Get all subblocks in message that start with tag with tagname, end with tag named endName and optionally, may be null, have optionalTail tag names at the end of the secuence
	  *
	  * @param start name of the tag that identifies the begin of the sequence
	  * @param end name of the tag that identifies the end of the sequence
	  * @param tail names of tags that are optional and belong to the sequence, the must be after endName
	  * @return an empty list if none found or prerequisites not met
	  */
	 public List<SwiftTagListBlock> getSubBlocksDelimitedWithOptionalTail(final String[] start, final String[] end, final String[] tail) {
		 if (tags != null && !tags.isEmpty()) {
			 final List<SwiftTagListBlock> result = new ArrayList<>();
			 int offset = 0;
			 boolean done = false;
			 while (!done) {
				 final int s = indexOfAnyFirstAfterIndex(offset, start);
				 final int e = indexOfAnyFirstAfterIndex(s+1, end);

				 offset = e;
				 if (s==-1 || e==-1) {
					 done = true;
				 } else if (e>=s) {
					 final SwiftTagListBlock l = sublist(s, e);
					 if (tail !=null && tail.length>0) {
						 boolean abort = false;
						 for (int i=e+1;i<tags.size() && !abort;i++) {
							 boolean added = false;
							 for (final String tn : tail) {
								 final Tag tag = tags.get(i);
								 if (StringUtils.equals(tag.getName(), tn)) {
									 l.append(tag);
									 offset++;
									 added = true;
								 }
							 }
							 if (!added) {
								 abort = true;
							 }
						 }
					 }
					 result.add(l);
				 }
			 }

			 return result;
		 }
		 return Collections.emptyList();
	 }

	 /**
	  * Similar to {@link #getSubBlockByTagNames(Integer, String...)} but will return
	  * all matches for the indicated subblock
	  * @return a list of found subblocks or empty if non matched
	  * @since 7.8.5
      * @return a list with the found blocks
	  */
	 public List<SwiftTagListBlock> getSubBlocksByTagNames(final Integer startIndex, final String ... searchTags) {
		 List<SwiftTagListBlock> result = new ArrayList<>();
		 int start = startIndex != null? startIndex : 0;
		 while (start < tags.size()) {
			 SwiftTagListBlock found = new SwiftTagListBlock();
			 start = getSubBlockByTagNames(found, start, searchTags);
			 // continue on the tag following the last found
			 start++;
			 if (found.isEmpty()) {
				 break;
			 } else {
				 result.add(found);
			 }
		 }
		 return result;
	 }

	 /**
	  * Find a sub block given a comprehensive ordered list of search tag names.
	  * <p>
	  * For example given the block [20, 21, 32A, 54, 36, 36, 58B, 72] 
	  * <ul> 
	  * 	<li>search tags [32A, 36, 72] will return the subblock [32A, 36, 36, 72] notice repetitions are returned</li>
	  * 	<li>search tags [36, 32A, 72] will return the subblock [36, 36, 72] notice order in search is important</li>
	  * 	<li>search tags [36, 99, 72] will return the subblock [36, 36, 72] notice partial match is also returned</li>
	  * </ul>
	  * 
	  * @param startIndex optional starting offset, defaults to zero to search from the beginning of the block
	  * @param searchTags a list of tags to search, in order, for example: 20, 59A, 50K, 72
	  * @return a new block with the found tags or an empty block if search produces no matches
	  * @since 7.8.5
	  */
	 public SwiftTagListBlock getSubBlockByTagNames(final Integer startIndex, final String ... searchTags) {
		 SwiftTagListBlock block = new SwiftTagListBlock();
		 getSubBlockByTagNames(block, startIndex, searchTags);
		 return block;
	 }

	/**
	 * Implementation for {@link #getSubBlockByTagNames(Integer, String...)} and {@link #getSubBlocksByTagNames(Integer, String...)}
	 * @param target a not null block where found fields will be appended
	 * @param startIndex optional starting offset, defaults to zero to search from the beginning of the block
	 * @param searchTags a list of tags to search, in order, for example: 20, 59A, 50K, 72
	 * @return the tag index of the last field added to the target block, useful to get multiple blocks
	 * @since 7.10.4
	 */
	 private int getSubBlockByTagNames(final SwiftTagListBlock target, final Integer startIndex, final String ... searchTags) {
		 int tagsIndex = startIndex != null? startIndex : 0;
		 int searchIndex = 0;
		 int lastAddedIndex = tagsIndex;
		 /*
		  * this loops does a linear iteration on message tags and
		  * several iterations on the search tags.
		  */
		 while (tagsIndex < tags.size() && searchIndex < searchTags.length) {
			 final Tag candidate = tags.get(tagsIndex);
			 /*
			  * try to match on search tags, from current search index
			  * up to end of search tags list
			  */
			 for (int j=searchIndex; j<searchTags.length; j++) {
				 if (candidate.getName().equals(searchTags[j])) {
					 /*
					  * save matched tag
					  */
					 target.append(candidate);
					 searchIndex = j;
					 lastAddedIndex = tagsIndex;
					 break;
				 }
			 }
			 tagsIndex++;
		 }
		 return lastAddedIndex;
	 }

	 /**
	  * Get the first found sub block in message that start with tag with tagname, end with tag named endName and optionally, may be null, have optionalTail tag names at the end of the secuence
	  * @param start name of the tag that identifies the begin of the sequence
	  * @param end name of the tag that identifies the end of the sequence
	  * @param tail names of tags that are optional and belong to the sequence, the must be after endName
	  * @return the found block or null if prerequisites are not met
	  */
	 public SwiftTagListBlock getSubBlockDelimitedWithOptionalTail(final String[] start, final String[] end, final String[] tail) {
		 if (tags != null && !tags.isEmpty()) {
			 final int s = indexOfAnyFirst(start);
			 final int e = indexOfAnyFirstAfterIndex(s+1, end);

			 if (s!=-1 && e!=-1 && e>=s) {
				 final SwiftTagListBlock result = sublist(s, e);
				 if (tail ==null || tail.length==0) {
					 return result;
				 }
				 boolean abort = false;
				 for (int i=e+1;i<tags.size() && !abort;i++) {
					 boolean added = false;
					 for (final String tn : tail) {
						 if (StringUtils.equals(tags.get(i).getName(), tn)) {
							 result.append(tags.get(i));
							 added = true;
						 }
					 }
					 if (!added) {
						 abort = true;
					 }
				 }
				 return result;
			 }
		 }
		 return null;
	 }
	 
	 /**
	  * @see #getOptionalList(String[][], int)
	  * @param optionalTags the rows of optional tags
      * @return a new block with the found fields
	  */
	 public SwiftTagListBlock getOptionalList(final String[][] optionalTags) {
		 return getOptionalList(optionalTags, 0);
	 }

	/**
	 * Search a sequence of optional tags. inside each row, only one is matched.
	 * stop conditions: a tag is not in the optional row being processed or any future row or there are no more rows
	 * @param optionalTags the rows of optional tags
	 * @param startAt the starting index, zero-based
     * @return a new block with the found fields
	 */
	 public SwiftTagListBlock getOptionalList(final String[][] optionalTags, final int startAt) {
		 if (this.tags != null && !this.tags.isEmpty()) {
			 final SwiftTagListBlock result = new SwiftTagListBlock();
			 boolean done = false;
			 int t = startAt;
			 int rowPointer = 0;
			 do {
				 final Tag tag = this.tags.get(t++);
				 final int rowIndex = findTagInRowSince(tag, rowPointer, optionalTags);
				 if (rowIndex >= 0) {
					 rowPointer = rowIndex + 1;
					 result.append(tag);
				 } else {
					 // no se encontro, ni aca ni en lo que queda el tag,
					 done = true;
				 }
			 } while (!done);
			 return result;
		 }
		 return null;
	 }

	 private int findTagInRowSince(final Tag tag, final int rowPointer, final String[][] optionalTags) {
		 for (int r=rowPointer;r<optionalTags.length;r++) {
			 final String[] row = optionalTags[r];
			 for (int i=0;i<row.length;i++) {
				 final String op = row[i];
				 if (StringUtils.equals(tag.getName(), op)) {
					 return r;
				 }
			 }
		 }
		 return -1;
	 }

	 public List<SwiftTagListBlock> getOptionalLists(final String[][] optionalTags) {
		 final List<SwiftTagListBlock> result = new ArrayList<>();
		 if (this.tags != null && !this.tags.isEmpty()) {
			 boolean done = false;
			 int offset = 0;
			 while (!done) {
				 final SwiftTagListBlock o = getOptionalList(optionalTags, offset);
				 offset += o.size();

				 if (offset > this.tags.size() || o.isEmpty()) {
					 done = true;
				 }
				 if (!o.isEmpty()) {
					 result.add(o);
				 }
			 }
		 }
		 return result;
	 }
	 
	 public List<String> tagNamesList() {
		 if (this.tags == null || this.tags.isEmpty()) {
			 return Collections.emptyList();
		 }
		 final List<String> result = new ArrayList<>();
		 for (final Tag t: this.tags) {
			 result.add(t.getName());
		 }
		 return result;
	 }
	 
	 /**
	  * Counts tags starting with the given value
	  * @param name the exact name of the tag to be matched
	  * @param value the value that will be used to test if tag value startsWith
	  * @see Tag#startsWith(String)
      * @return the count result
	  */
	 public int countTagsStarsWith(final String name, final String value) {
		 int result = 0;
		 if (this.tags != null && !this.tags.isEmpty()) {
			 for (final Tag t : this.tags) {
				 if (StringUtils.equals(name, t.getName()) && t.startsWith(value)) {
					 result++;
				 }
			 }
		 }
		 return result;
	 }

	 /**
	  * Return a new block with all tags until the first tagname with the given name that start with startsWith
	  * @param name a field name
	  * @param startsWith the starting field content to search
      * @return a new block with the trimmed content
	  */
	 public SwiftTagListBlock removeAfterFirstStartsWith(final String name, final String startsWith) {
		 if (this.tags == null || !this.tags.isEmpty()) {
			 return new SwiftTagListBlock();
		 }

		 final List<Tag> tags = new ArrayList<>();
		 boolean done = false;
		 for (int i=0;i<this.tags.size() && !done;i++) {
			 final Tag t = this.tags.get(i);
			 if (StringUtils.equals(t.getName(), name) && t.startsWith(startsWith)) {
				 done = true;
			 } else {
				 tags.add(t);
			 }
		 }
		 return new SwiftTagListBlock(tags);
	 }

	/**
	 * Legacy (version 1) json representation of this object.
	 *
	 * <p>This implementation has been replaced by version 2, based on Gson.
	 * The main difference is the list of tags in the new version is serialized
	 * as a named field "tags".
	 *
	 * @deprecated use {@link #toJson()} instead
	 * @since 7.9.8
     * @return a string with the message content serialized as JSON
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public String toJsonV1() {
		DeprecationUtils.phase2(getClass(), "toJsonV1()", "use toJson() instead");
		final StringBuilder sb = new StringBuilder();
		sb.append("[ \n");
		if (this.tags != null && !this.tags.isEmpty()) {
			for (int i=0;i<this.tags.size();i++) {
				final Tag t = this.tags.get(i);
				sb.append("{ \"").append(t.getName()).append("\" : \"").append(escapeJson(t.getValue())).append("\" }");
				if (i+1<this.tags.size()) {
					sb.append(',');
				}
				sb.append('\n');
			}
		}
		sb.append("]");
		return sb.toString();
	}
	 
	 private String escapeJson(final String value) {
		 String tmp = StringUtils.replace(value, "\n", "\\n");
		 tmp = StringUtils.replace(tmp, "\"", "\\\"");
		 tmp = StringUtils.remove(tmp, "\r");
		 return tmp;
	 }

	/**
	 * Get a json representation of this block.
	 *
	 * Example:<br>
	 * <pre>
	 *{
	 *  "tags": [
	 *  {
	 *  "name": "113",
	 *  "value": "SEPA"
	 *  },
	 *  {
	 *  "name": "20",
	 *  "value": "REFERENCE"
	 *  }
	 *  ]
	 *}
	 *  </pre>
	 *
	 * @since 7.9.8
     * @return a string with the message content serialized as JSON
	 */
	public String toJson() {
		final Gson gson = new GsonBuilder().create();
		return gson.toJson(this);
	}

	 /**
	  * Appends all tags in block to the contents of this block
	  * @param block a block to append
	  * @return the current instance
	  */
	 public SwiftTagListBlock append (final SwiftTagListBlock block) {
		 if ((block!= null) && !block.isEmpty()) {
			 this.tags.addAll(block.getTags());
		 }
		 return this;
	 }
	 
	 /**
	  * Appends all blocks to the end of this one.
	  * 
	  * @param blocks may be null or empty, if so nothing happens 
	  * @return the current updated list
	  * @since 7.8
	  */
	 public SwiftTagListBlock append(final SwiftTagListBlock ... blocks) {
		 if ((blocks!= null) && blocks.length>0) {
			 for (final SwiftTagListBlock b : blocks) {
				 this.tags.addAll(b.getTags());
			}
		 }
		 return this;
	 }
	 
	 /**
	  * Add the given tag to the end of the list
	  * @param tag the tag to add, must not be null
	  * @return <code>this</code>
	  * @throws IllegalArgumentException if tag is null
	  * @since 7.7
	  */
	 public SwiftTagListBlock append(final Tag tag) {
		 Validate.notNull(tag);
		 this.tags.add(tag); 
		 return this;
	 }
	 
	 /**
	  * Appends all tags to the current block
	  * @param tags the tags to append. may be null in which case nothing happens
	  * @return <code>this</code>
	  * @since 7.8
	  */
	 public SwiftTagListBlock append(final Tag ... tags) {
		 if ((tags != null) && tags.length>0) {
			 for (final Tag t : tags) {
				 this.tags.add(t); 
			}
		 }
		 return this;
	 }
	 
	 /**
	  * Add the given field to the end of the list. 
	  * The Field components are serialized into a plain value usign the getValue implementation 
	  * of the Field object, and this created value is use for the internal Tag actually set into
	  * the block.
	  * 
	  * @param field the field to add, must not be null
	  * @return <code>this</code>
	  * @throws IllegalArgumentException if field is null
	  * @since 7.7
	  */
	 public SwiftTagListBlock append(final Field field) {
		 Validate.notNull(field);
		 this.tags.add(field.asTag()); 
		 return this;
	 }
	 
	 /**
	  * Appends all fields to the current block
	  * @param fields the fields to append. may be null in which case nothing happens
	  * @return <code>this</code>
	  * @since 7.8
	  */
	 public SwiftTagListBlock append(final Field ... fields) {
		 if ((fields != null) && fields.length>0) {
			 for (final Field f : fields) {
				 append(f); 
			}
		 }
		 return this;
	 }
	 
	 public Iterator<Tag> iterator() {
		 if (this.tags == null) {
			 return Collections.<Tag>emptyList().iterator();
		 }
		 return this.tags.iterator();
	 }

	 /**
	  * Get the content of this tag block as a Tag array.
	  * Returns an empty array if this list is empty.
	  * 
	  * @return this block taqs objects as array
	  * @since 7.8
	  */
	 public Tag[] asTagArray() {
		 if (this.size()>0) {
			 final Tag[] result = new Tag[this.size()];
			 int i = 0;
			 for (final Tag t : this.tags) {
				 result[i++] = t;
			 }
			 return result;
		 }
		 return new Tag[0];
	 }
	 
	 /**
	  * Removes all tags from the backing storage.
	  * @return this
	  * @since 7.8
	  */
	 public SwiftTagListBlock clear() {
		 if (this.tags != null) {
			 this.tags.clear();
		 }
		 return this;
	 }

     public String getName() {
        //unused
        return null;
    }

     public Integer getNumber() {
        //unused
        return null;
    }

     protected void setBlockName(final String blockName) {
        //unused
    }

     protected void setBlockNumber(final Integer blockNumber) {
        //unused
    }

     public void visit(final TagVisitor visitor) {
        if (visitor != null) {
            if (this.tags != null && !this.tags.isEmpty()) {
                for (final Tag t : this.tags) {
                    visitor.onTag(t);
                }
            }
        }
    }

	/**
	 * Return the list of fields in this block.
	 * <p>THe implementation iterates the existing Tag objects and for each
	 * calls the {@link Tag#asField()} method to create the corresponding
	 * Field instance
	 * @return a list of fields in this block or an empty list if the block is empty
	 * @since 7.10.4
	 */
	public List<Field> fields() {
		List<Field> fields = new ArrayList<>();
	 	for (Tag tag : this.tags) {
	 		fields.add(tag.asField());
		}
	 	return fields;
	}

	/**
	 * Helper method to retrieve all sequences starting with the parameter field.
	 * The boundary field can be indicated with or without the letter option. For example if number 15
	 * is passed with null letter option, this is like splitting by 15a (15A, 15B, 15C, etc..), each time
	 * a field 15 is found a new split is done regardless of the letter option. Converselly if a specific
	 * letter option is passed, the split is done when that particular number and letter combination is found.
	 * If the boundary field is nor present, the result will be empty.
	 * @param tagNumber the tag number
	 * @param letterOption optional letter option, if null, split is done by tag number for any letter option
	 * @return found subsequences or an empty list if boundary tag is not found
	 * @since 7.10.4
	 */
	public List<SwiftTagListBlock> splitByTagName(int tagNumber, String letterOption) {
		if (letterOption != null) {
			Validate.isTrue(StringUtils.length(letterOption) == 1, "letter option must be only one character");
		}
		final List<SwiftTagListBlock> result = new ArrayList<>();
		SwiftTagListBlock currentBlock = null;
		for (final Tag t : this.tags) {
			if (t.getNumber() == tagNumber) {
				final String letter = t.getLetterOption();
				if (letterOption == null || letterOption.equals(letter)) {
					currentBlock = new SwiftTagListBlock();
					result.add(currentBlock);
				}
			}
			if (currentBlock != null) {
				currentBlock.append(t);
			}
		}
		return result;
	}

}
