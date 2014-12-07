package com.person124.egons.level.game;

import com.person124.egons.EGONS;
import com.person124.egons.audio.AudioFiles;
import com.person124.egons.graphics.Render;
import com.person124.egons.level.Game;

public class GameStatic extends Game {
	
	private boolean audio = false;
	private int current = 0, max;

	public GameStatic() {
		super(null);
		max = 60;
	}
	
	public void update() {
		if (!audio) {
			audio = true;
			AudioFiles.noise.play();
		}
		current++;
		if (current >= max) EGONS.nextLevel();
	}
	
	public void render() {
		Render.renderStatic();
	}

}
