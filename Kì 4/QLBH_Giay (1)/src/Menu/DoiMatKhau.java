/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Uhelper.Helper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import Menu.DangNhap;

/**
 *
 * @author khanh
 */
public class DoiMatKhau extends javax.swing.JInternalFrame {

    /**
     * Creates new form DoiMatKhau
     */
    Connection cn;
//    int ma = (int) Math.floor(((Math.random() * 899999) + 100000));

    public DoiMatKhau() {
        initComponents();
        cn = Helper.ketnoi("QLBH01");
    }

//    public void guiemail(int ma) {
//        Properties p = new Properties();
//        p.put("mail.smtp.auth", "true");
//        p.put("mail.smtp.starttls.enable", "true");
//        p.put("mail.smtp.host", "smtp.gmail.com");
//        p.put("mail.smtp.port", 587);
//        // Lay doi tuong Session mac dinh.
//        Session s = Session.getInstance(p,
//                new javax.mail.Authenticator() {
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("menscollection2001@gmail.com", "khanh2001");
//            }
//        });
//        try {
//            String fromName = "Men's Collection";
//            String fromEmail = "menscollection2001@gmail.com";
//            String toEmail = txt_email.getText();//email nhân viên
//            String tieude = "Xác nhận email Men's Collection";
//            String noidung = "Mã xác nhận email của bạn là " + ma;//random số
//            Message msg = new MimeMessage(s);
//            msg.setFrom(new InternetAddress(fromEmail));
//            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
//            msg.setSubject(tieude);
//            msg.setText(noidung);
//
//            // Send message
//            Transport.send(msg);
//        } catch (Exception e) {
////            e.printStackTrace();
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_loimatkhaucu = new javax.swing.JLabel();
        lbl_loiXNmatkhau = new javax.swing.JLabel();
        lbl_loimatkhaumoi = new javax.swing.JLabel();
        btn_xacnhan = new javax.swing.JButton();
        txt_passcu = new javax.swing.JPasswordField();
        txt_passmoi = new javax.swing.JPasswordField();
        txt_passXN = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("ĐỔI MẬT KHẨU");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Mật khẩu cũ");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Mật khẩu mới");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nhập lại mật khẩu mới");

        lbl_loimatkhaucu.setForeground(new java.awt.Color(255, 0, 0));

        lbl_loiXNmatkhau.setForeground(new java.awt.Color(255, 0, 0));

        lbl_loimatkhaumoi.setForeground(new java.awt.Color(255, 0, 0));

        btn_xacnhan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_xacnhan.setText("Xác nhận");
        btn_xacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xacnhanActionPerformed(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(51, 0, 204));
        jLabel5.setText("Quay lại");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(346, 346, 346)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_loiXNmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_passXN, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_loimatkhaucu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_loimatkhaumoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_passcu)
                            .addComponent(txt_passmoi))))
                .addGap(419, 419, 419))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_xacnhan)
                .addGap(613, 613, 613))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(606, 606, 606))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_passcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_loimatkhaucu, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_passmoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_loimatkhaumoi, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_passXN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbl_loiXNmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btn_xacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(183, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_xacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xacnhanActionPerformed
        // TODO add your handling code here:
        //tài khoản 
        //matkhau,email từ tài khoản
        String matkhaucu = new String(txt_passcu.getPassword());
        String matkhaumoi = new String(txt_passmoi.getPassword());
        String matkhaumoiXN = new String(txt_passXN.getPassword());
        int so1 = 0;
        int so2 = 0;
        int so3 = 0;
        int so4 = 0;
        //tìa khoản
        if (matkhaucu.equals("")) {
            lbl_loimatkhaucu.setText("Mật khẩu cũ không được để trống");
            so1 = 1;
        } else {
            lbl_loimatkhaucu.setText("");
            so1 = 0;
        }
        try {
            String sql1 = "Select matkhau From taikhoan where tentaikhoan =?";
            PreparedStatement pstm1 = cn.prepareStatement(sql1);
            pstm1.setString(1, DangNhap.tkdadn);
            ResultSet rs1 = pstm1.executeQuery();
            while (rs1.next()) {
                if (!matkhaucu.equals(rs1.getString(1))) {
                    lbl_loimatkhaucu.setText("Mật khẩu cũ không đúng");
                    so1 = 1;
                } else {
                    lbl_loimatkhaucu.setText("");
                    so1 = 0;
                }
            }
        } catch (Exception e) {
        }
        try {

            //mật khẩu
            if (matkhaumoi.equals("")) {
                lbl_loimatkhaumoi.setText("Mật khẩu mới không được để trống");
                so2 = 1;
            } else if (matkhaumoi.length() < 6) {
                lbl_loimatkhaumoi.setText("Mật khẩu phải ít nhất 6 ký tự");
                so2 = 1;
            } else {
                lbl_loimatkhaumoi.setText("");
                so2 = 0;
            }
            //xác nhận mật khẩu
            if (matkhaumoiXN.equals("")) {
                lbl_loiXNmatkhau.setText("Mật khẩu xác nhận không được để trống");
                so3 = 1;
            } else if (!matkhaumoiXN.equals(matkhaumoi)) {
                lbl_loiXNmatkhau.setText("Mật khẩu xác nhận chưa đúng");
                so3 = 1;
            } else {
                lbl_loiXNmatkhau.setText("");
                so3 = 0;
            }

            //Xác nhận email
//            if (txt_XNemail.getText().equals("")) {
//                lbl_loiXNemail.setText("Xác nhận email không được để trống");
//                so4 = 1;
//            } else if (!txt_XNemail.getText().equalsIgnoreCase(String.valueOf(""))) {//aaaaaaaaaaaaasửa
//                lbl_loiXNemail.setText("Mã xác nhận không đúng");
//                so4 = 1;
//            } else {
//                lbl_loiXNemail.setText("");
//                so4 = 0;
//            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
        if (so1 != 0 || so2 != 0 || so3 != 0) {
            return;
        }
        try {
            String sql = "Update taikhoan\n"
                    + "set matkhau=?\n"
                    + "where tentaikhoan=?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setString(1, matkhaumoiXN);
            pstm.setString(2, DangNhap.tkdadn);
            int row = pstm.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Đổi mật khẩu thất bại!!");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btn_xacnhanActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jLabel5MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_xacnhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbl_loiXNmatkhau;
    private javax.swing.JLabel lbl_loimatkhaucu;
    private javax.swing.JLabel lbl_loimatkhaumoi;
    private javax.swing.JPasswordField txt_passXN;
    private javax.swing.JPasswordField txt_passcu;
    private javax.swing.JPasswordField txt_passmoi;
    // End of variables declaration//GEN-END:variables
}
