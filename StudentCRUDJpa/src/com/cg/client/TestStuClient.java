package com.cg.client;

import java.util.List;
import java.util.Scanner;

import com.cg.bean.Stu;
import com.cg.dao.StuDaoImpl;
import com.cg.dao.StudentDao;

public class TestStuClient {

	public static void main(String[] args) {
		
		StudentDao stuDao=new StuDaoImpl();
		Scanner sc=new Scanner(System.in);
		//System.out.println("Enter Roll No: ");
		//int rNo=sc.nextInt();
		System.out.println("Enter name: ");
		String nm=sc.next();
		
		Stu st=new Stu();
		//st.setRollNo(rNo);
		st.setStuName(nm);
		
		stuDao.addStudent(st);
		System.out.println(" Student is added successfully");
		
		
		System.out.println("********Fetch All Record***********");
		System.out.println("");
		List<Stu> stuList=stuDao.getAllstu();
		System.out.println("RollNo\t\t StuName");
		for(Stu tempStu:stuList)
		{
			System.out.println(tempStu.getRollNo()+"\t\t"+tempStu.getStuName());
		}
		System.out.println("Which Roll No info u want?");
		int rno=sc.nextInt();
		Stu stu=stuDao.getStuById(rno);
		System.out.println("Student Info is :");
		System.out.println("RollNo\t\t StuName");
		System.out.println(stu.getRollNo()+"\t\t"+stu.getStuName());
		
		System.out.println("************Fetch Record Based on Name********");
		System.out.println("Enter Name: ");
		String name=sc.next();
		List<Stu> stuList2=stuDao.getStuByName(name);
		System.out.println("RollNo\t\t StuName");
		for(Stu tempStu:stuList2)
		{
			System.out.println(tempStu.getRollNo()+"\t\t"+tempStu.getStuName());
		}
		
		System.out.println("************Delete Student Record By Roll No********");
		System.out.println("Which Roll No Info U Want to delete?");
		int rnno=sc.nextInt();
		Stu stuu=stuDao.deleteStuByRollNo(rnno);
		System.out.println(stuu.getRollNo()+" is deleted");
		
		
		System.out.println("************Update Student Record By Roll No********");
		System.out.println("Which Roll No Info U Want to Update?");
		int rnnon=sc.nextInt();
		System.out.println("what do you want to Update ?");
		System.out.println("Enter New Name : ");
		String str=sc.next();
		Stu st3=new Stu();
		st3.setRollNo(rnnon);
		st3.setStuName(str);
		stuDao.updateStu(st3);
		System.out.println("Record is updated");
		
		

		

	}

}
