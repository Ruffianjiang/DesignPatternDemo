package top.lossingdawn.design.pattern.demo3;

/**
 * 饿汉式
 * @author jiangyj
 * @version 1.0
 * @create 2021-06-04 15:31
 **/
public class Singleton3 {
    private static Singleton3 instance = new Singleton3();
    private Singleton3(){}
    public static Singleton3 getInstance() {
        return instance;
    }
}
