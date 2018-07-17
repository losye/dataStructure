package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author: zhengye.zhang
 * @Description:
 * @Date: 2018/7/17 下午8:34
 */
class findLengthOfLCISTest {


    @Test
    void findLengthOfLCIS() {
        assertTrue(FindLengthOfLCIS.findLengthOfLCIS(new int[]{1,3,5,4,7}) == 3);
    }

    @Test
    void findLengthOfLCIS2() {
        assertTrue(FindLengthOfLCIS.findLengthOfLCIS2(new int[]{1,3,5,4,7}) == 3);
    }
}