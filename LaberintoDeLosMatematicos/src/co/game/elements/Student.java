package co.game.elements;

public class Student implements ICellConfiguration {

	private Maze maze;
	private Cell studentCell;
	private int lifes;

	private int direction;

	public Student(Maze maze) {
		this.maze = maze;

//		setCell(new Cell(14, 0, Type.STUDENT));
		studentCell = new Cell(15, 0, Type.STUDENT);
		this.maze.getCells()[15][0].setType(Type.STUDENT);
		direction = 0;// Move right
		lifes = 3;
	}

	// https://studylib.es/doc/7780309/desarrollo-de-videojuegos-2d-en-java-con-t%C3%A9cnicas-de-inte...

	public void moveUp() {
		if (studentCell.getY() > 0) {
			if (maze.getCells()[studentCell.getX()][studentCell.getY() - 1].getType() != Type.OBSTACLE) {
				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.ROAD);
				studentCell.setY(studentCell.getY() - 1);
				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.STUDENT);
				maze.getCells()[studentCell.getX()][studentCell.getY()].setIndexSprite(8);
			}
		}
	}

	public void moveDown() {
		if (studentCell.getY() + 1 < HEIGHT_VIRTUAL_WORLD) {
			if (maze.getCells()[studentCell.getX()][studentCell.getY() + 1].getType() != Type.OBSTACLE) {
				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.ROAD);
				studentCell.setY(studentCell.getY() + 1);
				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.STUDENT);
				maze.getCells()[studentCell.getX()][studentCell.getY()].setIndexSprite(0);
			}
		}
	}

	public void moveRight() {

		if (studentCell.getX() + 1 < WIDTH_VIRTUAL_WORLD) {
			if (maze.getCells()[studentCell.getX() + 1][studentCell.getY()].getType() != Type.OBSTACLE) {
				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.ROAD);
				studentCell.setX(studentCell.getX() + 1);
				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.STUDENT);
				maze.getCells()[studentCell.getX()][studentCell.getY()].setIndexSprite(12);
			}

		}

//		if (studentCell.getX() < WIDTH_VIRTUAL_WORLD - 1) {
//			if (maze.getCells()[studentCell.getX() + 1][studentCell.getY()].getType() != Type.MATHEMATICIAN) {
//				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.ROAD);
//				studentCell.setX(studentCell.getX() + 1);
//				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.STUDENT);
//			} else {
//				// Move left
//				direction = 1;
//			}
//		} else {
//			// appear again
//			maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.ROAD);
//			studentCell.setX(14);
//			studentCell.setY(getRandomInt(14, HEIGHT_VIRTUAL_WORLD - 1));
//			maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.STUDENT);
//		}

	}

	public void moveLeft() {

		if (studentCell.getX() > 0 && studentCell.getX() < WIDTH_VIRTUAL_WORLD) {
//			if(maze.getCells()[studentCell.getX() - 1][studentCell.getY()].getType() != Type.MATHEMATICIAN||maze.getCells()[studentCell.getX() - 1][studentCell.getY()].getType() != Type.ROAD) {
			if (maze.getCells()[studentCell.getX() - 1][studentCell.getY()].getType() != Type.OBSTACLE) {
				System.out.println("ENTRO LEFT");
				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.ROAD);
				studentCell.setX(studentCell.getX() - 1);
				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.STUDENT);
				maze.getCells()[studentCell.getX()][studentCell.getY()].setIndexSprite(4);
			}
		}

//		// Not at the 0,0 point
//
//		if (studentCell.getX() > 0) {
//			// verify the mathematician to the left
//			if (maze.getCells()[studentCell.getX() - 1][studentCell.getY()].getType() != Type.MATHEMATICIAN) {
//				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.ROAD);
//				studentCell.setX(studentCell.getX() - 1);
//				maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.STUDENT);
//			} else {
//				// Move left
//				direction = 0;
//			}
//		} else {
//			maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.ROAD);
//			studentCell.setX(14);
//			studentCell.setY(getRandomInt(14, HEIGHT_VIRTUAL_WORLD - 1));
//			maze.getCells()[studentCell.getX()][studentCell.getY()].setType(Type.STUDENT);
//		}
	}

	public Maze getMaze() {
		return maze;
	}

	public void setMaze(Maze maze) {
		this.maze = maze;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public Cell getStudentCell() {
		return studentCell;
	}

	public void setStudentCell(Cell studentCell) {
		this.studentCell = studentCell;
	}

	public int getLifes() {
		return lifes;
	}

	public void setLifes(int lifes) {
		this.lifes = lifes;
	}

}
