package util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by sunil on 5/25/16.
 */
public class DbConnection {


        private Connection dbConnection;

        public DbConnection() throws Exception {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://localhost:3306/servlet";
            String user = "root";
            String password = "sunil123";
            dbConnection = DriverManager.getConnection(url, user, password);
        }

        public Connection getDbConnection() {
            return dbConnection;
        }


}
