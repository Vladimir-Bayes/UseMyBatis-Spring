package com.terabits.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.terabits.mapper.LogMapper;

@Repository("logDAO")
public class LogDAO {
	/**
	 * 添加日志
	 * @param name
	 * @param type
	 * @return
	 */
	
	@Autowired
	private LogMapper logMapper;
	
	public int insertLog(String name, int type, String text){
		return logMapper.insertLog(name, type, text);
	}
}
