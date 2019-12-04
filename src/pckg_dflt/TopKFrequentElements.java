package pckg_dflt;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {

		List<Integer> output = topKFrequent(new int[]{1,1,1,2,2,3,3,3,3,4,5,5,6,7},3);
		
		if (output != null) {
			for(int i1: output) {
				System.out.print(i1 + " ");
			}
		}
		
	}
	
    public static List<Integer> topKFrequent(int[] nums, int k) {
    	
    	HashMap<Integer, Integer> elementCount = new HashMap();
    	//add count of entries
    	for(int i1: nums) {
    		elementCount.put(i1, elementCount.getOrDefault(i1, 0)+1);
    	}
    	
    	//add to priorityQueue by size
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>((a, b) -> a[1] - b[1]);
        
        for(Map.Entry<Integer, Integer> entry: elementCount.entrySet()) {
        	int[] n = new int[2];
        	n[0] = entry.getKey();
        	n[1] = entry.getValue();
        	
        	heap.add(n);
        	if (heap.size() > k) {
        		heap.poll();
        	}
        }
        
        List<Integer> output = new ArrayList<>();
        while(!heap.isEmpty()) {
        	output.add(heap.poll()[0]);
        }
    	
    	return output;
    }
}
