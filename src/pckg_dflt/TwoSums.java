package pckg_dflt;

import java.util.HashMap;

/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
public class TwoSums {

	// Questions? -> Are the numbers sorted
	// Can the sum of any two numbers be greater than Integer.MAX_INT?
	// Will there always be a valid answer on the array?
	
	public static void main(String[] args) {

		int[] ans = new TwoSums().twoSum(new int[] {1,2,3}, 3); 
		printArray(ans);
		
		ans = new TwoSums().twoSum(null, 10);
		printArray(ans);

		ans = new TwoSums().twoSum(new int[] {1,2,3,4}, 10);
		printArray(ans);		

		ans = new TwoSums().twoSum(new int[] {1,2,2,3,5}, 7);
		printArray(ans);
		
	}

	public static void printArray(int[] ans) {
		
		if (ans == null)
			return;
		
		for(int i1: ans) {
			System.out.print(i1 + " ");
		}
		System.out.println();
	}

	//O(n^2) -> travel through the array using i, then checking in a second for-loop if i can find (target-array[i]).
	
	//O(n) -> optimizes time, takes up more space
	// 1. Travel through the array using i
	// 2. Calculate complement =  target-array[i]
	// 3. Look for complement on Hashmap<Complement,Index> 
	// 4. If value not on Hashmap, add it.
    // 5. If we finish looping through the array, without finding target, return null
	
    public int[] twoSum(int[] nums, int target) {
    	
    	if (nums == null) {
    		return null;
    	}
    	
    	int[] answer = null;
    	HashMap<Integer, Integer> complement = new HashMap();
    	
    	for(int i = 0; i<nums.length; i++) {
    		int complementTarget = target-nums[i];
    		if (complement.containsKey(nums[i])) {
    			answer = new int[2];
    			answer[0] = complement.get(nums[i]);
    			answer[1] = i;
    			return answer;
    		}
    		complement.put(complementTarget, i);
    	}
    	return null;
    }
	
}
