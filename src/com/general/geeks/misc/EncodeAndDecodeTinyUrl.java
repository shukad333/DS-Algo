package com.general.geeks.misc;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL is a URL shortening service where you enter a URL such as
 * https://leetcode.com/problems/design-tinyurl and it returns a short URL such
 * as http://tinyurl.com/4e9iAk.
 * 
 * Design the encode and decode methods for the TinyURL service. There is no
 * restriction on how your encode/decode algorithm should work. You just need to
 * ensure that a URL can be encoded to a tiny URL and the tiny URL can be
 * decoded to the original URL.
 * 
 * Seen this question in a real interview before?
 * 
 * @author skadavath
 *
 */
public class EncodeAndDecodeTinyUrl {
	
	public static void main(String[] args) {
		
		
		EncodeAndDecodeTinyUrl enc = new EncodeAndDecodeTinyUrl();
		System.out.println(enc.decode(enc.encode("www.google.com")));
		
	}
	
	String tinyUrlHost = "http://tinyurl/";
	Map<Integer, String> map = new HashMap<>();
	 // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	
    	int hash = longUrl.hashCode();
    	map.put(hash, longUrl);
        return tinyUrlHost+hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	
    	
    	Integer hash = Integer.parseInt(shortUrl.replace(tinyUrlHost, ""));
    	
    	return map.get(hash);
        
    }

}
