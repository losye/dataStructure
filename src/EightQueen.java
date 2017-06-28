/**
 * Created by Administrator on 2017/6/28.
 * 8皇后问题
 */
public class EightQueen {
    public int[][] chess = new int[8][8];    //棋盘，放皇后
    public int solution;

    /**
     *
     * @param i 行
     */
    public void find(int i){    //寻找皇后节点
        //超过8行表示满足条件
        if(i>7){    //八皇后解
            solution++;
            return;
        }
        for(int m=0;m<8;m++){       //深度优先,递归算法
            if(rule(chess,i,m)){
                chess[i][m]=1;
                find(i+1);
                chess[i][m]=0;
            }
        }
    }

    /**
     *
     * @param chess 棋盘
     * @param k 行
     * @param j  列
     * @return
     */
    private  boolean rule(int chess[][],int k,int j){    //判断节点是否合适
        for(int i=0;i<8;i++){       //行列冲突
            if(chess[i][j]==1)
                return false;
        }
        for(int i=k-1,m=j-1;i>=0&&m>=0;i--,m--){    //左对角线
            if(chess[i][m]==1)
                return false;
        }
        for(int i=k-1,m=j+1;i>=0&&m<=7;i--,m++){    //右对角线
            if(chess[i][m]==1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        EightQueen eq = new EightQueen();
        eq.find(0);
        System.out.println(eq.solution);
    }
}
