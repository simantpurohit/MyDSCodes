package SimGraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestVertices {

	@Test(expected = java.lang.IllegalArgumentException.class)
	public void testVerticesLessThanZero() {
		Graph g = new Graph(0);
	}
	
	@Test
	public void testGraphFormation(){
		Graph g = new Graph(10);
		assertEquals("No. of vertices", 10, g.V());
		assertEquals("Vertices length", 10, g.getAdjacent().size());
	}

}
