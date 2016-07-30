题目描述
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。 

输入描述:
array： 待查找的二维数组
target：查找的数字

public class Solution {
    public boolean Find(int [][] array,int target) {
        //从左下角开始找
		int row = array.length-1;
        int i=0;
        while(row >= 0 && i<array[0].length){
           	if(target > array[row][i]){
                i++;
            }
            else if(target < array[row][i]){
                row--;
            }
            else{
                return true;
            }
        }
     	return false;
    }
}

从代码中可以分析出，利用已知条件。时间复杂度从原来的暴力O(M*N)降到O(Math.max(M,N))

