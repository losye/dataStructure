package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-04 上午9:31
 *
 * 递增数组旋转
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index,
 *
 * otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * 12345678    34567812     12345678  78123456
 *
 * 其实只要找到旋转的位置，就很好解，但是找不到好的方法去找个这个位置
 */
public class search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if (target == nums[mid]){
                return mid;
            }
            //这时只有2种情况，mid在前半部分或者在后半部分
            if (nums[left] <= nums[mid]){
                //注意只是局部有序的
                if (nums[mid] > target && nums[left] <= target){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }
            //后半部分
            if (nums[right] >= nums[mid]){
                if (nums[mid] < target && nums[right]>=target){
                    left = mid+1;
                }else {
                    right = mid-1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int res = new search().search(new int[]{3,4,5,6,7,8,1,2}, 4);
        System.out.println(res);
    }
}
