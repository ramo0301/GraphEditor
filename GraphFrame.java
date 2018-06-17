package pack;

//edit 9

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;
//import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.Action;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.AbstractAction;

public class GraphFrame extends JFrame {
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 600;
	
	//private boolean actionValue = false;
	private int numberOfVertices = 0;
	private GraphModel theModel = new GraphModel();
	private GraphPanel thePanel = new GraphPanel();
	
	private GraphVertex selectedVertex1 = null, selectedVertex2 = null;
	
	Scanner keyboard = new Scanner(System.in);
	SelectionController mouse = new SelectionController(thePanel);
	
	public GraphFrame(){
		super("Graph Frame");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout() );
				
		JMenu theMenu = new JMenu("Menu");
		JMenuItem addVertexItem = new JMenuItem("add vertex");
		JMenuItem addEdgeItem = new JMenuItem("add edge");
		JMenuBar theBar = new JMenuBar();
		
		theMenu.add(addVertexItem);
		theMenu.add(addEdgeItem);
		theBar.add(theMenu);
		setJMenuBar(theBar);
		
		Action addVertex = new AddVertexAction("add vertex");
		Action addEdge = new AddEdgeAction("add edge", 0, 1);
		addVertexItem.setAction(addVertex);
		addEdgeItem.setAction(addEdge);
		
		thePanel.setBackground(Color.LIGHT_GRAY);
		add(new EmptyPanel(), BorderLayout.NORTH);
		add(new EmptyPanel(), BorderLayout.SOUTH);
		add(new EmptyPanel(), BorderLayout.EAST);
		add(new EmptyPanel(), BorderLayout.WEST);
		add(thePanel, BorderLayout.CENTER);
		
	}
	
	private class AddVertexAction extends AbstractAction {
		
		public AddVertexAction(String addVertex){
			super(addVertex);
		}
		
		public void actionPerformed(ActionEvent e) {			
			int xCoordinate=0, yCoordinate=0;
			System.out.println(numberOfVertices);
			switch(numberOfVertices){
			case 0:
				xCoordinate = 350;
				yCoordinate = 100;
				break;
			case 1:
				xCoordinate = 50;
				yCoordinate = 400;
				break;
			case 2:
				xCoordinate = 650;
				yCoordinate = 400;
				break;
			}
			
			theModel.addVertex("Vertex " + numberOfVertices, xCoordinate, yCoordinate);
			thePanel.addRectangle(theModel.getVertexList().get(numberOfVertices).getRectangle());
			
			thePanel.repaint();
			
			numberOfVertices++;
		}
	}
	
	private class EdgeAddingMouse implements MouseListener{
		public EdgeAddingMouse(){
			thePanel.addMouseListener(this);
		}
		
		public void mousePressed(MouseEvent e) {
			System.out.println("You just pressed the panel at " + e.getX() + "," + e.getY() );
			int i = 0;
			for (Rectangle rec : thePanel.getRectangleList()){
				if(rec.contains(e.getPoint() )){
					System.out.println("You just pressed vertex " + i);
					thePanel.selectVertex(i);
					if(selectedVertex1 != null){
						selectedVertex1 = theModel.getVertex(i);
						break;
					} else if(selectedVertex2 != null){
						selectedVertex2 = theModel.getVertex(i);
						break;
					} else {
						removeMouseListener(this);
					}
				}
				i++;
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
	
	private class AddEdgeAction extends AbstractAction {
		int vertex1 = 0, vertex2 = 0;
	
		public AddEdgeAction(String inputEdge){
			super(inputEdge);
			
			EdgeAddingMouse edgeMouse = new EdgeAddingMouse();
		
		public void actionPerformed(ActionEvent e) {			
			int x1, y1, x2, y2;
			double xDifference, yDifference;
			vertex1 = selectedVertex1;
			vertex2 = selectedVertex2;
			
			x1 = (int)thePanel.getRectangle(vertex1).getX();
			y1 = (int)thePanel.getRectangle(vertex1).getY();
			x2 = (int)thePanel.getRectangle(vertex2).getX();
			y2 = (int)thePanel.getRectangle(vertex2).getY();
			xDifference = x1-x2;
			yDifference = y1-y2;
			System.out.println("xDifference: " + xDifference);
			System.out.println("yDifference: " + yDifference);
			
			double horizontalRatio = (Math.sqrt(3)/2) / .5;
			double verticalRatio = .5 / (Math.sqrt(3)/2);
			double actualRatio = xDifference/yDifference;
			System.out.println("HorizontalRatio: " + horizontalRatio);
			System.out.println("VerticalRatio: " + verticalRatio);
			System.out.println((int)Math.round(xDifference*1/yDifference));
			
			int xFirst=0, yFirst=0, xSecond=0, ySecond=0;
			
			if(Math.abs(actualRatio)>=horizontalRatio){
				
				yFirst = (int)( thePanel.getRectangle(vertex1).getY() + thePanel.getRectangle(vertex1).getHeight()/2 );
				ySecond = (int)( thePanel.getRectangle(vertex2).getY() + thePanel.getRectangle(vertex2).getHeight()/2 );
				if(xDifference>0){
					System.out.println("Left horizontal case");
					xFirst = (int)thePanel.getRectangle(vertex1).getX();
					xSecond = (int)( thePanel.getRectangle(vertex2).getX() + thePanel.getRectangle(vertex2).getWidth() );;
				} else {
					System.out.println("Right horizontal case");
					xFirst = (int)( thePanel.getRectangle(vertex1).getX() + thePanel.getRectangle(vertex1).getWidth() );
					xSecond = (int)thePanel.getRectangle(vertex2).getX();
				}
			} else if(Math.abs(actualRatio)<=verticalRatio){
				xFirst = (int)( thePanel.getRectangle(vertex1).getX() + thePanel.getRectangle(vertex1).getWidth()/2) ;
				xSecond = (int)( thePanel.getRectangle(vertex2).getX() + thePanel.getRectangle(vertex2).getWidth()/2) ;
				if(yDifference>0){
					System.out.println("Upper vertical case");
					yFirst = (int)( thePanel.getRectangle(vertex1).getY() );
					ySecond = (int)( thePanel.getRectangle(vertex2).getY() + thePanel.getRectangle(vertex2).getHeight() );
				} else {
					System.out.println("Lower vertical case");
					yFirst = (int)( thePanel.getRectangle(vertex1).getY() + thePanel.getRectangle(vertex1).getHeight() );
					ySecond= (int)( thePanel.getRectangle(vertex2).getY() );
				}
			} else {
				
				//THIS PART CAN BE DONE MORE EFFICIENTLY
				
				if(xDifference>0){
					
					yFirst = (int)( thePanel.getRectangle(vertex1).getY() + thePanel.getRectangle(vertex1).getHeight() );
					ySecond = (int)thePanel.getRectangle(vertex2).getY();
					if(yDifference>0){
						System.out.println("Lower right case");
						xFirst = (int)( thePanel.getRectangle(vertex1).getX() + thePanel.getRectangle(vertex1).getWidth()*2/3 );
					} else {
						System.out.println("Lower left case");
						xFirst = (int)( thePanel.getRectangle(vertex1).getX() + thePanel.getRectangle(vertex1).getWidth()/3 );
						xSecond = (int)( thePanel.getRectangle(vertex2).getX() + thePanel.getRectangle(vertex2).getWidth()*2/3 );
					}
				} else {
					
					yFirst = (int)thePanel.getRectangle(vertex1).getY();
					ySecond = (int)( thePanel.getRectangle(vertex2).getY() + thePanel.getRectangle(vertex2).getHeight() );
					if(yDifference>0){
						System.out.println("Upper right case");
						xFirst = (int)( thePanel.getRectangle(vertex1).getX() + thePanel.getRectangle(vertex1).getWidth()*2/3 );
						xSecond = (int)( thePanel.getRectangle(vertex2).getX() + thePanel.getRectangle(vertex2).getWidth()/3 );
					} else {
						System.out.println("Upper left case");
						xFirst = (int)( thePanel.getRectangle(vertex1).getX() + thePanel.getRectangle(vertex1).getWidth()/3 );
						xSecond= (int)( thePanel.getRectangle(vertex2).getX() + thePanel.getRectangle(vertex2).getWidth()*2/3 );
					}
				}
			}
			
			thePanel.addLineCoordinates(xFirst, yFirst, xSecond, ySecond);
			thePanel.repaint();
			
			
			
			
			//theModel.addVertex("Vertex " + numberOfVertices, xCoordinate, yCoordinate);
			//thePanel.addRectangle(theModel.getVertexList().get(numberOfVertices).getRectangle());
			
			//thePanel.repaint();
			
			//numberOfVertices++;
		}
	}
	
	
	/*
	private class AddVertixAction2 implements ActionListener{
		public void actionPerformed(ActionEvent e){
			setActionValue(true);
			System.out.println("Hereby setting action value to true");
			repaint();
		}
	}
	*/
	
	public void setActionValue(boolean value){
		//actionValue = value;
	}
	/*
	public void paint(Graphics g){
		super.paint(g);
		for(Rectangle rectangle : rectangleList){
			g.drawRect((int)rectangle.getX(), (int)rectangle.getY(), (int)rectangle.getWidth(), (int)rectangle.getHeight());
		}
		//if(actionValue)
		//	g.drawRect(100, 100, 100, 50);
	}
	*/
}
