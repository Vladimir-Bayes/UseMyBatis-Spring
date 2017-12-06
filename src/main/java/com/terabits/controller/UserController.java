package com.terabits.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.terabits.meta.po.AdminPO;
import com.terabits.service.UserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/user/consumption", method = RequestMethod.GET)
	@ResponseBody
	public JSONObject user_consumption(
			@RequestHeader(value="Authorization") String clientToken, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		String phoneString = request.getParameter("phone");
		String beginTimeString = request.getParameter("beginTime");
		String endTimeString = request.getParameter("endTime");
		
		JSONArray jsonArray = userService.getConsumes(beginTimeString, endTimeString, phoneString);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 1);
		jsonObject.put("info", jsonArray);
		return jsonObject;
				
	}
	
	@RequestMapping(value="/user/recharge", method=RequestMethod.GET)
	@ResponseBody
	public JSONObject user_recharge(
			@RequestHeader(value="Authorization") String clientToken, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		AdminPO adminPO = new AdminPO();
		adminPO.setCity("杭州");
		adminPO.setGid(9);
		adminPO.setName("Vladimir");
		adminPO.setPassword("123456");
		adminPO.setType(1);
		
		String phoneString = request.getParameter("phone");
		String beginTimeString = request.getParameter("beginTime");
		String endTimeString = request.getParameter("endTime");
				
		JSONArray jsonArray= userService.getRecharges(beginTimeString, endTimeString, phoneString);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", 1);
		jsonObject.put("info", jsonArray);
		return jsonObject;
	}

	
	@RequestMapping(value="/user/recharge", method = RequestMethod.POST)
	@ResponseBody
	public JSONObject user_recharge_post(
			@RequestHeader(value="Authorization") String clientToken,
			@RequestParam(value="payment") int payment,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		AdminPO adminPO = new AdminPO();
		adminPO.setCity("杭州");
		adminPO.setGid(9);
		adminPO.setName("Vladimir");
		adminPO.setPassword("123456");
		adminPO.setType(1);
		
		String phoneString = request.getParameter("phone");		
		String comments = request.getParameter("comments");
		String adminname = adminPO.getName();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("status", userService.insertPresent(phoneString, payment, comments, adminname));
		return jsonObject;
	}
}
