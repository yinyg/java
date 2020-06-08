package tech.hiyinyougen.demo.factory.simpleFactory;

import tech.hiyinyougen.demo.factory.CarA;
import tech.hiyinyougen.demo.factory.CarB;
import tech.hiyinyougen.demo.factory.CarC;
import tech.hiyinyougen.demo.factory.ICar;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 17:07
 * @Description
 */
public class CarFactory2 {
    private static final Map<String, ICar> map = new HashMap<>();

    static {
        map.put("A", new CarA());
        map.put("B", new CarB());
        map.put("C", new CarC());
    }

    public static ICar getInstance(String type) {
        if (type == null) {
            throw new NullPointerException("type can not be null");
        }
        ICar car = map.get(type);
        if (car == null) {
            throw new IllegalArgumentException("no such type");
        }
        return car;
    }

    public static void main(String[] args) {
        ICar car = CarFactory2.getInstance("B");
        System.out.println(car.getClass().getName());
    }
}
