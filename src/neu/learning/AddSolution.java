package neu.learning;
/**
 * 不用加减乘除做加法
 * @author Administrator
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class AddSolution {
	public static void main(String[] args) {
		System.out.println(add(3,5));
		System.out.println(add(3,4));
		System.out.println(add(5,5));
	}
	public static int add(int num1, int num2){
		int m = (num1&num2)<<1;  //找的都为1的位置 并为其进位
		int n = num1^num2;
		while((m&n)!=0){
			num1 = m;
			num2 = n;
			m = (num1&num2)<<1;
			n = num1^num2;
		}
		return m^n;
	}
}
