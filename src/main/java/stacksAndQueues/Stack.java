package stacksAndQueues;

import java.util.EmptyStackException;

public class Stack<T> {

	private StackNode<T> top;

	public void push(T item) {
		StackNode<T> node = new StackNode<T>(item);
		if (top == null)
			top = node;
		else {
			top.setNext(node);
			top = node;
		}
	}

	public T pop() {
		if (top == null)
			throw new EmptyStackException();
		else {
			T node = top.getData();
			top = top.getNext();
			return node;
		}
	}

	public T peek() {
		if (top == null)
			throw new EmptyStackException();
		else
			return top.getData();
	}

	public boolean isEmpty() {
		if (top == null)
			return true;
		else
			return false;
	}

	public StackNode<T> getTop() {
		return top;
	}

	public void setTop(StackNode<T> top) {
		this.top = top;
	}

}
