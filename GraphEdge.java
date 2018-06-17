package pack;

public class GraphEdge {
	private GraphVertex connected1, connected2;
	
	public GraphEdge(GraphVertex vertex1, GraphVertex vertex2){
		this.connected1 = vertex1;
		this.connected2 = vertex2;
	}
	
	public GraphVertex getVertex(int number){
		if(number == 1)
			return connected1;
		else if(number == 2)
			return connected2;
		else{
			System.out.println("There are only two connected vertices");
			return null;
		}
	}
	
	public void setVertex(int number, GraphVertex vertex){
		if(number == 1)
			connected1 = vertex;
		else if(number == 2)
			connected2 = vertex;
		else{
			System.out.println("There are only two connected vertices");
		}
	}

}
