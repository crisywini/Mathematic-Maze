package co.game.elements;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyCanvas extends Canvas implements ICellConfiguration {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Image backgroundImage;
	private Maze maze;
	//Double buffer
	public Graphics bufferGraphic;
	public Image bufferImage;

	public MyCanvas() {
		maze = new Maze();
		try {
			backgroundImage = ImageIO.read(MyCanvas.class.getResource("/images/background4.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setBackground(Color.green);
		this.setSize(maze.getWidth(), maze.getHeight());
		addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				maze.moveCell(e);
				repaint();
			}
		});
	}

	@Override
	public void update(Graphics g) {
		
		if(bufferGraphic==null) {
			bufferImage = createImage(this.getWidth(), this.getHeight());
			bufferGraphic = bufferImage.getGraphics();
		}
		bufferGraphic.setColor(getBackground());
		bufferGraphic.fillRect(0, 0, this.getWidth(), this.getHeight());
		bufferGraphic.drawImage(backgroundImage, 0, 0, null);
		maze.update(bufferGraphic);
		g.drawImage(bufferImage, 0, 0, null);
//		maze.paintComponent(g);
	}
	@Override
	public void paint(Graphics g) {
		update(g);
	}

	public void activateCells(MouseEvent evt) {
		for (int i = 0; i < WIDTH_VIRTUAL_WORLD; i++) {
			for (int j = 0; j < HEIGHT_VIRTUAL_WORLD; j++) {
//				maze.getCells()[i][j].selectCell(evt.getX(), evt.getY());
				if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
					System.out.println("Botón derecho- se agrega un obstaculo");
					maze.getCells()[i][j].setType(Type.OBSTACLE);
				} else {
					System.out.println("Botón izquierdo- se pone un adversario");
					maze.getCells()[i][j].setType(Type.MATHEMATICIAN);
				}
			}
		}
	}

	public Image getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(Image backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

}
