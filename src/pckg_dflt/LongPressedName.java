package pckg_dflt;

public class LongPressedName {

	public static void main(String[] args) {

		boolean b1 = new LongPressedName().isLongPressedName("alets", "aaleex");
		System.out.println(b1);

		b1 = new LongPressedName().isLongPressedName("alex", "aleeeeex");
		System.out.println(b1);
		
		b1 = new LongPressedName().isLongPressedName("alex", "aaaaaale");
		System.out.println(b1);		
		
		b1 = new LongPressedName().isLongPressedName("ale", "bale");
		System.out.println(b1);
		
		b1 = new LongPressedName().isLongPressedName("", "");
		System.out.println(b1);
		
		b1 = new LongPressedName().isLongPressedName("leelee", "leeeleel");
		System.out.println(b1);
		
		b1 = new LongPressedName().isLongPressedName("pyplrz", "ppyypllr");
		System.out.println(b1);		
	}
	
    public boolean isLongPressedName(String name, String typed) {
        

    	/* 1. Compare first position of both strings
    	 * -> If the same:
    	 * -----> Move forward once on name. If repeated letter appears, turn on flag
    	 * 		  that indicates how many times we moved forward.
    	 * -----> Move forward as many times as required on typed. If flag is on from
    	 * 		  previous step, make sure we moved at least flag times.
    	 * -> If length of (Name - indexName) > (typed -indexTyped), finish early
    	 * -> When we reach end of string, on one but not the other, we can finish
    	 */
         
    	int indexTyped = 0;
    	int indexName = 0;
    	while(indexName < name.length()) {
    		
            if (name.length()-indexName > typed.length()-indexTyped){
                return false;
            }
    		
    		char cTyped = typed.charAt(indexTyped);
    		char cName  = name.charAt(indexName);
    		
    		if (cTyped == cName) {
    			int repeatedLetter = 0;

    			while(++indexName < name.length() && cName == name.charAt(indexName))
    				repeatedLetter++;    			
    			
    			while(++indexTyped < typed.length() && cTyped == typed.charAt(indexTyped)) {
    				repeatedLetter--;
    			}
    			
    			if (repeatedLetter > 0) {
    				return false;
    			}	
    		} else {
    			return false;
    		}

    	}
    	
        if (indexTyped != typed.length()) {
        	return false;
        }
        return true;
        
    }	

}
