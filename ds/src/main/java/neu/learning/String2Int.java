package neu.learning;

public class String2Int {
	
	public static void main(String[] args) {
		int a = String2Int("+-123");
		System.out.println(a);
	}
	
	public static int String2Int(String str){
		if(str==null || str.length()==0){
			return 0;
		}
		boolean flag = true;
		char[] chars = str.toCharArray();
		int index = 0;
		if(chars[0]=='+'){
			index++;
		}
		if(chars[0]=='-'){
			flag = false;
			index++;
		}
		int res = 0;
		for(int i=index; i<str.length(); i++){
			if(chars[i]<'0' || chars[i]>'9'){
				return 0;
			}
			res *= 10;
			res += chars[i]-'0';
		}
		if(!flag){
			res *=-1;
		}
		return res;
	}
}
