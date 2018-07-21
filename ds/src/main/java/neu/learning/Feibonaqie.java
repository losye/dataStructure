package neu.learning;

public class Feibonaqie {

    public static void main(String[] args) {

        System.out.println(f1(5));

    }

    // O(2^n)
    public static int f1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return f1(n - 1) + f1(n - 2);
    }

    // O(N)
    public static int f2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int res = 1;
        int pre = 1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }
        return res;
    }

    /**
     * 如果严格遵循 : F(N) = F(N-1) + F(N-2)
     * 那么 (F(n),F(n-1)) = (F(N-1),F(N-2))*|a b|
     * |c d|
     *
     * @param n
     * @return
     */
    //O(logn)
    public static int f3(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[][] base = {{1, 1}, {1, 0}};
        int[][] res = matrixPower(base, n - 2);
        return res[0][0] + res[1][0];
    }

    public static int[][] matrixPower(int[][] m, int p) {
        int[][] res = new int[m.length][m[0].length];
        // 单位矩阵
        for (int i = 0; i < res.length; i++) {
            res[i][i] = 1;
        }
        int[][] temp = m;
        // 75的二进制1001011
        for (; p != 0; p >>= 1) {
            if ((p & 1) != 0) {
                res = muliMatrix(res, temp);
            }
            temp = muliMatrix(temp, temp);
        }
        return res;
    }

    // 两矩阵相乘
    public static int[][] muliMatrix(int[][] m1, int[][] m2) {
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m2[0].length; i++) {
            for (int j = 0; j < m1.length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return res;
    }

}
