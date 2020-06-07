package com.hrms.testcases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.ConfigsReader;



public class LoginTest extends CommonMethods {

	@Test(groups="smoke")
	public void adminLogin() {

		
		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, ConfigsReader.getProperty("password"));
		click(login.loginBtn);

		
		String expected = "Welcome Admin";
		String actual = dashboard.welcome.getText();
		Assert.assertEquals(expected, actual);
		System.out.println("Admin Log in Successful");
		
		takeScreenshot(actual);
	}

	@Test(groups="regression")
	public void invalidPasswordLogin() {

		LoginPageElements login = new LoginPageElements();

		sendText(login.username, ConfigsReader.getProperty("username"));
		sendText(login.password, "sadadad");
		click(login.loginBtn);

		String expected = "Invalid credentials";
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");
		System.out.println("InvalidPasswordLogin passed");
	}

	@Test(groups="regression")
	public void emptyUsernameLogin() {

		LoginPageElements login = new LoginPageElements();
		sendText(login.password,ConfigsReader.getProperty("password"));
		click(login.loginBtn);
		
		String expected="Username cannot be empty";
		
		Assert.assertEquals(login.errorMsg.getText(), expected, "Error message text is not matched");

	}
	// @Test
		public void timeStamp() {
			Date d = new Date();
			System.out.println(d.getTime());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
			System.out.println(sdf.format(d.getTime()));
		}
}
