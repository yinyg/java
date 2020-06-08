package tech.hiyinyougen.demo.factory.abstractFactory;

import tech.hiyinyougen.demo.factory.CarB;
import tech.hiyinyougen.demo.factory.ICar;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 18:13
 * @Description
 */
public class FactoryB implements IFactory {
    @Override
    public ICar getCarInstance() {
        return new CarB();
    }

    @Override
    public IBus getBusInstance() {
        return new BusB();
    }
}
