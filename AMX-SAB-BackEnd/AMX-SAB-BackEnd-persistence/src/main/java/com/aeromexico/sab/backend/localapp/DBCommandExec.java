package com.aeromexico.sab.backend.localapp;

import java.io.*;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * com.tracktopell.openlegacy.fullstackexam.dbengine.DBCommandExec
 * @author Alfredo Estrada
 */
public class DBCommandExec {
	private static       Properties versionProperties;
	
    public static final String PARAM_CONNECTION_JDBC_CLASS_DRIVER = "jdbc.driverClassName";
	public static final String PARAM_CONNECTION_JDBC_URL = "jdbc.url";
    public static final String PARAM_CONNECTION_JDBC_USER = "jdbc.user";
    public static final String PARAM_CONNECTION_JDBC_PASSWORD = "jdbc.password";

    protected Properties connectionProperties;
    protected static boolean printInfoDBOnStartup = false;	
	protected static boolean continueWithErrors = true;
	protected static String rdbms = "[SQL]";

    protected static Logger logger = Logger.getLogger(DBCommandExec.class.getSimpleName());

    public DBCommandExec(Properties p) throws IOException {
        logger.fine("init(): try to load properties :" + p);
        this.connectionProperties = p;
    }

    public void setPrintInfoDBOnStartup(boolean printInfoDBOnStartup) {
        this.printInfoDBOnStartup = printInfoDBOnStartup;
    }

    public boolean isPrintInfoDBOnStartup() {
        return printInfoDBOnStartup;
    }
    
    public Connection getConnection() throws IllegalStateException, SQLException {
        Connection conn = null;
        try {
            logger.fine("getConnection: ...try get Connection (using " + connectionProperties + ")for Create DB.");
            Class.forName(connectionProperties.getProperty(PARAM_CONNECTION_JDBC_CLASS_DRIVER)).newInstance();
        } catch (ClassNotFoundException ex) {
            throw new IllegalStateException(ex.getMessage());
        } catch (InstantiationException ex) {
            throw new IllegalStateException(ex.getMessage());
        } catch (IllegalAccessException ex) {
            throw new IllegalStateException(ex.getMessage());
        }

        logger.fine("getConnection:Ok, Loaded JDBC Driver.");
        String urlConnection = connectionProperties.getProperty("jdbc.url");

        if (urlConnection.contains("${db.name}")) {
            urlConnection = urlConnection.replace("${db.name}", connectionProperties.getProperty("db.name"));
            logger.fine("getConnection:replacement for variable db.name, now urlConnection=" + urlConnection);
        }

        conn = DriverManager.getConnection(
                urlConnection,
                connectionProperties.getProperty(PARAM_CONNECTION_JDBC_USER),
                connectionProperties.getProperty(PARAM_CONNECTION_JDBC_PASSWORD));

        logger.fine("getConnection:OK Connected to DB.");
        if(printInfoDBOnStartup){
            printDBInfo(conn);
        }
        return conn;
    }

    private void printDBInfo(Connection conn) throws SQLException {
        DatabaseMetaData metaData = conn.getMetaData();

        System.out.println("\t=>>SchemaTerm:" + metaData.getSchemaTerm());

        System.out.println("Schemas:");

        ResultSet schemas = metaData.getSchemas();
        while (schemas.next()) {
            System.out.println("\t=>>" + schemas.getString("TABLE_SCHEM") + ", " + schemas.getString("TABLE_CATALOG"));
        }
        schemas.close();
        ResultSet tablesRS = metaData.getTables(null, null, "%", null);
        System.out.println("Tables:");
        Statement statement = conn.createStatement();
        while (tablesRS.next()) {
            String schemaTableIter = tablesRS.getString(2);
            String tableNameIter = tablesRS.getString(3);
            if (schemaTableIter.toLowerCase().contains("sys")) {
                continue;
            }
            System.out.print("\t" + schemaTableIter + "." + tableNameIter + "(");
            ResultSet executeQuery = statement.executeQuery("SELECT * FROM " + schemaTableIter + "." + tableNameIter + " WHERE 1=2");
            ResultSetMetaData emptyTableMetaData = executeQuery.getMetaData();
            int columnCount = emptyTableMetaData.getColumnCount();
            for (int columNumber = 1; columNumber <= columnCount; columNumber++) {
                if (columNumber > 1) {
                    System.out.println(",");
                } else {
                    System.out.println("");
                }
                int columnSize = emptyTableMetaData.getPrecision(columNumber);
                int columnDD = emptyTableMetaData.getScale(columNumber);
                int nullableFlag = emptyTableMetaData.isNullable(columNumber);
                boolean autoIncrementFlag = emptyTableMetaData.isAutoIncrement(columNumber);

                System.out.print("\t\t" + emptyTableMetaData.getColumnName(columNumber) + "  " + emptyTableMetaData.getColumnTypeName(columNumber));
                if (columnSize > 0) {
                    System.out.print(" ( " + columnSize);
                    if (columnDD > 0) {

                    }
                    System.out.print(" )");
                }
                if (nullableFlag == 1) {
                    System.out.print(" NULL");
                }
                if (autoIncrementFlag) {
                    System.out.print(" AUTOINCREMENT");
                }
            }
            System.out.println();
            System.out.println("\t);");
            executeQuery.close();

            
			ResultSet resColumnsTable = metaData.getColumns(null, schemaTableIter, tableNameIter, null);
			for(int columnCounter = 0;resColumnsTable.next();columnCounter++) {
				if(columnCounter>0){
					System.out.println(",");
				}else{
					System.out.println("");
				}
				
				
				System.out.print("\t\t" + 
						resColumnsTable.getString("COLUMN_NAME")+ "  " + resColumnsTable.getString("TYPE_NAME"));
				
				int columnSize = resColumnsTable.getInt("COLUMN_SIZE");
				int columnDD   = resColumnsTable.getInt("DECIMAL_DIGITS");
				int nullableFlag = resColumnsTable.getInt("NULLABLE");
				boolean autoIncrementFlag = resColumnsTable.getString("IS_AUTOINCREMENT").equalsIgnoreCase("yes");
				
				if(columnSize>0) {
					System.out.print(" ( " + columnSize);
					if(columnDD>0){
					
					}
					System.out.print(" )");
				}
				if(nullableFlag ==1) {
					System.out.print(" NULL");
				}
				if(autoIncrementFlag) {
					System.out.print(" AUTOINCREMENT");
				}				
			}
			System.out.println();
			System.out.println("\t);");
			resColumnsTable.close();
            
        }
        tablesRS.close();

        System.out.println("=======================================");
    }

    public void executeScriptFrom(InputStream is,String rdbmsPrompt, Connection conn, boolean continueWithErrors, boolean prinToConsole, boolean repeatInput)
            throws SQLException, IOException {

        BufferedReader brInput = null;
        ResultSet rs = null;
        ResultSetMetaData rsmd = null;
        String sqlInput = null;
		String promt1   = rdbmsPrompt+"> ";
		String promt2   = "      >>";
        int updateCount;
        int numberOfColumns;
        
        prinToConsole = true;

        try {
            conn.setAutoCommit(true);
            brInput = new BufferedReader(new InputStreamReader(is));

            if (prinToConsole) {
                System.out.print(promt1);
            }
            Statement sexec = conn.createStatement();

            String fullSql = "";
            while ((sqlInput = brInput.readLine()) != null) {
                if (repeatInput) {
                    if (prinToConsole) {
                        System.out.println(sqlInput);
                    }
                }
                if (sqlInput.trim().toLowerCase().equals("exit")) {
                    break;
                } else if (sqlInput.trim().toLowerCase().equals("!dbinfo")) {
                    printDBInfo(conn);
                    if (prinToConsole) {
                        System.out.println("");
                        System.out.print(promt1);
                    }
                    continue;
                }
                if (sqlInput.trim().length() == 0 || sqlInput.startsWith("--")) {
                    if (prinToConsole) {
                        System.out.print(promt1);
                    }
                    continue;
                } else if (sqlInput.trim().endsWith(";")) {
                    fullSql += " " + sqlInput.trim();
                    try {
                        fullSql = fullSql.replaceAll(";$", "");
                        boolean resultExecution = false;
                        if (fullSql.toLowerCase().startsWith("call ")) {
                            //fullSql = fullSql.replace("call ","");
                            //System.err.println("==>>conn.prepareCall("+fullSql+")");
                            CallableStatement callSt = conn.prepareCall(fullSql);

                            resultExecution = callSt.execute();
                            rs = resultExecution ? callSt.getResultSet() : null;
                        } else {
                            resultExecution = sexec.execute(fullSql);
                            rs = resultExecution ? sexec.getResultSet() : null;
                        }

                        if (resultExecution && rs != null) {

                            rsmd = rs.getMetaData();
                            numberOfColumns = rsmd.getColumnCount();
                            if (prinToConsole) {                                
								System.out.print("\n--------------\n");
                            }
                            
                            for (int j = 0; j < numberOfColumns; j++) {
                                if (prinToConsole) {
                                    System.out.print((j > 0 ? "|'" : "'") + rsmd.getColumnClassName(j + 1) + "'");
                                }
                            }
                            if (prinToConsole) {           
								System.out.print("\n--------------\n");
                            }
                            for (int j = 0; j < numberOfColumns; j++) {
                                if (prinToConsole) {
                                    System.out.print((j > 0 ? "|'" : "'") + rsmd.getColumnLabel(j + 1) + "'");
                                }
                            }
                            if (prinToConsole) {                                
								System.out.print("\n--------------\n");
                            }
                            int numRows;
                            for (numRows = 0; rs.next(); numRows++) {                                
                                if (prinToConsole) {
                                    //System.out.print("\n\t\t{");
                                }
                                for (int j = 0; j < numberOfColumns; j++) {

                                    if (prinToConsole) {
										
                                        Object o = rs.getObject(j + 1);
                                        if (o == null) {
                                            System.out.print((j > 0 ? "|NULL" : "NULL"));
                                        } else if (o.getClass().equals(String.class)) {
                                            System.out.print((j > 0 ? "|" : "") + "'" + rs.getString(j + 1) + "'");
                                        } else {
                                            System.out.print((j > 0 ? "|" : "") + rs.getString(j + 1));
                                        }
                                    }
                                }
                                if (prinToConsole) {
									System.out.print("\n");
                                    //System.out.print(" }");
                                }
                            }
                            rs.close();
                            if (prinToConsole) {                                
								System.out.print("--------------\n");
								System.out.print(numRows+" rows.\n");
                            }
                            if (prinToConsole) {
                                //System.out.print("};\n");
                            }
                        } else {
                            updateCount = sexec.getUpdateCount();
                            if (prinToConsole) {
								System.out.print("--------------\n");
                                System.out.print(updateCount + " rows affected.\n");
                            }
                        }
                    } catch (Exception exExec) {
                        if (prinToConsole) {
                            exExec.printStackTrace(System.err);
                            //System.err.print("\t[x]:" + exExec.getMessage() + "\n");
                        }
                        if (!continueWithErrors) {
                            break;
                        }
                    }
                    fullSql = "";
                    if (prinToConsole) {
                        System.out.print(promt1);
                    }
                } else {
                    fullSql += " " + sqlInput.trim();
                    if (prinToConsole) {
                        System.out.print(promt2);
                    }
                }
            }
            if (prinToConsole) {
				System.out.println("{EOF}");
                System.out.println("Script executed.");
            }
        } catch (SQLException ex) {
            throw ex;
        } catch (IOException ex2) {
            throw ex2;
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (Exception ex3) {
                ex3.printStackTrace(System.err);
            }
        }
    }

	public int shellDB(boolean continueWithErrors) {
		return shellDB(System.in, continueWithErrors);
	}
	
    public int shellDB(InputStream is,boolean continueWithErrors) {
		boolean prinToConsole = true;
		boolean repeatInput   = false;
		Console console = null;
		int exitStatus = -1;
		try{
			console = System.console();
			logger.fine("shellDB: console = "+console);
			if(console == null){
				repeatInput   = true;
			}
		}catch(Exception e){
			logger.log(Level.SEVERE, "->shellDB:", e);
		}
        logger.fine("shellDB: --------------");

        Connection conn = null;

        try {
            conn = getConnection();
            logger.fine("shellDB:OK, the DB exist !!");
            logger.fine("shellDB:Ready, Now read from stdin(is pipe?"+repeatInput+"), connectionForInit=" + conn);
            executeScriptFrom(is, rdbms, conn, continueWithErrors,prinToConsole, repeatInput );
            logger.fine("-> EOF stdin, end");
			exitStatus = 0;
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Something with the reading script:" + ex.getLocalizedMessage(), ex);
			exitStatus = 5;
        } catch (IllegalStateException ex) {
            logger.log(Level.SEVERE, "Something with the Classpath and JDBC Driver:" + ex.getLocalizedMessage(), ex);
			exitStatus = 6;
        } catch (SQLException ex) {
            logger.log(Level.SEVERE, "Something with the JDBC Connection:" + ex.getLocalizedMessage(), ex);
			exitStatus = 7;
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex1) {
                logger.log(Level.SEVERE, ex1.getLocalizedMessage(), ex1);
				exitStatus = 8;
            }
        }
		return exitStatus;
    }

	public static void execSript(String driver,String url,String user,String password,String script){
		int exitStatus = 0;
		rdbms  = " derby";
		
		DBCommandExec dbInstaller = null;
		InputStream isScript = null;
        try {
			
			Properties parameters4CreateAndExecute=new Properties();

			parameters4CreateAndExecute.put(PARAM_CONNECTION_JDBC_CLASS_DRIVER, driver);
			parameters4CreateAndExecute.put(PARAM_CONNECTION_JDBC_URL         , url);
			parameters4CreateAndExecute.put(PARAM_CONNECTION_JDBC_USER        , user);
			parameters4CreateAndExecute.put(PARAM_CONNECTION_JDBC_PASSWORD    , password);
			
            dbInstaller = new DBCommandExec(parameters4CreateAndExecute);
            dbInstaller.setPrintInfoDBOnStartup(printInfoDBOnStartup);   
			
            if( script.startsWith("classpath:")){
				isScript = DBCommandExec.class.getResourceAsStream(script.substring(script.indexOf(":")+1));
			} else {
				isScript = new FileInputStream(script);
			}
            exitStatus = dbInstaller.shellDB(isScript, continueWithErrors);
			
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        } 
	}
	
	public static Connection createConnection(String driver,String url,String user,String password){
		int exitStatus = 0;
		rdbms  = " derby";
		
		DBCommandExec dbInstaller = null;
		InputStream isScript = null;
		Connection connection = null;
        try {
			
			Properties parameters4CreateAndExecute=new Properties();

			parameters4CreateAndExecute.put(PARAM_CONNECTION_JDBC_CLASS_DRIVER, driver);
			parameters4CreateAndExecute.put(PARAM_CONNECTION_JDBC_URL         , url);
			parameters4CreateAndExecute.put(PARAM_CONNECTION_JDBC_USER        , user);
			parameters4CreateAndExecute.put(PARAM_CONNECTION_JDBC_PASSWORD    , password);
			
            dbInstaller = new DBCommandExec(parameters4CreateAndExecute);
            dbInstaller.setPrintInfoDBOnStartup(printInfoDBOnStartup);   
			
			connection = dbInstaller.getConnection();
			
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        } 
		return connection;
	}
	
	public static void main(String[] args) {
		
		if(args.length != 5){
			System.err.println("use: ${java} com.tracktopell.openlegacy.fullstackexam.dbengine.DBCommandExec  driver url user password  script");
			System.exit(1);
		}
		
		String driver  = args[0];
		String url     = args[1];
		String user    = args[2];
		String password= args[3];
		String script  = args[4];
		
		execSript( driver, url, user, password, script);
	}

}
