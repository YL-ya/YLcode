#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#define N 10//��ʱ�޸Ķ�ά����Ĵ�С
int main()
{
	int i = 0; 
	int j = 0;
	int a[N][N] = {0};
	printf("��ӡ�������:\n");
	for (i = 0; i < N; i++)
	{
		a[i][0] = 1;
		a[i][i] = 1;//�Ȱ����߶���1��ӡ��
	}
	for (i = 2; i < N; i++)
	{
		for (j = 1; j< N; j++)
		{
			a[i][j] = a[i - 1][j - 1] + a[i - 1][j];//��λ�õ�ֵ������һ��ͬ�к���һ���м�һ��ֵ���ֵ
		}
	}
	for (i = 0; i < N; i++)
	{
		for (j= 0; j <= i;j++)
		{
			printf("%d ",a[i][j]);//
		}
		printf("\n");
	}
	return 0;
}