package com.yc137.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;


import com.yc137.domain.TAuthority;
import com.yc137.domain.TRoleAuthority;


/**
 * 自定义标签类
 * @author Administrator
 *
 */
public class AuthorityTld {
	/**
	 * 判断 角色中的 功能权限 是否被选中
	 */
	public static String checked(List<TAuthority> authoritys, Long authorityId){
		if(authoritys!=null && authoritys.size()>0){
			for (TAuthority auth : authoritys) {

				if(auth.getId()==authorityId.longValue()){
				//	System.out.println(auth.getROLE_ID()+":"+authorityId);
					return "checked='checked'";
				}
			}
		}
		return "";
	}
	/**
	 * 判断用户 是否有权限 能否显示 该功能模块
	 */
	public static Boolean allow(Set<TAuthority> authoritys, Long authorityId){
		if(authoritys!=null && authoritys.size()>0){
			
			Iterator<TAuthority> itr = authoritys.iterator();
			while (itr.hasNext()) {
				TAuthority auEnt = itr.next();
				if(auEnt.getId()==authorityId.longValue()){
					
					return true;
				}
			}
		}
		return false;
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
