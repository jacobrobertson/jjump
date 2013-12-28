package com.robestone.jjump;

import java.lang.reflect.Method;

public class KeyPressedReflectionAction extends AbstractReflectionAction {

	private int key;
	
	public KeyPressedReflectionAction(Object target, Method actionMethod, int key) {
		super(target, actionMethod);
		this.key = key;
	}

	public boolean checkCondition() {
		return getGameRunner().getSensor().isKeyPressed(key);
	}
	
}
