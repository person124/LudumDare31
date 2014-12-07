package com.person124.egons;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.person124.egons.audio.AudioFiles;
import com.person124.egons.graphics.Render;
import com.person124.egons.graphics.Sprites;
import com.person124.egons.input.Keyboard;
import com.person124.egons.level.Game;
import com.person124.egons.level.game.GameFrog;
import com.person124.egons.level.game.GamePong;
import com.person124.egons.level.game.GameSpace;
import com.person124.egons.level.game.GameStatic;
import com.person124.egons.level.game.GameTitle;

public class EGONS extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	private static EGONS instance;
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
	public static int speed = 1;
	private static int lives = 3;
	private static boolean hasLost = false;

	public EGONS(int s) {
		instance = this;
		scale = s;

		frame = new JFrame();
		frame.setTitle(TITLE);
		frame.setPreferredSize(new Dimension(WIDTH * scale, HEIGHT * scale));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		createBufferStrategy(3);
		bs = getBufferStrategy();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

		key = new Keyboard();
		addKeyListener(key);
		addFocusListener(key);

		game = new GameTitle();
		makeSet();
		AudioFiles.loadAudio();

		start();
	}

	public void update() {
		if (!hasLost) game.update();
	}

	public void render() {
		Render.clear();
		Graphics g = bs.getDrawGraphics();

		game.render();
		if (!(game instanceof GameTitle)) {
			Render.renderSprite(lives > 0 ? Sprites.LIFE_FULL : Sprites.LIFE_EMPTY, 0, 0);
			Render.renderSprite(lives > 1 ? Sprites.LIFE_FULL : Sprites.LIFE_EMPTY, 16, 0);
			Render.renderSprite(lives > 2 ? Sprites.LIFE_FULL : Sprites.LIFE_EMPTY, 32, 0);
		}

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose();
		bs.show();
	}

	public static void makeSet() {
		Game[] games = new Game[] { new GameSpace(), new GamePong(), new GameFrog() };
		list = new Game[games.length];
		int i = rand.nextInt(games.length);
		list[0] = games[i];
		list[1] = i + 1 >= games.length ? games[0] : games[i + 1];
		list[2] = games[games.length - 1 - i];
	}

	public static void nextLevel() {
		if (current == 5) {
			current = -1;
			speed++;
			game = new GameStatic();
			lives = lives + 1 <= 3 ? lives + 1 : 3;
			AudioFiles.gainLife.play();
			makeSet();
		}

		if (current % 2 == 1) game = new GameStatic();
		else {
			game = list[current / 2];
		}
		current++;
	}

	public static void lose() {
		lives--;
		if (lives == -1) {
			hasLost = true;
			JOptionPane.showMessageDialog(instance, "Your score was: " + speed + ".", "Score", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
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
				frame.setTitle(TITLE + " | fps: " + fps + ", ups: " + ups + " | Speed: " + speed);
				ups = 0;
				fps = 0;
			}
		}
	}
	
	public static void setGame(Game g) {
		game = g;
	}

	public static Game getGame() {
		return game;
	}

	public synchronized void start() {
		running = true;
		thread = new Thread(this, "egons_main_thread");
		thread.start();
	}

	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new EGONS(4);
	}

}
