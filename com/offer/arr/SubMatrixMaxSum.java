package cn.newcoder.arr;

import org.junit.Test;

/**
 * 给定一个无序矩阵，其中有正，有负，有0，求子矩阵的最大和
 * @author zzy
 * 类似求无序数组中求子数组最大和
 * 采用暴力解时间复杂度O(N^2)*O(N^2)*O(N^2)
 * 利用算法原形时间复杂度为O(N^3)
 */
public class SubMatrixMaxSum {
	public int maxSum(int[][] m) {
		if (m == null || m.length == 0 || m[0].length == 0) {
			return 0;
		}
		int res = Integer.MIN_VALUE;
		int[] temp = null;
		int cur = 0;
		for(int i=0; i<m.length; i++){
			temp = new int[m[0].length];
			for(int j=i; j<m.length; j++){
				 cur = 0;
				for(int k=0; k<m.length; k++){
					temp[k] += m[j][k];
					cur += temp[k];
					res = Math.max(res, cur);
					cur = cur<0 ? 0 : cur;
				}
			}
		}
		return res;
	}
	
	@Test
	public void test(){
		int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
		System.out.println(maxSum(matrix));

	}
}

