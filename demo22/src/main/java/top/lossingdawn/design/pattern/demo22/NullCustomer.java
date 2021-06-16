package top.lossingdawn.design.pattern.demo22;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-06-07 10:45
 **/
public class NullCustomer extends AbstractCustomer {

    @Override
    public String getName() {
        return "Not Available in Customer Database";
    }

    @Override
    public boolean isNil() {
        return true;
    }
}
