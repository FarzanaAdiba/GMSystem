
package SwingPackage;

import gms.Member;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author USER
 */
public class Members extends javax.swing.JFrame {

    /**
     * Creates new form members
     * @throws java.lang.ClassNotFoundException
     */
    public Members()  {
        initComponents();
        Show_Members_In_JTable();
    }
    //Connecting to db
     public Connection getConnection()
   {
       Connection con=null;
       try {
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym", "root","");
           JOptionPane.showMessageDialog(null,"DB Connected");
           return con;
       } catch (SQLException e) {
           JOptionPane.showMessageDialog(null,"Not Connected");
           e.printStackTrace();
           return null;
       }
   }
    // get a list of users from mysql database
   public ArrayList<Member> getMemberList()
   {
       ArrayList<Member> memberList = new ArrayList<Member>();
       Connection connection = getConnection();
       
       String query = "SELECT * FROM  `member ";
       Statement st;
       ResultSet rs;
       
       try {
           st = connection.createStatement();
           rs = st.executeQuery(query);
           Member member;
           while(rs.next())
           {
               member = new Member(rs.getInt("id"),rs.getString("name"),rs.getString("phn_no"),rs.getDate("start_date"),rs.getFloat("fee"));
               memberList.add(member);
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
       return memberList;
   }
    // Display Data In JTable
   
   public void Show_Members_In_JTable()
   {
       ArrayList<Member> list = getMemberList();
       DefaultTableModel model = (DefaultTableModel)jTable_Display_Members.getModel();
       Object[] row = new Object[5];
       for(int i = 0; i < list.size(); i++)
       {
           row[0] = list.get(i).getId();
           row[1] = list.get(i).getName();
           row[2] = list.get(i).getPhnNo();
           row[3] = list.get(i).getStart_date();
           row[4] = list.get(i).getFee();
           
           
           model.addRow(row);
       }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_ID = new javax.swing.JTextField();
        jTextField_NAME = new javax.swing.JTextField();
        jTextField_MOBILE = new javax.swing.JTextField();
        jTextField_FEE = new javax.swing.JTextField();
        jDateChooser_START = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Display_Members = new javax.swing.JTable();
        jButton_Insert = new javax.swing.JButton();
        jButton_Delete = new javax.swing.JButton();
        jButton_Update = new javax.swing.JButton();
        jButton_MENU = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Member data");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Mobile no.");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Start date");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Fee");

        jTextField_ID.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField_NAME.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField_MOBILE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jTextField_FEE.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jDateChooser_START.setDateFormatString("yyyy-mm-dd");

        jTable_Display_Members.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Mobile no.", "Startdate", "Fee"
            }
        ));
        jTable_Display_Members.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_Display_MembersMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_Display_Members);

        jButton_Insert.setBackground(new java.awt.Color(255, 51, 255));
        jButton_Insert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Insert.setText("INSERT");
        jButton_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_InsertActionPerformed(evt);
            }
        });

        jButton_Delete.setBackground(new java.awt.Color(255, 51, 255));
        jButton_Delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Delete.setText("DELETE");
        jButton_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_DeleteActionPerformed(evt);
            }
        });

        jButton_Update.setBackground(new java.awt.Color(255, 51, 204));
        jButton_Update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_Update.setText("UPDATE");
        jButton_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateActionPerformed(evt);
            }
        });

        jButton_MENU.setBackground(new java.awt.Color(51, 255, 102));
        jButton_MENU.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton_MENU.setText("MENU");
        jButton_MENU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MENUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_Delete))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_NAME, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(jTextField_ID)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_FEE)
                            .addComponent(jTextField_MOBILE)
                            .addComponent(jDateChooser_START, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))))
                .addGap(76, 76, 76)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_Update)
                        .addGap(96, 96, 96)
                        .addComponent(jButton_MENU, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_ID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_NAME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(41, 41, 41)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_MOBILE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDateChooser_START, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField_FEE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_Insert)
                            .addComponent(jButton_Delete)
                            .addComponent(jButton_Update))
                        .addGap(53, 53, 53))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_MENU, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_InsertActionPerformed

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO member(id,name,phn_no,start_date,fee)"
                    + "values(?,?,?,?,?) ");
            ps.setString(1, jTextField_ID.getText());
            ps.setString(2, jTextField_NAME.getText());
             ps.setString(3, jTextField_MOBILE.getText());
              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                String addDate = dateFormat.format(jDateChooser_START.getDate());
                ps.setString(4, addDate);
                ps.setString(5, jTextField_FEE.getText());
                 ps.executeUpdate();
                 DefaultTableModel model = (DefaultTableModel)jTable_Display_Members.getModel();
                model.setRowCount(0);
                Show_Members_In_JTable();
        } catch (SQLException ex) {
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton_InsertActionPerformed

    private void jTable_Display_MembersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_Display_MembersMouseClicked
        // display when any row is clicked
        int i=jTable_Display_Members.getSelectedRow();
        TableModel model=jTable_Display_Members.getModel();
        jTextField_ID.setText(model.getValueAt(i, 0).toString());
        jTextField_NAME.setText(model.getValueAt(i, 1).toString());
        jTextField_MOBILE.setText(model.getValueAt(i, 2).toString());
       //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
       //String addDate = dateFormat.format(jDateChooser_START.setText(model.getValueAt(i, 3).toString()));
       jTextField_FEE.setText(model.getValueAt(i, 4).toString());
    }//GEN-LAST:event_jTable_Display_MembersMouseClicked

    private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_DeleteActionPerformed
       
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement ("DELETE FROM member WHERE id = ?");
            ps.setString(1, jTextField_ID.getText());
            
             ps.executeUpdate();
             DefaultTableModel model = (DefaultTableModel)jTable_Display_Members.getModel();
                model.setRowCount(0);
                Show_Members_In_JTable();
             
              JOptionPane.showMessageDialog(null, "Data Deleted");
        } catch (SQLException ex) {
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data is not Deleted!!");
        }
        
    }//GEN-LAST:event_jButton_DeleteActionPerformed

    private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateActionPerformed
      try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE member SET name=?,phn_no=?,fee=? WHERE id=?");
            ps.setString(4, jTextField_ID.getText());
            ps.setString(1, jTextField_NAME.getText());
             ps.setString(2, jTextField_MOBILE.getText());
//              SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//                String addDate = dateFormat.format(jDateChooser_START.getDate());
//                ps.setString(3, addDate);
                ps.setString(3, jTextField_FEE.getText());
                 ps.executeUpdate();
                 
                 DefaultTableModel model = (DefaultTableModel)jTable_Display_Members.getModel();
                model.setRowCount(0);
                Show_Members_In_JTable();
               // Show_Members_In_JTable();
                JOptionPane.showMessageDialog(null, "Data Updated");
        } catch (SQLException ex) {
            Logger.getLogger(Members.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data is not Updated!!!");
        }
    }//GEN-LAST:event_jButton_UpdateActionPerformed

    private void jButton_MENUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MENUActionPerformed
      MainMenu menu=new MainMenu();
      menu.setVisible(true);
      this.dispose();
    }//GEN-LAST:event_jButton_MENUActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Members.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                    new Members().setVisible(true);
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Delete;
    private javax.swing.JButton jButton_Insert;
    private javax.swing.JButton jButton_MENU;
    private javax.swing.JButton jButton_Update;
    private com.toedter.calendar.JDateChooser jDateChooser_START;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Display_Members;
    private javax.swing.JTextField jTextField_FEE;
    private javax.swing.JTextField jTextField_ID;
    private javax.swing.JTextField jTextField_MOBILE;
    private javax.swing.JTextField jTextField_NAME;
    // End of variables declaration//GEN-END:variables
}
