package com.robestone.jjump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Encapsulates a list of costumes that can be manipulated.
 * 
 * @author Jacob
 */
public class Costumes {

	/*
	Costume next();
	Costume previous();
	*/
	
	private List<Costume> costumes;
	private Map<String, Costume> costumeMap = new HashMap<String, Costume>();
	private String currentCostume;
	
	public Costumes() {
		costumes = new ArrayList<Costume>();
	}
	public Costumes(List<Costume> costumes) {
		this();
		for (Costume costume: costumes) {
			addCostume(costume);
		}
	}
	public void addCostume(Costume costume) {
		if (currentCostume == null) {
			currentCostume = costume.getName();
		}
		costumes.add(costume);
		costumeMap.put(costume.getName(), costume);
	}
	public void setCostume(String name) {
		currentCostume = name;
	}
	public Costume getCostume(String name) {
		return costumeMap.get(name);
	}
	public Costume getCostume() {
		return getCostume(currentCostume);
	}

	public List<Costume> getCostumes() {
		return costumes;
	}

}
