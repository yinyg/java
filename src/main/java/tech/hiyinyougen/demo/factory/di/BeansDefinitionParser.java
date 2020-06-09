package tech.hiyinyougen.demo.factory.di;

import java.io.InputStream;
import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 10:04
 * @Description
 */
public interface BeansDefinitionParser {
    List<BeanDefinition> parse(String configContext);
    List<BeanDefinition> parse(InputStream inputStream);
}
