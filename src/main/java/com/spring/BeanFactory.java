package com.spring;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by chen on 2017/10/22.
 */
public class BeanFactory {
    private Map<String,Object> beanMap = new HashMap<String, Object>();
    /**
     * bean的实例化工厂
     */
    public void init(String xml) throws DocumentException, ClassNotFoundException, IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        //1.创建并读取配置文件的reader对象
        SAXReader reader = new SAXReader();

        //2.获取当前线程中的类装载器对象
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        //3.从class目录下获取指定的xml文件
        InputStream ins = classLoader.getResourceAsStream(xml);
        Document doc = reader.read(ins);
        Element root = doc.getRootElement();
        Element foo;

        //4.遍历xml文件中的Bean实例
        for(Iterator i = root.elementIterator("bean");i.hasNext();){
            foo = (Element)i.next();

            //5.针对每一个Bean实例 获取bean的属性id和class
            Attribute id = foo.attribute("id");
            Attribute cls = foo.attribute("class");

            //6.利用java反射机制，通过class的名称获取class对象
            Class bean = Class.forName(cls.getText());
            //7.获取对应class的信息
            BeanInfo info = Introspector.getBeanInfo(bean);
            //8.获取属性描述
            PropertyDescriptor pd[] = info.getPropertyDescriptors();

            //9.创建一个对象，并在接下来的代码中为对象属性赋值
            Object obj = bean.newInstance();

            //10.遍历bean的propety属性
            for(Iterator ite = foo.elementIterator("property");ite.hasNext();){
                Element foo2 = (Element)ite.next();

                //11.获取该property的name属性
                Attribute name = foo2.attribute("name");
                String value = null;

                //12.获取该property的子元素value值
                for(Iterator itel=foo2.elementIterator("value");itel.hasNext();){
                    Element node = (Element)itel.next();
                    value = node.getText();
                    break;
                }

                //13.利用java的反射机制调用对象的某个set方法，并将值设置进去
                for (int k=0;k<pd.length;k++){
                    if(pd[k].getName().equalsIgnoreCase(name.getText())){
                        Method mSet = null;
                        mSet = pd[k].getWriteMethod();
                        mSet.invoke(obj,value);
                    }
                }
            }
            //14. 将对象放入beanMap中，key为id,value为对象
            beanMap.put(id.getText(),obj);
        }
    }
    public Object getBean(String beanName){
        Object obj = beanMap.get(beanName);
        return obj;
    }
    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InstantiationException, DocumentException, InvocationTargetException, ClassNotFoundException {
        BeanFactory factory = new BeanFactory();
        factory.init("config.xml");
        JavaBean javaBean = (JavaBean) factory.getBean("javaBean");
        System.out.println("userName=:"+ javaBean.getUserName());
        System.out.println("password=:"+ javaBean.getPassword());
    }
}
