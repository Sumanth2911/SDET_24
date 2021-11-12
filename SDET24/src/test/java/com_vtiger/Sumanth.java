package com_vtiger;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sumanth {
	@Test(retryAnalyzer = com.vtiger.genericutilities.RetryAnalyzer.class )
	public void name() {
		System.out.println("my name is sumanth");
		Assert.fail();

	}

}
