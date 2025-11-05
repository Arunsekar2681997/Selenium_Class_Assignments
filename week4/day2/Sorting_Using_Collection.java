package week4.day2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sorting_Using_Collection {

	public static void main(String[] args) {
		
		//Declare the String values
		String[] values = {"HCL", "Wipro", "Aspire Systems", "CTS"};
		
		//Declare the empty list
		List<String> stringList = new ArrayList<String>();
		
		//Store the string values into the list using iteration
		for (int i = 0; i < values.length; i++) {
			stringList.add(values[i]);
		}
		
		//print the list before sort
		System.out.println(stringList);
		
		//sorting the list using Collections.sort
		Collections.sort(stringList);
		
		//Reverse the list using for loop and print
		for (int i = stringList.size()-1; i >= 0; i--) {
			System.out.print(stringList.get(i)+" ");
		}
		
	}

}
