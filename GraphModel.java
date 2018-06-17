package pack;

import java.util.ArrayList;

public class GraphModel {
	ArrayList<GraphEdge> edgeList = new ArrayList<GraphEdge>();
	ArrayList<GraphVertex> vertexList = new ArrayList<GraphVertex>();
	
	public void addVertex(String name, int xInput, int yInput){
		vertexList.add(new GraphVertex(name, xInput, yInput) );
	}
}
