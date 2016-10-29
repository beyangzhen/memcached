package com.beyang.cn;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;

public class Memcache {
	// 单例
	private static Memcache memcache = new Memcache();
	private MemCachedClient memCachedClient = new MemCachedClient();
	
	private Memcache() {
	}
	
	public static Memcache getInstance() {
		return memcache;
	}
	
	//考虑如何去连接memcached服务
	static {
		// 服务器列表
		String[] servers = {"127.0.0.1:11211"};
		//设置服务的权重
		Integer[] weigths = {3};
		
		//获取Sock连接池的实例对象
		SockIOPool pool = SockIOPool.getInstance();
		
		// 设置连接池的服务器地址列表和权重
		pool.setServers(servers);
		pool.setWeights(weigths);
		
		//设置初始化的连接数、最小，最大的连接数
		pool.setInitConn(10);
		pool.setMinConn(5);
		pool.setMaxConn(100000000);
		
		//设置主线程的睡眠时间
		pool.setMaintSleep(30);
		pool.setNagle(false);
		pool.setSocketTO(30);
		pool.getSocketConnectTO();
		
		pool.initialize();
	}
	
	public MemCachedClient  getClient(){
		return memCachedClient;
	}
}
