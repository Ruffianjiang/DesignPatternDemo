package top.lossingdawn.design.pattern.demo22;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-06-07 10:45
 **/
public class RealCustomer extends AbstractCustomer {

    public RealCustomer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isNil() {
        return false;
    }
}
