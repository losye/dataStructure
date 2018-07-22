package neu.learning;

public class huiwen {
    public static void main(String[] args) {
        String str = "fsdfdsklhvxcjmfpoupedsjdkgfiuew";
        //test(str);
        System.out.println(ishuiwen("abcdba"));
    }

    public static void test(String str) {
        int[] a = new int[26];
        for (int i = 0; i < str.length(); i++) {
            a[(str.charAt(i) - 97)] += 1;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(a[i]);
        }
    }

    public static boolean ishuiwen(String str) {
        for (int i = 0; i <= str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }


}
