题目
=======
给定一个非负数的数组，数组中的每个值代表一个柱子的高度，柱子的宽度是 1。两个柱

子之间可以围成一个面积，规定：面积＝两根柱子的最小值＊两根柱子之间的距离。比如数

组[3,4,2,5]。3 和 4 之间围成的面积为 0，因为两个柱子是相邻的，中间没有距离。3 和

2 之间围成的面积为 2，因为两个柱子的距离为 1，且 2 是最短的柱子，所以面积＝1*2。

求在一个数组中，哪两个柱子围成的面积最大，并返回值。


public class BarProblem {

        	public static int maxArea1(int[] arr) {
		            if (arr == null || arr.length < 3) {
			                return 0;
		             }
		           int res = Integer.MIN_VALUE;
        		   for (int i = 0; i < arr.length - 2; i++) {
                			for (int j = i + 2; j < arr.length; j++) {
				                    res = Math.max(res, (j - i - 1) * Math.min(arr[i], arr[j]));
          			      }
           		}
          		    return res;
           	}

          	public static int maxArea2(int[] arr) {
		              if (arr == null || arr.length < 3) {
                  			return 0;
		               }
		              int l = 0;
              		int r = arr.length - 1;
		              int res = Integer.MIN_VALUE;
              		while (l < r) {
                 			if (arr[l] < arr[r]) {
                    				res = Math.max(res, (r - l - 1) * arr[l++]);
                 			} else {
                    				res = Math.max(res, (r - l - 1) * arr[r--]);
			                 }
              		}
             		return res;
         	}  

	}

方法1显然是暴力解，不满足时间复杂度

方法2是这样做的，考虑一个问题，分别得到arr[0],arr[len-1]后，

两边往里缩，也就是筛选的过程中只要不错过这个最大值就可以了，无需把所有可能的值都求出来。

那如何才能不错过这个最优值呢？ 在缩的过程中，长度是在减少的，所以我要保证两边的最小值增大，那一定是将较小值那边往里缩才对。

因为你如果缩较大的值，那么长度减小，两边的基数只会减小，最优情况也是不变，所以res只会越来越小。
