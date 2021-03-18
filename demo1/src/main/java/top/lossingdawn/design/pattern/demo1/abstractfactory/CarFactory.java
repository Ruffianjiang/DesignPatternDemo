package top.lossingdawn.design.pattern.demo1.abstractfactory;

import top.lossingdawn.design.pattern.demo1.aribags.Airbags;
import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 15:08
 **/
public interface CarFactory {

    Airbags getAirBags();

    Wheel getWheel();

}
