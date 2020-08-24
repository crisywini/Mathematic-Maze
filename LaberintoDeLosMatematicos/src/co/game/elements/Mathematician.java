package co.game.elements;

import java.util.Hashtable;
import java.util.TimerTask;

public class Mathematician extends TimerTask implements ICellConfiguration {

	private Maze maze;
	private Cell mathematicianCell;
	private Hashtable<String, String> questions;

	public Mathematician(Maze maze) {
		this.maze = maze;
		mathematicianCell = new Cell(0, HEIGHT_VIRTUAL_WORLD - 1, Type.MATHEMATICIAN);
		maze.getCells()[mathematicianCell.getX()][mathematicianCell.getY()].setType(Type.MATHEMATICIAN);
		questions = new Hashtable<String, String>();
	}
	public Mathematician(Maze maze, int x, int y) {
		this.maze = maze;
		mathematicianCell = new Cell(x, y, Type.MATHEMATICIAN);
		maze.getCells()[mathematicianCell.getX()][mathematicianCell.getY()].setType(Type.MATHEMATICIAN);
		questions = new Hashtable<String, String>();
	}

	@Override
	public void run() {
		moveMathematician();
		maze.getMyCanvas().repaint();
	}

	public void moveMathematician() {
		if (mathematicianCell.getX() > 0) {
			maze.getCells()[mathematicianCell.getX()][mathematicianCell.getY()].setType(Type.ROAD);
			mathematicianCell.setX(mathematicianCell.getX() - 1);
			maze.getCells()[mathematicianCell.getX()][mathematicianCell.getY()].setType(Type.MATHEMATICIAN);
			maze.getCells()[mathematicianCell.getX()][mathematicianCell.getY()].setIndexSpriteMath(getRandomInt(1, 2));

		} else {
			maze.getCells()[mathematicianCell.getX()][mathematicianCell.getY()].setType(Type.ROAD);
			mathematicianCell.setX(WIDTH_VIRTUAL_WORLD - 1);
			mathematicianCell.setY(getRandomInt(0, HEIGHT_VIRTUAL_WORLD - 1));
			maze.getCells()[mathematicianCell.getX()][mathematicianCell.getY()].setType(Type.MATHEMATICIAN);
			maze.getCells()[mathematicianCell.getX()][mathematicianCell.getY()].setIndexSpriteMath(getRandomInt(1, 2));

		}
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public Cell getMathematicianCell() {
		return mathematicianCell;
	}

	public void setMathematicianCell(Cell mathematicianCell) {
		this.mathematicianCell = mathematicianCell;
	}
	public Hashtable<String, String> getQuestions() {
		return questions;
	}
	public void setQuestions(Hashtable<String, String> questions) {
		this.questions = questions;
	}

}
