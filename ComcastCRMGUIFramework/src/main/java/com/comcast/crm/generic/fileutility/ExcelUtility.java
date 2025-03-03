package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcel(String sheetName, int rowNum, int celNum) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./testData/Org.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetName).getRow(rowNum).getCell(celNum).getStringCellValue();
		return data;
	}
	
	public int getRowcount(String sheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis=new FileInputStream("./testData/Org.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowNum=wb.getSheet(sheetName).getLastRowNum();
		return rowNum;
		
	}
	public void setDataIntoExcel(String sheetName, int rowNum, int celNum, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/Org.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(celNum);
		FileOutputStream fos=new FileOutputStream("./testData/Org.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	
	public List<String> getMulDataFromEcxel(String sheetName,int rowNum,int colNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./testData/Org.xlsx") ;
		
		List<String> all_Data=new ArrayList<>();
		Workbook book=WorkbookFactory.create(fis) ;
		for(int i=1;i<=rowNum;i++)
		{
			for(int j=0;j<=colNum;j++)
			{
				String data=book.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue();
				all_Data.add(data);
			}
		}
		return all_Data;
		
	}
	

}
