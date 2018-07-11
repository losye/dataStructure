package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-09-30 下午4:18
 *
 * Given an unsorted array of integers,
 * find the length of longest continuous increasing subsequence.
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 */
public class findLengthOfLCIS {

    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for(int i=1; i<len; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = 1;
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
}
