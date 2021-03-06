/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_java3;

import DAO.SQLConnect;
import Data.User;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Truong Dep Zai
 */
public class Main extends javax.swing.JFrame {

    public static Connection conn;
    public static User user = new User();
    public static boolean dalogin = false;

    /**
     * Creates new form Mail
     */
    public Main() {
        initComponents();
        setSize(900, 600);
        setLocationRelativeTo(null);
        if ((conn = SQLConnect.openConnection()) == null) {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối csdl");
            System.exit(0);
        }
//        showLogin();
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
        lblTrangthai = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuUser = new javax.swing.JMenu();
        menuLogin = new javax.swing.JMenuItem();
        menuLogout = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        menuTeacher = new javax.swing.JMenu();
        menuQLD = new javax.swing.JMenuItem();
        menuEmployee = new javax.swing.JMenu();
        menuQLSV = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images/logo.png"))); // NOI18N
        getContentPane().add(jLabel1, java.awt.BorderLayout.CENTER);

        lblTrangthai.setText("jLabel2");
        lblTrangthai.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        getContentPane().add(lblTrangthai, java.awt.BorderLayout.PAGE_END);

        menuUser.setText("User");
        menuUser.setMargin(new java.awt.Insets(0, 15, 0, 15));

        menuLogin.setText("Login");
        menuLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLoginActionPerformed(evt);
            }
        });
        menuUser.add(menuLogin);

        menuLogout.setText("Logout");
        menuLogout.setEnabled(false);
        menuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuLogoutActionPerformed(evt);
            }
        });
        menuUser.add(menuLogout);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuUser.add(menuExit);

        jMenuBar1.add(menuUser);

        menuTeacher.setText("Teacher");
        menuTeacher.setEnabled(false);
        menuTeacher.setMargin(new java.awt.Insets(0, 15, 0, 15));

        menuQLD.setText("Quản Lý Điểm");
        menuQLD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQLDActionPerformed(evt);
            }
        });
        menuTeacher.add(menuQLD);

        jMenuBar1.add(menuTeacher);

        menuEmployee.setText("Employee");
        menuEmployee.setEnabled(false);
        menuEmployee.setMargin(new java.awt.Insets(0, 15, 0, 15));

        menuQLSV.setText("Quản Lý Sinh Viên");
        menuQLSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQLSVActionPerformed(evt);
            }
        });
        menuEmployee.add(menuQLSV);

        jMenuBar1.add(menuEmployee);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLoginActionPerformed
        // TODO add your handling code here:
        showLogin();
    }//GEN-LAST:event_menuLoginActionPerformed

    private void menuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuLogoutActionPerformed
        // TODO add your handling code here:
        logout();
    }//GEN-LAST:event_menuLogoutActionPerformed

    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuQLDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQLDActionPerformed
        // TODO add your handling code here:
        showQLD();
    }//GEN-LAST:event_menuQLDActionPerformed

    private void menuQLSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuQLSVActionPerformed
        // TODO add your handling code here:
        showQLSV();
    }//GEN-LAST:event_menuQLSVActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lblTrangthai;
    private javax.swing.JMenu menuEmployee;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenuItem menuLogin;
    private javax.swing.JMenuItem menuLogout;
    private javax.swing.JMenuItem menuQLD;
    private javax.swing.JMenuItem menuQLSV;
    private javax.swing.JMenu menuTeacher;
    private javax.swing.JMenu menuUser;
    // End of variables declaration//GEN-END:variables
private void showLogin() {
        Login lg = new Login();
//        setFocusable(false);
        setEnabled(false);
        lg.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
//                setFocusable(true);
                setEnabled(true);
                menuUser.requestFocus();
                if (dalogin) {
                    battatmenu(dalogin);
                }
            }
        });
        lg.setVisible(true);
    }

    public void battatmenu(boolean dalogin) {
        menuLogin.setEnabled(!dalogin);
        menuLogout.setEnabled(dalogin);
        menuTeacher.setEnabled(dalogin ? user.role.equals("GV") : false);
        menuEmployee.setEnabled(dalogin ? user.role.equals("DT") : false);
        lblTrangthai.setText(dalogin ? "Đã đăng nhập" : "Chưa đăng nhập");
    }

    private void logout() {
        dalogin = false;
        battatmenu(dalogin);
    }

    private void showQLSV() {
        Quan_Ly_Sinh_Vien qlsv = new Quan_Ly_Sinh_Vien();
        setEnabled(false);
        qlsv.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
//                setFocusable(true);
                setEnabled(true);
            }
        });
        qlsv.setVisible(true);
    }

    private void showQLD() {
        QuanLyDiem qld = new QuanLyDiem();
        setEnabled(false);
        qld.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent we) {
//                setFocusable(true);
                setEnabled(true);
            }
        });
        qld.setVisible(true);
    }
}
