package pckg_dflt;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

//451. Sort Characters By Frequency
/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
*/
public class SortByCharacterFreq {
	
	public static void main(String[] args) {
		
		String s1 = 
				frequencySort("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
						+ "aabababababababababababababababaaaaaaaaaaab"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaabbbbbababababababaabababababababababababa"
				+ "abababababababababababababababababababababababababa"
				+ "bababababababababababababababababababababababababaab");
		System.out.println(s1);
		
	}

    public static String frequencySort(String s) {
        
    	HashMap<Character, Integer> hash = new HashMap();
    	
    	for(int i = 0; i<s.length(); i++) {
    		char c1 = s.charAt(i);
    		hash.put(c1, hash.getOrDefault(c1, 0) + 1);
    	}

    	PriorityQueue<CharFreq> pq = new PriorityQueue<>(new CharFreqComparator());
    	
    	for(char c1: hash.keySet()) {
    		CharFreq pqEntry = new CharFreq();
    		pqEntry.letter = c1;
    		pqEntry.count = hash.get(c1);
    		pq.add(pqEntry);
    	}
    	
    	
    	String output = "";
    	while (!pq.isEmpty()) {
    		CharFreq c = pq.poll();
    		int count = c.count;
    		while (count > 0) {
        		output += c.letter;
        		count--;
    		}

    	}
        
    	
    	return output;
    }
	
}

class CharFreq{
	char letter;
	int count;
}

class CharFreqComparator implements Comparator<CharFreq> {
    @Override
    public int compare(CharFreq c1, CharFreq  c2) {
        return (c2.count - c1.count);
    }
}
