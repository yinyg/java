package tech.hiyinyougen.demo.factory.abstractFactory;

import tech.hiyinyougen.demo.factory.CarC;
import tech.hiyinyougen.demo.factory.ICar;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 18:13
 * @Description
 */
public class FactoryC implements IFactory {
    @Override
    public ICar getCarInstance() {
        return new CarC();
    }

    @Override
    public IBus getBusInstance() {
        return new BusC();
    }
}
