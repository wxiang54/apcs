/*****************************************************
 * William Xiang
 * APCS Pd 10
 * HW21 -- Stack: What is It Good For?
 * 2016-3-30

 * skeleton for class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    {
	//method 1 seems more conventional so I'm defaulting to that one
	int method = 1; 
	   
	Latkes stack = new Latkes( s.length() );

	//uses dynamic reverse method
	if (method == 0) {
	    for (int i = 0; i < s.length(); i++) {
		String charToAdd = s.substring(i, i+1);
		if ( stack.isEmpty() ) stack.push( charToAdd );
		else stack.push( charToAdd + stack.peek() );
	    }
	    return stack.peek();
	}
	//uses push-all-pop-all method
	else if (method == 1) {
	    for (int i = 0; i < s.length(); i++) {
		stack.push(s.substring(i, i+1));
	    }

	    String retStr = "";
	    while ( !stack.isEmpty() ) retStr += stack.pop();
	    return retStr;
	}
	else throw new IllegalStateException("I HARDCODED THE VALUES HOW DID I EVEN MANAGE TO MESS THIS UP");
	    
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) { 
	Latkes stack = new Latkes( s.length() );
	
	for (int i = 0; i < s.length(); i++ ) {
	    String charToAdd = s.substring(i, i+1);

	    //if a (), [], or {} pair is formed in stack, pop
	    if ( !stack.isEmpty() && //to avoid NullPointerException
		 ((stack.peek().equals("(") && charToAdd.equals(")")) ||
		  (stack.peek().equals("[") && charToAdd.equals("]")) ||
		  (stack.peek().equals("{") && charToAdd.equals("}"))) )
	    
		stack.pop();
		
	    else stack.push(charToAdd);
	}
	
	//by the time code reaches here, stack should be
	//empty if all symbols were paired and popped
	return stack.isEmpty();
    }//end allMatched()

    

    //main method to test
    public static void main( String[] args ) { 

	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	System.out.println(allMatched( "" ) ); //this should be true i think
	System.out.println(allMatched( "(()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]}()[]{{([])}[{()}[[(({{}}))]]]})" ) ); //true
	
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
