package exercises;

import java.util.Arrays;

public class One {
	final int INITIAL_SIZE = 5;
	private Object items[];

	private int top;

	public One() {
		items = new Object[INITIAL_SIZE];
		top = -1;
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public boolean isFull() {
		return top == items.length - 1;
	}

	private void grow() {
		items = Arrays.copyOf(items, items.length * 2);
	}

	public void popAll() {
		items = new Object[top];
		top = -1;
	}

	public void push(Object newItem) {
		if (!isFull()) {
			items[++top] = newItem;

		} else {
			grow();
			items[++top] = newItem;
		}
	}

	public Object pop() throws RuntimeException {
		if (!isEmpty()) {
			return items[top--];
		} else {
			throw new RuntimeException();
		}
	}

	public Object peek() throws RuntimeException {
		if (isEmpty()) {
			return items[top];
		} else {
			throw new RuntimeException();
		}
	}
}
