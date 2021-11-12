package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericutilities.BaseClass;
@Listeners(com.vtiger.genericutilities.ListnerImplementation.class)
public class FailedTestCaseScreenshot extends BaseClass {
	@Test
	public void listnerPractice() {
		System.out.println("testcasefail");
		Assert.fail();
	}
	

}
