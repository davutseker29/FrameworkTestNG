package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class SauceDemoLoginPage extends CommonMethods {

	// Not using PageFactory, You have to extend CommonMethods or BaseClass
		// public WebElement username2=driver.findElement(By.id("txtUsername"));

		// Using PageFactory and @FindBy Annotation
		@FindBy(id = "user-name")
		public WebElement username;

		@FindBy(id = "password")
		public WebElement password;

		@FindBy(xpath="//input[@class='btn_action']")
		public WebElement loginBtn;

		@FindBy(xpath = "//div[@class='bot_column']")
		public WebElement logo;

		@FindBy(xpath="//h3[@data-test='error']")
		public WebElement errorMsg;
		
		@FindBy(xpath="//div[text()='Products']")
		public WebElement headerText;

		public SauceDemoLoginPage() {
			PageFactory.initElements(BaseClass.driver, this);
		}

		//if we would be keeping elements as private 
		//then we will need to create public getters and setters 
		//so we can access page elements from test classes
		
		//setter
		public void sendUsername(String uid) {
			sendText(username, uid);
		}
		
		//getter
		public WebElement getUsername() {
			return username;
		}
		
		public void login(String uid, String pwd) {
			sendText(username, uid);
			sendText(password, pwd);
			click(loginBtn);
		}
		
	}

