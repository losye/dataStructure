题目描述
=============================
输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。

路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。

import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    
    public TreeNode(int val) {
        this.val = val;
    }
  }
  
  public class Solution {
  
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target){
        ArrayList<ArrayList<Integer>> pathList=
                new ArrayList<ArrayList<Integer>>();
        if(root==null){
            return pathList;
        }
        Stack<Integer> stack = new Stack<Integer>();
        FindPath(root,target,stack,pathList );
        return pathList;
    }
    
    private void FindPath(TreeNode root, int target,
            Stack<Integer> path,
            ArrayList<ArrayList<Integer>> pathList) {
        if(root==null)
            return;
        if(root.left==null&&root.right==null){
            if(root.val==target){
                ArrayList<Integer> ValList=
                        new ArrayList<Integer>();
                for(int i:path){
                    ValList.add(i);
                }
                ValList.add(root.val);
                pathList.add(ValList);
            }
        }
        else{
            path.push(new Integer(root.val));
            FindPath(root.left, target-root.val, path, pathList);
            FindPath(root.right, target-root.val, path,  pathList);
            path.pop();
        }
         
    }
}


解题思路
=============
递归！！！如果从根节点出发能完成，左右子树一定能完成。

问题是如果值大于固定和时如何返回上一级节点，一种方法就是hold node，保存上级节点。

整个过程类似于前序遍历
