#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#if 0
//ˮ�ɻ�
int main()
{
	int i;
	for (i = 0; i <= 999999; i++)
	{
		int a = i;
		int count = 0;
		int sum = 0;
		while (a)//��Ҫдa!=0,��Ϊa������֮��a=0ʱ������Ϊ�٣���Ȼ������ѭ���������Լ򻯴���
		{
			count++;
			a=a/10;
		}//������Ǽ�λ��
		a= i;
		int  b;
		while (a)//����ͬ��Ŷ
		{
			b= pow((double)(a % 10),(double)count);
			sum += b;
			a=a/10;
		}
		if (sum==i)
		{
			printf("%d\n", i);//ע�����ﲻ��д��aŶ����Ȼ���Ϊ0����Ϊ����ѭ����a�Ľ������0
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
//��д������һ��1�� 100 �����������г��ֶ��ٸ�����9
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
	printf("һ����%d����\n", count);
	return 0;
}*/
//����1/1-1/2+1/3-1/4+1/5 ���� + 1/99 - 1/100 ��ֵ��
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
// ������A�е����ݺ�����B�е����ݽ��н���
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
	}//ʵ���������ֵ�ý���
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