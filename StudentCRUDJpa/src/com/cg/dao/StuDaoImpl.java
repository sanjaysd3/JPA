package com.cg.dao;

import java.util.*;

import javax.management.Query;
import javax.persistence.*;

import com.cg.bean.Stu;
import com.cg.util.JPAUtil;

public class StuDaoImpl implements StudentDao{
	
	EntityManager entiManager=null;
	EntityTransaction entTrans=null;


	public StuDaoImpl() {
		entiManager=JPAUtil.getEntMgr();
	}

	@Override
	public int addStudent(Stu stu) {
		entTrans=entiManager.getTransaction();
		entTrans.begin();
		entiManager.persist(stu);
		entTrans.commit();
		return 0;
	}

	@Override
	public Stu getStuById(int rNo) {
		Stu stu=entiManager.find(Stu.class, rNo);
	    return stu;
	}

	@Override
	public List<Stu> getAllstu() {
		String stuQry="SELECT s FROM Stu s";
		javax.persistence.Query myQuery=entiManager.createQuery(stuQry,Stu.class);
		List<Stu> stuList=myQuery.getResultList();
		return stuList;
	}

	@Override
	public Stu deleteStuByRollNo(int rNo) {
		entTrans=entiManager.getTransaction();
		entTrans.begin();
		Stu st=entiManager.find(Stu.class, rNo);
		entiManager.remove(st);
		entTrans.commit();
		return st;
	}

	@Override
	public void updateStu(Stu stu) {
		entTrans=entiManager.getTransaction();
		entTrans.begin();
		entiManager.merge(stu);
		entTrans.commit();
		
	}

	@Override
	public List<Stu> getStuByName(String nm) {
		String selQry="SELECT s FROM Stu s WHERE s.stuName=:snm";
		TypedQuery qry=entiManager.createQuery(selQry, Stu.class);
		qry.setParameter("snm",nm);
		List<Stu> stl=qry.getResultList();
		return stl;
	}

}
