package pckg_dflt;
import java.util.Arrays;

public class HouseRobber {

	public static void main(String[] args) {
		int i1 = new HouseRobber().rob(new int[] {2,7,9,3,1});
		System.out.println(i1);
	}

    public int rob(int[] nums) {
        return dp(nums);
    }	
    
    public int dp(int[] remainingHouses) {
    	
    	if (remainingHouses.length <= 0 || remainingHouses == null) {
    		return 0;
    	}
    	
    	if (remainingHouses.length <= 1) {
    		return remainingHouses[0];
    	}
    	
    	remainingHouses[remainingHouses.length-2] 
    			= Math.max(remainingHouses[remainingHouses.length-2], 
    					   remainingHouses[remainingHouses.length-1]);
    	
    	int opt1 = -1; //rob the house
    	int opt2 = -1; //skip robbing the house
    	for(int i = remainingHouses.length-3; i>=0; i--) {
    		opt1 = remainingHouses[i] + remainingHouses[i+2];
    		opt2 = remainingHouses[i+1];
    		remainingHouses[i] = Math.max(opt1, opt2);
    	}
    	
    	return remainingHouses[0];
    }
    
    public int backTrack(int[] remainingHouses) {
    	
    	// when am I done?
    	
    	//1. when trying to rob two consecutive houses 
    	// (covered by method fillPossibleHouses)
    	//2. when no more houses are left
    	if (remainingHouses.length == 0) {
    		return 0;
    	}
    	
    	//try a new combination
    	int maxBounty = -1;
    	int[] newRemainingHouses; 
    	
    	for(int i = 0; i<remainingHouses.length; i++) {
    		
    		newRemainingHouses = fillPossibleHouses(i, remainingHouses);
    		
    		//calculate choice of robbing i house
    		int bounty = 0;
    		bounty = remainingHouses[i] + backTrack(newRemainingHouses);

    		maxBounty = Math.max(maxBounty, bounty);
    		
    	}
    	
    	
    	return maxBounty;
    	
    }
    
    public static int[] fillPossibleHouses(int addingHouseIndex, int[] remainingHouses) {
    	
    	int size = remainingHouses.length-1;
    	if (addingHouseIndex >= 1) {
    		size--;
    	}
    	
    	if (addingHouseIndex < remainingHouses.length-1) {
    		size--;
    	}
    	
    	
    	int[] newRemainingHouses = new int[size];
    	
		//fill RemainingHouse with possible houses to rob
    	int newArrayCounter = 0;
    	int oldArrayCounter = 0;
    	while (newArrayCounter < newRemainingHouses.length) {
    	
			// 1. house hasn't been robbed before (exists on remainingHouse array)
			// 2. when adding a house, don't add houses next to it
    		if (oldArrayCounter == addingHouseIndex - 1 || 
    			oldArrayCounter == addingHouseIndex     ||
    			oldArrayCounter == addingHouseIndex + 1) {
    			
    			oldArrayCounter++;
    		} else {
    			newRemainingHouses[newArrayCounter] = remainingHouses[oldArrayCounter];
    			newArrayCounter++;
    			oldArrayCounter++;
    		}
		}    
    	
    	return newRemainingHouses;
    	
    }
	
}
