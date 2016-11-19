package neu.learning;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class simpledate {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = sdf.format(new Date());
		System.out.println(date);
	}
}
