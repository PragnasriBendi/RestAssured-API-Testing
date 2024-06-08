package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		String path=System.getProperty("user.dir")+"//testData//UserData.xlsx";
		
		XLUtility xl=new XLUtility(path);
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1", 1);
		
		String apidata[][]=new String[rownum][colcount]; //created for two dimension array
		
		for(int i=1;i<=rownum;i++) { //1 //read the data from x1 storing in two dimensional array
			for(int j=0;j<=colcount;j++) {  //0 i is row j is col 
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);  // 1,0
			}
		}
		return apidata;  //returning two dimensional array
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException {
		String path=System.getProperty("user.dir")+"//testData//UserData.xlsx";
		
		XLUtility xl=new XLUtility(path);
		int rownum=xl.getRowCount("Sheet1");
		
		String apidata[]=new String[rownum];
		
		for(int i=1;i<=rownum;i++) { //1 //read the data from x1 storing in two dimensional array
				apidata[i-1]=xl.getCellData("Sheet1", i, 1);  // 1,0
			}
		
		return apidata;
		}
	}

