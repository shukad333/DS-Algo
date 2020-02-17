package com.designpatterns.dp.multithreading;

import java.util.concurrent.Semaphore;

/**
 * 
 * Five silent philosophers sit at a round table with bowls of spaghetti. Forks
 * are placed between each pair of adjacent philosophers.
 * 
 * Each philosopher must alternately think and eat. However, a philosopher can
 * only eat spaghetti when they have both left and right forks. Each fork can be
 * held by only one philosopher and so a philosopher can use the fork only if it
 * is not being used by another philosopher. After an individual philosopher
 * finishes eating, they need to put down both forks so that the forks become
 * available to others. A philosopher can take the fork on their right or the
 * one on their left as they become available, but cannot start eating before
 * getting both forks.
 * 
 * Eating is not limited by the remaining amounts of spaghetti or stomach space;
 * an infinite supply and an infinite demand are assumed.
 * 
 * Design a discipline of behavior (a concurrent algorithm) such that no
 * philosopher will starve; i.e., each can forever continue to alternate between
 * eating and thinking, assuming that no philosopher can know when others may
 * want to eat or think.
 * 
 * 
 * The philosophers' ids are numbered from 0 to 4 in a clockwise order.
 * Implement the function void wantsToEat(philosopher, pickLeftFork,
 * pickRightFork, eat, putLeftFork, putRightFork) where:
 * 
 * philosopher is the id of the philosopher who wants to eat. pickLeftFork and
 * pickRightFork are functions you can call to pick the corresponding forks of
 * that philosopher. eat is a function you can call to let the philosopher eat
 * once he has picked both forks. putLeftFork and putRightFork are functions
 * you can call to put down the corresponding forks of that philosopher. The
 * philosophers are assumed to be thinking as long as they are not asking to eat
 * (the function is not being called with their number). Five threads, each
 * representing a philosopher, will simultaneously use one object of your class
 * to simulate the process. It is possible that the function will be called for
 * the same philosopher more than once, even before the last call ends.
 * 
 * 
 * 
 * 
 * @author skadavath
 *
 */
public class TheDiningPhilosophers {
	
	private Semaphore[] forks = new Semaphore[5];
	private Semaphore eatingPeople = new Semaphore(2);
	
	
	public TheDiningPhilosophers() {
		for(int i=0;i<5;i++) {
			forks[i] = new Semaphore(1);
		}
	}
	
	public void wantsToEat(int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {
		
		
		Semaphore leftFork = forks[philosopher];
		Semaphore rightFork = forks[(philosopher+5-1)%4];
		
		eatingPeople.acquire();
		
		leftFork.acquire();
		rightFork.acquire();
		pickLeftFork.run();
		pickRightFork.run();
		eat.run();
		putLeftFork.run();
		putRightFork.run();
		leftFork.release();
		rightFork.release();
		
		eatingPeople.release();
		
		
	}
	

}
