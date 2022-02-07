package cs09.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb"
                    , "naneun", "qhdks123!");;

            return conn;
        } catch (Exception ex) {
            throw new RuntimeException("Connection Error!");
        }
    }
}
