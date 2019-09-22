#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void InitBoard(char board[ROW + 2][COL + 2], int rows, int cols,char set)
{
	int i, j;
	for (i = 0; i < rows; i++)
	{
		for (j = 0; j < cols; j++)
		{
			board[i][j] = set;
		}
	}
}
void ShowBoard(char board[][COLS], int rows, int cols)
{
	int i, j;
	printf("===================\n");
	for (i = 0; i <rows-1; i++)//i<10,即0~9
	{
		printf("%d ",i);
	}
	printf("\n");
	for (i = 1; i < rows-1; i++)//棋盘的第十行，即棋盘的最后一行
	{
		printf("%d ", i);
		for (j = 1; j < cols - 1; j++)//零列放了标号了
		{
			printf("%c ",board[i][j]);
		}
		printf("\n");//这两层for循环只打印了内部的棋盘，外面包裹的那层并没有打印
	}
	printf("===================\n");
}
//排雷之前得给棋盘设置雷，所以先设置雷
void SetMine(char mine[][COLS], int row, int col)//9*9
{
	int count = MINENUM;
	int x = 0; int y = 0;
	while (count != 0)
	{
		x = rand() % row + 1;//[0,9)[1,10)
		y = rand() % col + 1;//产生1~9的随机坐标
		if (mine[x][y] == '0')//设置零的时候不能重复设置同一个位置
		{
			mine[x][y] = '1';//即已经设置一个雷了
			count--;//即设置十个雷之后就退出循环，即十个雷这只完毕
		}
	}
}
static int GetMine(char mine[][COLS],int x,int y)//找x,y坐标旁边有多少雷，在mine数组里找
{
	//字符-字符=数字
	//即'1'-'0'=1
	return  mine[x - 1][y - 1] - '0' +
			mine[x - 1][y] - '0' +
			mine[x - 1][y - 1] - '0' +
			mine[x][y + 1] - '0' +
			mine[x + 1][y + 1] - '0' +
			mine[x][y - 1] - '0' +
			mine[x + 1][y] - '0' +
			mine[x + 1][y - 1] - '0';
}
//雷设置完了，即可以扫雷了
void FindMine(char minelnfo[][COLS], char mine[][COLS],int row, int col)
{
	int count = 0;
	int x = 0;
	int y = 0;
	//81-10=71
	while (count != row*col - MINENUM)//赢的话就是排除十个雷
	{
		printf("请输入你的坐标:");
		scanf("%d%d", &x, &y);//判断坐标合不合法。即输入的坐标只能在1~9之间
		if (x >= 1 && x <= 9 && y >= 1 && y <= 9)//说明你输入的坐标是合法的
		{
			if (mine[x][y] == '1')
			{
				printf("你被炸死了\n");
			}
			else
			{
				int mineNUM = GetMine(mine, x, y);//1:先找到旁边8个位置有几个零，若是有4个雷
				minelnfo[x][y] = mineNUM + '0';//2:将当前位置设置为 4
				                              // mineNUM是int型，而minelnfo是char型，进行数符转换
				count++;//3:count++//即继续扫雷
				ShowBoard(minelnfo,ROWS,COLS);
			}
		}
		else
		{
			printf("坐标不合法");
		}
	}
	if (count == row*col - MINENUM)//赢了
	{
		printf("扫雷成功\n");
	}
	
}
