package com.general.geeks.misc;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
Example:
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

 * @author skadavath
 *
 */
public class MinStack {
	
	public static void main(String[] args) {
		MinStack ms = new MinStack();
		ms.push(-2);
		ms.push(0);
		ms.push(-3);
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.top());
	}
	
	int min = Integer.MAX_VALUE;
	Stack<Integer> stack = new Stack<>();
	public MinStack() {

	}

	public void push(int x) {
		if(x<=min) {
			stack.push(min);
			min = x;
		}
		stack.push(x);
	}

	public void pop() {
		if(stack.peek()==min) {
			stack.pop();
			min=stack.pop();
		}
		else
			stack.pop();
	}

	public int top() {

		return stack.peek();

	}

	public int getMin() {

		return min;

	}

}
