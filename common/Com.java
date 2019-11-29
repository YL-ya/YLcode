import java.util.Scanner;
public class Com{
	public static void main(String[] args)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("请输入两个数：");
		int a=input.nextInt();
		int b=input.nextInt();
		if(a>b)
		{
			while(a%b!=0)
					{
					int	c=a%b;
						a=b;
						b=c;
					}
				System.out.println(b);
		}
		if(a<b)
		 {
			while(b%a!=0)
				{
				int c=b%a;
					 b=a;
					 a=c;
				}
		System.out.println(a);
		}
	}
}