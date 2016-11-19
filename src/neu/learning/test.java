package neu.learning;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public class test {
	public static void main(String[] args) throws Exception {
//		Constructor constructor = String.class.getConstructor(StringBuffer.class);
//		String str = (String) constructor.newInstance(new StringBuffer("abc"));
		/*Constructor constructor = String.class.getConstructor(String.class);
		String str = (String) constructor.newInstance("abc");
		String str2 = String.class.newInstance();
		System.out.println(str);*/
		List<Integer> list = new ArrayList<Integer>();
/*		ParameterizedType type = (ParameterizedType) list.getClass().getGenericSuperclass();
		Class clazz = (Class) type.getActualTypeArguments()[0];*/
		list.getClass().getMethod("add", Object.class).invoke(list, "abc");
		System.out.println(list.get(0));
		
	}  
}
