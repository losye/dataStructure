package neu.learning;
/**
 * 数组中未出现的最小正整数
 * @author Administrator
 * arr=[-1,2,3,4]  返回 1
 * arr=[1,2,3,4]  返回5
 */
public class MissPosNum {
	public static void main(String[] args) {
		//int[] arr = {1,2,3,4};
		int[] arr = {-1,2,3,4};
		System.out.println(missNum(arr));
	}
	
	public static int missNum(int[] arr){
		if(arr==null||arr.length==0){
			return 0;
		}
		int l = 0; //目前已收集  1 ~ l 上的数
		int r = arr.length; // 后续最优的情况下 能收集  1 ~ r 上的数
		while(l<r){
			if(arr[l]==l+1){
				l++;
			}else if(arr[l]<l || arr[l]>r || arr[arr[l]-1]==arr[l] ){
				r--;
			}else{
				swap(arr,l,arr[l]-1);
			}
		}
		return l+1;
	}
	
	public static void swap(int[] arr, int low, int high){
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
	}
}
