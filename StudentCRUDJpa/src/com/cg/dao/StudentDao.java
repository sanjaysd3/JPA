package com.cg.dao;

import java.util.List;

import com.cg.bean.Stu;

public interface StudentDao {
	
	public int addStudent(Stu stu);
	public Stu getStuById(int rNo);
	public List<Stu> getAllstu();
	public Stu deleteStuByRollNo(int rNo);
	public void updateStu(Stu stu);
	public List<Stu> getStuByName(String nm);
	

}
