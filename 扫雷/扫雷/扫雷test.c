#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include"game.h"
#include<time.h>
void game()//两个数组：一个数组存放雷，一个数组给用户看
{
	char minelnfo[ROWS][COLS];//存放11*11存放雷的信息
	char mine[ROWS][COLS];//存放雷的

	InitBoard(minelnfo,ROWS,COLS,'*');//用户界面

	InitBoard(mine,ROWS,COLS,'0');//'0'字符零，证明里面没有任何的雷//初始化棋盘

	ShowBoard(minelnfo, ROWS, COLS);

	SetMine(mine, ROW, COL);

	//ShowBoard(mine, ROWS, COLS);

	FindMine(minelnfo, mine, ROW, COL);
}
void menu()
{
	printf("请输入数字：\n1.play\n0.exit\n");
}
int main()
{
	//srand((unsigned int)time(NULL));
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