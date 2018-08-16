package neu.learning;

public class MoreThanHalf {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(getMoreThanHalf(arr, arr.length));
    }

    public static int getMoreThanHalf(int[] arr, int len) {
        int middle = len >> 1;
        int l = 0;
        int r = len - 1;
        int index = partition(arr, l, r);
        while (index != middle) {
            if (index > middle) {
                index = partition(arr, l, index - 1);
            } else {
                index = partition(arr, index + 1, r);
            }
        }
        return arr[middle];
    }

    public static int partition(int[] arr, int l, int r) {
        if (arr == null || arr.length < 1) {
            return -1;
        }
        int i = l, j = r, x = arr[l];
        while (i < j) {
            while (i < j && arr[j] >= x) // 从右向左找第一个小于x的数
                j--;
            if (i < j)
                arr[i++] = arr[j];

            while (i < j && arr[i] < x) // 从左向右找第一个大于等于x的数
                i++;
            if (i < j)
                arr[j--] = arr[i];
        }
        arr[i] = x;

        return i;
    }
}
