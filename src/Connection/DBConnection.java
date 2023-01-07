package Connection;
import java.sql.SQLException;
import java.util.Properties;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;


public class DBConnection 
{    
   final static String DB_URL="jdbc:oracle:thin:@OracleDB2_high?TNS_ADMIN=/Users/Neel_Esh/Downloads/Wallet_OracleDB2";
   final static String DB_USER_NAME="filetrackingapp";
   final static String DB_PASS="Abcde1234567";
   private static OracleConnection conn=null;
   static 
   {
       try
       {
           Properties pr=new Properties();
           pr.put(OracleConnection.CONNECTION_PROPERTY_USER_NAME, DB_USER_NAME);
           pr.put(OracleConnection.CONNECTION_PROPERTY_PASSWORD, DB_PASS);
           pr.put(OracleConnection.CONNECTION_PROPERTY_DEFAULT_ROW_PREFETCH,"20");
           OracleDataSource ods = new OracleDataSource();
           ods.setURL(DB_URL);
           ods.setConnectionProperties(pr);
           conn=(OracleConnection)ods.getConnection();
           
       }
       catch(SQLException ex)
       {
           ex.printStackTrace();
           System.out.println("Error in DBConnection :- ");
       }
   }
   
   public static OracleConnection getConnection()throws SQLException
   {
       return conn;
   }
   
   public static void closeConnection()
   {
       try
       {    
           if(conn!=null)
                conn.close();
       }
       catch(SQLException ex)
       {
           ex.printStackTrace();
           System.out.println("Error while Closing Conn ");
       }
       
   }
}
