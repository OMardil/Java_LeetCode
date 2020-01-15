package pckg_dflt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {

	public static void main(String[] args) {
		
		List<String> possiblePalindromes = calcPossiblePalindromesSuffix("abcd");
		for(String s1: possiblePalindromes) {
			System.out.println("Pal: " + s1);
		}
		
		List<List<Integer>> pairList = new PalindromePairs().palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" });
		
		for(List<Integer> pair: pairList) {
			for(int i1: pair) {
				System.out.print(i1 + " ");
			}
			System.out.println();
		}
		
	}
	
	public static String reverse(String str) {
		StringBuilder reverse = new StringBuilder(str);
		return reverse.reverse().toString();		
	}

	public List<List<Integer>> palindromePairs(String[] words) {

		HashMap<String, Integer> dictionary = new HashMap<String, Integer>();

		// fill dictionary with all words
		for (int i = 0; i < words.length; i++) {
			dictionary.put(words[i], i);
		}

		List<List<Integer>> out = new ArrayList<List<Integer>>();

		List<Integer> pair = new ArrayList<Integer>();
		// option 1: two words exactly reversed can be concatenated
		for (int i = 0; i < words.length; i++) {
			String search = reverse(words[i]);

			int index = dictionary.getOrDefault(search, -1);
			if (index >= 0 && index != i) {
				pair.add(index);
				pair.add(i);
				out.add(pair);
				pair = new ArrayList<Integer>();
			}
		}

		// option 2: Check for preffix
		List<String> possiblePalindrome;

		for (int i = 0; i < words.length; i++) {
			possiblePalindrome = calcPossiblePalindromesPreffix(words[i]);
			for (String search : possiblePalindrome) {
				int index = dictionary.getOrDefault(reverse(search), -1);
				if (index >= 0 && index != i) {
					pair.add(index);
					pair.add(i);
					out.add(pair);
					pair = new ArrayList<Integer>();
				}
			}

			// option 3: Check for suffix
			possiblePalindrome = calcPossiblePalindromesSuffix(words[i]);
			for (String search : possiblePalindrome) {
				int index = dictionary.getOrDefault(reverse(search), -1);
				if (index >= 0 && index != i) {
					pair.add(i);
					pair.add(index);
					out.add(pair);
					pair = new ArrayList<Integer>();
				}
			}
		}

		return out;

	}

	public static List<String> calcPossiblePalindromesPreffix(String word) {

		List<String> out = new ArrayList<String>();

		int begin = 0;
		int end = word.length() - 1;

		while (end >= begin) {
			char cBegin = word.charAt(begin);
			char cEnd = word.charAt(end);

			if (cBegin == cEnd) {

				int auxBegin = begin + 1;
				int auxEnd = end - 1;

				boolean keepGoing = true;
				while (keepGoing && auxEnd > auxBegin) {
					keepGoing = word.charAt(auxBegin) == word.charAt(auxEnd) ? true : false;
					auxEnd--;
					auxBegin++;
				}

				if (keepGoing) {
					out.add(word.substring(end+1, word.length()));
				}
			}

			end--;
		}

		return out;

	}

	public static List<String> calcPossiblePalindromesSuffix(String word) {

		List<String> out = new ArrayList<String>();

		int begin = 0;
		int end = word.length() - 1;

		while (end >= begin) {
			char cBegin = word.charAt(begin);
			char cEnd = word.charAt(end);

			if (cBegin == cEnd) {

				int auxBegin = begin + 1;
				int auxEnd = end - 1;

				boolean keepGoing = true;
				while (keepGoing && auxEnd > auxBegin) {
					keepGoing = word.charAt(auxBegin) == word.charAt(auxEnd) ? true : false;
					auxEnd--;
					auxBegin++;
				}

				if (keepGoing) {
					out.add(word.substring(0, begin+1));
				}
			}

			begin++;
		}

		return out;

	}

}
