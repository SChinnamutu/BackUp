package com.github.elizabetht.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.github.elizabetht.model.Student;

public interface StudentMapper {
	
	@Insert("INSERT INTO student(id,name, age,,address) VALUES (#{id},#{name}, #{age}, #{address}")
	public void save(Student student);
		
	@Select("SELECT id as id, name as name , age as age, address as address FROM student WHERE name = #{name}")
	public List<Student> getStudent(String name);
	
	@Select("SELECT id as id, name as name , age as age, address as address FROM student")
	public Student listStudent(String name);


}
