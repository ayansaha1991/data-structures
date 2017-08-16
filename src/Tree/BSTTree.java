package Tree;

public class BSTTree {
	
	private BSTNode root;
	
	public BSTTree() {
		root = null;
	}
	
	private static class BSTNode {
		
		Integer data;
		BSTNode left;
		BSTNode right;
		
		public BSTNode(Integer data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public void printInOrder(BSTNode node) {

		if(node == null) {
			return;
		}

		printInOrder(node.left);
		System.out.println(node.data + ", ");
		printInOrder(node.right);
	}

	
	private BSTNode createNode(Integer data) {
		
		BSTNode newNode = new BSTNode(data);
		return newNode;
	}
	
	public void insert(BSTNode current ,Integer data) {
		
		BSTNode newNode = createNode(data);
		
		if (root == null) {
			root = newNode;
		}
		
		if(newNode.data <= root.left.data) {
			insert(current.left, data);
		} else {
			insert(current.right, data);
		}
		
	}
	
	public static void main(String[] args) {
		
		BSTTree tree = new BSTTree();
	}

}
