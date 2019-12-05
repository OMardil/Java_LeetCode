package pckg_dflt;

public class AddTwoBinaryStrings {

	public static void main(String[] args) {

		String o1 = addBinary("11","1");
		System.out.println(o1);
		
		o1 = addBinary("1010","1011");
		System.out.println(o1);		
	}
	
    public static String addBinary(String a, String b) {
        
        int loopCounter = (a.length() >= b.length()) ? a.length() : b.length();
        loopCounter = loopCounter-1;
        
        int posA = a.length()-1;
        int posB = b.length()-1;
        char carry = '0';
        
        String out = "";
        
        while(loopCounter >= 0){
            char valueA = (posA < a.length() && posA>=0)? a.charAt(posA):'0';
            char valueB = (posB < b.length() && posB>=0)? b.charAt(posB):'0';  
            
            posA--;
            posB--;
            loopCounter--;
            
            String comb = "" + valueA + valueB + carry;
            
            switch(comb){
                case "000":
                    out = "0" + out;
                    carry = '0';
                    break;
                case "001":
                    out = "1" + out;
                    carry = '0';
                    break;
                case "010":
                    out = "1" + out;
                    carry = '0';
                    break;
                case "011":
                    out = "0" + out;
                    carry = '1';
                    break;
                case "100":
                    out = "1" + out;
                    carry = '0';
                    break;
                case "101":
                    out = "0" + out;
                    carry = '1';
                    break;
                case "110":
                    out = "0" + out;
                    carry = '1';
                    break;
                case "111":
                    out = "1" + out;
                    carry = '1';
                    break;                        
            }   
        }
        
        return (carry == '1')?"1"+out: out;
                
    }	

}
