package pack;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
//import java.awt.Rectangle;

public class GraphPanel extends JPanel {
	//public static final int PANEL_WIDTH = 300;
	//public static final int PANEL_HEIGHT = 200;
	
	public GraphPanel(){
		super();
		setBackground(Color.white);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		//g.drawRect(0, 0, 100, 60);
	}
	
}
