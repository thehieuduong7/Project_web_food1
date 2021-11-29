package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static final String serverName="DESKTOP-AV5GUUN\\SQLEXPRESS";
	private static final String dbName = "BanHang";
	private static final String instanceName="";//"SQLEXPRESS";
	private static final String portNumber = "1433";
	private static final String user = "sa";
	private static final String password = "123";
	
	public Connection getConnection() throws Exception{
		String url = "jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instanceName+";databaseName="+dbName;
		if(instanceName.length()==0) 
			url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection con = DriverManager.getConnection(url,user,password);
		return con;
	}
    public static void main(String[] args) {
		try {
			System.out.println(new DBConnect().getConnection());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
