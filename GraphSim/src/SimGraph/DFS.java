package SimGraph;

import java.util.LinkedHashSet;
import java.util.Stack;

public class DFS {
	Graph G;
	boolean[] visited;
	int[] edgeTo;
	int[] distTo;
	int DFSSource;
	Stack<Integer> vertexQ;
	
	public DFS(Graph G){
		this.G= G;
		vertexQ = new Stack<Integer>();
		this.DFSSource = 0;
		for(int i=0;i<G.V();i++){
			visited = new boolean[G.V()];
			edgeTo = new int[G.V()];
			distTo = new int[G.V()];
		}
		
	}
	
//	public void runDFS(){
//		if(G == null)
//			return;
//		if(DFSSource >= G.getAdjacent().size())
//			return;
//		
//		vertexQ.push(DFSSource);
//		visited[DFSSource] = true;
//		distTo[DFSSource] = 0;
//		
//		while(!vertexQ.isEmpty()){
//			int v = vertexQ.pop();
//			LinkedHashSet<Integer> adj = G.getAdjacentNodes(v);
//			for(Integer u:adj){
//				if(!visited[u]){
//					vertexQ.push(u);
//					visited[u] = true;
//					edgeTo[u] = v;
//					distTo[u] = distTo[v] + 1;
//				}
//			}
//		}
//		
//		printPathsToSource();
//	}
	
	
	public void runDFS(int v){
		visited[v] = true;
		LinkedHashSet<Integer> adj = G.getAdjacentNodes(v);
        for (Integer w:adj) {
            if (!visited[w]) {
            	visited[w] = true;
            	edgeTo[w] = v;
            	runDFS(w);
            }
        }
	}

	public void printPathsToSource(){
		for(int i=0;i<G.V();i++){
			System.out.println("Printing path to source for node:"+i+" Total distance:"+distTo[i]);
			int temp = i;
			System.out.print(i+"--");
			while(edgeTo[temp] != DFSSource && visited[temp]){
				System.out.print(edgeTo[temp]+"--");
				temp = edgeTo[temp];
			}
			System.out.print(DFSSource);
			System.out.println(" ");
		}
	}
	
	public static void main(String args[]){
		Graph G = Graph.generateRandomGraph();
		DFS dfs = new DFS(G);
		dfs.runDFS(0);
	}
}
