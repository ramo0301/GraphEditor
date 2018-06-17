package pack;

import java.util.ArrayList;

public class GraphModel {
	//private ArrayList<GraphEdge> edgeList = new ArrayList<GraphEdge>();
	private ArrayList<GraphVertex> vertexList = new ArrayList<GraphVertex>();
	
	public ArrayList<GraphVertex> getVertexList() {
		return vertexList;
	}

	public void setVertexList(ArrayList<GraphVertex> vertexList) {
		this.vertexList = vertexList;
	}

	public void addVertex(String name, int xInput, int yInput){
		vertexList.add(new GraphVertex(name, xInput, yInput) );
	}
}
