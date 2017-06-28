package cn.newcoder.tree;

/**
 * Created by Administrator on 2017/6/13.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的
 */
public class IsSymmetrical {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    boolean isSymmetrical(TreeNode pRoot)
    {
        return isSymmetric(pRoot,pRoot);
    }
    boolean isSymmetric(TreeNode root1,TreeNode root2){
        if(root1==null && root2==null)
            return true;
        if(root1==null || root2==null)
            return false;
        if(root1.val!=root2.val)
            return false;
        return isSymmetric(root1.left,root2.right)&&isSymmetric(root1.right,root2.left);
    }
}
