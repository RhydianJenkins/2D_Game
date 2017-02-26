package entities;

import java.awt.Color;
import java.awt.Graphics;

public class Bullet {
	float direction;	// 0.0 - 359.0, wraps
	float speed;	// pixels/tick
	float damage;
	float xPos;
	float yPos;
	
	public Bullet(float direction, float speed, float damage, float xPos, float yPos) {
		this.direction = direction;
		this.speed = speed;
		this.damage = damage;
		this.xPos = xPos;
		this.yPos = yPos;
	}
	
	public void tick() {
		move();
	}

	public void render(Graphics g) {
		g.setColor(new Color(0, 200, 0));
		g.fillOval((int) this.xPos-2, (int) this.yPos-2, 4, 4);
	}
	
	private void move() {
		this.xPos += Math.cos(Math.toRadians(this.direction)) * this.speed;
		this.yPos += Math.sin(Math.toRadians(this.direction)) * this.speed;
	}
}
