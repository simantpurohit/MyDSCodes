package SimGraph;

public class TestDFS implements Runnable{

	@Override
	public void run() {
		Graph G = Graph.generateRandomGraph();
		G.printGraph();
		System.out.println("------------------Running DFS-----------------");
		DFS dfs = new DFS(G);
		dfs.runDFS(0);
		dfs.printPathsToSource();
	}

}
