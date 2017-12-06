package com.terabits.service.impl;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.terabits.dao.LogDAO;
import com.terabits.dao.UserDAO;
import com.terabits.meta.vo.ConsumeVO;
import com.terabits.meta.vo.ConsumesVO;
import com.terabits.meta.vo.RechargeVO;
import com.terabits.meta.vo.RechargesVO;
import com.terabits.meta.vo.UserVO;
import com.terabits.service.UserService;
import com.terabits.utils.RandomTools;

import net.sf.json.JSONArray;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private LogDAO logDAO;

	@Override
	public JSONArray getRecharges(String beginTime, String endTime, String phone){
		List<RechargesVO> rechargesVOs = new ArrayList<RechargesVO>();
		List<RechargeVO> rechargeVOs = new ArrayList<RechargeVO>();
		double money = 0;
		try {
			rechargesVOs = userDAO.selectRecharge(beginTime, endTime, phone);
			for (int i = 0; i < rechargesVOs.size(); i++) {
				RechargeVO rechargeVO = new RechargeVO();
				rechargeVO.setPhone(rechargesVOs.get(i).getPhone());
				rechargeVO.setTime(rechargesVOs.get(i).getTime());
				money = rechargesVOs.get(i).getPayment()+rechargesVOs.get(i).getPresent();
				rechargeVO.setMoney((int) money);
				rechargeVOs.add(rechargeVO);
			}		

			JSONArray jsonArray = JSONArray.fromObject(rechargeVOs);
			return jsonArray;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	@Override
	public JSONArray getConsumes(String beginTime, String endTime, String phone){
		List<ConsumesVO> consumesVOs = new ArrayList<ConsumesVO>();
		List<ConsumeVO> consumeVOs = new ArrayList<ConsumeVO>();
		double money = 0;

		try {
			consumesVOs = userDAO.selectConsume(beginTime, endTime, phone);
			for (int i = 0; i < consumesVOs.size(); i++) {
				ConsumeVO consumeVO = new ConsumeVO();
				consumeVO.setBoxId(consumesVOs.get(i).getBoxId());
				consumeVO.setPhone(consumesVOs.get(i).getPhone());
				consumeVO.setTime(consumesVOs.get(i).getTime());
				consumeVO.setStation(consumesVOs.get(i).getStation());
				money = consumesVOs.get(i).getMoney();
				consumeVO.setMoney((int) money);
				consumeVOs.add(consumeVO);
			}			
			JSONArray jsonArray = JSONArray.fromObject(consumeVOs);
			return jsonArray;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
	@Override
	public int insertPresent(String phone, int payment, String comments, String adminname){
		List<UserVO> userVOs = new ArrayList<UserVO>();
		String user_openid = "";
		double user_recharge = 0;
		double user_present = 0;
		double prebalance = 0;
		double postbalance = 0;
		String nowtime = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
		String orderid = "CPCZ";

		try {
			userVOs = userDAO.selectUserInfo(phone);
			user_openid = userVOs.get(0).getOpenid();
			user_recharge = userVOs.get(0).getRecharge();
			user_present = userVOs.get(0).getPresent();

			orderid = orderid+nowtime+RandomTools.getFixLenthString(3);			
			prebalance = user_present+user_recharge;
			postbalance = prebalance+payment;
			userDAO.insertPresent(user_openid, phone, payment, prebalance, postbalance, orderid);
			userDAO.updateUserPresent(payment+user_present, phone);
			logDAO.insertLog(adminname, 4, comments);
			return 1;				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
