#pragma once//��ֹͷ�ļ��ظ�����
#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define ROW 9
#define COL 9

#define ROWS ROW+2
#define COLS COL+2//���������Ǹ�11*11�Ķ�ά����

#define MINENUM 10//��ʼΪʮ����
void InitBoard(char board[][COLS], int rows, int cols,char set);//��ʼ������

void ShowBoard(char board[][COLS], int rows, int cols);//��ӡ����

void SetMine(char mine[][COLS],int row,int col);//����

int GetMine(char mine[][COLS], int x, int y);//ɨ��ǰ���õ�x,y�����Ա��ж��ٸ���

void FindMine(char minelnfo[][COLS],char mine[][COLS], int row, int col);//ɨ��

