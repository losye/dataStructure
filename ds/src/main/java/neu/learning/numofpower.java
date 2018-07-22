package neu.learning;

/**
 * num的power次方
 */
public class numofpower {

    public static int numpower(int num, int power) {
        int result = 1;
        int temp = num;
        for (; power != 0; power >>= 1) {
            if ((power & 1) != 0) {
                result = result * temp;
            }
            temp = temp * temp;
        }
        return result;
    }

    // 递归了
    public static double numpower2(double num, int power) {
        if (power == 0) {
            return 1;
        }
        if (power == 1) {
            return num;
        }
        double result = numpower2(num, power >> 1);
        result *= result;
        if ((power & 1) == 1) {
            result *= num;
        }
        return result;
    }

    public static void main(String[] args) {
        double result = numpower(2, 5);
        double result2 = numpower2(2, 4);
        System.out.println(result);
        System.out.println(result2);
        /* System.out.println(0x01); */
    }
}
