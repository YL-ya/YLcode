#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
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
	scanf("%d", &a);
	IsLeapYear(a);
	return 0;
}