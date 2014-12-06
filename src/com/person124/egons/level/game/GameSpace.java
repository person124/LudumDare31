package com.person124.egons.level.game;

import java.util.Random;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Game;
import com.person124.egons.level.entity.EntityEvilSpaceShip;
import com.person124.egons.level.entity.EntitySpaceShip;

public class GameSpace extends Game {
	
	private Random rand = new Random();
	private int time, maxTime;

	public GameSpace() {
		super(Sprites.BG_SPACE);
		setPlayer(new EntitySpaceShip(100 - 8, 150 - 32));
		setTime();
		spawnEnemy();
	}
	
	public void update() {
		super.update();
		time++;
		if (time >= maxTime) {
			spawnEnemy();
			setTime();
		}
	}
	
	private void setTime() {
		maxTime = rand.nextInt(120 / EGONS.speed) + 60 / EGONS.speed;
		time = 0;
	}
	
	private void spawnEnemy() {
		addEntity(new EntityEvilSpaceShip(rand.nextInt(200 - 16), 0));
	}

}
