package com.google;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class WordCount implements Iterable<WordCount> {

	String word;
	int count;

	WordsCountIterator iterator;

	public WordCount(List<String> s) {

		Iterator<String> it = s.iterator();
		iterator = new WordsCountIterator(it);

	}

	public WordCount() {

	}

	class WordsCountIterator implements Iterator<WordCount> {

		List<WordCount> wordCounts;
		int index = 0;

		public WordsCountIterator(Iterator<String> iter) {

			String prevWord = null, currWord = null;
			int prevCount = 1;
			while (iter.hasNext()) {

				if (null == wordCounts) {
					wordCounts = new LinkedList<>();
					prevWord = iter.next();

				} else {
					currWord = iter.next();
					if (prevWord.equals(currWord)) {
						prevCount++;

					} else {
						WordCount wc = new WordCount();
						wc.count = prevCount;
						wc.word = prevWord;
						wordCounts.add(wc);
						prevWord = currWord;
						prevCount = 1;
					}
				}

			}

		}

		@Override
		public boolean hasNext() {

			return index < wordCounts.size();
		}

		@Override
		public WordCount next() {

			return wordCounts.get(index++);
		}

	}

	public static void main(String[] args) {
		String[] input = { "foo", "foo", "foo", "bar", "foo", "bar", "bar" };
		List<String> str = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			str.add(input[i]);
		}
		WordCount wordCount = new WordCount(str);
		Iterator<WordCount> wordIterator = wordCount.iterator();
		while (wordIterator.hasNext()) {
			WordCount word = wordIterator.next();
			System.out.println(word.word + " " + word.count);
		}
	}

	@Override
	public Iterator<WordCount> iterator() {

		return iterator;
	}
}