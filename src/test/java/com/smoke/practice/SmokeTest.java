/*
 * Copyright (C) 2022 SAM
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
package com.smoke.practice;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.generic.BaseConfig;
import com.generic.CrossBrowserCheck;
import com.generic.MasterPageFactory;
import com.util.DatePicker;
import com.util.HighLighter;
import com.util.RadioButton;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author SAM
 *
 */

public class SmokeTest {
	
	@Test 
	public void testNG() throws FileNotFoundException, IOException, InterruptedException
	{
		
		/*
		 * System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		 * BaseLogin obj = new BaseLogin(); obj.baselogin();
		 * 
		 */
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = CrossBrowserCheck.browserCheck("chrome");
		MasterPageFactory MPF = new MasterPageFactory(driver);
		BaseConfig BC = new BaseConfig();
		driver.get(BC.getValue("url"));
		HighLighter highLighter = new HighLighter();
		//you can pass any color from this site : w3schools.com/colors/colors_names.asp in getColor as a 3rd Argument
		highLighter.getColor(driver, MPF.getFirstName(), "Tomato");
		MPF.getFirstName().sendKeys(BC.getValue("firstName"));
		//Thread.sleep(3000);
		highLighter.getColor(driver, MPF.getLastName(),"Olive");
		MPF.getLastName().sendKeys(BC.getValue("lastName"));
		//Thread.sleep(2000);
		highLighter.getColor(driver, MPF.getUserEmail(),"Orange");
		MPF.getUserEmail().sendKeys(BC.getValue("userEmail"));
		highLighter.getColor(driver, MPF.getUserEmail());
		MPF.getUserNumber().sendKeys(BC.getValue("userNumber"));
		highLighter.getColor(driver, MPF.getUserNumber());
		//MPF.getUserGender().sendKeys(BC.getValue("gender"));
		MPF.getUserDOB().sendKeys(BC.getValue("DOB"));
		//Thread.sleep(5);
		DatePicker.datePicker(driver);
		MPF.getSubjects().sendKeys(BC.getValue("subjects"));
		MPF.getSubjects().sendKeys(Keys.ENTER);
		MPF.getUserAddress().sendKeys(BC.getValue("address"));
		RadioButton.radioButton(driver, BC.getValue("gender"));
		RadioButton.checkButton(driver, BC.getValue("hobby"));
		MPF.getUpload().sendKeys(System.getProperty("user.dir")+
				System.getProperty("file.separator")+BC.getValue("picture"));
		MPF.getState().sendKeys(Keys.ARROW_DOWN);
		MPF.getState().sendKeys(BC.getValue("state"));
		MPF.getState().sendKeys(Keys.TAB);
		MPF.getCity().sendKeys(Keys.ARROW_DOWN);
		MPF.getCity().sendKeys(BC.getValue("city"));
		MPF.getCity().sendKeys(Keys.TAB);
		MPF.getSubmit().submit();
		
	}


}
