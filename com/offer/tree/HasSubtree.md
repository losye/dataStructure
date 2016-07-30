题目描述
========================
输入两颗二叉树A，B，判断B是不是A的子结构

public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;


    public TreeNode(int val) {
        this.val = val;
    }
  }
  
  public class Solution {
  
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
         if(root2==null){
            return false;
        }
         if(root1==null ) {
            return false;
        }
        boolean flag = false;
        flag = IsSubtree(root1,root2);
        if(!flag){
            flag = HasSubtree(root1.left, root2);
            if(!flag){
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }
    
    private boolean IsSubtree(TreeNode root1,TreeNode root2){
        if(root2==null){
            return true;
        }
        if(root1==null ) {
            return false;
        }
        if(root1.val==root2.val){
            return IsSubtree(root1.left, root2.left)&&
                IsSubtree(root1.right, root2.right);
        }
        return false;
    }
}

解题思路
===============
如果B是A的子结构，那么首先B的根节点一定与B树中某一个节点相同。

接下来以这个相同的节点作为出发点，分别判断它的左右子树是否都相等。

其中IsSubtree就是在做这个事情，而HasSubtree是在遍历B树

对于树的问题通常递归方法显得简单。
