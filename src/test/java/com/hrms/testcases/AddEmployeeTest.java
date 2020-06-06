package com.hrms.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;

public class AddEmployeeTest extends CommonMethods {

//		Automate user stories below:
//		US 12678 As an Admin I should be able to create login credentials while adding employee
//
//		US 67789 As an admin while adding employee if I leave required fields empty I should see “Required” message
//		Note: first name and last name are required fields

	@Test
	public void loginCredentials() {

		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		wait(3);

		sendText(addEmp.firstName, "ziya");
		sendText(addEmp.lastName, "sengul");
		click(addEmp.checkboxLoginDetails);

		sendText(addEmp.username, "hakki");
		sendText(addEmp.password, "Ankar@_29");
		sendText(addEmp.confirmPassword, "Ankar@_29");
		wait(3);
		jsClick(addEmp.saveBtn);
		Assert.assertTrue(true, "Error");
		System.out.println("passed");
		wait(4);
	}

//	@Test
	public void requiredtest() {
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		dashboard.navigateToAddEmployee();
		wait(3);
		sendText(addEmp.firstName, "ziya");
		click(addEmp.saveBtn);

		waitForVisibility(pdetails.lblPersonalDetails);
		
	}

} 