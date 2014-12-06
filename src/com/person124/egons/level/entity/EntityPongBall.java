package com.person124.egons.level.entity;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Entity;

public class EntityPongBall extends Entity {
	
	private boolean goingLeft = false;
	private int yDir;

	public EntityPongBall(int x, int y) {
		super(Sprites.PONG_BALL, x, y);
	}
	
	public void update() {
		if (goingLeft) move(-1 * speed, yDir, false);
		else move(1 * speed, yDir, false);
		
		if (x >= 200-32) flip();
		if (y >= 142 || y <= 0) yDir *= -1;
		
		if (x <= 0) EGONS.lose();
	}
	
	public void flip() {
		goingLeft = !goingLeft;
		yDir = rand.nextInt(3) - 1;
	}

}
