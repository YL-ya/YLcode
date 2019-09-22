#pragma once//防止头文件重复引入
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define ROW 9
#define COL 9

#define ROWS ROW+2
#define COLS COL+2//真正棋盘是个11*11的二维数组

#define MINENUM 10//初始为十个雷
void InitBoard(char board[][COLS], int rows, int cols,char set);//初始化棋盘

void ShowBoard(char board[][COLS], int rows, int cols);//打印棋盘

void SetMine(char mine[][COLS],int row,int col);//放雷

int GetMine(char mine[][COLS], int x, int y);//扫雷前，得到x,y坐标旁边有多少个雷

void FindMine(char minelnfo[][COLS],char mine[][COLS], int row, int col);//扫雷

