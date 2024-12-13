package com.crm.comcast.CreateContactTest;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.listenerUtility.ListenerImplimentationClass;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationChildWindow;
import com.comcast.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

/**
 * 
 * @author Ramya
 * 
 */
@Listeners(com.comcast.crm.listenerUtility.ListenerImplimentationClass.class)
public class createContactTest extends BaseClass {

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();

		/*step2 : navigate to contact module*/
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact Page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on create contact Button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create contact Page");
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		// step 4: enter all the details & create new Contact
		UtilityClassObject.getTest().log(Status.INFO,"create contact");
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactNew(ContactlastName);
		UtilityClassObject.getTest().log(Status.INFO, ContactlastName+"create new contact");
		System.out.println(ContactlastName);

		// verify Header info Expected Result
		String actLastName = cp.getHeaderContactName().getText();
		System.out.println(actLastName);
		//Assert.assertEquals(true,actLastName.contains(ContactlastName);
		Assert.assertEquals(true,actLastName.contains(ContactlastName));
		System.out.println("Info verified and pass");
		UtilityClassObject.getTest().log(Status.PASS, ContactlastName+"contact is created");

	}

	@Test

	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String orgname = eLib.getDataFromExcel("productOrg", 4, 1) + jLib.getRandomNumber();
		String lastname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();

		// step2: navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact Page");
		ContactPage cp = new ContactPage(driver);
		cp.getContactlink().click();

		// step3: click on create contact Button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create contact Page");
		cp.getCreatecontactbtn().click();
		// driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();

		// step4: enter all the detail create new contact
		
		String startDate = jLib.getSystemDateYYYYDDMM();
		String endDate = jLib.getRequiredDateYYYYDDMM(20);

		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContact(lastname, startDate, endDate);
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actSuptStartDate = cip.getActualStartDateinCnt();
		UtilityClassObject.getTest().log(Status.PASS,actSuptStartDate+":actual support start date");
		System.out.println(actSuptStartDate);
		Assert.assertEquals(true,actSuptStartDate.contains(startDate));
		//if (actSuptStartDate.equals(startDate)) {
			System.out.println(startDate + " start date verified and pass");
		//} else {
			//System.out.println(startDate + "start date verified and fail");
		//}*/

		// step6: verify the support end Date

		String actSupprtEndDate = cip.getActualStartEndDateinCnt();
		UtilityClassObject.getTest().log(Status.PASS,actSupprtEndDate+":actual support end date");
		System.out.println(actSupprtEndDate);
		Assert.assertEquals(true,actSupprtEndDate.contains(endDate));
		//if (actSupprtEndDate.equals(endDate)) {
			System.out.println(endDate + " end Date verified and pass");
		//} else {
			//System.out.println(endDate + "end Date verified and Fail");
		//}

	}

	@Test

	public void createContactWithOrg() throws EncryptedDocumentException, IOException, InterruptedException {
		// read testscript data from Excel
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String orgname = eLib.getDataFromExcel("productOrg", 4, 2) + jLib.getRandomNumber();

		// step2: navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		Thread.sleep(2000);
		// create organization
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		OrganizationsPage cop = new OrganizationsPage(driver);
		cop.getCreateNewOrgBtn().click();

		// step4: enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO,"org name is created");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgname);

		// step6: verify header mesg expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		Assert.assertEquals(true,actOrgName.contains(orgname));
		//if (actOrgName.contains(orgname)) {
			System.out.println(orgname + "is verified and pass");
			UtilityClassObject.getTest().log(Status.PASS,orgname+" is verified");
		//} else {
			//System.out.println(orgname + "is not verified and FAIL");
		

		// String orgname1 = eLib.getDataFromExcel("productContact", 7,
		// 2)+jLib.getRandomNumber();
			UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();
		// step2: navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to contact module");
		ContactPage cp = new ContactPage(driver);
		cp.getContactlink().click();

		// step3: click on create contact Button
		cp.getCreatecontactbtn().click();

		// step4: create new Contact with Organization
		UtilityClassObject.getTest().log(Status.INFO,"create new contact with org");
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createContactwithOrg(ContactlastName);

		// step5: switch to childwindow
		UtilityClassObject.getTest().log(Status.INFO,"switch to child window");
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.switchNewBrowserTabBasedonUrl(driver, "module=Accounts");
		OrganizationChildWindow ocw = new OrganizationChildWindow(driver);
		Thread.sleep(1000);
		UtilityClassObject.getTest().log(Status.INFO,"verify org name in contact");
		ocw.verifyOrgNameInContact(orgname);
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
		// parent
		wLib.switchNewBrowserTabBasedonUrl(driver, "module=Contacts");
		CreateNewContactPage cnc = new CreateNewContactPage(driver);
		cnc.getSaveBtn().click();
		Thread.sleep(2000);

		String headerinfo = cp.getHeaderContactName().getText();
		Assert.assertEquals(true,headerinfo.contains(ContactlastName));
		//if (headerinfo.contains(ContactlastName)) {

			System.out.println(ContactlastName + "header verified ===PASS");
			UtilityClassObject.getTest().log(Status.PASS,ContactlastName+" header veified");
		//} else {
			//System.out.println(ContactlastName + "header verified is not verified==FAIL");
		
        
		String actualOrgName = cnop.getActualOrgName().getText();
		Assert.assertEquals(true,actualOrgName.contains(orgname));
		//if (actualOrgName.contains(orgname)) {
			System.out.println(orgname + "is verified===PASS");
			UtilityClassObject.getTest().log(Status.PASS,orgname+" is verified");
		//} else {
			//System.out.println(orgname + "is not verified===FAIL");
		}



	@Test
	public void createContactWithTitle() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();
		String TitleName = eLib.getDataFromExcel("productContact", 10, 3) + jLib.getRandomNumber();

		// step2 : navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on create contact Button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create contact page");
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();

		// step 4: enter all the details & create new Contact
		UtilityClassObject.getTest().log(Status.INFO,"new contact created");
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createTitle(ContactlastName, TitleName);
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualTitle = cip.getActualTitle().getText();
		Assert.assertEquals(true,actualTitle.contains(TitleName));
		//if (actualTitle.contains(TitleName)) {
			System.out.println(TitleName + "Title is verified and pass");
			UtilityClassObject.getTest().log(Status.PASS,TitleName+" is verified");
		//} else {
			//System.out.println(TitleName + "Title is not verified and fail");
		}
	
	

	@Test

	public void createContactwithDepart() throws EncryptedDocumentException, IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel");
		String ContactlastName = eLib.getDataFromExcel("productContact", 7, 3) + jLib.getRandomNumber();
		String departName = eLib.getDataFromExcel("productContact", 10, 3) + jLib.getRandomNumber();

		// step2 : navigate to contact module
		UtilityClassObject.getTest().log(Status.INFO,"navigate to home page");
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();

		// step3: click on create contact Button
		UtilityClassObject.getTest().log(Status.INFO,"navigate to create contact page");
		ContactPage cp = new ContactPage(driver);
		cp.getCreatecontactbtn().click();
		// step 4: enter all the details & create new Contact
		UtilityClassObject.getTest().log(Status.INFO,"new contact created");
		CreateNewContactPage ccp = new CreateNewContactPage(driver);
		ccp.createTitle(ContactlastName, departName);
		ContactInformationPage cip = new ContactInformationPage(driver);
		String actualTitle = cip.getActualTitle().getText();
		Assert.assertEquals(true,actualTitle.contains(departName));
			System.out.println(departName + "department name is verified and pass");
			UtilityClassObject.getTest().log(Status.PASS,departName+" is verified");
		//} else {
			//System.out.println(departName + "department name is not verified and fail");
		}
	}

	

