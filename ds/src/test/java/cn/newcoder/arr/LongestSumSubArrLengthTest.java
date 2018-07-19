package cn.newcoder.arr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: zhengye.zhang
 * @Description:
 * @Date: 2018/7/19 上午10:30
 */
class LongestSumSubArrLengthTest {

    @Test
    void getMaxLen() {
        assertEquals(LongestSumSubArrLength.getMaxLen(new int[]{1,1,1,2,1,4}, 4), 3);
    }
}