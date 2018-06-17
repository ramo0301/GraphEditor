package pack;

public class GraphVertex {
	private String name = "defaultName";
	
	public GraphVertex(){	}
	
	public GraphVertex(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
