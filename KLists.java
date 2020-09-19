import java.util.*;

public class KLists{
	public KLists(){}

	public double[] mergeKLists(double [][] outerArray)
	{
		double [] merged = {};
		if (outerArray.length > 0){	//checks to see if there are items in the array 
			for (int j = 0; j < outerArray.length; j++)	//loops through each subarray
			{
				double [] arr = new double[merged.length + outerArray[j].length];	//creates a temporary array that stores the values sorted at the current iteration
				merge(merged, outerArray[j], arr);	//merges the outer array with the subarrays and places them into the temporary array
				merged = arr;	//places the new values into the outer array 
			}
		}
		return merged;
	}

	public void merge(double[] left, double[] right, double [] target)
	{
		int left_index = 0; 
		int right_index = 0;
		int target_index = 0;

		//merge the left array and the right array together comparing the values at each index
		while (left_index < left.length && right_index < right.length)
		{
			if (left[left_index] > right[right_index]){
				target[target_index] = right[right_index];
				target_index++;
				right_index++;
			}
			else {
				target[target_index] = left[left_index];
				target_index++;
				left_index++;
			}
		}
		//if there are any values left in the left array place them into the target array
		while (left_index < left.length){
			target[target_index] = left[left_index];
			target_index++;
			left_index++;
		}
		//if there are any values left in the right array place them into the target array
		while (right_index < right.length){
			target[target_index] = right[right_index];
			target_index++;
			right_index++;
		}
	}

	public static void main(String[] args)
	{
		KLists lists = new KLists();

		double [][] arr1 = new double[][] {{9.7, 17.1}, {15.8}, {12.7, 18.5, 21.27}};
		System.out.println(Arrays.toString(lists.mergeKLists(arr1)));

		double [][] arr2 = new double[][] {{1.1, 4.4, 5.5}, {1.1, 3.3, 4.4}, {2.2, 6.6}};
		System.out.println(Arrays.toString(lists.mergeKLists(arr2)));

		double [][] arr3 = new double[][] {{}};
		System.out.println(Arrays.toString(lists.mergeKLists(arr3)));

	}
}