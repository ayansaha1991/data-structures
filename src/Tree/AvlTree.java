package Tree;

/**
 * @author Ayan Saha
 * <p>This is a AVL Tree implementation.</p>
 * <p> This implementation is having :
 * <ol>
 * 	<li> Add</li>
 * 	<li> Delete</li>
 * 	<li> Re balance </li>
 * 	<li> AVL Tree Rotations</li>
 * </ol>
 * </p>
 *
 */

public class AvlTree<T> {
	
	private AVLNode<T> root;

	public AvlTree() {
		root = null;
	}
	
	private static class AVLNode<T> {
		
		private T data;
		private AVLNode<T> left;
		private AVLNode<T> right;
		private AVLNode<T> parent;
		
		public AVLNode(T data) {
			this.data = data;
			left = right = parent = null;
		}

		@Override
		public boolean equals(Object obj) {
			
			if (this == obj) {
				return true;
			} 
			
			if ((obj == null) || (getClass() != obj.getClass()) ) {
				return false;
			} else {
				AVLNode<T> node = (AVLNode<T>) obj;
				return this.data.equals(node.data);
			}
			
		}
		
	}
	
	public void insert(T data) {

		AVLNode newnode = new AVLNode(data);
		if (root == null) {
			root = newnode;
		} else {
			addRec(root, newnode);
		}
	}

	private void addRec(AVLNode<T> rootNode, AVLNode<T> newnode) {
		
		if (((Comparable) newnode.data).compareTo((Comparable) rootNode.data) < 0) {
			if (rootNode.left == null) {
				rootNode.left = newnode;
				newnode.parent = rootNode;
			} else {
				addRec(rootNode.left, newnode);
			}
		} else if (((Comparable) newnode.data).compareTo((Comparable) rootNode.data) > 0) {
			if (rootNode.right == null) {
				rootNode.right = newnode;
				newnode.parent = rootNode;
			} else {
				addRec(rootNode.right, newnode);
			}
		}
		
		checkBalance(newnode);
	}

	public void checkBalance(AVLNode<T> newNode) {
		
		if ((height(newNode.left)) - height(newNode.right) > 1 ||
				(height(newNode.left)) - height(newNode.right) < -1) {
			
			rebalance(newNode);
		} 
		
		if (newNode.parent == null) {
			return;
		}
		
		checkBalance(newNode.parent);
	}
	
	public void rebalance(AVLNode<T> newNode) {
		
		if ((height(newNode.left)) - height(newNode.right) > 1) {
			//Left Heavy Tree.
			if (height(newNode.left.left) - height(newNode.left.right) > 1) {
				// Left child Left subtree situation. Rotate right
				rightRotate(newNode);
			} else {
				// Left Child Right subtree situation. Rotate Left-->Right--> Result
				leftRightRotate(newNode);
			}
			
		} else if ((height(newNode.left)) - height(newNode.right) < -1) {
			// Right Heavy Tree
			if (height(newNode.right.left) - height(newNode.right.right) > 1) {
				// Right child Left subtree situation. Rotate Right-->Left--> Result
				rightLeftRotate(newNode);
			} else {
				// Right child Right Subtree situation. Rotate Left.
				leftRightRotate(newNode);
			}
		}
		
		rebalance(newNode.parent);
	}
	
	public int height(AVLNode<T> node) {
		return heightRec(node);
	}
	
	private int heightRec(AVLNode<T> node) {
		
		if(node == null) {
			return -1;
		}
		
		int lHeight = heightRec(node.left);
		int rHeight = heightRec(node.right);
		
		return Math.max(lHeight, rHeight) + 1;
	}

	public void leftRotate() {

	}
	public void rightRotate(AVLNode newNode) {
		
		

	}
	public void leftRightRotate(AVLNode newNode) {

	}
	public void rightLeftRotate(AVLNode newNode) {

	}

	//	public void delete();
	
	public static void main(String[] args) {
		
		AvlTree<Integer> avl = new AvlTree();
		avl.insert(1);
		avl.insert(2);
		avl.insert(3);
		avl.insert(4);
		avl.insert(5);
	}
	
	

}
