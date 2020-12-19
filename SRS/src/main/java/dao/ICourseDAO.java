package dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import vo.Course;

@Repository
public interface ICourseDAO {
	public ArrayList<Course> get();
}
