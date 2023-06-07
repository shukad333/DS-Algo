package com.general.geeks.trie;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class Trie2 {

    TrieWithPrefixCount root;

    public static void main(String[] args) {
        Trie2 trie2 = new Trie2();
        trie2.insert("shuhail");
        trie2.insert("shamu");
        System.out.println(trie2.withSimilarPrefix("shu"));
    }
    public Trie2() {
        root = new TrieWithPrefixCount(' ');
    }

    void insert(String word) {

        TrieWithPrefixCount curr = root;

        for(char c : word.toCharArray()) {
            if(curr.children[c-'a']==null) {
                curr.children[c-'a'] = new TrieWithPrefixCount(c);
            }

            curr = curr.children[c-'a'];
            curr.prefixCount++;
        }
        curr.isWord = true;

    }

    int withSimilarPrefix(String s) {

        TrieWithPrefixCount curr = root;
        for(char c : s.toCharArray()) {
            if(curr.children[c-'a']!=null) {
                curr = curr.children[c-'a'];;
            }
            else {
                return 0;
            }
        }

        return curr.prefixCount;
    }
}


class TrieWithPrefixCount {
    TrieWithPrefixCount[] children;
    boolean isWord;
    int prefixCount;
    char c;
    public TrieWithPrefixCount(char c ) {
        this.c = c;
        this.children = new TrieWithPrefixCount[26];
    }
}