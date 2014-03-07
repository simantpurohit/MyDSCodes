package SimGraph;

public class DiGraph extends Graph {

	public DiGraph(int V) {
		super(V);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void addEdge(int from, int to) {
		if(from < V() && to < V()){
			getAdjacent().get(from).add(to);
			increaseE();;
		}
	}
	
	public static void main(String args[]){
		int vertices = (int)(Math.random()*1000);
		DiGraph G = new DiGraph(vertices);
		for(int i=0;i<vertices*2;i++){
			G.addEdge((int)(Math.random()*vertices), (int)(Math.random()*vertices));
		}
		G.printGraph();
		
	}

}