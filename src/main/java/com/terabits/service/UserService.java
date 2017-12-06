package com.terabits.service;

import net.sf.json.JSONArray;

/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2017年12月5日 下午5:28:32 
* 类说明 
*/
public interface UserService {
	public JSONArray getRecharges(String beginTime, String endTime, String phone);

	public JSONArray getConsumes(String beginTime, String endTime, String phone);
	
	public int insertPresent(String phone, int prement, String comments, String adminname);
}
