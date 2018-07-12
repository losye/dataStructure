package offer;

/**
 * Created by losye
 *          0              n=0
 * f(n) =   1              n=1
 *         f(n-1)+f(n-2)   n>1
 */
public class Fibonacci {
    public static int solution1(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        return solution1(n-1)+ solution1(n-2);
    }

    public static int solution2(int n){
        if (n <= 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int result = 0;
        int init = 0;
        int pre = 1;
        for (int i=2; i<=n; i++){
            result = init + pre;
            init = pre;
            pre = result;
        }
        return result;
    }

    /**
     *  如果严格遵循 : F(N) = F(N-1) + F(N-2)

         那么
        (F(n),F(n-1)) = (F(N-1),F(N-2))*|a b|
                                        |c d|
     */



    public static int solution3(int n){
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution1(14));
        System.out.println(solution2(14));
    }
}
