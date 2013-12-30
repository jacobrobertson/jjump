package com.robestone.jjump.command;

/**
 * Allows for lazy-loading of the actual receiver.
 * For example, we can build a chain of commands without having the receiver itself initialized.
 * @author Jacob.Robertson
 */
public interface Receiver {

	String getName();
	Object getDelegate();
	void setDelegate(Object delegate);
	
}
