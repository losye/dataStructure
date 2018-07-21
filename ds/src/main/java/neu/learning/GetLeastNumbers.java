package neu.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * 给到一个无序数组, 和一个k值
 * 得到排序后的前k个的数
 */
public class GetLeastNumbers {
    public static void main(String[] args) {

    }

    public List<Integer> solution(int[] input, int k) {
        if (input == null || input.length < k || k == 0) {
            return Collections.emptyList();
        }
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < input.length; i++) {
            if (set.size() < k) {
                set.add(input[i]);
            } else {
                if (input[i] < set.last()) {
                    set.remove(set.last());
                    set.add(input[i]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
