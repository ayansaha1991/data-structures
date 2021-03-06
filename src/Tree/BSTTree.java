package Tree;

/**
 * This is is BST implementation
 * @author ayan
 * It tries to achieve CRUD operations
 *
 */
public class BSTTree {
	
	private BSTNode root;
	
	public BSTTree() {
		root = null;
	}
	
	@Override
	public boolean equals(Object tree) {
		
		if (this == tree) {
			return true;
		}
		
		if (this == null || tree == null) {
			return false;
		}
		
		if (getClass() != tree.getClass()) {
			return false;
		}
		
		BSTTree anotherTree = (BSTTree) tree;
		
		return true;
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
		
		@Override
		public String toString() {
			String nodeStr = "Data : " + data + " Left Link : " + left ;
			return nodeStr;
		}
	}
	
	//public void delete();
	
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

	private BSTNode searchRec(int data, BSTNode root) {

		BSTNode dataFound = null;

		if (root == null )
			return null;

		if (root.data == data) {
			return root;
		} else if (data <= root.data) {
			dataFound = searchRec(data, root.left);
		} else {
			dataFound = searchRec(data, root.right);
		}

		return dataFound;
	}
	
	public int height() {
		return heightRec(root);
	}
	
	private int heightRec(BSTNode root) {
		
		if(root == null) {
			return -1;
		}
		
		int lHeight = heightRec(root.left);
		int rHeight = heightRec(root.right);
		
		return Math.max(lHeight, rHeight) + 1;
	}

	public int findMax() {
		
		return findMaxRec(root);
	}
	
	private int findMaxRec(BSTNode root) {
		
		if (root == null) {
			return 0;
		}
		int max = root.data;
		if (root.right != null && root.right.data > max) {
			max = findMaxRec(root.right);
		}
		return max;
	}
	

	private BSTNode createNode(Integer data) {
		
		BSTNode newNode = new BSTNode(data);
		return newNode;
	}
	
	public BSTNode insert(Integer data, BSTNode root) {
		
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
		root = insert(data, root);
	}
	
	/**
	 * This method finds out the lowest common ancestor given a root
	 */
	public void lce(Integer node1, Integer node2 ) {
		
	}
	
	public static void main(String[] args) {
		
		BSTTree tree = new BSTTree();
		tree.add(15);
		tree.add(10);
		tree.add(20);
		tree.add(25);
		
		tree.lce(10, 20);
		
		tree.printInOrder();
	}

}
