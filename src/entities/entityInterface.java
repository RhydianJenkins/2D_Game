package entities;

import java.awt.Graphics;

public interface entityInterface {
	void tick();
	void render(Graphics g);
	int getId();
	int getXPos();
	int getYPos();
	int getSize();
	int getHealth();
	String getName();
}
