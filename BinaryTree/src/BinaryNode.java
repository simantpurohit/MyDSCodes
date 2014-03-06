
public class BinaryNode {
	BinaryNode left;
	BinaryNode right;
	int data;
	
	public BinaryNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public BinaryNode getLeft() {
		return left;
	}

	public void setLeft(BinaryNode left) {
		this.left = left;
	}

	public BinaryNode getRight() {
		return right;
	}

	public void setRight(BinaryNode right) {
		this.right = right;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Data:"+this.data;
	}
	
	
	
}
