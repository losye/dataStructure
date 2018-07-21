package neu.learning;

import neu.learning.model.Myannotation;

import java.lang.reflect.Method;
import java.sql.Connection;

public class AnnotationTest {

	@Myannotation(driverName = "com.mysql.jdbc.Driver", url = "jdbc:mysql://localhost:3306/tttt", username = "root", password = "")
	public static Connection getConnection() {
		try {
			Method menthod = AnnotationTest.class.getMethod("getConnection", null);
			Myannotation annotation = menthod.getAnnotation(Myannotation.class);
			System.out.println(annotation.driverName());
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		AnnotationTest.getConnection();
	 
	}
}
