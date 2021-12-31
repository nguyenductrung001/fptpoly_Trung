/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import static Menu.TrangchuNV.maspct;
import Uhelper.Helper;
import Uhelper.Sanpham;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
//ArrayList
public class Banhang extends javax.swing.JInternalFrame {

    Connection cn;
    DefaultTableModel model, model1;
    int soluong1;
    int indexx;
    String tentk = "";

    /**
     * Creates new form Banhang
     */
    ArrayList<Sanpham> list2 = new ArrayList<>();

    public Banhang() {
        initComponents();
        cn = Helper.ketnoi("QLBH01");
        String header[] = {"Mã sản phẩm ", "Mã sản phẩm chi tiết", "Tên Sản Phẩm", "Tên Danh Mục"};
        String header1[] = {"Mã sản phẩm chi tiết", "Tên Sản Phẩm", "Kích Cỡ", "Số Lượng", "Đơn Giá", "Thành Tiền"};
        String data[][] = null;
        String data1[][] = null;
        model = new DefaultTableModel(data, header);
        model1 = new DefaultTableModel(data1, header1);
        tentk = DangNhap.tkdadn;
        tbl_banhang.setModel(model1);
        tbl_timkiem.setModel(model);
        if (cn != null) {
//            JOptionPane.showMessageDialog(this, "Thành Công");
//            LoadTable();
        } else {
            JOptionPane.showMessageDialog(this, "Thất Bại");
        }
    }

    public void upHinh(String hinh) {
        ImageIcon image = new ImageIcon("src//Image//" + hinh);
        Image img = image.getImage();
        ImageIcon icon = new ImageIcon(img.getScaledInstance(lbl_hinh2.getWidth(), lbl_hinh2.getHeight(), img.SCALE_SMOOTH));
        lbl_hinh2.setIcon(icon);
    }

    public void check() {
        if (txt_masanphamchitiet.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "mã sản phẩm chi tiết không được để trống");
            return;
        }
        if (txt_soluong.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "số lượng không được để trống");
            return;
        }
        if (!txt_soluong.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "số lượng không phải là số");
            return;
        }

    }

    public void clear() {
        txt_masanphamchitiet.setText("");
        txt_soluong.setText("");
        model1.setRowCount(0);

        txt_thanhtien.setText("");
    }

    public void them() {

        check();
        try {
            String sql = "select maspchitiet,tensp,kichco,soluong,dongia from sanpham where maspchitiet = ? or tensp=?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, txt_masanphamchitiet.getText());
            pstm.setString(2, txt_masanphamchitiet.getText());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int sl = rs.getInt(4);
                if (sl < Integer.parseInt(txt_soluong.getText())) {
                    JOptionPane.showMessageDialog(this, "Lớn hơn số lượng");
                } else {

                    Float thanhtien = Integer.parseInt(txt_soluong.getText()) * rs.getFloat(5);
                    model.addRow(new Object[]{rs.getString(1), rs.getString(2), rs.getString(3),
                        txt_soluong.getText(), rs.getFloat(5), thanhtien});
//                    chú ý phần này đã sửa qua
                    int row = tbl_banhang.getRowCount();

                    float tongtien = 0;

                    for (int i = 0; i < row; i++) {

                        tongtien += Float.parseFloat((String) tbl_banhang.getValueAt(i, 5));
                    }

                    txt_thanhtien.setText(tongtien + "");
                    try {
                        int soluongx = Integer.parseInt(txt_soluong.getText());
                        int soluongxx = sl - soluongx;
                        String sql1 = "update sanpham set soluong=? where maspchitiet=?";
                        PreparedStatement pstmx = cn.prepareStatement(sql1);
                        pstmx.setInt(1, soluongxx);
                        pstmx.setString(2, txt_masanphamchitiet.getText());
                        int kq = pstmx.executeUpdate();
                        if (kq > 0) {

                        } else {
                            JOptionPane.showMessageDialog(this, "Bạn đã lỗi rồi");
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "lỗi " + e);
                    }

                }

            }
            pstm.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void themhoadon() {
        String x = java.time.LocalDate.now() + "";

        model1.setRowCount(0);
        // truyền tên tài khoản để set hoa don
        try {
            String sql = "insert into hoadon values(?,?,?)";

            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, tentk);
            pstm.setString(2, x);
            pstm.setFloat(3, 0);
            int row = pstm.executeUpdate();

            pstm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi tạo hóa đơn" + e);
        }
        String mahdchitiet = "";
        try {
            String sql = "select top 1 mahd from hoadon order by mahd desc";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {

                mahdchitiet = rs.getString(1);
                lbl_mahd.setText(mahdchitiet);
            }
        } catch (Exception e) {

        }
    }

    public void themhoadonchitiet() {
        int mahdchitet = 0;
        try {
            String sql = "select top 1 mahd from hoadon order by mahd desc";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {

                mahdchitet = rs.getInt(1);
                // thêm từng hóa đơn chi tiết từ hóa đơn

                int row = tbl_banhang.getRowCount();

                for (int i = 0; i < row; i++) {
                    try {
                        String sql1 = "insert into hoadonchitiet values(?,?,?,?,?,?,?)";
                        PreparedStatement pstm = cn.prepareStatement(sql1);

                        pstm.setInt(1, mahdchitet);
                        pstm.setString(2, (String) tbl_banhang.getValueAt(i, 0));
                        pstm.setString(3, (String) tbl_banhang.getValueAt(i, 1));
                        pstm.setString(4, tbl_banhang.getValueAt(i, 2) + "");
                        pstm.setString(5, (String) tbl_banhang.getValueAt(i, 3));
                        pstm.setFloat(6, Float.parseFloat(tbl_banhang.getValueAt(i, 4) + ""));
                        pstm.setFloat(7, Float.parseFloat(tbl_banhang.getValueAt(i, 5) + ""));
                        pstm.executeUpdate();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                // update vào hóa đơn
                float thanhtien = 0;
                float tongthanhtien = 0;
                try {
                    String sqlx = "select tongtien from hoadon where mahd=?";
                    PreparedStatement pstmx = cn.prepareStatement(sqlx);
                    pstmx.setString(1, lbl_mahd.getText());
                    ResultSet rsx = pstmx.executeQuery();
                    while (rsx.next()) {
                        float thanhtienx = rs.getFloat(1);
                        try {
                            String sql2 = "update  hoadon set tongtien=? where mahd=?";
                            PreparedStatement pstm = cn.prepareStatement(sql2);
                            for (int i = 0; i < row; i++) {
                                thanhtien += (float) tbl_banhang.getValueAt(i, 5);
                                tongthanhtien = thanhtienx + thanhtien;
                                txt_thanhtien.setText(tongthanhtien + "");
                            }
                            pstm.setFloat(1, tongthanhtien);
                            pstm.setInt(2, mahdchitet);
                            int kq = pstm.executeUpdate();
                            if (kq > 0) {
                                JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                            } else {
                                JOptionPane.showMessageDialog(this, "Lỗi không thể thêm được");
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {

                }

            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi lấy mã hd chi tiết" + e);
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

        btn_thanhtoan = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_thanhtien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txt_masanphamchitiet = new javax.swing.JTextField();
        btn_Them = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt_soluong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_banhang = new javax.swing.JTable();
        btn_timkiem = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_timkiem = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txt_timkiem = new javax.swing.JTextField();
        btn_Xoa = new javax.swing.JButton();
        lbl_hinh2 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbl_mahd = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_kichco = new javax.swing.JTextField();
        txt_mausac = new javax.swing.JTextField();
        txt_dongia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_soluong2 = new javax.swing.JTextField();
        btn_sua = new javax.swing.JButton();

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

        btn_thanhtoan.setText("Thanh Toán");
        btn_thanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thanhtoanActionPerformed(evt);
            }
        });

        jLabel4.setText("Tổng Tiền");

        txt_thanhtien.setEditable(false);

        jLabel1.setText("Mã sp chi tiết");

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        jLabel3.setText("Số Lượng");

        tbl_banhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_banhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_banhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_banhang);

        btn_timkiem.setText("Tìm kiếm");
        btn_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemActionPerformed(evt);
            }
        });

        tbl_timkiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tbl_timkiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_timkiemMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_timkiem);

        jLabel2.setText("Tìm kiếm");

        txt_timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_timkiemActionPerformed(evt);
            }
        });

        btn_Xoa.setText("Xóa Hóa Đơn");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        jLabel12.setText("Ảnh");

        jLabel5.setText("Mã hóa đơn");

        jLabel6.setText("Số lượng");

        jLabel7.setText("Màu sắc");

        jLabel8.setText("Đơn giá");

        txt_kichco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kichcoActionPerformed(evt);
            }
        });

        txt_mausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_mausacActionPerformed(evt);
            }
        });

        txt_dongia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_dongiaActionPerformed(evt);
            }
        });

        jLabel9.setText("Kích cỡ");

        txt_soluong2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_soluong2ActionPerformed(evt);
            }
        });

        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(57, 57, 57)
                                .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel9))
                                .addGap(56, 56, 56)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_soluong2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_kichco, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(btn_timkiem))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel12)
                                .addGap(53, 53, 53)
                                .addComponent(lbl_hinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(320, 320, 320))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(64, 64, 64)
                                .addComponent(txt_thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(btn_thanhtoan)
                                    .addGap(198, 198, 198)
                                    .addComponent(btn_Xoa))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btn_sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txt_masanphamchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(37, 37, 37)
                                            .addComponent(btn_Them)))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txt_timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_timkiem)
                        .addComponent(jLabel5))
                    .addComponent(lbl_mahd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txt_soluong2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txt_kichco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbl_hinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Them)
                            .addComponent(txt_masanphamchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_sua)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_thanhtien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_thanhtoan)
                            .addComponent(btn_Xoa))))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:

        int sl = 0;
        float thanhtien = 0;
        int x = tbl_banhang.getSelectedRow();
        if (x == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn 1 hàng");
            return;
        }
        int hoi = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa?", "HỎi xóa", JOptionPane.YES_NO_OPTION);
        if (hoi == JOptionPane.YES_OPTION) {

            //           tbl_banhang.remove(x);
            if (x >= 0) {
                model1.removeRow(x);
            }
            int row = tbl_banhang.getRowCount();
            for (int i = 0; i < row; i++) {
                thanhtien += (float) tbl_banhang.getValueAt(i, 5);
            }
            float tongthanhtien = 0;
            try {
                String sqlx = "select tongtien from hoadon where mahd=?";
                PreparedStatement pstmx = cn.prepareStatement(sqlx);
                pstmx.setString(1, lbl_mahd.getText());
                ResultSet rsx = pstmx.executeQuery();
                while (rsx.next()) {
                    tongthanhtien = rsx.getFloat(1);
                }
            } catch (Exception e) {

            }
            try {
                String sql = "select soluong from sanpham where maspchitiet=?";
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setString(1, txt_masanphamchitiet.getText());
                ResultSet rs = pstm.executeQuery();

                while (rs.next()) {
                    sl = rs.getInt(1);
                    int soluongx = Integer.parseInt(txt_soluong.getText());
                    int soluongxx = sl + soluongx;
                    String sql1 = "update sanpham set soluong=? where maspchitiet=?";
                    PreparedStatement pstmx = cn.prepareStatement(sql1);
                    pstmx.setInt(1, soluongxx);
                    pstmx.setString(2, txt_masanphamchitiet.getText());
                    int kq = pstmx.executeUpdate();
                    if (kq > 0) {
                        JOptionPane.showMessageDialog(this, "thành công");
                    } else {
                        JOptionPane.showMessageDialog(this, "Bạn đã lỗi rồi");
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "lỗi ");
                e.printStackTrace();
            }
            txt_thanhtien.setText((thanhtien + tongthanhtien) + "");
            return;
        }
        try {
            String sql = "select soluong from sanpham where maspchitiet=?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, txt_masanphamchitiet.getText());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                sl = rs.getInt(1);
                int soluongx = Integer.parseInt(txt_soluong.getText());
                int soluongxx = sl + soluongx;
                String sql1 = "update sanpham set soluong=? where maspchitiet=?";
                PreparedStatement pstmx = cn.prepareStatement(sql1);
                pstmx.setInt(1, soluongxx);
                pstmx.setString(2, txt_masanphamchitiet.getText());
                int kq = pstmx.executeUpdate();
                if (kq > 0) {
                    JOptionPane.showMessageDialog(this, "thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn đã lỗi rồi");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "lỗi ");
            e.printStackTrace();
        }

        //        try {
        //
        //            String sql2 = "update  hoadon set thanhtien=? where mahd=?";
        //            PreparedStatement pstm = cn.prepareStatement(sql2);
        //            for (int i = 0; i < row; i++) {
        //                thanhtien += (float) tbl_banhang.getValueAt(i, 5);
        //            }
        //            pstm.setFloat(1, thanhtien);
        //            pstm.setString(2, mahdchitet);
        //            int kq = pstm.executeUpdate();
        //            if (kq > 0) {
        //
        //            } else {
        //                JOptionPane.showMessageDialog(this, "Lỗi không thể thêm được");
        //            }
        //
        //        } catch (Exception e) {
        //            JOptionPane.showMessageDialog(this, "Lỗi update hóa đơn" + e);
        //        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void txt_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_timkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_timkiemActionPerformed

    private void tbl_timkiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_timkiemMouseClicked
        // TODO add your handling code here:
        int currentRow = tbl_timkiem.getSelectedRow();
        if (currentRow >= 0) {
            txt_masanphamchitiet.setText(tbl_timkiem.getValueAt(currentRow, 1).toString());
            try {
                String sql = "select soluong,mausac,dongia,kichco,anh from sanpham where maspchitiet=?";
                PreparedStatement pstm = cn.prepareStatement(sql);
                pstm.setString(1, tbl_timkiem.getValueAt(currentRow, 1).toString());
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    txt_soluong2.setText(rs.getString(1));
                    txt_mausac.setText(rs.getString(2));
                    txt_dongia.setText(rs.getString(3));
                    txt_kichco.setText(rs.getString(4));
                    upHinh(rs.getString(5));
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi load dữ liệu bảng tìm kiếm");
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_tbl_timkiemMouseClicked

    private void btn_timkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemActionPerformed
        // TODO add your handling code here:
        model.setRowCount(0);
        ArrayList<Sanpham> list = new ArrayList<>();
        if (txt_timkiem.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập tên hoặc mã sản phẩm cần tìm");
            return;
        }
        try {
            String sql = "select * from sanpham where tensp like ? or masp like ? or tendanhmuc like ? or maspchitiet like ?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, "%" + txt_timkiem.getText() + "%");
            pstm.setString(2, "%" + txt_timkiem.getText() + "%");
            pstm.setString(3, "%" + txt_timkiem.getText() + "%");
            pstm.setString(4, "%" + txt_timkiem.getText() + "%");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                maspct = rs.getString(2);

                Sanpham sp = new Sanpham(maspct);
                list.add(sp);

                loadDatatoTable(list);

                list.clear();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không tìm được sản phẩm " + txt_timkiem.getText());
            e.printStackTrace();
        }

    }//GEN-LAST:event_btn_timkiemActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:

        int flag = 0;
        check();

        int row = tbl_banhang.getRowCount();
        for (int i = 0; i < row; i++) {
            if (txt_masanphamchitiet.getText().equalsIgnoreCase(tbl_banhang.getValueAt(i, 0).toString())) {
                JOptionPane.showMessageDialog(this, "sản phẩm này chỉ được chọn 1 lần");
                return;
            }
        }
        String mahdchitiet = "";

        try {
            String sql = "select top 1 mahd,tongtien from hoadon order by mahd desc";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {

                mahdchitiet = rs.getString(1);
                lbl_mahd.setText(mahdchitiet);

            }
        } catch (Exception e) {

        }
        try {
            String sql = "select maspchitiet from sanpham";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Sanpham sp = new Sanpham(rs.getString(1));
                list2.add(sp);
            }

            for (Sanpham x : list2) {

                if (txt_masanphamchitiet.getText().equalsIgnoreCase(x.getMaspchitet())) {
                    try {
                        String sqlx = "select maspchitiet,tensp,kichco,soluong,dongia from sanpham where maspchitiet = ?";
                        PreparedStatement pstm = cn.prepareStatement(sqlx);
                        pstm.setString(1, txt_masanphamchitiet.getText());
                        ResultSet rsc = pstm.executeQuery();
                        while (rsc.next()) {
                            int sl = rsc.getInt(4);
                            if (sl < Integer.parseInt(txt_soluong.getText())) {
                                JOptionPane.showMessageDialog(this, "Lớn hơn số lượng");
                            } else {
                                Float thanhtien = Integer.parseInt(txt_soluong.getText()) * rsc.getFloat(5);
                                model1.addRow(new Object[]{rsc.getString(1), rsc.getString(2), rsc.getString(3),
                                    txt_soluong.getText(), rsc.getFloat(5), thanhtien});

                                float tongtien = 0;

                                for (int i = 0; i < row + 1; i++) {

                                    tongtien += Float.parseFloat(String.valueOf(tbl_banhang.getValueAt(i, 5)));
                                }

                                txt_thanhtien.setText(tongtien + "");
// update số lượng trừ
                                try {
                                    int soluongx = Integer.parseInt(txt_soluong.getText());
                                    int soluongxx = sl - soluongx;
                                    String sql1 = "update sanpham set soluong=? where maspchitiet=?";
                                    PreparedStatement pstmx = cn.prepareStatement(sql1);
                                    pstmx.setInt(1, soluongxx);
                                    pstmx.setString(2, txt_masanphamchitiet.getText());
                                    int kq = pstmx.executeUpdate();
                                    if (kq > 0) {

                                    } else {
                                        JOptionPane.showMessageDialog(this, "Bạn đã lỗi rồi");
                                    }

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(this, "lỗi " + e);
                                }
                            }
                        }

                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Không tìm được mã sản phẩm trên");
                    }
                    return;

                } else {
                    flag++;
                }

            }
        } catch (Exception e) {

        }
        if (flag != 0) {
            JOptionPane.showMessageDialog(this, "Không tìm được mã sản phẩm trên");
        }


    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_thanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thanhtoanActionPerformed
        // TODO add your handling code here:
        themhoadonchitiet();
        themhoadon();
        clear();
    }//GEN-LAST:event_btn_thanhtoanActionPerformed

    private void txt_kichcoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kichcoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kichcoActionPerformed

    private void txt_mausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_mausacActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_mausacActionPerformed

    private void txt_dongiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_dongiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_dongiaActionPerformed

    private void txt_soluong2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_soluong2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_soluong2ActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        themhoadon();


    }//GEN-LAST:event_formInternalFrameOpened

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        // TODO add your handling code here:
        int flag = 0;
        int row = tbl_banhang.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "vui lòng chọn 1 hàng");
        }
        int dem = tbl_banhang.getRowCount();
        for (int i = 0; i < dem; i++) {
            if (txt_masanphamchitiet.getText().equalsIgnoreCase(tbl_banhang.getValueAt(i, 0).toString())) {
                if (txt_masanphamchitiet.getText().equalsIgnoreCase(tbl_banhang.getValueAt(row, 0).toString())) {

                } else {

                    JOptionPane.showMessageDialog(this, "sản phẩm này chỉ được chọn 1 lần");
                    return;
                }
            }
        }
        try {
            String sql = "select soluong from sanpham where maspchitiet=?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, tbl_banhang.getValueAt(row, 0) + "");
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                int sl = rs.getInt(1);
                try {
                    String sql1 = "update sanpham set soluong=? where maspchitiet=?";
                    PreparedStatement pstm1 = cn.prepareStatement(sql1);

                    int soluong = sl + Integer.parseInt((String) tbl_banhang.getValueAt(row, 3));
                    pstm1.setString(1, soluong + "");
                    pstm1.setString(2, tbl_banhang.getValueAt(row, 0).toString());
                } catch (Exception e) {

                }
            }
        } catch (Exception e) {

        }
        model1.removeRow(row);
        check();
        try {
            String sql = "select maspchitiet from sanpham";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                Sanpham sp = new Sanpham(rs.getString(1));
                list2.add(sp);
            }

            for (Sanpham x : list2) {

                if (txt_masanphamchitiet.getText().equalsIgnoreCase(x.getMaspchitet())) {
                    try {
                        String sqlx = "select maspchitiet,tensp,kichco,soluong,dongia from sanpham where maspchitiet = ?";
                        PreparedStatement pstm = cn.prepareStatement(sqlx);
                        pstm.setString(1, txt_masanphamchitiet.getText());
                        ResultSet rsc = pstm.executeQuery();
                        while (rsc.next()) {
                            int sl = rsc.getInt(4);
                            if (sl < Integer.parseInt(txt_soluong.getText())) {
                                JOptionPane.showMessageDialog(this, "Lớn hơn số lượng");
                            } else {
                                Float thanhtien = Integer.parseInt(txt_soluong.getText()) * rsc.getFloat(5);
                                model1.addRow(new Object[]{rsc.getString(1), rsc.getString(2), rsc.getString(3),
                                    txt_soluong.getText(), rsc.getFloat(5), thanhtien});

                                float tongtien = 0;
                                int dong = tbl_banhang.getRowCount();
                                for (int i = 0; i < dong; i++) {

                                    tongtien += Float.parseFloat(String.valueOf(tbl_banhang.getValueAt(i, 5)));
                                }

                                txt_thanhtien.setText(tongtien + "");
// update số lượng trừ
                                try {
                                    int soluongx = Integer.parseInt(txt_soluong.getText());
                                    int soluongxx = sl - soluongx;
                                    String sql1 = "update sanpham set soluong=? where maspchitiet=?";
                                    PreparedStatement pstmx = cn.prepareStatement(sql1);
                                    pstmx.setInt(1, soluongxx);
                                    pstmx.setString(2, txt_masanphamchitiet.getText());
                                    int kq = pstmx.executeUpdate();
                                    if (kq > 0) {

                                    } else {
                                        JOptionPane.showMessageDialog(this, "Bạn đã lỗi rồi");
                                    }

                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(this, "lỗi " + e);
                                }
                            }
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;

                } else {
                    flag++;
                }

            }
        } catch (Exception e) {

        }
        if (flag != 0) {
            JOptionPane.showMessageDialog(this, "Không tìm được mã sản phẩm trên");
        }


    }//GEN-LAST:event_btn_suaActionPerformed

    private void tbl_banhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_banhangMouseClicked
        // TODO add your handling code here:
        int row = tbl_banhang.getSelectedRow();
        if (row >= 0) {
            txt_masanphamchitiet.setText(tbl_banhang.getValueAt(row, 0).toString());
            txt_soluong.setText(tbl_banhang.getValueAt(row, 3).toString());
        } else {

        }
    }//GEN-LAST:event_tbl_banhangMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_thanhtoan;
    private javax.swing.JButton btn_timkiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_hinh2;
    private javax.swing.JLabel lbl_mahd;
    private javax.swing.JTable tbl_banhang;
    private javax.swing.JTable tbl_timkiem;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_kichco;
    private javax.swing.JTextField txt_masanphamchitiet;
    private javax.swing.JTextField txt_mausac;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JTextField txt_soluong2;
    private javax.swing.JTextField txt_thanhtien;
    private javax.swing.JTextField txt_timkiem;
    // End of variables declaration//GEN-END:variables
public void loadDatatoTable(ArrayList<Sanpham> list) {
        try {

            for (Sanpham x : list) {
                String sql = "Select * from sanpham where  maspchitiet=? ";
                PreparedStatement pstm = cn.prepareStatement(sql);

                pstm.setString(1, x.getMaspchitet());

                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {

                    Vector v = new Vector();
                    v.add(rs.getString(1));
                    v.add(rs.getString(2));
                    v.add(rs.getString(3));
                    v.add(rs.getString(4));

                    model.addRow(v);
                    tbl_timkiem.setModel(model);
                }

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load data to table");
        }
    }

}
