import java.util.HashSet;

//tree
public class BST {
	BinaryNode root;
	BinaryNode[] path;
	int nodeCount = 0;
	
	public BST(int data){
		root = new BinaryNode(data);
		root.setLeft(null);
		root.setRight(null);
		nodeCount++;
	}
	
	
	public void setPath(int depth){
		path = new BinaryNode[depth];
	}
	
	
	//add nodes to a tree
	public void addNode(int data, BinaryNode root){
		BinaryNode newNode = new BinaryNode(data);
		
		if(root.left == null && data<root.data){
			System.out.println("Adding data:"+data+" to left of node:"+root.data);
			root.left = newNode;
			nodeCount++;
			return;
		}
		
		if(root.right == null && data>root.data){
			System.out.println("Adding data:"+data+" to right of node:"+root.data);
			root.right = newNode;
			nodeCount++;
			return;
		}
		
		if(data>root.data)
			addNode(data, root.right);
		
		if(data<root.data)
			addNode(data, root.left);
	}
	
	//construct a random tree
	public void construstRandomTree(int size,int maxV){
		if(size>maxV){
			System.out.println("Incorrect parameters");
			return;
		}
		HashSet<Integer> numbersGenerated = new HashSet<Integer>();
		numbersGenerated.add(root.data);
		for(int i=0;i<size;i++){
			boolean addFlag = false;
			while(!addFlag){
				int data = (int) (Math.random()*maxV);
				if(numbersGenerated.add(data)){
					addNode(data, root);
					addFlag = true;
				}
			}
		}
	}
	
	
	//In-order traversal
	public void inOrderTraversal(BinaryNode root){
		if(root == null)
			return;
		inOrderTraversal(root.left);
		System.out.print(root.data+"--");
		inOrderTraversal(root.right);
	}
	
	//LevelOrder Traversal
	public void levelOrder(BinaryNode root){
		Queue<BinaryNode> nodes = new Queue<BinaryNode>();
		nodes.enqueue(root);
		nodes.enqueue(null);
		System.out.println("");
		
		while(!nodes.isEmpty()){
			if(nodes.peek() == null){
				nodes.dequeue();
				nodes.enqueue(null);
				System.out.println(" ");
			}
			
			if(nodes.peek() != null){
				System.out.print(nodes.peek().data+"--");
				if(nodes.peek().left != null)
					nodes.enqueue(nodes.peek().left);
				if(nodes.peek().right != null)
					nodes.enqueue(nodes.peek().right);
				nodes.dequeue();
			}
			
			else
				nodes.dequeue();
		}
	}
	
	
	//get the depth of the tree
	public int getDepth(BinaryNode root){
		if(root == null)
			return 0;
		
		int leftHeight = 1 + getDepth(root.getLeft());
		int rightHeight = 1 + getDepth(root.getRight());
		
		return Math.max(leftHeight, rightHeight);
	}
	
	//Find k-th node from the leaf nodes
	public void findKthNodesFromLeaf(BinaryNode root, BinaryNode[] path, int k, int level){
		path[level] = root;
		if(root.left == null && root.right == null){
			System.out.println("-----------------------------------");
			if(level >= k){
				for(int i=level;i>=level-k;i--){
					System.out.println(path[i]);
				}
			}
			System.out.println("-----------------------------------");
		}
		
		if(root.left !=null)
			findKthNodesFromLeaf(root.left, path, k, level+1);
		
		if(root.right !=null)
			findKthNodesFromLeaf(root.right, path, k, level+1);
	}
	
	//check if the tree is balanced
	public boolean checkBalance(BinaryNode root){
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if(Math.abs(rightDepth-leftDepth) <= 1){
			System.out.println("Difference in left and right subtree height:"+Math.abs(rightDepth-leftDepth));
			return true;
		}
		
		else{
			System.out.println("Difference in left and right subtree height:"+Math.abs(rightDepth-leftDepth));
			return false;
		}
	}
	
	//check if node in tree
	public boolean checkNode(BinaryNode root, int data){
		if(root == null)
			return false;
		
		if(root.data == data){
			//System.out.println("Found!");
			return true;
		}
		
		if(data > root.data){
			//System.out.println("Checking right");
			return checkNode(root.right, data);
		}
		
		if(data < root.data){
			//System.out.println("Checking left");
			return checkNode(root.left, data);
		}
		else
			return false;
			
	}
	
	//check if node in tree
	public BinaryNode findNode(BinaryNode root, int data){
		if(root == null)
			return null;
		
		if(root.data == data){
			//System.out.println("Found!");
			return root;
		}
		
		if(data > root.data){
			//System.out.println("Checking right");
			return findNode(root.right, data);
		}
		
		if(data < root.data){
			//System.out.println("Checking left");
			return findNode(root.left, data);
		}
		else
			return null;
			
	}
	
	//LCA
	public BinaryNode findLCA(int x, int y, BinaryNode root){
		
		if(root.data == x || root.data == y){
			System.out.println("Found LCA with data:"+root.data);
			return root;
		}
		//Check if both data on left side of root
		if(checkNode(root.left, x) && checkNode(root.left, y)){
			return findLCA(x, y, root.left);
		}
		
		//Check if both data on right side of root
		if(checkNode(root.right, x) && checkNode(root.right, y)){
			return findLCA(x, y, root.right);
		}
		
		//Check if both data on different sides of root
		if((checkNode(root.left, x) && checkNode(root.right, y))||(checkNode(root.left, y) && checkNode(root.right, x))){
			System.out.println("Found LCA with data: "+root.data);
			return root;
		}
		
		else{
			System.out.println("Not found LCA");
			return null;
		}
		
	}

	//Distance of node from given node
	public int distanceFrom(BinaryNode root, int distance, int data){
		if(root == null)
			return 0;
		
		if(root.data == data){
			return  distance;
		}
		
		if(data > root.data){
			return distanceFrom(root.right, distance+1, data);
		}
		
		if(data < root.data){
			return distanceFrom(root.left, distance+1, data);
		}
		
		else
			return 0;
	}
	
	//Distance between two nodes
	public int distanceBetweenNodes(int x, int y){
		if(checkNode(root, x) && checkNode(root, y)){
			BinaryNode LCANode = findLCA(x, y, root);
			int dist1 = distanceFrom(LCANode, 0, x);
			int dist2 = distanceFrom(LCANode, 0, y);
			return (dist1+dist2);
		}
		
		else
			return 0;
	}
	
}