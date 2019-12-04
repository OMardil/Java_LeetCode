package pckg_dflt;
import java.util.ArrayList;
import java.util.List;

public class Parenthesis {

	public static void main(String[] args) {

		List<String> l1 = generateParenthesis(3);
		for(String o1: l1) {
			System.out.println(o1);
		}
		
	}

    public static List<String> generateParenthesis(int n) {
        
        List<String> list = new ArrayList<>();
        backtrack(list,"",0,0,n);
        
        return list;
    }
    
    public static void backtrack(List<String> answer, String curr, int open, int close, int max){
        
        if (max*2 == open + close){
            answer.add(curr);
        }
        
        if (open < max){
        	backtrack(answer, curr + "(", open+1, close, max);
        }
        
        if (close < max && close < open){
        	backtrack(answer, curr + ")", open, close+1,max);
        }
        
    }	
	
}
