import java.io.*;
import java.sql.*;
class newclass
{
    public static void main(String args[])throws IOException,SQLException, ClassNotFoundException
    {
    String JDBC_DRIVER,DB_URL,USER,PASS,sql;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
 
    JDBC_DRIVER = "com.mysql.jdbc.Driver";
    DB_URL = "jdbc:mysql://localhost:3306/adesh";
    USER = "root";
    PASS = "adesh";
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(DB_URL,USER,PASS);
    stmt = conn.createStatement();
    String regid="123";
    sql="insert into new_table(id)VALUES('"+regid+"')"; 
    rs = stmt.executeQuery(sql);
    }
       
    }
