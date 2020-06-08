package tech.hiyinyougen.demo.factory.factoryMethod;

import tech.hiyinyougen.demo.factory.CarB;
import tech.hiyinyougen.demo.factory.ICar;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 17:20
 * @Description
 */
public class CarBFactory implements CarFactory {
    @Override
    public ICar getInstance() {
        return new CarB();
    }
}
