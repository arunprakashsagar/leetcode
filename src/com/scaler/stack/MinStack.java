package com.scaler.stack;

import java.util.ArrayList;

public class MinStack {

	public MinStack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push(1);
		s.push(23);
		s.push(5);
		s.pop();
		s.push(0);
		s.getMin();
	}
}

class MyStack {
	ArrayList<Integer> list = new ArrayList();
	ArrayList<Integer> minList = new ArrayList();

	public void push(int x) {
		list.add(x);
		if (minList.size() == 0) {
			minList.add(x);
		} else if (x < minList.get(minList.size() - 1)) {
			minList.add(x);
		} else
			minList.add(minList.get(minList.size() - 1));

	}

	public void pop() {
		if (list.size() == 0)
			return;
		list.remove(list.size() - 1);
		minList.remove(minList.get(minList.size() - 1));
	}

	public int top() {
		if (list.size() == 0)
			return -1;
		return list.get(list.size() - 1);

	}

	public int getMin() {
		if (minList.size() == 0)
			return -1;
		return minList.get(minList.size() - 1);

	}
}
