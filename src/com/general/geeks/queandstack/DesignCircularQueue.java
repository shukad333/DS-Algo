package com.general.geeks.queandstack;

/**
 * Design your implementation of the circular queue. The circular queue is a
 * linear data structure in which the operations are performed based on FIFO
 * (First In First Out) principle and the last position is connected back to the
 * first position to make a circle. It is also called "Ring Buffer".
 * 
 * One of the benefits of the circular queue is that we can make use of the
 * spaces in front of the queue. In a normal queue, once the queue becomes full,
 * we cannot insert the next element even if there is a space in front of the
 * queue. But using the circular queue, we can use the space to store new
 * values.
 * 
 * Your implementation should support following operations:
 * 
 * MyCircularQueue(k): Constructor, set the size of the queue to be k. Front:
 * Get the front item from the queue. If the queue is empty, return -1. Rear:
 * Get the last item from the queue. If the queue is empty, return -1.
 * enQueue(value): Insert an element into the circular queue. Return true if the
 * operation is successful. deQueue(): Delete an element from the circular
 * queue. Return true if the operation is successful. isEmpty(): Checks whether
 * the circular queue is empty or not. isFull(): Checks whether the circular
 * queue is full or not.
 * 
 * 
 * Example:
 * 
 * MyCircularQueue circularQueue = new MycircularQueue(3); // set the size to be
 * 3 circularQueue.enQueue(1); // return true circularQueue.enQueue(2); //
 * return true circularQueue.enQueue(3); // return true
 * circularQueue.enQueue(4); // return false, the queue is full
 * circularQueue.Rear(); // return 3 circularQueue.isFull(); // return true
 * circularQueue.deQueue(); // return true circularQueue.enQueue(4); // return
 * true circularQueue.Rear(); // return 4
 * 
 * Note:
 * 
 * All values will be in the range of [0, 1000]. The number of operations will
 * be in the range of [1, 1000]. Please do not use the built-in Queue library.
 * 
 * 
 * @author skadavath
 *
 */
public class DesignCircularQueue {

	public static void main(String[] args) {

		DesignCircularQueue designCircularQueue = new DesignCircularQueue(4);
		designCircularQueue.insertFront(12);
		designCircularQueue.insertLast(14);
		designCircularQueue.insertLast(16);
		designCircularQueue.deleteFront();

	}


	int size;
	int k;
	DoubleListNode head;
	DoubleListNode tail;
	/** Initialize your data structure here. Set the size of the deque to be k. */
	public DesignCircularQueue(int k) {
		head = new DoubleListNode(-1);
		tail = new DoubleListNode(-1);
		head.pre = tail;
		tail.next = head;
		this.k = k;
		this.size = 0;
	}

	/** Adds an item at the front of Deque. Return true if the operation is successful. */
	public boolean insertFront(int value) {
		if (size == k)
			return false;
		DoubleListNode node = new DoubleListNode(value);
		node.next = head;
		node.pre = head.pre;
		head.pre.next = node;
		head.pre = node;
		size++;
		return true;
	}

	/** Adds an item at the rear of Deque. Return true if the operation is successful. */
	public boolean insertLast(int value) {
		if (size == k)
			return false;
		DoubleListNode node = new DoubleListNode(value);
		node.next = tail.next;
		tail.next.pre = node;
		tail.next = node;
		node.pre = tail;
		size++;
		return true;
	}

	/** Deletes an item from the front of Deque. Return true if the operation is successful. */
	public boolean deleteFront() {
		if (size == 0)
			return false;
		head.pre.pre.next = head;
		head.pre = head.pre.pre;
		size--;
		return true;
	}

	/** Deletes an item from the rear of Deque. Return true if the operation is successful. */
	public boolean deleteLast() {
		if (size == 0)
			return false;
		tail.next.next.pre = tail;
		tail.next = tail.next.next;
		size--;
		return true;
	}

	/** Get the front item from the deque. */
	public int getFront() {
		return head.pre.val;
	}

	/** Get the last item from the deque. */
	public int getRear() {
		return tail.next.val;
	}

	/** Checks whether the circular deque is empty or not. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Checks whether the circular deque is full or not. */
	public boolean isFull() {
		return size == k;
	}
}

class DoubleListNode {
	DoubleListNode pre;
	DoubleListNode next;
	int val;
	public DoubleListNode(int val) {
		this.val = val;
	}

}
