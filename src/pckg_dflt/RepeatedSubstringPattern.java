package pckg_dflt;

public class RepeatedSubstringPattern {

	public static void main(String[] args) {
		
		boolean b1 = repeatedSubstringPattern("ababba");
		if (!b1)
			System.out.println(true);
		
		
	}
	
	/* 
	 * O(n)
	 * 
	 * Loop (i)
	 * 
	 * Loop: length 1 string
	 * -> 1,2,3,4,5,6,7
	 * -> substring(0,i)
	 * 
	 * length 2 string
	 * -> 2,4,6,8
	 * -> substring(0,i)
	 * 
	 * stop when i reach size/2
	 * 
	 * 
	 * Test cases:
	 * "abcabc"
	 * ""
	 * "abcabcabeabcabcabc"
	 * 
	 * "12345123456"
	 * 
	 * "12345612345"
	 */
	
	public static boolean repeatedSubstringPattern(String s1) {
		
		
		int strlen = s1.length();
		
		for(int i = 1; i<=strlen/2; i++) {
			if (repeatedSubstringPattern(s1, i)) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean repeatedSubstringPattern(String s1, int position) {
		
		int strlen = s1.length();
		if (strlen % position != 0)
			return false;

	    String sub = s1.substring(0,position);

				
		for(int i=position; i<=(strlen-position); i+=position) {			
			if (!sub.equals(s1.substring(i,i+position)))
				return false;
		}
		
		return true;
	}	
	
}


