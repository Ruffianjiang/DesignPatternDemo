package top.lossingdawn.design.pattern.demo1.simplefactory;

import top.lossingdawn.design.pattern.demo1.wheel.CircleWheel;
import top.lossingdawn.design.pattern.demo1.wheel.RectangleWheel;
import top.lossingdawn.design.pattern.demo1.wheel.SquareWheel;
import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 11:17
 **/
public class SimpleFactory {

    public Wheel getWheel(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("CIRCLE")) {
            return new CircleWheel();
        } else if (type.equalsIgnoreCase("RECTANGLE")) {
            return new RectangleWheel();
        } else if (type.equalsIgnoreCase("SQUARE")) {
            return new SquareWheel();
        }
        return null;
    }
}
