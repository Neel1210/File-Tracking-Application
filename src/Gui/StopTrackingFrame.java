/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Dao.FileTrackingDao;
import Pojo.FileTrackingPojo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Neel_Esh
 */
public class StopTrackingFrame extends javax.swing.JFrame {

    /**
     * Creates new form StopTrackingFrame
     */
    private String Email;
    private FileTrackingPojo filePojo;
    
    public StopTrackingFrame() {
        initComponents();
    }
    
    public StopTrackingFrame(String Email) {
        
        initComponents();
        this.Email=Email;
        this.setLocationRelativeTo(null);

        try
        {
        
            this.setTableData(FileTrackingDao.showData(this.Email));
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"Error in retreving data","Error" ,JOptionPane.WARNING_MESSAGE);
        }
        this.setVisible(true);
        
    }
    
    public void setTableData(ResultSet rs)
    {
        try
        {   int flag=0;
            for(int i=0;rs.next();i++)
            {   
                flag=flag+1;
                for(int j=0;j<3;j++)
                {
                    StatusTbl.setValueAt(rs.getString(j+2),i,j);
                }
            }
            if(flag==0)
            {
                JOptionPane.showMessageDialog(null,"No record on your Email","SomeThing Went Wrong ",JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatusTbl = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BackBtn = new javax.swing.JButton();
        StopTrackingBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(192, 205, 240));

        StatusTbl.setBackground(new java.awt.Color(211, 194, 236));
        StatusTbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        StatusTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "File Name", "File Path", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StatusTbl.setToolTipText("");
        StatusTbl.setGridColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(StatusTbl);
        if (StatusTbl.getColumnModel().getColumnCount() > 0) {
            StatusTbl.getColumnModel().getColumn(1).setPreferredWidth(380);
        }

        jLabel1.setFont(new java.awt.Font("Kokonor", 1, 36)); // NOI18N
        jLabel1.setText("File Tracking Application");

        jLabel2.setText("Note - Status 1 means tracking active , 0 menas tracking stoped .");

        BackBtn.setBackground(new java.awt.Color(211, 194, 236));
        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        StopTrackingBtn.setBackground(new java.awt.Color(211, 194, 236));
        StopTrackingBtn.setText("Stop Tracking");
        StopTrackingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopTrackingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(StopTrackingBtn)
                .addGap(77, 77, 77))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn)
                    .addComponent(StopTrackingBtn))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        UserOptionFrame user=new UserOptionFrame(Email);
        user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

    private void StopTrackingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopTrackingBtnActionPerformed
        // TODO add your handling code here:
        
        int Res=JOptionPane.showConfirmDialog(null,"Do you want to Stop Tracking of selected file","Confirmation Dailog",JOptionPane.INFORMATION_MESSAGE);
        if(Res==JOptionPane.OK_OPTION)
        {
            filePojo=new FileTrackingPojo();
            filePojo.setEmail(Email);
            filePojo.setFilePath(StatusTbl.getValueAt(StatusTbl.getSelectedRow(),1).toString().trim());
        
            try
            {
            
                FileTrackingDao.stopTracking(filePojo);
                JOptionPane.showMessageDialog(null,"Thread Stopped "+StatusTbl.getValueAt(StatusTbl.getSelectedRow(),0).toString().trim(),"SucessFully Done !!!",JOptionPane.INFORMATION_MESSAGE);
                
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error While Stoping File Tracking ","SomeThing Went Wrong ",JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
            
            try
            {
                this.setTableData(FileTrackingDao.showData(this.Email));
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error in retreving data","Error" ,JOptionPane.WARNING_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_StopTrackingBtnActionPerformed

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
            java.util.logging.Logger.getLogger(StopTrackingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StopTrackingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StopTrackingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StopTrackingFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StopTrackingFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JTable StatusTbl;
    private javax.swing.JButton StopTrackingBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
