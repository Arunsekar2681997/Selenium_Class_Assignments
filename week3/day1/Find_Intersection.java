package week3.day1;

import java.util.Arrays;

public class Find_Intersection {

	public static void main(String[] args) {
		
		//first array list values
		int a[]={3,2,11,4,6,7}; 
		
		//second array list values
		int b[]={1,2,8,4,9,7};
		
		//sorting the first array values
		Arrays.sort(a);
		
		//sorting the second array values
		Arrays.sort(b);
		
		//using for loop to iterate the first array value one by one
		for (int i = 0; i < a.length; i++) {
			
			//using for loop to iterate the second array value one by one
			for (int j = 0; j < b.length; j++) {
				
				//comparing array values
				if(a[i]==b[j])
				{
					//printing the duplicate values
					System.out.println("Duplicate Value Is : "+a[i]);
				}
			}
		}

	}

}
