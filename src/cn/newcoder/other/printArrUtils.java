package cn.newcoder.other;

public class printArrUtils {
	public static void showArr(int[] arr){
		if(arr == null || arr.length<0){
			return;
		}
		for(int item : arr){
			System.out.print(item + " ");
		}
		System.out.println();
	}
}
