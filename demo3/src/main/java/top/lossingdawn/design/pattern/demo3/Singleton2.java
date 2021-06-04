package top.lossingdawn.design.pattern.demo3;

/**
 * 懒汉式，线程安全
 * @author jiangyj
 * @version 1.0
 * @create 2021-06-04 15:30
 **/
public class Singleton2 {

    private static Singleton2 instance;
    private Singleton2(){}
    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
