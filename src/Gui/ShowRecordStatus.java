
package Gui;

import Dao.FileTrackingDao;
import Pojo.FileTrackingPojo;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ShowRecordStatus extends javax.swing.JFrame {
    
    private File file;
    private String Email;
    private FileTrackingPojo filePojo;
    public ShowRecordStatus() {
        initComponents();
        
    }
    
    public ShowRecordStatus(String Email) {
        initComponents();
        this.Email=Email;
        this.setLocationRelativeTo(null);

        try
        {
        
            this.setTableData(FileTrackingDao.showAllData(Email));
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StatusTbl = new javax.swing.JTable();
        BackBtn = new javax.swing.JButton();
        DownloadBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(192, 205, 240));

        jLabel1.setFont(new java.awt.Font("Kokonor", 1, 36)); // NOI18N
        jLabel1.setText("File Tracking Application");

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
        StatusTbl.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (StatusTbl.getColumnModel().getColumnCount() > 0) {
            StatusTbl.getColumnModel().getColumn(0).setResizable(false);
            StatusTbl.getColumnModel().getColumn(1).setResizable(false);
            StatusTbl.getColumnModel().getColumn(1).setPreferredWidth(380);
            StatusTbl.getColumnModel().getColumn(2).setResizable(false);
        }

        BackBtn.setBackground(new java.awt.Color(211, 194, 236));
        BackBtn.setText("Back");
        BackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackBtnActionPerformed(evt);
            }
        });

        DownloadBtn.setBackground(new java.awt.Color(211, 194, 236));
        DownloadBtn.setText("Download File");
        DownloadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DownloadBtnActionPerformed(evt);
            }
        });

        jLabel2.setText("Note - Status 1 means tracking active , 0 menas tracking stoped .");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(63, 63, 63))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(BackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(DownloadBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(24, 24, 24)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BackBtn)
                    .addComponent(DownloadBtn))
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void DownloadBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DownloadBtnActionPerformed
        // TODO add your handling code here:
        JFileChooser fileChooser=new JFileChooser();
        fileChooser.setDialogTitle("Download Here");
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int res =fileChooser.showSaveDialog(null);
        if (res == fileChooser.APPROVE_OPTION) 
        {   
            file=fileChooser.getSelectedFile();
            filePojo=new FileTrackingPojo();
            filePojo.setEmail(Email);
          
            filePojo.setFileName(StatusTbl.getValueAt(StatusTbl.getSelectedRow(),0).toString().trim());
            filePojo.setFileName1(StatusTbl.getValueAt(StatusTbl.getSelectedRow(),1).toString().trim());
            filePojo.setFilePath(file.toString().trim());
            
            try
            {
                FileTrackingDao.retriveCvs(filePojo);
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null,"Error While Downloading in File","SomeThing Went Wrong ",JOptionPane.ERROR_MESSAGE);
          
            }
            catch(IOException ex)
            {
                JOptionPane.showMessageDialog(null,"Error While Downloading in File","SomeThing Went Wrong ",JOptionPane.ERROR_MESSAGE);
          
            }
            
            System.out.println(file.toString());  
        } 
        
        JOptionPane.showMessageDialog(null,"File Downloaded SuccesFully","Success",JOptionPane.INFORMATION_MESSAGE);
  
    }//GEN-LAST:event_DownloadBtnActionPerformed

    private void BackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackBtnActionPerformed
        // TODO add your handling code here:
        UserOptionFrame user=new UserOptionFrame(Email);
        user.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ShowRecordStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowRecordStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowRecordStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowRecordStatus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowRecordStatus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackBtn;
    private javax.swing.JButton DownloadBtn;
    private javax.swing.JTable StatusTbl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
