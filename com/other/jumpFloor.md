题目描述
=================================
一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。

public class Solution {

    public int JumpFloor(int target) {
        if(target<1){
          return 0;
        }
        if(target==1||target==2){
            return target;
        }
        //return JumpFloor(target-1)+JumpFloor(target-2);
        int res = 2;
        int pre = 1;
        int temp =0;
        for(int i=3;i<=target;i++){
            temp = res ;
            res = temp + pre;
            pre = temp;
        }
        return res;
    }
    
}

解题思路
==================
此题类似于斐波那契数列，要跳上n级，可以从n-1跳一阶，也可以从n-2跳2阶。

所以利用递归很容易写出来，而上面将递归解法注释了。递归时间复杂度O(2^n)

利用非递归解,从左到右依次求出每一项的值，时间复杂度降到O(N)

当然还有大招可以降到时间复杂度O(lgN) 

如果递归公式严格遵循 F(N) = F(N-1) + F(N-2) 那么一定可以用矩阵乘法形式表示。
时间复杂度就转化为如何快速求一个矩阵的N次方了。



