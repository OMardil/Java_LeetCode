package pckg_dflt;

public class MinDominoRot {

	public static void main(String[] args) {

		int[] a = {2,1,2,4,2,2};
		int[] b = {5,2,6,2,3,2};		
		
		int out = new MinDominoRot().minDominoRotations(a, b);
		System.out.println(out);
	}

    public int minDominoRotations(int[] a, int[] b) {
        
    	// check if solution is possible
    	if (a.length != b.length) {
    		return -1;
    	}
    	
    	//check if frequencies
    	int[] freq = new int[6];
    	for (int i = 0; i<a.length; i++) {
    		if(a[i] == b[i]) {
    			freq[a[i]-1]++;
    		} else {
    			freq[a[i]-1]++;
	    		freq[b[i]-1]++;
    		}
    	}
    	
    	int minSwaps = Integer.MAX_VALUE;
    	
    	for(int i = 0; i<6; i++) {
    		
    		//only makes sense to continue when the target appears at least a.length times, otherwise there's no point.
    		if (freq[i] >= a.length) {
    			int swapUpper = 0;
    			int swapLower = 0;
    			
    			for (int j = 0; j<a.length; j++) {
	    			//if target is not on piece, it would be impossible to finish
	    			if (a[j] != (i+1) && b[j] != (i+1))
	    				break;
	    			
	    			//if it is a mule, no swaps needed
	    			if (a[j] == (i+1) && b[j] == (i+1)) {
	    				
	    			} else if (a[j] == (i+1)) {
	    				swapLower++;
	    			} else if (b[j] == (i+1)) {
	    				swapUpper++;
	    			}
	    			
	    			minSwaps = Math.min(swapLower, swapUpper);
	    		}
    		}
    	}
    	
    	return (minSwaps == Integer.MAX_VALUE)?-1:minSwaps;
    }
    
    public static int findMax(int[] a) {
    	
    	int currentMax = -1;
    	int indexMax = -1;
    	for(int i = 0; i<a.length; i++) {
    		if (currentMax < a[i]) {
    			indexMax = i;
    			currentMax = a[i];
    		}
    	}
    	
    	return indexMax;
    }
}
