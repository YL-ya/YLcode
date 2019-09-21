#define _CRT_SECURE_NO_WARNINGS 1
#if 0
#include<stdio.h>
//创建一个数组，
//实现函数init（）初始化数组、
//实现empty（）清空数组、
//实现reverse（）函数完成数组元素的逆置。
//要求：自己设计函数的参数，返回值。
void Init(int *b)
{
	int i;
	for (i = 0; i < 10; i++)
	{
		b[i] = 2;
		printf("%d\t", b[i]);
	}
}
void empty(int *c)
{
	int j;
	for (j = 0; j < 10; j++)
	{
		c[j] = 0;
		printf("%d\t", c[j]);
	}
}
void reverse(int *d)
{
	int b[10] = { 0 };
	int temp;
	int k;
	for (k = 0; k < 10; k++)
	{
		b[k] = d[9 - k];
		printf("%d\t", b[k]);
	}
}
int main()
{
	int a[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	Init(&a);//初始化
	empty(&a);//清空
	int c[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	reverse(&c);//逆置
	return 0;
}
//实现一个函数，判断一个数是不是素数
Isprime(int b)
{
	int i;
	for (i = 2; i <= b/2; i++)
	{
		if (b%i==0)
		{
			printf("%d不是素数\n",b);
			break;
		}
		else
		{
			printf("%d是素数\n",b);
			break;
		}
	}

}
int main()
{
	int a;
	printf("请输入一个数:\n");
	scanf("%d", &a);
	Isprime(a);
	return 0;
}
//实现一个函数判断year是不是润年
void IsLeapYear(int year)
{
	if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0))
	{
		printf("%d是闰年\n", year);
	}
	else
	{
		printf("%d不是闰年\n", year);
	}
}
int main()
{
	int a;
	printf("请输入你的年份:\n");
	scanf("%d",&a);
	IsLeapYear(a);
	return 0;
}
//使用函数实现两个数的交换
Exchange(int *pa, int *pb)
{
	int temp = 0;
	temp = *pa;
	*pa = *pb;
	*pb = temp;
}
int main()
{
	int a, b;
	printf("请输入两个数：\n");
	scanf("%d%d", &a, &b);
	Exchange(&a,&b);
	printf("%d,%d\n", a, b);
	return 0;
}
//实现一个函数，打印乘法口诀表，口诀表的行数和列数自己指定，
//输入9，输出9*9口诀表，输入12，输出12*12的乘法口诀表。
void Koujue(int n)
{
	int i,j;
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= i; j++)
		{
			printf("%d*%d=%-2d\t", i, j, i*j);
		}
		printf("\n");
	}
}
int main()
{
	int a;
	printf("请输入你要打什么乘法口诀表：\n");
	scanf("%d", &a);
	Koujue(a);
	return 0;
}
#endif