import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
public class Registerr extends javax.swing.JFrame 
{   
      
    String JDBC_DRIVER,DB_URL,USER,PASS,sql,sqle;
    Connection conn;
    Statement stmt;
    ResultSet rs;
    
    String regname, regphno,regpwd,regcarrier,regspec;
    int regid;
    private String[] args;
               
    public void connect()throws SQLException,ClassNotFoundException
    {
    JDBC_DRIVER = "com.mysql.jdbc.Driver";
    DB_URL = "jdbc:mysql://localhost:3306/adesh";
    USER = "root";
    PASS = "adesh";
    Class.forName("com.mysql.jdbc.Driver");
    conn = DriverManager.getConnection(DB_URL,USER,PASS);
    stmt = conn.createStatement();
    }
     
    public Registerr() 
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        register_label = new javax.swing.JLabel();
        name_label = new javax.swing.JLabel();
        phno_label = new javax.swing.JLabel();
        spectrum_label = new javax.swing.JLabel();
        password_label = new javax.swing.JLabel();
        id_label = new javax.swing.JLabel();
        carrier_label = new javax.swing.JLabel();
        reg_name_txtfield = new javax.swing.JTextField();
        reg_phno_txtfield = new javax.swing.JTextField();
        reg_id_txtfield = new javax.swing.JTextField();
        reg_pwd_pwdfield = new javax.swing.JPasswordField();
        spec_g = new javax.swing.JComboBox();
        comp_name = new javax.swing.JComboBox();
        submit_btton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 700, 500));
        setMaximumSize(new java.awt.Dimension(700, 450));
        setMinimumSize(new java.awt.Dimension(700, 450));
        getContentPane().setLayout(null);

        register_label.setBackground(new java.awt.Color(255, 255, 255));
        register_label.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        register_label.setForeground(new java.awt.Color(240, 240, 240));
        register_label.setText("Ready to Register!! Let's try out then!!");
        register_label.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                register_labelMouseWheelMoved(evt);
            }
        });
        getContentPane().add(register_label);
        register_label.setBounds(160, 20, 395, 28);

        name_label.setBackground(new java.awt.Color(51, 51, 255));
        name_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        name_label.setForeground(new java.awt.Color(240, 240, 240));
        name_label.setText("Name :");
        getContentPane().add(name_label);
        name_label.setBounds(90, 80, 106, 31);

        phno_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        phno_label.setForeground(new java.awt.Color(240, 240, 240));
        phno_label.setText("Phone No. :");
        getContentPane().add(phno_label);
        phno_label.setBounds(90, 130, 92, 22);

        spectrum_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        spectrum_label.setForeground(new java.awt.Color(240, 240, 240));
        spectrum_label.setText("Choose Spectrum :");
        getContentPane().add(spectrum_label);
        spectrum_label.setBounds(90, 250, 165, 22);

        password_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        password_label.setForeground(new java.awt.Color(240, 240, 240));
        password_label.setText("Password :");
        getContentPane().add(password_label);
        password_label.setBounds(90, 210, 95, 22);

        id_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        id_label.setForeground(new java.awt.Color(240, 240, 240));
        id_label.setText("Customer ID :");
        getContentPane().add(id_label);
        id_label.setBounds(90, 170, 111, 22);

        carrier_label.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        carrier_label.setForeground(new java.awt.Color(255, 255, 255));
        carrier_label.setText("Carrier :");
        getContentPane().add(carrier_label);
        carrier_label.setBounds(90, 290, 91, 22);

        reg_name_txtfield.setBackground(new java.awt.Color(240, 240, 240));
        reg_name_txtfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reg_name_txtfield.setMaximumSize(new java.awt.Dimension(200, 20));
        reg_name_txtfield.setMinimumSize(new java.awt.Dimension(200, 20));
        reg_name_txtfield.setPreferredSize(new java.awt.Dimension(1000, 200));
        reg_name_txtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_name_txtfieldActionPerformed(evt);
            }
        });
        getContentPane().add(reg_name_txtfield);
        reg_name_txtfield.setBounds(440, 80, 160, 30);

        reg_phno_txtfield.setBackground(new java.awt.Color(240, 240, 240));
        reg_phno_txtfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reg_phno_txtfield.setMaximumSize(new java.awt.Dimension(200, 20));
        reg_phno_txtfield.setMinimumSize(new java.awt.Dimension(200, 20));
        reg_phno_txtfield.setPreferredSize(new java.awt.Dimension(1000, 200));
        reg_phno_txtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_phno_txtfieldActionPerformed(evt);
            }
        });
        getContentPane().add(reg_phno_txtfield);
        reg_phno_txtfield.setBounds(440, 120, 160, 30);

        reg_id_txtfield.setBackground(new java.awt.Color(240, 240, 240));
        reg_id_txtfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reg_id_txtfield.setMaximumSize(new java.awt.Dimension(200, 20));
        reg_id_txtfield.setMinimumSize(new java.awt.Dimension(200, 20));
        reg_id_txtfield.setPreferredSize(new java.awt.Dimension(1000, 200));
        reg_id_txtfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_id_txtfieldActionPerformed(evt);
            }
        });
        getContentPane().add(reg_id_txtfield);
        reg_id_txtfield.setBounds(440, 160, 160, 30);

        reg_pwd_pwdfield.setBackground(new java.awt.Color(240, 240, 240));
        reg_pwd_pwdfield.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        reg_pwd_pwdfield.setMaximumSize(new java.awt.Dimension(200, 20));
        reg_pwd_pwdfield.setMinimumSize(new java.awt.Dimension(200, 20));
        reg_pwd_pwdfield.setPreferredSize(new java.awt.Dimension(1000, 200));
        reg_pwd_pwdfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reg_pwd_pwdfieldActionPerformed(evt);
            }
        });
        getContentPane().add(reg_pwd_pwdfield);
        reg_pwd_pwdfield.setBounds(440, 200, 160, 30);

        spec_g.setBackground(new java.awt.Color(240, 240, 240));
        spec_g.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        spec_g.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2G", "3G", "4G", "5G" }));
        spec_g.setMaximumSize(new java.awt.Dimension(200, 20));
        spec_g.setMinimumSize(new java.awt.Dimension(200, 20));
        spec_g.setPreferredSize(new java.awt.Dimension(1000, 200));
        spec_g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spec_gActionPerformed(evt);
            }
        });
        getContentPane().add(spec_g);
        spec_g.setBounds(440, 240, 160, 30);

        comp_name.setBackground(new java.awt.Color(240, 240, 240));
        comp_name.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        comp_name.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bharti Airtel", "BSNL", "Idea", "Reliance", "Tata DoCoMo", "Vodafone", "Uninor" }));
        comp_name.setMaximumSize(new java.awt.Dimension(200, 20));
        comp_name.setMinimumSize(new java.awt.Dimension(200, 20));
        comp_name.setPreferredSize(new java.awt.Dimension(1000, 200));
        comp_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comp_nameActionPerformed(evt);
            }
        });
        getContentPane().add(comp_name);
        comp_name.setBounds(440, 280, 160, 30);

        submit_btton.setBackground(new java.awt.Color(255, 255, 255));
        submit_btton.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        submit_btton.setText("Submit");
        submit_btton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_bttonActionPerformed(evt);
            }
        });
        getContentPane().add(submit_btton);
        submit_btton.setBounds(300, 370, 105, 37);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/shiny-galaxy-12425.jpg"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(200, 20));
        jLabel1.setMinimumSize(new java.awt.Dimension(200, 20));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void register_labelMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_register_labelMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_register_labelMouseWheelMoved

    private void reg_name_txtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_name_txtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reg_name_txtfieldActionPerformed

    private void reg_phno_txtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_phno_txtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reg_phno_txtfieldActionPerformed

    private void reg_id_txtfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_id_txtfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reg_id_txtfieldActionPerformed

    private void reg_pwd_pwdfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reg_pwd_pwdfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reg_pwd_pwdfieldActionPerformed

    private void spec_gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spec_gActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spec_gActionPerformed

    private void comp_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comp_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comp_nameActionPerformed

    private void submit_bttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_bttonActionPerformed

        try 
        {
            regname=reg_name_txtfield.getText();
            regphno=reg_phno_txtfield.getText();
            regid=Integer.parseInt(reg_id_txtfield.getText());
            regpwd=reg_pwd_pwdfield.getText();
            regcarrier=comp_name.getSelectedItem().toString();
            regspec=spec_g.getSelectedItem().toString();
            System.out.println(regid+"\t"+regpwd);
            connect();
            submit();
        } 
        catch (ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(Registerr.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }//GEN-LAST:event_submit_bttonActionPerformed
    
    public void submit()throws SQLException,ClassNotFoundException
    {
    int flag=0;
    sqle = "SELECT id,phno FROM new_table";
    ResultSet rs = stmt.executeQuery(sqle) ;
    while(rs.next())
      {
      int id  = rs.getInt("id");
      String phno=rs.getString("phno");
      if(regid==id)
        {
      JOptionPane.showMessageDialog(this,"Id already taken");  
        System.out.println("Id or Phone no. already taken");
        flag=1;
        
       break;
        }
      }
    rs = stmt.executeQuery(sqle) ;
    while(rs.next())
      {
      int id  = rs.getInt("id");
      String phno=rs.getString("phno");
      if(regphno==phno || regphno.length()!=10)
        {
        JOptionPane.showMessageDialog(this,"Invalid Phone No.");  
        System.out.println("Id or Phone no. already taken");
        flag=1;
        break;
        }
      }
    if(flag==0)
      
    {
      
    int output=JOptionPane.showConfirmDialog(this,"Are You Sure to register!!", "Confirm!!", JOptionPane.OK_CANCEL_OPTION);
     if(output==JOptionPane.OK_OPTION)
     {
      sql="INSERT INTO new_table(id,pwd,name,phno,carrier,spectrum,flag)VALUES('"+regid+"','"+regpwd+"','"+regname+"','"+regphno+"','"+regcarrier+"','"+regspec+"',0)";
      stmt.executeUpdate(sql);
      
      conn.close();
      this.setVisible(false);
      HomeLoginScreen.main(args);
      
     }
      }
    
    }

    
    
    
    public static void main(String args[])throws SQLException,ClassNotFoundException {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(Registerr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registerr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registerr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registerr.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
System.out.println("Hello");        
        
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run() {
                new Registerr().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel carrier_label;
    private javax.swing.JComboBox comp_name;
    private javax.swing.JLabel id_label;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel name_label;
    private javax.swing.JLabel password_label;
    private javax.swing.JLabel phno_label;
    private javax.swing.JTextField reg_id_txtfield;
    private javax.swing.JTextField reg_name_txtfield;
    private javax.swing.JTextField reg_phno_txtfield;
    private javax.swing.JPasswordField reg_pwd_pwdfield;
    private javax.swing.JLabel register_label;
    private javax.swing.JComboBox spec_g;
    private javax.swing.JLabel spectrum_label;
    private javax.swing.JButton submit_btton;
    // End of variables declaration//GEN-END:variables
}
