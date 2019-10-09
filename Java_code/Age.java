import java.util.Scanner;
public class Age{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.println("请输入年龄：");
		int Age=input.nextInt();
		if(Age<=18)
		{
			System.out.println(Age+"是少年");
		}
		if(Age>=19&&Age<=28)
		{
			System.out.println(Age+"是青年");
		}
		if(Age>=29&&Age<=55)
		{
			System.out.println(Age+"是中年");
		}
		if(Age>=56)
		{
			System.out.println(Age+"是老年");
		}
	}
}