#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#define N 10//随时修改二维数组的大小
int main()
{
	int i = 0; 
	int j = 0;
	int a[N][N] = {0};
	printf("打印杨辉三角:\n");
	for (i = 0; i < N; i++)
	{
		a[i][0] = 1;
		a[i][i] = 1;//先把两边都是1打印了
	}
	for (i = 2; i < N; i++)
	{
		for (j = 1; j< N; j++)
		{
			a[i][j] = a[i - 1][j - 1] + a[i - 1][j];//该位置的值等于上一行同列和上一行列减一的值相加值
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