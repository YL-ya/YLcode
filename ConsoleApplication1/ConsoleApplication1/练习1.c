/*#include <stdio.h>
// 打印100~200之间的素数
int main(){
	int i,j;
	for(i=200;i<300;i++)//200到300之间的所有数字
	{
		for(j=2;j<i;j++)
		if(i%j==0)break;
		if(j==i)
			printf("%d\t",i);
	}
	return 0;
}*/
//输出乘法口诀表
/*#include <stdio.h>
int main(){
	int i, j;
	for (i = 1; i < 10; i++)//1~9
	{
		for (j = 1; j <= i; j++)
			printf("%ld*%ld=%2d\n", j, i, j*i);
	}
	return 0;
}*/
//判断1000年---2000年之间的闰年
/*#include <stdio.h>
int main()
{
	int i ;
	int j = 0;
	for (i = 1000; i <= 2000; i++)
	{
		if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)//闰年是能被4 整除但不能被100整除或者能被400整除
			printf("%d\t", i);
		j++;
		if (j == 10)
			printf("\n");
	}
	return 0;
}*/



