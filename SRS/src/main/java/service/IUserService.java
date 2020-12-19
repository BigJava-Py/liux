package service;

import java.util.Map;

import vo.User;

public interface IUserService {
	//检查登录，返回检查结果，存放在map中
	public Map<String,Object> checkLogin(User user);

}
