package neu.learning;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class GetLeastNumbers {
	public static void main(String[] args) {

	}

	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		if (input == null || input.length < k || k==0) {
			return (ArrayList<Integer>) Collections.EMPTY_LIST;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>();
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
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			list.add(it.next());
		}
		return list;
	}
}
