package pack;

//edit 5

import java.awt.event.ActionEvent;
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
	private ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();
	private GraphPanel thePanel = new GraphPanel();
	
	Scanner keyboard = new Scanner(System.in);
	
	public GraphFrame(){
		super("Graph Frame");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(new BorderLayout() );
				
		JMenu theMenu = new JMenu("Menu");
		JMenuItem addVertexItem = new JMenuItem("add vertex");
		JMenuBar theBar = new JMenuBar();
		
		theMenu.add(addVertexItem);
		theBar.add(theMenu);
		setJMenuBar(theBar);
		
		Action addVertex = new AddVertexAction("add vertex");
		addVertexItem.setAction(addVertex);
		
		thePanel.setBackground(Color.green);
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
			setActionValue(true);				//probably doesn't even need to use the method
			
			//System.out.println("Enter coordinates x and y");
			switch(numberOfVertices){
			}
			int xCoordinate = numberOfVertices*100;
			int yCoordinate = numberOfVertices*100;
			
			theModel.addVertex("Vertex " + numberOfVertices, xCoordinate, yCoordinate);
			thePanel.addRectangle(theModel.getVertexList().get(numberOfVertices).getRectangle());
			
			thePanel.repaint();
			
			numberOfVertices++;
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
