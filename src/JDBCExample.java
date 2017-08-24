import java.sql.*;
public class JDBCExample
 {
   
 public static void main(String[] args) throws ClassNotFoundException, SQLException 
{
 
 
 String JDBC_DRIVER = "com.mysql.jdbc.Driver";
 String DB_URL = "jdbc:mysql://localhost:3306/adesh";
 String USER = "root";
 String PASS = "adesh";
 
 Class.forName("com.mysql.jdbc.Driver");
 System.out.println("Connecting to database...");
 Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
 System.out.println("Creating statement...");
 Statement stmt = conn.createStatement();
 String sql1,sql;
 
/* sql = "SELECT id, name,age FROM ss";
 ResultSet rs = stmt.executeQuery(sql) ;
 
 while(rs.next())
              {
                  int id  = rs.getInt("id");
                  String name = rs.getString("name");
                  int age = rs.getInt("age");
                  
                  System.out.println("ID: " + id);
                  System.out.println("\nAge: " + name);
                  System.out.println(",\nAge: " + age);
              }*/
 stmt.execute("update adesh.ss set age=24 where id=3 "); 
       try {
        Thread.sleep(1000);

      } catch (InterruptedException ie) {
        ie.printStackTrace();
       
      conn.close();
   System.out.println("Goodbye!");
}
}
}