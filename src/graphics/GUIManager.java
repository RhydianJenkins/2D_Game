package graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

public class GUIManager extends JFrame {

	public static final int SCALE = 4;
	public static final int WIDTH = 256 * SCALE;
	public static final int HEIGHT = WIDTH / 12 * 9;

	public GameCanvas gameCanvas;

	public GUIManager() {
		Dimension d1 = new Dimension(WIDTH, HEIGHT);
		setMinimumSize(d1);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setFocusable(true);
		this.requestFocus();

		gameCanvas = new GameCanvas(WIDTH, HEIGHT);

		this.add(gameCanvas);
		this.pack();
	}

	public void tick() {
		gameCanvas.tick();
	}

	public void render() {
		gameCanvas.render();
	}

}
