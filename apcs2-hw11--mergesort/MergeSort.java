/*======================================
<<<<<<< HEAD
  Team TheBigSort -- William Xiang and Aparna Nair-Kanneganti
  APCS2 pd10
  HW11 -- Wrapping It Up
  2016-03-10

  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  1) If array only has 1 element, it is sorted, therefore return self.
  2) Return the merging of the sorted versions of itself split into 2, recurively
  
  ======================================*/

public class MergeSort {

    /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b )
    //this was probably a lot easier recursively, but I wanted to see if I could do it iteratively cuz I'm a rebel >:)
    {
	int[] retArr = new int[a.length + b.length]; //just enough to fit all elements of both a and b
	    
	int aCounter = 0; //index of value currently being compared in array a
	int bCounter = 0; //index of value currently being compared in array b

	while (aCounter + 1 <= a.length) { //until all the values in a are added to retArr
	    if ( (bCounter + 1 > b.length) || (a[aCounter] < b[bCounter]) ) { //if b is "empty" or value at a < value at b
		retArr[aCounter + bCounter] = a[aCounter]; //add the value at a to retArr
		aCounter++;
	    } else {
		retArr[aCounter + bCounter] = b[bCounter]; //otherwise, assume value at b < value at a, so add value at b to retArr
		bCounter++;
	    }
	}

	for (bCounter = bCounter; bCounter < b.length; bCounter++) { //for all the leftover values in b
	    retArr[aCounter + bCounter] = b[bCounter];
	}

	return retArr;
	
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	if (arr.length == 1) return arr; //array is already sorted when length = 1

	int[] a = new int[arr.length - (arr.length / 2)]; //when arr.length is odd, arr1 is one longer than arr2 to hold extra value
	int[] b = new int[arr.length / 2];

	for (int i = 0; i < (arr.length/2.); i++) { //use float division for cases when arr.length is odd
	    //numbers alternatively get added to a and b
	    a[i] = arr[i * 2];
	    if (i * 2 + 1 < arr.length) { //for when arr.length is odd and arr is "empty"
		b[i] = arr[i * 2 + 1];
	    }
	}
      	return merge(sort(a),sort(b)); //envelops the entire algo recursively: split into subarrays and merge them
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};
	/*
	  System.out.println("\nTesting mess-with-array method...");
	  printArray( arr3 );
	  mess(arr3);
	  printArray( arr3 );
	*/
	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );
	
	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	
	/*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~	
	  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
    }//end main()

}//end class MergeSort
