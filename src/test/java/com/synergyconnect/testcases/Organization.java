package com.synergyconnect.testcases;

import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;

public class Organization extends BaseClass{
	@Test
	//@Test(retryAnalyzer = com.synergyconnect.utilities.RetryAnalyzer.class)
	public void verifyLoginisworking() throws InterruptedException {
		
		
		
	}
	@Test
	//@Test(retryAnalyzer = com.synergyconnect.utilities.RetryAnalyzer.class)
	public void verifyAddOrganization() throws InterruptedException {
		
		
		}
	
	@Test(dependsOnMethods = "verifyLoginisworking",priority=1)
		public void	verifyAddLocation() throws InterruptedException {
		
			
		}
}
