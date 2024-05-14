package ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * This class is the base class for all the Bars. 
 * It contains all common elements of an Animal.
 */
public class Bar {

	/**
	 * x position of the bar.
	 */
	private int x;
	/**
	 * y position of the bar.
	 */
	private int y;
	/**
	 * bar width.
	 */
	private int width;
	/**
	 * bar height.
	 */
	private int height;
	/**
	 * initialize fields.
	 */
	public Bar(int x, int y, int width, int height) { 

		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}
	/**
	 * draw a reaction when the button has got an action.
	 */
	public void drawButtonFeedback(GraphicsContext gc, MyButton b) { 

		// MouseOver
		if (b.isMouseOver()) {
			gc.setStroke(Color.WHITE);
		}
		else {
			gc.setStroke(Color.BLACK);
		}

		// Border
		gc.strokeRect(b.getX(), b.getY(), b.getWidth(), b.getHeight());

		// MousePressed
		if (b.isMousePressed()) {
			gc.strokeRect(b.getX() + 1, b.getY() + 1, b.getWidth() - 2, b.getHeight() - 2);
			gc.strokeRect(b.getX() + 2, b.getY() + 2, b.getWidth() - 4, b.getHeight() - 4);
		}
	}
	/**
	 * getter for x
	 * @return x x
	 */
	public int getX() { 

		return x;
	}
	/**
	 * getter for y
	 * @return y y
	 */
	public int getY() { 

		return y;
	}
	/**
	 * getter for width
	 * @return width width
	 */
	public int getWidth() { 

		return width;
	}
	/**
	 * getter for height
	 * @return height
	 */
	public int getHeight() { 

		return height;
	}
}
