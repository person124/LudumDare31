package com.person124.egons.level;

import java.util.ArrayList;
import java.util.List;

import com.person124.egons.graphics.Render;
import com.person124.egons.graphics.Sprite;

public class Game {

	public final Sprite BG;
	private Entity player;
	private List<Entity> entities = new ArrayList<Entity>();
	private List<Entity> entitiesToRemove = new ArrayList<Entity>();

	public Game(Sprite background) {
		BG = background;
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
