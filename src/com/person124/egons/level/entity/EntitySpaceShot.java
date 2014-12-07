package com.person124.egons.level.entity;

import com.person124.egons.EGONS;
import com.person124.egons.IDK;
import com.person124.egons.audio.AudioFiles;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Entity;

public class EntitySpaceShot extends Entity {

	public EntitySpaceShot(int x, int y) {
		super(Sprites.SPACE_SHOOT, x, y);
	}
	
	public void update() {
		move(0, -2 * speed, false);
		
		for (Entity e : EGONS.getGame().getEntities()) {
			if (e instanceof EntityEvilSpaceShip) {
				if (IDK.getDistance(e.x, e.y, x, y) <= 8) {
					AudioFiles.explode.play();
					e.remove();
					remove();
				}
			}
		}
	}

}
