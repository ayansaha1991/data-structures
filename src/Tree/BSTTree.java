package Tree;

public class BSTTree<E> {
	
	private BSTNode<E> root;
	
	public BSTTree() {
		root = null;
	}
	
	private static class BSTNode<E> {
		
		E data;
		BSTNode<E> left;
		BSTNode<E> right;
		
		public BSTNode(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public void insert(E data) {
		
		BSTNode<E> newNode = new BSTNode(data);
	}

}
