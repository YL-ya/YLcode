#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#if 0
//��ɲ�������Ϸ
void Data()
{
	int a = 0;
	srand((unsigned)time(NULL));
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
//��дһ�����򣬿���һֱ���ռ����ַ���
//�����Сд�ַ��������Ӧ�Ĵ�д�ַ���
//������յ��Ǵ�д�ַ����������Ӧ��Сд�ַ���
//��������ֲ������
//123ABCD45efG ==> abcdEFg
#include<string.h>
int main()
{
	int letter = 0;
	printf("���������");
	letter=getchar();
	if (letter >= 'a'&&letter <= 'z')
	{
		letter = letter - 32;
		putchar(letter);
	}
	if (letter >= 'A'&&letter <= 'Z')
	{
		letter = letter + 32;
		putchar(letter);
	}
	if (letter>=0&&letter<=9)
	{
	}
	printf("\n");
	system("pause");
	return 0;
}
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
//д����������������������в�����Ҫ�����֣�
//�ҵ��˷����±꣬�Ҳ�������-1.���۰���ң�
int BinarySeach(int arr[], int len, int n)
{
	int left = 0;
	int right = len - 1;
	while (left <= right)
	{
		int mid = (left + right) / 2;
		if (n <arr[mid])
		{
			right = mid - 1;
		}
		else if (n>arr[mid])
		{
			left = mid + 1;
		}
		else
		{
			return mid;
		}
	}
	return -1;
}
int main()
{
	int arr[10] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	int a = 6;
	int len = strlen(arr);
	int b= BinarySeach(arr,10,a);
	if (b == -1)
	{
		printf("û���ҵ�");
	}
	else
	{
		printf("�ҵ������±�Ϊ��%d\n", b);
	}
	return 0;
}
#endif
	
