package com.robestone.jjump.example;

import com.robestone.jjump.EdgeBehavior;
import com.robestone.jjump.SimpleSprite;

public class PerryB extends SimpleSprite {

	public PerryB() {
		super("Perry Bounce", "Perry_the_platypus.gif");
		setEdgeBehavior(EdgeBehavior.Bounce);
		setPosition(250, 250);
		setMoving(1, 1);
	}
	public void foreverBounceOnPerry() {
		if (getSensor().isTouching("Perry Bounce", "Perry Keys")) {
			setVelocity(-getXVelocity(), -getYVelocity());
		}
	}
	public void foreverDieOnBlob() {
		if (getSensor().isTouching("Perry Bounce", "Evil Blob")) {
			getCostumes().setCostume("Perry_the_dead_platypus.gif");
		} else {
			getCostumes().setCostume("Perry_the_platypus.gif");
		}
	}

}
