package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by losye
 * 0,1,..n-1 n 个数排成一个圈，每次从圈中除去第m个数字，求圆圈最后剩下的数字
 *
 */
public class LastRemaining {
    public static int solution(int n, int m){
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<n; i++){
            list.add(i+1);
        }
        int index = -1;
        while (list.size() > 1){
            index = (index + m) % list.size();
            list.remove(index);
            index--;
        }
        return list.get(0);
    }

    public static int solution2(int n, int m){
        return 0;
    }

    public static void main(String[] args) {
        int res = solution(5,3);
        System.out.println(res);
    }
}
