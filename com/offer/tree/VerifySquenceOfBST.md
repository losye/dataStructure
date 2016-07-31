题目描述
==========================
输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。

假设输入的数组的任意两个数字都互不相同。

import java.util.Arrays;

public class Solution {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return false;
        }
        int length = sequence.length;
        int root = sequence[length-1];
        int i=0;
        for(;i<sequence.length-1;i++){
            if(sequence[i]>root){
                break;
            }
        }
        int j=i;
        for(;j<sequence.length-1;j++){
            if(sequence[j]<root)
                return false;
        }
        boolean leftTree=true;
        boolean rightTree=true;
        if(i>0){
            leftTree=VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        }
        if(i<sequence.length-1)
            rightTree=VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length-1));
        return (leftTree&&rightTree);
    }
}

解题思路
==============
后序遍历 ： 根节点为arr[len-1]

搜索树 ：左小右大

划分出左右子树后就可以递归了

