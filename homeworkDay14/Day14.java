package homework;
import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day14 {
    /*
    * 题目1：给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。*/
    //求解的是右视图,那么BFS层次遍历时保存每层的最右一个节点即可。
    /*public static List<Integer> rightSideView(TreeNode root) {
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
                if (node.right !=null) {
                    queue.add(node.right);
                }
            }
        }
        return ret;
    }*/


    /*
    * 题目2：公交路线：
    * 我们有一系列公交路线。每一条路线 routes[i] 上都有一辆公交车在上面循环行驶。
    * 例如，有一条路线 routes[0] = [1, 5, 7]，表示第一辆 (下标为0) 公交车会一直按照 1->5->7->1->5->7->1->... 的车站路线行驶*/
    public static void main(String[] args) {

    }
    public static int numBusesToDestination(int[][] routes, int S, int T) {

    }
}
