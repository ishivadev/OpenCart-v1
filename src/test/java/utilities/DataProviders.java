package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = ".\\testData\\OpenCart_LoginDDT.xlsx";
		
		//Providing the path that will be used in constructor 
		ExcelUtility xlutil = new ExcelUtility(path);
		
		//Getting total rows and total columns
		int totalRows = xlutil.getRowCount("Sheet1");
		int totalColumns = xlutil.getCellCount("Sheet1",1);
		
		String[][] logindata = new String[totalRows][totalColumns];  //Creating the logindata two dimension array 
		
		//Looping every column for every row one-by-one
		for(int r=1; r <= totalRows; r++)
		{
			for(int c=0; c < totalColumns; c++)
			{
				logindata[r-1][c] = xlutil.getCellData("Sheet1", r, c);
			}
		}
		
		return logindata; // returning the data 
	}
	
	
	// DataProvider 2
	
	
	// DataProvider 3
	
	
	// DataProvider 4
	
	
}
