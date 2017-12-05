package inventory;

public class Node<T>
{
	T data;
	Node next;
	
	public Node() {
		data = null;
		next = null;
	}

	public Node(T newItem, Node nextN)
	{
		this.data = newItem;
		this.next = nextN;
	}
}