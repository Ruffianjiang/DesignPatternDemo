package top.lossingdawn.design.pattern.demo1.factorymethod;

import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 14:44
 **/
public interface WheelFactory {

    Wheel getWheel(String shapeType);

}
