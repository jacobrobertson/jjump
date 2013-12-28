package com.robestone.jjump;

import java.lang.reflect.Method;

public class ReflectionAction extends AbstractReflectionAction {

	private Method conditionMethod;
	
	public ReflectionAction(Object target, Method actionMethod,
			Method conditionMethod) {
		super(target, actionMethod);
		this.conditionMethod = conditionMethod;
	}

	public boolean checkCondition() {
		if (conditionMethod == null) {
			return true;
		}
		try {
			Boolean result = (Boolean) conditionMethod.invoke(target);
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
