package stacksAndQueues;

import java.util.NoSuchElementException;

public class Queue<T> {

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T data) {
		QueueNode<T> node = new QueueNode<T>(data);
		if (last != null)
			last.setNext(node);
		last = node;
		if (first == null)
			first = node;
	}

	public T remove() {
		if (first == null)
			throw new NoSuchElementException();
		else {
			T node = first.getData();
			first = first.getNext();
			return node;
		}
	}

	public T peek() {
		if (first == null)
			throw new NoSuchElementException();
		else
			return first.getData();
	}

	public boolean isEmpty() {
		if (first == null)
			return true;
		else
			return false;
	}

	public QueueNode<T> getFirst() {
		return first;
	}

	public void setFirst(QueueNode<T> first) {
		this.first = first;
	}

	public QueueNode<T> getLast() {
		return last;
	}

	public void setLast(QueueNode<T> last) {
		this.last = last;
	}

}
