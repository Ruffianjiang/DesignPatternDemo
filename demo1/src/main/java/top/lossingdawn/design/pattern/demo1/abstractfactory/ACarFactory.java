package top.lossingdawn.design.pattern.demo1.abstractfactory;

import top.lossingdawn.design.pattern.demo1.aribags.AAirbags;
import top.lossingdawn.design.pattern.demo1.aribags.Airbags;
import top.lossingdawn.design.pattern.demo1.wheel.RectangleWheel;
import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 15:11
 **/
public class ACarFactory implements CarFactory {


    @Override
    public Airbags getAirBags() {
        return new AAirbags();
    }

    @Override
    public Wheel getWheel() {
        return new RectangleWheel();
    }
}
