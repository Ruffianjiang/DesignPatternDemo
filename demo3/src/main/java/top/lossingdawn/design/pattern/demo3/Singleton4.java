package top.lossingdawn.design.pattern.demo3;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 * @author jiangyj
 * @version 1.0
 * @create 2021-06-04 15:35
 **/
public class Singleton4 {

    private volatile static Singleton4 singleton4;
    private Singleton4(){}
    public static Singleton4 getSingleton() {
        if (singleton4 == null) {
            synchronized (Singleton4.class) {
                if (singleton4 == null) {
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }
}
