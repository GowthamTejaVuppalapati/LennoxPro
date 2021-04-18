package com.htc.testPages;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.htc.base.BaseTest;

public class TestSalesTool extends BaseTest {

	@Test(priority = 1, dataProviderClass = com.htc.base.DataProvider.class, dataProvider = "data")
	private void TestSalestool(Map<Object, Object> mapData) throws InterruptedException {
		loginPage.LOGIN(mapData.get("username").toString(), mapData.get("password").toString());
		salestool.salesTool();
		boolean flag = salestool.verifySalesTool();
		Assert.assertEquals(true, flag);

	}

}
