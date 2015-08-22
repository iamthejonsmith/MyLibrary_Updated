/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mylibrary;

import search.SearchJDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;
import ConnectionManager.dbConnectionManager;

/**
 *
 * @author Jonathan
 */
public class BookJDialog extends javax.swing.JDialog {
    
    String connectionText;
    Connection conn1 = null;
    Connection conn2 = null;
    Connection conn3 = null;

    
    /**
     *
     */
    
    public void getConnection() {
        
        try {
           Class.forName("com.mysql.jdbc.Driver");

            // connect way #1
            String url1 = "jdbc:mysql://localhost:3306/my_library";
            String user = "root";
            String password = "nitemare79";

            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database test1");
            }

            // connect way #2
            String url2 = "jdbc:mysql://localhost:3306/my_library?user=root&password=nitemare79";
            conn2 = DriverManager.getConnection(url2);
            if (conn2 != null) {
                System.out.println("Connected to the database test2");
            }

            // connect way #3
            String url3 = "jdbc:mysql://localhost:3306/my_library";
            Properties info = new Properties();
            info.put("user", "root");
            info.put("password", "nitemare79");

            conn3 = DriverManager.getConnection(url3, info);
            if (conn3 != null) {
                System.out.println("Connected to the database test3");
            }
   } catch (SQLException ex) {
            System.out.println("An error occurred. Maybe user/password is invalid");
            ex.printStackTrace();
   } catch (ClassNotFoundException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
        
        
        // User enters query and clicks button to display data in table below
        String qry = "";
        if (qry.trim().length() > 0) {
            DefaultTableModel tableModel = new DefaultTableModel();
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try (Connection con = DriverManager.getConnection("jdbc:mysql:///my_library", "root", "nitemare79")) {
                    java.sql.Statement stmt = con.createStatement();
                    System.out.println("Connection Successful");
                    stmt.executeQuery(qry);
                    
                    try (ResultSet rs = stmt.getResultSet()) {
                        ResultSetMetaData rsMeta = rs.getMetaData();
                        int colCount = rsMeta.getColumnCount();
                        for (int i = 1; i <= colCount; i++) {
                            tableModel.addColumn(rsMeta.getColumnLabel(i));
                        }
                        while (rs.next()) {
                            String[] rowData = new String[colCount];

                            for (int i = 1; i <= rowData.length; i++) {
                                String colLabel = rsMeta.getColumnLabel(i);
                                String colValue = rs.getString(colLabel);
                                rowData[i - 1] = colValue;
                            }
                            tableModel.addRow(rowData);
                        }
                        
                    }
                    MessageFrame.setText("Connection Successful");
                }

            } catch (ClassNotFoundException | SQLException ex) {
             System.out.println("Unable to make connection with DB");
             ex.printStackTrace();
        }
       
    }  
    }  //end main

    /**
     *
     */
    public void closeConnection() {
        System.exit(0);
    }

    /**
     * Creates new form BookJDialog
     * @param parent
     * @param modal  
     */
    public BookJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
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
        EnterButton = new javax.swing.JButton();
        SearchButton = new javax.swing.JButton();
        BorrowButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        ExitButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        MessageFrame = new javax.swing.JTextArea();
        queryTestButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("My Library Welcome");
        setForeground(java.awt.Color.white);
        setPreferredSize(new java.awt.Dimension(642, 509));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Freestyle Script", 2, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME TO MY LIBRARY");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(168, 35, 308, 51));

        EnterButton.setFont(new java.awt.Font("Freestyle Script", 0, 24)); // NOI18N
        EnterButton.setText("ENTER BOOK");
        EnterButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, java.awt.Color.black));
        EnterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnterButtonActionPerformed(evt);
            }
        });
        getContentPane().add(EnterButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 140, 151, 47));

        SearchButton.setFont(new java.awt.Font("Freestyle Script", 0, 24)); // NOI18N
        SearchButton.setText("SEARCH LIBRARY");
        SearchButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(0, 0, 0)));
        SearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(SearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 205, 151, 47));

        BorrowButton.setFont(new java.awt.Font("Freestyle Script", 0, 24)); // NOI18N
        BorrowButton.setText("BORROW BOOK");
        BorrowButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(0, 0, 0)));
        BorrowButton.setPreferredSize(new java.awt.Dimension(101, 33));
        BorrowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorrowButtonActionPerformed(evt);
            }
        });
        getContentPane().add(BorrowButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 270, 151, 47));

        jLabel2.setText("© Creative Native Coding");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 451, -1, 14));

        ExitButton.setFont(new java.awt.Font("Freestyle Script", 0, 24)); // NOI18N
        ExitButton.setText("EXIT");
        ExitButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(0, 0, 0)));
        ExitButton.setPreferredSize(new java.awt.Dimension(101, 33));
        ExitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ExitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 335, 151, 41));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        MessageFrame.setEditable(false);
        MessageFrame.setColumns(20);
        MessageFrame.setRows(5);
        MessageFrame.setName("MesageFrame"); // NOI18N
        jScrollPane1.setViewportView(MessageFrame);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(212, 382, -1, 38));

        queryTestButton.setText("Query Test");
        queryTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryTestButtonActionPerformed(evt);
            }
        });
        getContentPane().add(queryTestButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(526, 12, -1, -1));

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Help");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EnterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnterButtonActionPerformed
        // TODO add your handling code here:
        EnterJDialog.main(null);   // Open Enter Book Form
        this.dispose(); //Close this one
        
    }//GEN-LAST:event_EnterButtonActionPerformed
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked
    
    private void SearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchButtonActionPerformed
        // Open Search Library Form, Close This Form
        SearchJDialog.main(null);   // open my second class
        this.dispose(); //Close this one
    }//GEN-LAST:event_SearchButtonActionPerformed
        
    private void ExitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitButtonActionPerformed
        // Close Server Connection, exit app
        
        closeConnection();
    }//GEN-LAST:event_ExitButtonActionPerformed

    private void BorrowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorrowButtonActionPerformed
        // TODO add your handling code here:
        
        BorrowBook.main(null);   // Open Borrow Book Form
        this.dispose(); //Close this one 
    }//GEN-LAST:event_BorrowButtonActionPerformed

    private void queryTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryTestButtonActionPerformed
        // TODO add your handling code here:
        QueryGUI.main(null);   // Open Enter Book Form
        this.dispose(); //Close this one
    }//GEN-LAST:event_queryTestButtonActionPerformed

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
            java.util.logging.Logger.getLogger(BookJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookJDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BookJDialog dialog = new BookJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BorrowButton;
    private javax.swing.JButton EnterButton;
    private javax.swing.JButton ExitButton;
    private javax.swing.JTextArea MessageFrame;
    private javax.swing.JButton SearchButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton queryTestButton;
    // End of variables declaration//GEN-END:variables
}