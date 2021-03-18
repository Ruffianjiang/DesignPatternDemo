# 设计模式（一、二） 工厂模式、抽象工厂模式

## 一、简介

工厂模式主要是为创建对象提供了接口。工厂模式按照《Java与模式》中的提法分为三类：

1. 简单工厂模式(Simple Factory)
2. 工厂方法模式(Factory Method)
3. 抽象工厂模式(Abstract Factory)




## 二、简单工厂模式


使用工厂获取功能定义相同的实现工具

### 接口

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 11:16
 **/
public interface Wheel {

   int wheelNum();

   void setNum(int num1);

   void show();

}
```

### 抽象类

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 14:59
 **/
public abstract class BaseWheel implements Wheel {

    protected int num = 4;

    @Override
    public int wheelNum() {
        return num;
    }

    @Override
    public void setNum(int num) {
        this.num = num;
    }
}

```


### 实现类

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 11:17
 **/
public class CircleWheel extends BaseWheel {

    @Override
    public void show() {
        System.out.println(this.getClass() + " has " + this.wheelNum() + " wheelNum");
    }
}
```

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 11:16
 **/
public class RectangleWheel extends BaseWheel {

    @Override
    public void show() {
        System.out.println(this.getClass() + " has " + this.wheelNum() + " wheelNum");
    }
}
```

```java
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
```

### 工厂

```java
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
```

### 测试类

```java
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
```

### 输出

> class top.lossingdawn.design.pattern.demo1.wheel.CircleWheel has 4 wheelNum
> class top.lossingdawn.design.pattern.demo1.wheel.RectangleWheel has 4 wheelNum
> class top.lossingdawn.design.pattern.demo1.wheel.SquareWheel has 4 wheelNum
> 15:49:41.276 [main] INFO top.lossingdawn.design.pattern.demo1.simplefactory.SimpleFactoryDemo - AAAA == null : true





### 特点

1 它是一个具体的类，非接口 抽象类。根据参数返回具体的实现对象。
2 get()方法通常是静态的，所以也称之为静态工厂。

### 缺点

1 扩展性差，当需要增加、减少
2 不同的产品需要不同额外参数的时候 不支持。


**注：**当然也有规避缺点的方法，就是动态加载实现类，利用反射或者spring bean工厂，动态的把参数和实现类关联起来




## 三、工厂方法模式

不同工厂定义不同的初始化




### 工厂接口

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 14:44
 **/
public interface WheelFactory {

    Wheel getWheel(String shapeType);

}
```


### 工厂类

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 14:50
 **/
public class LowWheelFactory implements WheelFactory {

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
        wheel.setNum(4);
        return wheel;
    }
}
```

```java
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
```


### 测试类

```java
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
```

### 输出

> class top.lossingdawn.design.pattern.demo1.wheel.CircleWheel has 4 wheelNum
> class top.lossingdawn.design.pattern.demo1.wheel.CircleWheel has 8 wheelNum



### 特点

不同的工厂输出定制化的实现工具


### 缺点

同简单模式，拓展性较差，因增加定制化需求，较难通过一些手段规避问题




## 四、抽象工厂模式


把不同的接口通过层级组合起来


### 接口

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 14:37
 **/
public interface Airbags {

    void show();

}
```


### 实现类

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 14:37
 **/
public class AAirbags implements Airbags{

    @Override
    public void show() {
        System.out.println(this.getClass());
    }

}

```

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 15:08
 **/
public interface CarFactory {

    Airbags getAirBags();

    Wheel getWheel();

}
```


### 工厂接口

```java
/**
 * @author jiangyj
 * @version 1.0
 * @create 2021-03-18 15:08
 **/
public interface CarFactory {

    Airbags getAirBags();

    Wheel getWheel();

}
```


### 工厂类

```java
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
```

```java
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
```


### 测试类

```java
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
```

### 输出

> class top.lossingdawn.design.pattern.demo1.wheel.RectangleWheel has 4 wheelNum
> class top.lossingdawn.design.pattern.demo1.aribags.AAirbags
> class top.lossingdawn.design.pattern.demo1.wheel.CircleWheel has 8 wheelNum
> class top.lossingdawn.design.pattern.demo1.aribags.BAirbags



### 特点

通过接口层级关系，紧密的连接起来，形成一个产品




### 缺点

接口之间有固定的层级依赖关系，跨层级调整是灾难性的




## 五、总结


### 简单工厂：

一个工厂生产多种轮子，圆轮子、方轮子、矩形轮子
**同种商品的不同种类**




### 工厂方法：

多个工厂生产轮子，圆轮子、方轮子、矩形轮子
A工厂轮子4个一组，B工厂轮子8个一组
**同种商品不同的生产规格**




### 抽象工厂：

一个工厂生产轮子、气囊等产品
**一个产品由规格不同的其他产品组成**




## 六、工厂模式的实际应用


1、spring bean工厂 【BeanFactory】
2、加密工厂【SecretKeyFactory】












项目地址：[https://github.com/Ruffianjiang/DesignPatternDemo/tree/master/demo1](https://github.com/Ruffianjiang/DesignPatternDemo/tree/master/demo1)

























