package Frame;

import Code.Info_students;
import Code.Points;
import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author manhk
 */
public class quanlysinhvien extends javax.swing.JFrame {

    String[] header = {"Mã SV", "Họ tên", " Email", "Số ĐT", "Giới tính", "Địa chỉ", "Hình"};
    DefaultTableModel model = new DefaultTableModel(header, 0);
    File chon = null;

    public quanlysinhvien() {
        initComponents();
        setTitle("Quản lý danh sách sinh viên");
        setLocationRelativeTo(null);
        tb_table.setModel(model);
        SQL.helper.putDataToTable(model);
        if (model.getRowCount() > 0) {
            showDetail(0);
            tb_table.setRowSelectionInterval(0, 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_code = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_name = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_sodienthoai = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        pic = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdo_nam = new javax.swing.JRadioButton();
        rdo_nu = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_diachi = new javax.swing.JTextArea();
        bt_new = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();
        bt_save = new javax.swing.JButton();
        bt_delete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Quản Lý Sinh Viên");

        jLabel2.setText("Ma SV");

        jLabel3.setText("Họ Tên");

        txt_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nameActionPerformed(evt);
            }
        });

        jLabel4.setText("Email");

        jLabel5.setText("Số ĐT");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pic.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pic.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                picMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                picMouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pic, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel6.setText("Giới Tính");

        buttonGroup1.add(rdo_nam);
        rdo_nam.setSelected(true);
        rdo_nam.setText("Nam");
        rdo_nam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdo_namActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_nu);
        rdo_nu.setText("Nữ");

        jLabel7.setText("Địa Chỉ");

        txt_diachi.setColumns(20);
        txt_diachi.setLineWrap(true);
        txt_diachi.setRows(5);
        txt_diachi.setToolTipText("");
        txt_diachi.setWrapStyleWord(true);
        jScrollPane1.setViewportView(txt_diachi);

        bt_new.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        bt_new.setText("New");
        bt_new.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_newActionPerformed(evt);
            }
        });

        bt_update.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Accept.png"))); // NOI18N
        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        bt_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        bt_save.setText("Save");
        bt_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_saveActionPerformed(evt);
            }
        });

        bt_delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        bt_delete.setText("Delete");
        bt_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_deleteActionPerformed(evt);
            }
        });

        tb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã SV", "Họ tên", "Email", "Số ĐT", "Giới Tính", "Địa chỉ", "Hình"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tb_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txt_sodienthoai, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_name, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txt_code, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(rdo_nam)
                            .addGap(18, 18, 18)
                            .addComponent(rdo_nu))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bt_new, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bt_delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bt_update))
                            .addComponent(bt_save, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(96, 96, 96))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_code, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_sodienthoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(rdo_nam)
                            .addComponent(rdo_nu))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_new)
                            .addComponent(bt_save))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_update)
                            .addComponent(bt_delete))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nameActionPerformed

    private void rdo_namActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdo_namActionPerformed

    }//GEN-LAST:event_rdo_namActionPerformed

    private void bt_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_deleteActionPerformed
        int i = tb_table.getSelectedRow();
        if (i >= 0 && JOptionPane.showConfirmDialog(this, "Xác nhận xóa sinh viên", "", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
            SQL.helper.deletePoint(new Points((String) model.getValueAt(i, 0), "", 0, 0, 0));
            SQL.helper.deleteSV(new Info_students((String) model.getValueAt(i, 0), "", "", "", "", "", true));
            model.removeRow(i);
            tb_table.clearSelection();
            deletePic(chon);
            deleteFrom();
        }
    }//GEN-LAST:event_bt_deleteActionPerformed

    private void bt_newActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_newActionPerformed
        int x = JOptionPane.showConfirmDialog(this, "bạn có muốn reset from?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (x == 0) {
            deleteFrom();
        }
    }//GEN-LAST:event_bt_newActionPerformed

    private void bt_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_saveActionPerformed
        // TODO add your handling code here:
        if (checkData()) {
            if (checkSTT(txt_code.getText()) == -1) {
                Info_students x = new Info_students(
                        txt_code.getText(),
                        txt_name.getText(),
                        txt_email.getText(),
                        txt_sodienthoai.getText(),
                        txt_diachi.getText(),
                        pic.getName(),
                        rdo_nam.isSelected());
                SQL.helper.insertSV(x);
                String GT;
                if (x.gioitinh == true) {
                    GT = "Nam";
                } else {
                    GT = "Nữ";
                }
                model.addRow(new Object[]{
                    x.MaSV,
                    x.Hoten,
                    x.email,
                    x.SDT,
                    GT,
                    x.Diachi,
                    x.hinh
                });
                tb_table.setRowSelectionInterval(model.getRowCount() - 1, model.getRowCount() - 1);
                copyFile(chon);
            } else {
                JOptionPane.showMessageDialog(this, "hãy dùng update");
            }
        }
    }//GEN-LAST:event_bt_saveActionPerformed

    private void picMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser jfc = new JFileChooser();
            if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                chon = jfc.getSelectedFile();
                showIcon(chon);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "vui lòng thử lại sau");
        }

    }//GEN-LAST:event_picMouseClicked

    private void picMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_picMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_picMouseEntered

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        if(checkData()){
            int i = checkSTT(txt_code.getText());
            if(i !=tb_table.getSelectedRow()){
                JOptionPane.showMessageDialog(this, "không được thay đổi mã nhân viên");
                return;
            }
         if(i !=1){
          Info_students x = new Info_students(
                        txt_code.getText(),
                        txt_name.getText(),
                        txt_email.getText(),
                        txt_sodienthoai.getText(),
                        txt_diachi.getText(),
                        pic.getName(),
                        rdo_nam.isSelected());
          SQL.helper.updateSV(x);
          String GT;
                if (x.gioitinh == true) {
                    GT = "Nam";
                } else {
                    GT = "Nữ";
                }
                model.setValueAt(txt_code.getText(), i, 0);
                model.setValueAt(txt_name.getText(), i, 1);
                model.setValueAt(txt_email.getText(), i, 2);
                model.setValueAt(txt_sodienthoai.getText(), i, 3);
                model.setValueAt(GT, i, 4);
                model.setValueAt(txt_diachi.getText(), i, 5);
                copyFile(chon);
         
        }}
    }//GEN-LAST:event_bt_updateActionPerformed

    private void tb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tableMouseClicked
        int i = tb_table.getSelectedRow();
        if(i>=0){
              showDetail(i);
              chon =new File(System.getProperty("C:\\Users\\manhk\\OneDrive\\Desktop\\Ky3\\Ky3_block2\\Java3\\Asm\\ASM2\\src\\Anhdaidien") + model.getValueAt(i, 6));
        }
    }//GEN-LAST:event_tb_tableMouseClicked
    public void showDetail(int index) {
        txt_code.setText((String) model.getValueAt(index, 0));
        txt_name.setText((String) model.getValueAt(index, 1));
        txt_email.setText((String) model.getValueAt(index, 2));
        txt_sodienthoai.setText((String) model.getValueAt(index, 3));
        txt_diachi.setText((String) model.getValueAt(index, 5));
        if ("Nam".equals(model.getValueAt(index, 4))) {
            rdo_nam.setSelected(true);
        } else {
            rdo_nu.setSelected(true);
        }

        File f = new File(System.getProperty("C:\\Users\\manhk\\OneDrive\\Desktop\\Ky3\\Ky3_block2\\Java3\\Asm\\ASM2\\src\\Anhdaidien") + model.getValueAt(index, 6));
        showIcon(f);
    }

    public void showIcon(File f) {
        try {

            pic.setIcon(new ImageIcon(ImageIO.read(f).getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_DEFAULT)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean checkData() {
        if (txt_code.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập vào mã SV");
            txt_code.setBackground(Color.red);
        } else {
            txt_code.setBackground(Color.white);
        }
        if (txt_name.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập vào Họ tên");
            txt_name.setBackground(Color.red);
        } else {
            txt_name.setBackground(Color.white);
        }
        if (txt_email.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập vào Email");
            txt_email.setBackground(Color.red);
        } else {
            txt_email.setBackground(Color.white);
        }
        if (txt_sodienthoai.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập vào số điện thoại");
            txt_sodienthoai.setBackground(Color.red);
        } else {
            txt_sodienthoai.setBackground(Color.white);
        }
        if (txt_diachi.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập vào địa chỉ");
            txt_diachi.setBackground(Color.red);
            return false;
        } else {
            txt_diachi.setBackground(Color.white);
        }
        if (pic == null) {
            JOptionPane.showMessageDialog(this, "Phải có ảnh đại diện");
            pic.setBackground(Color.red);
            return false;
        } else {
            pic.setBackground(Color.white);
        }
        if (Pattern.compile("^[\\\\w-_\\\\.+]*[\\\\w-_\\\\.]\\\\\n" +
"      @([\\\\w]+\\\\.)+[\\\\w]+[\\\\w]").matcher(txt_email.getText()).matches() == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");
            txt_email.setBackground(Color.yellow);
            return false;
        } else {
            txt_email.setBackground(Color.white);
        }
        if (Pattern.compile("0[0-9]{9.}").matcher(txt_sodienthoai.getText()).matches() == false) {
            JOptionPane.showMessageDialog(this, "Sai định dạng email");
            txt_email.setBackground(Color.yellow);
            return false;
        } else {
            txt_email.setBackground(Color.white);
        }
        return true;
    }

    public int checkSTT(String masv) {
        int i = -1;
        for (int j = 0; j < model.getRowCount(); j++) {
            if (model.getValueAt(i, 0).equals(masv)) {
                i = j;
                break;
            }
        }
        return i;
    }

    public void copyFile(File f) {
        FileInputStream fis = null;
        FileOutputStream ois = null;
        try {
            fis = new FileInputStream(f);
            ois = new FileOutputStream(new File(System.getProperty("C:\\Users\\manhk\\OneDrive\\Desktop\\Ky3\\Ky3_block2\\Java3\\Asm\\ASM2\\src\\Anhdaidien")
                    + txt_code.getText() + f.getName().substring(f.getName().lastIndexOf(""))));
            byte[] buff = new byte[fis.available()];
            fis.read(buff);
            ois.write(buff);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                ois.close();
            } catch (Exception e) {
            }
        }
    }

    public void deleteFrom() {
        txt_code.setText("");
        txt_name.setText("");
        txt_diachi.setText("");
        txt_email.setText("");
        rdo_nam.setSelected(true);
        txt_sodienthoai.setText("");
        txt_name.setBackground(Color.white);
        txt_diachi.setBackground(Color.white);
        txt_email.setBackground(Color.white);
        txt_sodienthoai.setBackground(Color.white);
        txt_code.setBackground(Color.white);
    }

    public void deletePic(File f) {
        if (f.exists()) {
            f.delete();
        }
    }

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
            java.util.logging.Logger.getLogger(quanlysinhvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(quanlysinhvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(quanlysinhvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(quanlysinhvien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new quanlysinhvien().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_delete;
    private javax.swing.JButton bt_new;
    private javax.swing.JButton bt_save;
    private javax.swing.JButton bt_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel pic;
    private javax.swing.JRadioButton rdo_nam;
    private javax.swing.JRadioButton rdo_nu;
    private javax.swing.JTable tb_table;
    private javax.swing.JTextField txt_code;
    private javax.swing.JTextArea txt_diachi;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_sodienthoai;
    // End of variables declaration//GEN-END:variables
}
