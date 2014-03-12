package SimGraph;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test_DFS_BFS {

	Graph G;
	@Before
	public void setUp() throws Exception {
		G = Graph.generateRandomGraph();
	}

	@Test
	public void testBFS() {
		System.out.println("------------------Running BFS-----------------\n\n");
		BFS bfs = new BFS(G);
		bfs.runBFS();
		//bfs.printPathsToSource();
	}
	
	@Test
	public void testDFS() {
		System.out.println("------------------Running DFS-----------------");
		DFS dfs = new DFS(G);
		dfs.runDFS(0);
		//dfs.printPathsToSource();
	}

}
