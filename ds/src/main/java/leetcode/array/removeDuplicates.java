package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-03 下午7:32
 *
 * Given a sorted array, remove the duplicates in place such that each element appear
 *
 * only once and return the new length.
 *
 * Do not allocate extra space for another array,
 *
 * you must do this in place with constant memory.
 *
 *
 * For example,
 *
 * Given input array nums = [1,1,2],
 *
 * Your function should return length = 2,
 *
 * with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the new length.
 */
public class removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2){
            return nums.length;
        }
        int res = 0;
        for (int i=0; i<nums.length; i++){
            if (nums[i] != nums[res]){
                /**
                 * 记录前一个值是多少，和后一次循环的值做比较
                 * example : 1,1,1,4,4,5
                 *           1,4,1,4,4,5 res = 1 i = 3
                 *          nums[res] = 4 ==  nums[4]
                 */
                nums[++res] = nums[i];
            }
        }
        return ++res;
    }

    public static void main(String[] args) {
        //int res = new removeDuplicates().removeDuplicates(new int[]{4 ,5, 5, 5 ,5 ,5});
        int res = new removeDuplicates().removeDuplicates(new int[]{1,1,1,1,1,4});
        System.out.println(res);
        String a = "s";
        switch (a){
            case "as":
                break;
            case "as1":
        }
    }
}
