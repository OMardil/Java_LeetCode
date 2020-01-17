package pckg_dflt;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class MinWindowSubstring {

	public static void main(String[] args) {

		String s1 = new MinWindowSubstring().minWindow("AAA", "AA");
		System.out.println("Answer: " + s1);
		
		s1 = new MinWindowSubstring().minWindow("ABAACBAB", "ABC");
		System.out.println("Answer: " + s1);		
				
		s1 = new MinWindowSubstring().minWindow("ADOBECODEBANC", "ABC");
		System.out.println("Answer: " + s1);		

		s1 = new MinWindowSubstring().minWindow("A", "B");
		System.out.println("Answer: " + s1);		
				

	}

	public String minWindow(String s, String t) {

		HashMap<Character, Integer> dictionary = new HashMap<Character, Integer>();
		HashMap<Character, Integer> windowLetters = new HashMap<Character, Integer>();
		for (int i = 0; i < t.length(); i++) {
			dictionary.put(t.charAt(i),dictionary.getOrDefault(t.charAt(i),0)+1);
		}

		if (s.length() < t.length()) {
			return "";
		}

		int bestLeft = -1;
		int bestRight = -1;
		int left = 0;
		int right = 0;
		int smallestWindow = Integer.MAX_VALUE;
		boolean validAnswer = false;
		
        if (dictionary.containsKey(s.charAt(left)))
		    windowLetters.put(s.charAt(left),1);

		while (right < s.length()) {
			// check if every letter exists in range from left to right
			// if it does, then check if current response is better than stored response
			if (isValidRange(dictionary, windowLetters)) {
				validAnswer = true;
				if (right - left < smallestWindow) {
					smallestWindow = Math.min(smallestWindow, right - left);
					bestLeft = left;
					bestRight = right;
				}

				char letter = s.charAt(left);
				int letterCount = windowLetters.getOrDefault(letter, -1);
				if (letterCount > 1) {
					windowLetters.put(letter, letterCount-1);
				} else if (letterCount == 1) {
					windowLetters.remove(letter);
				} 
				left++;
				// subtract 1 from hashmap. If hashmap stores a 0, remove it.
			} else {
				right++;
				// add 1 to HashMap. If hashmap does not include letter, add it
				if (right < s.length()) {
					char letter = s.charAt(right);
					if (dictionary.containsKey(letter)) {
						windowLetters.put(letter, windowLetters.getOrDefault(letter, 0) + 1);
					}
				}
			}
		}
		
		validAnswer = validAnswer?validAnswer:isValidRange(dictionary, windowLetters);
		return validAnswer?s.substring(bestLeft, bestRight + 1):"";
	}


	public static boolean isValidRange(HashMap<Character, Integer> requiredLetters, HashMap<Character, Integer> currentLetters) {

		for(Entry<Character, Integer> e1: requiredLetters.entrySet()) {
			if (currentLetters.getOrDefault(e1.getKey(), -1) < e1.getValue())
				return false;
		}
			
		
		return true;

	}
}
