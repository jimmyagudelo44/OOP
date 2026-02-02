package linkedList;

public class MyLinkedList<T> {

	private Node<T> start;
	private int length;
	
	public int getLength() {
		return length;
	}
	
	public void setLength(int length) {
		this.length = length;
	}
	
	public Node<T> getStart() {
		return start;
	}

	public void setStart(Node<T> start) {
		this.start = start;
	}

	public MyLinkedList(Node<T> start){
		this.start = start;
		length = 1;
	}
	
	public MyLinkedList() {
		length = 0;
	}
	
	public void add(T data) {
		if(!found(start, data)) {
			Node<T> node = new Node(data);
			node.setNext(start);
			start = node;
			length++;
		}
	}
	
	public void delete(T data) {
		if(length != 0) {
			
			if(length == 1 && start.getData().equals(data))
				start = null;
			
			else if(start.getData().equals(data))
				start = start.getNext();
			
			else if(lastOne(start).getData().equals(data))
				contains(start, data).setNext(null);
				
			else {
				contains(start, data).setNext(
						contains(start, data).getNext().getNext());
			}
			
			length--;
		}
	}
	
	public Node<T> lastOne(Node<T> node) {
		if(node.getNext() == null)
			return node;
		else
			return lastOne(node.getNext());
	}
	
	public Node contains(Node<T> node, T data) {
		Node<T> result = null;
		if(node.getNext() != null && node.getNext().getData().equals(data))
			result = node;
		else
			result = contains(node.getNext(), data);
		return result;
	}
	
	public boolean found(Node<T> node, T data) {
		if(length != 0) {
			boolean found = node.getData().equals(data);
			if(!found && node.getNext() != null)
				found = found(node.getNext(), data);
			return found;
		}else
			return false;
	}
	
	@Override
	public String toString() {
		return length == 0? "No hay ningun numero aun" : allNodesToString(start);
	}
	
	public String allNodesToString(Node<T> node) {
		String total = "";
		if(node.getNext() != null)
			total += node.getData().toString() + ", " + allNodesToString(node.getNext());
		else
			total += node.getData().toString();
		return total;
	}
	
}
