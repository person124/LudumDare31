package com.person124.egons.graphics;

import java.util.Random;

import com.person124.egons.EGONS;

public class Render {

	private static Random rand = new Random();

	public static void clear() {
		for (int i = 0; i < EGONS.pixels.length; i++) {
			EGONS.pixels[i] = 0xff00ff;
		}
	}

	public static void renderStatic() {
		for (int i = 0; i < EGONS.pixels.length; i++) {
			EGONS.pixels[i] = rand.nextBoolean() ? 0 : 0xffffff;
		}
	}

	public static void renderSprite(Sprite s, int xp, int yp) {
		for (int y = 0; y < s.HEIGHT; y++) {
			int ya = y + yp;
			for (int x = 0; x < s.WIDTH; x++) {
				int xa = x + xp;

				if (xa < -s.WIDTH || xa >= EGONS.WIDTH || ya < 0 || ya >= EGONS.HEIGHT) break;
				if (xa < 0) xa = 0;

				int col = s.PIXELS[x + y * s.WIDTH];
				if (col != 0xffff00ff) EGONS.pixels[xa + ya * EGONS.WIDTH] = s.PIXELS[x + y * s.WIDTH];
			}
		}
	}
	
	public static void renderBG(Sprite s) {
		if (s == null) return;
		for (int i = 0; i < s.PIXELS.length; i++) {
			EGONS.pixels[i] = s.PIXELS[i];
		}
	}

}
