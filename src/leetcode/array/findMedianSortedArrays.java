package leetcode.array;

import java.util.Arrays;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-03 下午4:39
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 *  nums1 = [1, 3]
    nums2 = [2]
    The median is 2.0

   Example 2:
    nums1 = [1, 2]
    nums2 = [3, 4]
    The median is (2 + 3)/2 = 2.5
 */
public class findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] nums3 = new int[len];
        nums3 = merge(nums1, nums2);
        if (len%2 == 0){
            return (nums3[len/2-1]+nums3[len/2])/2.0;
        }
        return nums3[len/2];
    }



    private int[] merge(int[] nums1, int[] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i=0, j=0;
        int[] res = new int[len1+len2];
        int k = 0;
        while (i<len1 && j<len2){
            if (nums1[i]<=nums2[j]){
                res[k++] = nums1[i];
                i++;
            }else {
                res[k++] = nums2[j];
                j++;
            }
        }
        if (i == len1){
            while (j < len2){
                res[k++] = nums2[j];
                j++;
            }
        }else {
            while (i < len1){
                res[k++] = nums1[i];
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        double res = new findMedianSortedArrays().findMedianSortedArrays(new int[]{1,3,4,7}, new int[]{2,3,5,9});
        System.out.println(res);
    }
}
