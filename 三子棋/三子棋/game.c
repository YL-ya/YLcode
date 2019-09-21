#define _CRT_SECURE_NO_WARNINGS 1
#include"game.h"
void InitBoard(char board[][COL], int row, int col)
{
	//memset(board,' ',row*col*sizeof(char));ͷ�ļ�Ϊ#include<string.h>���ַ���������ȫ����ʼ��Ϊ�ո�
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
			printf(" %c ", board[i][j]);//�����ո�
			if (j < col - 1)
			{
				printf("|");//ֻ����������
			}
		}
		printf("\n");
		if (i < 2)//����---|---|---|
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
		printf("����ƶ���\n");
		printf("������1-3�����꣺");
		scanf("%d%d", &x, &y);//�û������һ�����������������λ��
		if (x >= 1 && y <= 3)//�����ǺϷ��Ľ����������жϸ����������Ƿ��¹�����
		{
			if (board[x - 1][y - 1] == ' ')//��ǰλ��û�б�������
			{
				board[x - 1][y - 1] = 'X';
				break;
			}
			else
			{
				printf("��λ���Ѿ��¹�����");
			}
		}
		else
		{
			printf("���겻�Ϸ�\n");
		}
	}
}
static int IsFull(char board[][COL], int row, int col)//static�����ú���ֻ�ڸ�game.c�ļ��µ���
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

int IsWin(char board[][COL], int row, int col)//�ж�˭Ӯ������ӮûӮ��������ֵ
{
	int i;
	for (i = 0; i < row; i++)//�۲��������λ�ã�����������һ���˵��Ӯ��
	{
		if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ')//��ʤ����XXX��(3��)
		{
			return board[i][0];
		}
		if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')//��ʤ��
		{
			return board[0][i];
		}
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ')//�Խ���'\'
		{
			return board[0][0];
		}
		if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ')//�Խ���'/'
		{
			return board[0][2];
		}
		if (IsFull(board, row, col) == 1)//���̷����ˣ�����ƽ��
		{
			return 'Q';//��ʾƽ��
		}
	}
	return ' ';//�������û��ƽ��Ҳû��Ӯ�ң����û�������һ�����������õ�����
}
void ComputerMove(char board[][COL], int row, int col)
{
	printf("�����ƶ�:\n");
	int x = 0;
	int y = 0;
	while (1)
	{
		x = rand() % row;
		y = rand() % col;//���0~2�������
		if (board[x][y] == ' ')
		{
			board[x][y] = 'O';
			break;
		}
	}
}

