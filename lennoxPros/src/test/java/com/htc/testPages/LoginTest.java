package com.htc.testPages;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.base.BaseTest;
public class LoginTest extends BaseTest {
	 


	@Test(priority = 1, dataProviderClass = com.htc.base.DataProvider.class, dataProvider ="data")
	private void TestvalidLogin(Map<Object, Object> mapData) {
		loginPage.LOGIN(mapData.get("username").toString(),mapData.get("password").toString());
	    boolean flag=loginPage.verifyLogin();
	    System.out.println("Login Successfull");
	    Assert.assertEquals(true, flag);
	}
	
	
	
}
