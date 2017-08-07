package LinkedList;

public class MyLinkedList<E> {
	
	private MyNode<E> head = null;
	private int size = 0;
	
	private void travarse(MyNode<E> temp, int pos) {
			
		int count = 1;
		while(count < pos) {
			temp = temp.next;
			count++;
		}
		
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public E remove() {
		
		if (isEmpty()) 
			return null;
		
		MyNode<E> temp = head;
		travarse(temp, size);
		E removedData = temp.data;
		temp.next = null;
		size--;
		return removedData;
	}
	
	public E remove(int pos) {
	
		return null;
	}
	
	public void addFirst(E data) {

		MyNode<E> temp = head;
		final MyNode<E> newNode = new MyNode<E>(data, temp);
		newNode.data = data;
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void add(E data) {
		
		if (isEmpty()) {
			addFirst(data);
		} else {
			addLast(data);
		}
	}
	
	public void addLast(E data) {

		MyNode<E> temp = head;
		int count = 1;
		while(count < size) {
			temp = temp.next;
			System.out.println("Inside travarse : " + temp.data);
			count++;
		}
		
		MyNode<E> newNode = new MyNode<>(data, temp.next);
		newNode.next = null;
		temp.next = newNode;
		size++;
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
		size++;
		
	}

	public void printList() {
		
		MyNode<E> temp = head;
		while(temp != null) {
			System.out.print(temp.data + ", " );
			temp = temp.next;
		}
		
		System.out.println();
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
		mylist.add(101);
		mylist.addFirst(10);
		mylist.add(102);
		
		/*mylist.addFirst(11);
		mylist.addFirst(13);
		mylist.addFirst(14);
		mylist.printList();
		System.out.println();
		
		mylist.addAt(12, 2);
		mylist.printList();
		System.out.println();
		
		mylist.addAt(13, 2);
		mylist.printList();
		System.out.println("---------Add At-------------");
		
		mylist.add(100);
		mylist.add(100);
		mylist.printList();
		System.out.println("---------remove-------------");*/
		
		mylist.printList();
		System.out.println("Removed : " + mylist.remove());
		mylist.printList();
	}

}
