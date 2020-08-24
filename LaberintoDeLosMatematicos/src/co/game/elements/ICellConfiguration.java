package co.game.elements;

import java.awt.Color;
import java.util.Random;
/**
 * https://elandroidefeliz.com/lista-top-10-los-mejores-sprites-gratuitos/
 * https://www.spriters-resource.com/ds_dsi/
 * @author Crisi
 *
 */
public interface ICellConfiguration {
	
	public final int WIDTH_CELL_MATH = 47;// Para los sprites se debe poner en 32
	public final int HEIGHT_CELL_MATH = 47;// Para los sprites se debe poner en 32
	
	public final int WIDTH_CELL = 48;// Para los sprites se debe poner en 32
	public final int HEIGHT_CELL = 48;// Para los sprites se debe poner en 32
	public final int WIDTH_VIRTUAL_WORLD = 16;
	public final int HEIGHT_VIRTUAL_WORLD = 10;
	public final int HEIGHT_SCREEN = 180;
	public final int WIDTH_SCREEN = 180;
	public final int ALFA = 127;
	
	public final Color BACKGROUND_COLOR = new Color(153, 217, 234, ALFA);
	public final String PATH = "file:///" + System.getProperty("user.dir");// Proporciona la ruta absoluta del proyecto

	default int getRandomInt(int min, int max) {
		Random random = new Random();
		int randomNumber = random.nextInt((max - min) + 1) + min;
		return randomNumber;
	}

}
