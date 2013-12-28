package com.robestone.jjump;

import java.lang.reflect.Method;

public class AbstractReflectionAction extends ConditionalCycleAction {

	private Method actionMethod;
	protected Object target;

	public AbstractReflectionAction(Object target, Method actionMethod) {
		this.target = target;
		this.actionMethod = actionMethod;
	}

	public void doInnerAction() {
		try {
			actionMethod.invoke(target);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
}
