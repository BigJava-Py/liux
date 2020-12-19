package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dao.ICourseDAO;

import vo.Course;

@Controller
public class CourseController {
	@Autowired
	private ICourseDAO dao;
	
	//课程查询
	@RequestMapping(value = "/queryCourse.do", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> login(HttpSession session,HttpServletResponse response) throws Exception {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		ArrayList<Course> rows=dao.get();
		map.put("rows", rows);
		
		return map;
	}

}
