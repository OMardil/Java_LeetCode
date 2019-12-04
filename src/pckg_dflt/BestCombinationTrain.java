package pckg_dflt;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BestCombinationTrain {

	int[] days;
	int[] costs; 
	int[] dp;
	Set<Integer> tripDay;
	
	public static void main(String[] args) {
		int o1 = new BestCombinationTrain().minCostTickets(new int[]{1,4,6,7,8,20},new int[]{2,7,15});
		System.out.println(o1);
	}

    public int minCostTickets(int[] days, int[] costs) {
    	
    	dp = new int[366];
    	this.days = days;
    	this.costs = costs;
    	tripDay = new HashSet<>();
    	Arrays.fill(dp, Integer.MAX_VALUE);
    	
    	for (int i1: days) {
    		tripDay.add(i1);
    	}
    	    	
    	int i1 = explore(0);
    	
    	return i1;
    }
    
    public int explore(int dayIndex) {
    	
    	if (dayIndex >= dp.length) {
    		return 0;
    	}
    	if (dp[dayIndex] != Integer.MAX_VALUE) {
    		return dp[dayIndex];
    	}
    	
    	if (tripDay.contains(dayIndex)) {
    	
	    	int day0  = costs[0] + explore(dayIndex + 1);
	    	int day7  = costs[1] + explore(dayIndex + 7);
	    	int day30 = costs[2] + explore(dayIndex + 30);
	    	
	    	dp[dayIndex] = Math.min(dp[dayIndex], day0);
	    	dp[dayIndex] = Math.min(dp[dayIndex], day7);
	    	dp[dayIndex] = Math.min(dp[dayIndex], day30);     	
	    	
    	} else {
    		int i1 = explore(dayIndex+1);
    		if (dayIndex <dp.length) {
    			dp[dayIndex] = i1;
    		}
    		return i1;
    	}
    	return dp[dayIndex];
    }
}
