#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int main()
{
	printf("请输入两个数：");
	int a, b;
	scanf("%d%d",&a,&b);
	if (a>b)
	{
		int c;
		while (a%b != 0)
		{
			c = a%b;
			a = b;
			b = c;
		}
		printf("%d\n",c);
	}
	if (a<b)
	{
		int c;
		while (b%a != 0)
		{
			 c = b%a;
			b = a;
			a = c;
		}
		printf("%d\n", a);
		}
	}