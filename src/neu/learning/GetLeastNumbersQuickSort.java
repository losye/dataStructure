package neu.learning;
import java.util.ArrayList;

/**
 * GetLeastNumbers_Solution
 * @author Administrator
 *
 */
public class GetLeastNumbersQuickSort {
	public static void main(String[] args) {
		
	}
	public static ArrayList  GetLeastNumbers_Solution(int[] arr, int k){
		if(arr==null || arr.length==0 || arr.length<k || k<=0){
			return new ArrayList<Integer>();
		}
		int low = 0;
		int high = arr.length-1;
		int index = Partition(arr,k,low,high);
		while(index != k-1){   //index of k-1 is numof k
			if(index > k-1){
				low = index+1;
				index = Partition(arr,k,low,high);
			}else{
				high = index-1;
				index = Partition(arr,k,low,high);
			}
		}
		ArrayList list = new ArrayList<Integer>();
		for (int i = 0; i < k; i++)
            list.add(arr[i]);
        return list;	
	}
	
	public static int Partition(int[] arr, int k, int low, int high){
		if(arr==null || arr.length==0 || arr.length<k || k<=0){
			return 0;
		}
		int temp = arr[k-1];
		swap(arr,low,k-1);
		while(low < high){
			while(low<high && arr[high]>=temp){
				high--;
			}
			swap(arr,low,high);
			while(low<high && arr[low]<temp	){
				low++;
			}
			swap(arr,low,high);
		}
		return low;
	}
	
	public static void swap(int[] arr, int low, int high){
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
