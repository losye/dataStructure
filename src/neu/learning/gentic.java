package neu.learning;

import java.util.Set;

public class gentic {
	public static void main(String[] args) {
		
	}
	
	public static int add(Set<?> s1,Set<?> s2){
		int result = 0;
		for(Object o:s1){
			if(s2.contains(o)){
				result++;
			}
		}
		return result;
	}
}
