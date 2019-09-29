#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#if 0
void Isprime(int n)
{
	int i, j;
	for (i = 2; i <= n; i++)//产生了2~n个的数字
	{
		for (j = 2; j <= sqrt((double)i); j++)//若i是素数，在2~(i/2)中i对任何数取余都不等于0
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
	int i, j;
	int count = 0;
	for (i = 2; i <= n; i++)//产生了2~n个的数字，若i是素数，那它一定不是偶数即i+2
	{
		for (j = 2; j <= sqrt((double)i); j++)//若i是素数，在2~(i/2)中i对任何数取余都不等于0
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
#endif