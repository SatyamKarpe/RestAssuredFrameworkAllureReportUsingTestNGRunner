package commonFunctionPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterTest;

public class Utility_commonFunction {
	
	public static void evidencefilecreator(String filename,String requestbody,String responsebody) throws IOException 
	{
		File newfile=new File("C:\\Users\\swapnil\\Desktop\\testfile.xlsx" +filename+".txt");
		System.out.println("a new text file created to record request and response of API:"+filename+".txt");
		FileWriter datawrite=new FileWriter(newfile);
		datawrite.write("request body:" +requestbody+"\n\n");
		datawrite.write("response body:" +responsebody);
		datawrite.close();
		System.out.println("request body and respone body are saved in :" +newfile.getName());
				
		}
     public static ArrayList<String>readdataexcel(String sheetname,String testcasename) throws IOException
     {
    	 ArrayList<String>ArrayData=new ArrayList<String>();
    	 
    	//step1: create the object of File input stream
    	FileInputStream fis= new FileInputStream("C:\\Users\\swapnil\\Desktop\\testfile.xlsx");
    	
    	 //step2: access the EXCIL name
    	XSSFWorkbook workbook=new XSSFWorkbook(fis);
    	//step3: Access the SHEET name
    	int countofsheet=workbook.getNumberOfSheets();
    	for(int i=0;i<countofsheet;i++)
    	{
    		String filesheetname=workbook.getSheetName(i);
    		if(filesheetname.equalsIgnoreCase(sheetname))
    		{
    	//step4 access the row from where the data is suppose to fetch
    			XSSFSheet sheet=workbook.getSheetAt(i);
    			Iterator<Row>rows =sheet.iterator();
                //Row r=rows.next();
    		while(rows.hasNext())
    		{
    			Row r1=rows.next();
    			if (r1.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
    			{
    			Iterator<Cell> cellvalues=r1.cellIterator();
    			while (cellvalues.hasNext()) {
    				String testdata=cellvalues.next().getStringCellValue();
    				ArrayData.add(testdata);
    			}
    			
    			}
    		}
   
    	}
    	
    	} 
    	 workbook.close();
    	 return ArrayData;
    	 
    	 
     }
}