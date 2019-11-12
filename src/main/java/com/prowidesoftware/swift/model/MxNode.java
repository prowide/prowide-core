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

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * <p>This class represents a node element within a tree of MX message.
 * It is basically a generic <b>XML node</b> structure used to provide basic 
 * parsing functionallity for MX messages in Prowide Core.
 * 
 * <p>Note than full business model is provided only for the business
 * header, while a complete MX model is implemented in Prowide Integrator.
 * For more information on the full MX model implementation please check:
 * <a href="http://www.prowidesoftware.com/products/integrator">Prowide Integrator</a>
 *
 * @since 7.6
 */
public class MxNode {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(MxNode.class.getName());

	public static  final transient String PATH_SEPARATOR = "/";
	private MxNode parent;
	private final List<MxNode> children;
	private String value;
	private String localName;
	private Map<String, String> attributes = null;

	public MxNode() {
		this.parent = null;
		this.children = new ArrayList<>();
		this.value = null;
	}

	public MxNode(final MxNode parent, final String localName) {
		this();
		this.localName = localName;
		if (parent != null) {
			bindParent(parent);
		}
	}

	private void bindParent(final MxNode parent) {
		this.parent = parent;
		parent.addChild(this);
	}

	private void addChild(final MxNode child) {
		this.children.add(child);
	}

	public String singlePathValue(final String path) {
		final MxNode first = findFirst(path);
		if (first != null) {
			return first.getValue();
		}
		return null;
	}

	/**
	 * Given a basic path, find the first instance of a node matching the
	 * path parameter.<br>
	 *
	 * If the path starts with '/' it will search from the root element,
	 * else it will search from this node.
	 *
	 * @param path absolute or relative path to find
	 * @return found node or null
	 * @since 7.7
	 */
	public MxNode findFirst(final String path) {
		final List<MxNode> found = find(path);
		if (!found.isEmpty()) {
			return found.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Given a basic path, find all nodes matching the path parameter.<br>
	 *
	 * If the path starts with '/' it will search from the root element,
	 * else it will search from this node.
	 *
	 * @param path absolute or relative path to find
	 * @return found node or null
	 * @since 7.7
	 */
	public List<MxNode> find(final String path) {
		final String[] segments = StringUtils.split(path, PATH_SEPARATOR);
		final MxNode start = path != null && path.startsWith(PATH_SEPARATOR) ? getRoot() : this;
		return _find2(0, segments, start);
	}

	private List<MxNode> _find2(int index, final String[] segments, final MxNode node) {
		if (index >= segments.length) {
			return new ArrayList<>();
		}
		final List<MxNode> result = new ArrayList<>();
		final String segment = segments[index];
		int nextIndex = index + 1;
		
		//TODO en vez de remover el predicado, habria que soportarlo, devolviendo la/s instancia/s pedidas
		if (StringUtils.equals(".", segment) || StringUtils.equalsIgnoreCase(node.localName, removePredicate(segment))) {
			if (nextIndex == segments.length) {
				result.add(node);
				return result;
			} else if (node.children != null) {
				for (final MxNode n : node.children) {
					result.addAll(_find2(nextIndex, segments, n));
				}
				return result;
			}

		}
		return result;
	}

	private String removePredicate(final String segment) {
		int index = segment.indexOf('[');
		if (index > 0) {
			return segment.substring(0, index);
		} else {
			return segment;
		}
	}

	public MxNode getRoot() {
		return _getRoot(this);
	}

	private static MxNode _getRoot(final MxNode mxNode) {
		if (mxNode == null) {
			return null;
		}
		return mxNode.parent == null ? mxNode : _getRoot(mxNode.parent);
	}

	public String getValue() {
		return value;
	}

	public void setValue(final String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "MxNode{" +
				"localName='" + localName + '\'' +
				'}';
	}

	/**
	 * Prints this node tree structure in standard output
	 */
	public void print() {
		final PrintStream w = System.out;
		try {
			_print(0, getRoot(), w);
		} catch (final IOException e) {
			log.log(Level.WARNING, "exception printing node structure", e);
		}
	}

	private void _print(int level, final MxNode node, final PrintStream w) throws IOException {
		for (int i=0;i<level;i++) {
			w.write("   ".getBytes());
		}
		w.write((node.localName + "\n").getBytes());
		int nextLevel = level + 1;
		for(final MxNode child : node.children) {
			_print(nextLevel, child, w );
		}
	}

	public MxNode getParent() {
		return parent;
	}

	/**
	 * Traverse the tree from this node looking for the first node matching the given name.
	 * @param name a node name to find
	 * @return the found node or null if not found
	 * @since 7.7
	 */
	public MxNode findFirstByName(final String name) {
		return _findFirstByName(this, name);
	}

	/**
	 * Recursive implementation of the find by name
	 */
	private MxNode _findFirstByName(final MxNode node, final String name) {
		if (node == null) {
			return null;
		}
		if (StringUtils.equalsIgnoreCase(node.localName, name)) {
			return node;
		} else if (node.children != null) {
			for (final MxNode child : node.children) {
				final MxNode found = _findFirstByName(child, name);
				if (found != null) {
					return found;
				}
			}
		}
		return null;
	}

	/**
	 * @since 7.8
	 * @return returns this node children nodes
	 */
	public List<MxNode> getChildren() {
		return children;
	}

	/**
	 * @since 7.8
	 */
	public Map<String, String> getAttributes() {
		return attributes;
	}

	/**
	 * @since 7.8
	 */
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	/**
	 * Adds the given attribute to the node. 
	 * If an attribute already exist with the same local name, its value is updated.
	 * @since 7.8
	 */
	public void addAttribute(final String name, final String value) {
		if (this.attributes == null) {
			this.attributes = new HashMap<>();
		}
		this.attributes.remove(name);
		this.attributes.put(name, value);
	}

	/**
	 * @since 7.8
	 * @return found attribute value or null if not found or node does not contain attributes
	 */
	public String getAttribute(final String name) {
		if (this.attributes != null) {
			return this.attributes.get(name);
		}
		return null;
	}
	
	/**
	 * Builds this node's path up to the root element
	 * @return the absolute path of the ndoe in the form /foo/foo/foo
	 * @since 7.8 
	 */
	public String path() {
		if (this.parent == null) {
			return PATH_SEPARATOR + this.localName;
		} else {
			return this.parent.path() + PATH_SEPARATOR + this.localName;
		}
	}
}
