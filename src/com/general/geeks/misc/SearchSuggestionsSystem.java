package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * Given an array of strings products and a string searchWord. We want to design
 * a system that suggests at most three product names from products after each
 * character of searchWord is typed. Suggested products should have common
 * prefix with the searchWord. If there are more than three products with a
 * common prefix return the three lexicographically minimums products.
 * 
 * Return list of lists of the suggested products after each character of
 * searchWord is typed.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"],
 * searchWord = "mouse" Output: [ ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"], ["mouse","mousepad"], ["mouse","mousepad"],
 * ["mouse","mousepad"] ] Explanation: products sorted lexicographically =
 * ["mobile","moneypot","monitor","mouse","mousepad"] After typing m and mo all
 * products match and we show user ["mobile","moneypot","monitor"] After typing
 * mou, mous and mouse the system suggests ["mouse","mousepad"] Example 2:
 * 
 * Input: products = ["havana"], searchWord = "havana" Output:
 * [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]] Example
 * 3:
 * 
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord =
 * "bags" Output:
 * [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 * 
 * Input: products = ["havana"], searchWord = "tatiana" Output:
 * [[],[],[],[],[],[],[]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= products.length <= 1000 There are no repeated elements in products. 1 <=
 * Σ products[i].length <= 2 * 10^4 All characters of products[i] are lower-case
 * English letters. 1 <= searchWord.length <= 1000 All characters of searchWord
 * are lower-case English letters.
 * 
 * @author skadavath
 *
 */
public class SearchSuggestionsSystem {
	
	public static void main(String[] args) {
		
		System.out.println(new SearchSuggestionsSystem()._suggestedProducts(new String[] {"mobile","mouse","moneypot","monitor","mousepad"}, "mouse"));
		
	}
	
	public List<List<String>> _suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(products);
        for (int i = 1; i <= searchWord.length(); ++i) {
            String cur = searchWord.substring(0, i);
            int k = Arrays.binarySearch(products, cur);
            while (k > 0 && cur.equals(products[k - 1])) // in case there are more than 1 cur in products.
                --k; // find the first one. 
            if (k < 0) // no cur in products. 
                k = ~k; // find the first one larger than cur.
            List<String> suggestion = new ArrayList<>();
            for (int j = k + 3; k < products.length && k < j && products[k].startsWith(cur); ++k)
                suggestion.add(products[k]);
            ans.add(suggestion);
        }
        return ans;
    }

	public List<List<String>> suggestedProducts(String[] products, String searchWord) {

		SearchTrie root = new SearchTrie();
		for (String str : products) {
			SearchTrie trie = root;
			for (char c : str.toCharArray()) {

				if (trie.chars[c - 'a'] == null)
					trie.chars[c - 'a'] = new SearchTrie();
				trie = trie.chars[c - 'a'];
				trie.suggestions.add(str);
				Collections.sort(trie.suggestions);
				if (trie.suggestions.size() > 3) {
					trie.suggestions.pollLast();
				}
			}
		}
		
		List<List<String>> resp = new ArrayList<List<String>>();
		//searching
		SearchTrie trie = root;
		for(char c : searchWord.toCharArray()) {
			if(null!=trie) {
				trie = trie.chars[c-'a'];
			}
			
			resp.add(null==trie?new ArrayList<>():trie.suggestions);
		}
		
		return resp;

	}

}

class SearchTrie {
	SearchTrie[] chars = new SearchTrie[26];
	LinkedList<String> suggestions = new LinkedList<>();
}
