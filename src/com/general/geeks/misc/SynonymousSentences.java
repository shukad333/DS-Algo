package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * 
 * Given a list of pairs of equivalent words synonyms and a sentence text, Return all possible synonymous sentences sorted lexicographically.
 

Example 1:

Input:
synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
text = "I am happy today but was sad yesterday"
Output:
["I am cheerful today but was sad yesterday",
​​​​​​​"I am cheerful today but was sorrow yesterday",
"I am happy today but was sad yesterday",
"I am happy today but was sorrow yesterday",
"I am joy today but was sad yesterday",
"I am joy today but was sorrow yesterday"]
 

Constraints:

0 <= synonyms.length <= 10
synonyms[i].length == 2
synonyms[0] != synonyms[1]
All words consist of at most 10 English letters only.
text is a single space separated sentence of at most 10 words.
 * 
 * @author skadavath
 *
 */
public class SynonymousSentences {
	
	public static void main(String[] args) {
		
		List<List<String>> syn = new ArrayList<>();
		syn.add(Arrays.asList("happy","joy"));
		syn.add(Arrays.asList("sad","sorrow"));
		syn.add(Arrays.asList("joy","cheerful"));
		
		
		System.out.println(new SynonymousSentences().generateSentences(syn, "I am happy today but was sad yesterday"));
		
	}

	public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> synonymPair : synonyms) {
            String w1 = synonymPair.get(0), w2 = synonymPair.get(1);
            connect(graph, w1, w2);
            connect(graph, w2, w1);
        }
        // BFS
        HashSet<String> ans = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(text);
        while (!q.isEmpty()) {
            String out = q.remove();
            ans.add(out); // Add to result
            List<String> words = Arrays.asList(out.split("\\s"));
            for (int i = 0; i < words.size(); i++) {
                String word = words.get(i);
                if (graph.get(word) == null) continue;
                for (String neighbor : graph.get(word)) {
                    words.set(i, neighbor);
                    String newText = words.stream().collect(Collectors
                    		.joining(" "));
                    if (!ans.contains(newText)) q.add(newText);
                }
            }
        }
        List<String> output = new ArrayList<>(ans);
        Collections.sort(output);
        return output;
    }

    private void connect(Map<String, List<String>> graph, String v1, String v2) {
        if (graph.get(v1) == null) {
            graph.put(v1, new LinkedList<String>());
        }
        List<String> list = graph.get(v1);
        list.add(v2);
    }
}