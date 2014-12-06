package com.person124.egons.level.entity;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.input.Keyboard;
import com.person124.egons.level.Entity;

public class EntitySpaceShip extends Entity {

	private int shootTime, maxShootTime;
	private boolean canShoot = true;

	public EntitySpaceShip(int x, int y) {
		super(Sprites.STAR_SHIP, x, y);
		maxShootTime = 15 / speed;
	}

	public void update() {
		if (!canShoot) {
			if (shootTime >= maxShootTime) {
				canShoot = true;
				shootTime = 0;
			}
			else shootTime++;
		}

		if (Keyboard.left) move(-2 * speed, 0, true);
		else if (Keyboard.right) move(2 * speed, 0, true);

		if (Keyboard.up && canShoot) {
			canShoot = false;
			EGONS.getGame().addEntity(new EntitySpaceShot(x + 6, y));
		}
	}

}
