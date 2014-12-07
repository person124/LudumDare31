package com.person124.egons.level.entity;

import com.person124.egons.EGONS;
import com.person124.egons.audio.AudioFiles;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Entity;

public class EntityPongBall extends Entity {

	private boolean goingLeft = false;
	private int yDir, initX, initY;

	public EntityPongBall(int x, int y) {
		super(Sprites.PONG_BALL, x, y);
		initX = x;
		initY = y;
	}

	public void update() {
		if (goingLeft) move(-1 * speed, yDir, false);
		else move(1 * speed, yDir, false);

		if (x >= 168) flip(167);
		if (y >= 134 || y <= 16) yDir *= -1;

		if (x <= 0) {
			goingLeft = false;
			x = initX;
			y = initY;
			EGONS.lose();
		}
	}

	public void flip(int xa) {
		AudioFiles.bounce.play();
		x = xa;
		goingLeft = !goingLeft;
		yDir = rand.nextInt(3) - 1;
	}

}
