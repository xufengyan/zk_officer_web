package com.xf.project.admin.controller.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.util.*;

/**
 * @author xf
 * @version 1.0
 * @date 2021/3/29 14:51
 */
@Component
public class User implements BeanFactoryPostProcessor
{
    User(){


//       new String(new byte []);
       System.out.println("Sdsd");
    }

    public static void main(String[] args) {
        String str = "sdsdsdsd";
        byte[] bytes = str.getBytes();
        ByteBuffer buffer = ByteBuffer.wrap(bytes,0,bytes.length);
        long aLong = buffer.getLong();
        System.out.println(aLong);
        String s = Long.toString(aLong);
        System.out.println(s);

        int i = 1000;
        byte b = (byte) i;
        System.out.println(b);
        int i2 = (int) b;
        System.out.println(i2);
        new Stack();
        Collections.sort(new ArrayList<String>(), new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {

    }
}
