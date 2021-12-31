/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.QLNV;

import GUI.Main;
import Helper.EmployerHelper;
import Helper.Helper;
import Model.Employee;
import static java.awt.Image.SCALE_DEFAULT;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ma-user
 */
public class ThemNV extends javax.swing.JInternalFrame {

    private Employee employee;
    File icon;
    private String state;

    /**
     * Creates new form ThemNV
     *
     * @param employee
     * @param state
     */
    public ThemNV(Employee employee, String state) {
        initComponents();
        this.employee = employee == null ? new Employee() : employee;
        this.state = state;
        initFeild();
        setClosable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDT = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDC = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtLuong = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cboCV = new javax.swing.JComboBox<>();
        jdtDate = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        lblIName = new javax.swing.JLabel();
        btnAnh = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.TOP));

        jLabel1.setText("Họ và tên:");

        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNameKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNameKeyTyped(evt);
            }
        });

        jLabel2.setText("Ngày Sinh");

        jLabel3.setText("Số ĐT");

        jLabel4.setText("Email");

        jLabel5.setText("Địa chỉ");

        jLabel6.setText("Lương");

        jLabel7.setText("Chức vụ");

        cboCV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lý", "Nhân Viên" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jdtDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cboCV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jdtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cboCV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addGap(18, 18, 18)
                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnHuy)
                    .addComponent(btnReset))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUser.setText("       ");

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblIName.setText("         ");

        btnAnh.setText("Chọn ảnh");
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblIName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAnh))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblUser)
                .addGap(18, 18, 18)
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAnh)
                .addGap(11, 11, 11)
                .addComponent(lblIName)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyTyped
        // TODO addEmployee your handling code here:

    }//GEN-LAST:event_txtNameKeyTyped

    private void txtNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNameKeyReleased
        // TODO addEmployee your handling code here:
        if (state.equalsIgnoreCase("T")) {
            lblUser.setText(autoUsername(Helper.removeAccent(txtName.getText())));
        }
    }//GEN-LAST:event_txtNameKeyReleased

    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
        // TODO addEmployee your handling code here:
        selPicture();
    }//GEN-LAST:event_btnAnhActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO addEmployee your handling code here:
        switch (state) {
            case "T":
                addEmployee();
                break;
            case "S":
                updateEmployee();
                break;
            case "X":
                state = "S";
                initFeild();
                break;
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO addEmployee your handling code here:
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        resetFeild();
    }//GEN-LAST:event_btnResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnh;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JComboBox<String> cboCV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private com.toedter.calendar.JDateChooser jdtDate;
    private javax.swing.JLabel lblIName;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblUser;
    private javax.swing.JTextField txtDC;
    private javax.swing.JTextField txtDT;
    private javax.swing.JTextField txtLuong;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables

    private void initFeild() {
        if (state.equalsIgnoreCase("T")) {
            jdtDate.setDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
            return;
        } else {
            txtName.setText(employee.getName());
            txtMail.setText(employee.getEmail());
            txtDC.setText(employee.getAddress());
            txtLuong.setText((new DecimalFormat("#.###").format(employee.getSalary())));
            txtDT.setText(employee.getPhone());
            lblUser.setText(employee.getUsername());
            lblIName.setText(employee.getPic());
            cboCV.setSelectedIndex(employee.getPosition().equalsIgnoreCase("AD") ? 0 : 1);
            try {
                lblIcon.setIcon(new ImageIcon(ImageIO.read(new File(System.getProperty("user.home") + "/Documents/QLDTIP/Images/" + employee.getPic())).getScaledInstance(180, 180, SCALE_DEFAULT)));
            } catch (IOException ex) {
            }
            jdtDate.setDate(employee.getDateofbirth());
        }
        btnReset.setVisible(false);
        btnThem.setText(state.equalsIgnoreCase("X") ? "Sửa" : (state.equalsIgnoreCase("T") ? "Thêm" : "Lưu"));
        txtDC.setEnabled(state.equalsIgnoreCase("X") == false);
        txtDT.setEnabled(state.equalsIgnoreCase("X") == false);
        txtLuong.setEnabled(state.equalsIgnoreCase("X") == false && Main.user.getPosition().equalsIgnoreCase("AD") == true);
        txtMail.setEnabled(state.equalsIgnoreCase("X") == false);
        txtName.setEnabled(state.equalsIgnoreCase("X") == false);
        jdtDate.setEnabled(state.equalsIgnoreCase("X") == false);
        btnAnh.setEnabled(state.equalsIgnoreCase("X") == false);
        cboCV.setEnabled(state.equalsIgnoreCase("X") == false && Main.user.getPosition().equalsIgnoreCase("AD") == true);
    }

    private void resetFeild() {
        txtName.setText("");
        txtMail.setText("");
        txtDC.setText("");
        txtLuong.setText("");
        txtDT.setText("");
        lblUser.setText("");
        lblIName.setText("");
        cboCV.setSelectedIndex(0);
        jdtDate.setDate(Date.from(LocalDate.now().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
    }

    private String autoUsername(String name) {
        try {
            name = name.trim().replaceAll("( )+", " ");
            ArrayList<String> hvt = new ArrayList<>();
            for (String s : name.split(" ")) {
                if (s.equalsIgnoreCase(" ") == false) {
                    hvt.add(s);
                }
            }
            String user = hvt.get(hvt.size() - 1);
            for (int i = 0; i < hvt.size() - 1; i++) {
                user = user.concat(String.valueOf(hvt.get(i).charAt(0)));
            }
            user = user.concat("ip").concat(String.format("%06d", EmployerHelper.getNumberImployee()));
            return user.toLowerCase();
        } catch (Exception e) {
            return "";
        }
    }

    private void selPicture() {
        JFileChooser jfc = new JFileChooser();
        jfc.setFileFilter(new FileNameExtensionFilter("hình ảnh(.jpg, .png)", "jpg", "png"));
        if (jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                icon = jfc.getSelectedFile();
                lblIcon.setIcon(new ImageIcon(ImageIO.read(icon).getScaledInstance(180, 180, SCALE_DEFAULT)));
                lblIName.setText(icon.getName());
            } catch (IOException ex) {
            }
        }
    }

    private boolean copyIcon(String code, File file) {
        boolean success = false;
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            File des = new File(System.getProperty("user.home") + "/Documents/QLDTIP/Images/" + code + file.getPath().substring(file.getPath().lastIndexOf(".")));
            os = new FileOutputStream(des);
            byte[] bs = new byte[is.available()];
            is.read(bs);
            os.write(bs);
            success = true;
        } catch (Exception e) {
            e.printStackTrace();
            return success;
        } finally {
            try {
                is.close();
                os.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return success;
    }

    private boolean checkInput() {
        if (txtName.getText().trim().length() < 5) {
            JOptionPane.showMessageDialog(this, "tên có độ dài ít nhất 5 ký tự");
            return false;
        }
        if (Pattern.compile("(^84|0)[0-9]{9}$").matcher(txtDT.getText().trim()).matches() == false) {
            JOptionPane.showMessageDialog(this, "số điện thoại không tồn tại");
            return false;
        }
        if (Pattern.compile("[a-z][a-z0-9]+@[a-z0-9]+(\\.[a-z0-9]+){1,2}").matcher(txtMail.getText().trim()).matches() == false) {
            JOptionPane.showMessageDialog(this, "Email sai định dạng");
            return false;
        }
        if (EmployerHelper.getEmployeeByPhone(txtDT.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Số điên thoại đã tồn tại");
            return false;
        }
        if (EmployerHelper.getEmployeeByEmail(txtMail.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Email đã tồn tại");
            return false;
        }
        try {
            if (Double.parseDouble(txtLuong.getText()) <= 0) {
                JOptionPane.showMessageDialog(this, "Lương phải lớn hơn 0");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lương phải là số");
            return false;
        }
        employee.setName(txtName.getText().trim());
        employee.setAddress(txtDC.getText());
        employee.setPasswd("12345");
        employee.setUsername(lblUser.getText());
        employee.setDateofbirth(jdtDate.getDate());
        employee.setPhone(txtDT.getText().trim());
        employee.setSalary(Double.parseDouble(txtLuong.getText()));
        employee.setEmail(txtMail.getText());
        employee.setPosition(cboCV.getSelectedIndex() == 0 ? "AD" : (cboCV.getSelectedIndex() == 1 ? "NV" : "DN"));
        employee.setPic(icon != null ? lblUser.getText() + icon.getPath().substring(icon.getPath().lastIndexOf(".")) : null);
        return true;
    }

    private void addEmployee() {
        if (checkInput()) {
            if (EmployerHelper.addEmployee(employee)) {
                if (icon != null) {
                    copyIcon(employee.getUsername(), icon);
                }
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                state = "X";
                initFeild();
            }
        }
    }

    private void updateEmployee() {
        if (checkInput()) {
            if (EmployerHelper.updateEmployee(employee)) {
                if (icon != null) {
                    copyIcon(employee.getUsername(), icon);
                }
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                state = "X";
                initFeild();
            }
        }
    }

}