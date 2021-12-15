package com.controller.config;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
	private static final String serverName="DESKTOP-AV5GUUN\\SQLEXPRESS";
	private static final String dbName = "BanHang";
	private static final String instanceName="";//"SQLEXPRESS";
	private static final String portNumber = "1433";
	private static final String user = "sa";
	private static final String password = "123";
	private static Connection con;
	public DBConnect() {

	}
	public static Connection getConnection(){
		if(DBConnect.con==null) {
			try {
				String url = "jdbc:sqlserver://"+serverName+":"+portNumber+"\\"+instanceName+";databaseName="+dbName;
				if(instanceName.length()==0) 
					url = "jdbc:sqlserver://"+serverName+":"+portNumber+";databaseName="+dbName;
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection con = DriverManager.getConnection(url,user,password);
				DBConnect.con=con;
				return con;
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return null;
	}
	
	
    public static void main(String[] args) {
		try {
			System.out.println(DBConnect.getConnection());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
