import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Update extends javax.swing.JFrame 

{
    
    String JDBC_DRIVER,DB_URL,USER,PASS,sql;
    Connection conn;
    PreparedStatement st1;
    Statement stmt;
    ResultSet rs,r1;
    
    String regpwd;
    int regid;
    private String[] args;
    
    
    
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
   
    public Update() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        updt_call = new javax.swing.JTextField();
        updt_data = new javax.swing.JTextField();
        makechange = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setPreferredSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Update Your Account!!");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(170, 50, 290, 20);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(240, 240, 240));
        jLabel2.setText("Recent Duration Of Calls (min) :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(60, 150, 220, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Recent Data Spent (MB) :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 210, 170, 20);

        updt_call.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(updt_call);
        updt_call.setBounds(370, 150, 90, 23);

        updt_data.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(updt_data);
        updt_data.setBounds(370, 210, 90, 23);

        makechange.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        makechange.setText("Make Changes");
        makechange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                makechangeActionPerformed(evt);
            }
        });
        getContentPane().add(makechange);
        makechange.setBounds(190, 280, 160, 25);

        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/1368143910.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 580, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void makechangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_makechangeActionPerformed
        
        try {
            connect();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
 
int output=JOptionPane.showConfirmDialog(this,"Are You Sure to make changes!!", "Confirm!!", JOptionPane.OK_CANCEL_OPTION);
  if(output==JOptionPane.OK_OPTION)                     
  {
            
            try {
                connect();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    try {
        st1=conn.prepareStatement("select callno,datano,callbill,databill,totalbill from new_table where flag=1");
        r1=st1.executeQuery();
    } catch (SQLException ex) {
        Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            
            int call = 0,data = 0,callnew=0,datanew=0;
            double callbill=0.0,databill=0.0,totalbill=0.0,callbillnew=0.0,databillnew=0.0;
            
    try {   
        callnew=Integer.parseInt(rs.getString(7));
        datanew=+Integer.parseInt(rs.getString(8));
        callbillnew=Integer.parseInt(rs.getString(9));
        databillnew=+Integer.parseInt(rs.getString(10));
        System.out.println(callnew);
        
    } catch (SQLException ex) {
        Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            
            
        call = Integer.parseInt(updt_call.getText())+callnew;
        data=Integer.parseInt(updt_data.getText())+datanew;
        callbill= 0.80*call+callbillnew;
        databill= 0.24*data+databillnew;
        totalbill=callbill+databill;
           
    
            
            
            
            sql="update adesh.new_table SET callno="+call+",datano="+data+",callbill="+callbill+",databill="+databill+",totalbill="+totalbill+" where  flag=1";
            
            try {
                stmt.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            this.setVisible(false);
            
            try {
                LoggedN.main(args);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
            }
        
  }     
    }//GEN-LAST:event_makechangeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])throws ClassNotFoundException, SQLException {
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
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton makechange;
    private javax.swing.JTextField updt_call;
    private javax.swing.JTextField updt_data;
    // End of variables declaration//GEN-END:variables
}
