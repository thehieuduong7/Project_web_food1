package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectMySQL {
    private static final String DB_URL = "jdbc:mysql://root@localhost/webfood?"		
    		+ "allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static final String DB_URL_CLOUD = "jdbc:mysql://ugwvdlisgyydugol:ylYw4TwKw7IGmzRoKkOa@"
    		+ "br1m5ieutnnxcbnrvyhk-mysql.services.clever-cloud.com:3306/br1m5ieutnnxcbnrvyhk"
    		+ "?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
    private static Connection con=null;
    public static Connection getConnection() {
    	if(DBConnectMySQL.con==null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				DBConnectMySQL.con = DriverManager.getConnection(DB_URL);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
    	}
        return DBConnectMySQL.con;
    }
    public static void main(String[] args) {
		try {
			System.out.println(DBConnectMySQL.getConnection());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
