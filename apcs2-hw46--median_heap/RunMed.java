/************************************************
 * Team XYZ_Affair -- William Xiang, Joel Ye, Zicheng Zhen
 * APCS Pd10
 * HW46 -- Running M[edi]an
 * 2016-05-26

 class RunMed
 * Records median for serialized data stream 
************************************************/

import java.util.ArrayList; // For Testing

public class RunMed {
    
    /** Instance Variables **/
    MinHeap larger; // Numbers larger than median
    MaxHeap smaller; // Numbers smaller than median
    int largerSize, smallerSize; // Size of heaps
    double median;
	
    public RunMed() {
	larger = new MinHeap();
	smaller = new MaxHeap();
	largerSize = smallerSize = 0;
	median = -1;
    }
		
    public void add(int value) {
	if (larger.isEmpty() && smaller.isEmpty()) // No data yet
	    {
		smaller.add(value);
		smallerSize++;
	    }
	else if (value > median)
	    {
		larger.add(value);
		largerSize++;
	    }
	else 
	    {
		smaller.add(value);
		smallerSize++;
	    }
	redistribute();
	System.out.println("New Median: " + calcMedian());
    }
    
    // redistributes heaps if necessary
    public void redistribute() {
	if (smallerSize - largerSize > 1) // Smaller pile too large
	    {
		larger.add(smaller.removeMax());
		smallerSize--; largerSize++;
	    }
	else if (largerSize - smallerSize > 1) // Larger pile too large
	    {
		smaller.add(larger.removeMin());
		smallerSize++; largerSize--;
	    }
    }

    // finds median
    public double calcMedian() {
	if (larger.isEmpty())
	    median = smaller.peekMax();
	if ((largerSize + smallerSize) % 2 == 0) // Even number of elements
	    median = (smaller.peekMax() + larger.peekMin()) / 2.0;
	else // Odd number of elements
	    median = (smallerSize > largerSize) ? 
		smaller.peekMax() : larger.peekMin();
	return median;
    } // O(1)
		
		
    public double getMedian() {
	return median;
    }
		
    public static void main(String[] args) {
	ArrayList<Integer> testData = new ArrayList<Integer>();
	RunMed foo = new RunMed();

	// Testing Mechanism
	for (int i = 0; i < 20; i++) 
	    {
		int newVal = (int)(20 * Math.random());
		testData.add(newVal);
		System.out.println("Test Data:\n" + testData);
		foo.add(newVal);
	    }
    }
}
