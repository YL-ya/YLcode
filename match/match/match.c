#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
int main()
{
	int i;
	int a[] = { 1, 2, 3, 4, 3, 2, 6, 8, 4, 8, 6 };
	int len = sizeof(a) / sizeof(a[0]);
	for (i = 1; i < len; i++)
	{
		a[0] = a[0] ^ a[i];//自己异或自己等于0，0异或一个数等于那个数；就证明是成对出现的
		// c=a^b;d^c=d^(a^b)
	}
	printf("%d\n", a[0]);
	return 0;
}