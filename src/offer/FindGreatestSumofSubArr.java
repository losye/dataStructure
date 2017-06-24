package offer;

/**
 * Created by losye
 * 连续子数组的最大和
 * 输入数组为{1,-2,3,10,-4,7,2,-5}
 * 最大子数组为{3,10,-4,7,2}
 */
public class FindGreatestSumofSubArr {

    //改变了源数组
    public static int[] solution(int[] arr, int len){
        if (arr == null || len<1){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = 0;
        int tmp = 0;
        //int res[] = new int[len];
       // res[0] = arr[0];
        for (int i=1; i<len; i++) {
            if (arr[i - 1] > 0) {
                arr[i] = arr[i - 1] + arr[i];
            } else {
                arr[i] = arr[i];
                tmp = i;
            }
            if (arr[i] > max) {
                max = arr[i];
                start = tmp;
                end = i;
            }
        }
        return new int[]{start,end};
    }
    //用一个变量记录目前的累加值
    public static int[] solution2(int[] arr, int len){
        if (arr == null || len<1){
            return null;
        }
        int max = Integer.MIN_VALUE;
        int cur = arr[0];
        int start = 0;
        int end = 0;
        int tmp = 0;
        for (int i=1; i<len; i++) {
            if (cur > 0){
                cur = cur + arr[i];
            }else {
                cur = arr[i];
                tmp = i;
            }
            if (cur > max){
                start = tmp;
                end = i;
                max = cur;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        int[] res = solution2(arr, arr.length);
        for (int i=0; i<res.length; i++){
            System.out.println(res[i]);
        }
    }
}

