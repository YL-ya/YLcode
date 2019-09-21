#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#if 0
//完成猜数字游戏
void Data()
{
	int a = 0;
	srand((unsigned)time(NULL));
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
//编写一个程序，可以一直接收键盘字符，
//如果是小写字符就输出对应的大写字符，
//如果接收的是大写字符，就输出对应的小写字符，
//如果是数字不输出。
//123ABCD45efG ==> abcdEFg
#include<string.h>
int main()
{
	int letter = 0;
	printf("请键盘输入");
	letter=getchar();
	if (letter >= 'a'&&letter <= 'z')
	{
		letter = letter - 32;
		putchar(letter);
	}
	if (letter >= 'A'&&letter <= 'Z')
	{
		letter = letter + 32;
		putchar(letter);
	}
	if (letter>=0&&letter<=9)
	{
	}
	printf("\n");
	system("pause");
	return 0;
}
//编写代码模拟三次密码输入的场景。
//最多能输入三次密码，密码正确，提示“登录成功”,密码错误，
//可以重新输入，最多输入三次。三次均错，则提示退出程序。
int main()
{
	char password[10];
	int count = 3;
	while (count > 0)
	{
		printf("请输入你的密码：");
		scanf("%s", password);
		if (strcmp(password, "12345678") == 0)
		{
			printf("登陆成功\n");
			break;
		}
		else
		{
			count--;
			printf("密码错误！ 您还有%d次机会\n", count);
		}
	}
	return 0;
}
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
	int a = 6;
	int len = strlen(arr);
	int b= BinarySeach(arr,10,a);
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
#endif
	
