// William Xiang
// APCS Pd10
// HW22 -- Augmenting Your Array of Tools
// 2015-11-2

public class ArrayUtils {

    public static void main(String[] args) {
	System.out.println("-=-=-=-=-=-=-= INTEGER ARRAY =-=-=-=-=-=-=-");
	Integer[] intArr = {0,1,2,3,4,5,6,7,8,9,9,9,9,9,9,9,9,9,2};
	System.out.println("stringify(intArr) -> " + stringify(intArr));

	System.out.println("linSearch(intArr, 1) -> " + linSearch(intArr, 1));
	System.out.println("linSearch(intArr, 9) -> " + linSearch(intArr, 9));
	System.out.println("linSearch(intArr, 10) -> " + linSearch(intArr, 10));

	System.out.println("freq(intArr, 1) -> " + freq(intArr, 1));
	System.out.println("freq(intArr, 9) -> " + freq(intArr, 9));
	System.out.println("freq(intArr, 10) -> " + freq(intArr, 10));

	System.out.println("\n-=-=-=-=-=-=-= STRING ARRAY =-=-=-=-=-=-=-");
	String[] strArr = {"zero","one","two","two"};
	System.out.println("stringify(strArr) -> " + stringify(strArr));

	System.out.println("linSearch(strArr, \"one\" -> " + linSearch(strArr,"one"));
	System.out.println("linSearch(strArr, \"two\" -> " + linSearch(strArr,"two"));
	System.out.println("linSearch(strArr, \"three\" -> " + linSearch(strArr,"three"));

	System.out.println("freq(strArr, \"one\" -> " + freq(strArr,"one"));
	System.out.println("freq(strArr, \"two\" -> " + freq(strArr,"two"));
	System.out.println("freq(strArr, \"three\" -> " + freq(strArr,"three"));
    }
    
    public static void populate(int[] arr, int min, int max) {
	// for each position available in the array
	for (int i = 0; i < arr.length; i++) {
	    // generate a random number between 0 and 1
	    // "(Math.random() * (max - min)) + min" returns pseudorandom number from [min,max)
	    // Cast into int to truncate floating point and return an integer
	    arr[i] = (int)( (Math.random() * (max - min)) + min);
	}
    }

    public static String stringify(Object[] arr) {
        String s = "("; // Initialize s and give it a { to start off the array
	
	for (Object i : arr) { // for each integer in arr
	    s += i + ", "; // add i to the string and then add ", " to seperate from subsequent items
	}
	
	return s.substring(0,s.length()-2) + "}"; // truncate the last ", " and add "}" to close it off
    }

    public static int linSearch(Object[] a, Object target) {
	for (int i = 0; i < a.length; i++) {
	    if (a[i].equals(target)) {
		return i;
	    }
	}
	return -1;
    }

    public static int freq(Object[] a, Object target) {
	int ctr = 0;
	
	for (Object i : a) {
	    if (i.equals(target)) {ctr++;}
	}
	
	return ctr;
    }    
        
}
