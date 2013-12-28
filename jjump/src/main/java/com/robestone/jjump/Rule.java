package com.robestone.jjump;

import java.util.List;

/**
 * For now is a marker interface.
 * @author jacob
 */
public interface Rule {

	void init(GameRunner runner);
	List<CycleAction> getActions();
	
}
