package top.lossingdawn.design.pattern.demo3;

/**
 * 登记式/静态内部类
 * @author jiangyj
 * @version 1.0
 * @create 2021-06-04 15:36
 **/
public class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    private Singleton5(){}
    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
