package com.htc.testPages;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.htc.base.BaseTest;

public class LeadDatailsTest extends BaseTest {

	@Test(priority = 1, dataProviderClass = com.htc.base.DataProvider.class, dataProvider = "data")
	private void TestLeadDeatails(Map<Object, Object> mapData) throws InterruptedException {
		loginPage.LOGIN(mapData.get("username").toString(), mapData.get("password").toString());
		salestool.salesTool();
		boolean flag = leadDetails.leadData(mapData);
		System.out.println("Lead has been created successfully");
		Assert.assertEquals(true, flag);
	}

}
