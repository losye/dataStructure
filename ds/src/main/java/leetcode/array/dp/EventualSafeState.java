package leetcode.array.dp;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author modong
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
    private static boolean dfs(int node, int[] color, int[][] graph) {
        if (color[node] > 0)
            return color[node] == 2;

        color[node] = 1;
        for (int nei: graph[node]) {
            if (color[node] == 2)
                continue;
            if (color[nei] == 1 || !dfs(nei, color, graph))
                return false;
        }
        color[node] = 2;
        return true;
    }

    @Test
    public void testDfs(){
        int[][] graph = new int[][]{{1,2},{2,3},{5},{0},{5},{},{}};
        Assert.assertArrayEquals(new Object[]{2,4,5,6}, EventualSafeState.eventualSafeNodesDfs(graph).toArray());
    }
}
