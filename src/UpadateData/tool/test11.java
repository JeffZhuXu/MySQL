package UpadateData.tool;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test11 {
	public static void main(String[] args) throws SQLException {
		Connection sziitConnection = Database.getConnectionIcheck();
		Statement aStatement = sziitConnection.createStatement();
		ResultSet teacherResultSet = aStatement.executeQuery("select distinct real_name from teacher  limit 0,1");
		while(teacherResultSet.next()){
			System.out.println("¿œ ¶√˚≥∆£∫"+teacherResultSet.getString(1));
		}
		sziitConnection.close();
	}
	
}
