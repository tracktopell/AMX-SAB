#!/bin/bash
java -jar SQLCommander.jar -driverClass org.apache.derby.jdbc.ClientDriver -url "jdbc:derby://localhost:1527/AMX_SAB_DB_DEV" -user AMX_SAB_DEV_USR -password AMX_SAB_DEV_PWD <  ../../AMX-SAB-BackEnd/AMX-SAB-BackEnd-persistence/src/main/resources/sql/DELETE_ALLDATA_DEV.DERBY.SQL
java -jar SQLCommander.jar -driverClass org.apache.derby.jdbc.ClientDriver -url "jdbc:derby://localhost:1527/AMX_SAB_DB_DEV" -user AMX_SAB_DEV_USR -password AMX_SAB_DEV_PWD <  ../../AMX-SAB-BackEnd/AMX-SAB-BackEnd-persistence/src/main/resources/sql/FIRST_DATA_DEV.DERBY.SQL