package pckg_dflt;
//552. Student Attendance Record II

/*
 * Given a positive integer n, return the number of all possible 
 * attendance records with length n, which will be regarded as rewardable. 
 * The answer may be very large, return it after mod 109 + 7.

A student attendance record is a string that only contains 
the following three characters:

'A' : Absent.
'L' : Late.
'P' : Present.
A record is regarded as rewardable if it doesn't contain more than 
one 'A' (absent) or more than two continuous 'L' (late).

*/

public class StudentAttendance {

	public static String[] possibleValues = {"A", "L", "P"};
	
	public static void main(String[] args) {
		int out = checkRecord(100);
		System.out.println(out);
	}
	
    public static int checkRecord(int n) {
    	
        int o1 = (int)backTrack("","A",n);
        int o2 = (int)backTrack("","L",n);
        int o3 = (int)backTrack("","P",n);
        
        return o1 + o2 + o3;
    }	
    
    public static long backTrack(String combination, String add,  int n) {
    	//when do i finish?
    	
    	//1. when adding a second consecutive "late"
    	if (combination.length()>1) {
	    	String lastLetter = 
	    			combination.substring(combination.length()-2, combination.length());
			if (add.equals("L") && lastLetter.equals("LL")) {
				return 0;
			}
    	}
		
		//2. when adding a second absence
		if (add.equals("A") && combination.indexOf("A") != -1) {
			return 0;
    	}
		
		//3. if no more values should be added.
    	// this string should already have been validated
    	if (n == 1) {
    		return 1;
    	} 		
    		
    	
    	long count = 0;
    	String newCombination = combination + add;
    	for(int i = 0; i<3; i++) {
    		count += backTrack(newCombination, possibleValues[i], n-1);
    	}
    	
    	return count % 1000000007;
    	
    	
    	
    }

}
