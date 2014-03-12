package SimGraph;

public class Test implements Runnable {

	@Override
	public void run() {
		Graph G = Graph.generateRandomGraph();
		G.printGraph();
		System.out.println("------------------Running BFS-----------------\n\n");
		BFS bfs = new BFS(G);
		bfs.runBFS();
	}

}
