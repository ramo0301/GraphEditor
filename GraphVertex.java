package pack;

import java.awt.Rectangle;

public class GraphVertex {
	private String name = "defaultName";
	private int xCoordinate = 0;
	private int yCoordinate = 0;
	
	public GraphVertex(){	}
	
	public GraphVertex(String name){
		this.name = name;
	}
	
	public GraphVertex(String name, int inputX, int inputY){
		this.name = name;
		xCoordinate = inputX;
		yCoordinate = inputY;
	}
	
	public void setCoordinates(int inputX, int inputY){
		if(inputX>=0 && inputY>=0){
			xCoordinate = inputX;
			yCoordinate = inputY;
		} else {
			System.out.println("ERROR: IMPOSSIBLE COORDINATES");
		}
	}
	
	public Rectangle getRectangle(){
		Rectangle rectangle = new Rectangle(xCoordinate, yCoordinate, 200, 100);
		return rectangle;
	}
	
	public int getXCoordinate(){
		return xCoordinate;
	}
	
	public int getYCoordinate(){
		return yCoordinate;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
