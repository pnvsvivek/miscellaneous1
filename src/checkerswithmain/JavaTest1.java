package checkerswithmain;

import java.util.LinkedHashSet;
import java.util.Set;

public class JavaTest1 {
	
	public void run(int x)
	{
		System.out.println(x);		
	}
	
	public static void main(String args[])
	{
		Set<String> set = new LinkedHashSet<String>();
		String str = "oracle is a is a company is a company oracle oracle yummy yummy";
		System.out.println("print"+str.charAt(str.length()));
		String temp="";
		for(int i=0;i<str.length();i++)
		{
			temp+=str.charAt(i);
			if(str.charAt(i)==' '||i==str.length())
			{
				set.add(temp);
				temp="";
			}
		}
		for(String i:set)
		{
			System.out.print(i+" ");
		}
	}
}
