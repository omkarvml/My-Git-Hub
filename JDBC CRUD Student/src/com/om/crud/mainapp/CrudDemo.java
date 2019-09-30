package com.om.crud.mainapp;

import java.sql.SQLException;

public class CrudDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	CrudDao dao=new CrudDao();
		
		dao.addStudent();
									
		dao.getStudent(1);

		dao.getStudents();
	
		dao.update(1);
		
		dao.deletebyID(1);
		
		dao.deleteAll();
	}

}
