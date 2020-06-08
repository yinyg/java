package tech.hiyinyougen.demo.factory.abstractFactory;

import tech.hiyinyougen.demo.factory.ICar;

/**
 * @Author yinyg
 * @CreateTime 2020/6/8 18:12
 * @Description
 */
public interface IFactory {
    ICar getCarInstance();

    IBus getBusInstance();
}
