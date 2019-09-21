#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#if 0
//汉诺塔
void Move(char pos1, char pos2)
{
	printf("%c→%c\t",pos1,pos2);
}
void hanio(int n,char pos1,char pos2,char pos3)
{
	if (n == 1)
	{
		Move(pos1, pos3);
	}
	else
	{
		hanio(n - 1, pos1, pos3, pos2);
		Move(pos1, pos3);
		hanio(n - 1, pos2, pos1, pos3);
	}
}

int main()
{
	hanio(4, 'A', 'B', 'C');
	printf("\n");
	return 0;
}

void Isprime(int n)
{
	int i,j;
	for (i = 2; i <= n; i++)//产生了2~n个的数字
	{
		for (j = 2; j <=sqrt((double)i); j++)//若i是素数，在2~(i/2)中i对任何数取余都不等于0
		{
			if (i%j == 0)
			{
				break;//表示i不是素数就没必要在往下取余了，直接跳出该循环,i++,进行下一个数的判断就好了
			}
		}
		if (j>sqrt((double)i))
		{
			printf("%d\t", i);
		}
	}
}
int main()
{
	int a = 0;
	printf("请输入你要打印到多少的素数:");
	scanf("%d", &a);
	Isprime(a);
	printf("\n");
	return 0;
}

void Isprime(int n)
{
	int i,j;
	int count = 0;
	for (i = 2; i <= n; i++)//产生了2~n个的数字，若i是素数，那它一定不是偶数即i+2
	{
		for (j = 2; j <=sqrt((double)i); j++)//若i是素数，在2~(i/2)中i对任何数取余都不等于0
		{
			if (i%j == 0)
			{
				break;//表示i不是素数就没必要在往下取余了，直接跳出该循环,i++,进行下一个数的判断就好了
			}
		}
		if (j>sqrt((double)i))
		{
			printf("%d\t", i);
			count++;
		}
	}
}
int main()
{
	int a = 0;
	printf("请输入你要打印到多少的素数:");
	scanf("%d", &a);
	Isprime(a);
	printf("\n");
	return 0;
}

int main()
{
	int a = 50;
	int b = 70;
	int temp = 0;
	printf("交换前的值为%d,%d\n", a, b);
	temp = a;
	a = b;
	b = temp;
	printf("交换后的值为%d,%d\n", a, b);
	return 0;
}

int main()
{
	int a = 10;
	int b = 20;
	printf("交换前的值为%d,%d\n", a, b);
	a = a^b;
	b = a^b;
	a = a^b;
	printf("交换后的值为%d,%d\n", a, b);
	return 0;
}

int main()
{
	int a = 20;
	int b = 30;
	printf("交换前的值为%d,%d\n", a, b);
	a = a + b;
	b = a - b;
	a = a - b;
	printf("交换后的值为%d,%d\n", a, b);
	return 0;
}

int main()
{
	int i,temp;
	for (i = 0; i < 999999; i++)
	{
		int count = 0;
		int sum = 0;
		temp = i;
		while (temp != 0)
		{
			count++;
			temp=temp / 10;
		}//计算出是几位数

	}
	return 0;
}

int main()
{
	int i = 0, j = 0;
	for (i = 0; i <= 100; i++)
	{
		for (j = 2; j <= i; j++)
		{
			if (i == j)
			{
				printf("%d是素数\n");
			}
			if (i%j == 0)
			{
				break;
			}
		}
		
	}
	return 0;
}

int main()
{
	int line = 0;
	 (line < 100)
	{
		printf("我要写代码\t");
		line++;
	}
	printf("写完了\n");
	return 0;
}

int main()
{
	int a=0;
	printf("如果你想拿到好的offer,请输入1：\n");
	scanf("%d", &a);
	if (a == 1)
	{
		printf("你要好好学习\n");
	}
	else
	{
		printf("毕业就等于失业，请你加油");
	}
	return 0;
}
#endif