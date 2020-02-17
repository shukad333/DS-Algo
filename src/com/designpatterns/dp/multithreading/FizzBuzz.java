package com.designpatterns.dp.multithreading;

import java.util.ConcurrentModificationException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzz {
	
	private AtomicInteger counter;
	private int n;

    public FizzBuzz(int n) {
        this.n = n;
        counter = new AtomicInteger();
    }

    private void updateNextVal(int val) {
    	if(!counter.compareAndSet(val, val+1))
    		throw new ConcurrentModificationException();
    }
    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
    	
    	int count;
    	while((count=counter.get())<=n) {
    		if(count%3==0 && count%5!=0) {
    			printFizz.run();
    			updateNextVal(count);
    		}
    	}
        
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 != 0 && count % 5 == 0) {
                printBuzz.run();
                updateNextVal(count);
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        int count;
        while ((count = counter.get()) <= n) {
            if (count % 3 == 0 && count % 5 == 0) {
                printFizzBuzz.run();
                updateNextVal(count);
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
    	int count;
    	while((count=counter.get())<=n) {
    		if(count%3!=0 && count%5!=0) {
    			printNumber.accept(count);
    			updateNextVal(count);
    		}
    	}
        
    }

}
