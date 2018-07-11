package offer;

/**
 * Created by losye
 * 得到最小的k个数
 */
public class LeastNumber {
    private static int partition(int[] arr, int start , int right){
        int i = start;
        int j = right;
        int tmp = arr[i];
        if (i < j){
            while (i < j && tmp <= arr[j]){
                j--;
            }
            arr[i] = arr[j];
            while (i < j && tmp > arr[i]){
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = tmp;
        return i;
    }

    public static int[] getLeastKNumber(int[] arr, int length, int k){
        if (arr.length < k){
            return null;
        }
        int start= 0;
        int end = length-1;

        int index = partition(arr, start, end);
        while (index != k){
            if (index > k){
                index = partition(arr, start, index-1);
            }else {
                index = partition(arr, index+1, end);
            }
        }
        int[] res = new int[k];
        for (int i=0; i<k; i++){
            res[i] = arr[i];
        }
        return  res;

    }

    public static void main(String[] args) {
        int[] arr = {1,4,6,3,5,8,12,5,2,7};
        int[] leastKNumber = getLeastKNumber(arr, arr.length, 4);
        for (int i=0; i<leastKNumber.length; i++){
            System.out.print(leastKNumber[i] + " ");

        }

    }


}
