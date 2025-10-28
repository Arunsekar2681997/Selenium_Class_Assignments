package week3.day2;

public class APIClient {
	
	public void sendRequest(String endPoint)
	{
		System.out.println("URL End Point Is : "+endPoint);
	}
	
	public void sendRequest(String endPoint , String requestBody,boolean requestStatus)
	{
		System.out.println("URL End Point Is : "+endPoint+" "+"And The Request Body Is :"+requestBody);
		System.out.println("URL Request Status Is : "+requestStatus);
	}
	
	
	public static void main(String[] args) {
		
		APIClient ac = new APIClient();
		ac.sendRequest("192.52.45.6");
		ac.sendRequest("25.2.24.65", "Success With The Code 200", true);
	}
}
