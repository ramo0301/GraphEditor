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
		System.out.println("repainting");

		for(Rectangle rec : listOfRectangles){
			g.setColor(Color.BLACK);
			g.drawRect((int)rec.getX(), (int)rec.getY(), (int)rec.getWidth(), (int)rec.getHeight());	
			g.setColor(Color.WHITE);
			g.fillRect((int)rec.getX()+1, (int)rec.getY()+1, (int)rec.getWidth()-1, (int)rec.getHeight()-1);			
		}
	}
	
}
