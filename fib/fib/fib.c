#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#if 0
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
	for (i = 3; i <= n; i++)
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
#endif