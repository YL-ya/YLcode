#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#if 0
//�ݹ鷽ʽʵ�ִ�ӡһ��������ÿһλ
void Printint(int n)
{
	if (n/ 10 == 0)
	{
		printf("%d", n);
	}
	else
	{
		Printint(n/ 10);
		printf("%d", n % 10);
	}
}
int main()
{
	Printint(1234);
	return 0;
}
//�ݹ�ͷǵݹ�ֱ�ʵ����n�Ľ׳�
jiecheng(int n)
{
	if (n == 1)
	{
		return 1;
	}
	else
	{
		return n*jiecheng(n - 1);
	}

}
int main()
{
	int a;
	printf("����Ҫ�õ����Ľ׳ˣ�");
	scanf("%d", &a);
	int b=jiecheng(a);
	printf("%d\n", b);
	return 0;
}

//��дһ������ reverse_string(char * string)���ݹ�ʵ�֣�
//ʵ�֣��������ַ����е��ַ��������С�
//Ҫ�󣺲���ʹ��C�������е��ַ�������������

void reverse_string(char * string)
{
	if (*string == '\0')
	{
		return 0;
	}
	else
	{
		string++;
		reverse_string(string);
		printf("%c", *(string - 1));
	}
}
int main()
{
	char*string = "hello";
	reverse_string(string);
	return 0;
}


//дһ���ݹ麯��DigitSum(n)������һ���Ǹ����������������������֮�ͣ�
//���磬����DigitSum(1729)����Ӧ�÷���1+7+2+9�����ĺ���19
int DigitSum(int n)
{
	if (n / 10 == 0)
	{
		return n % 10;
	}
	else
	{
			return (n % 10) + DigitSum(n / 10);
	}
}
int main()
{
	int a=DigitSum(1729);
	printf("%d\n", a);
	return 0;
}

//��дһ������ʵ��n^k��ʹ�õݹ�ʵ��
int Cifang(int n,int k)
{
	if (k == 0)
	{
		return 0;
	}
	else if (k == 1)
	{
		return n;
	}
	else
	{
		return n* Cifang(n, (k - 1));
	}
}
int main()
{
	int n=3;
	int k=3;
	int result=Cifang(n,k);
	printf("%d\n", result);
	return 0;
}
//�ݹ�ͷǵݹ�ֱ�ʵ�����n��쳲�������
//�ݹ�
int fib(int n)
{
	if (n == 1 || n == 2)
	{
		return 1;
	}
	else
	{
		return fib(n - 1) + fib(n - 2);
	}
}
int main()
{
	int n;
	printf("��Ҫ�õ��ڼ���쳲���������:");
	scanf("%d", &n);
	int d = fib(n);
	printf("%d\n", d);
	return 0;
}

//�ǵݹ�
int fib(int n)
{
	int a = 1;
	int b = 1;
	int c = 0;
	int i = 0;
	for (i = 3; i <= 40; i++)
	{
		c = a + b;
		a = b;
		b = c;

	}
	return c;
}
int main()
{
	int n;
	printf("��Ҫ�õ��ڼ���쳲���������:");
	scanf("%d", &n);
	int d = fib(n);
	printf("%d\n", d);
	return 0;
}



//�ݹ�ͷǵݹ�ֱ�ʵ��strlen
//�ݹ飺
int Mystrlen(char *p)//p��ָ�������ŵ�����λ�ַ��ĵ�ַ
{
	int count=0;
	if (*p == '\0')//*p��ʾ��ӷ��ʣ����ַ�����ַ���������'\0'����ʾ�ַ�������Ϊ0
	{
		return 0;
	}
	else//���ַ�����ַ������ݲ���'\0',�����ٷ���1�����ַ�������һ���ַ�
	{
		return 1 + Mystrlen(p + 1);
	}
	
}
int main()
{
	char *str = "hello";
	int len = Mystrlen(str);
	printf("%d\n", len);
	return 0;
}
#endif
