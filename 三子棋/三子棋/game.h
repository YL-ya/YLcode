#pragma once//��ֹͷ�ļ��ظ�����
#define ROW 3
#define COL 3//3*3������
#include<stdio.h>
#include<string.h>
#include<stdlib.h>

void InitBoard(char board[][COL], int row, int col);

void ShowBoard(char board[][COL], int row, int col);

void PlayerMove(char board[][COL], int row, int col);

int IsWin(char board[][COL], int row, int col);

void ComputerMove(char board[][COL], int row, int col);
