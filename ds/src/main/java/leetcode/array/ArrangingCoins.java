package leetcode.array;

/**
 * ${DESCRIPTION}
 *
 * @author zhangzhengye
 * @create 2017-10-18 上午11:30
 *
 * You have a total of n coins that you want to form in a staircase shape,
 *
 * where every k-th row must have exactly k coins.

    Given n, find the total number of full staircase rows that can be formed.

    n is a non-negative integer and fits within the range of a 32-bit signed integer.

    Example 1:

    n = 5

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤

    Because the 3rd row is incomplete, we return 2.
    Example 2:

    n = 8

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤ ¤
    ¤ ¤

    Because the 4th row is incomplete, we return 3.
 */
public class ArrangingCoins {

    /**
     * math method
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }

    /**
     * target is to search for a factor k where k * (k+1) / 2 <= n
     * so using binary search
     * @param n
     * @return
     */
    public int arrangeCoins2(int n) {
        long nLong = (long)n;

        long st = 0;
        long ed = nLong;

        long mid = 0;

        while (st <= ed){
            mid = st + (ed - st) / 2;

            if (mid * (mid + 1) <= 2 * nLong){
                st = mid + 1;
            }else{
                ed = mid - 1;
            }
        }

        return (int)(st - 1);
    }
}
