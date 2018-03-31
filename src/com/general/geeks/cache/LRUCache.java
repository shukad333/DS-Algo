package com.general.geeks.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	int capacity;
	Map<Integer,DLL> map = new HashMap<>();
	DLL head = null;
	DLL end = null;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if(map.containsKey(key)) {
			DLL node = map.get(key);
			removeNode(node);
			setHead(node);
			return node.val;
		}
		
		return -1;
	}
	
	public void set(int key,int val) {
		
		if(map.containsKey(key)) {
			DLL old = map.get(key);
			old.val = val;
			removeNode(old);
			setHead(old);
		}
		else {
			DLL dll = new DLL(key, val);
			if(map.size()>=capacity) {
				map.remove(end.key);
				removeNode(end);
				setHead(dll);
			}
			else {
				setHead(dll);
			}
			map.put(key, dll);
		}
		
	}
	
	private void removeNode(DLL n) {
		
		if(null!=n.prev) {
			n.prev.next = n.next;
		}
		else {
			head = n.next;
		}
		
		if(null!=n.next) {
			n.next.prev = n.prev;
		}
		else {
			end = n.prev;
		}
	}
	
	private void setHead(DLL n) {
		
		n.next = head;
		n.prev = null;
		
		if(null!=head) {
			head.prev = n;
		}
		
		head = n;
		if(null == end) {
			end = head;
		}
	}
	
	
	public static void main(String[] args) {
		
		LRUCache cache = new LRUCache(4);
		cache.set(12, 102);
		cache.set(13, 103);
		cache.set(14, 104);
		cache.set(15, 105);
		System.out.println(cache.get(12));
	}
	
}

class DLL {
	
	 int key;
	 int val;
	 DLL next;
	 DLL prev;
	
	
	public DLL(int key,int val) {
		this.key = key;
		this.val = val;
		this.next = null;
		this.prev = null;
	}
	
	
}
