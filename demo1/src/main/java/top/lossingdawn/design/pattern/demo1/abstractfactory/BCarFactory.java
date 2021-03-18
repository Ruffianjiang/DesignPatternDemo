package top.lossingdawn.design.pattern.demo1.abstractfactory;

import top.lossingdawn.design.pattern.demo1.aribags.Airbags;
import top.lossingdawn.design.pattern.demo1.aribags.BAirbags;
import top.lossingdawn.design.pattern.demo1.wheel.CircleWheel;
import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 15:11
 **/
public class BCarFactory implements CarFactory {


    @Override
    public Airbags getAirBags() {
        return new BAirbags();
    }

    @Override
    public Wheel getWheel() {
        Wheel wheel = new CircleWheel();
        wheel.setNum(8);
        return wheel;
    }
}
