package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-05 下午12:02
 *
 * Given an array of integers sorted in ascending order,
 *
 * find the starting and ending position of a given target value.

    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].

    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
    return [3, 4].
 */
public class searchRange {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 2){
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length;

        int first = search(nums, left, right, target);
        int second = -1;
        if (first == -1){
            return new int[]{-1, -1};
        }else {
            if (nums[first-1] == target){

                second = first;
                first = first-1;
            }
            if (nums[first+1] == target){
                second = first+1;
            }
        }
        return new int[]{first, second};
    }

    private int search(int[] nums, int left, int right, int target){
        while (left < right){
            int mid = (left+right)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                right = mid;
            }else {
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] res = new searchRange().searchRange(new int[]{5,7,7,8,8,10,12,13,15,17}, 8);
        System.out.println(res[0] + " " + res[1]);
    }
}
