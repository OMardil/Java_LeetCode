package pckg_dflt;
import java.util.PriorityQueue;

public class MaxSumAfterNegations {

	public static void main(String[] args) {
		int i1 = new MaxSumAfterNegations().largestSumAfterKNegations(new int[]{4,2,3}, 1);
		System.out.println(i1);
	}
	
    public int largestSumAfterKNegations(int[] A, int k) {
    	
    	PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(A[a], A[b]));
    	
    	int sum = 0;
    	
    	//hold the k smaller numbers in priority queue
    	for(int i = 0; i<A.length; i++) {
    		pq.add(i);	
    		sum+= A[i];
    	}
    	
    	for(int i = 0; i<k; i++) {
    		if (pq.size() > 0) {
    			int indexSmallest = pq.poll();    			
    			pq.add(indexSmallest);
    			//remove and add number to sum
    			sum+=-2*A[indexSmallest];    			
    		}
    	}
    	
    	return sum;
    	
        
    }

}
