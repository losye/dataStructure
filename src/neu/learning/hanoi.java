package neu.learning;

public class hanoi {
	public static void main(String[] args) {
		hanoi(4);
	}
	public static void hanoi(int n){
		if(n>0){
			fun(n,"LEFT","MID","RIGHT");
		}
	}
	public static void fun(int n, String from, String mid, String to) {
		if(n==1){
			System.out.println("move from " + from + " to " + to);
		}else{
			fun(n-1, from, to, mid);
			fun(1, from, mid, to);
			fun(n-1, mid, from, to);
		}	
	}
}
