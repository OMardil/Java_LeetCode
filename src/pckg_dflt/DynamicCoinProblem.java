package pckg_dflt;
import java.util.Arrays;

public class DynamicCoinProblem {

	public static void main(String[] args) {
		
		//base case, 1,2,3 => 11 
		// expecting 3
		if (coinChange(new int[] {1,2,5},11) == 3)
			System.out.println(true);
		
		// edge case (empty array, looking for 0)
		if (coinChange(new int[] {1,2,3,4},0) == 0)
			System.out.println(true);		
		
		// edge case (looking for -1)		
		if (coinChange(new int[] {2},3) == -1)
			System.out.println(true);
		
		if (coinChange(new int[] {25,1,10},30) == 3) {
			System.out.println(true);
		}

		// edge case (empty array)
		if (coinChange(new int[]{}, 10) == -1) {
			System.out.println(true);
		}
		
		// edge case (impossible combination with coins)		
		if (coinChange(new int[] {2,4,8}, 11) == -1) {
			System.out.println(true);
		}
		
	}
	//dynamic programming approach
	// bottom up
    public static int coinChange(int[] coins, int amount) {
    	
    	//base case amount = 0, 
    	// we need to calculate up to amount
    	int[] coinsRequired = new int[amount+1];
    	//initialize array with more coins than amount.
    	Arrays.fill(coinsRequired, amount + 1);
    	
    	coinsRequired[0] = 0;
    	
    	for (int i = 1; i<coinsRequired.length; i++) {
	    	int currentAmount = i;

	    	for(int j = 0; j<coins.length; j++) {
		    	int coinCount = 0;	    		
	    		if (currentAmount-coins[j] < 0)
	    			continue;
	    		else {
	    			coinCount++;
	    		}
	    		
	    		int previousSolution = coinsRequired[currentAmount-coins[j]];
	    		coinsRequired[i] = 
	    				Math.min(coinsRequired[i], coinCount + previousSolution);
	    	}
    	}
    	
    	
	    return coinsRequired[amount] == (amount + 1) ? -1 : coinsRequired[amount];
    	
    }	

}
