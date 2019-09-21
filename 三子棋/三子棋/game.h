#pragma once//防止头文件重复引入
#define ROW 3
#define COL 3//3*3的棋盘
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void InitBoard(char board[][COL], int row, int col);

void ShowBoard(char board[][COL], int row, int col);

void PlayerMove(char board[][COL], int row, int col);

int IsWin(char board[][COL], int row, int col);

void ComputerMove(char board[][COL], int row, int col);
