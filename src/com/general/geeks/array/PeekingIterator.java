package com.general.geeks.array;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> it = null;
	Integer next = null;

	public PeekingIterator(Iterator<Integer> iterator) {

		this.it = iterator;
		next = it == null ? null : it.next();
	}

	@Override
	public boolean hasNext() {

		return null != next;
	}

	@Override
	public Integer next() {

		Integer resp = next;
		next = it.hasNext() ? it.next() : null;
		return resp;

	}

	public Integer peek() {
		return next;
	}

}
