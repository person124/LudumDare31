package com.person124.egons.level.entity;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.input.Keyboard;
import com.person124.egons.level.Entity;

public class EntityPongPlayerPaddle extends Entity {

	public EntityPongPlayerPaddle(int x, int y) {
		super(Sprites.PONG_PADDLE, x, y);
	}
	
	public void update() {
		if (Keyboard.up) move(0, -2 * speed, true);
		else if (Keyboard.down) move(0, 2 * speed, true);
		
		int xp = EGONS.getGame().getPlayer().x;
		int yp = EGONS.getGame().getPlayer().y;
		if (xp <= 24 && xp >= 16) {
			if (yp >= y && yp <= y + 32) ((EntityPongBall) EGONS.getGame().getPlayer()).flip(25);
		}
	}

}
