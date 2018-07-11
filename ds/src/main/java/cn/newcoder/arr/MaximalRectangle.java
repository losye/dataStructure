package cn.newcoder.arr;

import java.util.Stack;

import org.junit.Test;
/**
 * 给定一个无序数组，其中只有0和1，求只含有1的最大子矩阵大小。	
 * @author zzy
 *
 */
public class MaximalRectangle {
	public int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int maxArea = 0;
		int[] height = new int[map[0].length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				//求当前行及之前行的高度(若当前列为0则为0否则累加之前的高度)
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			maxArea = Math.max(maxArea, maxRecFromBottom(height));
		}
		return maxArea;
	}

	public int maxRecFromBottom(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int maxArea = 0;
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < height.length; i++) {
			//如果当前数小于等于栈顶元素，pop出栈顶，结算栈顶元素的最大范围
			//因为当前数小于栈顶元素，所以当前数是栈顶的右边界，而弹出后的栈顶是左边界
			while (!stack.isEmpty() && height[i] <= height[stack.peek()]) {
				int j = stack.pop();
				int k = stack.isEmpty() ? -1 : stack.peek();
				int curArea = (i - k - 1) * height[j];
				maxArea = Math.max(maxArea, curArea);
			}
			//如果当前数大于栈顶元素，则push进去
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int j = stack.pop();
			int k = stack.isEmpty() ? -1 : stack.peek();
			int curArea = (height.length - k - 1) * height[j];
			maxArea = Math.max(maxArea, curArea);
		}
		return maxArea;
	}

	@Test
	public void test() {
		int[][] map = { { 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 0 }, };
		System.out.println(maxRecSize(map));
	}
}
