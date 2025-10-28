package week3.day1;

public class Change_Odd_Index_To_UpperCase {

	public static void main(String[] args) {


		//assign the value for the String class
		String value = "changeme";
		
		//covert to chararray
		char[] charArray = value.toCharArray();
		
		//using for loop for iteration
		for (int i = 0; i < charArray.length; i++) {
			
			//condition to validate the odd value
			if (i%2!=0) {
				
				//covert the char to uppercase
				charArray[i] =  Character.toUpperCase(charArray[i]);
			}
		}
		
		//printing the values using for loop after changing to odd values as uppercase 
		for (int i = 0; i < charArray.length; i++) {
			System.out.print(charArray[i]);
		}

	}

}
