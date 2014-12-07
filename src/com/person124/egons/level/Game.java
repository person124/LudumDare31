package com.person124.egons.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.person124.egons.EGONS;
import com.person124.egons.graphics.Render;
import com.person124.egons.graphics.Sprite;

public class Game {

	public final Sprite BG;
	private Entity player;
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Entity> entitiesToRemove = new ArrayList<Entity>();
	protected int maxTick;
	private int tick;

	protected Random rand;

	public Game(Sprite background) {
		BG = background;
		rand = new Random();
	}

	public void update() {
		player.update();
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
			if (entities.get(i).isRemoved()) entitiesToRemove.add(entities.get(i));
		}
		if (entitiesToRemove.size() > 0) {
			entities.removeAll(entitiesToRemove);
			entitiesToRemove.clear();
		}
	}

	public void render() {
		Render.renderBG(BG);
		for (Entity e : entities) {
			e.render();
		}
		player.render();
	}

	public void tickForTime() {
		tick++;
		if (tick >= maxTick) EGONS.nextLevel();
	}

	public void setPlayer(Entity e) {
		player = e;
	}

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public Entity getPlayer() {
		return player;
	}

}
