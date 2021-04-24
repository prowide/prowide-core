package com.prowidesoftware.swift.model;

/**
 * Message direction from SWIFT perspective.
 *
 * <p>A message direction is Input when it is sent to SWIFT, meaning it is and outbound message from the application.
 * Conversely, a message direction is Output when it is received from SWIFT, meaning it is and inbound message for the
 * application.</p>
 *
 * @since 9.1.2
 */
public enum MessageDirection {
    Input,
    Output
}
