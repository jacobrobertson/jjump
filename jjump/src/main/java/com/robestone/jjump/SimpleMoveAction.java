package com.robestone.jjump;

public class SimpleMoveAction extends ConditionalCycleAction {

	private int xd;
	private int yd;
	private int key;
	private MoveableSprite sprite;
	private boolean useSpriteVelocity;
	
	public SimpleMoveAction(MoveableSprite sprite, int xd, int yd, int key, boolean useSpriteVelocity) {
		this.sprite = sprite;
		this.xd = xd;
		this.yd = yd;
		this.key = key;
		this.useSpriteVelocity = useSpriteVelocity;
	}

	@Override
	public void doInnerAction() {
		int xChange = xd;
		int yChange = yd;
		if (useSpriteVelocity) {
			xChange = xChange * sprite.getXVelocity();
			yChange = yChange * sprite.getYVelocity();
		}
		sprite.changePosition(xChange, yChange);
	}

	@Override
	public boolean checkCondition() {
		return getGameRunner().getSensor().isKeyPressed(key);
	}

}
