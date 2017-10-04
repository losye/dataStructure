package leetcode.array;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-04 上午9:29
 *
 * Given an array and a value, remove all instances of that value in place and
 *
 * return the new length.
 *
 * Do not allocate extra space for another array,
 *
 * you must do this in place with constant memory.
 *
 * The order of elements can be changed.
 *
 * It doesn't matter what you leave beyond the new length.

    Example:
    Given input array nums = [3,2,2,3], val = 3
    Your function should return length = 2, with the first two elements of nums being 2.
 */
public class removeElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int res = 0;
        for (int i=0; i<len; i++){
            if (nums[i] != val){
                nums[res++] = nums[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //int res = new removeElement().removeElement(new int[]{3,2,2,3}, 3);
        int res = new removeElement().removeElement(new int[]{2,2,2,3,1,2}, 2);

    }
}
