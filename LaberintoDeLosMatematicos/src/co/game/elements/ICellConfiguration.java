package co.game.elements;

import java.awt.Color;

public interface ICellConfiguration {
	public final int WIDTH_CELL = 48;//Para los sprites se debe poner en 32
	public final int HEIGHT_CELL = 48;//Para los sprites se debe poner en 32
	public final int WIDTH_VIRTUAL_WORLD = 15;
	public final int HEIGHT_VIRTUAL_WORLD = 10;
	public final int HEIGHT_SCREEN = 180;
	public final int WIDTH_SCREEN = 180;
	public final int ALFA = 127;
	public final Color BACKGROUND_COLOR = new Color(153, 217, 234, ALFA);
	public final String PATH = "file:///" + System.getProperty("user.dir");// Proporciona la ruta absoluta del proyecto

}
