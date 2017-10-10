package checkerswithmain;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checker2 extends Checker1{
	
	public static void main(String args[]) throws IOException
	{
		/*String str = "name is vivek";
		String strnew = "";
		String temp="";
		String t="";
		for(int i=0; i<str.length();i++)
		{
			temp+=str.charAt(str.length()-1-i);
		}
		for(int i=0;i<temp.length();i++)
		{
			t+=temp.charAt(i);
			if(temp.charAt(i)==' '||i==temp.length()-1)
			{
				for(int j=t.length()-1;j>=0;j--)
				{
				strnew+=t.charAt(j);
				if(j==0&&i!=temp.length()-1)
				{
					strnew+=" ";
				}
				}
				t="";
			}
		}
		System.out.println(strnew);*/
		
		/*String str = "vivekasvikkiabssa";
		char[] c = str.toCharArray();
		int sum=0;
		for(int i=0;i<str.length();i++)
		{
			if(c[i]=='a'&&i<=str.length()-2)
			{
				if(c[i+1]=='s')
				{
					sum++;
				}
			}
		}
		System.out.println(sum);*/		
		/*File file = new File("C:\\Users\\p.nvs.vivek\\Desktop\\test.txt");
		List<String> listoflines = FileUtils.readLines(file);
		int sum =0;
		for(int i=0;i<listoflines.size();i++)
		{
			String str = listoflines.get(i);
			char c[] = str.toCharArray();
			for(int j=0;j<c.length;j++)
			{
				if(c[j]=='v'&&j<=c.length-2)
				{
					if(c[j+1]=='i')
					{
					sum++;
					}
				}
			}
		//	System.out.println("line "+(i+1)+" "+sum);
		}
		System.out.println(sum);*/
		
		/*WebDriver driver = Components.selectBrowser("chrome");
		driver.get("https://www.w3schools.com/sql/sql_orderby.asp");
		driver.manage().window().maximize();
		WebElement table = driver.findElement(By.cssSelector(".w3-table-all.notranslate"));
		List<WebElement> trow = table.findElements(By.tagName("tr"));
		for(int i=0;i<trow.size();i++)
		{
			List<WebElement> tds = trow.get(i).findElements(By.tagName("td"));
			{
				for(int j=0;j<tds.size();j++)
				{
					System.out.print(tds.get(j).getText());
				}
				System.out.println();
			}
		}*/	
		
		/*int[] a={10,5,9,2,1};
		int max=a[0];
		for(int i=0;i<a.length;i++)
		{
			if(max<a[i])
			{
				max=a[i];
			}
		}
		System.out.println(max);*/
		
		/*String newStr="";
		String str = "xyz(abc)123";
		for(int i=0;i<str.length();i++)
		{
		if(str.charAt(i)=='(')
		{
			for(int j=i;j<str.length();j++)
			{
				newStr+=str.charAt(j);
				if(str.charAt(j)==')')
				{
					break;
				}
			}
        }
		}
		System.out.println(newStr);*/		
		
		/*int[] a={1,2,3,4,4,5,5,5};
		for(int i=0;i<a.length;i++)
		{
			int count=0;
			for(int j=0;j<i;j++)
			{
				if(a[i]==a[j])
				{
				count++;
				}
			}
			if(count==0)
			{
				System.out.println(a[i]);
			}
		}*/
		
		/*int [][] a={{1,2,9},{4,5,6},{7,8,9}};
		System.out.println(a.length);
		int sum1=0,sum2=0;
			for(int j=0;j<a.length;j++)
			{
				sum1=sum1+a[j][j];
			}
			int k=a.length-1;
				for(int i=0;i<a.length;i++)
				{
					sum2=sum2+a[k][i];
					if(k>=0)
					{
						k--;
					}
				}
		System.out.println(sum1);
		System.out.println(sum2);*/
		int n=123;
		String num = String.valueOf(n);
		char[] a = num.toCharArray();
		permuteHelper(a,0);
				
		/*int[][] a ={{1,2,3},{3,2}};
		System.out.println(a.length);*/
		
		File file = new File("C:\\Users\\p.nvs.vivek\\Desktop\\test.txt");
		//System.out.println(FileUtils.readFileToString(file));
		List<String> lines = FileUtils.readLines(file);
		for(int i=0;i<lines.size();i++)
		{
			System.out.println();
		}
	}
	
	public static void permuteHelper(char[] a,int index)
	{
		if(index>=a.length-1 && index==a.length)
		{
			for(int i=0; i<a.length;i++)
			{
				System.out.print(a[i]);
			}
			System.out.println();
		}
		
		for(int i=index;i<a.length;i++)
		{
			char t=a[index];
			a[index]=a[i];
			a[i]=t;
			
			permuteHelper(a,index+1);
			
			t=a[index];
			a[index]=a[i];
			a[i]=t;		
		}		
	}
}
