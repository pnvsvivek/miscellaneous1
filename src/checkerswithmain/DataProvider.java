package checkerswithmain;

import java.util.Arrays;
import java.util.Random;

public class DataProvider {

	public static void main(String[] args) {
		
		int rowNum = 3;
		int colNum = 2;
		int c=25;
		int b=40;
		int[] array={rowNum,colNum,c,b};
		int[][] array2=new int[colNum][rowNum];
		Random r = new Random();
		
		for(int i=0;i<array[0];i++)
		{
			for(int j=0;j<array[1];j++)
			{
				array2[j][i]= r.nextInt(array[3]-array[2])+array[2];
			}
		}
		for(int i=0;i<array[0];i++)
		{
			for(int j=0;j<array[1];j++)
			{
				System.out.print(array2[j][i]+" ");
			}
			System.out.println();
		}
		Arrays.sort(array2[0]);
		Arrays.sort(array2[1]);
		
		System.out.println(array2[0][2]);
		System.out.println(array2[1][2]);
	}
}
