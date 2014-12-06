package com.person124.egons.level.entity;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.level.Entity;

public class EntityEnemyPongPladdle extends Entity {

	public EntityEnemyPongPladdle(int x, int y) {
		super(Sprites.PONG_PADDLE, x, y);
	}

	public void update() {
		y = EGONS.getGame().getPlayer().y - 12;
	}

}
