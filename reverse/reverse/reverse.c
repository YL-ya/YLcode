#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>  
#include<math.h>
#include <stdlib.h> 
unsigned int reverse_bit(unsigned int a)
{
	printf("��ת��Ķ�����:\n");
	int i;
	int b[32];
	for (i = 0; i <32; i++)
	{
		b[i] = a % 2;
		a = a / 2;//�Ѿ���ת
	}
	for (i = 0; i < 32; i++)
	{
		printf("%d ", b[i]);
	}
	printf("\n");
	unsigned int sum = 0;
	for (i = 0; i < 32; i++)
	{
		sum = sum + b[i] * pow(2, 31 - i);
	}
	return sum;
}
int main()
{
	int value;
	printf("������һ������");
	scanf("%d",&value);
	unsigned int b;
	b = reverse_bit(value);
	printf("��ת���ֵΪ:\n");
	printf("%u", b);//��ӡ�޷�������%u
	return 0;
}