package com.robestone.jjump;

/**
 * Each cycle, the game will check every action.
 * 
 * @author jacob
 */
public class ConditionalCycleAction implements CycleAction {

	private GameRunner runner;
	
	public void init(GameRunner runner) {
		this.runner = runner;
	}

	public GameRunner getGameRunner() {
		return runner;
	}
	
	public final void doAction() {
		if (checkCondition()) {
			doInnerAction();
		}
	}
	public void doInnerAction() {
	}
	public boolean checkCondition() {
		return true;
	}
	
}
