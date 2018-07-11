package offer;

/**
 * Created by losye
 */
public class MoreThanHalfNum {
    public static int moreThanHalf(int[] arr){
        int times = 1;
        int res = arr[0];
        for (int i=1; i<arr.length; i++){
            if (times == 0){
                times = 1;
                res = arr[i];
            }else if (res == arr[i]){
                times++;
            }else {
                times--;
            }
        }
        return res;
    }
}
