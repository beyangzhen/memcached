package com.beyang.cn;

import com.danga.MemCached.MemCachedClient;

public class MemcachedManager {
	
	// 获取和memcached服务增删改查的类
	public static MemCachedClient getClient() {
		return Memcache.getInstance().getClient();
	}
	
	/**
	 * 查询
	 * */
	public static Object get(String key) {
		return getClient().get(key);
	}
	
	/**
	 * 新增
	 * */
	public static boolean add(String key,Object obj) {
		return getClient().add(key, obj);
	}
	
	/**
	 * 删除
	 * */
	public static boolean delete(String key) {
		return getClient().delete(key);
	}
	
	/**
	 * 修改
	 * */
	public static boolean update(String key,Object value) {
		return getClient().set(key, value);
	}
}

