#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
//��д����ģ��������������ĳ�����
//����������������룬������ȷ����ʾ����¼�ɹ���,�������
//�����������룬����������Ρ����ξ�������ʾ�˳�����
int main()
{
	char password[10];
	int count = 3;
	while (count > 0)
	{
		printf("������������룺");
		scanf("%s", password);
		if (strcmp(password, "12345678") == 0)
		{
			printf("��½�ɹ�\n");
			break;
		}
		else
		{
			count--;
			printf("������� ������%d�λ���\n", count);
		}
	}
	return 0;
}