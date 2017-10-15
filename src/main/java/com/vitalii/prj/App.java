package com.vitalii.prj;

import com.vitalii.prj.config.SpringConfig;
import com.vitalii.prj.service.TestBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        TestBean bean = context.getBean(TestBean.class);
        String name = bean.getName();

        System.out.println( "Hello World!" + name);
    }
}
