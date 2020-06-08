package tech.hiyinyougen.demo.factory.factoryMethod;

import tech.hiyinyougen.demo.factory.CarC;
import tech.hiyinyougen.demo.factory.ICar;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 17:20
 * @Description
 */
public class CarCFactory implements CarFactory {
    @Override
    public ICar getInstance() {
        return new CarC();
    }
}
