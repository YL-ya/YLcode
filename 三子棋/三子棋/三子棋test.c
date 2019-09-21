#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<time.h>
#include "game.h"
void game()
{
	int ret = 0;
	char board[3][3] = { 0 };

	InitBoard(board, 3, 3);//��λ�����ʼ��Ϊ�ո�

	printf("=============\n");

	ShowBoard(board, 3, 3);

	printf("=============\n");

	printf("��Ϸ��ʼ\n");


	while (1)//��֪����˭��Ӯ��˭��Ӯ����������ѭ��
	{
		PlayerMove(board, 3, 3);//1.���������2.�����ǲ���Ӯ��
		ret = IsWin(board, 3, 3);//�жϵ���ʲô������'X'�û�Ӯ������'O'����Ӯ
		if (ret != ' ')
		{
			break;//����Ӯ����
		}
		ShowBoard(board, 3, 3);
		ComputerMove(board, 3, 3);//�����ƶ�
		ret = IsWin(board, 3, 3);
		if (ret != ' ')
		{
			break;//����Ӯ����
		}
		ShowBoard(board, 3, 3);
	}//�����������ж���˭Ӯ
	if (ret == 'X')
	{
		printf("��һ�ʤ�������\n");
	}
	if (ret == 'O')
	{
		printf("���Ի�ʤ\n");
	}
	if (ret == 'Q')
	{
		printf("ƽ��\n");
	}
}
void menu()
{
	printf("���������֣�\n1.play\n0.exit\n");
}
int main()
{
	srand((unsigned int)time(NULL));
	int input;
	do
	{
		menu();
		printf("��������Ĳ�����");
		scanf("%d", &input);
		switch (input)
		{
		case 1:
			game();
			break;
		case 0:
			printf("�˳���Ϸ");
			break;
		default:
			break;
		}
	} while (input);
	return 0;
}