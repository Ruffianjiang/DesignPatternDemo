package top.lossingdawn.design.pattern.demo1.wheel;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 11:17
 **/
public class SquareWheel extends BaseWheel {

    @Override
    public void show() {
        System.out.println(this.getClass() + " has " + this.wheelNum() + " wheelNum");
    }
}
