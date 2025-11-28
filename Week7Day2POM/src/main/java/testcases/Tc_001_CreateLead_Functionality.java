package testcases;

import org.testng.annotations.Test;

import base.CommonCodes;
import pages.LoginPage;

public class Tc_001_CreateLead_Functionality extends CommonCodes {
	
	@Test
	public void LoginPage()
	{
		LoginPage lp = new LoginPage();
		lp.enterUsername().enterPassword().clickLogin().clickCRMSFA().clickLeads().clickCreateLead()
		.enterCompanyName().enterFirstName().enterLastname().clickSubmitButton();
	}

}
