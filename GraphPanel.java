package pack;

import javax.swing.JPanel;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
	private ArrayList<Rectangle> listOfRectangles = new ArrayList<Rectangle>();
	private ArrayList<Integer> lineCoordinates = new ArrayList<Integer>();
	
	public GraphPanel(){
		super();
		setBackground(Color.white);
	}
	
	public void addRectangle(Rectangle inputRectangle){
		listOfRectangles.add(inputRectangle);
	}
	
	public void addLineCoordinates(int x1, int y1, int x2, int y2){
		lineCoordinates.add(x1);
		lineCoordinates.add(y1);
		lineCoordinates.add(x2);
		lineCoordinates.add(y2);
	}
	
	public Rectangle getRectangle(int number){
		return listOfRectangles.get(number);
	}
	
	public ArrayList<Rectangle> getRectangleList(){
		return listOfRectangles;
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
	    
		System.out.println("repainting");

		for(Rectangle rec : listOfRectangles){	
			g.setColor(Color.WHITE);
			g.fillRect((int)rec.getX()+1, (int)rec.getY()+1, (int)rec.getWidth()-1, (int)rec.getHeight()-1);	
			g.setColor(Color.BLACK);
			g.drawRect((int)rec.getX(), (int)rec.getY(), (int)rec.getWidth(), (int)rec.getHeight());
		}
		for(int i=0 ; i<lineCoordinates.size(); i+=4){
			g.drawLine(lineCoordinates.get(i),lineCoordinates.get(i+1),lineCoordinates.get(i+2),lineCoordinates.get(i+3));
		}
	}
	
}
