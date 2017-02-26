package listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import graphics.GameCanvas;

public class CustomListener implements MouseListener, MouseMotionListener, KeyListener {
	
	private GameCanvas gameCanvas;
	private int mouseX, mouseY;
	
	/* CONSTRUCTOR */
	public CustomListener(GameCanvas gameCanvas) {
		this.gameCanvas = gameCanvas;
	}
	
	public void mousePressed(MouseEvent e) {}
	
	public void keyTyped(KeyEvent e) {
		char keyChar = e.getKeyChar();
	}

	public void mouseReleased(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {}
	
	public void mouseExited(MouseEvent e) {}
	
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	/* GETTERS AND SETTERS */
	public int getMouseX() { return mouseX; }
	public int getMouseY() { return mouseY; }
	
	/* UNUSED */
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	
}
