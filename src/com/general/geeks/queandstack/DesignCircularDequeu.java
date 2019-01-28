package com.general.geeks.queandstack;

/**
 * 
 * 
 * @author skadavath
 *
 */
public class DesignCircularDequeu {
	
	int[] arr;
    int front = 0, rear = -1, len = 0, size;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public DesignCircularDequeu(int k) {
        arr = new int[k];
        size = k;  
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull()){
            return false;
        }else{
            front = (front - 1) % size;
            if(front < 0){
                front += size;
            }
            arr[front] = value;
            len++;
            //  Corner case： add Front -> get Rear
            //  This kind of case which can be handled in: Add rear -> get front
            //  In which rear has a initial of -1
            if(len == 1){
                rear = front;
            }
            return true;
        }
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull()){
            return false;
        }else{
            rear = (rear + 1) % size;
            arr[rear] = value;
            len++;
            return true;
        }
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty()){
            return false;
        }else{
            front = (front + 1) % size;
            len--;
            return true;
        }
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty()){
            return false;
        }else{
            rear = (rear - 1) % size;
            if(rear < 0){
                rear += size;
            }
            len--;
            return true;
        }
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()){
            return -1;
        }else{
            return arr[front];
        }
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()){
            return -1;
        }else{
            return arr[rear];
        }
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return len == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return len == size;
    }
}



