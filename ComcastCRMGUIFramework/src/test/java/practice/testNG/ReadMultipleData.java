package practice.testNG;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import com.comcast.crm.generic.fileutility.ExcelUtility;


public class ReadMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException
	
	{
		ExcelUtility eLib=new ExcelUtility();
		int rowCount=eLib.getRowcount("Sheet1");
		
		List<String> data=eLib.getMulDataFromEcxel("Sheet1", rowCount, 3);
		System.out.println(data.size());
		for(int i=0;i<data.size();i++)
		{
			System.out.println(data.get(i));
		}
	}
	
}
