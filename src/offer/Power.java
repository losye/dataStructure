package offer;

/**
 * Created by losye
 * 数值的整数次方
 */
public class Power {


    public static double power(double base, int exponent){
        if (base == 0 && exponent < 0){
            return -1;
        }
        if (exponent < 0){
            base = 1/base;
            exponent = Math.abs(exponent);
        }
        if (exponent == 0){
            return 1;
        }
        double res = power(base, exponent>>1);
        res = res * res;
        //如果是基数那么还要乘一次底数
        if ((exponent&1) == 1){
            res = res * base;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("2 power of 8: " + power(2, 8));
        System.out.println("2 power of 3: " + power(2, 3));
        System.out.println("2 power of -3: " + power(2, -3));
    }
}
