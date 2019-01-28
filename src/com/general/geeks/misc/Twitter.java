package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Design a simplified version of Twitter where users can post tweets,
 * follow/unfollow another user and is able to see the 10 most recent tweets in
 * the user's news feed. Your design should support the following methods:
 * 
 * postTweet(userId, tweetId): Compose a new tweet. getNewsFeed(userId):
 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
 * the news feed must be posted by users who the user followed or by the user
 * herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee. Example:
 * 
 * Twitter twitter = new Twitter();
 * 
 * // User 1 posts a new tweet (id = 5). twitter.postTweet(1, 5);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5].
 * twitter.getNewsFeed(1);
 * 
 * // User 1 follows user 2. twitter.follow(1, 2);
 * 
 * // User 2 posts a new tweet (id = 6). twitter.postTweet(2, 6);
 * 
 * // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. //
 * Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
 * twitter.getNewsFeed(1);
 * 
 * // User 1 unfollows user 2. twitter.unfollow(1, 2);
 * 
 * // User 1's news feed should return a list with 1 tweet id -> [5], // since
 * user 1 is no longer following user 2. twitter.getNewsFeed(1);
 * 
 * @author skadavath
 *
 */
public class Twitter {
	
	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		
		List<Integer> tweets = twitter.getNewsFeed(1);
		twitter.postTweet(1, 5);
		System.out.println(tweets);
		twitter.follow(1, 2);
		
		twitter.postTweet(2, 6);
		
		tweets = twitter.getNewsFeed(1);
		System.out.println(tweets);
		twitter.unfollow(1, 2);
		
		tweets = twitter.getNewsFeed(1);
		System.out.println(tweets);
		
	}
	
	List<Tweet> tweets = new ArrayList<>();
	Map<Integer, List<Integer>> followers = new HashMap<>();
	int time;
	
	
	 /** Initialize your data structure here. */
    public Twitter() {
    	time = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	time++;
    	Tweet  tweet = new Tweet(userId,time,tweetId);
    	tweets.add(tweet);
    	
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
    	
    	List<Integer> following = followers.get(userId)==null ? new ArrayList<>() : followers.get(userId);
    	List<Integer> owenTweets = tweets.stream().filter(t -> t.userId == userId || following.contains(t.userId)).sorted(new Comparator<Tweet>() {

			@Override
			public int compare(Tweet o1, Tweet o2) {
				return o2.getTime()-o1.getTime();
			}
    		
		}).limit(10).map(Tweet::getTweetId).collect(Collectors.toList());
    	
    	
    	
    	return owenTweets;
        
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new ArrayList<>());
        followers.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId==followeeId)
            return;
        
        try {
       List<Integer> followerss =  followers.get(followerId);
      int index = followerss.indexOf(followeeId);
      followerss.remove(index);
      followers.put(followerId, followerss);
        }catch(Exception e ) {}
    }
}

class Tweet {
	int userId;
	int time;
	int tweetId;
	public Tweet(int userId,int time, int tweetId) {
		this.userId = userId;
		this.time = time;
		this.tweetId = tweetId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getTweetId() {
		return tweetId;
	}
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	
	
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
