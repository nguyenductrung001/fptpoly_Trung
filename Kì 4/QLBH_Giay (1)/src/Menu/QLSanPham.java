/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Uhelper.ClassQLSP;
import Uhelper.ClassSanPham;
import Uhelper.Helper;
import Uhelper.TheModel3;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class QLSanPham extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLSanPham
     */
    Connection con;
    SuaSanPham ssp;
    ThemSanPham tsp;
    ArrayList<ClassQLSP> lstQLSP = new ArrayList<>();

    public QLSanPham() {
        initComponents();
        con = Helper.ketnoi("QLBH01");
        String[] columnName = {"Mã sản phẩm", "Mã sản phẩm chi tiết", "Tên sản phẩm",
            "Tên danh mục", "Kích cỡ", "Màu sắc", "Số lượng", "Đơn giá", "Ngày thêm",
            "Mô tả", "Ảnh"};
        String data[][] = null;

        loadDataToTable();

    }

    public void loadDataToTable() {
        String[] columnName = {"Mã sản phẩm", "Mã sản phẩm chi tiết", "Tên sản phẩm",
            "Tên danh mục", "Kích cỡ", "Màu sắc", "Số lượng", "Đơn giá", "Ngày thêm",
            "Mô tả", "Ảnh"};
        try {
            String sql = "Select * from sanpham where trangthai=1";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                lstQLSP.add(new ClassQLSP(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getString(11)));
            }
            Object[][] rows = new Object[lstQLSP.size()][11];
            for (int i = 0; i < lstQLSP.size(); i++) {
                rows[i][0] = lstQLSP.get(i).getMasp();
                rows[i][1] = lstQLSP.get(i).getMaspct();
                rows[i][2] = lstQLSP.get(i).getTensp();
                rows[i][3] = lstQLSP.get(i).getDanhmuc();
                rows[i][4] = lstQLSP.get(i).getKichco();
                rows[i][5] = lstQLSP.get(i).getMausac();
                rows[i][6] = lstQLSP.get(i).getSoluong();
                rows[i][7] = lstQLSP.get(i).getDongia();
                rows[i][8] = lstQLSP.get(i).getNgaythem();
                rows[i][9] = lstQLSP.get(i).getMota();
                if (lstQLSP.get(i).getAnh() != null) {
                    ImageIcon icon1 = new ImageIcon("src//Image//" + lstQLSP.get(i).getAnh());
                    Image im = icon1.getImage();
                    ImageIcon icon = new ImageIcon(im.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
                    rows[i][10] = icon;
                } else {
                    rows[i][10] = null;
                }
                TheModel3 model = new TheModel3(rows, columnName);
                tbl_sanpham.setModel(model);
                tbl_sanpham.setRowHeight(100);
                tbl_sanpham.getColumnModel().getColumn(1).setPreferredWidth(100);
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load data to sanpham");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dsk = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_sanpham = new javax.swing.JTable();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txt_nhap = new javax.swing.JTextField();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        dsk.setBackground(new java.awt.Color(255, 255, 255));
        dsk.setPreferredSize(new java.awt.Dimension(1193, 524));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("QUẢN LÝ SẢN PHẨM");

        tbl_sanpham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbl_sanpham);

        btn_them.setText("Thêm sản phẩm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa sản phẩm");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_xoa.setText("Xóa sản phẩm");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        jButton1.setText("Xóa theo mã sản phẩm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dsk.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsk.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsk.setLayer(btn_them, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsk.setLayer(btn_sua, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsk.setLayer(btn_xoa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsk.setLayer(jButton1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        dsk.setLayer(txt_nhap, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout dskLayout = new javax.swing.GroupLayout(dsk);
        dsk.setLayout(dskLayout);
        dskLayout.setHorizontalGroup(
            dskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dskLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(txt_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121)
                .addComponent(jButton1)
                .addGap(141, 141, 141)
                .addComponent(btn_xoa)
                .addGap(163, 163, 163)
                .addComponent(btn_sua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                .addComponent(btn_them)
                .addGap(62, 62, 62))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(596, 596, 596))
            .addGroup(dskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dskLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1)
                    .addContainerGap()))
        );
        dskLayout.setVerticalGroup(
            dskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dskLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 407, Short.MAX_VALUE)
                .addGroup(dskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(btn_xoa)
                    .addComponent(btn_sua)
                    .addComponent(btn_them))
                .addGap(82, 82, 82))
            .addGroup(dskLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(dskLayout.createSequentialGroup()
                    .addGap(43, 43, 43)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(150, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsk, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dsk, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:

        tsp = new ThemSanPham();
        dsk.add(tsp);
        tsp.setVisible(true);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int row = tbl_sanpham.getSelectedRow();
        if (row >= 0 && txt_nhap.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Đã tìm thấy sản phẩm cần sửa");
            String maspchitiet = (String) tbl_sanpham.getValueAt(row, 1);
            ssp = new SuaSanPham(maspchitiet);
            dsk.add(ssp);
            ssp.setVisible(true);
        } else if (row < 0 ) {
            try {
                String sql = "select * from sanpham where maspchitiet=?";
                PreparedStatement pstm = con.prepareStatement(sql);
                pstm.setString(1, txt_nhap.getText());
                boolean kq = pstm.execute();
                System.out.println(kq);
                if (kq =true) {
                    JOptionPane.showMessageDialog(this, "Đã tìm thấy sản phẩm cần sửa");
                    
                    SuaSanPham ssp = new SuaSanPham(txt_nhap.getText());
                    dsk.add(ssp);
                    ssp.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "không tìm thấy sản phẩm cần sửa");
                }
            } catch (Exception e) {

            }
        } else if (row < 0 && !txt_nhap.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn dòng trước khi chuyển sang sửa sản phẩm");
        } else {
            JOptionPane.showMessageDialog(this, "vui lòng thao tác chọn 1 loại");
        }

    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        // TODO add your handling code here:
        int row = tbl_sanpham.getSelectedRow();

        if (row >= 0) {
            String maspchitiet = (String) tbl_sanpham.getValueAt(row, 1);
            try {
                String sql = "update sanpham set trangthai='0' where maspchitiet=? or maspchitiet=?";
                PreparedStatement pstm = con.prepareStatement(sql);

                pstm.setString(1, maspchitiet);
                pstm.setString(2, txt_nhap.getText());
                int kq = pstm.executeUpdate();
                if (kq > 0) {
                    JOptionPane.showMessageDialog(this, "bạn đã xóa thành công sản phẩm");
                } else {
                    JOptionPane.showMessageDialog(this, "bạn đã xóa thất bại");
                }
                loadDataToTable();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi xóa");
            }
        }
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String masp = txt_nhap.getText();
        int row = tbl_sanpham.getSelectedRow();
        String masp2 = (String) tbl_sanpham.getValueAt(row, 0);
        try {
            String sql = "update sanpham set trangthai='0' where masp=? or masp=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, masp);
            pstm.setString(2, masp2);
            int kq = pstm.executeUpdate();
            if (kq > 0) {
                JOptionPane.showMessageDialog(this, "Bạn đã xóa thành công ");
            } else {
                JOptionPane.showMessageDialog(this, "Bạn ko xóa được gì");
            }
            loadDataToTable();
        } catch (Exception e) {

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:

    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JDesktopPane dsk;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_sanpham;
    private javax.swing.JTextField txt_nhap;
    // End of variables declaration//GEN-END:variables
}
