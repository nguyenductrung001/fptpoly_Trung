/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import Model.HocSinh_1;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Truong Dep Zai
 */
public class lt6_c2 extends javax.swing.JFrame {

    Connection cnn;
    DefaultComboBoxModel<HocSinh_1> model_combo;

    public lt6_c2() {
        initComponents();
        setLocationRelativeTo(null);
        model_combo = (DefaultComboBoxModel) cbo_MaSV.getModel();
        cnn = helper.helper.ketnoi("lab6");
        if (cnn != null) {
            JOptionPane.showMessageDialog(this, " kết nối thành công");
            LoadDataToComboBox();
        } else {
            JOptionPane.showMessageDialog(this, "Lỗi kết nối");
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

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        cbo_MaSV = new javax.swing.JComboBox<>();
        lbl_HoTen = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MaSV");

        cbo_MaSV.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_MaSVItemStateChanged(evt);
            }
        });

        lbl_HoTen.setText("jLabel4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(cbo_MaSV, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(lbl_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbo_MaSV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(258, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_MaSVItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_MaSVItemStateChanged
        // TODO add your handling code here:
        try {
            HocSinh_1 hs = (HocSinh_1) cbo_MaSV.getSelectedItem();
            lbl_HoTen.setText(hs.getHoTen());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load combo");
        }
    }//GEN-LAST:event_cbo_MaSVItemStateChanged

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
            java.util.logging.Logger.getLogger(lt6_c2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(lt6_c2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(lt6_c2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(lt6_c2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new lt6_c2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_MaSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbl_HoTen;
    // End of variables declaration//GEN-END:variables

    private void LoadDataToComboBox() {
        try {
            String sql = "select*\n"
                    + "from SinhVien";
            Statement stm = cnn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                String masv = rs.getString(1);
                String hoten = rs.getString(2);
                int tuoi = rs.getInt(3);
                String nganh = rs.getString(4);
                model_combo.addElement(new HocSinh_1(masv, hoten, nganh, tuoi));
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi load data");
        }
    }
}
