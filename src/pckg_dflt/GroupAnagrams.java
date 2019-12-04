package pckg_dflt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		
		List<List<String>> output = groupAnagrams(new String[]{"are", "bat", "ear", "code", "tab", "era"});
		
		for(List<String> s1: output) {
			for (String s2: s1) {
				System.out.print(s2 + " ");
			}
			System.out.println();
		}

	}
	
	    public static List<List<String>> groupAnagrams(String[] strs) {

	        Map<String, Integer> hashList = new HashMap<String, Integer>();
	        List<List<String>> output = new ArrayList<List<String>>();
	        
	        
	        int count = 0;
	        for(String s1: strs) {
	        	String strProfile = letterCount(s1);
	        	if (hashList.containsKey(strProfile)) {
	        		int index = hashList.get(strProfile);
	        		output.get(index).add(s1);
	        	} else {
	        		hashList.put(strProfile, output.size());
	        		
	        		List<String> newList = new ArrayList<String>();
	        		newList.add(s1);
	        		output.add(newList);
	        		

	        	}
	        	
	        }
			
	        
	        return output;   
	    }
	    
	    
	    //return a String with letter counts concatenated
	    // letterCount("abcd") --> "1,1,1,1,0,0,0,0,0,0,0,..." 
	    public static String letterCount(String s1){
	        char[] letters = s1.toCharArray();
	        int[] letterCount = new int[26];
	        
	        for(char c1: letters) {
	        	letterCount[c1-'a']++;
	        }
	        
	        String output = "";
	        for(int i1: letterCount) {
	        	output += i1 + "|";
	        }
	        
	        return output;
	    }

}
