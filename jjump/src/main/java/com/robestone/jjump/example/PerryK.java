package com.robestone.jjump.example;

import java.awt.event.KeyEvent;

import com.robestone.jjump.SimpleSprite;

public class PerryK extends SimpleSprite {

	public PerryK() {
		super("Perry Keys", "Perry_the_platypus.gif");
		setMoveKeys(KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN);
	}
	public void whilePressed_R() {
		setPosition(100, 100);
	}
	public void foreverShoes() {
		if (getSensor().isKeyPressed(KeyEvent.VK_SPACE)) {
			getCostumes().setCostume("Perry_and_shoes.gif");
		} else {
			getCostumes().setCostume("Perry_the_platypus.gif");
		}
	}
	public void foreverShow() {
		if (getSensor().isKeyPressed(KeyEvent.VK_H)) {
			hide();
		} else {
			show();
		}
	}
}
