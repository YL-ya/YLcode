#define _CRT_SECURE_NO_WARNINGS 1
//2��ȷ�����֣�
#include<stdio.h>
int main()
{
	int i;//��i������
	for (i = 'A'; i <= 'D'; i++)//�������ֿ���'A'-'D'=4
	{
		if ((i != 'A') + (i == 'C') + (i == 'D') + (i != 'D') == 3)
			printf("������:%c\n", (char)i);
	}
	return 0;
}