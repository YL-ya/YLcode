#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
#if 0
//��ŵ��
void Move(char pos1, char pos2)
{
	printf("%c��%c\t",pos1,pos2);
}
void hanio(int n,char pos1,char pos2,char pos3)
{
	if (n == 1)
	{
		Move(pos1, pos3);
	}
	else
	{
		hanio(n - 1, pos1, pos3, pos2);
		Move(pos1, pos3);
		hanio(n - 1, pos2, pos1, pos3);
	}
}

int main()
{
	hanio(4, 'A', 'B', 'C');
	printf("\n");
	return 0;
}

void Isprime(int n)
{
	int i,j;
	for (i = 2; i <= n; i++)//������2~n��������
	{
		for (j = 2; j <=sqrt((double)i); j++)//��i����������2~(i/2)��i���κ���ȡ�඼������0
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
	int i,j;
	int count = 0;
	for (i = 2; i <= n; i++)//������2~n�������֣���i������������һ������ż����i+2
	{
		for (j = 2; j <=sqrt((double)i); j++)//��i����������2~(i/2)��i���κ���ȡ�඼������0
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

int main()
{
	int a = 50;
	int b = 70;
	int temp = 0;
	printf("����ǰ��ֵΪ%d,%d\n", a, b);
	temp = a;
	a = b;
	b = temp;
	printf("�������ֵΪ%d,%d\n", a, b);
	return 0;
}

int main()
{
	int a = 10;
	int b = 20;
	printf("����ǰ��ֵΪ%d,%d\n", a, b);
	a = a^b;
	b = a^b;
	a = a^b;
	printf("�������ֵΪ%d,%d\n", a, b);
	return 0;
}

int main()
{
	int a = 20;
	int b = 30;
	printf("����ǰ��ֵΪ%d,%d\n", a, b);
	a = a + b;
	b = a - b;
	a = a - b;
	printf("�������ֵΪ%d,%d\n", a, b);
	return 0;
}

int main()
{
	int i,temp;
	for (i = 0; i < 999999; i++)
	{
		int count = 0;
		int sum = 0;
		temp = i;
		while (temp != 0)
		{
			count++;
			temp=temp / 10;
		}//������Ǽ�λ��

	}
	return 0;
}

int main()
{
	int i = 0, j = 0;
	for (i = 0; i <= 100; i++)
	{
		for (j = 2; j <= i; j++)
		{
			if (i == j)
			{
				printf("%d������\n");
			}
			if (i%j == 0)
			{
				break;
			}
		}
		
	}
	return 0;
}

int main()
{
	int line = 0;
	 (line < 100)
	{
		printf("��Ҫд����\t");
		line++;
	}
	printf("д����\n");
	return 0;
}

int main()
{
	int a=0;
	printf("��������õ��õ�offer,������1��\n");
	scanf("%d", &a);
	if (a == 1)
	{
		printf("��Ҫ�ú�ѧϰ\n");
	}
	else
	{
		printf("��ҵ�͵���ʧҵ���������");
	}
	return 0;
}
#endif