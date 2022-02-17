//给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!
//=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。
//
// 只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。
//
//
//
//
//
//
// 示例 1：
//
// 输入：["a==b","b!=a"]
//输出：false
//解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
//
//
// 示例 2：
//
// 输入：["b==a","a==b"]
//输出：true
//解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
//
//
// 示例 3：
//
// 输入：["a==b","b==c","a==c"]
//输出：true
//
//
// 示例 4：
//
// 输入：["a==b","b!=c","c==a"]
//输出：false
//
//
// 示例 5：
//
// 输入：["c==c","b==d","x!=z"]
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= equations.length <= 500
// equations[i].length == 4
// equations[i][0] 和 equations[i][3] 是小写字母
// equations[i][1] 要么是 '='，要么是 '!'
// equations[i][2] 是 '='
//
// Related Topics 并查集 图 数组 字符串
// 👍 217 👎 0


package leetcode.editor.cn;

public class SatisfiabilityOfEqualityEquations {
    public static void main(String[] args) {
        Solution solution = new SatisfiabilityOfEqualityEquations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean equationsPossible(String[] equations) {
            if (equations == null || equations.length < 1) {
                return false;
            }
            UnionFind unionFind = new UnionFind(26);

            for (String equation : equations) {
                if (equation.charAt(1) ==  '=') {
                    unionFind.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
                }
            }

            for (String equation : equations) {
                if (equation.charAt(1) ==  '!') {
                    boolean connected = unionFind.connected(equation.charAt(0) - 'a',
                            equation.charAt(3) - 'a');
                    if (connected) {
                        return false;
                    }
                }
            }

            return true;
        }


        class UnionFind {
            private int[] parent;
            private int[] weight;
            private int count;

            public UnionFind (int count){
                this.count = count;
                this.parent = new int[count];
                this.weight = new int[count];

                for (int i = 0; i < count; i++) {
                    parent[i] = i;
                    weight[i] = 1;
                }
            }

            public void union(int p, int q){
                int rootP = find(p);
                int rootQ = find(q);
                if (rootP == rootQ) {
                    return;
                }

                int weightP = weight[rootP];
                int weightQ = weight[rootQ];
                if (weightP > weightQ) {
                    parent[rootQ] = rootP;
                    weight[rootP] += weight[rootQ];
                } else {
                    parent[rootP] = rootQ;
                    weight[rootQ] += weight[rootP];
                }

                count--;
            }

            public int find(int x){
                while (x != parent[x]) {
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }

            public boolean connected(int p, int q){
                return find(p) == find(q);
            }

            public int getCount(){
                return this.count;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
