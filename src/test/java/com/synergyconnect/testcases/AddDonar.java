package com.synergyconnect.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;
import com.synergyconnect.pageobject.AdminHome;
import com.synergyconnect.pageobject.LoginPage;
import com.synergyconnect.pageobject.stakeholder.AddDonarInfo;
import com.synergyconnect.pageobject.stakeholder.Contact;
import com.synergyconnect.pageobject.stakeholder.Corporate;
import com.synergyconnect.pageobject.stakeholder.Goals;
import com.synergyconnect.pageobject.stakeholder.NpbtDetails;
import com.synergyconnect.pageobject.stakeholder.PreferedLocation;

public class AddDonar extends BaseClass {
	@Test(priority=11)
	public void verifyLoginisworking() throws InterruptedException {
		
		
	}
	@Test(dependsOnMethods = "verifyLoginisworking",priority=12)
	public void verifyAddDonarInfo() throws InterruptedException {
		
		
	}
		
		@Test(dependsOnMethods = "verifyLoginisworking",priority=13)
		public void verifyDonarContents() throws InterruptedException {
			
			
				
		
		}
	}
	
	

	

