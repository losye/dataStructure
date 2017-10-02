package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-02 下午4:14
 *
 * Given a non-negative integer, you could swap two digits
 *
 * at most once to get the maximum valued number.
 *
 * Return the maximum valued number you could get.
 *
 * Example 1:
 *
    Input: 2736
    Output: 7236
    Explanation: Swap the number 2 and the number 7.

    Example 2:
    Input: 9973
    Output: 9973
    Explanation: No swap.
 */
public class maximumSwap {

    public int maximumSwap(int num) {
        char[] arr  = String.valueOf(num).toCharArray();
        //找到第一个数 这个数比它前一位大 find i where arr[i+1] > arr[i]
        int firstPos = -1;
        for (int i=0; i<arr.length-1; i++){
            if (arr[i]<arr[i+1]){
                firstPos = i+1;
                break;
            }
        }
        if (firstPos == -1){
            return num;
        }
        //这时数组被分为2部分 后部分里找到最大值
        int maxPos = firstPos;
        char max = arr[firstPos];
        for (int i=firstPos+1; i<arr.length; i++){
            if (arr[i] > max){
                maxPos = i;
                max = arr[i];
            }
        }
        //最大值和前部分里第一个小于这个值做交换
        for (int i=0; i<firstPos; i++){
            if (arr[i] < max){
                arr[maxPos] = arr[i];
                arr[i] = max;
                break;
            }
        }
        return Integer.parseInt(new String(arr));
    }

    public static void main(String[] args) {

        int res = new maximumSwap().maximumSwap(9937);
        System.out.println(res);
    }
}
