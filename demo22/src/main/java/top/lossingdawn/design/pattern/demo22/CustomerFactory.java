package top.lossingdawn.design.pattern.demo22;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-06-07 10:46
 **/
public class CustomerFactory {

    public static final String[] names = {"Rob", "Joe", "Julie"};

    public static AbstractCustomer getCustomer(String name){
        for (int i = 0; i < names.length; i++) {
            if (names[i].equalsIgnoreCase(name)){
                return new RealCustomer(name);
            }
        }
        return new NullCustomer();
    }
}
