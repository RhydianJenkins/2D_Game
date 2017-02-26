package entities;

import java.awt.Graphics;

public interface entityInterface {
	void tick();
	void render(Graphics g);
	void move();
	int getId();
	float getXPos();
	float getYPos();
	int getSize();
	int getHealth();
	String getName();
}
