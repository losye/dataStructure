package neu.learning;
/**
 * 左旋转字符串
 * @author Administrator
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class LeftRotate {
	public static void main(String[] args) {
		String str = LeftRotateString("abcXYZdef",3);
		System.out.println(str);
	}
	
	public static String LeftRotateString(String str,int n) {
		if(str==null||str.length()==0||n<0){
			return "";
		}
		StringBuilder sb = new StringBuilder(str);
		int len = str.length();
        n = n % len;
        sb.append(str);
       // System.out.println(sb);
        return sb.substring(n, len+n);
	}
}
