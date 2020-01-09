package pckg_dflt;

import java.util.Arrays;

public class MinFallingPathSum {
	

	public static void main(String[] args) {

		int out = new MinFallingPathSum().minFallingPathSum(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
		if (out == 12) {
			System.out.println("Correct!");
		} else {
			System.out.println("False!");
		}
		
	}
	
	
	// Recursive algorithm
	// 
	
	
    public int minFallingPathSum(int[][] A) {
    	
    	if (A == null)
    		return 0;
    	
    	int[][] dp = new int[A.length][A[0].length];
    	
    	for(int i = 0; i<dp[0].length; i++) {
    		dp[0][i] = A[0][i];
    	}
    	
    	
    	for (int r = 1; r<A.length; r++) {
    		for(int c = 0; c<A[r].length; c++){
    			if (c == 0) {
    				dp[r][c] = Math.min(A[r][c] + dp[r-1][c], A[r][c] + dp[r-1][c+1]);
    			} else if (c == A[r].length-1) {
    				dp[r][c] = Math.min(A[r][c] + dp[r-1][c], A[r][c] + dp[r-1][c-1]);    				
    			} else {
    				dp[r][c] = Math.min(A[r][c] + dp[r-1][c-1], A[r][c] + dp[r-1][c]);    				    				
    				dp[r][c] = Math.min(dp[r][c], A[r][c] + dp[r-1][c+1]);    				    				
    			}
    		}
    	}

    	int min = Integer.MAX_VALUE;
    	for(int i=0; i<dp[0].length;i++) {
    		min = Math.min(min, dp[dp.length-1][i]); 
    	}
    	
    	return min;
    	
    }	
    

    
   
    

}
