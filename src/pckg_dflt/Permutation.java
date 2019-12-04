package pckg_dflt;
import java.util.Arrays;

public class Permutation {

	public static void main(String[] args) {

		permutation("123");
		
	}

	public static void permutation(String input) {
		permutation ("", input);
	}
	
	public static void permutation(String perm, String word) {
		
		System.out.println(perm);
		
		if (!word.isEmpty()) {
			for (int i = 0; i< word.length(); i++) {
				char c1 = word.charAt(i);
				permutation(perm + c1, word.substring(0,i) + word.substring(i+1, word.length()));
			}
		}
	}
	
}
