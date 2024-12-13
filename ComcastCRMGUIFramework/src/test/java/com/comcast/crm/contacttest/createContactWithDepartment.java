package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;

public class createContactWithDepartment extends BaseClass {
	
	@Test
	
	public void createContactwithDepart() throws EncryptedDocumentException, IOException
	{
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();
		String departName = eLib.getDataFromExcel("productContact", 10, 3)+ jLib.getRandomNumber();

		// step2 : navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on create contact Button
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		// step 4: enter all the details & create new Contact
				CreateNewContactPage ccp = new CreateNewContactPage(driver);
				ccp.createTitle(ContactlastName, departName);
				ContactInformationPage cip=new ContactInformationPage(driver);
				String actualTitle = cip.getActualTitle().getText();
				if(actualTitle.contains(departName))
				{
					System.out.println(departName+"department name is verified and pass");
				}
				else
				{
					System.out.println(departName+"department name is not verified and fail");
				}
			}

	}


