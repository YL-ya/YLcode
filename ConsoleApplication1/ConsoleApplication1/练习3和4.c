#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#if 0
//水仙花
int main()
{
	int i;
	for (i = 0; i <= 999999; i++)
	{
		int a = i;
		int count = 0;
		int sum = 0;
		while (a)//不要写a!=0,因为a除尽了之后a=0时括号中为假，自然就跳出循环；即可以简化代码
		{
			count++;
			a=a/10;
		}//计算出是几位数
		a= i;
		int  b;
		while (a)//理由同上哦
		{
			b= pow((double)(a % 10),(double)count);
			sum += b;
			a=a/10;
		}
		if (sum==i)
		{
			printf("%d\n", i);//注意这里不能写成a哦，不然结果为0，因为跳出循环后a的结果就是0
		}
	}
	return 0;
} 
#endif
/*
//2+22+222+2222+22222
int main()
{
	int a = 2;
	int c = 2;
	int d=0;
	int i, n;
	scanf("%d", &n);
	for (i = 1; i <= n; i++)
	{
		c += d;
		double b = pow(10,i);
		d = d + 2 * b+2;
	}
	printf("2+22+222+....=%d\n",c );
	return 0;
}*/
//编写程序数一下1到 100 的所有整数中出现多少个数字9
/*int main()
{
	int i=1;
	int count=0;
	for (i = 1; i <= 100;i++)
	{		
		if (i%10==9||i/10==9)
		{
			count++;
			printf("%d\t", i);
		}
	}
	printf("\n");
	printf("一共有%d个数\n", count);
	return 0;
}*/
//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值。
/*int main()
{
	double i;
	double sum=0;	
	double j = 1;
	for (i = 1; i <= 3; i++)
	{	
		sum += (j/ i);	
	}
	printf("%f\n", sum);
	return 0;
}*/
// 将数组A中的内容和数组B中的内容进行交换
/*#include<string.h>
int main()
{
	int a[8] = { 1, 2, 3, 4, 5, 6, 7, 8 };
	int b[8] = { 8, 7, 6, 5, 4, 3, 2, 1 };
	int temp,i;
	for (i = 0; i < 8; i++)
	{
	
		temp = a[i];
		a[i] = b[i];
		b[i] = temp;
	}//实现数组里的值得交换
	for (int i= 0; i < 8; i++)
	{
		printf("%d\t", a[i]);
	}
		printf("\n");
	for (int i = 0; i< 8; i++)
	{
		printf("%d\t", b[i]);
	}
	return 0;
}*/