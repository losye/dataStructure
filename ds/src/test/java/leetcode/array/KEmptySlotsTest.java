package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author: zhengye.zhang
 * @Description:
 * @Date: 2018/7/17 下午9:50
 */
class KEmptySlotsTest {

    @Test
    void kEmptySlots() {
        assertEquals(KEmptySlots.kEmptySlots(new int[]{1, 3, 4, 5 ,2}, 2), 3);
    }
}