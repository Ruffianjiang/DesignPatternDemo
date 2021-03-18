package top.lossingdawn.design.pattern.demo1.factorymethod;

import lombok.extern.slf4j.Slf4j;
import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * 工厂模式demo
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 15:03
 **/
@Slf4j
public class WheelFactoryDemo {

    public static void main(String[] args) {
        // lowcar
        WheelFactory wheelFactory = new LowWheelFactory();
        Wheel wheel = wheelFactory.getWheel("CIRCLE");
        wheel.show();

        // upcar
        wheelFactory = new UpWheelFactory();
        wheel = wheelFactory.getWheel("CIRCLE");
        wheel.show();
    }

}
