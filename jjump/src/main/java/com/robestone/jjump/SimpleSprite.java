package com.robestone.jjump;

import java.util.ArrayList;
import java.util.List;

/**
 * A very basic sprite that simply keeps track of the position.
 * @author jacob
 */
public class SimpleSprite implements MoveableSprite, ImageSprite {

	private int x;
	private int y;

	private int xVelocity;
	private int yVelocity;
	
	private boolean moving;
	
	private SpriteXYMove spriteXYMove = new SpriteXYMove();

	private String name;
	private String costume;
	
	private boolean visible = true;
	
	private List<CycleAction> actions = new ArrayList<CycleAction>();
	private GameRunner runner;
	
	public SimpleSprite(String name, String costume) {
		this.name = name;
		this.costume = costume;
		this.spriteXYMove.sprite = this;
		this.spriteXYMove.edgeBehavior = EdgeBehavior.Stick;
	}
	
	public GameRunner getGameRunner() {
		return runner;
	}
	public Sensor getSensor() {
		return runner.getSensor();
	}
	
	public void init(GameRunner runner) {
		this.runner = runner;
	}

	public List<CycleAction> getActions() {
		return actions;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public void changePosition(int xChange, int yChange) {
		setPosition(x + xChange, y + yChange);
	}

	public void changeVelocity(int xChange, int yChange) {
		setVelocity(xVelocity + xChange, yVelocity + yChange);
	}

	public void setPosition(int newX, int newY) {
		if (runner == null) {
			this.x = newX;
			this.y = newY;
			return;
		}
	
		spriteXYMove.oldX = x;
		spriteXYMove.oldY = y;
		spriteXYMove.newX = newX;
		spriteXYMove.newY = newY;
		spriteXYMove.allowed = true;

		
		runner.getSensor().decide(spriteXYMove);
		
		this.x = spriteXYMove.newX;
		this.y = spriteXYMove.newY;
		
	}

	public String getName() {
		return name;
	}

	public void setCostume(String costume) {
		this.costume = costume;
	}
	public String getCostume() {
		return costume;
	}
	public int getXVelocity() {
		return xVelocity;
	}

	public int getYVelocity() {
		return yVelocity;
	}

	public void setVelocity(int xVelocity, int yVelocity) {
		this.xVelocity = xVelocity;
		this.yVelocity = yVelocity;
	}

	public EdgeBehavior getEdgeBehavior() {
		return spriteXYMove.edgeBehavior;
	}

	public void setEdgeBehavior(EdgeBehavior edgeBehavior) {
		spriteXYMove.edgeBehavior = edgeBehavior;
	}
	
	public void setMoving(int xVelocity, int yVelocity) {
		setMoving(true);
		setVelocity(xVelocity, yVelocity);
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public void move() {
		changePosition(getXVelocity(), getYVelocity());
	}
	public void moveAction() {
		if (moving) {
			move();
		}
	}
	public void setMoveKeys(int left, int right, int up, int down) {
		setMoveKeys(left, right, up, down, false);
	}
	public void setMoveKeys(int left, int right, int up, int down, boolean useSpriteVelocity) {
		actions.add(new SimpleMoveAction(this, -1, 0, left, useSpriteVelocity));
		actions.add(new SimpleMoveAction(this, 1, 0, right, useSpriteVelocity));
		actions.add(new SimpleMoveAction(this, 0, -1, up, useSpriteVelocity));
		actions.add(new SimpleMoveAction(this, 0, 1, down, useSpriteVelocity));
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public void hide() {
		visible = false;
	}
	public void show() {
		visible = true;
	}
}
