package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-15 下午2:27
 *
 * Find the contiguous subarray within an array (containing at least one number)
 *
 * which has the largest sum.

    For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
    the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 */
public class maxSubArray {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i=0; i<nums.length; i++){
            cur = cur + nums[i];
            max = Math.max(max, cur);
            if (cur < 0){
                cur = 0;
            }

        }
        return max;
    }
}
