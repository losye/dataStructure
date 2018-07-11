题目描述
=======
输入一棵二叉树，判断该二叉树是否是平衡二叉树。

public class Solution {

    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null){
            return true;
        }
         if(Math.abs(TreeHeight(root.left) - TreeHeight(root.right)) <= 1) {
             return IsBalanced_Solution(root.left)
            && IsBalanced_Solution(root.right);
         }else{
        return false;
         }
    }
     public int TreeHeight(TreeNode root){
        if(root == null) {
            return 0;
        }
        return Math.max(TreeHeight(root.left),
                        TreeHeight(root.right)) + 1;
    }
    
}
