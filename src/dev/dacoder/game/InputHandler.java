package dev.dacoder.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputHandler implements KeyListener {

	public InputHandler(Game game) {
		game.addKeyListener(this);
	}

	class Key {
		private int numTimesPressed = 0;
		private boolean pressed = false;

		public boolean isPressed() {
			return pressed;
		}

		public int getNumTimesPressed() {
			return numTimesPressed;
		}

		public void toggle(boolean pressed) {
			this.pressed = pressed;
			if (pressed)
				numTimesPressed++;
		}
	}

	public Key up = new Key();
	public Key down = new Key();
	public Key left = new Key();
	public Key right = new Key();

	@Override
	public void keyPressed(KeyEvent e) {
		toggleKey(e.getKeyCode(), true);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		toggleKey(e.getKeyCode(), false);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	public void toggleKey(int keyCode, boolean pressed) {
		if (keyCode == KeyEvent.VK_UP || keyCode == KeyEvent.VK_W) {
			up.toggle(pressed);
		}
		if (keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_S) {
			down.toggle(pressed);
		}
		if (keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_A) {
			left.toggle(pressed);
		}
		if (keyCode == KeyEvent.VK_RIGHT || keyCode == KeyEvent.VK_D) {
			right.toggle(pressed);
		}
	}

}
