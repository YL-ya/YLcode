/*#include <stdio.h>
// ��ӡ100~200֮�������
int main(){
	int i,j;
	for(i=200;i<300;i++)//200��300֮�����������
	{
		for(j=2;j<i;j++)
		if(i%j==0)break;
		if(j==i)
			printf("%d\t",i);
	}
	return 0;
}*/
//����˷��ھ���
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
//�ж�1000��---2000��֮�������
/*#include <stdio.h>
int main()
{
	int i ;
	int j = 0;
	for (i = 1000; i <= 2000; i++)
	{
		if ((i % 4 == 0 && i % 100 != 0) || i % 400 == 0)//�������ܱ�4 ���������ܱ�100���������ܱ�400����
			printf("%d\t", i);
		j++;
		if (j == 10)
			printf("\n");
	}
	return 0;
}*/



