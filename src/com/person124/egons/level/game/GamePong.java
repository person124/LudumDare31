package com.person124.egons.level.game;

import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Game;
import com.person124.egons.level.entity.EntityEnemyPongPladdle;
import com.person124.egons.level.entity.EntityPongBall;
import com.person124.egons.level.entity.EntityPongPlayerPaddle;

public class GamePong extends Game {

	public GamePong() {
		super(Sprites.BG_BLACK);
		setPlayer(new EntityPongBall(100 - 8, 150 / 2 - 8));
		addEntity(new EntityPongPlayerPaddle(16, 16));
		addEntity(new EntityEnemyPongPladdle(200 - 32, 0));
	}
	
	public void update() {
		super.update();
	}

}
