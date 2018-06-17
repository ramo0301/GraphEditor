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
	private int selectedVertex = -1;
	
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
	
	public void selectVertex(int index){
		selectedVertex = index;
		repaint();
		System.out.println("Selected vertex " + selectedVertex);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
	    
		System.out.println("repainting");

		int i = 0;
		for(Rectangle rec : listOfRectangles){	
			if(i == selectedVertex){
				g.setColor(Color.RED);
				g.fillRect((int)rec.getX()+1, (int)rec.getY()+1, (int)rec.getWidth()-1, (int)rec.getHeight()-1);	
			} else {
				g.setColor(Color.WHITE);
				g.fillRect((int)rec.getX()+1, (int)rec.getY()+1, (int)rec.getWidth()-1, (int)rec.getHeight()-1);
			}
			g.setColor(Color.BLACK);
			g.drawRect((int)rec.getX(), (int)rec.getY(), (int)rec.getWidth(), (int)rec.getHeight());
			i++;
		}
		for(int j=0 ; i<lineCoordinates.size(); j+=4){
			g.drawLine(lineCoordinates.get(j),lineCoordinates.get(j+1),lineCoordinates.get(j+2),lineCoordinates.get(j+3));
		}
	}
	
}
