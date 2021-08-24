package leetcode.array.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author modong
 * @date 2018/9/4 下午11:22
 *
 * Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1,
 *
 * and return them in any order.
 *
 * The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.
 *
 * graph[i] is a list of all nodes j for which the edge (i, j) exists.
 *
 * Example:
 *
 * Input: [[1,2], [3], [3], []]
 *
 * Output: [[0,1,3],[0,2,3]]
 *
 * Explanation: The graph looks like this:
 * 0--->1
 * |    |
 * v    v
 * 2--->3
 *
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 *
 *
 * Note. The number of nodes in the graph will be in the range [2, 15].
 *
 */
public class PathsSourceTarget {


    public static List<List<Integer>> solution(int[][] graph) {
        return dfs(graph, 0);
    }

    private static List<List<Integer>> dfs(int[][] graph, int node){
        List<List<Integer>> ans = new ArrayList<>();
        int len = graph.length;
        // 如果通过某条链路到达终点
        if (node == len - 1) {
            List<Integer> path = new ArrayList<>();
            path.add(node);
            ans.add(path);
            return ans;
        }
        // 遍历所有邻节点
        for (int nei: graph[node]) {
            for (List<Integer> path: dfs(graph, nei)) {
                path.add(0, node);
                ans.add(path);
            }
        }
        return ans;
    }
    @Test
    public void test(){
        List<List<Integer>> solution = PathsSourceTarget.solution(new int[][]{{1, 2}, {3}, {3}, {}});
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> sub1 = new ArrayList<>();
        sub1.add(0);
        sub1.add(1);
        sub1.add(3);
        ans.add(sub1);
        List<Integer> sub2 = new ArrayList<>();
        sub2.add(0);
        sub2.add(2);
        sub2.add(3);
        ans.add(sub2);
        Assert.assertArrayEquals(solution.toArray(), ans.toArray());
    }

}
