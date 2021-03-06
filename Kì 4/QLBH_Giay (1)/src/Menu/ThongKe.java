/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Uhelper.Helper;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import Menu.TrangChu;

/**
 *
 * @author khanh
 */
public class ThongKe extends javax.swing.JInternalFrame {

    /**
     * Creates new form ThongKe
     */
    Connection cn;
    LichSuHoaDon lichsuhoadon;

    public ThongKe() {
        initComponents();
        cn = Helper.ketnoi("QLBH01");
        try {
            String sql = "SELECT DISTINCT MONTH(ngaytao)AS 'thang', YEAR(ngaytao) AS 'Nam'\n "
                    + "FROM dbo.hoadon";
            Statement stm = cn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cbo_thang.addItem(rs.getString(1) + "/" + rs.getString(2));
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
        }
        

    }

    public void loadHinh(String image) {
        ImageIcon icon1 = new ImageIcon("src//Image//" + image);
        Image im = icon1.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(250, 250, Image.SCALE_SMOOTH));
        lbl_anhsp.setIcon(icon);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop_thongke = new javax.swing.JDesktopPane();
        btn_lichsu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbo_thang = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_tongdon = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_tongnv = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbl_tongtien = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lbl_anhsp = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lbl_tenbanchay = new javax.swing.JTextArea();
        lbl_mabanchay = new javax.swing.JLabel();
        lbl_daban = new javax.swing.JLabel();

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

        btn_lichsu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_lichsu.setText("L???ch s??? s???n ph???m ???? b??n");
        btn_lichsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lichsuActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("K???T QU??? B??N H??NG");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("TH??NG");

        cbo_thang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_thangItemStateChanged(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("T???ng s??? ????n");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Rectangle 14.png"))); // NOI18N

        lbl_tongdon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_tongdon.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 110, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_tongdon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lbl_tongdon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("T???ng s??? nh??n vi??n");

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Rectangle 13.png"))); // NOI18N

        lbl_tongnv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_tongnv.setText("0");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 51, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_tongnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(lbl_tongnv, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Th???ng k??");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Rectangle 7.png"))); // NOI18N

        lbl_tongtien.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbl_tongtien.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbl_tongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("S???N PH???M B??N CH???Y");

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbl_anhsp.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("M??:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("T??n s???n ph???m:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setText("???? b??n:");

        lbl_tenbanchay.setEditable(false);
        lbl_tenbanchay.setColumns(20);
        lbl_tenbanchay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lbl_tenbanchay.setLineWrap(true);
        lbl_tenbanchay.setRows(5);
        lbl_tenbanchay.setWrapStyleWord(true);
        jScrollPane1.setViewportView(lbl_tenbanchay);

        lbl_mabanchay.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lbl_daban.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(lbl_anhsp, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_mabanchay, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(lbl_daban, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_mabanchay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_daban, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(lbl_anhsp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        desktop_thongke.setLayer(btn_lichsu, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop_thongke.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop_thongke.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop_thongke.setLayer(cbo_thang, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop_thongke.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop_thongke.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop_thongke.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop_thongke.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        desktop_thongke.setLayer(jPanel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktop_thongkeLayout = new javax.swing.GroupLayout(desktop_thongke);
        desktop_thongke.setLayout(desktop_thongkeLayout);
        desktop_thongkeLayout.setHorizontalGroup(
            desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(desktop_thongkeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(desktop_thongkeLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_lichsu)
                        .addContainerGap())
                    .addGroup(desktop_thongkeLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 232, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(165, 165, 165)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(272, 272, 272))))
            .addGroup(desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(desktop_thongkeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(desktop_thongkeLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(1200, 1200, Short.MAX_VALUE))
                        .addGroup(desktop_thongkeLayout.createSequentialGroup()
                            .addGroup(desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(desktop_thongkeLayout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 879, Short.MAX_VALUE)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(cbo_thang, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(desktop_thongkeLayout.createSequentialGroup()
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 261, Short.MAX_VALUE)))
                            .addContainerGap()))))
        );
        desktop_thongkeLayout.setVerticalGroup(
            desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, desktop_thongkeLayout.createSequentialGroup()
                .addGroup(desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(desktop_thongkeLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(desktop_thongkeLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 239, Short.MAX_VALUE)
                .addComponent(btn_lichsu, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(desktop_thongkeLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(desktop_thongkeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2)
                        .addComponent(cbo_thang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(113, 113, 113)
                    .addComponent(jLabel3)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop_thongke, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop_thongke)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_thangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_thangItemStateChanged
        // TODO add your handling code here:
        String[] chon = ((String) cbo_thang.getSelectedItem()).split("/");
        try {
            String sql = "Select count(mahd),sum(tongtien), MONTH(ngaytao)AS 'thang', YEAR(ngaytao) AS 'Nam'\n"
                    + "FROM dbo.hoadon\n"
                    + "WHERE MONTH(ngaytao)=? and YEAR(ngaytao)=?\n"
                    + "GROUP BY MONTH(ngaytao), YEAR(ngaytao)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, chon[0]);
            pstm.setString(2, chon[1]);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                lbl_tongdon.setText(rs.getString(1));
                lbl_tongtien.setText(rs.getFloat(2) + "00 VN??");
            }
            rs.close();
            pstm.close();
        } catch (Exception e) {
        }
        try {
            String sql1 = "SELECT TOP 1 SUM(dbo.hoadonchitiet.soluong) AS 'sl',hoadonchitiet.mahd,dbo.sanpham.tensp,dbo.sanpham.anh,\n"
                    + "dbo.hoadonchitiet.maspchitiet,MONTH(ngaytao)AS 'thang', YEAR(ngaytao) AS 'Nam'\n"
                    + "FROM ((dbo.hoadonchitiet JOIN dbo.hoadon ON hoadonchitiet.mahd = hoadon.mahd)\n"
                    + "JOIN dbo.sanpham ON sanpham.maspchitiet = hoadonchitiet.maspchitiet)\n"
//                    + "JOIN dbo.hoadon ON hoadonchitiet.mahd = hoadon.mahd \n"
                    + "WHERE MONTH(ngaytao)=? AND YEAR(ngaytao)=?\n"
                    + "GROUP BY dbo.hoadonchitiet.maspchitiet,MONTH(ngaytao), YEAR(ngaytao),dbo.sanpham.tensp,dbo.sanpham.anh,hoadonchitiet.mahd\n"
                    + "ORDER BY SUM(dbo.hoadonchitiet.soluong) DESC";
            PreparedStatement pstm1 = cn.prepareStatement(sql1);
            pstm1.setString(1, chon[0]);
            pstm1.setString(2, chon[1]);
            ResultSet rs1 = pstm1.executeQuery();
            while (rs1.next()) {
                if (!rs1.getString(5).equalsIgnoreCase("")) {
                    lbl_mabanchay.setText(rs1.getString(5));
                    lbl_tenbanchay.setText(rs1.getString(3));
                    lbl_daban.setText(String.valueOf(rs1.getInt(1)));
                    loadHinh(rs1.getString(4));
                } else {
                    lbl_mabanchay.setText("");
                    lbl_tenbanchay.setText("");
                    lbl_daban.setText("");
                    loadHinh("");
                }
            }
            rs1.close();
            pstm1.close();
        } catch (Exception e) {
        }
        try {
            String sql2 = "SELECT COUNT(tentaikhoan)\n"
                    + "FROM dbo.taikhoan\n"
                    + "WHERE vaitro =0 or vaitro=1";
            Statement stm = cn.createStatement();
            ResultSet rs2 = stm.executeQuery(sql2);
            while (rs2.next()) {
                lbl_tongnv.setText(rs2.getString(1));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_thangItemStateChanged

    private void btn_lichsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lichsuActionPerformed
        // TODO add your handling code here:
        if (lichsuhoadon == null || lichsuhoadon.isClosed()) {
            lichsuhoadon = new LichSuHoaDon();
            desktop_thongke.add(lichsuhoadon);
            lichsuhoadon.setVisible(true);
        } else {
            lichsuhoadon.setVisible(true);
        }
    }//GEN-LAST:event_btn_lichsuActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formInternalFrameOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_lichsu;
    private javax.swing.JComboBox<String> cbo_thang;
    private javax.swing.JDesktopPane desktop_thongke;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_anhsp;
    private javax.swing.JLabel lbl_daban;
    private javax.swing.JLabel lbl_mabanchay;
    private javax.swing.JTextArea lbl_tenbanchay;
    private javax.swing.JLabel lbl_tongdon;
    private javax.swing.JLabel lbl_tongnv;
    private javax.swing.JLabel lbl_tongtien;
    // End of variables declaration//GEN-END:variables
}
