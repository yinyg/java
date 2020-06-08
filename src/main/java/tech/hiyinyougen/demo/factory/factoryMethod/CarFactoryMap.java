package tech.hiyinyougen.demo.factory.factoryMethod;

import tech.hiyinyougen.demo.factory.ICar;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 17:23
 * @Description
 */
public class CarFactoryMap {
    private static final Map<String, CarFactory> map = new HashMap<>();

    static {
        map.put("A", new CarAFactory());
        map.put("B", new CarBFactory());
        map.put("C", new CarCFactory());
    }

    public static CarFactory getCarFactory(String type) {
        if (type == null) {
            throw new NullPointerException("type can not be null");
        }
        CarFactory factory = map.get(type);
        if (factory == null) {
            throw new NullPointerException("no such factory");
        }
        return factory;
    }

    public static void main(String[] args) {
        CarFactory factory = CarFactoryMap.getCarFactory("A");
        ICar car = factory.getInstance();
        System.out.println(car.getClass().getName());
    }
}
