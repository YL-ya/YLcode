#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//写代码可以在整型有序数组中查找想要的数字，
//找到了返回下标，找不到返回-1.（折半查找）
int BinarySeach(int arr[], int len, int n)
{
	int left = 0;
	int right = len - 1;
	while (left <= right)
	{
		int mid = (left + right) / 2;
		if (n <arr[mid])
		{
			right = mid - 1;
		}
		else if (n>arr[mid])
		{
			left = mid + 1;
		}
		else
		{
			return mid;
		}
	}
	return -1;
}
int main()
{
	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int a;
	printf("请输入你想查询的数：");
	scanf("%d",&a);
	int len = strlen(arr);
	int b = BinarySeach(arr, 10, a);
	if (b == -1)
	{
		printf("没有找到");
	}
	else
	{
		printf("找到数的下标为：%d\n", b);
	}
	return 0;
}