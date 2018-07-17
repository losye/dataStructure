package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhengye.zhang
 * @Description:
 * @Date: 2018/7/17 下午8:51
 */
class FindMedianSortedArraysTest {

    @Test
    void findMedianSortedArrays() {
        assertEquals(FindMedianSortedArrays.findMedianSortedArrays(new int[]{1, 3, 4, 7}, new int[]{2, 3, 5, 9}), 3.5);
    }

    @Test
    void findMedianSortedArrays2() {
        assertEquals(FindMedianSortedArrays.findMedianSortedArrays2(new int[]{1, 3, 4, 7}, new int[]{2, 3, 5, 9}), 3.5);
    }
}