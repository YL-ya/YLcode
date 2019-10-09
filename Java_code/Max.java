import java.util.Scanner;
public class Max{
	public static void main(String[] args){
	System.out.println("随意输入三个数：");
	Scanner input=new Scanner (System.in);
	int a=input.nextInt();
	int b=input.nextInt();
	int c=input.nextInt();
	int max;
	int min;
	if(a>b){
		max=a;
		min=b;
	}else{
		max=b;
		min=a;
	}
	if(max>c){
		System.out.println("最大值为："+max);
	}else{
		System.out.println("最大值为： "+c);
	}
	if(min<c){
		System.out.println("最小值为: "+min);
	}else{
		System.out.println("最小值为："+c);
	}
  }
}