package week3.day1;

import java.util.Arrays;

public class FindMissingElement {

	public static void main(String[] args) {
		
		//Array Values
		int a[]={1,4,3,2,8,6,7};
		
		//Sorting the array list
		Arrays.sort(a);
		
		//assign the first value to count variable
		int count = a[0];
		
		//using for loop for iteration
		for (int i = 0; i < a.length; i++) {
			
			//usinf while loops to checking the count value with the array value one by one
			while(count<a[i])
			{
				
				//print the msising value if while loop condition is true and increment the count value by one
				System.out.println("Missing the Number in the array is : "+count);
				count++;
			}
			//increment count value by one
			count++;
		}
	}
}
