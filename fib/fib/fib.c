#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#if 0
//�ݹ�ͷǵݹ�ֱ�ʵ�����n��쳲�������
//�ݹ�
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
	printf("��Ҫ�õ��ڼ���쳲���������:");
	scanf("%d", &n);
	int d = fib(n);
	printf("%d\n", d);
	return 0;
}

//�ǵݹ�
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
	printf("��Ҫ�õ��ڼ���쳲���������:");
	scanf("%d", &n);
	int d = fib(n);
	printf("%d\n", d);
	return 0;
}
#endif