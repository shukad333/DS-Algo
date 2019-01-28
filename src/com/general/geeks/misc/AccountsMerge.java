package com.general.geeks.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some email that is common to both accounts. Note
 * that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of
 * accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * Example 1: Input: accounts = [["John", "johnsmith@mail.com",
 * "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John",
 * "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com',
 * 'johnsmith@mail.com'], ["John", "johnnybravo@mail.com"], ["Mary",
 * "mary@mail.com"]] Explanation: The first and third John's are the same person
 * as they have the common email "johnsmith@mail.com". The second John and Mary
 * are different people as none of their email addresses are used by other
 * accounts. We could return these lists in any order, for example the answer
 * [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'], ['John',
 * 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would
 * still be accepted. Note:
 * 
 * The length of accounts will be in the range [1, 1000]. The length of
 * accounts[i] will be in the range [1, 10]. The length of accounts[i][j] will
 * be in the range [1, 30].
 * 
 * @author skadavath
 *
 */
public class AccountsMerge {

	public static void main(String[] args) {
		List<List<String>> accounts = new ArrayList<>();
		List<String> emails = new ArrayList<>();
		emails.add("Shuhail");
		emails.add("shukad3@gmail.com");
		emails.add("shukad4@gmail.com");
		emails.add("shukad17@gmail.com");
		
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("Shuhail");
		emails.add("shukad5@gmail.com");
		emails.add("shukad3@gmail.com");
		emails.add("shukad23@gmail.com");
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("Shuhail");
		emails.add("shukad0@gmail.com");
		emails.add("shukad1@gmail.com");
		emails.add("shukad8@gmail.com");
		
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("Shuhail");
		emails.add("shukad14@gmail.com");
		emails.add("shukad23@gmail.com");
		
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("Shuhail");
		emails.add("shukad4@gmail.com");
		emails.add("shukad5@gmail.com");
		emails.add("shukad23@gmail.com");
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("Shuhail");
		emails.add("shukad1@gmail.com");
		emails.add("shukad2@gmail.com");
		emails.add("shukad11@gmail.com");
		accounts.add(emails);
		emails = new ArrayList<>();
		emails.add("Shuhail");
		emails.add("shukad2@gmail.com");
		emails.add("shukad0@gmail.com");
		emails.add("shukad14@gmail.com");
		
		accounts.add(emails);

		List<List<String>> resp = new AccountsMerge().accountsMerge(accounts);
		for (List<String> l : resp) {
			for (String s : l) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if(accounts==null || accounts.size()<1){
            return new ArrayList<>();
        }
        int[] parent = new int[accounts.size()];
        for(int i=0;i<parent.length;i++){
            parent[i] = i;
        }
        
        Map<String,Integer> map = new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            List<String> eleStrs = accounts.get(i);
            for(int j=1;j<eleStrs.size();j++){
                String email = eleStrs.get(j);
                if(map.containsKey(email)){
                    int pre_id = map.get(email);
                    int cur_id = i;
                    int parent_pre_id = findParent(parent,pre_id);
                    int parent_cur_id = findParent(parent,cur_id);
                    if(parent_pre_id!=parent_cur_id){
                        parent[parent_cur_id] = parent_pre_id;
                    }
                }else{
                    map.put(email,i);
                }
            }
        }
        
        Map<Integer,Set<String>> hm = new HashMap<>();
        for(int i=0;i<parent.length;i++){
            int index = findParent(parent,i);
            if(!hm.containsKey(index)){
                hm.put(index,new HashSet<>());
            }
            
            Set<String> temp = new HashSet<>();
            for(int j=1;j<accounts.get(i).size();j++){
                temp.add(accounts.get(i).get(j));
            }
            hm.get(index).addAll(temp);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(Integer id : hm.keySet()){
            ans.add(new ArrayList<>());
            ans.get(ans.size()-1).add(accounts.get(id).get(0));
            
            List<String> addemails = new ArrayList<>(hm.get(id));
            Collections.sort(addemails);
            ans.get(ans.size()-1).addAll(addemails);
        }
        
        return ans;
        
    }
    
    public int findParent(int[] parent,int index){
             while(index!=parent[index]){
                 parent[index] = parent[parent[index]];
                 index = parent[index];
             }
        
             return index;
    }
}