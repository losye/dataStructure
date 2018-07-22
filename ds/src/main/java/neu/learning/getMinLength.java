package neu.learning;

/**
 * 需要排序的最短子数组长度
 *
 * @author Administrator
 * 如 arr=[1,5,3,4,2,6,7] 返回4 因为只有[5,3,4,2]需要排序
 */
public class getMinLength {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2, 7, 8, 6};
        System.out.println(getMinLength(arr));
    }

    public static int getMinLength(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int length = arr.length;

        int min = arr[length - 1];
        int noMinIndex = -1;
        for (int i = length - 2; i >= 0; i--) {
            if (arr[i] > min) {
                noMinIndex = i;
            } else {
                min = Math.min(min, arr[i]);
            }
        }
        if (noMinIndex == -1) {
            return 0;
        }

        int max = arr[0];
        int noMaxIndex = -1;
        for (int i = 1; i < length; i++) {
            if (arr[i] < max) {
                noMaxIndex = i;
            } else {
                max = Math.max(max, arr[i]);
            }
        }
        return noMaxIndex - noMinIndex + 1;
    }
}
