#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
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