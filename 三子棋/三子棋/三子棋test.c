#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<time.h>
#include "game.h"
void game()
{
	int ret = 0;
	char board[3][3] = { 0 };

	InitBoard(board, 3, 3);//二位数组初始化为空格

	printf("=============\n");

	ShowBoard(board, 3, 3);

	printf("=============\n");

	printf("游戏开始\n");


	while (1)//不知道是谁先赢，谁先赢，就跳出死循环
	{
		PlayerMove(board, 3, 3);//1.玩家下棋子2.看他是不是赢了
		ret = IsWin(board, 3, 3);//判断等于什么，若是'X'用户赢，若是'O'电脑赢
		if (ret != ' ')
		{
			break;//即有赢家了
		}
		ShowBoard(board, 3, 3);
		ComputerMove(board, 3, 3);//电脑移动
		ret = IsWin(board, 3, 3);
		if (ret != ' ')
		{
			break;//即有赢家了
		}
		ShowBoard(board, 3, 3);
	}//接下来就是判断是谁赢
	if (ret == 'X')
	{
		printf("玩家获胜，你真棒\n");
	}
	if (ret == 'O')
	{
		printf("电脑获胜\n");
	}
	if (ret == 'Q')
	{
		printf("平局\n");
	}
}
void menu()
{
	printf("请输入数字：\n1.play\n0.exit\n");
}
int main()
{
	srand((unsigned int)time(NULL));
	int input;
	do
	{
		menu();
		printf("请输入你的操作：");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("退出游戏");
			break;
		default:
			break;
		}
	} while (input);
	return 0;
}