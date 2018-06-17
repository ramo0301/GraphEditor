package pack;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class GraphPanel extends JPanel {
	private ArrayList<Rectangle> listOfRectangles = new ArrayList<Rectangle>();
	
	public GraphPanel(){
		super();
		setBackground(Color.white);
	}
	
	public void addRectangle(Rectangle inputRectangle){
		listOfRectangles.add(inputRectangle);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		for(Rectangle rec : listOfRectangles){
			g.drawRect((int)rec.getX(), (int)rec.getY(), (int)rec.getWidth(), (int)rec.getHeight());			
		}
	}
	
}
