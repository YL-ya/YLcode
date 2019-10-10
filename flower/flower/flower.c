#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<math.h>
//水仙花
int main()
{
	int i;
	for (i = 0; i <= 999999; i++)
	{
		int a = i;
		int count = 0;
		int sum = 0;
		while (a)//不要写a!=0,因为a除尽了之后a=0时括号中为假，自然就跳出循环；即可以简化代码
		{
			count++;
			a = a / 10;
		}//计算出是几位数
		a = i;
		int  b;
		while (a)//理由同上哦
		{
			b = pow((double)(a % 10), (double)count);
			sum += b;
			a = a / 10;
		}
		if (sum == i)
		{
			printf("%d\n", i);//注意这里不能写成a哦，不然结果为0，因为跳出循环后a的结果就是0
		}
	}
	return 0;
}