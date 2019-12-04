package pckg_dflt;

public class LongestCommonPrefix {

	public static void main(String[] args) {

		String[] data = {"flower", "flow", "flight"};
		String s1 = longestCommonPrefix(data);
		System.out.println(s1);
		
		
		data = new String[]{"dog","racecar","car"};
		s1 = longestCommonPrefix(data);
		System.out.println(s1);		
		
		data = new String[]{};
		s1 = longestCommonPrefix(data);
		System.out.println(s1);		
		
		data = new String[]{"","flow","flower"};
		s1 = longestCommonPrefix(data);
		System.out.println(s1);	
		
		data = new String[]{"flower"};
		s1 = longestCommonPrefix(data);
		System.out.println(s1);		
		
		data = new String[]{"c","c","cc"};
		s1 = longestCommonPrefix(data);
		System.out.println(s1);				
		
		
	}
	
    public static String longestCommonPrefix(String[] strs) {
        
        
        //O(n2)
        // outer loop through every position of word
        // inner loop to advance through every character in String
        
    	if (strs.length == 0 || strs == null) {
    		return "";
    	}
    	
    	if (strs.length == 1) {
    		return strs[0];
    	}

        int end = 0;    	
        for(int i = 0; i<strs[0].length(); i++){
            
            if (strs[0].length() == 0){
                return "";
            }
            
            char commonChar = strs[0].charAt(i);
            for(int j = 1; j<strs.length; j++){
                if (!(strs[j].charAt(i) == commonChar))
                    return strs[0].substring(0,i);
                
                end++;
            }
        }
        
        return (end>=1)?strs[0].substring(0,end-1): "";
    }	

}
