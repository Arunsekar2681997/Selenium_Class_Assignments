package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Find_Second_Largest_Number {

	public static void main(String[] args) {
		
		//Declare the Array Values
		int[] arrayValues = {3, 2, 11, 4, 6, 7};
		
		//Declare the lis
		List<Integer> listValues = new ArrayList<Integer>();
		
		//add the array value into list using for loop 
		for (int i = 0; i < arrayValues.length; i++) {
			listValues.add(arrayValues[i]);
		}
		
		//print the listvalues post add
		System.out.println(listValues);
		
		//Sorting the values using collections.sort();
		Collections.sort(listValues);
		
		//Now print the list values for understanding post sorting
		System.out.println(listValues);
		//get the list size
		int listSize = listValues.size();
		
		//now print the second largest nimber using listsize-2 , Since the array size is 6 and the index starts from 1
		System.out.println("Second Largest Value In The List Is : "+listValues.get(listSize-2));
	}


}
