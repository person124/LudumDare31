package com.person124.egons.graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {
	
	public final int WIDTH, HEIGHT;
	public final int[] PIXELS;
	
	public Sprite(String path) {
		BufferedImage image = null;
		try {
			image = ImageIO.read(Sprite.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		WIDTH = image.getWidth();
		HEIGHT = image.getHeight();
		PIXELS = new int[WIDTH * HEIGHT];
		image.getRGB(0, 0, WIDTH, HEIGHT, PIXELS, 0, WIDTH);
	}
	
	public Sprite(int w, int h, int color) {
		WIDTH = w;
		HEIGHT = h;
		PIXELS = new int[WIDTH * HEIGHT];
		for (int i = 0; i < PIXELS.length; i++) {
			PIXELS[i] = color;
		}
	}

}
