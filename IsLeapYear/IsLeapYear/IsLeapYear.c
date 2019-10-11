#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
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
	scanf("%d", &a);
	IsLeapYear(a);
	return 0;
}