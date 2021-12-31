/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Uhelper.Helper;
import java.awt.Image;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class SuaSanPham extends javax.swing.JInternalFrame {

    /**
     * Creates new form SuaSanPham
     */
    Connection con;
    String namepic="";
    String xx="";
    public SuaSanPham(String maspchitiet) {
        initComponents();
        con=Helper.ketnoi("QLBH01");
        loadDanhmuc();
        loadData(maspchitiet);
        xx=maspchitiet;
        
    }
    public void upload(String hinh) {
        ImageIcon img = new ImageIcon("src\\Image\\" + hinh);
        Image im = img.getImage();
        ImageIcon icon = new ImageIcon(im.getScaledInstance(200, 200, im.SCALE_SMOOTH));
        lbl_anh.setIcon(icon);

    }
//    public void loadtt(String maspchitiet){
//        try{
//            String sql="select * from sanpham where maspchitet=?";
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setString(1,maspchitiet);
//            ResultSet rs= pstm.executeQuery();
//            while(rs.next()){
//                txt_masp.setText(rs.getString(1));
//                txt_maspct.setText(rs.getString(2));
//                txt_tensp.setText(rs.getString(3));
//                cbo_danhmuc.setSelectedItem(rs.getString(4));
//                txt_size.setText(rs.getString(5));
//                txt_mausac.setText(rs.getString(6));
//                txt_soluong.setText(rs.getString(7));
//                txt_dongia.setText( rs.getString(8));
//                txt_mota.setText(rs.getString(10));
//                upload(rs.getString(11));
//               
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this," lỗi load data "+e);
//        }
//    }
    public void loadhinh() {
        try {
            JFileChooser fc = new JFileChooser();
            int kq = fc.showOpenDialog(null);
            if (kq == JFileChooser.APPROVE_OPTION) {
                String filename = fc.getSelectedFile().getAbsolutePath();
                FileReader fr = new FileReader(filename);
                namepic = fc.getSelectedFile().getName();

                Path src = Paths.get(filename);
                Path dest = Paths.get("src\\Image\\" + namepic);
                Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING);
                upload(namepic);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi đọc file " );
        }
    }
    
    public void check(String maspchitiet){
        if (txt_masp.getText().equalsIgnoreCase("")) {
            lbl_loi_masp.setText("Mã sản phẩm không được để trống");
            return;
        }
        else{
            lbl_loi_masp.setText("");
        }
        if (txt_maspct.getText().equalsIgnoreCase("")) {
            lbl_loi_maspchitiet.setText("Mã sản phẩm chi tiết không được để trống");
            return;
        }
        else{
            lbl_loi_maspchitiet.setText("");
        }
        if (txt_soluong.getText().equalsIgnoreCase("")) {
            lbl_loi_soluong.setText("số lượng sản phẩm không được để trống");
            return;
        }
        else{
            lbl_loi_soluong.setText("");
        }
        String check = "^[0-9]+";
        boolean check2 = txt_soluong.getText().matches(check);
        if (check2 = false) {
            lbl_loi_soluong.setText("số lượng phải là số");
            return;
        }else{
            if(Integer.parseInt(txt_soluong.getText())<0){
                lbl_loi_soluong.setText("số lượng không được âm");
            }else{
                lbl_loi_soluong.setText("");
            }
                    
        }
        
        if (txt_size.getText().equalsIgnoreCase("")) {
            lbl_loi_size.setText("kích thước không được để trống");
            return;
        }
        else{
            lbl_loi_size.setText("");
        }
        if (txt_mausac.getText().equalsIgnoreCase("")) {
            lbl_loi_mausac.setText("Màu sắc không được để trống");
            return;
        }else{
            lbl_loi_mausac.setText("");
        }
        if (txt_mota.getText().equalsIgnoreCase("")) {
            lbl_loi_mota.setText("Mô tả sản phẩm không được để trống");
            return;
        }
        else{
            lbl_loi_mota.setText("");
        }
        if (txt_tensp.getText().equalsIgnoreCase("")) {
            lbl_loi_tensp.setText("Tên sản phẩm  không được để trống");
            return;
        }else{
            lbl_loi_tensp.setText("");
        }

        if (txt_dongia.getText().equalsIgnoreCase("")) {
            lbl_loi_dongia.setText("Đơn giá không được để trống");

        }else{
            lbl_loi_dongia.setText("");
        }
        try {

            double dongia = Double.parseDouble(txt_dongia.getText());
            if(dongia<0){
                lbl_loi_dongia.setText("đơn giá không được nhỏ hơn 0");
            }else{
                lbl_loi_dongia.setText("");
            }
        } catch (Exception e) {
            lbl_loi_dongia.setText("Đơn giá không đúng định dạng");
        }
        String loai="";
        if(rad_ao.isSelected()){
            loai="Áo";
        }else if(rad_quan.isSelected()){
            loai="Quần";
        }else{
            lbl_loi_loai.setText("Bạn chưa chọn loại");
            return;
        }
        String tendanhmuc=(String) cbo_danhmuc.getSelectedItem();
        String y=tendanhmuc.substring(0, 2);
        if(y.equalsIgnoreCase("Áo") ||y.equalsIgnoreCase("qu")){
            
        }else{
            lbl_loi_loai.setText("Loại và đơn giá không cùng kiểu");
            return;
        }
        try{
            String sql="update sanpham set tensp=?,tendanhmuc=?,kichco=?,mausac=?,"
                    + "soluong=?,dongia=?,mota=?,anh=? where maspchitiet=?";
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1,txt_tensp.getText());
            pstm.setString(2, (String) cbo_danhmuc.getSelectedItem());
            pstm.setString(3,txt_size.getText());
            pstm.setString(4,txt_mausac.getText());
            pstm.setString(5,txt_soluong.getText());
            pstm.setString(6,txt_dongia.getText());
            pstm.setString(7,txt_mota.getText());
            pstm.setString(8,namepic);
            pstm.setString(9,maspchitiet);
            int row= pstm.executeUpdate();
            if(row>0){
                JOptionPane.showMessageDialog(this, "sửa thành công");
            }
            pstm.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "sửa thất bại ");
        }
        
    }
//    public void update(String maspchitiet){
//        try{
//            String sql="update sanpham set tensanpham=?,tendanhmuc=?,kichco=?,mausac=?,"
//                    + "soluong=?,dongia=?,mota=?,anh=? where maspchitiet=?";
//            PreparedStatement pstm = con.prepareStatement(sql);
//            pstm.setString(1,txt_tensp.getText());
//            pstm.setString(2, (String) cbo_danhmuc.getSelectedItem());
//            pstm.setString(3,txt_size.getText());
//            pstm.setString(4,txt_mausac.getText());
//            pstm.setString(5,txt_soluong.getText());
//            pstm.setString(6,txt_dongia.getText());
//            pstm.setString(7,txt_mota.getText());
//            pstm.setString(8,namepic);
//            pstm.setString(9,maspchitiet);
//            int row= pstm.executeUpdate();
//            if(row>0){
//                JOptionPane.showMessageDialog(this, "sửa thành công");
//            }
//            pstm.close();
//            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(this, "sửa thất bại "+e);
//        }
//    }
    public void loadDanhmuc(){
        try{
            String sql="select * from danhmuc where not loai=N'Đã Xóa'";
            Statement stm = con.createStatement();
            ResultSet rs= stm.executeQuery(sql);
            while(rs.next()){
                
                cbo_danhmuc.addItem(rs.getString(1));
            }
        }catch(Exception e){
            
        }
    }
    public void loadData(String maspchitiet){
        try{
            String sql= "Select * from sanpham where maspchitiet=?";
            PreparedStatement pstm= con.prepareStatement(sql);
            pstm.setString(1,maspchitiet);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                txt_masp.setText(rs.getString(1));
                txt_maspct.setText(rs.getString(2));
                txt_tensp.setText(rs.getString(3));
                String x=rs.getString(4);
                String x2=x.substring(0, 1);
                if(x2.equalsIgnoreCase("A")){
                    rad_ao.setSelected(true);
                    
                }else{
                    rad_quan.setSelected(true);
                }
                cbo_danhmuc.setSelectedItem(x);
                txt_soluong.setText(rs.getString(7));
                txt_size.setText(rs.getString(5));
                txt_mausac.setText(rs.getString(6));
                txt_dongia.setText(rs.getString(8));
                txt_mota.setText(rs.getString(10));
                upload(rs.getString(11));
                int row= pstm.executeUpdate();
                rs.close();
                pstm.close();
                
            }
        }catch(Exception e){
            
        }
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        txt_maspct = new javax.swing.JTextField();
        txt_soluong = new javax.swing.JTextField();
        txt_size = new javax.swing.JTextField();
        rad_quan = new javax.swing.JRadioButton();
        rad_ao = new javax.swing.JRadioButton();
        cbo_danhmuc = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txt_mausac = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_masp = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_suasp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_submit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbl_loi_masp = new javax.swing.JLabel();
        lbl_loi_maspchitiet = new javax.swing.JLabel();
        lbl_loi_soluong = new javax.swing.JLabel();
        lbl_loi_size = new javax.swing.JLabel();
        lbl_loi_mausac = new javax.swing.JLabel();
        lbl_loi_mota = new javax.swing.JLabel();
        lbl_loi_tensp = new javax.swing.JLabel();
        lbl_dongia = new javax.swing.JLabel();
        txt_dongia = new javax.swing.JTextField();
        lbl_loi_dongia = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_tensp = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_mota = new javax.swing.JTextArea();
        lbl_loi_loai = new javax.swing.JLabel();
        lbl_anh = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        txt_maspct.setEnabled(false);

        buttonGroup1.add(rad_quan);
        rad_quan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rad_quan.setText("Quần");

        buttonGroup1.add(rad_ao);
        rad_ao.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rad_ao.setText("Áo");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("Màu sắc");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setText("Tên sản phẩm");

        txt_masp.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Ảnh");

        txt_suasp.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txt_suasp.setText("Sửa sản phẩm");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Mã sản phẩm");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Mã sp chi tiết");

        btn_submit.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btn_submit.setText("Xác nhận");
        btn_submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_submitActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setText("Loại");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Danh mục");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("Số lượng");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setText("Size");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setText("Mô tả");

        lbl_loi_masp.setForeground(new java.awt.Color(255, 0, 0));

        lbl_loi_maspchitiet.setForeground(new java.awt.Color(255, 0, 0));

        lbl_loi_soluong.setForeground(new java.awt.Color(255, 0, 0));

        lbl_loi_size.setForeground(new java.awt.Color(255, 0, 0));

        lbl_loi_mausac.setForeground(new java.awt.Color(255, 0, 0));

        lbl_loi_mota.setForeground(new java.awt.Color(255, 0, 0));

        lbl_loi_tensp.setForeground(new java.awt.Color(255, 0, 0));

        lbl_dongia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl_dongia.setText("Đơn giá");

        lbl_loi_dongia.setForeground(new java.awt.Color(255, 0, 0));

        txt_tensp.setColumns(20);
        txt_tensp.setRows(5);
        jScrollPane1.setViewportView(txt_tensp);

        txt_mota.setColumns(20);
        txt_mota.setRows(5);
        jScrollPane2.setViewportView(txt_mota);

        lbl_anh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_anhMouseClicked(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("Quay lại");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(lbl_loi_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 115, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel2))
                                                .addGap(39, 39, 39))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel6)))
                                                .addGap(38, 38, 38)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rad_quan)
                                                .addGap(41, 41, 41)
                                                .addComponent(rad_ao))
                                            .addComponent(lbl_loi_soluong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cbo_danhmuc, 0, 260, Short.MAX_VALUE)
                                            .addComponent(txt_maspct)
                                            .addComponent(txt_soluong)))
                                    .addComponent(txt_masp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_loi_masp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_loi_maspchitiet, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(59, 59, 59)))
                        .addGap(16, 16, 16))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(lbl_dongia))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_loi_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_size, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_loi_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_loi_size, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(txt_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(56, 56, 56)
                                    .addComponent(jLabel10)))
                            .addComponent(lbl_loi_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_suasp)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btn_submit)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lbl_loi_tensp, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)
                        .addComponent(lbl_anh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(111, 111, 111))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_suasp)
                    .addComponent(jLabel1))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_loi_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_loi_masp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_loi_maspchitiet, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_maspct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3))
                                        .addGap(18, 18, 18)
                                        .addComponent(lbl_loi_loai, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbl_loi_size, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txt_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_loi_mota, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_mausac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel9)
                                .addComponent(txt_masp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel10)))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_loi_tensp, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_anh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(11, 11, 11)
                                .addComponent(lbl_loi_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(rad_quan)
                                        .addComponent(rad_ao)))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbo_danhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(20, 20, 20)
                                .addComponent(lbl_loi_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txt_dongia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_dongia))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(btn_submit)
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbl_anhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_anhMouseClicked
        // TODO add your handling code here:
        loadhinh();
    }//GEN-LAST:event_lbl_anhMouseClicked

    private void btn_submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_submitActionPerformed
        // TODO add your handling code here:
        check(xx);
    }//GEN-LAST:event_btn_submitActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_submit;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbo_danhmuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel lbl_anh;
    private javax.swing.JLabel lbl_dongia;
    private javax.swing.JLabel lbl_loi_dongia;
    private javax.swing.JLabel lbl_loi_loai;
    private javax.swing.JLabel lbl_loi_masp;
    private javax.swing.JLabel lbl_loi_maspchitiet;
    private javax.swing.JLabel lbl_loi_mausac;
    private javax.swing.JLabel lbl_loi_mota;
    private javax.swing.JLabel lbl_loi_size;
    private javax.swing.JLabel lbl_loi_soluong;
    private javax.swing.JLabel lbl_loi_tensp;
    private javax.swing.JRadioButton rad_ao;
    private javax.swing.JRadioButton rad_quan;
    private javax.swing.JTextField txt_dongia;
    private javax.swing.JTextField txt_masp;
    private javax.swing.JTextField txt_maspct;
    private javax.swing.JTextField txt_mausac;
    private javax.swing.JTextArea txt_mota;
    private javax.swing.JTextField txt_size;
    private javax.swing.JTextField txt_soluong;
    private javax.swing.JLabel txt_suasp;
    private javax.swing.JTextArea txt_tensp;
    // End of variables declaration//GEN-END:variables
}
