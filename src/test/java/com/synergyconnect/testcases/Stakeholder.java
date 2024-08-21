package com.synergyconnect.testcases;

import org.testng.annotations.Test;

import com.synergyconnect.common.BaseClass;

public class Stakeholder extends BaseClass {
	@Test(priority = 7)
	public void verifyLoginisworking() throws InterruptedException {

	}

	@Test(dependsOnMethods = "verifyLoginisworking", priority = 8)
	public void verifyNgoPartners() throws InterruptedException {

	}

	@Test(priority = 9)
	public void verifyNonNgoPartners() throws InterruptedException {

	}

	@Test(priority = 10)
	public void verifyAddUsers() throws InterruptedException {

	}
}
