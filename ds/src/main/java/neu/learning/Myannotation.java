package neu.learning;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Myannotation {

	String driverName();

	String url();

	String username();

	String password();

}
