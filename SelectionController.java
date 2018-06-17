package pack;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class SelectionController implements MouseListener{
	private ArrayList<Rectangle> listOfRectangles = new ArrayList<Rectangle>();
	private GraphPanel thePanel;
	
	public SelectionController(GraphPanel relevantPanel){
		relevantPanel.addMouseListener(this);
		thePanel = relevantPanel;
	}
	
	public void importRectangles(ArrayList<Rectangle> rectangleList){
		for(Rectangle inputRec : rectangleList){
			listOfRectangles.add(inputRec);
		}
	}
	
	public void mousePressed(MouseEvent e) {
		System.out.println("You just pressed the panel at " + e.getX() + "," + e.getY() );
		importRectangles(thePanel.getRectangleList() );
		for (Rectangle rec : listOfRectangles){
			if(rec.contains(e.getPoint() )){
				System.out.println("You just pressed a vertex");
			}
		}
		
	}
	
	public void mouseReleased(MouseEvent e) {
		System.out.println("You just released the panel at " + e.getX() + "," + e.getY() );

	}
	
	public void mouseEntered(MouseEvent e) {
		System.out.println("You just entered the panel at " + e.getX() + "," + e.getY() );

	}

	public void mouseExited(MouseEvent e) {
		System.out.println("You just exited the panel at " + e.getX() + "," + e.getY() );

	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("You just clicked the panel at " + e.getX() + "," + e.getY() );

	}
}
