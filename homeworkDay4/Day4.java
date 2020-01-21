package homework;

import java.util.Arrays;

public class Day4 {
    /*
     * 题目1：给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。*/
    public static void main1(String[] args) {
        String s = "a";
        System.out.println(lengthOfLastWord(s));

    }

    //自己写的：
    public static int lengthOfLastWord(String s) {
        //1：先判断字符串的长度
        if (s.length() == 0) {
            return 0;
        }
        //2：如果前后有空格，将其去掉
        String a = s.trim();
        int count = 0;//设置一个计数器
        //3：进行从后往前进行循环遍历，遇到空格就跳出循环，返回count
        for (int i = a.length() - 1; i > 0; i--) {
            if (a.charAt(i) >= 'a' && a.charAt(i) <= 'z' || a.charAt(i) >= 'A' && a.charAt(i) <= 'Z') {
                count++;
            } else if (a.charAt(i) == ' ') {
                break;
            } else {
                break;
            }
        }
        return count;
    }

    //博客上写的：
   /* public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        int count = 0;
        while (end >= 0) {
            //从后往前遍历
            char c = s.charAt(end);
            if ((c >= 'a' && c <= 'z') || c >= 'A' && c <= 'Z') {
                //只有是字符请况下 count++
                count++;
            } else {
                if (count != 0) {
                    //避免最后一位是空格
                    break;
                }
            }
            end--;
        }
        return count;
    }
}
*/

    /*   public static void main(String[] args) {
           int[]nums1={1,2,3,0,0,0};
           int[]nums2={2,5,6};
           merge(nums1,nums1.length,nums2,nums2.length);
       }


       public static void merge(int[] nums1, int  m, int[] nums2, int n) {
           //1:找出两数组中非连续零的个数
           int c=peek(nums1);
           int b=peek(nums2);
            //2：将nums2中的数字放进nums1数组中
           for (int i = c; i <m; i++) {
               nums1[i]=nums2[b-1];
               b--;
           }
           System.out.println(Arrays.toString(nums1));
           //3：将nums1中的数进行冒泡排序即可
           for (int i = 0; i < m; i++) {
               for (int j = 0; j <m-1-i; j++) {
                   if (nums1[j + 1] < nums1[j]) {
                       int temp = nums1[j + 1];
                       nums1[j + 1] = nums1[j];
                       nums1[j] = temp;
                   }
               }
           }
           System.out.println(Arrays.toString(nums1));
       }
       public static int peek(int[]a){
           //1：找出数组中的非0 的数字
           int cur=0;
           for (int i = 0; i <a.length ; i++) {
               if(a[i]!=0) {
                   cur++;
                   if (i==a.length-1||a[i + 1] == 0) {
                       break;
                   }
               }
           }
           return cur;
       }
       public static void play(int[]d){
           for (int i = 0; i <d.length ; i++) {
               System.out.print(d[i]+" ");
           }
       }
   }*/
   /* public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, nums1.length, nums2, nums2.length);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int d = peek(nums1);
        //2：将nums2中的数字放进nums1数组中
        for (int i = 0; i < n; i++) {

        }
        System.out.println(Arrays.toString(nums1));
        //3：将nums1中的数进行冒泡排序即可
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m - 1 - i; j++) {
                if (nums1[j + 1] < nums1[j]) {
                    int temp = nums1[j + 1];
                    nums1[j + 1] = nums1[j];
                    nums1[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(nums1));
    }

    public static int peek(int[] a) {
        //1：找出数组中后一个小于前一个的位置进行返回
        int i;
        for (i = 0; i < a.length; i++) {
            if (a[i] > a[i + 1]) {
                break;
            }
        }
        return i;
    }
}
*/
    public static void main(String[] args) {
        int[]nums1={1,2,3,0,0,0};
        int[]nums2={2,5,6};
        merge(nums1,3,nums2,3);
    }
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //1：直接将数组2放进数组1中
        for (int i = m; i < nums1.length; i++) {
            nums1[i] = nums2[n-1];
            n--;
        }
        //2：将数组1进行排序
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums1.length-1-i;j++){
                if(nums1[j+1]<nums1[j]){
                    int temp=nums1[j+1];
                    nums1[j+1]=nums1[j];
                    nums1[j]=temp;
                }
            }
        }
        //Arrays.sort(nums1);
        //3：输出即可
        System.out.println(Arrays.toString(nums1));
    }
}
