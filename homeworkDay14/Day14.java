package homework;
import java.util.*;

public class Day14 {
    /*
     * 题目1：给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。*/
    //求解的是右视图,那么BFS层次遍历时保存每层的最右一个节点即可。
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ret;
    }


    /*
     * 题目2：公交路线：
     * 我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。
     * 例如，有一条路线 routes[0] = [1, 5, 7]，表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶*/
    public static void main1(String[] args) {
        int[][] a = {{1, 2, 7}, {3, 6, 7}};
        System.out.println(numBusesToDestination(a, 1, 6));
    }

    /*
     * 立扣上面给的题解：*/
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        // 特殊情况以及数据初始化
        if (S == T) {
            return 0;
        }
        if (routes == null || routes.length == 0) {
            return -1;
        }
        List<Integer> before = getRouteList(routes, S);// 起始车站所在的路线集合
        List<Integer> after = getRouteList(routes, T);// 终点车站所在的路线集合
        if (beforeContainAfter(before, after)) {
            return 1;// 在一条路线上
        }
        Boolean[] isVisited = new Boolean[routes.length];
        for (int i = 0; i < isVisited.length; i++) {
            if (before.contains(i)) {
                isVisited[i] = true;
            }
            isVisited[i] = false;
        }
        Map<Integer, List<Integer>> routeMap = new HashMap<>();// routeMap.get(i)的值表示与路线i存在公共车站的所有路线集合
        for (int i = 0; i < routes.length; i++) {
            for (int j = i + 1; j < routes.length; j++) {
                if (haveCommonStop(routes[i], routes[j])) {
                    if (!routeMap.containsKey(i)) {
                        routeMap.put(i, new ArrayList<>());
                    }
                    routeMap.get(i).add(j);
                    if (!routeMap.containsKey(j)) {
                        routeMap.put(j, new ArrayList<>());
                    }
                    routeMap.get(j).add(i);
                }
            }
        }
        if (routeMap == null || routeMap.size() == 0) {
            return -1; // 所有路线无交集场景
        }
        // 算法主体
        boolean hasReached = false;
        boolean noMoreAvailableStop = false;
        int count = 1;
        while (!hasReached && !noMoreAvailableStop) {
            // [1]开始从before向外拓展
            count++;
            // [2]求得当前before列表中相邻的所有路线集合，结果替换before然后进下一轮向外拓展
            List<Integer> canVisitList = canVisit(routeMap, before, isVisited);
            if (canVisitList.size() == 0) {
                noMoreAvailableStop = true;
            } else {
                before.clear();
                before = canVisitList;
                for (int beforeItem : before) {
                    isVisited[beforeItem] = true; //已探索过的结点不再探索
                }
            }
            // [3]当前before集合中是否存在一条路线也属于after集合
            if (beforeContainAfter(before, after)) {
                hasReached = true;
            }
        }
        // 算法结果
        if (hasReached) {
            return count;
        } else {
            return -1;
        }
    }

    public static List<Integer> getRouteList(int[][] routes, int busStop) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                if (routes[i][j] == busStop && !result.contains(i)) {
                    result.add(i);
                }
            }
        }
        return result;
    }

    public static boolean haveCommonStop(int[] routes1, int[] routes2) {
        int index1 = 0;
        int index2 = 0;
        while (index1 < routes1.length && index2 < routes2.length) {
            if (routes1[index1] == routes2[index2]) {
                return true;
            } else if (routes1[index1] < routes2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        return false;
    }

    public static List<Integer> canVisit(Map<Integer, List<Integer>> routeMap, List<Integer> before, Boolean[] isVisited) {
        List<Integer> result = new ArrayList<>();
        for (int beforeItem : before) {
            for (int routeItem : routeMap.get(beforeItem)) {
                if (!result.contains(routeItem) && !before.contains(routeItem) && !isVisited[routeItem]) {
                    result.add(routeItem);
                }
            }
        }
        return result;
    }

    public static Boolean beforeContainAfter(List<Integer> before, List<Integer> after) {
        for (int afterItem : after) {
            if (before.contains(afterItem)) {
                return true;
            }
        }
        return false;
    }


    /*自己写的有缺陷：
    public static int numBusesToDestination(int[][] routes, int S, int T) {
        //1：思路：先判断没有终点的情况下：
        int j = peek(routes, T);
        if (j == -1) {
            return -1;//表示无法到达终点
        }
        //判断是否在同一行：
        int i=judge(routes,S);
        int k=judge(routes,T);
        if(i==k){
            return 1;
        }
        return i+k+1;

    }

    public static int peek(int[][] b, int t) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[i][j] == t) {
                    return 1;
                }
            }
        }
        return -1;
    }
    public static int judge(int[][]c,int k){
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                if(c[i][j]==k){
                    return i;
                }
            }
        }
        return -1;
    }*/


    /*
    * 题目3：通配符匹配：
    * '?' 可以匹配任何单个字符。
    * '*' 可以匹配任意字符串（包括空字符串）。*/
    public static void main(String[] args) {
        String a="aa";
        String b="a";
        System.out.println(isMatch(a,b));
    }
    /*
    * 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配 (true 的话表示匹配)
    * 状态转移方程：
     * 1. 当 s[i] == p[j]，或者 p[j] == ? 那么 dp[i][j] = dp[i - 1][j - 1];
       2. 当 p[j] == * 那么 dp[i][j] = dp[i][j - 1] || dp[i - 1][j]
     * 其中：
         dp[i][j - 1] 表示 * 代表的是空字符，例如 ab, ab*
         dp[i - 1][j] 表示 * 代表的是非空字符，例如 abcd, ab*
     * 初始化：
        * 1. dp[0][0] 表示什么都没有，其值为 true
          2. 第一行 dp[0][j]，换句话说，s 为空，与 p 匹配，所以只要 p 开始为 * 才为 true
          3. 第一列 dp[i][0]，当然全部为 false
    */
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        // 状态 dp[i][j] : 表示 s 的前 i 个字符和 p 的前 j 个字符是否匹配
        boolean[][] dp = new boolean[m + 1][n + 1];

        // 初始化
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }

        // 状态转移
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        // 返回结果
        return dp[m][n];
    }
}
