package com.person124.egons.level.entity;

import java.util.Random;

import com.person124.egons.EGONS;
import com.person124.egons.IDK;
import com.person124.egons.audio.AudioFiles;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Entity;

public class EntityEvilSpaceShip extends Entity {

	private Random rand = new Random();
	private int action, time, maxTime;

	public EntityEvilSpaceShip(int x, int y) {
		super(Sprites.EVIL_STAR_SHIP, x, y);
		action = rand.nextInt(4);
		maxTime = 45;
	}

	public void update() {
		if (action > 2) {
			if (action == 3) move(-1 * speed, 0, true);
			if (action == 4) move(1 * speed, 0, true);

			time++;
			if (time >= maxTime) {
				time = 0;
				action = action == 3 ? 4 : 3;
			}
		}
		move(0, 1 * speed, false);

		if (y > EGONS.HEIGHT + 16) remove();

		if (IDK.getDistance(EGONS.getGame().getPlayer().x, EGONS.getGame().getPlayer().y, x, y) <= 8) {
			remove();
			AudioFiles.pExplode.play();
			EGONS.lose();
		}
	}

}
