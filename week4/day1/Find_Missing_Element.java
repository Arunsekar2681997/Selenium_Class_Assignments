package week4.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Find_Missing_Element {

	public static void main(String[] args) {
		
		//crate a array
		int[] arrayValues = {1, 2, 3, 4, 10, 6, 8};
		
		//intialize list
		List<Integer> listValues = new ArrayList<Integer>();
		
		//Store the array values into the list
		for (int i = 0; i < arrayValues.length; i++) {
			listValues.add(arrayValues[i]);

		}
		
		//Print the list values
		System.out.println(listValues);
		
		//Sort the list using collections.sort()
		Collections.sort(listValues);
		
		//Printing the list values post sort
		System.out.println(listValues);
		
		int number = 1;
		
		//using for and while to find the missing element
		for (int i = 0; i < listValues.size(); i++) {
			while (listValues.get(i)!=number) {
				//print the missing number
				System.out.println("Missing Element Is : "+number);
				//increment the number value by one 
				number++;
			}
			//increment the number value by one
			number++;
		}
	}

}
