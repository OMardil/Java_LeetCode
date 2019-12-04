package pckg_dflt;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BackTrack {

	static String[][] lists=new String[100][];
	
	public static List<String> letterCombinations(String digits) {
	    lists['1']= new String[]{};
	    lists['2']= new String[]{"a", "b", "c"};
	    lists['3']= new String[]{"d", "e", "f"};
	    lists['4']= new String[]{"g", "h", "i"};
	    lists['5']= new String[]{"j", "k", "l"};
	    lists['6']= new String[]{"m", "n", "o"};
	    lists['7']= new String[]{"p", "q", "r", "s"};
	    lists['8']= new String[]{"t", "u", "v"};
	    lists['9']= new String[]{"w", "x", "y", "z"};	
		
		List<String> output = new ArrayList<>();
	    
		for(int i = 0; i<digits.length(); i++) {
			output = addCombination(output, digits.substring(i,i+1));
		}
		
		return output;
	}
	
	public static List<String> addCombination(List<String> list,
											  String letter){

		List<String> outputList = new ArrayList<>();
		int letterCount = lists[letter.charAt(0)].length;

		
		if(list.isEmpty()) {
			for(int i = 0; i<letterCount; i++) {
				outputList.add(lists[letter.charAt(0)][i]);
			}
			return outputList;
		}
		
		for (String s1: list) {
			for(int i = 0; i<letterCount; i++) {
				outputList.add(s1 + lists[letter.charAt(0)][i]);
			}
		}
		return outputList;
		
	}
	
	public static void main(String[] args) {
		List<String> l1 = letterCombinations("23");
		for(String o1: l1) {
			System.out.println(o1);
		}
	}
}
