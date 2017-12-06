package com.terabits.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.terabits.meta.vo.ConsumesVO;
import com.terabits.meta.vo.RechargesVO;
import com.terabits.meta.vo.UserVO;


public interface UserMapper {
	
	public List<RechargesVO> selectRecharge(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("phone") String phone) throws Exception;
	
	public List<ConsumesVO> selectConsume(@Param("beginTime") String beginTime, @Param("endTime") String endTime, @Param("phone") String phone) throws Exception;
	
	public int insertPresent(@Param("openid") String openid, @Param("phone") String phone, @Param("present") double present, @Param("prebalance") double prebalance, @Param("postbalance") double postbalance, @Param("orderid") String orderod) throws Exception;
	
	public List<UserVO> selectUserInfo(@Param("phone") String phone) throws Exception;

	public int updateUserPresent(@Param("present") double present, @Param("phone") String phone) throws Exception;
}
