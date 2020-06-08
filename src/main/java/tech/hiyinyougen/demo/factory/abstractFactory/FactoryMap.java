package tech.hiyinyougen.demo.factory.abstractFactory;

import tech.hiyinyougen.demo.factory.ICar;
import tech.hiyinyougen.demo.factory.factoryMethod.CarFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 18:22
 * @Description
 */
public class FactoryMap {
    private static final Map<String, IFactory> map = new HashMap<>();

    static  {
        map.put("A", new FactoryA());
        map.put("B", new FactoryB());
        map.put("C", new FactoryC());
    }

    public static IFactory getFactory(String type) {
        if (type == null) {
            throw new NullPointerException("type can not be null");
        }
        IFactory factory = map.get(type);
        if (factory == null) {
            throw new NullPointerException("no such factory");
        }
        return factory;
    }

    public static void main(String[] args) {
        IFactory factory = FactoryMap.getFactory("C");
        ICar car = factory.getCarInstance();
        IBus bus = factory.getBusInstance();
        System.out.println(car.getClass().getName());
        System.out.println(bus.getClass().getName());
    }
}
