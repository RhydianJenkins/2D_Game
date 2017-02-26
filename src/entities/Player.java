package entities;

import java.awt.Color;
import java.awt.Graphics;

import listeners.CustomListener;

public class Player implements entityInterface{

	private String name = "";
	private int id = 0;
	private int size, health = 0;
	private CustomListener listener;
	private float xPos, yPos, dx, dy = 0f;
	private float acceleration = 0.5f;
	private float friction = 0.2f;
	private float maxSpeed = 5.0f;
	
	public Player(CustomListener listener, int id, String name, int size) {
		this.listener = listener;
		this.id = id;
		this.name = name;
		this.size = size;
		this.xPos = 200.0f;
		this.yPos = 200.0f;
		this.health = 100;
	}
	
	public void tick() {
		move();
	}

	public void render(Graphics g) {
		int x = (int) this.xPos;
		int y = (int) this.yPos;
		g.setColor(new Color(0, 200, 0));
		g.fillOval(x, y, 50, 50);
		
		// render name
		g.drawString(this.name, x, y);
	}

	public void move() {
		// apply movement force
		if (listener.getIsUpPressed()) {
			this.dy -= this.acceleration;
			if (Math.abs(this.dy) > this.maxSpeed) {
				this.dy = -this.maxSpeed;
			}
		}
		if (listener.getIsDownPressed()) {
			this.dy += this.acceleration;
			if (Math.abs(this.dy) > this.maxSpeed) {
				this.dy = this.maxSpeed;
			}
		}
		if (listener.getIsLeftPressed()) {
			this.dx -= this.acceleration;
			if (Math.abs(this.dx) > this.maxSpeed) {
				this.dx = -this.maxSpeed;
			}
		}
		if (listener.getIsRightPressed()) {
			this.dx += this.acceleration;
			if (Math.abs(this.dx) > this.maxSpeed) {
				this.dx = this.maxSpeed;
			}
		}
		// apply friction
		float fx = Math.signum(dx) * (this.friction);
		float fy = Math.signum(dy) * (this.friction);
		this.dx -= fx;
		this.dy -= fy;
		// set the new pos
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
	public void setXPos(float xPos) {
		this.xPos = xPos;
	}
	public void setYPos(float yPos) {
		this.yPos = yPos;
	}
	public void setDirection(float dx, float dy) {
		this.dx = dx;
		this.dy = dy;
	}
	public int getSize() {
		return this.size;
	}
	public int getHealth() {
		return this.health;
	}
}