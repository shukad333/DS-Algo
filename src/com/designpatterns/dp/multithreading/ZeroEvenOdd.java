package com.designpatterns.dp.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 
 * Suppose you are given the following code:
 * 
 * class ZeroEvenOdd { public ZeroEvenOdd(int n) { ... } // constructor public
 * void zero(printNumber) { ... } // only output 0's public void
 * even(printNumber) { ... } // only output even numbers public void
 * odd(printNumber) { ... } // only output odd numbers } The same instance of
 * ZeroEvenOdd will be passed to three different threads:
 * 
 * Thread A will call zero() which should only output 0's. Thread B will call
 * even() which should only ouput even numbers. Thread C will call odd() which
 * should only output odd numbers. Each of the thread is given a printNumber
 * method to output an integer. Modify the given program to output the series
 * 010203040506... where the length of the series must be 2n.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 2 Output: "0102" Explanation: There are three threads being fired
 * asynchronously. One of them calls zero(), the other calls even(), and the
 * last one calls odd(). "0102" is the correct output. Example 2:
 * 
 * Input: n = 5 Output: "0102030405"
 * 
 * @author skadavath
 *
 */
public class ZeroEvenOdd {

	public static void main(String[] args) {
		
		Executor ex = Executors.newFixedThreadPool(3);
		final IntConsumer it = (x)->System.out.println(x);
		ZeroEvenOdd zeo = new ZeroEvenOdd(10);
		Runnable runn = new Runnable() {
			
			@Override
			public void run() {
				try {
					zeo.zero(it);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
Runnable runn1 = new Runnable() {
			
			@Override
			public void run() {
				
				try {
					zeo.even(it);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
Runnable runn2 = new Runnable() {
			
			@Override
			public void run() {
				
				try {
					zeo.odd(it);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		ex.execute(runn);
		ex.execute(runn1);
		ex.execute(runn2);
		
	}

	private int n;

	Semaphore s1, s2, s3;

	public ZeroEvenOdd(int n) {
		this.n = n;
		s1 = new Semaphore(1);
		s2 = new Semaphore(0);
		s3 = new Semaphore(0);
		Semaphore s4 = new Semaphore(12,true);
		ScheduledExecutorService s = Executors.newScheduledThreadPool(12);


	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void zero(IntConsumer printNumber) throws InterruptedException {

		for (int i = 0; i < n; i++) {
			s1.acquire();
			printNumber.accept(0);
			if (i % 2 == 0)
				s3.release();
			else
				s2.release();
		}

	}

	public void even(IntConsumer printNumber) throws InterruptedException {

		for (int i = 2; i <= n; i += 2) {
			s2.acquire();
			printNumber.accept(i);
			s1.release();
		}

	}

	public void odd(IntConsumer printNumber) throws InterruptedException {

		for (int i = 1; i <= n; i += 2) {
			s3.acquire();
			printNumber.accept(i);
			s1.release();
		}

	}

}
