#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#if 0
void Isprime(int n)
{
	int i, j;
	for (i = 2; i <= n; i++)//������2~n��������
	{
		for (j = 2; j <= sqrt((double)i); j++)//��i����������2~(i/2)��i���κ���ȡ�඼������0
		{
			if (i%j == 0)
			{
				break;//��ʾi����������û��Ҫ������ȡ���ˣ�ֱ��������ѭ��,i++,������һ�������жϾͺ���
			}
		}
		if (j>sqrt((double)i))
		{
			printf("%d\t", i);
		}
	}
}
int main()
{
	int a = 0;
	printf("��������Ҫ��ӡ�����ٵ�����:");
	scanf("%d", &a);
	Isprime(a);
	printf("\n");
	return 0;
}

void Isprime(int n)
{
	int i, j;
	int count = 0;
	for (i = 2; i <= n; i++)//������2~n�������֣���i������������һ������ż����i+2
	{
		for (j = 2; j <= sqrt((double)i); j++)//��i����������2~(i/2)��i���κ���ȡ�඼������0
		{
			if (i%j == 0)
			{
				break;//��ʾi����������û��Ҫ������ȡ���ˣ�ֱ��������ѭ��,i++,������һ�������жϾͺ���
			}
		}
		if (j>sqrt((double)i))
		{
			printf("%d\t", i);
			count++;
		}
	}
}
int main()
{
	int a = 0;
	printf("��������Ҫ��ӡ�����ٵ�����:");
	scanf("%d", &a);
	Isprime(a);
	printf("\n");
	return 0;
}
#endif