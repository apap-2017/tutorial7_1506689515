package com.example.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Many;

import com.example.model.CourseModel;
import com.example.model.StudentModel;

@Mapper
public interface CourseMapper {
	@Select("select student.npm, name, gpa " +
			"from student join studentcourse " +
			"on student.npm = studentcourse.npm " +
			"where studentcourse.id_course = #{id_course}"		
			)
	List<StudentModel> selectStudents (@Param("id_course") String id_course);
	
	
	@Select("select id_course,name,credits from course where id_course = #{id_course}")
	@Results(value = {
			@Result(property="idCourse", column="id_course"),
			@Result(property="students", column="id_course",
					javaType = List.class,
					many=@Many(select="selectStudents"))
			
	})
	CourseModel selectCourse (@Param("id_course") String id_course);
	
}
