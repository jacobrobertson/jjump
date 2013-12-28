package com.robestone.jjump;

import java.awt.event.KeyEvent;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionActionBuilder implements ActionBuilder {

	public void initActions(GameRunner runner, Rule rule) {
		Class<? extends Rule> cls = rule.getClass();
		Method[] methods = cls.getMethods();
		for (Method method: methods) {
			CycleAction action = buildAction(runner, rule, method, methods);
			if (action != null) {
				action.init(runner);
				rule.getActions().add(action);
			}
		}
	}
	private CycleAction buildAction(GameRunner runner, Rule rule, Method method, Method[] methods) {
		String name = method.getName();
		if (name.endsWith("Action")) {
			name = name.substring(0, name.length() -6);
			String conditionName = name + "Condition";
			Method conditionMethod = null;
			for (Method m: methods) {
				if (m.getName().equals(conditionName)) {
					conditionMethod = m;
					break;
				}
			}
			return new ReflectionAction(rule, method, conditionMethod);
		} else if (name.startsWith("whilePressed_")) {
			int keyValue = getKey(name);
			return new KeyPressedReflectionAction(rule, method, keyValue);
		} else if (name.startsWith("ifTyped_")) {
			int keyValue = getKey(name);
			CycleAction action = new AbstractReflectionAction(rule, method);
			runner.getSensor().addKeyTypedAction(keyValue, action);
			return null;
		} else if (name.startsWith("forever")) {
			return new ReflectionAction(rule, method, null);
		}
		return null;
	}
	private int getKey(String methodName) {
		int pos = methodName.indexOf('_');
		String keyName = methodName.substring(pos + 1);
		Class<KeyEvent> keyEventClass = KeyEvent.class;
		try {
			Field field = keyEventClass.getField("VK_" + keyName.toUpperCase());
			int keyValue = field.getInt(null);
			return keyValue;
		} catch (Exception e) {
			throw new IllegalArgumentException("The method '" + methodName + "' confused me...");
		}
	}
	

}
