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

package com.generic;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class MasterPageFactory {
	
	public MasterPageFactory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@id = 'firstName']")
	private WebElement firstName;
	@FindBy(xpath = "//*[@id = 'lastName']")
	private WebElement lastName;
	@FindBy(xpath = "//*[@id = 'userEmail']")
	private WebElement userEmail;
	@FindBy(xpath = "//*[@id = 'userNumber']")
	private WebElement userNumber;
	@FindBy(xpath = "//*[@id = 'currentAddress']")
	private WebElement userAddress;
	@FindBy(xpath = "//input[@id = 'dateOfBirthInput']")
	private WebElement userDOB;
	@FindBy(xpath = "//*[@id = 'subjectsInput']")
	private WebElement subjects;
	@FindBy(xpath =  "//*[@id='uploadPicture']")
	private WebElement upload;
	@FindBy(xpath = "//*[@id = 'react-select-3-input']")
	private WebElement state;
	@FindBy(xpath = "//*[@id = 'react-select-4-input']")
	private WebElement city;
	@FindBy(xpath = "//*[@type = 'submit']")
	private WebElement submit;

}
