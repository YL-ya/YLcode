#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
//ˮ�ɻ�
int main()
{
	int i;
	for (i = 0; i <= 999999; i++)
	{
		int a = i;
		int count = 0;
		int sum = 0;
		while (a)//��Ҫдa!=0,��Ϊa������֮��a=0ʱ������Ϊ�٣���Ȼ������ѭ���������Լ򻯴���
		{
			count++;
			a = a / 10;
		}//������Ǽ�λ��
		a = i;
		int  b;
		while (a)//����ͬ��Ŷ
		{
			b = pow((double)(a % 10), (double)count);
			sum += b;
			a = a / 10;
		}
		if (sum == i)
		{
			printf("%d\n", i);//ע�����ﲻ��д��aŶ����Ȼ���Ϊ0����Ϊ����ѭ����a�Ľ������0
		}
	}
	return 0;
}