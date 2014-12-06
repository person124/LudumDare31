package com.person124.egons;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;

import com.person124.egons.graphics.Render;
import com.person124.egons.input.Keyboard;
import com.person124.egons.level.Game;
import com.person124.egons.level.game.GamePong;
import com.person124.egons.level.game.GameSpace;

public class EGONS extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private static Random rand = new Random();

	public static final String TITLE = "Entire Game on One Screen";
	public static final int WIDTH = 200, HEIGHT = 150;
	private static int scale;
	private boolean running = false;
	private JFrame frame;
	private BufferStrategy bs;
	private static BufferedImage image;
	public static int[] pixels;
	private Thread thread;

	private static int current = 0;
	private static Game[] list;
	private static Game game;
	private Keyboard key;
	public static int speed = 2;

	public EGONS(int s) {
		scale = s;

		frame = new JFrame();
		frame.setTitle(TITLE);
		frame.setPreferredSize(new Dimension(WIDTH * scale, HEIGHT * scale));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setResizable(true);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		createBufferStrategy(3);
		bs = getBufferStrategy();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		key = new Keyboard();
		addKeyListener(key);
		addFocusListener(key);

		game = new GamePong();

		start();
	}

	public void update() {
		game.update();
	}

	public void render() {
		Render.clear();
		Graphics g = bs.getDrawGraphics();

		game.render();

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void makeSet() {
		Game[] games = new Game[] { new GameSpace() };
		list = new Game[games.length];
		while (true) {
			
		}
	}

	public static void nextLevel() {

	}

	public static void lose() {
		System.out.println("LOST!");
	}

	public void run() {
		long lastTime = System.nanoTime(), now;
		final double NS = 1000000000.0 / 60.0;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int fps = 0, ups = 0;
		requestFocus();
		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / NS;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
				ups++;
			}
			render();
			fps++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				frame.setTitle(TITLE + " | fps: " + fps + ", ups: " + ups);
				ups = 0;
				fps = 0;
			}
		}
	}

	public static Game getGame() {
		return game;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EGONS(4);
	}

}
