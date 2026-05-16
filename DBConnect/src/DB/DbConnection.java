/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.*;
/**
 *
 * @author eduos
 */
public class DbConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/agenda?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
    /*public Connection getconnection(){
      // create a mysql database connection
      String myDriver = "org.gjt.mm.mysql.Driver";
      String myUrl = "jdbc:mysql://localhost/test";
      Class.forName(myDriver);
      Connection conn = DriverManager.getConnection(myUrl, "root", "");
      
      Statement st = conn.createStatement();

      // note that i'm leaving "date_created" out of this insert statement
      st.executeUpdate("INSERT INTO users (first_name, last_name, is_admin, num_points) "
          +"VALUES ('Fred', 'Flinstone', false, 10000)");

      conn.close();
    }*/
    
}
