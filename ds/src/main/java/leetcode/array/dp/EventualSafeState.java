package leetcode.array.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ye
 * @date 2018/8/23 下午11:28
 * In a directed graph, we start at some node and every turn,
 *
 * walk along a directed edge of the graph.
 *
 * If we reach a node that is terminal (that is, it has no outgoing directed edges), we stop.
 *
 * Now, say our starting node is eventually safe if and only if we must eventually walk to a terminal node.
 *
 * More specifically, there exists a natural number K so that for any choice of where to walk,
 *
 * we must have stopped at a terminal node in less than K steps.
 *
 * Which nodes are eventually safe?  Return them as an array in sorted order.
 *
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the length of graph.
 *
 * The graph is given in the following form: graph[i] is a list of labels j such that (i, j) is a directed edge of the graph.
 *
 * Example:
 * Input: graph = [[1,2],[2,3],[5],[0],[5],[],[]]
 * Output: [2,4,5,6]
 * Here is a diagram of the above graph.
 *
 */
public class EventualSafeState {

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int N = graph.length;
        Boolean[] checked = new Boolean[N];
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            if(!check(i, graph, checked, new HashSet<>())) {
                list.add(i);
            }
        }
        return list;
    }

    private static boolean check(int i, int[][] graph, Boolean[] checked, Set<Integer> checking) {
        if(checked[i] != null) return checked[i];
        checking.add(i);
        for(int n : graph[i]) {
            if(checking.contains(n) || check(n, graph, checked, checking)) {
                checked[i] = true;
                return true;
            }
        }
        checking.remove(i);
        checked[i] = false;
        return false;
    }

    public static List<Integer> eventualSafeNodesDfs(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        int len = graph.length;
        int[] color = new int[len];
        for (int i = 0; i < len; i++) {
            if (dfs(i, color, graph)) {
                res.add(i);
            }
        }
        return res;
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;

    /**
     * color{
     *     WHITE: 节点还未遍历,
     *     GRAY: 正在遍历邻节点
     *     BLACK: 已经结束该节点遍历
     * }
     * @param node
     * @param color
     * @param graph
     * @return safe
     */
    private static boolean dfs(int node, int[] color, int[][] graph) {
        // 当前节点如果遍历过
        if (color[node] > DfsState.WHITE.color){
            // gray 表示有环 返回false
            return color[node] == DfsState.BLACK.color;
        }
        // 记录该节点为正在遍历邻节点
        color[node] = DfsState.GRAY.color;
        for (int nei: graph[node]) {
            if (color[nei] == DfsState.BLACK.color)
                continue;
            // 邻接点有环
            if (color[nei] == DfsState.GRAY.color)
                return false;
            // 递归邻节点有环
            if (!dfs(nei, color, graph))
                return false;
        }
        // 结束该节点遍历
        color[node] = DfsState.BLACK.color;
        return true;
    }

    private enum DfsState {
        WHITE(0),
        GRAY(1),
        BLACK(2);
        private int color;

        DfsState(int color) {
            this.color = color;
        }

    }


    @Test
    public void testDfs(){
        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        Assert.assertArrayEquals(new Object[]{2,4,5,6}, EventualSafeState.eventualSafeNodesDfs(graph).toArray());
        Assert.assertArrayEquals(new Object[]{2,4,5,6}, EventualSafeState.eventualSafeNodes(graph).toArray());
    }
}
