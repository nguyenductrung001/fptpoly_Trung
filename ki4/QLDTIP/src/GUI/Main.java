/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.QLDT.ThemDT;
import javax.swing.JInternalFrame;

/**
 *
 * @author ma-user
 */
public class Main extends javax.swing.JFrame {

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
//        setContentPane(rootPanel);
        setExtendedState(MAXIMIZED_BOTH);
        for (JInternalFrame chiFrame : rootPanel.getAllFrames()) {
            chiFrame.dispose();
        }
        MDI m = new MDI();
        rootPanel.add(m);
        m.setVisible(true);
        ThemDT tdt = new ThemDT();
        rootPanel.add(tdt);
        tdt.setVisible(true);
//        DN dn = new DN();
//        dn.setTitle("Đăng Nhập");
//        dn.setLocation(this.getWidth() / 2 - dn.getWidth() / 2, (this.getHeight() - 20) / 2 - dn.getHeight() / 2 - 20);
//        rootPanel.add(dn);
//        dn.setVisible(true);
//        
//        
//        if (dn == null || dn.isClosed()) {
//            dn = new DN();
//            rootPanel.add(dn);
//            dn.setLocation(this.getWidth() / 2 - dn.getWidth() / 2, (this.getHeight() - 20) / 2 - dn.getHeight() / 2 - 20);
//            dn.setVisible(true);
//        } else {
//            dn.setLocation(this.getWidth() / 2 - dn.getWidth() / 2, (this.getHeight() - 20) / 2 - dn.getHeight() / 2 - 20);
//            dn.setVisible(true);
//        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnDangNhap = new javax.swing.JMenuItem();
        btnDoiMK = new javax.swing.JMenuItem();
        btnDangXuat = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        btnThemNV = new javax.swing.JMenuItem();
        btnXoaNV = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        btnExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnThemDT = new javax.swing.JMenuItem();
        btnNhapKho = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        btnTimHD = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        btnXemDT = new javax.swing.JMenuItem();
        btnXemDS = new javax.swing.JMenuItem();
        btnDSKH = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        btnAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(1360, 750));

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1360, Short.MAX_VALUE)
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        jMenu1.setText("Nhân viên");
        jMenu1.setMargin(new java.awt.Insets(0, 5, 0, 30));

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        jMenu1.add(btnDangNhap);

        btnDoiMK.setText("Đổi mật khẩu");
        jMenu1.add(btnDoiMK);

        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangXuatActionPerformed(evt);
            }
        });
        jMenu1.add(btnDangXuat);
        jMenu1.add(jSeparator2);

        btnThemNV.setText("Thêm nhân viên");
        jMenu1.add(btnThemNV);

        btnXoaNV.setText("Xem chi tiết");
        jMenu1.add(btnXoaNV);
        jMenu1.add(jSeparator1);

        btnExit.setText("Exit");
        jMenu1.add(btnExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("ĐIện thoại");
        jMenu2.setMargin(new java.awt.Insets(0, 5, 0, 30));

        btnThemDT.setText("Thêm mới ");
        jMenu2.add(btnThemDT);

        btnNhapKho.setText("Nhập kho");
        jMenu2.add(btnNhapKho);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Hóa đơn");
        jMenu3.setMargin(new java.awt.Insets(0, 5, 0, 30));

        btnTimHD.setText("Tìm hóa đơn");
        jMenu3.add(btnTimHD);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Thống kê");
        jMenu4.setMargin(new java.awt.Insets(0, 5, 0, 30));

        btnXemDT.setText("Xem doanh thu");
        jMenu4.add(btnXemDT);

        btnXemDS.setText("Xem doanh số");
        jMenu4.add(btnXemDS);

        btnDSKH.setText("Danh sách khách hàng");
        jMenu4.add(btnDSKH);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("thông tin");
        jMenu5.setMargin(new java.awt.Insets(0, 5, 0, 30));

        btnAbout.setText("About SAO");
        jMenu5.add(btnAbout);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangXuatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDangXuatActionPerformed

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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAbout;
    private javax.swing.JMenu btnDSKH;
    private javax.swing.JMenuItem btnDangNhap;
    private javax.swing.JMenuItem btnDangXuat;
    private javax.swing.JMenuItem btnDoiMK;
    private javax.swing.JMenuItem btnExit;
    private javax.swing.JMenuItem btnNhapKho;
    private javax.swing.JMenuItem btnThemDT;
    private javax.swing.JMenuItem btnThemNV;
    private javax.swing.JMenuItem btnTimHD;
    private javax.swing.JMenuItem btnXemDS;
    private javax.swing.JMenuItem btnXemDT;
    private javax.swing.JMenuItem btnXoaNV;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JDesktopPane rootPanel;
    // End of variables declaration//GEN-END:variables
}