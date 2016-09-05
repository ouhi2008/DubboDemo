package com.alibaba.dubbo.demo.pp;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unj.dubbotest.provider.CalcService;
import com.unj.dubbotest.provider.DemoService;
import com.unj.dubbotest.provider.pojo.User;

public class Consumer {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		context.start();

		System.out.println("-------------Test Demo Service------------------------");
		DemoService demoService = (DemoService) context.getBean("demoService");
		String hello = demoService.sayHello("tom");
		System.out.println(hello);

		List<User> list = demoService.getUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
		System.out.println("-------------Test Calc Service------------------------");
		CalcService calcService = (CalcService)context.getBean("calcService");
		for(int i=0;i<16;i++){
			System.out.println(i+"! = "+calcService.factorial(i));
		}
		
		
		
		System.in.read();
	}

}