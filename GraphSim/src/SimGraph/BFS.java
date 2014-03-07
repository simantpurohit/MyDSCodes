package SimGraph;

import java.util.LinkedHashSet;

public class BFS {
	Graph G = Graph.generateRandomGraph();
	boolean[] visited;
	int[] edgeTo;
	int[] distTo;
	int BFSSource;
	Queue<Integer> vertexQ;
	
	public BFS(){
		vertexQ = new Queue<Integer>();
		this.BFSSource = 0;
		for(int i=0;i<G.V();i++){
			visited = new boolean[G.V()];
			edgeTo = new int[G.V()];
			distTo = new int[G.V()];
		}
		
	}
	
	public void runBFS(){
		if(G == null)
			return;
		if(BFSSource >= G.getAdjacent().size())
			return;
		
		vertexQ.enqueue(BFSSource);
		visited[BFSSource] = true;
		distTo[BFSSource] = 0;
		
		while(!vertexQ.isEmpty()){
			int v = vertexQ.dequeue();
			LinkedHashSet<Integer> adj = G.getAdjacentNodes(v);
			for(Integer u:adj){
				if(!visited[u]){
					vertexQ.enqueue(u);
					visited[u] = true;
					edgeTo[u] = v;
					distTo[u] = distTo[v] + 1;
				}
			}
		}
		
		printPathsToSource();
	}

	public void printPathsToSource(){
		for(int i=0;i<G.V();i++){
			System.out.println("Printing path to source for node:"+i+" Total distance:"+distTo[i]);
			int temp = i;
			System.out.print(i+"--");
			while(edgeTo[temp] != BFSSource && visited[temp]){
				System.out.print(edgeTo[temp]+"--");
				temp = edgeTo[temp];
			}
			System.out.print(BFSSource);
			System.out.println(" ");
		}
	}
	
	public static void main(String args[]){
		BFS bfs = new BFS();
		bfs.runBFS();
		
	}
}
