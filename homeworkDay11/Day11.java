package homework;

public class Day11 {
    /*
     * 题目1：给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。*/
    public static void main1(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {
        //1：将字符串转成字符数组
        char[] a = s.toCharArray();
        int i = 0;
        int j = a.length - 1;
        //2：进行循环判断即可
        while (i < j) {
            //Character.isLetterOrDigit：判断是数字还是字母
            if (!Character.isLetterOrDigit(a[i]))
                i++;
            else if (!Character.isLetterOrDigit(a[j]))
                j--;
            else if (Character.toLowerCase(a[i]) == Character.toLowerCase(a[j])) {
                //Character.toLowerCase：字母的小写化
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    /*
     * 题目2：压缩字符串*/
    public static void main(String[] args) {
        char[] chars = {'a', 'a', 'b', 'b', 'b', 'c', 'c'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        int pTop = 0;
        int N = chars.length;
        int counter = 1;
        for (int i = 0; i < N - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                counter++;                 //记录重复字符
            } else {
                chars[pTop++] = chars[i];  //不同字符压栈
                if (counter > 1) {
                    for (char c : (counter + "").toCharArray())
                        chars[pTop++] = c; //添加数量大于1的字符个数
                }
                counter = 1;
            }
        }
        //处理最后一类字符
        chars[pTop++] = chars[N - 1];
        if (counter > 1) {
            for (char c : (counter + "").toCharArray())
                chars[pTop++] = c;
        }
        return pTop;
    }
}
        /*自己写的：
        int cur = 0;
        int n = chars.length;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                count++;                 //记录重复字符
            } else {
                chars[cur++] = chars[i];  //不同字符压栈
                if (count > 1) {
                    for (char c : (count + "").toCharArray())
                        chars[cur++] = c; //添加数量大于1的字符个数
                }
                count = 1;
            }
        }
        //处理最后一类字符
        chars[cur++] = chars[n - 1];
        if (count > 1) {
            for (char c : (count+ "").toCharArray())
                chars[cur++] = c;
        }
        return cur;
    }
}*/