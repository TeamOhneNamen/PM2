package pm2ss2016;
//http://www.vogella.com/tutorials/JavaAnnotations/article.html

import java.lang.reflect.Method;

public class AnnotationExecuter {

	public static void main(String[] args) {

		AnnotationMarker runner = new AnnotationMarker();
		//get all methods from the class
		for (Method method : runner.getClass().getMethods()) {
			Schedule annos = method.getAnnotation(Schedule.class);
			//if annotation == Schedule
			if (annos != null) {
				try {
					//executes the method
					method.invoke(runner);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}