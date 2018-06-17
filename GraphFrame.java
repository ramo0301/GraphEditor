package pack;

//edit 3

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.Action;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.AbstractAction;

public class GraphFrame extends JFrame {
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 600;
	
	public boolean actionValue = false;
	
	public GraphFrame(){
		super("Graph Frame");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout() );
		
		JMenu theMenu = new JMenu("Menu");
		JMenuItem addVertixItem = new JMenuItem("add vertice");
		JMenuBar theBar = new JMenuBar();
		
		theMenu.add(addVertixItem);
		theBar.add(theMenu);
		setJMenuBar(theBar);
		//addVertixItem.addActionListener(new AddVertixAction2() );
		
		Action addVertix = new AddVertixAction("add vertex");
		addVertixItem.setAction(addVertix);
		
		GraphPanel center = new GraphPanel();
		center.setBackground(Color.green);
		add(new EmptyPanel(), BorderLayout.NORTH);
		add(new EmptyPanel(), BorderLayout.SOUTH);
		add(new EmptyPanel(), BorderLayout.EAST);
		add(new EmptyPanel(), BorderLayout.WEST);
		add(center, BorderLayout.CENTER);
		
	}
	
	private class AddVertixAction extends AbstractAction {
		
		public AddVertixAction(String addVertix){
			super(addVertix);
		}
		
		public void actionPerformed(ActionEvent e) {
			setActionValue(true);
			System.out.println("Hereby setting action value to true");
			repaint();
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
		actionValue = value;
	}
	
	public void paint(Graphics g){
		super.paint(g);
		if(actionValue)
			g.drawRect(100, 100, 100, 50);
	}
}
