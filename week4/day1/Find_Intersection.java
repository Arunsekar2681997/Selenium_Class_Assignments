package week4.day1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Find_Intersection {

	public static void main(String[] args) {
		
		//declare first array
		int[] arr_Values = {3, 2, 11, 4, 6, 7};
		
		//declare second array
		int[] another_Array_Values = {1, 2, 8, 4, 9, 7};
		
		//declare the first list for first array values
		List<Integer> arrayList1 = new ArrayList<Integer>();
		
		//declare the second list for second array values
		List<Integer> arrayList2 = new ArrayList<Integer>();
		
		//iteration for add the values into the list from array one
		for (int i = 0; i < arr_Values.length; i++) {
			arrayList1.add(arr_Values[i]);
		}
		
		//iteration for add the values into the list from array two
		for (int i = 0; i < another_Array_Values.length; i++) {
			arrayList2.add(another_Array_Values[i]);		
		}
//		System.out.println(arrayList1);
//		System.out.println(arrayList2);
		
		//Print statement
		System.out.println("Common Values Are");
		
		//iterate the arrayList1 values one by one
		for (int i = 0; i < arrayList1.size(); i++) {
			//iterate the arrayList2 values one by one
			for (int j = 0; j < arrayList2.size(); j++) {
				//check both values are same
				if (arrayList1.get(i)==arrayList2.get(j)) {	
					//if condition is true , it will print the below statement
					System.out.println(arrayList1.get(i));
				}
			}
		}
	}

}
