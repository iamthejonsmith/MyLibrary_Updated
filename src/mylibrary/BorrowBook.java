/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrary;

import ConnectionManager.dbConnectionManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jonathan
 */
public class BorrowBook extends javax.swing.JFrame {

    /**
     * Creates new form BorrowBook
     */
    public BorrowBook() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BookNameField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ClearButton = new javax.swing.JButton();
        loanButton = new javax.swing.JButton();
        HomeButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Book Loaning");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Book Title");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        BookNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BookNameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(BookNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 190, -1));

        jLabel4.setText("© Creative Native Coding");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(527, 463, 145, 34));

        jLabel2.setFont(new java.awt.Font("Freestyle Script", 2, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Loan Book");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 381, 51));

        ClearButton.setFont(new java.awt.Font("Freestyle Script", 0, 24)); // NOI18N
        ClearButton.setText("Clear Form");
        ClearButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.black));
        ClearButton.setPreferredSize(new java.awt.Dimension(101, 33));
        ClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ClearButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 185, 42));

        loanButton.setFont(new java.awt.Font("Freestyle Script", 0, 24)); // NOI18N
        loanButton.setText("Loan Book");
        loanButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.black));
        loanButton.setPreferredSize(new java.awt.Dimension(101, 33));
        loanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loanButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 185, 42));

        HomeButton.setFont(new java.awt.Font("Freestyle Script", 0, 24)); // NOI18N
        HomeButton.setText("Home");
        HomeButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.black));
        HomeButton.setPreferredSize(new java.awt.Dimension(101, 33));
        HomeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeButtonActionPerformed(evt);
            }
        });
        getContentPane().add(HomeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 185, 42));

        returnButton.setFont(new java.awt.Font("Freestyle Script", 0, 24)); // NOI18N
        returnButton.setText("Return Book");
        returnButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.black));
        returnButton.setPreferredSize(new java.awt.Dimension(101, 33));
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, 185, 42));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BookNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BookNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BookNameFieldActionPerformed

    private void ClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearButtonActionPerformed
        BookNameField.setText("");
        BookNameField.requestFocus();
    }//GEN-LAST:event_ClearButtonActionPerformed

    private void loanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loanButtonActionPerformed
        if (("".equals(BookNameField.getText()))) { //all fields are required check
            JOptionPane.showMessageDialog(null, "You have forgotten one or more required fields");
        } else {
            try {

                dbConnectionManager.getConnection(); //get connection from connection manager
                
                String BookStatus = "Out"; //Loan book by changing status

                String sql = String.format("UPDATE book Set BookStatus = '" + BookStatus + "' WHERE Title = '" + BookNameField.getText() + "'");
                java.sql.Statement stmt = dbConnectionManager.getConnection().prepareStatement(sql);
                stmt.executeUpdate(sql);


                // Clear All Form Fields
                BookNameField.setText(""); //clear book title field
                BookNameField.requestFocus();
                dbConnectionManager.getConnection().close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

    }//GEN-LAST:event_loanButtonActionPerformed

    private void HomeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeButtonActionPerformed
        // TODO add your handling code here:
        BookJDialog.main(null);   // open main search form
        this.dispose(); //Close this one
    }//GEN-LAST:event_HomeButtonActionPerformed

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        // TODO add your handling code here:
        if (("".equals(BookNameField.getText()))) { //all fields are required check
            JOptionPane.showMessageDialog(null, "You have forgotten one or more required fields");
        } else {
            try {

                dbConnectionManager.getConnection(); //get connection from connection manager
                
                String BookStatus = "In"; //Loan book by changing status

                String sql = String.format("UPDATE book Set BookStatus = '" + BookStatus + "' WHERE Title = '" + BookNameField.getText() + "'");
                java.sql.Statement stmt = dbConnectionManager.getConnection().prepareStatement(sql);
                stmt.executeUpdate(sql);


                // Clear All Form Fields
                BookNameField.setText(""); //clear book title field
                BookNameField.requestFocus();
                dbConnectionManager.getConnection().close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }

    }//GEN-LAST:event_returnButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BorrowBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BorrowBook().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BookNameField;
    private javax.swing.JButton ClearButton;
    private javax.swing.JButton HomeButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton loanButton;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables
}