package SimGraph;

import java.util.ArrayList;
import java.util.LinkedHashSet;


public class Graph {
	
	private int V;
	private int E;
	private  ArrayList<LinkedHashSet<Integer>> adjacent = new ArrayList<LinkedHashSet<Integer>>();
	
	public int V(){
		return V;
	}
	
	public int E(){
		return E;
	}
	
	public void increaseE(){
		E++;
	}
	
	public ArrayList<LinkedHashSet<Integer>> getAdjacent() {
		return adjacent;
	}

	public Graph(int V){
		if(V < 0)
			return;
		this.V = V;
		this.E = 0;
		for(int i=0;i<V;i++){
			LinkedHashSet<Integer> vertex = new LinkedHashSet<Integer>();
			vertex.add(i);
			adjacent.add(i, vertex);
		}
	}
	
	public LinkedHashSet<Integer> getAdjacentNodes(int v){
		if(v>V())
			return null;
		return adjacent.get(v);
	}
	
	public void addEdge(int from, int to){
		
		if(from < V && to < V){
			adjacent.get(from).add(to);
			adjacent.get(to).add(from);
			E++;
		}
		
	}
	
	public void printGraph(){
		System.out.println("----------------------------------------");
		for(int i=0;i<V();i++){
			LinkedHashSet<Integer> vertex = adjacent.get(i);
			for(Integer v:vertex){
				System.out.print(i+"--"+v+"  ");
			}
			System.out.println("");
		}
		
		System.out.println("----------------------------------------");
	}
	
	public static Graph generateRandomGraph(){
		int vertices = (int)(Math.random()*1000);
		Graph G = new Graph(vertices);
		for(int i=0;i<vertices*2;i++){
			G.addEdge((int)(Math.random()*vertices), (int)(Math.random()*vertices));
		}
		G.printGraph();
		return G;
	}

	public static void main(String args[]){
		int vertices = (int)(Math.random()*100);
		Graph G = new Graph(vertices);
		for(int i=0;i<vertices*2;i++){
			G.addEdge((int)(Math.random()*vertices), (int)(Math.random()*vertices));
		}
		G.printGraph();
		
	}
}