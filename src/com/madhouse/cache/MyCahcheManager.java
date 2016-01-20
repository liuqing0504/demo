package com.madhouse.cache;

import java.util.Collection;

import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

//Collection这个接口告诉 spring 有哪些 cache 实例
public class MyCahcheManager extends AbstractCacheManager{

	private Collection<? extends MyCache> caches;
	
	protected Collection<? extends Cache> loadCaches() {
		 return this.caches;
	}
    
	 public void setCaches(Collection<? extends MyCache> caches) { 
	     this.caches = caches; 
	   } 
	 
}
