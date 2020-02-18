package homework;

import java.util.ArrayList;

import java.util.List;

public class Day13 {
    /*
    * 题目1：求子集*/
    //集合的每个元素，都有可以选或不选，用二进制和位运算，可以很好的表示。
    public static void main1(String[] args) {
        int[]a={1,2,3};
        System.out.println(subsets(a));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 0; i < (1 << nums.length); i++) {
            List<Integer> sub = new ArrayList<Integer>();
            for (int j = 0; j < nums.length; j++)
                if (((i >> j) & 1) == 1) sub.add(nums[j]);
            res.add(sub);
        }
        return res;
    }

    /*
    * 题目2：矩阵中最长递增路径长度*/
    //1：用vivited来记录遍历过的点的最大递增路径。
    //2：当某次dfs遇到该点时，直接返回，因此可以减少搜索时间。
    //3：回溯时弄清楚你想如何保存状态。
    public static void main(String[] args) {
        int[][]nums={{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(nums));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][] vector = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int sum = 1;
        int[][] visited = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j] == 0){
                    List<int[]> list = new ArrayList<>();
                    list.add(new int[]{i,j});
                    int dfs = dfs(vector, i, j, matrix, list,visited);
                    if (dfs >= sum)
                        sum = dfs;
                }
            }
        }
        return sum;
    }

    private static int dfs(int[][] vector,int i,int j,int[][] matrix,List<int[]> list,int[][] visited){
        if (visited[i][j] != 0)
            return visited[i][j];
        int max_len = 1;
        for (int[] ints : vector) {
            int r = i + ints[0];
            int c = j + ints[1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length && matrix[r][c] > matrix[i][j]){
                list.add(new int[]{i,j});
                int len = dfs(vector, r, c, matrix, list,visited) + 1;
                if (len >= max_len)
                    max_len = len;
                list.remove(list.size()-1);
            }
        }
        visited[i][j] = max_len;
        return max_len;
    }
}
