/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Code.code;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author manhk
 */
public class Frame extends javax.swing.JFrame {

    String[] header = {"Mã môn", "Tên môn", "Điểm"};
    DefaultTableModel model = new DefaultTableModel(header, 0);
    DefaultComboBoxModel<String> model_cb = new DefaultComboBoxModel<>();
    ArrayList<Code.code> lst = new ArrayList<>();
    int index = -1;

    /**
     * Creates new form Frame
     */
    public Frame() {
        initComponents();
        setLocationRelativeTo(null);
        tb_table.setModel(model);
        cb_com.setModel(model_cb);
        SQL.helper.putDataToCombo(model_cb);

        if (model_cb.getSize() > 0) {
            SQL.helper.putDataToTable(model, (String) model_cb.getSelectedItem());
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

        cb_com = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_ma = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_ten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_diem = new javax.swing.JTextField();
        bt_them = new javax.swing.JButton();
        bt_xoa = new javax.swing.JButton();
        bt_update = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cb_com.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_comItemStateChanged(evt);
            }
        });

        tb_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
        jScrollPane1.setViewportView(tb_table);

        jLabel1.setText("Mã MH");

        jLabel2.setText("Tên môn");

        jLabel3.setText("Điểm");

        bt_them.setText("ADD");
        bt_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_themActionPerformed(evt);
            }
        });

        bt_xoa.setText("Delete");
        bt_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_xoaActionPerformed(evt);
            }
        });

        bt_update.setText("Update");
        bt_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_diem, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(248, 248, 248)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bt_update)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(bt_them, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bt_xoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(194, 194, 194)
                        .addComponent(cb_com, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(cb_com, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(bt_them))
                    .addComponent(txt_ma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_xoa)
                    .addComponent(jLabel2)
                    .addComponent(txt_ten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_diem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_update))
                .addGap(110, 110, 110))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_themActionPerformed
        if (checkData()) {
            if (checkMH(txt_ma.getText()) == -1) {// đề no khong bao check ma mh thi ke me cu them vao thoi :D
                code x = new code(
                        txt_ma.getText(),
                        txt_ten.getText(),
                        (String) cb_com.getSelectedItem(),
                        Float.parseFloat(txt_diem.getText()));

                SQL.helper.insertDate(x);
//cai de nay no loi vcc ra. dang l cho mamh o  cai textfield beb duoi no pai la cai combo thi no moiínert chuan..... 
// kieu minh chi phai them diem thoi :D
// ke di :D neu lam the lau lam k du thoi gian dau thi co tí m ra ci đe vkl.. thoat nha...
                model.addRow(new Object[]{
                    x.ma,
                    x.ten,
                    x.diem
                });
                tb_table.setRowSelectionInterval(model.getRowCount() - 1, model.getRowCount() - 1);
            } else {
                JOptionPane.showMessageDialog(this, "hãy dùng update");
            }
        }
    }//GEN-LAST:event_bt_themActionPerformed

    private void cb_comItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_comItemStateChanged
        int Row = cb_com.getSelectedIndex();
        if (Row >= 0) {
            SQL.helper.putDataToTable(model, (String) model_cb.getSelectedItem());
        }
    }//GEN-LAST:event_cb_comItemStateChanged

    private void tb_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_tableMouseClicked
        int i = tb_table.getSelectedRow();
        if (i >= 0) {
            showDetail(i);
        }
    }//GEN-LAST:event_tb_tableMouseClicked

    private void bt_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_updateActionPerformed
        if (checkData()) {
//            int i = checkMH(txt_ma.getText());
//            if (i != tb_table.getSelectedRow()) {
//                JOptionPane.showMessageDialog(this, "không được thay đổi mã mh");
//                return;
//            }
            int i;
            if ((i = tb_table.getSelectedRow()) >= 0) {
                code x = new code();
                x.ma = (String) model.getValueAt(i, 0);
                x.masv = (String) model_cb.getElementAt(i);
                x.diem = Float.parseFloat(txt_diem.getText());
                SQL.helper.updateDate(x);
                model.setValueAt(txt_diem.getText(), i, 2);//dc r
            }
        }
    }//GEN-LAST:event_bt_updateActionPerformed

    private void bt_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_xoaActionPerformed
        int i = tb_table.getSelectedRow();
        if (i > 0 && JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa") == JOptionPane.YES_OPTION) {
            code c = new code();
            c.setMasv((String) cb_com.getSelectedItem());
            c.setMa((String) tb_table.getValueAt(index, 0));
            SQL.helper.deletePoint(c);
            SQL.helper.putDataToCombo(model_cb);
            if (model_cb.getSize() > 0) {
                SQL.helper.putDataToTable(model, (String) model_cb.getSelectedItem());
            }
        }

    }//GEN-LAST:event_bt_xoaActionPerformed
    public void showDetail(int index) {
        this.index = index;
        tb_table.setRowSelectionInterval(index, index);
        txt_ma.setText((String) tb_table.getValueAt(index, 0));
        txt_ten.setText((String) tb_table.getValueAt(index, 1));
        txt_diem.setText(String.valueOf(tb_table.getValueAt(index, 2)));
    }

    public boolean checkData() {
        String ma = txt_ma.getText();
        String ten = txt_ten.getText();
        String Diem = txt_diem.getText();
        if (ma.trim().equals("") || ten.trim().equals("") || Diem.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Thêm dữ liệu đầy đủ vào from");
            return false;
        }
        try {
            if (Float.parseFloat(txt_diem.getText()) < 0 || Float.parseFloat(txt_diem.getText()) > 10) {
                JOptionPane.showMessageDialog(this, "Diem phai tu 0 den 10");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "diem phai la so");
            return false;
        }
//else if (Pattern.compile("[0-9]{1,}").matcher(txt_diem.getText()).matches() == false) {
//            JOptionPane.showMessageDialog(this, "diem phai tu 0 -10");
//            return false;
//        }
        return true;

    }

    public int checkMH(String mamh) { // check trùng
        int i = -1;
        for (int j = 0; j < model.getRowCount(); j++) {
            if (model.getValueAt(j, 0).equals(mamh)) {
                i = j;
                break;
            }
        }
        return i;
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
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_them;
    private javax.swing.JButton bt_update;
    private javax.swing.JButton bt_xoa;
    private javax.swing.JComboBox<String> cb_com;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tb_table;
    private javax.swing.JTextField txt_diem;
    private javax.swing.JTextField txt_ma;
    private javax.swing.JTextField txt_ten;
    // End of variables declaration//GEN-END:variables
}
