题目描述
============================
数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。

如果不存在则输出0。

public class Solution {

    public int MoreThanHalfNum_Solution(int [] array) {
       // int res = 0;
        if(array==null||array.length==0){
            return 0;
        }
        int count = 1;
        int temp = array[0];
        for(int i=1;i<array.length;i++){
            if(array[i]==temp){
                count++;
            }else{
                count--;
                if(count<1){
                    temp = array[i];
                    count=1;
                }
              //  count--;
            }
        }
        int num=0;
        for(int i=0;i<array.length;i++){
            if(array[i]==temp){
                num++;
            }
        }
        int len = array.length/2;
        if(num>len){
            return temp;
        }else{
        return 0;
   }
   
}

public class Solution2 {

	public static int getMoreThanHalf(int[] arr, int len){
		 int middle = len>>1;
		 int l = 0;
		 int r = len-1;
		 int index = Partition(arr, l, r);
		 while(index != middle){
			 if(index > middle){
				 index = Partition(arr, l, index-1);
			 }else{
				 index = Partition(arr, index+1, r);
			 }
		 }
		 return arr[middle];
	}
	public static int Partition(int[] arr, int l, int r){
		if(arr == null || arr.length < 1){
			return -1;
		}
		   int i = l, j = r, x = arr[l];  
	        while (i < j)  
	        {  
	            while(i < j && arr[j] >= x) // 从右向左找第一个小于x的数  
	                j--;    
	            if(i < j)   
	                arr[i++] = arr[j];  
	              
	            while(i < j && arr[i] < x) // 从左向右找第一个大于等于x的数  
	                i++;    
	            if(i < j)   
	                arr[j--] = arr[i];  
	        }  
	        arr[i] = x;  
		return i;
	}
}
解题思路：
====================
Solution1:因为一个数是超过一半的，类似于选一个候选数，如果与后面一个数相等则候选值+1，否则-1。

如果候选值为0时就换一个候选数。这种方法只遍历一遍数组，显然O(N)

Soultion2:其实对于数组第一反应是排序，但是排序似乎最快是O(N*lgN)啊。能不能更快？

利用快排的思想 此题也可以做到O(N)  因为无须全部排序完，至于时间复杂度为什么是O(N)详见算法导论。
