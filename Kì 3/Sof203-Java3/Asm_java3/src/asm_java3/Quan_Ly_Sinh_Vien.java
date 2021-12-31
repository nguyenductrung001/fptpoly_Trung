/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asm_java3;

import DAO.QLDDAO;
import DAO.QLSVDAO;
import Data.QLD;
import Data.QLSV;
import static java.awt.Image.SCALE_DEFAULT;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

public class Quan_Ly_Sinh_Vien extends javax.swing.JFrame {

    DefaultTableModel model;
    public File selected = null;
    int index = -1;
    String Colums[] = {"Mã SV", "Họ Tên", "Email", "Số ĐT",
        "Giới Tính", "Địa Chỉ", "Hình"};

    public Quan_Ly_Sinh_Vien() {
        initComponents();
        model = new DefaultTableModel(Colums, 0);
        tbl_QLSV.setModel(model);
        QLSVDAO.showDataToTable(model);
    }

    public int CheckMa() {
        for (int i = 0; i < tbl_QLSV.getRowCount() - 1; i++) {
            if (txt_MaSV.getText().equals(model.getValueAt(i, 0))) {
                return i;
            }
        }
        return -1;
    }

    public void Showdetail() {
        if (index != -1) {
            txt_name.setText((String) model.getValueAt(index, 1));
            txt_SDT.setText((String) model.getValueAt(index, 3));
            txt_Email.setText((String) model.getValueAt(index, 2));
            txt_MaSV.setText((String) model.getValueAt(index, 0));
            showIcon(new File("D:/java3ass_image/" + (String) model.getValueAt(index, 6)));
            txt_Address.setText((String) model.getValueAt(index, 5));
            if (((String) model.getValueAt(index, 4)).equals("Nam")) {
                rdo_Nam.setSelected(true);
            } else {
                rdo_Nu.setSelected(true);
            }
        }
    }

    public void showIcon(File f) {
        try {
            ImageIcon img = new ImageIcon(ImageIO.read(f)
                    .getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(), SCALE_DEFAULT));
            lblIcon.setIcon(img);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void copyFile() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File des = new File("D:/java3ass_image/" + txt_MaSV.getText()
                    + selected.getPath().substring(selected.getPath().lastIndexOf(".")));

            fis = new FileInputStream(selected);
            fos = new FileOutputStream(des);

            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fos.write(buffer);
        } catch (Exception e) {
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteFile(int i) {
        File f = new File("D:/java3ass_image/" + model.getValueAt(i, 6));
        if (f.exists()) {
            f.delete();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_MaSV = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        txt_SDT = new javax.swing.JTextField();
        rdo_Nam = new javax.swing.JRadioButton();
        rdo_Nu = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_Save = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btn_Edit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_QLSV = new javax.swing.JTable();
        lblIcon = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_Address = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setText("Mã SV");

        jLabel3.setText("Họ Tên");

        jLabel4.setText("Email");

        jLabel5.setText("Số Đt");

        txt_name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nameKeyTyped(evt);
            }
        });

        txt_SDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SDTActionPerformed(evt);
            }
        });
        txt_SDT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SDTKeyTyped(evt);
            }
        });

        buttonGroup1.add(rdo_Nam);
        rdo_Nam.setSelected(true);
        rdo_Nam.setText("Nam");

        buttonGroup1.add(rdo_Nu);
        rdo_Nu.setText("Nữ");

        jLabel6.setText("Gioi Tinh");

        jLabel7.setText("Địa chỉ:");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images/Add_1.png"))); // NOI18N
        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images/Save.png"))); // NOI18N
        btn_Save.setText("Save");
        btn_Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SaveActionPerformed(evt);
            }
        });

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images/Delete.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btn_Edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Images/Edit.png"))); // NOI18N
        btn_Edit.setText("Update");
        btn_Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_EditActionPerformed(evt);
            }
        });

        tbl_QLSV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã SV", "Họ Tên", "Email", "Số ĐT", "Gioi Tính", "Địa chỉ ", "Hình"
            }
        ));
        tbl_QLSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_QLSVMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_QLSV);

        lblIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconMouseClicked(evt);
            }
        });

        txt_Address.setColumns(20);
        txt_Address.setRows(5);
        jScrollPane2.setViewportView(txt_Address);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdo_Nam)
                                        .addGap(37, 37, 37)
                                        .addComponent(rdo_Nu))
                                    .addComponent(txt_MaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_name, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(txt_Email)
                                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnDelete)
                                            .addComponent(jButton1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btn_Edit)
                                            .addComponent(btn_Save)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_MaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(btn_Save))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDelete)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdo_Nam)
                        .addComponent(rdo_Nu)
                        .addComponent(jLabel6)
                        .addComponent(btn_Edit)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SDTActionPerformed

    private void txt_SDTKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SDTKeyTyped
        // TODO add your handling code here:
        if (!Pattern.compile("[0-9]").matcher(String.valueOf(evt.getKeyChar())).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_SDTKeyTyped

    private void txt_nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nameKeyTyped
        // TODO add your handling code here:
        if (!Pattern.compile(
                "[ aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]")
                .matcher(String.valueOf(evt.getKeyChar())).matches()) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nameKeyTyped

    private void btn_SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SaveActionPerformed
        // TODO add your handling code here:

        if (txt_MaSV.getText().equals("") || txt_name.getText().equals("")
                || txt_Address.getText().equals("")
                || txt_Email.getText().equals("")
                || txt_SDT.getText().equals("") || selected == null) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập đủ form");
        } else if (!Pattern.compile("\\w{1,}@\\w{1,}(\\.\\w{1,}){1,}").matcher(txt_Email.getText()).matches()) {
            JOptionPane.showMessageDialog(this, "Mail phải đúng định dạng");
        } else if (CheckMa() != -1) {
            JOptionPane.showMessageDialog(this, "Mã đã tồn tại");
        } else {
            QLSV ql = new QLSV();
            ql.MaSV = txt_MaSV.getText();
            ql.HoTen = txt_name.getText();
            ql.Email = txt_Email.getText();
            ql.DiaChi = txt_Address.getText();
            ql.SDT = txt_SDT.getText();
            ql.gioitinh = rdo_Nam.isSelected();
            ql.Img = txt_MaSV.getText() + selected.getPath().substring(selected.getPath().lastIndexOf("."));
            if (QLSVDAO.insert(ql)) {
                QLDDAO.insert(new QLD(ql.MaSV, ql.HoTen, 0, 0, 0));
                copyFile();
                model.addRow(new Object[]{ql.MaSV, ql.HoTen, ql.Email, ql.SDT, (ql.gioitinh ? "Nam" : "Nữ"), ql.DiaChi, ql.Img});
            }
        }
    }//GEN-LAST:event_btn_SaveActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int i;
        if ((i = tbl_QLSV.getSelectedRow()) >= 0) {
            String masv = (String) model.getValueAt(i, 0);
            if (QLDDAO.delete(masv)) {
                QLSVDAO.delete(masv);
                deleteFile(i);
            }
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        txt_name.setText("");
        txt_Email.setText("");
        txt_SDT.setText("");
        txt_MaSV.setText("");
        txt_Address.setText("");
        rdo_Nam.setSelected(true);
        lblIcon.setIcon(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblIconMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconMouseClicked
        // TODO add your handling code here:

        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("Anh(jpg,png,gif)", "jpg", "png", "gif"));
        jfc.setDialogTitle("Chọn 1 file ảnh!");
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            selected = jfc.getSelectedFile();
            showIcon(selected);
        }
    }//GEN-LAST:event_lblIconMouseClicked

    private void btn_EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_EditActionPerformed
        // TODO add your handling code here:
        if (txt_MaSV.getText().equals("") || txt_name.getText().equals("")
                || txt_Address.getText().equals("")
                || txt_Email.getText().equals("")
                || txt_SDT.getText().equals("") || selected == null) {
            JOptionPane.showMessageDialog(this, "Bạn phải nhập đủ form");
        } else if (!Pattern.compile("\\w{1,}@\\w{1,}(\\.\\w{1,}){1,}").matcher(txt_Email.getText()).matches()) {
            JOptionPane.showMessageDialog(this, "Mail phải đúng định dạng");
        } else {
            QLSV ql = new QLSV();
            ql.MaSV = txt_MaSV.getText();
            ql.HoTen = txt_name.getText();
            ql.Email = txt_Email.getText();
            ql.DiaChi = txt_Address.getText();
            ql.SDT = txt_SDT.getText();
            ql.gioitinh = rdo_Nam.isSelected();
            ql.Img = txt_MaSV.getText() + selected.getPath().substring(selected.getPath().lastIndexOf("."));
            if (QLSVDAO.update(ql)) {
                copyFile();
                model.addRow(new Object[]{ql.MaSV, ql.HoTen, ql.Email, ql.SDT, (ql.gioitinh ? "Nam" : "Nữ"), ql.DiaChi, ql.Img});
            }
        }

    }//GEN-LAST:event_btn_EditActionPerformed

    private void tbl_QLSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_QLSVMouseClicked
        // TODO add your handling code here:
        index = tbl_QLSV.getSelectedRow();
        Showdetail();

    }//GEN-LAST:event_tbl_QLSVMouseClicked

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
            java.util.logging.Logger.getLogger(Quan_Ly_Sinh_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sinh_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sinh_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quan_Ly_Sinh_Vien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quan_Ly_Sinh_Vien().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btn_Edit;
    private javax.swing.JButton btn_Save;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JRadioButton rdo_Nam;
    private javax.swing.JRadioButton rdo_Nu;
    private javax.swing.JTable tbl_QLSV;
    private javax.swing.JTextArea txt_Address;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_MaSV;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_name;
    // End of variables declaration//GEN-END:variables

}
