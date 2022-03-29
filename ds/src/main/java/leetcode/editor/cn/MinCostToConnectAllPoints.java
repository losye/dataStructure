//给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。
//
// 连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示
//val 的绝对值。
//
// 请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。
//
//
//
// 示例 1：
//
//
//
//
//输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//输出：20
//解释：
//
//我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
//注意到任意两个点之间只有唯一一条路径互相到达。
//
//
// 示例 2：
//
//
//输入：points = [[3,12],[-2,5],[-4,1]]
//输出：18
//
//
// 示例 3：
//
//
//输入：points = [[0,0],[1,1],[1,0],[-1,1]]
//输出：4
//
//
// 示例 4：
//
//
//输入：points = [[-1000000,-1000000],[1000000,1000000]]
//输出：4000000
//
//
// 示例 5：
//
//
//输入：points = [[0,0]]
//输出：0
//
//
//
//
// 提示：
//
//
// 1 <= points.length <= 1000
// -106 <= xi, yi <= 106
// 所有点 (xi, yi) 两两不同。
//
// Related Topics 并查集 数组 最小生成树
// 👍 188 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinCostToConnectAllPoints {
    public static void main(String[] args) {
        Solution solution = new MinCostToConnectAllPoints().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minCostConnectPoints(int[][] points) {

            List<Edge>[] graph = buildGraph(points);
            Prim prim = new Prim(graph);

            return prim.getWeightSum();
            //return kruskal(points);
        }

        public List<Edge>[] buildGraph(int[][] points) {
            int n = points.length;
            List<Edge>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0], yi = points[i][1];
                    int xj = points[j][0], yj = points[j][1];
                    int weight = Math.abs(xi - xj) + Math.abs(yi - yj);

                    graph[i].add(new Edge(i, j, weight));
                    graph[j].add(new Edge(j, i, weight));
                }
            }
            return graph;
        }

        class Prim {

            private List<Edge>[] graph;

            private PriorityQueue<Edge> priorityQueue = new PriorityQueue<>((Edge::compareTo));

            private int weightSum;

            private boolean[] inMST;

            public Prim(List<Edge>[] graph) {
                this.graph = graph;
                inMST = new boolean[graph.length];

                inMST[0] = true;
                cut(0);

                while (!priorityQueue.isEmpty()) {
                    Edge edge = priorityQueue.poll();

                    int to = edge.to;
                    if (inMST[to]) {
                        continue;
                    }
                    inMST[to] = true;

                    cut(to);
                    weightSum += edge.weight;
                }

            }


            private void cut(int node) {
                List<Edge> edges = graph[node];

                for (Edge edge : edges) {
                    int to = edge.to;
                    if (inMST[to]) {
                        continue;
                    }
                    priorityQueue.offer(edge);
                }
            }

            public int getWeightSum() {
                return weightSum;
            }

            public boolean allConnected() {
                for (boolean in : inMST) {
                    if (!in) {
                        return false;
                    }
                }
                return true;
            }
        }

        class Edge implements Comparable<Edge> {

            int from;

            int to;

            Integer weight;

            public Edge(int from, int to, Integer weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            @Override
            public int compareTo(Edge o) {
                return this.weight.compareTo(o.weight);
            }
        }


        private int kruskal(int[][] points) {
            List<int[]> edges = new ArrayList<>();
            int n = points.length;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0], yi = points[i][1];
                    int xj = points[j][0], yj = points[j][1];
                    edges.add(new int[]{
                            i, j, Math.abs(xi - xj) + Math.abs(yi - yj)
                    });
                }
            }
            edges.sort(Comparator.comparingInt(a -> a[2]));
            int res = 0;
            UnionFind unionFind = new UnionFind(n);
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                int weight = edge[2];
                if (unionFind.connected(from, to)) {
                    continue;
                }
                unionFind.union(from, to);
                res += weight;
            }
            return res;
        }

        class UnionFind {
            private int cnt;

            private int[] parent;

            private int[] size;

            public UnionFind(int n) {
                this.cnt = n;
                parent = new int[n];
                size = new int[n];

                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }

            public int getCnt() {
                return cnt;
            }

            public int find(int p) {
                while (p != parent[p]) {
                    parent[p] = parent[parent[p]];
                    p = parent[p];
                }
                return p;
            }


            private boolean connected(int p, int q) {
                return find(p) == find(q);
            }

            public void union(int p, int q) {
                int rootP = find(p);
                int rootQ = find(q);

                if (rootP == rootQ) {
                    return;
                }

                if (size[rootP] > size[rootQ]) {
                    parent[rootQ] = rootP;
                    size[rootP] += size[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    size[rootQ] += size[rootP];
                }

                cnt--;
            }
        }

        /*class Prim {
            private List<int[]>[] graph;

            private boolean[] inMst;

            private int weightSum = 0;

            private PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

            public Prim(List<int[]>[] graph) {
                this.graph = graph;
                inMst = new boolean[graph.length];

                inMst[0] = true;
                cut(0);

                while (!priorityQueue.isEmpty()) {
                    int[] node = priorityQueue.poll();
                    int to = node[1];
                    if (inMst[to]) {
                        continue;
                    }
                    inMst[to] = true;

                    int weight = node[2];
                    weightSum += weight;

                    cut(to);
                }
            }

            private void cut(int i) {
                List<int[]> edgs = graph[i];

                for (int[] edg : edgs) {
                    int to = edg[1];
                    if (inMst[to]) {
                        continue;
                    }
                    priorityQueue.offer(edg);
                }
            }

            public int getWeightSum() {
                return weightSum;
            }
        }

        private List<int[]>[] buildGraph(int[][] points) {
            int n = points.length;
            List<int[]>[] graph = new LinkedList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<>();
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int xi = points[i][0], yi = points[i][1];
                    int xj = points[j][0], yj = points[j][1];
                    int weight = Math.abs(xi - xj) + Math.abs(yi - yj);

                    graph[i].add(new int[]{i, j, weight});
                    graph[j].add(new int[]{j, i, weight});
                }
            }
            return graph;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}
