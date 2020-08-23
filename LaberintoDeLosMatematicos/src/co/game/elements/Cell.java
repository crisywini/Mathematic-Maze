package co.game.elements;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class Cell extends JComponent implements ICellConfiguration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean selectedCell = false;
	public Rectangle cellRectangle;
	// Sprites
	private int indexSprite;
	private BufferedImage sprites[], spriteImage;

	private Type type;
	public BufferedImage student, obstacle, road, mathematician;

	private int x, y;

	public Cell(int x, int y, Type type) {
		this.x = x;
		this.y = y;
		this.setType(type);
		indexSprite = 4;
		try {
//			student = ImageIO.read(Cell.class.getResource("/images/personaje1.png"));
			mathematician = ImageIO.read(Cell.class.getResource("/images/mathematician.png"));
//			road = ImageIO.read(Cell.class.getResource("/images/road.png"));
//			obstacle = ImageIO.read(Cell.class.getResource("/images/obstacle.png"));
			obstacle = ImageIO.read(Cell.class.getResource("/images/stone.png"));
			// Load the image
			spriteImage = ImageIO.read(Cell.class.getResource("/images/george.png"));
			sprites = new BufferedImage[4 * 4];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					sprites[(i * 4) + j] = spriteImage.getSubimage(i * WIDTH_CELL, j * HEIGHT_CELL, WIDTH_CELL,
							HEIGHT_CELL);
				}
			}
			student = sprites[indexSprite];

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void update(Graphics g) {
		switch (type) {
		case STUDENT:
			g.drawImage(sprites[indexSprite], x, y, null);
			break;
		case MATHEMATICIAN:
			g.drawImage(mathematician, x, y, null);
			break;
		case OBSTACLE:
			g.drawImage(obstacle, x, y, null);
			break;
		case ROAD:
//			g.drawImage(road, x, y, null);
			g.setColor(BACKGROUND_COLOR);
			g.fillRect(x, y, WIDTH_CELL, HEIGHT_CELL);
			break;
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
//		g.drawRect(x, y, WIDTH_CELL, HEIGHT_CELL);
//		if (selectedCell) {
//			g.fillRect(x, y, WIDTH_CELL, HEIGHT_CELL);
//		}
//		switch (type) {
//		case STUDENT:
//			g.drawImage(student, x, y, null);
//			break;
//		case MATHEMATICIAN:
//			g.drawImage(mathematician, x, y, null);
//			break;
//		case OBSTACLE:
//			g.drawImage(obstacle, x, y, null);
//			break;
//		case ROAD:
//			g.drawImage(road, x, y, null);
//			break;
		// }
		update(g);

	}

//	public void selectCell(int xp, int yp) {
//		if (cellRectangle.contains(new Point(xp, yp))) {
//			if (selectedCell) {
//				selectedCell = false;
//			} else {
//				selectedCell = true;
//			}
//		}
//	}
	/**
	 * This method allows to verify if a the click is on this cell
	 * 
	 * @param xp
	 * @param yp
	 * @return
	 */
	public boolean selectCell(int xp, int yp) {
		return cellRectangle.contains(new Point(xp, yp));
	}

	public boolean isSelectedCell() {
		return selectedCell;
	}

	public void setSelectedCell(boolean selectedCell) {
		this.selectedCell = selectedCell;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getIndexSprite() {
		return indexSprite;
	}

	public void setIndexSprite(int indexSprite) {
		this.indexSprite = indexSprite;
	}

	public BufferedImage[] getSprites() {
		return sprites;
	}

	public void setSprites(BufferedImage sprites[]) {
		this.sprites = sprites;
	}

	public BufferedImage getSpriteImage() {
		return spriteImage;
	}

	public void setSpriteImage(BufferedImage spriteImage) {
		this.spriteImage = spriteImage;
	}

}
