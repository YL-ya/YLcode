#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
//完成猜数字游戏
void Data()
{
	int a = 0;
	srand((unsigned)time(NULL));//设置随机种子
	a = rand() % 100 + 1;
	while (1)
	{
		printf("输入你猜的数：\n");
		int b;
		scanf("%d", &b);
		if (a > b)
		{
			printf("你猜小了,再猜\n");
		}
		if (a < b)
		{
			printf("你猜大了，再猜\n");
		}
		if (a == b)
		{
			printf("你猜对了\n");
			break;
		}
	}
}
int main()
{
	printf("请输入数字：\n1.play\n0.exit\n");
	int a;
	scanf("%d", &a);
	switch (a)
	{
	case 1:
		Data();
		break;
	case 0:
		printf("退出游戏成功\n");
	}
	return 0;
}