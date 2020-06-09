package tech.hiyinyougen.demo.factory.di;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 10:06
 * @Description
 */
public class XmlBeansDefinitionParser implements BeansDefinitionParser {
    @Override
    public List<BeanDefinition> parse(String configContext) {
        return new ArrayList<BeanDefinition>();
    }

    @Override
    public List<BeanDefinition> parse(InputStream inputStream) {
        return new ArrayList<BeanDefinition>();
    }
}
