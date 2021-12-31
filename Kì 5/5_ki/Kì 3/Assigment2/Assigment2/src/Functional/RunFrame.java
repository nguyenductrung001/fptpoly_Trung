package Functional;

// import java.text.NumberFormat;
import Employee.Employee;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class RunFrame extends JFrame implements Runnable {

    public RunFrame() {
        this.openFile(true);
        initComponents();
        model = (DefaultTableModel) tblData.getModel();
        this.fillToTable();
        this.showDetail();
    }

    @SuppressWarnings("unchecked")
    // generate
    public void initComponents() {

        setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        // add even

        txtCode.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                txtCodeKeyTyped(e);
            }
        });
        txtName.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                txtNameKeyTyped(e);
            }
        });
        txtAge.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                txtAgeKeyTyped(e);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                txtEmailKeyTyped(e);
            }
        });
        txtSalary.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyTyped(java.awt.event.KeyEvent e) {
                txtSalaryKeyTyped(e);
            }
        });

        // design paneData
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnHomeActionPerformed(e);
            }
        });
        btnPrevious.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnPreviousActionPerformed(e);
            }
        });
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnNextActionPerformed(e);
            }
        });
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnEndActionPerformed(e);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 24));
        lblTitle.setForeground(new java.awt.Color(0, 0, 255));
        lblPosition.setForeground(new java.awt.Color(255, 0, 0));

        GroupLayout paneDataLayout = new GroupLayout(paneData);
        paneData.setLayout(paneDataLayout);

        paneDataLayout.setHorizontalGroup(paneDataLayout.createSequentialGroup().addGroup(paneDataLayout
                .createParallelGroup(Alignment.LEADING, false)
                .addComponent(lblCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addComponent(lblName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addComponent(lblAge, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addComponent(lblSalary, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE))
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(paneDataLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE)
                        .addComponent(txtCode, 350, 350, 350).addComponent(txtName, 350, 350, 350)
                        .addComponent(txtAge, 350, 350, 350).addComponent(txtEmail, 350, 350, 350)
                        .addComponent(txtSalary, 350, 350, 350)
                        .addGroup(paneDataLayout.createSequentialGroup().addComponent(btnHome)
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnPrevious)
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnNext)
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnEnd)
                                .addPreferredGap(ComponentPlacement.RELATED).addComponent(lblPosition)
                                .addPreferredGap(ComponentPlacement.RELATED)))
                .addGap(25));
        paneDataLayout.setVerticalGroup(paneDataLayout.createSequentialGroup().addContainerGap()
                .addComponent(lblTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addGap(14)
                .addGroup(paneDataLayout.createParallelGroup(Alignment.LEADING, false).addComponent(lblCode)
                        .addComponent(txtCode, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14)
                .addGroup(paneDataLayout.createParallelGroup(Alignment.LEADING, false).addComponent(lblName)
                        .addComponent(txtName, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14)
                .addGroup(paneDataLayout.createParallelGroup(Alignment.LEADING, false).addComponent(lblAge)
                        .addComponent(txtAge, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14)
                .addGroup(paneDataLayout.createParallelGroup(Alignment.LEADING, false).addComponent(lblEmail)
                        .addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14)
                .addGroup(paneDataLayout.createParallelGroup(Alignment.LEADING, false).addComponent(lblSalary)
                        .addComponent(txtSalary, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14)
                .addGroup(paneDataLayout.createParallelGroup(Alignment.BASELINE, false).addComponent(btnHome)
                        .addComponent(btnPrevious).addComponent(btnNext).addComponent(btnEnd).addComponent(lblPosition))
                .addContainerGap());

        // design paneButton
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnNewActionPerformed(e);
            }
        });
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnSaveActionPerformed(e);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnDeleteActionPerformed(e);
            }
        });
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnFindActionPerformed(e);
            }
        });
        btnOpen.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnOpenActionPerformed(e);
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                btnExitActionPerformed(e);
            }
        });

        GroupLayout panebButtonLayout = new GroupLayout(paneButton);
        paneButton.setLayout(panebButtonLayout);

        panebButtonLayout.setHorizontalGroup(panebButtonLayout.createSequentialGroup().addContainerGap()
                .addGroup(panebButtonLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(btnNew, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSave, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDelete, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFind, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExit, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap());
        panebButtonLayout.setVerticalGroup(panebButtonLayout.createSequentialGroup().addContainerGap()
                .addComponent(btnNew).addPreferredGap(ComponentPlacement.RELATED).addComponent(btnSave)
                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnDelete)
                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnFind)
                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnOpen)
                .addPreferredGap(ComponentPlacement.RELATED).addComponent(btnExit).addContainerGap());

        // design paneButtonParent
        lblTime.setForeground(new java.awt.Color(255, 0, 0));
        lblTime.setHorizontalAlignment(SwingConstants.CENTER);
        GroupLayout panebButtonParentLayout = new GroupLayout(paneButtonParent);
        paneButtonParent.setLayout(panebButtonParentLayout);
        panebButtonParentLayout.setHorizontalGroup(panebButtonParentLayout.createSequentialGroup()
                .addGroup(panebButtonParentLayout.createParallelGroup(Alignment.LEADING, false)
                        .addComponent(lblTime, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paneButton)));
        panebButtonParentLayout.setVerticalGroup(panebButtonParentLayout.createSequentialGroup().addGap(30)
                .addComponent(lblTime).addGap(15).addComponent(paneButton));

        // design paneTable
        model = new DefaultTableModel(new String[]{"Mã", "Họ Và Tên", "Tuổi", "Email", "Lương"}, 0);
        tblData = new JTable(model) {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; // Disallow the editing of any cell
            }
        };
        srcTableData = new JScrollPane(tblData);
        // srcTableData.setBorder(BorderFactory.createEmptyBorder());
        tblData.setPreferredScrollableViewportSize(
                new Dimension(paneData.getWidth() + paneButtonParent.getWidth() - 20, 100));
        tblData.setFillsViewportHeight(false);
        tblData.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JTableHeader header = tblData.getTableHeader();
        header.setReorderingAllowed(false);
        // header.setResizingAllowed(false);
        header.setBackground(new Color(222, 0, 222));
        tblData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDataMouseClicked(evt);
            }
        });

        GroupLayout paneTableLayout = new GroupLayout(paneTable);
        paneTable.setLayout(paneTableLayout);

        paneTableLayout.setHorizontalGroup(paneTableLayout.createSequentialGroup().addComponent(srcTableData,
                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        paneTableLayout.setVerticalGroup(paneTableLayout.createSequentialGroup().addComponent(srcTableData,
                GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        // // design root pane
        paneButton.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addComponent(paneData)
                                .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(paneButtonParent))
                        .addComponent(paneTable))
                .addContainerGap());
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(Alignment.BASELINE).addComponent(paneData)
                        .addComponent(paneButtonParent))
                .addPreferredGap(ComponentPlacement.UNRELATED).addComponent(paneTable).addContainerGap());

        pack();
    }

    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        RunFrame frame = new RunFrame();
        frame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                frame.saveFile(true);
            }
        });
        Dimension sizeDimension = frame.getContentPane().getPreferredSize();
        sizeDimension.setSize(sizeDimension.getWidth() + 17, sizeDimension.getHeight() + 36);
        frame.setLocation((int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() - frame.getWidth()) / 2,
                (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() - frame.getHeight()) / 2);
        frame.setResizable(false);
        // frame.setSize(sizeDimension);
        frame.setVisible(true);
        frame.showDetail();
        Thread clock = new Thread() {
            @Override
            public void run() {
                while (true) {
                    frame.showTime();
                    try {

                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        };
        clock.start();
    }

    // *
    // *
    // *
    // *
    // *
    // declare varS
    // *
    // *
    // *
    // *
    private JPanel paneData = new JPanel();
    private JPanel paneButton = new JPanel();
    private JPanel paneButtonParent = new JPanel();
    private JPanel paneTable = new JPanel();

    private JLabel lblTitle = new JLabel("QUẢN LÝ NHÂN VIÊN");
    private JLabel lblCode = new JLabel("MÃ NHÂN VIÊN");
    private JLabel lblName = new JLabel("HỌ VÀ TÊN");
    private JLabel lblAge = new JLabel("TUỔI");
    private JLabel lblEmail = new JLabel("EMAIL");
    private JLabel lblSalary = new JLabel("LƯƠNG");
    private JLabel lblPosition = new JLabel("Record: 0 of 0");
    private JLabel lblTime = new JLabel(".................");

    private JTextField txtCode = new JTextField(20);
    private JTextField txtName = new JTextField(20);
    private JTextField txtAge = new JTextField(20);
    private JTextField txtEmail = new JTextField(20);
    private JTextField txtSalary = new JTextField(20);

    private JButton btnHome = new JButton("|<");
    private JButton btnEnd = new JButton(">|");
    private JButton btnPrevious = new JButton("<<");
    private JButton btnNext = new JButton(">>");
    private JButton btnNew = new JButton("New");
    private JButton btnSave = new JButton("Save");
    private JButton btnDelete = new JButton("Delete");
    private JButton btnFind = new JButton("Find");
    private JButton btnOpen = new JButton("Open");
    private JButton btnExit = new JButton("Exit");

    private JTable tblData;
    private JScrollPane srcTableData;
    private DefaultTableModel model;

    //begin of user variables declaration     
    private ArrayList<Employee> listEmployees = new ArrayList<>();
    private int index = -1;
//    private File openedFile;
    private final File tmp = new File(System.getProperty("user.home").concat("//Documents//JavaDATA/Assignment//temp.bin"));
    private boolean datChanged = false;
    //end of user variables declaration   

    // *
    // *
    // *
    // *
    // *
    // design action event
    // *
    // *
    // *
    // * text input check
    private void txtCodeKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (!Pattern.compile("[A-Za-z0-9]").matcher(String.valueOf(evt.getKeyChar())).matches()) {
            evt.consume();
        }
    }

    private void txtNameKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (!Pattern.compile(
                "[ aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ]")
                .matcher(String.valueOf(evt.getKeyChar())).matches()) {
            evt.consume();
        }
    }

    private void txtAgeKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (!Pattern.compile("[0-9]").matcher(String.valueOf(evt.getKeyChar())).matches()) {
            evt.consume();
        }
    }

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        // if
        // (!Pattern.compile("[a-z.@0-9_]").matcher(String.valueOf(evt.getKeyChar())).matches())
        // {
        // evt.consume();
        // }
    }

    private void txtSalaryKeyTyped(java.awt.event.KeyEvent evt) {
        // TODO add your handling code here:
        if (!Pattern.compile("[0-9.]").matcher(String.valueOf(evt.getKeyChar())).matches()) {
            evt.consume();
        }
    }
    // *
    // *
    // *
    // *
    // *
    // design action event
    // *
    // *
    // *
    // * button change and table click

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.index = 0;
        this.showDetail();
    }

    private void btnPreviousActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (this.index > 0) {
            this.index--;
            this.showDetail();
        }
    }

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (this.index < listEmployees.size() - 1) {
            this.index++;
            this.showDetail();
        }
    }

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.index = listEmployees.size() - 1;
        this.showDetail();
    }

    private void tblDataMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        this.index = tblData.getSelectedRow();
        this.showDetail();
    }

    // *
    // *
    // *
    // *
    // *
    // design action event
    // *
    // *
    // *
    // * button menu clicked
    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.index = -1;
        this.clearForm();
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (index == -1) {
            this.addEmployee();
        } else {
            this.updateEmployee();
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.removeEmployee();
        this.clearForm();
        this.index = -1;
        this.saveFile(false);
    }

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.findEmployee();
        this.showDetail();
    }

    private void btnOpenActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.openFile(false);
        this.fillToTable();
        if (listEmployees.size() > 0) {
            this.index = 0;
            this.showDetail();
        } else {
            this.index = -1;
            this.clearForm();
        }
    }

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        this.saveFile(true);
    }

    // *
    // *
    // *
    // *
    // *
    // design fucntion
    private void clearForm() //xóa trắng form nhập liệu
    {
        this.txtCode.setText("");
        this.txtName.setText("");
        this.txtAge.setText("");
        this.txtEmail.setText("");
        this.txtSalary.setText("");
        this.lblPosition.setText("...........");
    }

    private void fillToTable() //đổ List<Employee> lên bảng
    {
        DecimalFormat df = new DecimalFormat("#");
        this.model.getDataVector().removeAllElements();
        if (listEmployees.size() > 0) {
            for (Employee employee : listEmployees) {
                model.addRow(new Object[]{employee.getCode(), employee.getName(), employee.getAge(), employee.getEmail(), df.format(employee.getSalary())});
            }
        }
        model.fireTableDataChanged();
    }

    private void showDetail() //hiển thị nhân viên tại index lên form, hiển thị thông tin trạng thái
    {
        if (index == -1) {
            this.clearForm();
        } else {
            DecimalFormat df = new DecimalFormat("#");
            this.txtCode.setText(listEmployees.get(this.index).getCode());
            this.txtName.setText(listEmployees.get(this.index).getName());
            this.txtAge.setText(String.valueOf(listEmployees.get(this.index).getAge()));
            this.txtEmail.setText(listEmployees.get(this.index).getEmail());
            this.txtSalary.setText(df.format(listEmployees.get(this.index).getSalary()));
            this.lblPosition.setText("Record: ".concat(String.valueOf(this.index + 1)).concat(" of ").concat(String.valueOf(this.listEmployees.size())));
            this.tblData.setRowSelectionInterval(this.index, this.index);
        }
    }

    private void openFile(boolean isStart) //đọc dữ liệu từ file vào List<Employee>
    {
        if (isStart) {
            if (this.tmp.exists()) {
                this.listEmployees = this.readFromFile(this.tmp.getAbsolutePath());
                if (listEmployees.size() > 0) {
                    this.index = 0;
                }
            } else {
            }
        } else {
            JFileChooser fc = this.chooseAFile(true);
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File openedFile = fc.getSelectedFile();
                ArrayList<Employee> listInFile = readFromFile(openedFile.getAbsolutePath());
                if (listEmployees.size() > 0) {
                    int sel = JOptionPane.showOptionDialog(this, "Đã tồn tại dữ liệu trên bảng.".concat(
                            "\nXin mời chọn:\n1. Chỉ để lại dữ liệu trên file.\n2. Chỉ để lại dữ liệu trên bảng.")
                            .concat("\n3. Thêm dữ liệu trên file vào bảng, nếu trùng code giữ lại dữ liệu trên file.")
                            .concat("\n4. Thêm dữ liệu trên file vào bảng, nếu trùng code giữ lại dữ liệu trên bảng.")
                            .concat("\n5. Hủy mở file"), "Xác nhận mở file", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, new String[]{"1", "2", "3", "4", "5"}, null);
                    switch (sel) {
                        case 0:
                            this.listEmployees = listInFile;
                            this.saveFile(false);
                            break;
                        case 2:
                            for (Employee employee : listInFile) {
                                int i = this.existedCode(employee.getCode(), this.listEmployees);
                                if (i != -1) {
                                    this.listEmployees.remove(i);
                                }
                            }
                            this.listEmployees.addAll(listInFile);
                            this.saveFile(false);
                            this.datChanged = true;
                            break;
                        case 3:
                            for (Employee employee : this.listEmployees) {
                                int i = this.existedCode(employee.getCode(), listInFile);
                                if (i != -1) {
                                    listInFile.remove(i);
                                }
                            }
                            this.listEmployees.addAll(listInFile);
                            this.saveFile(false);
                            this.datChanged = true;
                            break;
                    }
                } else {
                    this.listEmployees = listInFile;
                    this.saveFile(false);
                }
            }
        }
    }

    private void saveFile(boolean isExit) ///lưu List<Employee> vào file
    {
        if (!isExit) {
            this.writeToFile(tmp.getAbsolutePath());
        } else {
            if (this.datChanged || this.tmp.exists()) {
                JFileChooser fc = this.chooseAFile(true);
//                int sel = ;
                if (JOptionPane.showOptionDialog(this, "Dữ liệu đã thay đổi. lưu vào file?", "Thoát",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Yes", "No"}, null) == 0) {
                    while (true) {
                        int returnVal = fc.showSaveDialog(this);
                        if (returnVal == JFileChooser.APPROVE_OPTION) {
                            File openedFile = fc.getSelectedFile();
                            if (openedFile.exists()) {
                                if (JOptionPane.showConfirmDialog(this, "File đã tồn tại ghi đè lên file gốc?", "Ghi đè", JOptionPane.YES_NO_OPTION)
                                        == JOptionPane.OK_OPTION) {
                                    this.writeToFile(openedFile.getAbsolutePath());
                                    break;
                                } else {
                                    continue;
                                }
                            } else {
                                this.writeToFile(openedFile.getAbsolutePath());
                                break;
                            }
                        } else {
                            return;
                        }
                    }
                    try {
                        this.tmp.delete();
                    } catch (Exception e) {
                    }
                }
            }
            System.exit(0);
        }
    }

    private JFileChooser chooseAFile(boolean isOpen) {
        JFileChooser fc = new JFileChooser(System.getProperty("user.home").concat("//Documents//JavaDATA//Assignment"));
        fc.setFileFilter(new FileNameExtensionFilter("Binary File (.bin)", "bin"));
        fc.setSelectedFile(new File("Data.bin"));
        if (isOpen) {
            fc.setDialogTitle("Chọn File");
        } else {
            fc.setDialogTitle("Chọn nơi lưu File");
        }
        return fc;
    }

    private void addEmployee() //tạo một nhân viên mới và bổ sung vào List<>
    {
        if (this.checkInput()) {
            int i = this.existedCode(this.txtCode.getText().trim(), this.listEmployees);
            if (i == -1) {
                this.listEmployees.add(new Employee(this.txtCode.getText().trim(), this.txtName.getText().trim(),
                        Integer.parseInt(this.txtAge.getText().trim()), this.txtEmail.getText().trim(),
                        Double.parseDouble(this.txtSalary.getText().trim())));
                this.index = this.listEmployees.size() - 1;
                this.datChanged = true;
                this.saveFile(false);
                this.fillToTable();
                this.showDetail();
            } else {
                if (JOptionPane.showOptionDialog(this, "Đã có nhân viên với mã này. Không thể thêm mới.\nCó muốn update lại thông tin của nhân viên với mã này không?", "",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Yes", "No"}, null) == 0) {
                    this.index = i;
                    this.checkThenUpdateEmployee(i);
                }
            }
        }
    }

    private void updateEmployee() //cập nhật lại thông tin trên form vào nhân viên tại index
    {
        if (this.checkInput()) {
            int i = this.existedCode(this.txtCode.getText().trim(), this.listEmployees);
            if (i != -1) {
                this.checkThenUpdateEmployee(i);
            } else {
                this.listEmployees.set(this.index, new Employee(this.txtCode.getText().trim(), this.txtName.getText().trim(),
                        Integer.parseInt(this.txtAge.getText().trim()), this.txtEmail.getText().trim(),
                        Double.parseDouble(this.txtSalary.getText().trim())));
                JOptionPane.showMessageDialog(this, "Xong", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
                this.datChanged = true;
                this.saveFile(false);
                this.fillToTable();
                this.showDetail();
            }
        }
    }

    private void checkThenUpdateEmployee(int exitstCode) {
        if (this.index != exitstCode) {
            JOptionPane.showMessageDialog(this, "Đã tồn tại mã nhân viên này. Không thể đổi sang mã này", "Lỗi", JOptionPane.ERROR_MESSAGE);
        } else {
            if (!this.txtCode.getText().trim().equalsIgnoreCase(this.listEmployees.get(exitstCode).getCode())
                    || !this.txtName.getText().trim().equalsIgnoreCase(this.listEmployees.get(exitstCode).getName())
                    || Integer.parseInt(this.txtAge.getText().trim()) != (this.listEmployees.get(exitstCode).getAge())
                    || !this.txtEmail.getText().trim().equalsIgnoreCase(this.listEmployees.get(exitstCode).getEmail())
                    || Double.parseDouble(this.txtSalary.getText().trim()) != this.listEmployees.get(exitstCode).getSalary()) {
                if (JOptionPane.showOptionDialog(this, "Xác nhận thay đổi? Không thể hoàn tác", "",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Yes", "No"}, null) == 0) {
                    this.listEmployees.set(exitstCode, new Employee(this.txtCode.getText().trim(), this.txtName.getText().trim(),
                            Integer.parseInt(this.txtAge.getText().trim()), this.txtEmail.getText().trim(),
                            Double.parseDouble(this.txtSalary.getText().trim())));
                    JOptionPane.showMessageDialog(this, "Xong", "Thành Công", JOptionPane.INFORMATION_MESSAGE);
                    this.datChanged = true;
                    this.saveFile(false);
                    this.fillToTable();
                    this.showDetail();
                }
            }
        }
    }

    private void removeEmployee() //xóa nhân viên tại index khỏi List<>
    {
        if (this.index != -1) {
            if (JOptionPane.showOptionDialog(this, "Xác nhận xóa. không thể thay đổi", "", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, null, new String[]{"Yes", "No"}, null) == 0) {
                this.listEmployees.remove(this.index);
                this.datChanged = true;
                this.fillToTable();
            }
        }
    }

    private void findEmployee() //tìm vị trí của nhân viên có mã nhập vào giao diện và cập nhật index
    {
        boolean found = false;
        String inputCode = JOptionPane.showInputDialog(this, "Nhập vào code tìm kiếm:");
        if (inputCode != null && !inputCode.trim().isEmpty()) {
            for (Employee employee : this.listEmployees) {
                if (inputCode.equalsIgnoreCase(employee.getCode())) {
                    this.index = this.listEmployees.indexOf(employee);
                    found = true;
                    break;
                }
            }
            if (found) {
                this.showDetail();
            } else {
                JOptionPane.showMessageDialog(this, "Không tìm thấy", "Kết Quả", JOptionPane.INFORMATION_MESSAGE);
                this.clearForm();
                this.index = -1;
            }
        }
    }

    private boolean checkInput() {
        if (this.txtCode.getText().trim().isEmpty() || this.txtName.getText().trim().isEmpty()
                || this.txtAge.getText().trim().isEmpty() || this.txtEmail.getText().trim().isEmpty()
                || this.txtSalary.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Phải nhập đầy đủ form", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (Integer.parseInt(this.txtAge.getText().trim()) < 16 || Integer.parseInt(this.txtAge.getText().trim()) > 55) {
            JOptionPane.showMessageDialog(this, "Nhân viên chỉ nhận từ 16 - 55 tuổi", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (!Pattern.compile("^[a-z]([a-z0-9])+([\\._][a-z0-9]+){0,}@([a-z]{2,}[\\.]){1,2}[a-z]{2,}$")
                .matcher(this.txtEmail.getText().trim()).matches()) {
            JOptionPane.showMessageDialog(this, "Mail không đúng định dạng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (Double.parseDouble(this.txtSalary.getText().trim()) <= 5000000) {
            JOptionPane.showMessageDialog(this, "Lương phải trên 5 triệu đồng", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private int existedCode(String code, ArrayList<Employee> listEmployees) {
        for (Employee employee : listEmployees) {
            if (code.equalsIgnoreCase(employee.getCode())) {
                return listEmployees.indexOf(employee);
            }
        }
        return -1;
    }

    private void writeToFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(this.listEmployees);
            oos.close();
            fos.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có Lỗi Xảy Ra\n".concat(e.getMessage()), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    private ArrayList<Employee> readFromFile(String path) {
        ArrayList<Employee> readedList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            readedList = (ArrayList<Employee>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Có Lỗi Xảy Ra\n".concat(e.getMessage()), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
        return readedList;
    }

    public void showTime() {
        // lblTime.setText(LocalTime.now().toString());
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        lblTime.setText(sdf.format(new Date()));
        // lblTime.setText(String.valueOf(LocalTime.now().getHour()).concat(":")
        // .concat(String.valueOf(LocalTime.now().getMinute())));
    }

    // *
    // *
    // *
    // *
    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
        // Tools | Templates.
    }
}
