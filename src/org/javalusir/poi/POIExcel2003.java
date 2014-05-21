package org.javalusir.poi;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * This Demo is only used to parse Office Excel2003.If
 * the filepath is a Office Excel2003 file .It does't work
 * 
 * @author javalusir
 * 
 */
public class POIExcel2003 {

	public static void main(String[] args) throws Exception {
		read("d:\\test2003.xls");
	}

	/**
	 * read a Excel file
	 * @param fileName
	 * @return
	 */
	public static ArrayList<String> read(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		try {
			File f = new File(fileName);
			FileInputStream fis = new FileInputStream(f);
			HSSFWorkbook wbs = new HSSFWorkbook(fis);
			
			HSSFSheet sheet = wbs.getSheetAt(0);

			for(int i=0;i<sheet.getLastRowNum();i++){
				HSSFRow row = sheet.getRow(i);
				for(int j=0;j<row.getLastCellNum();j++){
					HSSFCell cell = row.getCell(j);
					if(cell!=null)
					System.out.println(getStringCellValue(cell));
				}
			}
		
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * Obtain the cell data content as a string data type
	 * 
	 * @param cell
	 *            Excel The cell
	 * @return String The cell data content
	 */
	private static String getStringCellValue(HSSFCell cell) {
		String strCell = "";
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_STRING:
			strCell = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_NUMERIC:
			strCell = String.valueOf(cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN:
			strCell = String.valueOf(cell.getBooleanCellValue());
			break;
		case HSSFCell.CELL_TYPE_BLANK:
			strCell = "";
			break;
		default:
			strCell = "";
			break;
		}
		if (strCell.equals("") || strCell == null) {
			return "";
		}
		return strCell;
	}

}
