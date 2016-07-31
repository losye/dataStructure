题目描述
==============
把只包含因子2、3和5的数称作丑数（Ugly Number）。

例如6、8都是丑数，但14不是，因为它包含因子7。 习惯上我们把1当做是第一个丑数。

求按从小到大的顺序的第N个丑数。

public class Solution {

    public int GetUglyNumber_Solution(int index) {
        if(index<=0){
            return 0;
        }
        if(index<=5){
            return index;
        }
        int[] array= new int[index];
        array[0]=1;
        array[1]=2;
        array[2]=3;
        array[3]=4;
        array[4]=5;
         
        for(int i=5;i<index;i++)
        {
            int min=0;
            int min2=0,min3=0,min5=0;
            int temp=0;
            //找到已知的丑数的2倍的数，且该数比已知最大丑数大。
            for(int j=0;j<i;j++)
            {
                temp=array[j]*2;
                if(temp>array[i-1]){
                  min2=temp;
                  break;
                }
            }
            //同上，3倍
            for(int j=0;j<i;j++)
            {
                temp=array[j]*3;
                if(temp>array[i-1]){
                  min3=temp;
                  break;
                }
            }
            //同上，5倍
            for(int j=0;j<i;j++)
            {
                temp=array[j]*5;
                if(temp>array[i-1]){
                  min5=temp;
                  break;
                }
            }
            min = Math.min(Math.min(min2,min3),min5);
            array[i] = min;           
        }
        return array[index-1];
    }
}

解题思路
===============
显然来个while(n<index) if(isUgly) index++; 很轻松能完成，但是时间复杂度肯定达不到要求

另一个想法：丑数是前一个丑数*2*3*5的结果。所以利用空间换时间的方法，这也是通常的DP思想。





