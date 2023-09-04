package crud.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {

    public Connection Link;

    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Link=DriverManager.getConnection("jdbc:mysql://localhost:3306/software", "root", "42391523");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Link;
    }

}

