#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include"game.h"
#include<time.h>
void game()//�������飺һ���������ף�һ��������û���
{
	char minelnfo[ROWS][COLS];//���11*11����׵���Ϣ
	char mine[ROWS][COLS];//����׵�

	InitBoard(minelnfo,ROWS,COLS,'*');//�û�����

	InitBoard(mine,ROWS,COLS,'0');//'0'�ַ��㣬֤������û���κε���//��ʼ������

	ShowBoard(minelnfo, ROWS, COLS);

	SetMine(mine, ROW, COL);

	//ShowBoard(mine, ROWS, COLS);

	FindMine(minelnfo, mine, ROW, COL);
}
void menu()
{
	printf("���������֣�\n1.play\n0.exit\n");
}
int main()
{
	//srand((unsigned int)time(NULL));
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