#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int Forecast(int arr[])//�ж�Ԥ����  
{
	if ((arr[1] == 2) + (arr[0] == 3) == 1
		&& (arr[1] == 2) + (arr[4] == 4) == 1
		&& (arr[2] == 1) + (arr[3] == 2) == 1
		&& (arr[2] == 5) + (arr[3] == 3) == 1
		&& (arr[4] == 4) + (arr[0] == 1) == 1)
		return 1;
	else
		return 0;
}
int Repet(int arr[])//�ж������ڵ�ֵ�Ƿ����ظ���  
{
	int i = 0;
	int j = 0;
	for (i = 0; i < 5; i++)
	for (j = i + 1; j < 5; j++)
	{
		if (arr[i] == arr[j])
			return 0;
	}
	return 1;
}
int main()
{
	int arr[5] = { 0 };
	//����arr[0]~arr[4]�ֱ����A B C D E  
	//arr[i]��ֵ��ʾ������  
	for (arr[0] = 1; arr[0] <= 5; arr[0]++)
	{
		for (arr[1] = 1; arr[1] <= 5; arr[1]++)
		{
			for (arr[2] = 1; arr[2] <= 5; arr[2]++)
			{
				for (arr[3] = 1; arr[3] <= 5; arr[3]++)
				{
					for (arr[4] = 1; arr[4] <= 5; arr[4]++)
					{
						if (Forecast(arr) == 1)
						{
							if (Repet(arr) != 0)
							{
								printf("A:Ϊ��%d�� B:Ϊ��%d�� C:Ϊ��%d�� D:Ϊ��%d�� E:Ϊ��%d��\n", arr[0], arr[1], arr[2], arr[3], arr[4]);
							}
						}
					}
				}
			}
		}
	}
	return 0;
}