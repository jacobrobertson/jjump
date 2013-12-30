package com.robestone.jjump.command;

public class SimpleReceiver implements Receiver {

	private Object delegate;
	private String name;
	
	public SimpleReceiver(String name) {
		this.name = name;
	}

	public SimpleReceiver(String name, Object delegate) {
		this(name);
		this.delegate = delegate;
	}
	public String getName() {
		return name;
	}

	public Object getDelegate() {
		return delegate;
	}

	public void setDelegate(Object delegate) {
		this.delegate = delegate;
	}

}
