package neu.learning;
import java.util.HashMap;

/*
 * 在未排序数组中 找到和为k的最长子数组长度
 */
public class getMaxLength {
	public static void main(String[] args) {
		
	}
	
	public static int maxLength(int[] arr, int k){
		if(arr==null || arr.length==0){
			return 0;
		}
		//这个map表示key第一次出现在value下标的位置
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		map.put(0, -1); //表示 合为0 第一次出现在-1位置
		int len = 0;
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
			if(map.containsKey(sum-k)){
				len = Math.max(i-map.get(sum-k),len);
			}
			if(!map.containsKey(sum)){
				map.put(sum, i);
			}
		}
		return len;
	}
}
