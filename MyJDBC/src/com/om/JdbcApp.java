package com.om;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcApp {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","omkar");
		Statement stm=con.createStatement();
		//String s1="Create table student(sid int,sname varchar(30),sdept varchar(30))";
		//	stm.execute(s1);
			System.out.println("table student created");
	String s2="insert into student values(111,'omkar','ece')";
//String s3="insert into student values(222,'ram','eee')";
	stm.execute(s2);
//		stm.execute(s3);
	//	stm.execute("alter table student add gender varchar(20)");
	//	stm.execute("alter table student drop column email");
//		//stm.execute("alter table student modify gender int");
	//ResultSet rs=stm.executeQuery("select * from student");
	//System.out.println(rs.toString());

	System.out.println("quary execuated");
	con.close();
	}

}
