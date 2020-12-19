package controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.IUserDAO;
import service.IUserService;
import util.CreateImage;
import vo.User;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
	
	@Autowired
	public IUserDAO userdao;
	

	// 用户登录
	@RequestMapping(value = "/ajaxLoginCheck.do", method = RequestMethod.POST)
	@ResponseBody
	//@ResponseBody的作用其实是将java对象转为json格式的数据。
	public Map<String, Object> login(String userName,String password, String vcode, String autoLogin, HttpSession session,
			HttpServletResponse response) {
		//System.out.println(vcode);
		//System.out.println(userName);
		User user=new User(userName,password);
		// 存放返回信息的Map
		Map<String, Object> map = new HashMap<String, Object>();
		// 比较输入的验证码和随机生成的验证码是否相同
		String saveCode = (String) session.getAttribute("verifyCode");
		if (!vcode.equalsIgnoreCase(saveCode)) { // 不同
			// 在map中存放返回数据
			map.put("code", 1);
			map.put("info", "验证码不正确！");
		} else {// 验证码正确
			map = userService.checkLogin(user);
			if (map.get("code").equals("0")) { // 登录成功
				if (autoLogin != null) { // 如果勾选了自动登录复选框
					// 设置cookie
					Cookie cookie1 = new Cookie("userName", user.getName());
					cookie1.setMaxAge(7 * 24 * 24 * 24); // 设置有效期为7天
					response.addCookie(cookie1);
					Cookie cookie2 = new Cookie("password", user.getPassword());
					cookie2.setMaxAge(7 * 24 * 24 * 24); // 设置有效期为7天
					response.addCookie(cookie2);
				}
				
			}
			user=userdao.get(user.getName());
			session.setAttribute("user", user);
		}
		
		return map; // 框架使用MappingJackson2HttpMessageConverter类将java类型转换为json字符串放在response
					// body中
	}

	// 验证码生成
	@RequestMapping(value = "/createVerifyImage.do", method = RequestMethod.GET)
	public void CreateVerifyImage(HttpSession session, HttpServletResponse response) throws IOException {
		// 把验证码图片生成的过程封装在tools包下的CreateVerificationCodeImage类中
		CreateImage createImage = new CreateImage();
		// 产生四位随机字符串
		String vCode = createImage.createCode();
		// 将产生的四位随机字符串存放于session中（存放在session中的数据在一个会话范围内多个程序全局共享），以便验证
		session.setAttribute("verifyCode", vCode);

		// 设置返回的内容
		response.setContentType("img/jpeg");
		// 调用封装的类方法生成指定验证码字符串的内存图片
		BufferedImage image = createImage.CreateImage(vCode);
		// 获取字节流对象
		ServletOutputStream out = response.getOutputStream();
		// 将内存图像输出到浏览器，格式为JPEG
		ImageIO.write(image, "JPEG", out);
		// 刷新输出缓冲器（立即输出，而不用等待输出缓存满后才送至网络）
		out.flush();
		out.close();
	}

	//修改密码
	@RequestMapping(value = "/changePassword.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> changePassword(String oldpassword,String password,String password1, HttpSession session,
			HttpServletResponse response) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		//System.out.println(oldpassword+password+password1+"好");
		User user=(User)session.getAttribute("user");
		//System.out.println("当前用户名"+user.getName());
		map.put("code", 0);
		if(oldpassword.equalsIgnoreCase(user.getPassword())) {
			if(password=="" || password==null) {
				map.put("info","密码不能为空!");
				return map;
			}
			else if(password.equalsIgnoreCase(password1)) {
				user.setPassword(password);
				boolean bool=userdao.update(user);
				if(bool) {
					map.put("code",1);
					map.put("info","修改成功");
				}
			}
			else {
				map.put("info","密码不一致");
			}
		}
		else {
			map.put("info","原密码不正确!");
		}
		return map;
	}
}
