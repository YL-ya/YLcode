#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
//��ɲ�������Ϸ
void Data()
{
	int a = 0;
	srand((unsigned)time(NULL));//�����������
	a = rand() % 100 + 1;
	while (1)
	{
		printf("������µ�����\n");
		int b;
		scanf("%d", &b);
		if (a > b)
		{
			printf("���С��,�ٲ�\n");
		}
		if (a < b)
		{
			printf("��´��ˣ��ٲ�\n");
		}
		if (a == b)
		{
			printf("��¶���\n");
			break;
		}
	}
}
int main()
{
	printf("���������֣�\n1.play\n0.exit\n");
	int a;
	scanf("%d", &a);
	switch (a)
	{
	case 1:
		Data();
		break;
	case 0:
		printf("�˳���Ϸ�ɹ�\n");
	}
	return 0;
}