package com.person124.egons.audio;

import java.applet.Applet;
import java.applet.AudioClip;

public class Audio {

	private AudioClip clip;

	public Audio(String path) {
		clip = Applet.newAudioClip(Audio.class.getResource(path));
	}

	public void play() {
		new Thread(new Runnable() {
			public void run() {
				clip.play();
			}
		}).start();
	}

}
