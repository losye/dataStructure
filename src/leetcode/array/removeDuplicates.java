package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-03 下午7:32
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
    }
}
