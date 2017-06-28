package offer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by losye
 * 一个数组除了两个数字外，其他数字都出现了两次，请找出这两个数字
 */
public class FindNumApperOnce {
    /**
     * 联想到只有一个数字出现两次的，直接数组异或搞定
     * 同样的思路，只要把数组分成两部分，但这两个数不在同一个数组中即可
     * @param arr
     * @return
     */
    public static int[] solution(int[] arr){
        if (arr == null || arr.length<1){
            return null;
        }
        int tmp = arr[0];
        for (int i=1; i<arr.length; i++){
            tmp ^= arr[i];
        }
        int index = getIndexBit(tmp);
        List<Integer> bit0 = Arrays.asList();
        List<Integer> bit1 = Arrays.asList();
        for (int i=0; i<arr.length; i++){
            if (isBit(arr[i], index)){
                bit0.add(arr[i]);
            }else {
                bit1.add(arr[i]);
            }
        }
        int res1 = 0;
        for (int item : bit0){
            res1 ^= item;
        }
        int res2 = 0;
        for (int item : bit1){
            res2 ^= item;
        }
        return new int[]{res1, res2};
    }

    private static boolean isBit(int n, int index){
        n = n>>index;
        return (n&1)==0;
    }

    private static int getIndexBit(int n){
        int index = 0;
        while ((n&1) == 0){
            index ++;
            n = n>>1;
        }
        return index;
    }
}
