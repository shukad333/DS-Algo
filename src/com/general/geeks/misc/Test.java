package com.general.geeks.misc;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

class Abc {

	String name;
	List<String> bundles;
}

public class Test {

	static void acc(String s) {
		System.out.println("Got s");
	}
	public static void main(String[] args) throws InterruptedException {

		Map<String,String> m = new HashMap<>();
		m.put("shs","litchi");
		m.put("shs","litchi");
		m.put("vxrail1234","litchi");
		m.put("vxrail0009","shu");

		System.out.println(m);

		Set<String> s = m.keySet().stream().filter(b->b.contains("VXRAIL")).collect(Collectors.toSet());
		LinkedHashSet<String> ll = new LinkedHashSet<>();
		ll.addAll(s);

		System.out.println(m);
		Supplier<String> sbb = ()->{ return "Hi";}; System.out.println(sbb.get());

		Tri<String,String,String,String> tt = (a,b,c) -> {return a+b+c+"Shu";};


		System.out.println(tt.apply("shu","me","yo"));

		Map<String,String> m1 = new HashMap<>();
		m1.computeIfAbsent("shu",a->"Shu"+a);
		System.out.println(m1);
		Test.class.getClass().getResourceAsStream("txt");

		Consumer<String> c = (a)-> acc(a);
		c.accept("Shu");
//
//		List<String> bundles = new ArrayList<>();
//		bundles.add("Shu");
//		bundles.add("vxrail");
//		bundles.add("vxrail123");
//		bundles.add("CVxrail123");
//		bundles.add("vxrail34567");
//		Abc abc = new Abc();
//		abc.bundles = bundles;
//
////		abc.bundles.removeIf(b-> b.contains("vxrail"));
//
//		List<String> vxrail = abc.bundles.stream().filter(b->b.contains("vxrail")).collect(Collectors.toList());
//
//		System.out.println(vxrail);
//
//		System.out.println(abc.bundles);
//
//		abc.bundles.removeAll(vxrail);
//
//		System.out.println(abc.bundles);
//
//		int[] arr = {1,1,1,1};
//		System.out.println(Arrays.binarySearch(arr,1));
//		char[] c = {'a','1','b'};
//		System.out.println(((char)(c[0]+Integer.parseInt(c[1]+""))));

		//PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//		int[][] orders = {{8,1},{4,2},{5,6},{3,1},{4,3}};
//		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[1]+a[2])-(b[1]+b[2])));
//
//		int i=0;
//		for(int[] o : orders) {
//			pq.offer(new int[]{i++,o[0],o[1]});
//		}
//
//		System.out.println(pq.peek()[1]+" ccc "+pq.peek()[2]);;
//
//		while(!pq.isEmpty()) {
//			int[] c = pq.poll();
//			System.out.println(c[1]+"   ccc  "+c[2]);;
//		}
//
//		char[] s1 = {'a'};
//		char[] s2 = {'a'};
//		List<Integer> list = Arrays.asList(1,2);


//		pq.add(new Integer[]{4,5});
//		pq.add(new Integer[]{2,6});
//		pq.add(new Integer[]{10,25});
//
//		System.out.println(pq.peek()[0]);

		
		
	}



}

@FunctionalInterface
interface Tri<A,B,C,R>{

	R apply(A a , B b,C c);
}
