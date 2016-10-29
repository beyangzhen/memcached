package com.beyang.cn;

public class MemcachedTest {
	public static void main(String[] args){
		boolean flag = MemcachedManager.add("email", "bruce@yeah.net");
		System.out.println("add Flag:" + flag);
		
		String email = (String)MemcachedManager.get("email");
		System.out.println("email:>>" + email); 
		
		MemcachedManager.update("email", "123@qq.com");
		String email2 = (String)MemcachedManager.get("email");
		System.out.println("email:>>" + email2); 
		
		MemcachedManager.delete("email");
		String email3 = (String)MemcachedManager.get("email");
		System.out.println("email:>>" + email3); 
		
	}
}
