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

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.util.ArrayList;
import java.util.List;

/**
 * Node that identifies a sequence inside a message.
 * Messages may define an arbitrary amount of sequences and nested subsequences.
 * These structures are modeled here as a tree.
 * 
 * @since 6.3
 * @deprecated to retrieve fields in sequences use the AbstractMT model
 */
@Deprecated
@ProwideDeprecated(phase3 = TargetYear.SRU2020)
public class SequenceNode {
	private final String name;
	private final List<SequenceNode> children = new ArrayList<>();
	private final SequenceNode parent;
	
	private SequenceNode(final String name, final SequenceNode parent) {
		this.name = name;
		this.parent = parent;
		DeprecationUtils.phase2(getClass(), "getParsedSequences()", "This is part of an discarded attempt to provide a structured model in the SwiftMessage object, it is still kept for backward compatibility but should not be used");
	}
	
	/**
	 * get the name of this sequence
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Adds a sequence to this node
	 * @param name the name of the sequence to add
	 * @return the newly created sequence
	 */
	public SequenceNode addChild(String name) {
		final SequenceNode o = new SequenceNode(name, this);
		this.children.add(o);
		return o;
	}
	
	/**
	 * Creates a root node. this must be the main entry point of all sequences
	 */
	public static SequenceNode newRootNode() {
		return new SequenceNode("main", null);
	}

	public SequenceNode getParent() {
		return parent;
	}

	public List<SequenceNode> getChildren() {
		return children;
	}

}
