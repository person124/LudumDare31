package com.person124.egons.level;

import java.util.Random;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Render;
import com.person124.egons.graphics.Sprite;

public class Entity {

	public Sprite sprite;
	public int x, y;
	private boolean removed = false;

	protected int speed;
	protected Random rand;

	public Entity(Sprite sprite, int x, int y) {
		this.sprite = sprite;
		this.x = x;
		this.y = y;
		speed = EGONS.speed;
		rand = new Random();
	}

	public void update() {

	}

	public void render() {
		Render.renderSprite(sprite, x, y);
	}

	public void move(int xa, int ya, boolean check) {
		if (xa != 0 && ya != 0) {
			move(xa, 0, check);
			move(0, ya, check);
		}

		if (check) {
			if (x + xa < 0 || x + xa + sprite.WIDTH >= EGONS.WIDTH) return;
			if (y + ya < 0 || y + ya + sprite.HEIGHT >= EGONS.HEIGHT) return;
		}

		x += xa;
		y += ya;
	}

	public void remove() {
		removed = true;
	}

	public boolean isRemoved() {
		return removed;
	}

}
