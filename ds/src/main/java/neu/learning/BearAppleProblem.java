package neu.learning;

import java.util.Scanner;

public class BearAppleProblem {

    public static void main(String[] args) {
        int bear = 1;
        int apples = 1;
        int onceNum = 1;
        Scanner s = new Scanner(System.in);
        int num = s.nextInt();
        if (num <= 1 || num >= 9) {
            System.out.println("wrong input");
            return;
        }
        while (bear <= num) {
            if (onceNum % 5 == 1 && onceNum / 5 != 0) {
                onceNum = (onceNum / 5) * 4;
                bear++;
            } else {
                apples++;
                onceNum = apples;
                bear = 1;
            }
        }
        System.out.println(apples);
    }
}
