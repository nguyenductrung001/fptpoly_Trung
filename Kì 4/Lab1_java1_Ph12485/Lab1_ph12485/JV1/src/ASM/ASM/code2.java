package ASM.ASM;

import java.io.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * main
 */
public class code2 {

    public static String sel;
    public static ArrayList<code1> listcn = new ArrayList<code1>();
    private static Scanner s = new Scanner(System.in);
    // private static Console c = System.console();

    public static void main(String[] args) {
        showMenu();
    }

    static void showMenu() {
        do {
            System.out.println("\n\n                         MENU");
            System.out.println("       Chức năng 1:   Nhập danh sách sinh vien từ bàn phím.");
            System.out.println("       Chức năng 2:   Xuất danh sách sinh vien ra màn hình.");
            System.out.println("       Chức năng 3:   Cập nhật thông tin sinh vien theo mã nhập từ bàn phím."); // sửa
            System.out.println("       Chức năng 4:   Xóa sinh vien theo mã nhập từ bàn phím."); // xóa
            System.out.println("       Chức năng 5:   Tìm các sinh vien theo mã từ bàn phím."); // tìm
            System.out.println("       Chức năng 6:   Xuất 5 Sinh viên có điểm trung bình từ 8.5 đến 9.0 trở lên."); // xuất
                                                                                                               // 8.5 >
                                                                                                               // 9
            System.out.println("       Chức năng 7:  Sắp xếp sinh vien theo họ và tên."); // tb <5
            System.out.println("       Chức năng 8:   Sắp xếp sinh vien theo thu nhập."); // học lại
            System.out.println("       Chức năng 9:   Xuất 5 sinh vien có thu nhập cao nhất."); // cao nhất all
            System.out.println("       chọn 0 dừng chương trình.");
            System.out.println("");
            System.out.print("An phim de chon chuc nang: ");
            sel = s.nextLine().trim();
            // sel = c.readLine().trim();
            if (!sel.isEmpty()) {
                switch (sel.charAt(0)) {
                    case '1':
                        mission1();
                        break;
                    case '2':
                        mission2(true, listcn.size());
                        break;
                    case '3':
                        mission3();
                        break;
                    case '4':
                        mission4();
                        break;
                    case '5':
                        mission5();
                        break;
                    case '6':
                        mission6();
                        break;
                    case '7':
                        mission7();
                        break;
                    case '8':
                        mission8();
                        break;
                    case '9':
                        mission9();
                        break;
                    case '0':
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Khong có chức năng này");
                        pauseApp();
                        break;
                }
            }

        } while (true);
    }

    public static void pauseApp() {
        System.out.print("\n\n\nNhan Enter de tiep tuc...");
        s.nextLine();
    }

    public static boolean isExitCode(String code) {
        for (int i = 0; i < listcn.size(); i++) {
            if (code.equalsIgnoreCase(listcn.get(i).getMasv())) {
                return true;
            }
        }
        return false;
    }

    static void printTitle() {
        System.out.printf("|%8s%3s|%19s%13s|%22s%17s|%14s%9s|%14s%9s|%14s%9s|%14s%9s|\n", "Ma NV", "", "Ho", "",
                "Ten Dem", "", "Ten", "", "Que quan", "", "Nam sinh", "", "DiemTB", "");
    }

    static void printItem(code1 code1) {
        System.out.printf("|%9s  |%27s     |%30s         |%18s      | %18s   |%18s        |%18.3f d   |\n",
                code1.getMasv().toUpperCase(), code1.getHo().toUpperCase(), code1.getTendem().toUpperCase(),
                code1.getTen().toUpperCase(), code1.getQuequan().toUpperCase(), code1.getNamsinh(), code1.getDiemTB());
    }

    static void mission1() {
        System.out.println("Chức năng 1:   Nhập danh sách sinh vien từ bàn phím.");
        int check;
        String inHo = null, inTendem = null, inTen = null, inQue = null, inNam = null, inMasv = null;
        double inDiemTB = 0;
        code1 code1;
        do {
            System.out.println("nhập \"stop\" de dung nhap");
            System.out.println("Nhap ten sinh vien: ");
            try {
                check = 1;
                inTen = s.nextLine().trim();
                if (!inTen.equalsIgnoreCase("stop")) {
                    System.out.print("Ma sinh vien: ");
                    inMasv = s.nextLine().trim();
                    System.out.print("nhap Ho: ");
                    inHo = s.nextLine().trim();
                    System.out.print("nhap ten dem: ");
                    inTendem = s.nextLine().trim();
                    System.out.print("nhap que quan: ");
                    inQue = s.nextLine().trim();
                    System.out.print("nhap nam sinh: ");
                    inNam = s.nextLine().trim();
                    System.out.print("nhap diem tb: ");
                    inDiemTB = Double.parseDouble(s.nextLine());
                    if (isExitCode(inMasv)) {
                        System.out.println("Da co sinh vien voi ma nay.");
                        check = 0;
                    }
                } else {
                    check = -1;
                }
            } catch (Exception e) {
                System.out.printf("Co loi xay ra, không biết bạn có nhập sai gì không?: %s\n", e.getLocalizedMessage());
                check = 0;
            }
            switch (check) {
                case -1:
                    break;
                case 0:
                    System.out.println("Moi nhap lai thong tin");
                    break;
                default:
                    code1 = new code1(inHo, inTendem, inTen, inQue, inNam, inMasv, inDiemTB);
                    listcn.add(code1);
                    break;
            }
        } while (check != -1);
    }

    static void mission2(boolean stop, int Number) {
        if (listcn.isEmpty()) {
            System.out.println("Khong co sinh vien nao");
            // pauseApp();
        } else {
            printTitle();
            for (int i = 0; i < Number; i++) {
                printItem(listcn.get(i));
            }
            // listEmployee.forEach((a) -> {
            // printItem(a);
            // // System.out.printf("|%9s |%27s |%30s |%18.3f d |\n",
            // // a.getCode().toUpperCase(),
            // // a.getName().toUpperCase(), a.getMail().toLowerCase(), a.getSalary());
            // });
        }
        if (stop) {
            pauseApp();
        }
    }

    static void mission3() {
        System.out.println("Chức năng 5:   Cập nhật thông tin sinh theo mã nhập từ bàn phím.");
        System.out.println("Cap nhat sinh theo ma");
        boolean listEmpty = listcn.isEmpty();
        if (listEmpty) {
            System.out.println("Khong co sinh vien");
            pauseApp();
        } else {
            System.out.println("Danh sach sinh vien:");
            mission2(false, listcn.size());
            String inHo = null, inTendem = null, inTen = null, inQue = null, inNam = null, inMasv = null;
            double inDiemTB = 0;
            int member = -1;
            System.out.print("Nhap ma sinh vien can sua:");
            inMasv = s.nextLine().trim();
            // inCode = c.readLine().trim();
            if (!inMasv.isEmpty()) {
                for (int i = 0; i < listcn.size(); i++) {
                    if (listcn.get(i).getMasv().equalsIgnoreCase(inMasv)) {
                        member = i;
                        break;
                    }
                }
                if (member == -1) {
                    System.out.println("Khong tim thay sinh vien. moi thuc hien lai.");
                } else {
                    try {
                        System.out.print("Ten sinh vien: ");
                        inTen = s.nextLine().trim();
                        System.out.print("nhap Ho: ");
                        inHo = s.nextLine().trim();
                        System.out.print("nhap ten dem: ");
                        inTendem = s.nextLine().trim();
                        // inName = c.readLine().trim();
                        System.out.println("Ma sinh vien (Nhap ma sinh vien moi de thay doi. neu khong doi an Enter):");
                        inMasv = s.nextLine().trim();
                        System.out.print("nhap que quan: ");
                        inQue = s.nextLine().trim();
                        System.out.print("nhap nam sinh: ");
                        inNam = s.nextLine().trim();
                        System.out.print("nhap diem tb: ");
                        inDiemTB = Double.parseDouble(s.nextLine());

                        if (inMasv.isEmpty() | listcn.get(member).getMasv().equalsIgnoreCase(inMasv)) {
                            inMasv = listcn.get(member).getMasv();
                            listcn.get(member).setHo(inHo);
                            listcn.get(member).setTendem(inTendem);
                            listcn.get(member).setTen(inTen);
                            listcn.get(member).setQuequan(inQue);
                            listcn.get(member).setNamsinh(inNam);                            
                            listcn.get(member).setMasv(inMasv);
                            listcn.get(member).setDiemTB(inDiemTB);
                        } else {
                            if (!isExitCode(inMasv)) {
                                listcn.get(member).setHo(inHo);
                                listcn.get(member).setTendem(inTendem);
                                listcn.get(member).setTen(inTen);
                                listcn.get(member).setQuequan(inQue);
                                listcn.get(member).setNamsinh(inNam);                            
                                listcn.get(member).setMasv(inMasv);
                                listcn.get(member).setDiemTB(inDiemTB);
                            } else {
                                System.out.println("Da co sinh vien voi ma nay.");
                            }
                        }
                    } catch (Exception e) {
                        System.out.printf("Co loi xay ra: %s\n", e.getLocalizedMessage());
                        System.out.println("Moi thuc hien lai.");
                    }
                }
            } else {
                System.out.println("Chua nhap ma sinh vien. moi thuc hien lai.");
            }
            pauseApp();
        }
    }

    static void mission4() {
        System.out.println("Chức năng 4:   Xóa sinh vien theo mã nhập từ bàn phím.");
        System.out.print("Nhập mã sinh vien cần xóa: ");
        String searchCode = s.nextLine().trim();
        boolean hasDeleted = false;
        for (int i = listcn.size() - 1; i >= 0; i--) {
            if (listcn.get(i).getMasv().equalsIgnoreCase(searchCode)) {
                listcn.remove(i);
                hasDeleted = true;
                break;
            }
        }
        if (hasDeleted) {
            System.out.println("Da xoa xong");
        } else {
            System.out.println("có vẻ mã nv đã được xóa rồi");
        }
        pauseApp();
    }

    static void mission5() {
        System.out.println("       Chức năng 5:   Tìm và hiển thị sinh vien theo mã nhập từ bàn phím.");
        System.out.println("Tim sinh vien theo ma");
        System.out.print("Nhap ma sinh vien: ");
        String searchCode = s.nextLine().trim();
        boolean hasCode = false;
        for (code1 code1 : listcn) {
            if (searchCode.equalsIgnoreCase(code1.getMasv())) {
                printTitle();
                printItem(code1);
                hasCode = true;
                break;
            }
        }
        if (!hasCode) {
            System.out.println("Mã sinh vien bạn nhập không tồn tại trên hệ thống");
        }
        pauseApp();
    }

    static void mission6() {
        System.out.println("Chức năng 6:   Xuất Sinh viên có điểm trung bình từ 8.5 đến 9.0 trở lên");
        double minPointSalary = 8.5;
        System.out.printf("Danh sach sinh vien la:\n");
        printTitle();
        for (code1 code1 : listcn) {
             mission2(false, 1);
            if (code1.getDiemTB() >= minPointSalary) {
                printItem(code1);
            }
        }
        pauseApp();
    }

    static void mission7() {
        System.out.println("Chức năng 7:  Sắp xếp sinh vien theo họ và tên.");
        if (listcn.size() <= 0) {
            System.out.println("Chua co sinh vien nao");
        } else {
            Collections.sort(listcn, new Comparator<code1>() {
                @Override
                public int compare(code1 e1, code1 e2) {
                    String lastName1 = e1.getHo().trim().toLowerCase();
                    String buffername1 = e1.getTendem().trim().toLowerCase();
                    String firstName1 = e1.getTen().trim().toLowerCase();
                    String lastName2 = e2.getHo().trim().toLowerCase();
                    String buffername2 = e2.getTendem().trim().toLowerCase();
                    String firstName2 = e2.getTen().trim().toLowerCase();
                    if (firstName1.compareTo(firstName2) > 0) {
                        return 1;
                    } else if (firstName1.compareTo(firstName2) == 0) {
                        if (lastName1.compareTo(lastName2) > 0) {
                            return 1;
                        } else if (lastName1.compareTo(lastName2) == 0) {
                            if (buffername1.compareTo(buffername2) > 0) {
                                return 1;
                            } else if (buffername1.compareTo(buffername2) == 0) {
                                return 0;
                            } else {
                                return -1;
                            }
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            });
            System.out.println("Danh sach sinh vien sap xep theo ten:");
            mission2(false, listcn.size());
        }
        pauseApp();
    }

    // chuc nang 8
    static void mission8() {
        System.out.println("Chức năng 8:   Xuất Sinh viên có điểm trung bình <5 bi trượt");
        double minPointSalary = 5;
        System.out.printf("Danh sach sinh vien la:\n");
        printTitle();
        for (code1 code1 : listcn) {
            if (code1.getDiemTB() < minPointSalary) {
                printItem(code1);
            }
        }
        pauseApp();
    }

    // chuc nang 9
    static void mission9() {
        mission8();
        System.out.println(" sinh vien co diem cao nhat:");
        if (listcn.size() > 1) {
            mission2(false, 1);
        } else {
            mission2(false, listcn.size());
        }
        pauseApp();
    }
}
