package com.terabits.dao;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.terabits.mapper.UserMapper;
import com.terabits.meta.vo.ConsumesVO;
import com.terabits.meta.vo.RechargesVO;
import com.terabits.meta.vo.UserVO;

/** 
* @author 作者Vladimir E-mail: gyang.shines@gmail.com
* @version 创建时间：2017年12月5日 下午5:25:37 
* 类说明 
*/

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
    private UserMapper userMapper;
	
	
	public List<RechargesVO> selectRecharge(String beginTime, String endTime, String phone)  throws Exception{
		return userMapper.selectRecharge(beginTime, endTime, phone);
	}

	public List<ConsumesVO> selectConsume(String beginTime, String endTime, String phone)  throws Exception{
		return userMapper.selectConsume(beginTime, endTime, phone);
	}
	
	public int insertPresent(String openid, String phone, double present, double prebalance, double postbalance, String orderod)  throws Exception{
		return userMapper.insertPresent(openid, phone, present, prebalance, postbalance, orderod);
	}
	
	public List<UserVO> selectUserInfo(String phone)  throws Exception{
		return userMapper.selectUserInfo(phone);
	}

	public int updateUserPresent(double present, String phone)  throws Exception{
		return userMapper.updateUserPresent(present, phone);
	}
	
}
