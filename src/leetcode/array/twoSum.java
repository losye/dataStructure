package leetcode.array;

import java.util.HashMap;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-03 下午4:18
 *
 * Given an array of integers, return indices of the two numbers such
 *
 * that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution,
 *
 * and you may not use the same element twice.
 *
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,

    Because nums[0] + nums[1] = 2 + 7 = 9,

    return [0, 1].
 */
public class twoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{0, 0};
        if (nums.length < 2){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i =0; i<nums.length; i++){
            if (map.containsKey(target-nums[i])){
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
