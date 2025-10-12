package week1.day2;

public class IsPrimeNumber {

	public static void main(String[] args) {
		int number =13;
		int flag=0;
		
		if (number<=1) {
			flag =1;
		}
		else {
			for (int i = 2; i <= Math.sqrt(number); i++) {
				if(number%i==0)
				{
					flag=1;
					break;
				}
			}
		}
		
		if(flag==0)
		{
			System.out.println(number+" Is Prime Number");
		}
		else
		{
			System.out.println(number+" Is Not Prime Number");
		}
	}


	}


