package tech.hiyinyougen.demo.factory.simpleFactory;

import tech.hiyinyougen.demo.factory.CarA;
import tech.hiyinyougen.demo.factory.CarB;
import tech.hiyinyougen.demo.factory.CarC;
import tech.hiyinyougen.demo.factory.ICar;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 16:53
 * @Description
 */
public class CarFactory {
    public static ICar getInstance(String type) {
        if (type == null) {
            throw new NullPointerException("type can not be null");
        }
        if (type.toUpperCase().equals("A")) {
            return new CarA();
        } else if (type.toUpperCase().equals("B")) {
            return new CarB();
        } else if (type.toUpperCase().equals("C")) {
            return new CarC();
        } else {
            throw new NullPointerException("no such type");
        }
    }

    public static void main(String[] args) {
        ICar car = CarFactory.getInstance("A");
        System.out.println(car.getClass().getName());
    }
}
