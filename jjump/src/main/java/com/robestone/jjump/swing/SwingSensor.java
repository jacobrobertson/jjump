package com.robestone.jjump.swing;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.robestone.jjump.CycleAction;
import com.robestone.jjump.Sensor;

public class SwingSensor extends Sensor implements KeyListener {

	private Map<Integer, List<CycleAction>> keyTypedActions = new HashMap<Integer, List<CycleAction>>();
	
	private boolean[] keys = new boolean[2000];
	
	public boolean isKeyPressed(int key) {
		return keys[key];
	}

	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		keys[c] = true;
	}

	public void keyReleased(KeyEvent e) {
		int c = e.getKeyCode();
		keys[c] = false;
		int key = e.getKeyCode();
		List<CycleAction> actions = keyTypedActions.get(key);
		if (actions != null) {
			for (CycleAction action: actions) {
				action.doAction();
			}
		}
	}

	public void keyTyped(KeyEvent e) {
	}

	public void addKeyTypedAction(int key, CycleAction action) {
		List<CycleAction> actions = keyTypedActions.get(key);
		if (actions == null) {
			actions = new ArrayList<CycleAction>();
			keyTypedActions.put(key, actions);
		}
		actions.add(action);
	}
}
