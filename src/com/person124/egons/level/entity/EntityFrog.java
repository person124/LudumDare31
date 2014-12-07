package com.person124.egons.level.entity;

import com.person124.egons.audio.AudioFiles;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.input.Keyboard;
import com.person124.egons.level.Entity;

public class EntityFrog extends Entity {

	private int time, maxTime;
	private boolean canMove = true;

	public EntityFrog(int x, int y) {
		super(Sprites.FROG_UP, x, y);
		maxTime = 30 / speed;
	}

	public void update() {
		if (canMove) {
			if (Keyboard.up && y != 19) {
				move(0, -16, false);
				Keyboard.up = false;
				sprite = Sprites.FROG_UP;
				canMove = false;
				AudioFiles.jump.play();
			} else if (Keyboard.down && y != 115) {
				move(0, 16, false);
				Keyboard.down = false;
				sprite = Sprites.FROG_DOWN;
				canMove = false;
				AudioFiles.jump.play();
			} else if (Keyboard.left && x != 12) {
				move(-16, 0, false);
				Keyboard.left = false;
				sprite = Sprites.FROG_LEFT;
				canMove = false;
				AudioFiles.jump.play();
			} else if (Keyboard.right && x != 172) {
				move(16, 0, false);
				Keyboard.right = false;
				sprite = Sprites.FROG_RIGHT;
				canMove = false;
				AudioFiles.jump.play();
			}
		} else {
			if (time <= maxTime) time++;
			else {
				time = 0;
				canMove = true;
			}
		}
	}

}
