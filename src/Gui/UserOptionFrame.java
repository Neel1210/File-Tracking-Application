/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

/**
 *
 * @author Neel_Esh
 */
public class UserOptionFrame extends javax.swing.JFrame {

    /**
     * Creates new form UserOptionFrame
     */
    private String Email;
    
    public UserOptionFrame()
    {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public UserOptionFrame(String email) {
        initComponents();
        this.Email=email;
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        
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
        jLabel1 = new javax.swing.JLabel();
        StartTrackingBtn = new javax.swing.JButton();
        ShowTrackingStatusBtn = new javax.swing.JButton();
        LogOutBtn = new javax.swing.JButton();
        StopTrackingBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(192, 205, 240));

        jLabel1.setFont(new java.awt.Font("Kokonor", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gui/Screenshot 2022-06-14 at 00.27.06.png"))); // NOI18N

        StartTrackingBtn.setBackground(new java.awt.Color(211, 194, 236));
        StartTrackingBtn.setText("Start Tracking");
        StartTrackingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartTrackingBtnActionPerformed(evt);
            }
        });

        ShowTrackingStatusBtn.setBackground(new java.awt.Color(211, 194, 236));
        ShowTrackingStatusBtn.setText("Show Tracking Status");
        ShowTrackingStatusBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShowTrackingStatusBtnActionPerformed(evt);
            }
        });

        LogOutBtn.setBackground(new java.awt.Color(211, 194, 236));
        LogOutBtn.setText("LogOut");
        LogOutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOutBtnActionPerformed(evt);
            }
        });

        StopTrackingBtn.setBackground(new java.awt.Color(211, 194, 236));
        StopTrackingBtn.setText("Stop Tracking ");
        StopTrackingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopTrackingBtnActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("/Users/Neel_Esh/Projects/NetBeansProjects/Training&Placement_git/Traning&Placement/src/images/worlp-map-in-black-h9i.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(StopTrackingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(StartTrackingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ShowTrackingStatusBtn)
                    .addComponent(LogOutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(170, 170, 170))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(StartTrackingBtn)
                        .addGap(42, 42, 42)
                        .addComponent(StopTrackingBtn)
                        .addGap(38, 38, 38)
                        .addComponent(ShowTrackingStatusBtn)
                        .addGap(49, 49, 49)
                        .addComponent(LogOutBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel2)))
                .addContainerGap(48, Short.MAX_VALUE))
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

    private void ShowTrackingStatusBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ShowTrackingStatusBtnActionPerformed
        // TODO add your handling code here:
        ShowRecordStatus show=new ShowRecordStatus(Email);
        show.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ShowTrackingStatusBtnActionPerformed

    private void LogOutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOutBtnActionPerformed
        // TODO add your handling code here:
        new LoginPage().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_LogOutBtnActionPerformed

    private void StartTrackingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartTrackingBtnActionPerformed
        // TODO add your handling code here:
        FileChooseFrame fileChoose=new FileChooseFrame(Email);
        fileChoose.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_StartTrackingBtnActionPerformed

    private void StopTrackingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopTrackingBtnActionPerformed
        // TODO add your handling code here:
        StopTrackingFrame stop=new StopTrackingFrame(Email);
        stop.setVisible(true);
        this.dispose();             
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
            java.util.logging.Logger.getLogger(UserOptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserOptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserOptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserOptionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserOptionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LogOutBtn;
    private javax.swing.JButton ShowTrackingStatusBtn;
    private javax.swing.JButton StartTrackingBtn;
    private javax.swing.JButton StopTrackingBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
