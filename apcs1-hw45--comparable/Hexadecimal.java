// Team HexMasters -- Vincent Liok, William Xiang
// APCS1 Pd 10
// HW44 -- This or That or Fourteen Other Things
// 2015-12-8

public class Hexadecimal implements Comparable {

    private int _decNum;
    private String _hexNum;
    private final static String HEXDIGITS = "0123456789ABCDEF"; 

    /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0, _hexNum to "0"
      =====================================*/
    public Hexadecimal() { 
	_decNum = 0;
	_hexNum = "0";
    }

    /*=====================================
      overloaded constructor
      pre:  n >= 0
      post: sets _decNum to n, _hexNum to equiv string of bits
      =====================================*/
    public Hexadecimal( int n ) {
	_decNum = n;
	_hexNum = decToHexR(n);
    }

    /*=====================================
      overloaded constructor
      pre:  s is String representing non-negative hexadecimal number
      post: sets _hexNum to input, _decNum to decimal equiv
      =====================================*/
    public Hexadecimal( String s ) {
	_decNum = hexToDecR(s);
	_hexNum = s;
    }

    /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String of 1's and 0's representing value of this Object
      =====================================*/
    public String toString() { 
	return _hexNum; 
    }

    /*=====================================
      String decToHex(int) -- converts base-10 input to hexadecimal
      pre:  n >= 0
      post: returns String of bits
      eg  
      decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(16) -> "10"
      decToHex(17) -> "11"
      decToHex(4368) -> "1110"
      =====================================*/
    public static String decToHex( int n ) {
	  
	    String s = ""; //initialize String to contain hex representation
	    if (n == 0) {return "0";}
	    while (n > 0) { //keep iterating until n=0
	        s = HEXDIGITS.indexOf(String.valueOf(n % 16)) + s;
	        n /= 16;
	    }
	    return s;
    }   

    /*=====================================
      String decToHexR(int) -- converts base-10 input to hexadecimal, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  
      decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(16) -> "10"
      decToHexR(17) -> "11"
      decToHexR(4368) -> "1110"
      =====================================*/
    public static String decToHexR( int n ) { 
	String retStr;	 
	if ( n < 16 ) {retStr = HEXDIGITS.substring(n,n+1);}
	else {retStr = decToHexR( n / 16 ) + HEXDIGITS.substring( n % 16, n % 16 + 1 );}
	
	return retStr;
    }

    /*=====================================
      String hexToDec(String) -- converts hexadecimal input to a base 10 number
      pre:  s represents non-negative hexadecimal number
      post: returns decimal equivalent as int
      eg  
      hexToDec("0") -> 0
      hexToDec("1") -> 1
      hexToDec("10") -> 16
      hexToDec("11") -> 17
      hexToDec("1110") -> 4368
      =====================================*/
    public static int hexToDec( String s ) {
    	int dec = 0;
    	for (int i = 0; i < s.length(); i++) { //iterates along string, adding 16^position if first char is '1'
    	    dec += HEXDIGITS.indexOf(s.substring(i,i + 1)) * Math.pow(16, s.length()- 1 - i);
    	}
    	return dec;
    }

    /*=====================================
      String hexToDecR(String) -- converts hexadecimal input to a base 10 number
      pre:  s represents non-negative hexadecimal number
      post: returns decimal equivalent as int
      eg  
      hexToDecR("0") -> 0
      hexToDecR("1") -> 1
      hexToDecR("10") -> 16
      hexToDecR("11") -> 17
      hexToDecR("1110") -> 4368
      =====================================*/
    public static int hexToDecR( String s ) 
    { 
	if (s.length() == 0) {
	    return 0;
	}
	else {
	    int dec = HEXDIGITS.indexOf(s.substring(0,1));
	    return ( dec * (int)Math.pow(16,s.length()-1) ) + hexToDecR( s.substring(1) );
	}
    }

    /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal hexadecimal values
      =============================================*/
    public boolean equals( Object other ) 
    { 
	return this == other //check for aliases
	        ||
	    (other instanceof Hexadecimal
	     && this._decNum == ((Hexadecimal)other)._decNum);
    }

    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/
    public int compareTo(Object other) {		
		if ( ! (other instanceof Comparable) ) {
			throw new ClassCastException("\nError: compareTo() input not Comparable");
		}
		
		if (other.equals(null)) {
			throw new NullPointerException("\nError: compareTo() input can't be null")
		}
		
		if (other instanceof Rational) {
			if (_decNum > ((Rational)other).floatValue()) {return 1;}
			else if (_decNum == ((Rational)other).floatValue()) {return 0;}
			else {return -1;}
		}
		
		if (other instanceof Hexadecimal) {
			return _decNum - ((Hexadecimal)other).getDecNum();
		}
		
		if (other instanceof Binary) {
			return _decNum - ((Binary)other).getDecNum();
		}
		return 0;
    }
	
	public int getDecNum() {
		return _decNum;
	}
	
    //main method for testing
    public static void main( String[] args ) 
    {
	System.out.println();
	System.out.println( "Testing ..." );
	
	Hexadecimal b1 = new Hexadecimal(10);
	Hexadecimal b2 = new Hexadecimal("A");
	Hexadecimal b3 = b1;
	Hexadecimal b4 = new Hexadecimal(1234);

	System.out.println( b1 );
	System.out.println( b2 );
	System.out.println( b3 );       
	System.out.println( b4 );       

	System.out.println( "\n==..." );
	System.out.println( b1 == b2 ); //should be false
	System.out.println( b1 == b3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( b1.equals(b2) ); //should be true
	System.out.println( b1.equals(b3) ); //should be true
	System.out.println( b3.equals(b1) ); //should be true
	System.out.println( b4.equals(b2) ); //should be false
	System.out.println( b1.equals(b4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( b1.compareTo(b2) ); //should be 0
	System.out.println( b1.compareTo(b3) ); //should be 0
	System.out.println( b1.compareTo(b4) ); //should be neg
	System.out.println( b4.compareTo(b1) ); //should be pos		
    }//end main()
} //end class
