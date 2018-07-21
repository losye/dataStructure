package neu.learning;

import java.util.ArrayList;
import java.util.Collections;

//判断是否是顺子
public class Continuous {

    public static void main(String[] args) {

    }

    public static boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 5) {
            return false;
        }
        int jokers = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                jokers++;
            } else {
                list.add(numbers[i]);
            }
        }
        if (jokers > 4) {
            return false;
        }
        Collections.sort(list);
        if (Math.abs(list.get(0) - list.get(list.size() - 1)) > 4) {
            return false;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
