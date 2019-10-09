import java.util.Scanner;
public class Change{
	public static void main(String[] args)
	{
		Scanner input=new Scanner (System.in);
		System.out.println("请输入两个数：");
			int a=input.nextInt();
			int b=input.nextInt();
			int temp;
			temp=a;
			a=b;
			b=temp;
			System.out.print(a+" "+b );
		// 或者以下输出也行：
		// System.out.print(a);
		// System.out.print(' ');
		// System.out.print(b);
	}
}
