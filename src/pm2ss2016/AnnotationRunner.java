package pm2ss2016;

public class AnnotationRunner {

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

    @CanRun
    public void method5() {
        System.out.println("method4");
    }

}