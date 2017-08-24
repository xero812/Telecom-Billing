import java.sql.*;
import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HomeLoginScreen extends javax.swing.JFrame 
{
    
    String JDBC_DRIVER,DB_URL,USER,PASS,sql;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    String regpwd;
    int regid;
    private String[] args;
          
    public HomeLoginScreen() 
    {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        head2 = new javax.swing.JLabel();
        head1 = new javax.swing.JLabel();
        register_button = new javax.swing.JButton();
        register_label = new javax.swing.JLabel();
        login_label = new javax.swing.JLabel();
        login_id_label = new javax.swing.JLabel();
        login_pwd_label = new javax.swing.JLabel();
        login_id = new javax.swing.JTextField();
        login_pwd = new javax.swing.JPasswordField();
        login_button = new javax.swing.JButton();
        homepg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 1290, 900));
        setLocationByPlatform(true);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 1290, 900));
        setMaximumSize(new java.awt.Dimension(577, 410));
        setMinimumSize(new java.awt.Dimension(577, 410));
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        head2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        head2.setText("Billing System");
        getContentPane().add(head2);
        head2.setBounds(330, 0, 230, 70);

        head1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        head1.setForeground(new java.awt.Color(240, 240, 240));
        head1.setText("Telecom");
        getContentPane().add(head1);
        head1.setBounds(190, 10, 140, 50);

        register_button.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        register_button.setForeground(new java.awt.Color(0, 204, 255));
        register_button.setText("Register");
        register_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(register_button);
        register_button.setBounds(30, 200, 120, 40);

        register_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        register_label.setForeground(new java.awt.Color(255, 255, 255));
        register_label.setText("New!! Register Here!!");
        getContentPane().add(register_label);
        register_label.setBounds(30, 150, 190, 50);

        login_label.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        login_label.setText("Login Here!!");
        getContentPane().add(login_label);
        login_label.setBounds(410, 200, 140, 40);

        login_id_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        login_id_label.setForeground(new java.awt.Color(0, 51, 51));
        login_id_label.setText("Customer ID :");
        getContentPane().add(login_id_label);
        login_id_label.setBounds(320, 250, 120, 20);

        login_pwd_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        login_pwd_label.setForeground(new java.awt.Color(0, 0, 51));
        login_pwd_label.setText("Password :");
        getContentPane().add(login_pwd_label);
        login_pwd_label.setBounds(320, 280, 110, 20);

        login_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_idActionPerformed(evt);
            }
        });
        getContentPane().add(login_id);
        login_id.setBounds(440, 240, 120, 30);
        getContentPane().add(login_pwd);
        login_pwd.setBounds(440, 280, 120, 30);

        login_button.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        login_button.setForeground(new java.awt.Color(0, 153, 255));
        login_button.setText("Proceed");
        login_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_buttonActionPerformed(evt);
            }
        });
        getContentPane().add(login_button);
        login_button.setBounds(400, 320, 100, 30);

        homepg.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        homepg.setForeground(new java.awt.Color(255, 255, 255));
        homepg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/homepg.jpg"))); // NOI18N
        homepg.setText("Telecom");
        getContentPane().add(homepg);
        homepg.setBounds(0, 0, 560, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void connect()throws ClassNotFoundException, SQLException
    {
    JDBC_DRIVER = "com.mysql.jdbc.Driver";
    DB_URL = "jdbc:mysql://localhost:3306/adesh";
    USER = "root";
    PASS = "adesh";
    conn = null;
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(DB_URL,USER,PASS);
    stmt = conn.createStatement();
    sql="select * from adesh.new_table"; 
    rs = stmt.executeQuery(sql);
    }
   
    
    public void login()throws ClassNotFoundException, SQLException
    {
    int flag=0;    
    sql = "SELECT id,pwd FROM new_table";
    rs = stmt.executeQuery(sql) ;
    while(rs.next())
      {
      int id  = rs.getInt("id");
      String pwd=rs.getString("pwd");
      
      if(regid==id || regpwd==pwd)
          {
          flag=1;
          int output=JOptionPane.showConfirmDialog(this,"Direct to Login Page!!", "Just a click away!!", JOptionPane.YES_NO_OPTION);
          if(output==JOptionPane.YES_OPTION)
            {
                
                            
            sql="update adesh.new_table SET flag=1 where  id="+regid+"";
            stmt.executeUpdate(sql);
      

            this.setVisible(false);
            LoggedN.main(args);
            }
          }
      }
    
      if(flag==0)
      {
      JOptionPane.showMessageDialog(this,"Incorrect Id or Password");    
      }
      
      
    }
    
    
    private void register_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_buttonActionPerformed
     this.setVisible(false);
     Registerr obj=new Registerr();
     obj.setVisible(true);

// TODO add your handling code here:
    }//GEN-LAST:event_register_buttonActionPerformed

    private void login_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_buttonActionPerformed

      regid=Integer.parseInt(login_id.getText());
      regpwd=login_pwd.getText();
        try {
            connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HomeLoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HomeLoginScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
          try {
              login();
          } catch (ClassNotFoundException ex1) {
              Logger.getLogger(HomeLoginScreen.class.getName()).log(Level.SEVERE, null, ex1);
          } catch (SQLException ex1) {
              Logger.getLogger(HomeLoginScreen.class.getName()).log(Level.SEVERE, null, ex1);
          }
        
        
  
    }//GEN-LAST:event_login_buttonActionPerformed
    
       
    private void login_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_login_idActionPerformed

    public static void main(String args[])throws ClassNotFoundException, SQLException {
             try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeLoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeLoginScreen().setVisible(true);
            }
        });
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel head1;
    private javax.swing.JLabel head2;
    private javax.swing.JLabel homepg;
    private javax.swing.JButton login_button;
    private javax.swing.JTextField login_id;
    private javax.swing.JLabel login_id_label;
    private javax.swing.JLabel login_label;
    private javax.swing.JPasswordField login_pwd;
    private javax.swing.JLabel login_pwd_label;
    private javax.swing.JButton register_button;
    private javax.swing.JLabel register_label;
    // End of variables declaration//GEN-END:variables
}
