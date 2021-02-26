package seleniumUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelSheet {

	private String filePath = System.getProperty("user.dir")+ "\\src\\test\\resources\\ExcelSheet\\";
	String tcName;
	
	public String getData(String fileName, String sheetName, String coloumnName) throws Exception {
		
		verifyTCNotNull(tcName);
		fileName = validateAndGetFileName(fileName);
		Workbook workBook = getWorkBook(fileName);
		Sheet sheet =workBook.getSheet(sheetName);
		String data = getDataIfExistElseThrowException(sheet,coloumnName);
		return data;
	}

	

	private String getDataIfExistElseThrowException(Sheet sheet, String coloumnName) throws CustomException{
		int targetCellNo = getTargetColoumnNoAtSheet(sheet,coloumnName);
		if(targetCellNo==-1)
			throw new CustomException("Coloumn name "+coloumnName+" does not present at Excel sheet: "+sheet.getSheetName());
		
		String data = getDataFromSheet(sheet,targetCellNo);
		if(data==null)
			throw new CustomException("Test Case "+tcName+" is not present at Excel sheet: "+sheet.getSheetName());
		return data;
	}



	private String getDataFromSheet(Sheet sheet, int targetColoumnNo) {
		String data = null;
		for(Row row :sheet) {
			if(row.getCell(0).getStringCellValue().trim().equalsIgnoreCase(tcName.trim())) {
				if(row.getCell(targetColoumnNo).getCellType()==CellType.NUMERIC)
					data = row.getCell(targetColoumnNo).getNumericCellValue()+"";
				else if(row.getCell(targetColoumnNo).getCellType()==CellType.STRING)
					data = row.getCell(targetColoumnNo).getStringCellValue();
				break;
			}
		}
		return data;
	}

	private int getTargetColoumnNoAtSheet(Sheet sheet, String coloumnName) {
		int targetCellNo =-1;
		Row firstRow = sheet.getRow(0);
		for(Cell cell:firstRow) {
			if(cell.getStringCellValue().trim().equalsIgnoreCase(coloumnName.trim())) {
				targetCellNo = cell.getColumnIndex();
				break;
			}
		}
		return targetCellNo;
	}


	private Workbook getWorkBook(String fileName) throws IOException {
		File file;
		FileInputStream fis;
		Workbook workBook;
		file= new File(filePath+fileName);
		fis = new FileInputStream(file);
		workBook=new HSSFWorkbook(fis);
		return workBook;
	}


	private String validateAndGetFileName(String fileName) {
		if(!fileName.contains(".xls"))
			fileName=fileName.trim()+".xls";
		return fileName;
	}

	private void verifyTCNotNull(String tcName2) throws Exception {
		if(tcName==null)
			throw new Exception("Set test case name first using (ExcelSheet) objName.setTestCaseName(); .");
	}

	public ExcelSheet setTestCaseName(String tcName) {
		this.tcName = tcName;
		return this;
	}
	
	public enum SheetName{
		General_Data,Data_Page,Parameterize_CheckPoint;
	}
	

	public List<String> etractMultipleValuesToList(String allValues, String splitString) {
		List<String> listOfValues = new ArrayList<String>();
		String[] values = allValues.split(splitString.trim());
		for(int i=0 ;i<values.length;i++) {
			listOfValues.add(values[i].trim());
		}
		return listOfValues;
	}
	
}
