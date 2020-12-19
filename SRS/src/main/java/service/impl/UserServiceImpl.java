package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.IUserDAO;
import service.IUserService;
import util.MD5;
import vo.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDAO userDao;
	
	@Override
	public Map<String, Object> checkLogin(User user) {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String,Object>();
		User userResult=userDao.get(user.getName());
		if(userResult == null){
			map.put("code", 2);
			map.put("info", "用户名不存在");
		}
		else{
			if(!user.getPassword().equals(userResult.getPassword())){
				map.put("code", 3);
				map.put("info", "密码不正确");
			}
			else{
				map.put("code", 0);
				map.put("info", "登录成功");
			}
		}
		return map;
	}
}

