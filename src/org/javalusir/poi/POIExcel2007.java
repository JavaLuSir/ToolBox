package org.javalusir.poi;

import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;
/**
 * This Demo is only used to parse Office Excel2007.If
 * the filepath is a Office Excel2003 file .It does't work
 * 
 * @author JavaLuSir 
 */
public class POIExcel2007 {

	public static void main(String[] args) {
		POIExcel2007 mytest = new POIExcel2007();
		try {
			mytest.processOneSheet("D:/test.xlsx");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * processOneSheet
	 * @param filename
	 * @throws Exception
	 */
	public void processOneSheet(String filename) throws Exception {

		OPCPackage pkg = OPCPackage.open(filename);
		
		XSSFReader r = new XSSFReader(pkg);
		
		SharedStringsTable sst = r.getSharedStringsTable();
		
		InputStream sheet = r.getSheet("rId1"); //rId1 is the first sheet.rId2 is the second sheet...

		XMLReader parser = fetchSheetParser(sst);

		InputSource sheetSource = new InputSource(sheet);
		parser.parse(sheetSource);
		sheet.close();
	}

	/**
	 * processAllSheets
	 * @param filename
	 * @throws Exception
	 */
	public void processAllSheets(String filename) throws Exception {
		OPCPackage pkg = OPCPackage.open(filename);
		XSSFReader r = new XSSFReader(pkg);
		SharedStringsTable sst = r.getSharedStringsTable();

		XMLReader parser = fetchSheetParser(sst);

		Iterator<InputStream> sheets = r.getSheetsData();
		while (sheets.hasNext()) {
			System.out.println("Processing new sheet:\n");
			InputStream sheet = (InputStream) sheets.next();
			InputSource sheetSource = new InputSource(sheet);
			parser.parse(sheetSource);
			sheet.close();
			System.out.println("");
		}
	}
	
	/**
	 * fetchSheetParser
	 * @param filename
	 * @throws Exception
	 */
	public XMLReader fetchSheetParser(SharedStringsTable sst)
			throws SAXException {
		XMLReader parser = XMLReaderFactory
				.createXMLReader("org.apache.xerces.parsers.SAXParser");

		ContentHandler handler = new SheetHandler(sst);
		parser.setContentHandler(handler);

		return parser;
	}
	
	/**
	 * Class SheetHandler
	 * 
	 * @param filename
	 * @throws Exception
	 */
	private static class SheetHandler extends DefaultHandler {
		private SharedStringsTable sst;
		private String lastContents;
		private boolean nextIsString;

		private SheetHandler(SharedStringsTable sst) {
			this.sst = sst;
		}

		/**
		 * startElement
		 */
		public void startElement(String uri, String localName, String name,
				Attributes attributes) throws SAXException {
			if (name.equals("c")) {
				System.out.print(attributes.getValue("r") + " - ");

				String cellType = attributes.getValue("t");

				if ((cellType != null) && (cellType.equals("s")))
					this.nextIsString = true;
				else {
					this.nextIsString = false;
				}
			}
			this.lastContents = "";
		}
		/**
		 * endElement
		 */
		public void endElement(String uri, String localName, String name)
				throws SAXException {

			if (this.nextIsString) {

				if (name.equals("v")) {
					int idx = Integer.parseInt(this.lastContents);

					this.lastContents = new XSSFRichTextString(
							this.sst.getEntryAt(idx)).toString();
				}
			}

			if (name.equals("v"))
				System.out.println(this.lastContents);
		}
		/**
		 * characters
		 */
		public void characters(char[] ch, int start, int length)
				throws SAXException {
			this.lastContents += new String(ch, start, length);
		}
	}
}
