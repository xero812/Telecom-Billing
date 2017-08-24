import java.sql.*;
import javax.swing.*;


public class LoggedIn extends javax.swing.JFrame
{

    String JDBC_DRIVER,DB_URL,USER,PASS,sql;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    String regname, regphno,regpwd,regcarrier,regspec;
    int regid;
    
    
    public LoggedIn()
        {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        payment = new javax.swing.JButton();
        l_name = new javax.swing.JLabel();
        l_id = new javax.swing.JLabel();
        l_carrier = new javax.swing.JLabel();
        l_spectrum = new javax.swing.JLabel();
        l_call = new javax.swing.JLabel();
        l_callamt = new javax.swing.JLabel();
        l_data = new javax.swing.JLabel();
        l_dataamt = new javax.swing.JLabel();
        l_totalamt = new javax.swing.JLabel();
        l_phno = new javax.swing.JLabel();

        jLabel20.setText("jLabel20");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(655, 475));
        setMinimumSize(new java.awt.Dimension(655, 475));
        setPreferredSize(new java.awt.Dimension(655, 475));
        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("Welcome To Telecom Billing User Portal!!");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 0, 480, 60);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 90, 80, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Customer ID :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 120, 110, 17);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("Carrier :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(60, 150, 80, 17);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Spectrum :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 170, 90, 30);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setText("Call Duration till now (min) :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(60, 210, 180, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Data Spent till now (MB) :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(60, 270, 170, 30);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Call Amount (INR) : ");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(60, 240, 140, 20);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel9.setText("Data Amount (INR) :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(60, 310, 140, 20);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Total Payable Amount (INR) :");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(60, 340, 190, 17);

        update.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        update.setText("Update Account");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(120, 390, 170, 30);

        payment.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        payment.setText("Procced To Payment");
        getContentPane().add(payment);
        payment.setBounds(340, 390, 220, 30);

        l_name.setBackground(new java.awt.Color(255, 255, 0));
        l_name.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_name.setText("...");
        getContentPane().add(l_name);
        l_name.setBounds(490, 90, 150, 17);

        l_id.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_id.setText("...");
        getContentPane().add(l_id);
        l_id.setBounds(490, 120, 150, 17);

        l_carrier.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_carrier.setText("...");
        getContentPane().add(l_carrier);
        l_carrier.setBounds(490, 150, 150, 17);

        l_spectrum.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_spectrum.setText("...");
        getContentPane().add(l_spectrum);
        l_spectrum.setBounds(490, 180, 150, 17);

        l_call.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_call.setText("...");
        getContentPane().add(l_call);
        l_call.setBounds(490, 210, 150, 17);

        l_callamt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_callamt.setText("...");
        getContentPane().add(l_callamt);
        l_callamt.setBounds(490, 240, 150, 17);

        l_data.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_data.setText("...");
        getContentPane().add(l_data);
        l_data.setBounds(490, 284, 150, 10);

        l_dataamt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_dataamt.setText("...");
        getContentPane().add(l_dataamt);
        l_dataamt.setBounds(490, 314, 150, 10);

        l_totalamt.setFont(new java.awt.Font("Times New Roman", 3, 14)); // NOI18N
        l_totalamt.setText("...");
        getContentPane().add(l_totalamt);
        l_totalamt.setBounds(490, 340, 150, 17);

        l_phno.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        l_phno.setForeground(new java.awt.Color(240, 240, 240));
        l_phno.setText("..........");
        getContentPane().add(l_phno);
        l_phno.setBounds(270, 170, 90, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        Update obj=new Update();
        obj.setVisible(true);
    }//GEN-LAST:event_updateActionPerformed


    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        
        LoggedIn obj=new LoggedIn();
       obj.connect();
    //    obj.display();
        
 
        
        
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
            java.util.logging.Logger.getLogger(LoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoggedIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
                      
        java.awt.EventQueue.invokeLater(() -> {
            new LoggedIn().setVisible(true);
        });
    
        
    
    }
    
    
    
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
    System.out.println("Helloc");
    System.out.println(rs.getString("name"));
    }  
   
    public void display()throws ClassNotFoundException, SQLException
    {
    //sql = "SELECT * FROM adesh.new_table";
    //rs = stmt.executeQuery(sql);
    System.out.println(rs.getString("name"));
    //l_name=new JLabel(rs.getString("name"));
    //l_id=new JLabel(rs.getString("id"));
    //l_carrier=new JLabel(rs.getString("carrier"));
    //l_spectrum=new JLabel(rs.getString("spectrum"));
    //l_call=new JLabel(rs.getString("callno"));
    //l_callamt=new JLabel(rs.getString("callbill"));
    //l_data=new JLabel(rs.getString("datano"));
    //l_dataamt=new JLabel(rs.getString("databill"));
    //l_totalamt=new JLabel(rs.getString("totalbill"));
    }
    
    

   
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel l_call;
    private javax.swing.JLabel l_callamt;
    private javax.swing.JLabel l_carrier;
    private javax.swing.JLabel l_data;
    private javax.swing.JLabel l_dataamt;
    private javax.swing.JLabel l_id;
    private javax.swing.JLabel l_name;
    private javax.swing.JLabel l_phno;
    private javax.swing.JLabel l_spectrum;
    private javax.swing.JLabel l_totalamt;
    private javax.swing.JButton payment;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
