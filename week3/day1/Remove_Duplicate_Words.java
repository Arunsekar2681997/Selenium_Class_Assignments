package week3.day1;

import java.util.Iterator;

public class Remove_Duplicate_Words {

	public static void main(String[] args) {
		
		//Actual Input
		String value = "We learn Java basics as part of java sessions in java week1"; 
		
		//Split the words using empty space
		String[] split_Value = value.split(" ");
		
		//creating variable and assig the value as 0
		int count = 0;
		
		//nested loop checks to compare the words one by one
		for (int i = 0; i < split_Value.length; i++) {
			for (int j = i+1; j < split_Value.length; j++) {
				
				//if condition to check , if  both words is same 
				if (split_Value[i].equalsIgnoreCase(split_Value[j])) {
					
					//replace the value with empty space
					split_Value[j]=" ";
					
					//post increment option to check the duplicate
					count++;	
				}
			}		
		}
		
		//Print the words without duplicate and added empty space for each word
		if (count>=1) {
			for (int i = 0; i < split_Value.length; i++) {	
				System.out.print(split_Value[i]+" ");					
			}
		}
		
	}

}
