package top.lossingdawn.design.pattern.demo1.factorymethod;

import top.lossingdawn.design.pattern.demo1.wheel.CircleWheel;
import top.lossingdawn.design.pattern.demo1.wheel.RectangleWheel;
import top.lossingdawn.design.pattern.demo1.wheel.SquareWheel;
import top.lossingdawn.design.pattern.demo1.wheel.Wheel;

/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 14:44
 **/
public class UpWheelFactory implements WheelFactory {


    @Override
    public Wheel getWheel(String shapeType) {
        Wheel wheel = null;
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            wheel = new CircleWheel();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            wheel = new RectangleWheel();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            wheel = new SquareWheel();
        }
        wheel.setNum(8);
        return wheel;
    }
}
