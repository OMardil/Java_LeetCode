package pckg_dflt;

public class KthElement {

	public static void main(String[] args) {

		int out = findKthElement(new int[] {3,2,1,5,6,4}, 2);
		System.out.println(out);
	}
	
	public static int findKthElement(int[] array, int kthElement) {
		
		int begin = 0;
		int end = array.length-1;
		
		kthElement = array.length - kthElement;
		
		while (begin <= end) {
			int finalPosition = findPivot(array, begin, end);
			if (finalPosition == kthElement) {
				return array[kthElement];
			}
			if (kthElement < finalPosition) {
				end = finalPosition - 1;
			} else if(kthElement > finalPosition) {
				begin = finalPosition + 1;
			}
				
		}
		
		//invalid, your kthElement does not exist!
		return -1; 

	}
	
	public static int findPivot(int[] array, int begin, int end) {
		
		int pivot = array[end];
		int lastFoundSmaller  = begin-1;
		
		for(int i = begin; i<end; i++) {
			if (array[i] < pivot) {
				lastFoundSmaller++;
				swap(array, i, lastFoundSmaller);
			}
		}
		
		swap(array, end, lastFoundSmaller+1);
		
		return lastFoundSmaller+1;
		
	}
	
	public static void swap(int[] array, int i, int j) {
		int aux = array[i];
		array[i] = array[j];
		array[j] = aux;
		
	}

}
