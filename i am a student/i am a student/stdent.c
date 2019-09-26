#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
void reverse(char *left, char *right)
{
	while (left<right)
	{
		char tmp = *left;
		*left = *right;
		*right = tmp;
		left++;
		right--;
	}
}
void reverse_str(char arr[], int sz)
{
	char *left = arr;
	char *right = arr + sz - 1;
	char *start = arr;
	char *end = arr;
	reverse(left, right);
	while (*end != '\0')
	{
		while ((*end != ' ') && (*end != '\0'))
		{
			end++;
		}
		reverse(start, end - 1);
		if (*end != '\0')
		{
			start = end + 1;
			end = start;
		}
	}
}
int main()
{
	char arr[] = "student a am i";
	int sz = sizeof(arr) / sizeof(arr[0]) - 1;
	reverse_str(arr, sz);
	printf("%s\n", arr);
	return 0;
}