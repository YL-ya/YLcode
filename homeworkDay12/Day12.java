package homework;

import java.util.Stack;

public class Day12 {
    /*
    * 题目1：最短无序连续子数组*/
    public static void main1(String[] args) {
        int[]nums={2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }

    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len-1];
        int l = 0, r = -1;
        for(int i=0;i<len;i++) {
            if (max > nums[i]) {
                r = i;
            } else {
                max = nums[i];
            }
        }
        for(int i=0;i<len;i++){
            if(min<nums[len-i-1]){
                l = len-i-1;
            }else{
                min = nums[len-i-1];
            }
        }
        return r-l+1;
    }

    /*
    *题目2：逆波兰表达式： */
    public static void main(String[] args) {
        String[]a={"2","1","+","3","*"};
        System.out.println(evalRPN(a));
    }
    //思想：定义1个栈，数字存储，然后进行遍历数组，当遇到运算符的时候进行运算即可
    public static int evalRPN(String[] tokens) {
        int a = 0, b = 0;
        Stack<Integer> S = new Stack<Integer>();
        for (String s : tokens) {
            if (s.equals("+"))
                S.add(S.pop() + S.pop());
            else if (s.equals("-")) {
                b = S.pop();
                a = S.pop();
                S.add(a - b);
            } else if (s.equals("*"))
                S.add(S.pop() * S.pop());
            else if (s.equals("/")) {
                b = S.pop();
                a = S.pop();
                S.add(a / b);
            } else
                S.add(Integer.parseInt(s));
        }
        return S.pop();
    }
}
