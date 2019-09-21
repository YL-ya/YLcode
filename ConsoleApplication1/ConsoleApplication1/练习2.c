/*#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
//求两个数的最大公约数,余数为0的时候，除数就是最大公约数
int main()
{
	int a = 18;
	int b = 24;
	int c;
	while (b%a!=0)
	{
		c = b%a;
		b = a;
		a = c;
	}
	printf("两数的最大公约数是：%d\n",c);
	return 0;
}*/
//给定两个整形变量的值，将两个值的内容进行交换
/*include <stdio.h>
int main()
{
	int a, b, c;
	printf("随机输入两个整型的数：");
	scanf("%d %d", &a, &b);
	c = a; a = b; b = c;
	printf("%d,%d\n", a, b);
	return 0;
}
//不允许创建临时变量，交换两个数的内容
/*int main()
{
int a = 10;
int b = 20;
a = a + b;
b = a - b;
a = a - b;
printf("%d,%d\n", a, b);
return 0;
}*/
//将三个数按从大到小输出
/*int main()
{
	int a = 5;
	int b = 8;
	int c = 3;
	int tmp;
	if (a < b)
	{
		tmp = a;
		a = b;
		b = tmp;
	}
	if (a < c)
	{
		tmp = a;
		a = c;
		c = tmp;
	}
	if (b < c)
	{
		tmp = b;
		b = c;
		c = tmp;
	}
	printf("%d,%d,%d", a, b, c);	
	return 0;
}*/

/*
//求10 个整数中最大值
int main()
{
	int i, j;
	int a[10];
	int max = 0;
	for (i = 0; i < 10; i++)
	{
		scanf("%d", &a[i]);
	}
	max = a[0];
	for (j = 1; j < 10; j++)
	{
		if (max < a[j])
			max = a[j];
	}
	printf("最大数为:%d\n",max);
	return 0;
}
//求10 个整数中最大值。
#include <stdio.h>
int main()
{
	int a[10];
	int i;
	int max = 0;
	printf("随机输入十个数：\n");
	for (i = 0; i < 10; i++)
	{
		scanf_s("%d", &a[i]);
		if (max < a[i])
		{
			max = a[i];
		}

	printf("最大的数为：%d\n", max);
	return 0;
}
*/
	


//将三个数按从大到小输出。
/*#include <stdio.h>
int main()
{
	int a[3];
	int max1=0;
	int i,j,k;
	printf("随机输入3个数：\n");
	for (i = 0; i < 3; i++){
		for (j = 0; j<3 - i; j++){
			scanf_s("%d", &a[i]);
			if (a[i + 1]>a[i])
				max1 = a[i + 1];
			a[i + 1] = a[i];
			a[i] = max1;
		}
	}
	for (k = 0; k < 3; k++)
		printf("%d\n", a[k]);
	return 0;
}*/