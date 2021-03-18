package top.lossingdawn.design.pattern.demo1.abstractfactory;

import top.lossingdawn.design.pattern.demo1.aribags.Airbags;
import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * 抽象工厂模式demo
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 15:21
 **/
public class CarFactoryDemo {

    public static void main(String[] args) {
        // ACar
        CarFactory carFactory = new ACarFactory();
        Wheel wheel = carFactory.getWheel();
        wheel.show();
        Airbags airbags = carFactory.getAirBags();
        airbags.show();


        // BCar
        carFactory = new BCarFactory();
        wheel = carFactory.getWheel();
        wheel.show();
        airbags = carFactory.getAirBags();
        airbags.show();
    }

}
