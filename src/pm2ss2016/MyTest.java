package pm2ss2016;
//http://www.vogella.com/tutorials/JavaAnnotations/article.html

import java.lang.reflect.Method;

public class MyTest {

	public static void main(String[] args) {

		AnnotationRunner runner = new AnnotationRunner();

		for (Method method : runner.getClass().getMethods()) {
			Schedule annos = method.getAnnotation(Schedule.class);
			if (annos != null) {
				try {
					method.invoke(runner);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}