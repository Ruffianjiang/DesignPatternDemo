package top.lossingdawn.design.pattern.demo1.wheel;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 14:59
 **/
public abstract class BaseWheel implements Wheel {

    protected int num = 4;

    @Override
    public int wheelNum() {
        return num;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }
}
