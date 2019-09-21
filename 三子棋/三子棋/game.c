#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void InitBoard(char board[][COL], int row, int col)
{
	//memset(board,' ',row*col*sizeof(char));头文件为#include<string.h>将字符数组里面全部初始化为空格
	int i, j;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			board[i][j] = ' ';
		}
	}
}
void ShowBoard(char board[][COL], int row, int col)
{
	int i, j;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			printf(" %c ", board[i][j]);//三个空格
			if (j < col - 1)
			{
				printf("|");//只有两个竖线
			}
		}
		printf("\n");
		if (i < 2)//两行---|---|---|
		{
			for (j = 0; j < col; j++)
			{
				printf("---");
				if (j < col - 1)
				{
					printf("|");
				}
			}
			printf("\n");
		}
	}
}
void PlayerMove(char board[][COL], int row, int col)
{
	int x = 0;
	int y = 0;
	while (1)
	{
		printf("玩家移动：\n");
		printf("请输入1-3的坐标：");
		scanf("%d%d", &x, &y);//用户坐标减一即是数组坐标的真正位置
		if (x >= 1 && y <= 3)//坐标是合法的接下来就是判断该数组内容是否被下过棋子
		{
			if (board[x - 1][y - 1] == ' ')//当前位置没有被下棋子
			{
				board[x - 1][y - 1] = 'X';
				break;
			}
			else
			{
				printf("该位置已经下过棋子");
			}
		}
		else
		{
			printf("坐标不合法\n");
		}
	}
}
static int IsFull(char board[][COL], int row, int col)//static表明该函数只在该game.c文件下调用
{
	int i, j;
	for (i = 0; i < row; i++)
	{
		for (j = 0; j < col; j++)
		{
			if (board[i][j] == ' ')//
			{
				return 0;
			}
		}
	}
	return 1;
}

int IsWin(char board[][COL], int row, int col)//判断谁赢；并且赢没赢给个返回值
{
	int i;
	for (i = 0; i < row; i++)//观察三子棋的位置，若可以连在一起就说明赢了
	{
		if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')//行胜出“XXX”(3行)
		{
			return board[i][0];
		}
		if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')//列胜出
		{
			return board[0][i];
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')//对角线'\'
		{
			return board[0][0];
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')//对角线'/'
		{
			return board[0][2];
		}
		if (IsFull(board, row, col) == 1)//棋盘放满了，即是平局
		{
			return 'Q';//表示平局
		}
	}
	return ' ';//代表的事没有平局也没有赢家，即用户刚走了一步，接下来该电脑走
}
void ComputerMove(char board[][COL], int row, int col)
{
	printf("电脑移动:\n");
	int x = 0;
	int y = 0;
	while (1)
	{
		x = rand() % row;
		y = rand() % col;//获得0~2的随机数
		if (board[x][y] == ' ')
		{
			board[x][y] = 'O';
			break;
		}
	}
}

