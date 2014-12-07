package com.person124.egons.level.game;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Render;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.input.Keyboard;
import com.person124.egons.level.Game;

public class GameTitle extends Game {

	public GameTitle() {
		super(Sprites.BG_TITLE);
	}
	
	public void update() {
		if (Keyboard.up) {
			EGONS.setGame(new GameStatic());
		}
	}
	
	public void render() {
		Render.renderBG(BG);
	}

}
