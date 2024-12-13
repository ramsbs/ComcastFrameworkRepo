package practice.test;
/**
 * test class for contact module
 * @author Ramya
 * 
 */

import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass {
	/**
	 * Scenario: login()===> navigateContact===>createContact()==>verify
	 * 
	 */
	@Test
	public void searchcontactTest()
	{
		/*Step 1: login to app*/
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp("username","password");
	}

}
