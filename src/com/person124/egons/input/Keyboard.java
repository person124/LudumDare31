package com.person124.egons.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener, FocusListener {

	public static boolean left, right, up, down;
	private static final int LEFT = KeyEvent.VK_A, RIGHT = KeyEvent.VK_D, UP = KeyEvent.VK_W, DOWN = KeyEvent.VK_S;

	public void focusGained(FocusEvent e) {

	}

	public void focusLost(FocusEvent e) {
		left = false;
		right = false;
		up = false;
		down = false;
	}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case LEFT:
				left = true;
				break;
			case RIGHT:
				right = true;
				break;
			case UP:
				up = true;
				break;
			case DOWN:
				down = true;
				break;
			default:
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case LEFT:
				left = false;
				break;
			case RIGHT:
				right = false;
				break;
			case UP:
				up = false;
				break;
			case DOWN:
				down = false;
				break;
			default:
				break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}

}
