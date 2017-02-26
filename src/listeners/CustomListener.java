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
	private boolean isLeftPressed = false;
	private boolean isRightPressed = false;
	private boolean isUpPressed = false;
	private boolean isDownPressed = false;
	
	/* CONSTRUCTOR */
	public CustomListener(GameCanvas gameCanvas) {
		this.gameCanvas = gameCanvas;
	}
	
	public void mousePressed(MouseEvent e) {
		gameCanvas.addPlayerBullet(getMouseX(), getMouseY());
	}
	
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
	
	public void keyPressed(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	this.isLeftPressed = true;
	    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	this.isRightPressed = true;
	    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	this.isUpPressed = true;
	    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	this.isDownPressed = true;
	    }
	}
	
	public void keyReleased(KeyEvent e) {
	    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
	    	this.isLeftPressed = false;
	    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
	    	this.isRightPressed = false;
	    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
	    	this.isUpPressed = false;
	    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
	    	this.isDownPressed = false;
	    }
	}
	
	/* GETTERS AND SETTERS */
	public int getMouseX() { return mouseX; }
	public int getMouseY() { return mouseY; }
	public boolean getIsLeftPressed() { return this.isLeftPressed; }
	public boolean getIsDownPressed() { return this.isDownPressed; }
	public boolean getIsUpPressed() { return this.isUpPressed; }
	public boolean getIsRightPressed() { return this.isRightPressed; }

	/* UNUSED */
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	
}
