#define _CRT_SECURE_NO_WARNINGS 1
//2：确定凶手：
#include<stdio.h>
int main()
{
	int i;//设i是凶手
	for (i = 'A'; i <= 'D'; i++)//即有四种可能'A'-'D'=4
	{
		if ((i != 'A') + (i == 'C') + (i == 'D') + (i != 'D') == 3)
			printf("凶手是:%c\n", (char)i);
	}
	return 0;
}