package derby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
	
	
// use singleton pattern ,,,,,,,,,,,,,,^)^


public  class SgsDb {
	private static SgsDb pSelf = null;
	private String dbName = "myDB";
	private  String dbURL = "jdbc:derby:" + dbName + ";create=true";
	private  String tableName = "restaurants";
	private  Connection conn = null;
	private  Statement stmt = null;

//	public static void main(String[] args) {
//		createConnection();
//		insertRestaurants(5, "LaVals", "Berkeley");
//		selectRestaurants();
//		shutdown();
//	}

	private SgsDb(){
		createConnection();
		selectRestaurants();
		shutdown();
	}
	
	public static SgsDb getInstance(){
		return pSelf == null ? (pSelf = new SgsDb()) : pSelf;
	}
	
	private  void createConnection() {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
			// Get a connection
			conn = DriverManager.getConnection(dbURL);
		}catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		catch (Exception except) {
			except.printStackTrace();
		}
	}
	public ResultSet executeQuery(String sql){
		ResultSet results = null;
		try {
			stmt = conn.createStatement();
			results = stmt.executeQuery(sql);
			stmt.close();
			
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
		return results;	
	}
	
	public int executeUpdate(String sql){
		int res = 0;
		try {
			stmt = conn.createStatement();
			res = stmt.executeUpdate(sql);
			stmt.close();
			
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}		
		return res;
	}
	
	private  void insertRestaurants(int id, String restName, String cityName) {
		try {
			stmt = conn.createStatement();
			stmt.execute("insert into " + tableName + " values (" + id + ",'"
					+ restName + "','" + cityName + "')");
			stmt.close();
			
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
	
	private  void selectRestaurants() {
		try {
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from " + tableName);
			ResultSetMetaData rsmd = results.getMetaData();
			int numberCols = rsmd.getColumnCount();
			for (int i = 1; i <= numberCols; i++) {
				// print Column Names
				System.out.print(rsmd.getColumnLabel(i) + "\t\t");
			}

			System.out.println("\n-------------------------------------------------");

			while (results.next()) {
				int id = results.getInt(1);
				String restName = results.getString(2);
				String cityName = results.getString(3);
				System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
			}
			results.close();
			stmt.close();
		} catch (SQLException sqlExcept) {
			sqlExcept.printStackTrace();
		}
	}
	
	public  void shutdown() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				DriverManager.getConnection(dbURL + ";shutdown=true");
				conn.close();
			}
		} catch (SQLException sqlExcept) {

		}

	}
}
