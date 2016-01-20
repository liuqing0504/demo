package com.madhouse.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import com.madhouse.util.Account;

public class MyAccountService {
    //condition="#name.length() <= 4",
	//,key="#name.concat(#id)" key属性是用来指定Spring缓存方法的返回结果时对应的key，默认为#root.caches[0].name
	// @Cacheable({"cache1", "cache2"})多个缓存对象时，是一个数组
    @Cacheable(value="accountCache")
    public Account getAccountByName(String name){
    	System.out.println("查詢account: "+name);
    	return getFromDb(name);
    }
    
   // @CacheEvict(value="accountCache",key="#account.getName()")//清空缓存
    @CachePut(value="accountCache",key="#account.getName()")
    public void updateAccount(Account account){
    	updateDB(account);
    }
    //beforeInvocation当我们指定该属性值为true时，Spring会在调用该方法之前清除缓存中的指定元素。如果为false，方法执行发生异常就不会进行清除
    //@Caching(cacheable = @Cacheable("users"), evict = { @CacheEvict("cache2"),

    //@CacheEvict(value = "cache3", allEntries = true) })
    //@CacheEvict(value="accountCache",allEntries=true)//清空缓存
	public void reload(){
		
	}
   
	private void updateDB(Account account) {
		 System.out.println("update db  "+account.getName());
	}

	private Account getFromDb(String name) {
	    System.out.println("查詢数据库："+name);
		return new Account(name);
	}
}
