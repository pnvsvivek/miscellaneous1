package checkerswithmain;

import java.util.LinkedHashMap;

public class OracleTest {

	public static void main(String args[])
	{
		String str = "viveki";
		LinkedHashMap<Character, Integer> lhm = new LinkedHashMap<Character, Integer>();
		for(int i=0;i<str.length();i++)
		{
			if(lhm.containsKey(str.charAt(i)))
			{
				lhm.put(str.charAt(i), lhm.get(str.charAt(i))+1);
			}
			else
			{
				lhm.put(str.charAt(i), 1);
			}
		}
		System.out.println(lhm);
	}
}
