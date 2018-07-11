package neu.learning;
import java.util.Scanner;
public class BearAppleProbleam {
	public static void main(String[] args) {
		int bear = 1;
		int apples = 1;
		int oncenum = 1;
		Scanner s = new Scanner(System.in);
		int num = s.nextInt();
		if (num <= 1 || num >= 9) {
			System.out.println("wrong input");
			return;
		}
		while (bear <= num) {
			if (oncenum % 5 == 1 && oncenum / 5 != 0) {
				oncenum = (oncenum / 5) * 4;
				bear++;
			} else {
				apples++;
				oncenum = apples;
				bear = 1;
			}
		}
		System.out.println(apples);
	}
}
