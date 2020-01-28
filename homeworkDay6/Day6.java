package homework;
import java.util.Arrays;
public class Day6 {
    /*
    * 题目1：给定一个按非递减顺序排序的整数数组 A，
    * 返回每个数字的平方组成的新数组，
     *要求也按非递减顺序排序。*/
    public static void main(String[] args) {
        int []a={1,-3,5,7};
        System.out.println(Arrays.toString(sortedSquares(a)));
    }
    public static int[] sortedSquares(int[] A) {
        //1：进行数组的遍历
        for(int i=0;i<A.length;i++){
            A[i]=A[i]*A[i];
        }
       //2：将数组进行排序
        Arrays.sort(A);
        return A;
    }
}
