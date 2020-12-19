package dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import vo.User;



@Repository
public interface IUserDAO {
	//按用户名进行查询，返回User对象
	public User get(@Param("name") String name);
	
	//新增一个User对象,返回布尔值
	public boolean insert(User user);
	
	//按User对象的用户名修改其它信息
	public boolean update(User user);
}
