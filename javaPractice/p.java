import java.util.Scanner;
public class p{
	public static void main(String[] args){
		int[]a={1,2,3,4,5,6};
		System.out.println(toString(a));
	}
		public static String toString(int[] array)
	{
		String str="[";
		for(int i=0;i<array.length;i++)
		{
			str+=array[i];//字符串加整型还是字符串类型
			if(i!=array.length-1)
			{
				str+=",";
			}
		}
		str+="]";
		return str;
		
	}
}
		// int[]ret=fac(a);
		// for(int i=0;i<ret.length;i++)
		// {	
			// System.out.print(ret[i]+" ");
		// }
	// }
//1 写一个方法让它数组里面的值*2
	// public static int[] fac(int[]b)
	// {
		// for(int i=0;i<b.length;i++)
		// {
			// b[i]=b[i]*2;
		// }
		// return b;
	// }
// }

//2 public static int[] fac(int[]a)
	// {
		// int []temp=new int[a.lenght]
		// for(int i=0;i<b.length;i++)
		// {
			// b[i]=b[i]*2;
		// }
		// return b;
	// }
	//自己写一个完成toString()方法
