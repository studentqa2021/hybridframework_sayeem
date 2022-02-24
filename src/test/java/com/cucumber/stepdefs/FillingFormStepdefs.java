/*
 * Copyright (c) 2022 SAM
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; version 2
 * of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package com.cucumber.stepdefs;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.generic.BaseConfig;
import com.generic.CrossBrowserCheck;
import com.generic.MasterPageFactory;
import com.util.HighLighter;
import com.util.RadioButton;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FillingFormStepdefs {
	
	BaseConfig BC = new BaseConfig();
	HighLighter highLighter = new HighLighter();
	WebDriver driver;
	MasterPageFactory MPF;
	
	@Given("Open browser")
	public void open_browser() 
	{
	   WebDriverManager.chromedriver().setup();
	   driver = CrossBrowserCheck.browserCheck("chrome");
	}
	

	@And("Go to URL")
	public void go_to_URL() throws FileNotFoundException, IOException {
	    driver.get(BC.getValue("url"));
	}
	
	@When("put first name")
	public void put_first_name() throws Exception
	{
		MPF = new MasterPageFactory(driver);
		highLighter.getColor(driver, MPF.getFirstName(), "Tomato");
		MPF.getFirstName().sendKeys(BC.getValue("firstName"));
	}

	@And("put last name")
	public void put_last_name() throws Exception
	{
		MPF = new MasterPageFactory(driver);
	    highLighter.getColor(driver,MPF.getLastName(), "Olive");
	    MPF.getLastName().sendKeys(BC.getValue("lastName"));
	}

	@And("put email")
	public void put_email() throws Exception 
	{
		MPF = new MasterPageFactory(driver);
	    highLighter.getColor(driver, MPF.getUserEmail(), "Orange");
	    MPF.getUserEmail().sendKeys(BC.getValue("userEmail"));
	}

	@And("select gender")
	public void select_gender() throws Exception
	{
		RadioButton.radioButton(driver, BC.getValue("gender"));
	}

	@And("put mobile number")
	public void put_mobile_number() throws Exception 
	{
		MPF = new MasterPageFactory(driver);
	    highLighter.getColor(driver, MPF.getUserNumber());
	    MPF.getUserNumber().sendKeys(BC.getValue("userNumber"));
	}

	@And("put DateOfBirth")
	public void put_DateOfBirth() throws Exception
	{
		MPF = new MasterPageFactory(driver);
		MPF.getUserDOB().sendKeys(BC.getValue("DOB"));
	}

	@And("put subjects")
	public void put_subjects() throws Exception
	{
		MPF = new MasterPageFactory(driver);
		MPF.getSubjects().sendKeys(BC.getValue("subjects"));
	}

	@And("put hobbies")
	public void put_hobbies() throws Exception
	{
	   RadioButton.checkButton(driver, BC.getValue("hobby"));
	}

	@And("select picture")
	public void select_picture() throws Exception
	{
		MPF = new MasterPageFactory(driver);
		MPF.getUpload().sendKeys(System.getProperty("user.dir")+
				System.getProperty("file.separator")+BC.getValue("picture"));
	}

	@And("put current address")
	public void put_current_address() throws Exception
	{
		MPF = new MasterPageFactory(driver);
		highLighter.getColor(driver, MPF.getUserAddress());
		MPF.getUserAddress().sendKeys(BC.getValue("address"));
	}

	@And("select state")
	public void select_state() throws Exception
	{
		MPF = new MasterPageFactory(driver);
		MPF = new MasterPageFactory(driver);
		MPF.getState().sendKeys(Keys.ARROW_DOWN);
		MPF.getState().sendKeys(BC.getValue("state"));
		MPF.getState().sendKeys(Keys.TAB);
		 
	}

	@And("select city")
	public void select_city() throws Exception
	{
		
		MPF = new MasterPageFactory(driver);
		MPF = new MasterPageFactory(driver);
		MPF.getCity().sendKeys(Keys.ARROW_DOWN);
		MPF.getCity().sendKeys(BC.getValue("city"));
		MPF.getCity().sendKeys(Keys.TAB);
	}

	@Then("click submit")
	public void click_submit() throws Exception
	{
		MPF = new MasterPageFactory(driver);
		MPF.getSubmit().submit();
	}

	@And("teardown browser")
	public void teardown_browser() throws InterruptedException 
	{
	    Thread.sleep(5000);
	    driver.quit();
	}

}
