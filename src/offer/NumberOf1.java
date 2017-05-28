package offer;

/**
 * Created by losye
 * 输入一个整数，  输出该数二级制表示中1的个数
 * 输入9 (二级制为1001) 输出2
 */
public class NumberOf1 {
    public static int getNumer1(int n){
        int res = 0;
        if(n < 0){
           res++;
        }
        n = Math.abs(n);
        while (n != 0){
            if ((n&1) == 1){
                res++;
            }
            n = n>>1;
        }
        return res;
    }
    //把一个整数减1和原数做与运算 相当于把最右的1变成0
    public static int getNumber2(int n){
        int res = 0;
        if (n<0){
            res++;
        }
        n = Math.abs(n);
        while (n != 0){
            n = n&(n-1);
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println("number1 of 9 :" + getNumer1(9));
        System.out.println("number1 of 9 :" + getNumer1(-9));
        System.out.println("number2 of 9 :" + getNumber2(9));
        System.out.println("number2 of 9 :" + getNumber2(-9));
    }
}
