package entities;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy implements entityInterface {

	private Player player;
	private String name = "";
	private int id = 0;
	private float xPos, yPos, dx, dy = 0f;
	private float targetXPos, targetYPos = 0.0f;
	private int size, health = 0;
	private float acceleration = 0.5f;
	private float friction = 0.1f;
	private float maxSpeed = 3.0f;
	private BufferedImage avatar;

	public Enemy(Player player, int id, String name, int size, int xPos, int yPos) {
		this.player = player;
		this.id = id;
		this.name = name;
		this.size = size;
		this.xPos = xPos;
		this.yPos = yPos;
		this.health = 100;
		try {
			this.avatar = ImageIO.read(getClass().getResource("/img/zombie.png"));
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void tick() {
		moveTowardsPosition(player.getXPos(), player.getYPos());
		if (getDistanceTo(player.getXPos(), player.getYPos()) < this.size) {
			this.xPos = 0;
			this.yPos = 0;
		}
	}

	public void render(Graphics g) {
		int x = (int) this.xPos;
		int y = (int) this.yPos;
		Graphics2D g2d = (Graphics2D) g;
		AffineTransform transform = g2d.getTransform();
		// double angleToPlayer = Math.atan2(y - this.player.getYPos(), x -
		// this.player.getXPos()) - Math.PI / 2;
		double angleToPlayer = Math.atan2(y - this.player.getYPos(), x - this.player.getXPos()) - Math.PI / 2;
		g2d.rotate(angleToPlayer, x, y);
		g2d.drawImage(this.avatar, x - (this.size / 2), y - (this.size / 2), this.size, this.size, null);
		g2d.setTransform(transform);
	}

	private void moveTowardsPosition(float tx, float ty) {
		this.dx += (tx - this.xPos) / 1.0f;
		this.dy += (ty - this.yPos) / 1.0f;
		float factor = (float) (this.maxSpeed / Math.sqrt(dx * dx + dy * dy));
		this.dx *= factor;
		this.dy *= factor;
		// apply friction
		float fx = Math.signum(dx) * this.friction;
		float fy = Math.signum(dy) * this.friction;
		if (fx > Math.abs(dx)) {
			this.dx = 0.0f;
		} else {
			this.dx -= fx;
		}
		if (fy > Math.abs(dy)) {
			this.dy = 0.0f;
		} else {
			this.dy -= fy;
		}
		// set the new pos
		this.xPos += this.dx;
		this.yPos += this.dy;
	}

	private float getDistanceTo(float x, float y) {
		float distX = this.getXPos() - x;
		float distY = this.getYPos() - y;
		return (float) Math.sqrt(distX * distX + distY * distY);
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
