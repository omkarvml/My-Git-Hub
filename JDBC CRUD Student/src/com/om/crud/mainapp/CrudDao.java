package com.om.crud.mainapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CrudDao {

	public Student getStudent(int sid) throws ClassNotFoundException, SQLException {
		String q1 = "select * from student where sid=" + sid;
		Student s = new Student();
		s.sid = sid;
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root", "omkar");

		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(q1);
		rs.next();
			String name = rs.getString(1);
			int sub1=rs.getInt(2);
			int sub2=rs.getInt(3);
			int sub3=rs.getInt(4);
			s.sname = name;
			
			System.out.println( name + ":" +sub1+","+sub2+","+sub3);
		return s;
	}

	public Student getStudents() throws ClassNotFoundException, SQLException {
		String q1 = "select * from student";
		Student s = new Student();
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root", "omkar");

		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(q1);
		while (rs.next()) {
			int sid = rs.getInt("sid");
			String name = rs.getString("sname");
			int sub1=rs.getInt("sub1");
			int sub2=rs.getInt("sub2");
			int sub3=rs.getInt("sub3");

			System.out.println(sid + ":" + name + ":"  +sub1+","+sub2+","+sub3);
			
		}
		return s;
	}

	public void addStudent() throws ClassNotFoundException, SQLException {
		String q1="insert into student values(?,?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Student s3=new Student();
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root", "omkar");
		PreparedStatement pst=con.prepareStatement(q1);
		s3.sid=3;
		s3.sname="omakr";
		s3.sub1=35;
		s3.sub2=45;
		s3.sub3=55;
		pst.setInt(1, s3.sid);
		pst.setString(2, s3.sname);
		pst.setInt(3, s3.sub1);
		pst.setInt(4, s3.sub2);
		pst.setInt(5, s3.sub3);
		
		int i=	pst.executeUpdate();
		System.out.println(i+"rows added");

		
	}

	public void update(int sid) throws SQLException, ClassNotFoundException {
		String q1="update student"+" set sname=?"+"set sub1=?"+"set sub2=?"+"set sub3=?"+"where sid=?";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root", "omkar");
		PreparedStatement pst=con.prepareStatement(q1);
		String sname="omkarsj";
		int sub1=39;
		int sub2=38;
		int sub3=50;
		pst.setString(1, sname);
		pst.setInt(2, sub1);
		pst.setInt(3, sub2);
		pst.setInt(4, sub3);
		pst.setInt(5, sid);
		int i=	pst.executeUpdate();
		System.out.println(i+"rows updated");
		
	}

	public void deletebyID(int sid) throws SQLException, ClassNotFoundException {
		String q1="delete from student where sid=? ";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root", "omkar");
		PreparedStatement pst=con.prepareStatement(q1);
		
		int sid1=1;
		pst.setInt(1, sid1);
		
		pst.execute();
		System.out.println("one row deleted successfully by id");
		
		
			}

	public void deleteAll() throws ClassNotFoundException, SQLException {
		String q1="truncate student ";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_details", "root", "omkar");
		PreparedStatement pst=con.prepareStatement(q1);
				pst.executeUpdate();
		System.out.println("table truncated/deleted successfully");
		
		
		
		
	}

}
