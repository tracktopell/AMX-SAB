package com.aeromexico.sab.backend.localapp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

/**
 * com.aeromexico.sab.backend.localapp.DBInstaller
 * @author alfredo
 */
public class DBInstaller {
	private static final String CONN_PROP = "/jdbc_derby_embbeded_connection.properties";
	
	public static void installServerDB(){
		Properties prop = new Properties();
		try {			
			prop.load(DBInstaller.class.getResourceAsStream(CONN_PROP));
		}catch(IOException ioe){
			System.err.println("=>PATH:"+CONN_PROP);
			ioe.printStackTrace(System.err);
			return;
		}
		
				
		String driver  = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_CLASS_DRIVER);
		String url     = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_URL);
		String user    = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_USER);
		String password= prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_PASSWORD);
		
		String scripts[]= new String[]{ 
			//"classpath:/sql/DROP_SCHEMMA_DEV.DERBY.SQL",
			"classpath:/sql/CREATE_SCHEMMA_DEV.DERBY.SQL",
			"classpath:/sql/FIRST_DATA_DEV.DERBY.SQL",
			"classpath:/sql/UTIL_QUERYS.DERBY.SQL"
		};
		
		for(String script:scripts){
			DBCommandExec.main(new String[]{driver,url,user,password,script});
		}
	}
	
	public static void dropAllTablesInDB(){
		Properties prop = new Properties();
		try {			
			prop.load(DBInstaller.class.getResourceAsStream(CONN_PROP));
		}catch(IOException ioe){
			System.err.println("=>PATH:"+CONN_PROP);
			ioe.printStackTrace(System.err);
			return;
		}
						
		String driver  = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_CLASS_DRIVER);
		String url     = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_URL);
		String user    = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_USER);
		String password= prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_PASSWORD);
		
		
		Connection connection = null;
		DatabaseMetaData metaData = null;
		connection = DBCommandExec.createConnection(driver, url, user, password);
		
		if(connection != null) {
			try {
				metaData = connection.getMetaData();
				ResultSet rs = metaData.getTables(null, null, "%", null);
				while (rs.next()) {
					System.out.println("TABLE:==>>["+rs.getString(1)+"]["+rs.getString(2)+"]["+rs.getString(3)+"]");
				}
				
			}catch(SQLException se){
				se.printStackTrace(System.err);
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		dropAllTablesInDB();
		installServerDB();
	}
}
