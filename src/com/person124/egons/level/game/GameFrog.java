package com.person124.egons.level.game;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Game;
import com.person124.egons.level.entity.EntityFrog;
import com.person124.egons.level.entity.EntityTruck;

public class GameFrog extends Game {
	
	private int[] ints = new int[] {19, 35, 51, 67, 83, 99, 115};
	private int time, maxTime;

	public GameFrog() {
		super(Sprites.BG_ROAD);
		setPlayer(new EntityFrog(100 - 8, 75 - 8));
		maxTime = 60 * 2 / EGONS.speed;
		spawnTruck();
		spawnTruck();
		spawnTruck();
		maxTick = 60 * 20 / EGONS.speed;
	}
	
	public void update() {
		super.update();
		tickForTime();
		
		time++;
		if (time >= maxTime) {
			time = 0;
			spawnTruck();
			spawnTruck();
			spawnTruck();
		}
	}
	
	public void spawnTruck() {
		int y = ints[rand.nextInt(ints.length)];
		boolean left = rand.nextBoolean();
		addEntity(new EntityTruck(left ? 200 : -16, y, left));
	}

}
