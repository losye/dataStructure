package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-14 下午11:17
 * Given an array with n objects colored red, white or blue,
 *
 * sort them so that objects of the same color are adjacent,
 *
 * with the colors in the order red, white and blue.

    Here, we will use the integers 0, 1, and 2 to

    represent the color red, white, and blue respectively.

    Note:
    You are not suppose to use the library's sort function for this problem.
 */
public class sortColors {

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int index = 0;
        while (index < right){
            if (nums[index] == 0 ){
                nums[index] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[index] == 2){
                nums[index] = nums[right];
                nums[right] = 2;
                right--;
                //换过了的数还要排序
                index--;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        new sortColors().sortColors(new int[]{2,0,1,2,2,1,1,1,0,0,0,0,2,1,2});
    }
}
