package com.person124.egons.level.entity;

import com.person124.egons.EGONS;
import com.person124.egons.audio.AudioFiles;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Entity;

public class EntityTruck extends Entity {
	
	private boolean moveLeft;

	public EntityTruck(int x, int y, boolean left) {
		super(null, x, y);
		moveLeft = left;
		sprite = moveLeft ? Sprites.TRUCK_LEFT : Sprites.TRUCK_RIGHT;
	}
	
	public void update() {
		if (moveLeft) move(-1 * speed, 0, false);
		else move(1* speed, 0, false);
		
		if (EGONS.getGame().getPlayer().y == y) {
			int xa = EGONS.getGame().getPlayer().x;
			if (xa >= x && xa <= x + 16) {
				AudioFiles.hit.play();
				remove();
				EGONS.lose();
			}
		}
	}

}
