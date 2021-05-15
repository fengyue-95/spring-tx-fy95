package com.fy.spring.tx;

import com.fy.spring.tx.service.OuterBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fy.spring.tx.model.User;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        OuterBean outerBean = (OuterBean) ctx.getBean("outerBeanImpl");

        /**你能通过控制插入的数据的UserName重复产生异常*/
        User outer = new User();
        outer.setUsername("009");
        outer.setName("fy");

        User inner = new User();
        inner.setUsername("010");
        inner.setName("fy");

        /** 选择代码进行注释，完成你想要的测试*/
        outerBean.testRequired(outer, inner);
        // outerBean.testRequiresNew(outer,inner);
        //outerBean.testNested(outer,inner);
    }
}
