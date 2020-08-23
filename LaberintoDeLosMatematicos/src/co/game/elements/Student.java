package co.game.elements;

public class Student implements ICellConfiguration{
	
	private Maze maze;
	private Cell cell;
	public Student(Maze maze) {
		this.maze = maze;
		cell = new Cell(14, 0, Type.STUDENT);
		maze.getCells()[14][0].setType(Type.STUDENT);
	}
	//https://studylib.es/doc/7780309/desarrollo-de-videojuegos-2d-en-java-con-t%C3%A9cnicas-de-inte...
	
	

}
