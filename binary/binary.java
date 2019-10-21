import java.util.Scanner;
import java.util.Arrays;
//二叉树查找
public class binary{
	public static void main(String[] args){
		int[]array1={4,7,8,9,10,23,34,45,66};
		System.out.println(binarySort(array1,10,0,array1.length-1));
	}
	public static int binarySort(int[]a,int key,int left,int right)
	{
		if(left>right)
		{
			return -1;
		}
		//int mid=(left+right)/2
		int mid=(left+right)>>1;//无符号右移相当于除法
		if(a[mid]==key)
		{
			return mid;
		}
		if(a[mid]>key)
		{
			return binarySort(a, key,left++, right);
		}
		else{//即a[mid]<key
			return binarySort(a, key, left,right--);
		}
	}
}
		
		
			
			  
		
		
		