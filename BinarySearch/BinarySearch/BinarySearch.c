#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//д����������������������в�����Ҫ�����֣�
//�ҵ��˷����±꣬�Ҳ�������-1.���۰���ң�
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
	printf("�����������ѯ������");
	scanf("%d",&a);
	int len = strlen(arr);
	int b = BinarySeach(arr, 10, a);
	if (b == -1)
	{
		printf("û���ҵ�");
	}
	else
	{
		printf("�ҵ������±�Ϊ��%d\n", b);
	}
	return 0;
}