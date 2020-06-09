package tech.hiyinyougen.demo.factory.di;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author yinyg
 * @CreateTime 2020/6/9 09:44
 * @Description
 */
public class ClassPathXmlApplicationContext implements ApplicationContext {
    private BeansDefinitionParser beansDefinitionParser;
    private BeansFactory beansFactory;

    public ClassPathXmlApplicationContext(String configPath) {
        this.beansDefinitionParser = new XmlBeansDefinitionParser();
        this.beansFactory = new BeansFactory();
        this.loadDefinitions(configPath);
    }

    private void loadDefinitions(String configPath) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configPath);
            if (in == null) {
                throw new RuntimeException("no such config found");
            }
            List<BeanDefinition> beanDefinitions = beansDefinitionParser.parse(in);
            this.beansFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
