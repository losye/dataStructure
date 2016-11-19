package neu.learning;
import java.util.Stack;

/**
 * 二叉搜索树的第k个结点
 * 
 * @author Administrator 给定一颗二叉搜索树，请找出其中的第k大的结点。 例如， 5 / \ 3 7 /\ /\ 2 4 6 8
 *         中，按结点数值大小顺序第三个结点的值为4。
 */
public class KthNode {
	public static void main(String[] args) {
			
	}

	public static TreeNode KthNode(TreeNode pRoot, int k) {
		if (pRoot == null || k < 1) {
			return null;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int count = 0;
		TreeNode KthNode = null;
		while (pRoot != null || !stack.isEmpty()) {
			while (pRoot != null) {
				stack.push(pRoot);
				pRoot = pRoot.left;
			}
			TreeNode node = stack.pop();
			count++;
			if(count==k){
				KthNode = node;
			}
			//System.out.println(node.val);			
			pRoot = node.right;			
		}
		return KthNode;

	}
}
