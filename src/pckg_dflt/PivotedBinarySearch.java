package pckg_dflt;

public class PivotedBinarySearch {

	public static void main(String[] args) {

		int[] a = new int[]{4,5,6,7,8,9,0,1,2,3};
		int pivot = findPivot(a);
		System.out.println(pivot);
		
		int search = pivottedBinarySearch(a, 4);
		System.out.println(search);
		
	}
	
	public static int pivottedBinarySearch(int[] array, int key) {

		int pivot = findPivot(array);
		
		if (pivot == -1)
			return -1;
		
		if (array[pivot] == key)
			return pivot;
		
		if (array[pivot] < key) {
			return binarySearch(array, key, pivot+1, array.length-1);
		} else {
			return binarySearch(array, key, 0, pivot-1);
		}
	
	}	
	
	
	
	public static int findPivot(int[] array) {
		return findPivot(array, 0, array.length-1);
	}
	
	public static int findPivot(int[] array, int begin, int end) {

		int pivot = -1;
		
		//exit condition
		if (begin > end)
			return pivot;
		if (begin == end) {
			return begin;
		}

		int mid = (begin + end) / 2;
		
		if (mid<end && array[mid]>array[mid+1]) {
			return mid;
		}
		
		if (begin<mid && array[mid-1]>array[mid]) {
			return mid-1;
		}
		
		if (array[begin] >= array[mid]) 
	           return findPivot(array, begin, mid-1); 
	    
		return findPivot(array, mid + 1, end);		
		
	}
	
	public static int binarySearch(int array[], int key) {
		return binarySearch(array, 0, key, array.length-1);
	}
	
	public static int binarySearch(int array[], int key, int begin, int end) {
		if (begin>end)
			return -1;
		
		int mid = (begin + end)/2;
		
		if (array[mid] == key)
			return mid;
		else if (array[mid] > key) {
			return binarySearch(array, key, begin, mid-1);
		} else { //(array[mid] < key)
			return binarySearch(array, key, mid + 1, end);
		}
	}

}
