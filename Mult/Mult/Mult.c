#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//ʵ��һ����������ӡ�˷��ھ����ھ���������������Լ�ָ����
//����9�����9*9�ھ�������12�����12*12�ĳ˷��ھ���
void Koujue(int n)
{
	int i, j;
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= i; j++)
		{
			printf("%d*%d=%-2d\t", i, j, i*j);
		}
		printf("\n");
	}
}
int main()
{
	int a;
	printf("��������Ҫ��ʲô�˷��ھ���\n");
	scanf("%d", &a);
	Koujue(a);
	return 0;
}