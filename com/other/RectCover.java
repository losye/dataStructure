/**
 * Created by Administrator on 2017/7/28.
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。

 请问用n个 21 的小矩形无重叠地覆盖一个2n的大矩形，总共有多少种方法？
 */
public class RectCover {

    public static int solution(int n){
        if (n < 1){
            return -1;
        }
        if (n == 1){
            return 1;
        }
        if (n ==2){
            return 2;
        }
        return solution(n-1) + solution(n-2);

    }

}
