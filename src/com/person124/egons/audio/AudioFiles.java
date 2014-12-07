package com.person124.egons.audio;

public class AudioFiles {
	
	//Misc
	public static Audio noise;
	public static Audio gainLife;
	
	//Space
	public static Audio shoot;
	public static Audio pExplode;
	public static Audio explode;
	
	//Pong
	public static Audio bounce;
	
	//Frog
	public static Audio jump;
	public static Audio hit;
	
	public static void loadAudio() {
		noise = new Audio("/sounds/static.wav");
		gainLife = new Audio("/sounds/gainhealth.wav");
		
		shoot = new Audio("/sounds/shoot.wav");
		pExplode = new Audio("/sounds/pexplode.wav");
		explode = new Audio("/sounds/explode.wav");
		
		bounce = new Audio("/sounds/bounce.wav");
		
		jump = new Audio("/sounds/jump.wav");
		hit = new Audio("/sounds/hit.wav");
	}

}
