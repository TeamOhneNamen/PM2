package pm2ss2016;

public class AnnotationMarker {

    public void method1() {
        System.out.println("method1");
    }

    @Schedule
    public void method2() {
        System.out.println("method2");
    }
    
    @Schedule
    public void method3() {
        System.out.println("method3");
    }


}