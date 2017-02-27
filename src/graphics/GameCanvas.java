package graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

import entities.Bullet;
import entities.Enemy;
import entities.Player;
import listeners.CustomListener;

public class GameCanvas extends Canvas {
	private CustomListener listener;
	private int width, height;
	private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
	private Player player;
	private ArrayList<Bullet> bullets;
	
	public GameCanvas(int width, int height) {
		// vars
		this.width = width;
		this.height = height;
		
		// add listener
		listener = new CustomListener(this);
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		this.addKeyListener(listener);
		
		// init player
		this.player = new Player(listener, 0, "Rhydian", 50);
		
		// init bullets
		this.bullets = new ArrayList<Bullet>();
		
		// init enemies
		for (int i = 0; i < 1; i++) {
			enemies.add(new Enemy(player, 1, "Monster", 50, 100, 100));
		}
		
		// set some vars for the canvas
		this.setBackground(new Color(240, 240, 240));
		this.setBounds(0, 0, width, height);
	}
	
	public void tick() {
		// DEBUG, keep player in canvas
		if (player.getXPos() > width || player.getXPos() < 0 || player.getYPos() > height || player.getYPos() < 0) {
			player.setXPos(width / 2);
			player.setYPos(height / 2);
			player.setDirection(0.0f, 0.0f);
		}
		
		// tick player
		this.player.tick();
	
		// tick bullets
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
		
		// tick enemies
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).tick();
		}
	}

	public void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs== null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.clearRect(0, 0, this.width, this.height);
		renderEntities(g);
		g.dispose();
		bs.show();
	}
	
	private void renderEntities(Graphics g){
		// enemies
		for (int i = 0; i < this.enemies.size(); i++) {
			enemies.get(i).render(g);
		}
		// bullets
		for (int i = 0; i < this.bullets.size(); i++) {
			bullets.get(i).render(g);
		}
		// player
		this.player.render(g);
	}
	
	public void addPlayerBullet(float tx, float ty) {
		float px = this.player.getXPos();
		float py = this.player.getYPos();
		float mx = (float) this.listener.getMouseX();
		float my = (float) this.listener.getMouseY();
		
		float direction = (float) (Math.atan2(my - py, mx - px) * (180 / Math.PI));
		if (direction < 0) {
			direction += 360;
		}
		
		bullets.add(new Bullet(direction, 15.0f, 1.0f, px, py));
	}
	
	// TODO
	private float getRandXPosInsideCanvas() {
		return (float) this.width / 2;
	}
	private float getRandYPosInsideCanvas() {
		return (float) this.height / 2;
	}
	private float getRandXPosOutsideCanvas() {
		return (float) this.width / 2;
	}
	private float getRandYPosOutsideCanvas() {
		return (float) this.height / 2;
	}
}
