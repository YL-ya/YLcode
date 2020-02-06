package homework;
public class Day11 {
    public static void main(String[] args) {
        char []chars={'a','a','b','b','b','c','c'};
        System.out.println(compress(chars));
    }
    //思路：要想数组是在原始数组中进行执行和判断，那么就得用两个指针
    public static int compress(char[] chars) {
        if(chars.length==1){
            return 1;
        }else {
            int temp=0;
            int cur=1;
            char a='0';
            while(cur!=chars.length){
                if(chars[cur]==chars[temp]){
                    cur++;
                    continue;
                }
            }
        }
        return 1;
    }
}
