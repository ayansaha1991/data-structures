package Tree;

public class MyTree<E> {
	
	private MyTreeNode<E> root;
	
	public MyTree() {
		root = null;
	}
	
	private static final class MyTreeNode<E> {
		private E data;
		private MyTreeNode<E> left;
		private MyTreeNode<E> right;
		
		public MyTreeNode(E data) {
			this.data = data;
		}
	}
	
	public void printInOrder(MyTreeNode<E> node) {
		
		if(node == null) {
			return;
		}
		
		printInOrder(node.left);
		System.out.println(node.data + ", ");
		printInOrder(node.right);
	}
	
	
	public static void main(String[] args) {
		
		MyTree<Integer> tree = new MyTree<Integer>();
		tree.root = new MyTreeNode<Integer>(1);
		tree.root.left = new MyTreeNode<Integer>(2);
		tree.root.right = new MyTreeNode<Integer>(3);
		tree.root.left.left = new MyTreeNode<Integer>(4);
		tree.root.left.right = new MyTreeNode<Integer>(5);
		
		tree.printInOrder(tree.root);
	}
	
	

}
