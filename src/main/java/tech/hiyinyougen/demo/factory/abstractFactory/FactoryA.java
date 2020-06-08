package tech.hiyinyougen.demo.factory.abstractFactory;

import tech.hiyinyougen.demo.factory.CarA;
import tech.hiyinyougen.demo.factory.ICar;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 18:13
 * @Description
 */
public class FactoryA implements IFactory {
    @Override
    public ICar getCarInstance() {
        return new CarA();
    }

    @Override
    public IBus getBusInstance() {
        return new BusA();
    }
}
