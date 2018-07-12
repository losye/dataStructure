package offer;

/**
 * Created by losye
 * 在二维数组中查找指定数字
 * 每一行从左到右递增排序，每一列从上到下有序排序
 */
public class FindInArr {

    //O(Min(arr.length,arr[].length))
    public static boolean Solution(int[][] arr, int find) {
        if (arr == null || arr.length < 1 || arr[0].length < 1) {
            return false;
        }
        int i = arr.length - 1;
        int j = 0;
        boolean result = false;
        while (i >= 0 && j < arr[0].length) {
            if (arr[i][j] < find) {
                j++;
            } else if (arr[i][j] > find) {
                i--;
            } else {
                result = true;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 3, 6},
                {2, 4, 9},
                {5, 7, 10}};
        System.out.println("find 1 : " + Solution(arr, 1));
        System.out.println("find 4 : " + Solution(arr, 4));
        System.out.println("find 8 : " + Solution(arr, 8));
        System.out.println("find 10 : " + Solution(arr, 10));
        System.out.println("find 5 : " + Solution(arr, 5));
    }
}
