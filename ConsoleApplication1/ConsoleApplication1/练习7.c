#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#if 0
//递归方式实现打印一个整数的每一位
void Printint(int n)
{
	if (n/ 10 == 0)
	{
		printf("%d", n);
	}
	else
	{
		Printint(n/ 10);
		printf("%d", n % 10);
	}
}
int main()
{
	Printint(1234);
	return 0;
}
//递归和非递归分别实现求n的阶乘
jiecheng(int n)
{
	if (n == 1)
	{
		return 1;
	}
	else
	{
		return n*jiecheng(n - 1);
	}

}
int main()
{
	int a;
	printf("你想要得到几的阶乘：");
	scanf("%d", &a);
	int b=jiecheng(a);
	printf("%d\n", b);
	return 0;
}

//编写一个函数 reverse_string(char * string)（递归实现）
//实现：将参数字符串中的字符反向排列。
//要求：不能使用C函数库中的字符串操作函数。

void reverse_string(char * string)
{
	if (*string == '\0')
	{
		return 0;
	}
	else
	{
		string++;
		reverse_string(string);
		printf("%c", *(string - 1));
	}
}
int main()
{
	char*string = "hello";
	reverse_string(string);
	return 0;
}


//写一个递归函数DigitSum(n)，输入一个非负整数，返回组成它的数字之和，
//例如，调用DigitSum(1729)，则应该返回1+7+2+9，它的和是19
int DigitSum(int n)
{
	if (n / 10 == 0)
	{
		return n % 10;
	}
	else
	{
			return (n % 10) + DigitSum(n / 10);
	}
}
int main()
{
	int a=DigitSum(1729);
	printf("%d\n", a);
	return 0;
}

//编写一个函数实现n^k，使用递归实现
int Cifang(int n,int k)
{
	if (k == 0)
	{
		return 0;
	}
	else if (k == 1)
	{
		return n;
	}
	else
	{
		return n* Cifang(n, (k - 1));
	}
}
int main()
{
	int n=3;
	int k=3;
	int result=Cifang(n,k);
	printf("%d\n", result);
	return 0;
}
//递归和非递归分别实现求第n个斐波那契数
//递归
int fib(int n)
{
	if (n == 1 || n == 2)
	{
		return 1;
	}
	else
	{
		return fib(n - 1) + fib(n - 2);
	}
}
int main()
{
	int n;
	printf("你要得到第几个斐波那契数字:");
	scanf("%d", &n);
	int d = fib(n);
	printf("%d\n", d);
	return 0;
}

//非递归
int fib(int n)
{
	int a = 1;
	int b = 1;
	int c = 0;
	int i = 0;
	for (i = 3; i <= 40; i++)
	{
		c = a + b;
		a = b;
		b = c;

	}
	return c;
}
int main()
{
	int n;
	printf("你要得到第几个斐波那契数字:");
	scanf("%d", &n);
	int d = fib(n);
	printf("%d\n", d);
	return 0;
}



//递归和非递归分别实现strlen
//递归：
int Mystrlen(char *p)//p是指针变量存放的是首位字符的地址
{
	int count=0;
	if (*p == '\0')//*p表示间接访问，若字符串地址里的内容是'\0'即表示字符串长度为0
	{
		return 0;
	}
	else//若字符串地址里的内容不是'\0',则最少返回1，即字符串中有一个字符
	{
		return 1 + Mystrlen(p + 1);
	}
	
}
int main()
{
	char *str = "hello";
	int len = Mystrlen(str);
	printf("%d\n", len);
	return 0;
}
#endif
