package LinkedList;

public class MyLinkedList<E> {
	
	private MyNode<E> head = null;
	
	private int size = 0;
	
//	public boolean isEmpty() ;
//	public void add(E data);
//	public E remove();
//	public E remove(int pos);
	
	
	public void addFirst(E data) {

		MyNode<E> temp = head;
		final MyNode<E> newNode = new MyNode<E>(data, temp);
		newNode.data = data;
		newNode.next = head;
		head = newNode;
	}
	
	public void addAt(E data, int pos) {
		
		MyNode<E> temp = head;
		
		int count = 1;
		while(count < pos-1) {
			temp = temp.next;
			System.out.println("Inside travarse : " + temp.data);
			count++;
		}
		
		MyNode<E> newNode = new MyNode<E>(data, temp.next);
		temp.next = newNode;
		
	}

	public void printList() {
		
		MyNode<E> temp = head;
		while(temp != null) {
			System.out.print(temp.data + ", " );
			temp = temp.next;
		}
	}
	
	private static final class MyNode<E> {
		
		private E data;
		private MyNode<E> next;
		
		public MyNode(E data, MyNode<E> next) {
			this.data = data;
			this.next = next;
		}
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("This is compile time");
		
		MyLinkedList<Integer> mylist = new MyLinkedList<>();
		mylist.addFirst(10);
		mylist.addFirst(11);
		mylist.addFirst(13);
		mylist.addFirst(14);
		mylist.printList();
		System.out.println();
		
		mylist.addAt(12, 2);
		mylist.printList();
		System.out.println();
		
		mylist.addAt(13, 2);
		
		mylist.printList();
	}

}
