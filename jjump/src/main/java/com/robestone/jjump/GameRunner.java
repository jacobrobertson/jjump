package com.robestone.jjump;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class GameRunner {

	private List<Rule> rules;
	private Screen screen;
	private ActionBuilder actionBuilder;
	private Sensor sensor;
	
	private class SpriteRoom {
		Sprite sprite;
		Room room;
	}
	private Map<String, Room> rooms = new HashMap<String, Room>();
	private List<Room> roomsList = new ArrayList<Room>();

	private List<SpriteRoom> spriteRoomPairs = new ArrayList<SpriteRoom>();
	
	public GameRunner(Screen screen, ActionBuilder actionBuilder, Sensor sensor) {
		this.rules = new ArrayList<Rule>();
		this.screen = screen;
		this.actionBuilder = actionBuilder;
		this.sensor = sensor;
		addRoom(screen);
	}
	
	public void putInRoom(Sprite sprite, Room room) {
		putInRoom(sprite.getName(), room.getName());
	}
	public void putInRoom(String spriteName, String roomName) {
		Room newRoom = rooms.get(roomName);
		Sprite sprite = getSprite(spriteName);
		
		SpriteRoom found = null;
		for (SpriteRoom sr: spriteRoomPairs) {
			if (sr.sprite == sprite) {
				found = sr;
			}
		}
		if (found == null) {
			found = new SpriteRoom();
			spriteRoomPairs.add(found);
		}
		found.room = newRoom;
		found.sprite = sprite;
	}
	public Iterable<Room> getRooms() {
		return roomsList;
	}
	public void addRoom(Room room) {
		rooms.put(room.getName(), room);
		roomsList.add(room);
		room.init(this);
		sensor.addMoveDecider(room.getMoveDecider());
	}
	public Room getRoom(String name) {
		return rooms.get(name);
	}
	public Room getRoom(Sprite sprite) {
		for (SpriteRoom sr: spriteRoomPairs) {
			if (sr.sprite == sprite) {
				return sr.room;
			}
		}
		return screen;
	}

	
	public Sprite getSprite(String name) {
		for (Rule rule: rules) {
			if (rule instanceof Sprite) {
				Sprite sprite = (Sprite) rule;
				if (sprite.getName().equals(name)) {
					return sprite;
				}
			}
		}
		return null;
	}
	public Sensor getSensor() {
		return sensor;
	}
	public List<Rule> getRules() {
		return rules;
	}
	public Screen getScreen() {
		return screen;
	}
	public void runGame() {
		initGame();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				doRunCycle();
			}
		};
		new Timer().schedule(task, 0, 10);
	}
	void doRunCycle() {
		runCycle();
		paint();
	}
	private void initGame() {
		sensor.init(this);
		for (Rule rule: rules) {
			rule.init(this);
			for (CycleAction action: rule.getActions()) {
				action.init(this);
			}
			actionBuilder.initActions(this, rule);
		}
	}
	public void paint() {
		screen.paintCycle();
	}
	public boolean checkGameEndCondition() {
		return true;
	}
	
	public void runCycle() {
		// check each rule and run each do method
		for (Rule rule: rules) {
			runRule(rule);
		}
	}
	
	public void runRule(Rule rule) {
		for (CycleAction action: rule.getActions()) {
			action.doAction();
		}
	}
}
