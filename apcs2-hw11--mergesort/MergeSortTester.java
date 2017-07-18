/*======================================
  Team TheBigSort -- William Xiang and Aparna Nair-Kanneganti
  APCS2 pd10
  HW11 -- Wrapping It Up
  2016-03-10

  class MergeSortTester

  ALGORITHM:

  1. If the array has length 1, it is sorted. Return the array.
  2. Else, construct two new arrays with length that is half of the original array's length.
  3. Copy the elements out of the original array into the two new arrays, so that half of the 
  data from the original ends up in each new array.
  4. Recurse by merging the sorted versions of the two half-arrays:
  {
  	5. In order to merge two arrays, construct a new array whose length is the sum of the arguments'
  	lengths.
	6. Compare the first elements of both arrays. Copy the lesser of the two into the first position
	of the newly constructed array.
	7. Repeat this process by iterating through both arrays.
  }


  BIG-OH CLASSIFICATION OF ALGORITHM:
  
  We believe that MergeSort runs in linearithmic time: O(nlogn).

  Mean execution times for dataset of size n:
  Batch size: 3
  n=1        time: 0.0000 ms
  n=10       time: 0.0000 ms
  n=100      time: 0.0000 ms
  n=1000     time: 0.0000 ms
  n=10000    time: 5.3333 ms
  n=100000   time: 27.666 ms
  n=1000000  time: 211.33 ms
  n=10000000 time: 2933.3 ms
 
  ANALYSIS:
  
  Times were reproduced above to 5 significant digits. 
  
  For greater precision and a full set of data for various types of arrays tested, 
  please see tester.txt, which can also be found in TheBigSort's repo. 

  Notice that the first four time entries (until n = 10000) reported an average runtime of 0 ms. 
  This indicates that the runtime was negligible on a millisecond scale, but was probably still substantial at the nano-level. 
  We could have eliminated this imprecision had we used System.nanoTime() instead of System.currentTimeMillis() in order to gather our timing data. 
  However, System.nanotime() itself incurs rather a heavy computational cost, which we wished to avoid.
  Nevertheless, we have included tests using System.nanoTime() in tester.txt.

  When we graphed our data using Mathematica's ListPlot function, we were able to identify a resemblance to the nlogn function, 
  enough for us to suppose that our function must be some scaling of the graph f(n) = nlogn. 
  Key characteristics included a flattening of the curve close to the origin, where we had several times equal to 0 ms, 
  and a smoothing out to approximate a straight line for larger n.
  We were able to distinguish this function from that of a line by its slight positive concavity.  

  ======================================*/

public class MergeSortTester {

    public static int[] crtOrdArr( int n ) {
	int[] ordArr = new int[n];
	for (int i = 0; i < n; i++) {
	    ordArr[i] = i;
	}
	return ordArr;
    }

    public static int[] crtRevArr( int n ) {
	int[] revArr = new int[n];
	for (int i = 0; i < n; i++) {
	    revArr[i] = n-1-i;
	}
	return revArr;
    }

    public static int[] crtRandArr( int n ) {
	int[] randArr = crtOrdArr(n);
	for (int i = 0; i < n; i++) {
	    int pos1 = (int)(Math.random() * n);
	    int pos2 = (int)(Math.random() * n);
	    int tmp = randArr[pos1];
	    randArr[pos1] = randArr[pos2];
	    randArr[pos2] = tmp;	    
	}
	return randArr;
    }
    
    /******************************
     * execution time analysis 
     * Our test apparatus can be summarized as follows:
     * 1. First we sort 100000 one-element arrays, in order to ensure
     * that Java has properly "heated up."
     * 2. We then construct a 2D array where each row represents a different
     * type of list to be sorted: ie. a list that has been presorted in 
     * ascending order, a list that has been presorted in descending order, 
     * and a randomly generated list.
     * 3. By accessing each row of the array individually we can account for
     * all three test cases. Each test array is sorted and timed thrice, and 
     * an average is computed.
     * 4. This process is repeated for various test array lengths (increasing
     * the length by a factor of 10 after every iteration). 
     ******************************/
    public static void main( String[] args ) {
	//"heat up" Java to prevent lots of runtime irregularities
	int [] warmup = new int[1];
	for (int i = 0; i < 100000; ++i)
	    MergeSort.sort(warmup);
	
	//begin testing
	String [] names = {"Ordered", "Reverse Ordered", "Randomized"};		
	for (int j = 1; j < Math.pow(10, 8); j*=10) {
	    int[][] arrs = new int[3][j];
	    arrs[0] = crtOrdArr(j);
	    arrs[1] = crtRevArr(j);
	    arrs[2] = crtRandArr(j);
	    int totalSum = 0;
	    for (int k = 0; k < 3; k++){
		int sum = 0;
		for (int i = 0; i < 3; i++) {
		    long startTime = System.currentTimeMillis();
		    MergeSort.sort(arrs[k]);
		    long finishTime = System.currentTimeMillis();
		    sum += (finishTime - startTime);
		}
		double avg = sum / 3.0;
		System.out.println(j + "-item " + names[k] + " Time:\t" + avg + " ms");
		totalSum += avg;
	    }
	    double totalAvg = totalSum / 3.0;
	    System.out.println(j + "-item " + " Avg. Time:\t" + totalAvg + " ms");
	}
    }//end main

}//end class
