#define _CRT_SECURE_NO_WARNINGS 1
#if 0
#include<stdio.h>
//����һ�����飬
//ʵ�ֺ���init������ʼ�����顢
//ʵ��empty����������顢
//ʵ��reverse���������������Ԫ�ص����á�
//Ҫ���Լ���ƺ����Ĳ���������ֵ��
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
	Init(&a);//��ʼ��
	empty(&a);//���
	int c[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	reverse(&c);//����
	return 0;
}
//ʵ��һ���������ж�һ�����ǲ�������
Isprime(int b)
{
	int i;
	for (i = 2; i <= b/2; i++)
	{
		if (b%i==0)
		{
			printf("%d��������\n",b);
			break;
		}
		else
		{
			printf("%d������\n",b);
			break;
		}
	}

}
int main()
{
	int a;
	printf("������һ����:\n");
	scanf("%d", &a);
	Isprime(a);
	return 0;
}
//ʵ��һ�������ж�year�ǲ�������
void IsLeapYear(int year)
{
	if (((year % 4) == 0) && ((year % 100) != 0) || ((year % 400) == 0))
	{
		printf("%d������\n", year);
	}
	else
	{
		printf("%d��������\n", year);
	}
}
int main()
{
	int a;
	printf("������������:\n");
	scanf("%d",&a);
	IsLeapYear(a);
	return 0;
}
//ʹ�ú���ʵ���������Ľ���
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
	printf("��������������\n");
	scanf("%d%d", &a, &b);
	Exchange(&a,&b);
	printf("%d,%d\n", a, b);
	return 0;
}
//ʵ��һ����������ӡ�˷��ھ����ھ���������������Լ�ָ����
//����9�����9*9�ھ�������12�����12*12�ĳ˷��ھ���
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
	printf("��������Ҫ��ʲô�˷��ھ���\n");
	scanf("%d", &a);
	Koujue(a);
	return 0;
}
#endif