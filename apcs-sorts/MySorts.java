/*======================================
  William Xiang
  APCS Pd10
  2015-12-23

  class mySorts -- implements bubbleSort,
  selectionSort, and bogoSort algorithms
  ======================================*/

import java.util.ArrayList;

public class MySorts {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }

    //checks if the elements of an ArrayList are in order
    public static boolean isSorted( ArrayList<Comparable> al ) {
	for (int i = 0; i < al.size() - 1; i++) {
	    if ( al.get(i).compareTo( al.get(i + 1) ) > 0 ) {
		return false; //return false at first instance where term is > term after it
	    }
	}
	return true; //return true now that we know all the items are in order
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    

    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	//do size-1 passes
	for (int passCtr = 0; passCtr < data.size() - 1; passCtr++) {
	    //start at the end and bubble towards the left
	    for (int i = data.size() - 1; i > 0; i--) {
		//if value at position i < value of position before it
		if (data.get(i).compareTo(data.get(i - 1)) < 0) {
		    //swap the values at position i and i-1
		    data.set(i - 1, data.set(i, data.get(i - 1)));
		}
	    }
	}
    }//end bubbleSortV -- O(n^2)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    // Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> input ) {
	//hard copy input's contents over to retAL
	ArrayList<Comparable> retAL = new ArrayList<Comparable>();
	for (Comparable c : input) {
	    retAL.add(c);
	}

	//sort retAL with void method and return it, leaving input unchanged
	bubbleSortV(retAL);
	return retAL;
    }//end bubbleSort -- O(n^2)


    
    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) {
	for (int swapPos = 0; swapPos < data.size() - 1; swapPos++) {
	    //find min value from [swapPos,end]
	    int minPos = swapPos;
	    for (int i = swapPos; i < data.size(); i++) {
		if (data.get(i).compareTo(data.get(minPos)) < 0) {
		    minPos = i;
		}
	    }
	    
	    data.set( swapPos , data.set( minPos,data.get(swapPos) ) ); //swap
	    
	}
    }//end selectionSort -- O(n^2)


    // ArrayList-returning selectionSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> selectionSort( ArrayList<Comparable> input ) {
	ArrayList<Comparable> output = new ArrayList<Comparable>(); //instantiate ArrayList output

	for (Comparable c : input) { //hard copy
	    output.add(c);
	}

	selectionSortV(output); //sort
	return output;
    }//end selectionSort -- O(n^2)

    
    
    // VOID version of BogoSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bogoSortV( ArrayList<Comparable> data ) {
	while (!isSorted(data)) {
	    shuffle(data);
	}
    }//end bogoSort -- O(infinity)


    // ArrayList-returning bogoSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bogoSort( ArrayList<Comparable> input ) {
	ArrayList<Comparable> output = new ArrayList<Comparable>(); //instantiate ArrayList output

	for (Comparable c : input) { //hard copy
	    output.add(c);
	}

	bogoSortV(output); //sort
	return output;
    }//end bogoSort -- O(infinity)


    //main method for testing
    public static void main( String [] args ) {

	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );

	  ArrayList glenBubbleSorted = bubbleSort( glen );
	  System.out.println( "bubble sorted version of ArrayList glen:\n" + glenBubbleSorted );

	  ArrayList glenSelectionSorted = selectionSort( glen );
	  System.out.println( "selection sorted version of ArrayList glen:\n" + glenSelectionSorted );

	  ArrayList glenBogoSorted = bogoSort( glen );
	  System.out.println( "bogo sorted version of ArrayList glen:\n" + glenBogoSorted );

	  System.out.println( "ArrayList glen after sorting:\n" + glen );


	  
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  
	  ArrayList cocoBubbleSorted = bubbleSort( coco );
	  System.out.println( "bubble version of ArrayList coco:\n" + cocoBubbleSorted );

	  ArrayList cocoSelectionSorted = selectionSort( coco );
	  System.out.println( "selection sorted version of ArrayList coco:\n" + cocoSelectionSorted );

	  ArrayList cocoBogoSorted = bogoSort( coco );
	  System.out.println( "bogo sorted version of ArrayList coco:\n" + cocoBogoSorted );

	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	/*==========for AL-returning methods==========
	  ============================================*/

    }//end main

}//end class SelectionSort
