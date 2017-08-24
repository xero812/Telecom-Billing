import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggedN extends javax.swing.JFrame
{
    
    String JDBC_DRIVER,DB_URL,USER,PASS,sql;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    String regpwd;
    int regid;
    private String[] args;
    

    public LoggedN() throws ClassNotFoundException, SQLException {
        initComponents();
        connect();
        setlabel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lname = new javax.swing.JLabel();
        lid = new javax.swing.JLabel();
        lcarrier = new javax.swing.JLabel();
        lspectrum = new javax.swing.JLabel();
        lcall = new javax.swing.JLabel();
        lcallamt = new javax.swing.JLabel();
        ldata = new javax.swing.JLabel();
        ldataamt = new javax.swing.JLabel();
        ltotal = new javax.swing.JLabel();
        lphno = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        home = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(840, 550));
        setMinimumSize(new java.awt.Dimension(840, 550));
        setPreferredSize(new java.awt.Dimension(840, 550));
        getContentPane().setLayout(null);

        lname.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        lname.setForeground(new java.awt.Color(0, 51, 51));
        getContentPane().add(lname);
        lname.setBounds(330, 60, 310, 60);

        lid.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lid.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(lid);
        lid.setBounds(210, 150, 140, 30);

        lcarrier.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lcarrier.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(lcarrier);
        lcarrier.setBounds(210, 190, 90, 30);

        lspectrum.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lspectrum.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(lspectrum);
        lspectrum.setBounds(210, 230, 130, 30);

        lcall.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lcall.setForeground(new java.awt.Color(0, 102, 102));
        lcall.setText("0");
        getContentPane().add(lcall);
        lcall.setBounds(210, 280, 140, 30);

        lcallamt.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lcallamt.setForeground(new java.awt.Color(0, 102, 102));
        lcallamt.setText("0.00");
        getContentPane().add(lcallamt);
        lcallamt.setBounds(210, 320, 140, 30);

        ldata.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ldata.setForeground(new java.awt.Color(0, 102, 102));
        ldata.setText("0");
        getContentPane().add(ldata);
        ldata.setBounds(210, 380, 150, 30);

        ldataamt.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ldataamt.setForeground(new java.awt.Color(0, 102, 102));
        ldataamt.setText("0.00");
        getContentPane().add(ldataamt);
        ldataamt.setBounds(210, 420, 150, 30);

        ltotal.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        ltotal.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(ltotal);
        ltotal.setBounds(210, 480, 140, 30);

        lphno.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        lphno.setForeground(new java.awt.Color(0, 102, 102));
        getContentPane().add(lphno);
        lphno.setBounds(0, 70, 190, 50);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("Telecom Billing User Portal!!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(180, 0, 480, 60);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Welcome ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(240, 80, 80, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Customer ID :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 160, 100, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Carrier :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 200, 70, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Spectrum :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 240, 100, 17);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Call Duration(mm) :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 290, 150, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Call Amt (INR) :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 330, 130, 17);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Data Spent(MB) :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 390, 140, 17);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Data Amt(INR) :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(10, 430, 114, 17);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Total Amt(INR) :");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(10, 490, 130, 17);

        update.setBackground(new java.awt.Color(0, 153, 153));
        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setForeground(new java.awt.Color(240, 240, 240));
        update.setText("Update Account");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(670, 460, 160, 50);

        home.setBackground(new java.awt.Color(51, 51, 0));
        home.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        home.setForeground(new java.awt.Color(240, 240, 240));
        home.setText("Home");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        getContentPane().add(home);
        home.setBounds(760, 0, 73, 25);

        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Roxtec_Telecom_Greenfield_site_16-9_16.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 830, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
            
        this.setVisible(false);
        try {
                Update.main(args);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_updateActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        
        
        int output=JOptionPane.showConfirmDialog(this,"Are You Sure to Make it over!!", "Confirm!!", JOptionPane.OK_CANCEL_OPTION);
  if(output==JOptionPane.OK_OPTION)      
  {
        try {
            
            sql="update adesh.new_table SET flag=0 where  id>=0";
            stmt.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(LoggedN.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            this.setVisible(false);
            try {
                HomeLoginScreen.main(args);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
  }
    }//GEN-LAST:event_homeActionPerformed

    public void connect()throws ClassNotFoundException, SQLException
    {
        
    JDBC_DRIVER = "com.mysql.jdbc.Driver";
    DB_URL = "jdbc:mysql://localhost:3306/adesh";
    USER = "root";
    PASS = "adesh";
    conn = null;
    Class.forName(JDBC_DRIVER);
    conn = DriverManager.getConnection(DB_URL,USER,PASS);
    stmt = conn.createStatement();
   
    sql="select * from new_table where flag=1"; 
    rs = stmt.executeQuery(sql);
    
    
    }
    
    
    public void setlabel() throws SQLException,ClassNotFoundException
    {
        while(rs.next())
    {
    lname.setText(rs.getString("name"));
    lid.setText(rs.getString("id"));
    lcarrier.setText(rs.getString("carrier"));
    lspectrum.setText(rs.getString("spectrum"));
    lcall.setText(rs.getString("callno"));
    lcallamt.setText(rs.getString("callbill"));
    ldata.setText(rs.getString("datano"));
    ldataamt.setText(rs.getString("databill"));
    ltotal.setText(rs.getString("totalbill"));
    lphno.setText(rs.getString("phno"));
    }
        
        
    }
    
   
    
    public static void main(String args[])throws ClassNotFoundException, SQLException {
        
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoggedN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoggedN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoggedN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoggedN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>    
            
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LoggedN().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(LoggedN.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(LoggedN.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lcall;
    private javax.swing.JLabel lcallamt;
    private javax.swing.JLabel lcarrier;
    private javax.swing.JLabel ldata;
    private javax.swing.JLabel ldataamt;
    private javax.swing.JLabel lid;
    private javax.swing.JLabel lname;
    private javax.swing.JLabel lphno;
    private javax.swing.JLabel lspectrum;
    private javax.swing.JLabel ltotal;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}




