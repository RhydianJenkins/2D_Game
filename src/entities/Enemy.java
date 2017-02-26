package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Enemy implements entityInterface {
	
	private String name = "";
	private int id = 0;
	private float xPos, yPos, dx, dy = 0f;
	private int size, health = 0;
	
	public Enemy(int id, String name, int size, int xPos, int yPos) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.xPos = xPos;
		this.yPos = yPos;
		this.health = 100;
	}
	
	public void tick() {}

	public void render(Graphics g) {
		int x = (int) this.xPos;
		int y = (int) this.yPos;
		g.setColor(new Color(200, 0, 0));
		g.fillOval(x, y, this.size, this.size);
		
		// render name
		g.drawString(this.name, x, y);
	}
	
	public void updateDirections() {
		
	}
	
	public void move() {
		this.xPos += this.dx;
		this.yPos += this.dy;
	}	

	// GETTERS AND SETTERS
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public float getXPos() {
		return this.xPos;
	}
	public float getYPos() {
		return this.yPos;
	}
	public int getSize() {
		return this.size;
	}
	public int getHealth() {
		return this.health;
	}
}
