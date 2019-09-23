#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>  
//汉诺塔
void Move(char pos1, char pos2)
{
	printf("%c→%c\t", pos1, pos2);
}
void hanio(int n, char pos1, char pos2, char pos3)
{
	if (n == 1)
	{
		Move(pos1, pos3);
	}
	else
	{
		hanio(n - 1, pos1, pos3, pos2);
		Move(pos1, pos3);
		hanio(n - 1, pos2, pos1, pos3);
	}
}
int main()
{
	int n;
	printf("输入有多少个盘子:");
	scanf("%d", &n);
	hanio(n, 'A', 'B', 'C');
	printf("\n");
	return 0;
}