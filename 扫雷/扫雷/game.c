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
	for (i = 0; i <rows-1; i++)//i<10,��0~9
	{
		printf("%d ",i);
	}
	printf("\n");
	for (i = 1; i < rows-1; i++)//���̵ĵ�ʮ�У������̵����һ��
	{
		printf("%d ", i);
		for (j = 1; j < cols - 1; j++)//���з��˱����
		{
			printf("%c ",board[i][j]);
		}
		printf("\n");//������forѭ��ֻ��ӡ���ڲ������̣�����������ǲ㲢û�д�ӡ
	}
	printf("===================\n");
}
//����֮ǰ�ø����������ף�������������
void SetMine(char mine[][COLS], int row, int col)//9*9
{
	int count = MINENUM;
	int x = 0; int y = 0;
	while (count != 0)
	{
		x = rand() % row + 1;//[0,9)[1,10)
		y = rand() % col + 1;//����1~9���������
		if (mine[x][y] == '0')//�������ʱ�����ظ�����ͬһ��λ��
		{
			mine[x][y] = '1';//���Ѿ�����һ������
			count--;//������ʮ����֮����˳�ѭ������ʮ������ֻ���
		}
	}
}
static int GetMine(char mine[][COLS],int x,int y)//��x,y�����Ա��ж����ף���mine��������
{
	//�ַ�-�ַ�=����
	//��'1'-'0'=1
	return  mine[x - 1][y - 1] - '0' +
			mine[x - 1][y] - '0' +
			mine[x - 1][y - 1] - '0' +
			mine[x][y + 1] - '0' +
			mine[x + 1][y + 1] - '0' +
			mine[x][y - 1] - '0' +
			mine[x + 1][y] - '0' +
			mine[x + 1][y - 1] - '0';
}
//���������ˣ�������ɨ����
void FindMine(char minelnfo[][COLS], char mine[][COLS],int row, int col)
{
	int count = 0;
	int x = 0;
	int y = 0;
	//81-10=71
	while (count != row*col - MINENUM)//Ӯ�Ļ������ų�ʮ����
	{
		printf("�������������:");
		scanf("%d%d", &x, &y);//�ж�����ϲ��Ϸ��������������ֻ����1~9֮��
		if (x >= 1 && x <= 9 && y >= 1 && y <= 9)//˵��������������ǺϷ���
		{
			if (mine[x][y] == '1')
			{
				printf("�㱻ը����\n");
			}
			else
			{
				int mineNUM = GetMine(mine, x, y);//1:���ҵ��Ա�8��λ���м����㣬������4����
				minelnfo[x][y] = mineNUM + '0';//2:����ǰλ������Ϊ 4
				                              // mineNUM��int�ͣ���minelnfo��char�ͣ���������ת��
				count++;//3:count++//������ɨ��
				ShowBoard(minelnfo,ROWS,COLS);
			}
		}
		else
		{
			printf("���겻�Ϸ�");
		}
	}
	if (count == row*col - MINENUM)//Ӯ��
	{
		printf("ɨ�׳ɹ�\n");
	}
	
}
