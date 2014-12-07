package com.person124.egons.audio;

import java.applet.Applet;
import java.applet.AudioClip;

public class Audio {

	private String path;
	private AudioClip clip;

	public Audio(String path) {
		this.path = path;
		try {
			clip = Applet.newAudioClip(Audio.class.getResource(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		new Thread(new Runnable() {
			public void run() {
				clip.play();
			}
		});
	}

	public void loop() {
		clip.loop();
	}

	public void stop() {
		clip.stop();
	}

}
