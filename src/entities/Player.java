package entities;

import java.awt.Color;
import java.awt.Graphics;

import listeners.CustomListener;

public class Player implements entityInterface{

	private String name = "";
	private int id = 0;
	private int size, xPos, yPos, health = 0;
	private CustomListener listener;
	
	public Player(CustomListener listener, int id, String name, int size, int xPos, int yPos) {
		this.listener = listener;
		this.id = id;
		this.name = name;
		this.size = size;
		this.xPos = xPos;
		this.yPos = yPos;
		this.health = 100;
	}
	
	public void tick() {}

	public void render(Graphics g) {
		g.setColor(new Color(0, 200, 0));
		g.fillOval(this.xPos, this.yPos, 50, 50);
		
		// render name
		g.drawString(this.name, this.xPos, this.yPos);
	}
	
	// GETTERS AND SETTERS
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getXPos() {
		return this.xPos;
	}
	public int getYPos() {
		return this.yPos;
	}
	public int getSize() {
		return this.size;
	}
	public int getHealth() {
		return this.health;
	}	
}
