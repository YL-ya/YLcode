import java.util.Scanner;
import java.util.Arrays;
public class array{
	public static void main(String[] args){
		int[]array1={5,4 ,7 ,27 ,45 ,36 ,31};
		System.out.println("数组中的最大值是："+fac1(array1));
		System.out.println("数组中的最小值是："+fac2(array1));
		System.out.println("数组的平均值是："+fac3(array1));
		fac4(array1);
		fac5(array1);
	}
	//数组中的最大值
	public static int fac1(int[]a)
	{
		int max=a[0];
		for(int i=1;i<a.length;i++)
		{
			if(a[i]>max)
			{
				max=a[i];
			}
		}
		return max;
	}
	//数组中的最小值
	public static int fac2(int[]a)
	{
		 int min=a[0];
		 for(int i=1;i<a.length;i++)
		{
			if(a[i]<min)
			{
				min=a[i];
			}
		}
		return min;
	}
	//数组的平均值：
	public static double fac3(int[]a)
	{
		double sum=0;
		 for(int i=1;i<a.length;i++)
		{
			sum+=a[i];
		}
		double avg=sum/(a.length);
		return avg;
	}
	//数组的逆置
	public static void fac4(int[]a)
	{
		int left=0;
		int right=a.length-1;
		int temp;
		System.out.println("逆置前的数组为：");
		System.out.print(Arrays.toString(a));
		// for(int i=0;i<a.length;i++)
		// {
			// System.out.print(a[i]+" ");
		// }
		System.out.println();
		while(left<=right)
		{
			temp=a[left];
			a[left]=a[right];
			a[right]=temp;
			left++;
			right--;
		}
		System.out.println("逆置后的数组为：");
		System.out.println(Arrays.toString(a));
		// for(int i=0;i<a.length;i++)
		// {
			// System.out.print(a[i]+" ");
		// }
	}
	//将数组中的奇数放在偶数前面
	public static void fac5(int[]a)
	{
		 int left=0;
		int right=a.length-1;
		 int temp;
		 while(left<=right)
		 {
			 if(a[left]%2==0)
			 {
				temp=a[left];
				a[left]=a[right];
				a[right]=temp;
				right--;
			 }
			 else
			 {
				 left++;
			 }
				 
		 }
		 System.out.println("奇数在前偶数在后：");
		 System.out.println(Arrays.toString(a));
	}
}
			 

