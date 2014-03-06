
public class TestBT {

	public static void main(String[] args) {
//		int balancedCount = 0;
//		int notBalancedCount = 0;
		int size = 8000;
		BST tree = new BST((int)(Math.random()*size));
		tree.construstRandomTree(size, size+1);
		
//		for(int i=0;i<100;i++){
//			
//			tree = new BST(100);
//			tree.construstRandomTree(30, 200);
//			if(tree.checkBalance(tree.root))
//				balancedCount++;
//			else
//				notBalancedCount++;
//		}
		
//		System.out.println("Balanced:"+balancedCount);
//		System.out.println("Not Balanced:"+notBalancedCount);
		tree.setPath(tree.getDepth(tree.root));
		tree.levelOrder(tree.root);
		System.out.println("\nNode count:"+tree.nodeCount);
		System.out.println("");
		System.out.println("Depth:"+tree.getDepth(tree.root));
		System.out.println("Balanced:"+tree.checkBalance(tree.root));
		System.out.println("");
		//System.out.println("Is Node Found:"+tree.checkNode(tree.root, 0));
		int x = (int)(Math.random()*size);
		int y = (int)(Math.random()*size);
		System.out.println("LCA of:"+x+" and "+y);
		BinaryNode LCANode = tree.findLCA(x , y, tree.root);
		System.out.println("Root node is:"+tree.root.data);
		System.out.println("Distance from LCA:"+tree.distanceFrom(LCANode, 0, x));
		System.out.println("Distance from LCA:"+tree.distanceFrom(LCANode, 0, y));
		System.out.println("Distance between the two nodes:"+tree.distanceBetweenNodes(x, y));
		///tree.findKthNodesFromLeaf(tree.root, tree.path, 2, 0);
	}

}
