package com.tracktopell.openlegacy.fullstackexam.localapp;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author alfredo
 */
public class DBInstaller {
	public static void installServerDB(){
		Properties prop = new Properties();
		try {
			final String connectionProperties = "/jdbc_derby_server_connection.properties";
			final InputStream propertiesInputStream = DBInstaller.class.getResourceAsStream(connectionProperties);
			if(propertiesInputStream == null){
				throw new IOException("Cna` read from:"+connectionProperties);
			}
			prop.load(propertiesInputStream);
		}catch(IOException ioe){
			ioe.printStackTrace(System.err);
			System.exit(1);
		}
		
				
		String driver  = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_CLASS_DRIVER);
		String url     = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_URL);
		String user    = prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_USER);
		String password= prop.getProperty(DBCommandExec.PARAM_CONNECTION_JDBC_PASSWORD);
		
		String scripts[]= new String[]{ 
			"classpath:/sql/DROP_SCHEMMA_DEV.DERBY.SQL",
			"classpath:/sql/CREATE_SCHEMMA_DEV.DERBY.SQL",
			"classpath:/sql/FIRST_DATA_DEV.DERBY.SQL",
			"classpath:/sql/UTIL_QUERYS.DERBY.SQL"
		};
		
		for(String script:scripts){
			DBCommandExec.main(new String[]{driver,url,user,password,script});
		}
	}	
	
	public static void main(String[] args) {
		installServerDB();
	}
}
