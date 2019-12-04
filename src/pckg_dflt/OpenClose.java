package pckg_dflt;
import java.util.ArrayDeque;
import java.util.Deque;

public class OpenClose {

	public static void main(String[] args) {
		System.out.println(isValid("()"));
		System.out.println(isValid("(()"));
		System.out.println(isValid("({}{})"));		
	}

	public static boolean isValid(String s) {

		Deque<Character> stack = new ArrayDeque<Character>();

		for(int i = 0; i<s.length(); i++){

			char c1 = s.charAt(i);
			char c2;

			if (c1 == '{' || c1 == '(' || c1 == '[') {
				stack.push(c1);
			} else {
				c2 = stack.pop(); 
				if (((c2 == '{' && c1 == '}')) || 
					((c2 == '(' && c1 == ')')) ||
					((c2 == '[' && c1 == ']')) ){
					//keep going
				} else {
					return false;
				}
			}    
		}

		return stack.size() == 0? true: false;
	}

}
