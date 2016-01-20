package com.madhouse.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.madhouse.service.MyAccountService;
import com.madhouse.util.Account;

public class Main {
       public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("/com/resource/SpringCore.xml");
		
		MyAccountService accountService=(MyAccountService)context.getBean("accountServiceBean");
		
		
		 Account account = accountService.getAccountByName("someone"); 
		   System.out.println("passwd="+account.getPassword()); 
		   account = accountService.getAccountByName("someone"); 
		   System.out.println("passwd="+account.getPassword()); 
		/*System.out.println("first query");
		
		Account name = accountService.getAccountByName("someBody");
		//accountService.getAccountByName("someBody",2);
		name.setId(2);
		accountService.updateAccount(name);
		//System.out.println("second query ");
		name.setId(321);
		accountService.updateAccount(name);
		name = accountService.getAccountByName("someBody");
		System.out.println(name.getId());//cacheput有问题
		//accountService.getAccountByName("someBody");
		
		System.out.println();*/
		
		/*System.out.println("跟新某条记录");
		
		Account name1 = accountService.getAccountByName("somebody1");
		
		Account name2 = accountService.getAccountByName("somebody2");
		
		accountService.updateAccount(name1);
		accountService.getAccountByName("somebody1");
		accountService.getAccountByName("somebody2");
		System.out.println("开始清空全部缓存");
		accountService.reload();
		accountService.getAccountByName("somebody1");
		accountService.getAccountByName("somebody2");*/
		
		
		
	}
}
