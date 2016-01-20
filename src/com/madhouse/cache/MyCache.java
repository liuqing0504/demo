package com.madhouse.cache;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.madhouse.util.Account;

//Cache 接口负责实际的缓存逻辑，例如增加键值对、存储、查询和清空等。利用 Cache 接口，我们可以对接任何第三方的缓存系统
public class MyCache implements Cache  {
	 private String name;
	 private Map<String,Account> store = new HashMap<String,Account>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MyCache(String name) {
		super();
		this.name = name;
	}
	public MyCache() {
		super();
	}
	@Override
	public void clear() {
		
	}
	@Override
	public void evict(Object arg0) {
		
	}
	@Override
	public ValueWrapper get(Object key) {
		ValueWrapper result = null; 
	     Account thevalue = store.get(key); 
	     if(thevalue!=null) { 
	       thevalue.setPassword("from mycache:"+name); 
	       result = new SimpleValueWrapper(thevalue); 
	     } 
	     return result;
	}
	@Override
	public <T> T get(Object arg0, Class<T> arg1) {
		return null;
	}
	@Override
	public Object getNativeCache() {
		 return store; 
	}
	@Override
	public void put(Object key, Object value) {
		 Account thevalue = (Account)value; 
	     store.put((String)key, thevalue);
	}
	@Override
	public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
		return null;
	}
	 
}
