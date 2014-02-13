package db.accessor;

import java.util.*;
import java.sql.*;

/**
 *
 * @author ndaley
 */
public class DB_MySql implements DBAccessor{
    private Connection conn;
    
    public List<Map> getRecords(String tableName, List<String> columnNames)
    throws SQLException, Exception {
        List<Map> Records = new ArrayList();
        
        Statement stmt = null;
        ResultSet rs = null;
        ResultSetMetaData metaData = null;
        Map record = null;
        
        String sql = "SELECT ";
        for(String col : columnNames){
            sql += col + ",";
        }
        sql = sql.substring(0,sql.length()-1);
        sql += " FROM " + tableName;
        
        String driverClassName = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/restaurant";
        String userName = "root";
        String password = "admin";

        try {
                  Class.forName (driverClassName);
                  conn = DriverManager.getConnection(url, userName, password);
        }
        catch ( ClassNotFoundException cnfex ) {
           System.err.println(
                  "Error: Failed to load JDBC driver!" );
           cnfex.printStackTrace();
           System.exit( 1 );  // terminate program
        }
        catch ( SQLException sqlex ) {
           System.err.println( "Error: Unable to connect to database!" );
           sqlex.printStackTrace();
           System.exit( 1 );  // terminate program
        }
                
                
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            metaData = rs.getMetaData();
            final int fields=metaData.getColumnCount();

            while( rs.next() ) {
                    record = new HashMap();
                    for( int i=1; i <= fields; i++ ) {
                            try {
                                    record.put( metaData.getColumnName(i), rs.getObject(i) );
                            } catch(NullPointerException npe) { 
                                    // no need to do anything... if it fails, just ignore it and continue
                            }
                    } // end for
                    Records.add(record);
            } // end while

            } catch (SQLException sqle) {
                    throw sqle;
            } catch (Exception e) {
                    throw e;
            } finally {
                    try {
                            stmt.close();
                            conn.close();
                    } catch(SQLException e) {
                            throw e;
                    } // end try
            }
        
        return Records;
    }
    
    public static void main(String[] args) {
        DB_MySql db = new DB_MySql();
        List<Map> Records = null;
        List<String> columnNames = new ArrayList();
        columnNames.add("*");
        
        try{
            Records = db.getRecords("menu", columnNames);
        }catch(SQLException se){
            System.err.println("SQL Exception in DB_MySql!");
        }catch(Exception e){
            System.err.println("Exception in DB_MySql!");
        }
        
        for(Map m : Records){
            System.out.print(m.get("item_id")+ "/");
            System.out.print(m.get("item_name")+ "/");
            System.out.print(m.get("item_price"));
            System.out.println("");
        }
        
    }
}
