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
	
	public void printInOrder() { 
		inOrderRec(root);
	}


	private void inOrderRec(BSTNode node) {
		
		if(node == null) {
			return;
		}

		inOrderRec(node.left);
		System.out.println(node.data + ", ");
		inOrderRec(node.right);
	}

	
	private BSTNode createNode(Integer data) {
		
		BSTNode newNode = new BSTNode(data);
		return newNode;
	}
	
	public BSTNode insert(Integer data, BSTNode rootNode) {
		
		if (root == null) {
			root = createNode(data);
		}else if(data <= root.data) {
			root.left = insert(data, root.left);
		} else {
			root.right = insert(data, root.right);
		}
		
		return root;
	}
	
	public void add(Integer data) {
		insert(data, root);
	}
	
	public static void main(String[] args) {
		
		BSTTree tree = new BSTTree();
		tree.add(15);
		tree.add(10);
		tree.add(20);
		tree.add(25);
		
		tree.printInOrder();
	}

}
