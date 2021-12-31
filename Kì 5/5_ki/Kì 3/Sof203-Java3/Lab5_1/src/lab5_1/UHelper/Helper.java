
package UHelper;

import java.sql.Connection;
import java.sql.DriverManager;


public class Helper {
  public static  Connection ketnoi(String database){
       try {
            String user="sa";
            String pass="songlong";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url="jdbc:sqlserver://DESKTOP-L0KTUMB:1433;databaseName="+database;
            Connection cn= DriverManager.getConnection(url, user, pass);
            return cn;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
  }
}
