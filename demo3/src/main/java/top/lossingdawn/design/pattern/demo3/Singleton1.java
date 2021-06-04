package top.lossingdawn.design.pattern.demo3;

/**
 * 懒汉式，线程不安全
 * @author jiangyj
 * @version 1.0
 * @create 2021-06-04 15:23
 **/
public class Singleton1 {

    private static Singleton1 instance;
    private Singleton1 (){}

    public static Singleton1 getInstance() {
        if (instance == null) {
            instance = new Singleton1();
        }
        return instance;
    }
}
