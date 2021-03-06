/*
 * Main class. Responsible for running the simulator. Contains the engine that 
 * controls the ticks and renders of the overall system.
 */

package engine;

import graphics.GUIManager;

public class main implements Runnable {

	public static final int DESIREDTICKS = 60;

	public GUIManager gui = new GUIManager();
	public boolean running = false;

	public main() {
	}

	public void tick() {
		gui.tick();
	}

	public void render() {
		gui.render();
	}

	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}

	public synchronized void stop() {
		running = false;
	}

	public void run() {
		long lastTimeNs = System.nanoTime();
		long lastTimeMs = System.currentTimeMillis();
		long now = lastTimeNs;
		double tickIfMoreThan1 = 0;
		double nsPerTick = 1000000000D / DESIREDTICKS;
		int tickNo = 0, frameNo = 0;
		boolean shouldRender = true;

		while (running) {
			now = System.nanoTime();
			tickIfMoreThan1 += (now - lastTimeNs) / nsPerTick;
			;
			lastTimeNs = now;

			while (tickIfMoreThan1 >= 1) {
				tickNo++;
				tick();
				tickIfMoreThan1 -= 1;
				shouldRender = true;
			}

			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (shouldRender) {
				render();
				frameNo++;
				shouldRender = false;
			}

			// once per second update the title and reset counters
			if (System.currentTimeMillis() - lastTimeMs >= 1000) {
				gui.setTitle(tickNo + " ticks, " + frameNo + " FPS");
				lastTimeMs += 1000;
				frameNo = 0;
				tickNo = 0;
			}
		}

		System.exit(1);
	}

	public static void main(String[] args) {
		new main().start();
	}

}
