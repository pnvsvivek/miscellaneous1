package checkerswithmain;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Check1 {	
	
	@Test(dataProvider="arthmatics")
	public void sum(String  a, String b, String c)
	{
		System.out.println(Float.valueOf(a)+Float.valueOf(b)+Float.valueOf(c));
	}
	
	@Test(dataProvider="arthmatics")
	public void mul(String a, String b, String c)
	{
		System.out.println(Float.valueOf(a)*Float.valueOf(b));
	}
	
	@Test(dataProvider="arthmatics")
	public void sub(String a, String b, String c)
	{
		System.out.println(Float.valueOf(a)-Float.valueOf(b));
	}
	
	@DataProvider(name="arthmatics")
	public Object[][] inputs(Method m) throws IOException 
	{
		String path = "C:\\Users\\p.nvs.vivek\\Documents\\viki.xlsx";
		String sheetname = "test";
		FileInputStream fis = new FileInputStream(path);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sh = wb.getSheet(sheetname);
		int rd = sh.getLastRowNum()-sh.getFirstRowNum();
		int col = sh.getRow(0).getLastCellNum()-3;
		Set<String> set = new HashSet<String>();
		HashMap<String, Object[][]> hm = new HashMap<String, Object[][]>();
		for(int i=1;i<=rd;i++)
		{
			set.add(sh.getRow(i).getCell(1).toString());
		}
		for(String s:set)
		{
			ArrayList<Integer> al = new ArrayList<Integer>();			
			for(int i=1;i<=rd;i++)
			{
				if(sh.getRow(i).getCell(1).toString().contains(s))
				{
					al.add(i);
				}
			}
			Object[][] ob = new Object[al.size()][col];
			for(int k=0;k<al.size();k++)
			{
				for(int j=3;j<col+3;j++)
				{
					ob[k][j-3]=sh.getRow(al.get(k)).getCell(j).toString();
				}
			}
			hm.put(s, ob);
		}
		for(String a:hm.keySet())
		{
			if(m.getName().equalsIgnoreCase(a))
			{
				return hm.get(a);
			}
		}
		return null;
	}
}
