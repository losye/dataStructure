package offer;

/**
 * Created by losye
 * 前序遍历{1,2,4,7,3,5,6,8} 中序遍历{4,7,2,1,5,3,8,6}
 * 请重建二叉树，并输出头节点
 */
public class RebuildTree {
    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static TreeNode rebuild(int[] pre, int[] in){
        TreeNode root = new TreeNode(pre[0]);
        
        return root;
    }
}
