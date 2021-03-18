package top.lossingdawn.design.pattern.demo1.simplefactory;

import lombok.extern.slf4j.Slf4j;
import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * 简单工厂demo
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 11:20
 **/
@Slf4j
public class SimpleFactoryDemo {

    public static void main(String[] args) {
        SimpleFactory simpleFactory = new SimpleFactory();

        //获取 Circle 的对象
        Wheel wheel = simpleFactory.getWheel("CIRCLE");
        wheel.show();

        //获取 Rectangle 的对象
        wheel = simpleFactory.getWheel("RECTANGLE");
        wheel.show();

        //获取 Square 的对象
        wheel = simpleFactory.getWheel("SQUARE");
        wheel.show();

        wheel = simpleFactory.getWheel("AAAA");
        log.info("AAAA == null : {}", wheel == null);
    }
}
