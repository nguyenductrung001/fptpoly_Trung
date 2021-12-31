package Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * main
 */
public class Menu {

    public static String sel;
    public static ArrayList<Employee> listEmployee = new ArrayList<Employee>();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
    }

    static void showMenu() {
        do {
            System.out.println("\n\n-----+------------------------------MENU-------------------------------+-----");
            System.out.println("-----+-----------------------------------------------------------------+-----");
            System.out.println("     |  1   Nhập danh sách nhân viên từ bàn phím.                      |");
            System.out.println("     |  2   Xuất danh sách nhân viên ra màn hình.                      |");
            System.out.println("     |  3   Tìm và hiển thị nhân viên theo mã nhập từ bàn phím.        |");
            System.out.println("     |  4   Xóa nhân viên theo mã nhập từ bàn phím.                    |");
            System.out.println("     |  5   Cập nhật thông tin nhân viên theo mã nhập từ bàn phím.     |");
            System.out.println("     |  6   Tìm các nhân viên theo khoảng lương nhập từ bàn phím.      |");
            System.out.println("     |  7   Sắp xếp nhân viên theo họ và tên.                          |");
            System.out.println("     |  8   Sắp xếp nhân viên theo thu nhập.                           |");
            System.out.println("     |  9   Xuất 5 nhân viên có thu nhập cao nhất.                     |");
            System.out.println("     |  0   Thoát chương trình.                                        |");
            System.out.println("-----+-----------------------------------------------------------------+-----");
            System.out.print("An phim de chon chuc nang:");
            sel = s.nextLine().trim();
            if (!sel.isEmpty()) {
                switch (sel.charAt(0)) {
                    case '1':
                        ActionOne();
                        break;
                    case '2':
                        ActionTwo(true, listEmployee.size());
                        break;
                    case '3':
                        ActionThree();
                        break;
                    case '4':
                        actionFour();
                        break;
                    case '5':
                        actionFive();
                        break;
                    case '6':
                        actionSix();
                        break;
                    case '7':
                        actionSeven();
                        break;
                    case '8':
                        actionEight(true);
                        break;
                    case '9':
                        actionNine();
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
        for (int i = 0; i < listEmployee.size(); i++) {
            if (code.equalsIgnoreCase(listEmployee.get(i).getCode())) {
                return true;
            }
        }
        return false;
    }

    static void printTitle() {
        System.out.println(
                "+-----------+--------------------------------+---------------------------------------+-----------------------+");
        System.out.printf("|%8s%3s|%19s%13s|%22s%17s|%14s%9s|\n", "Ma NV", "", "Ho Ten", "", "Email", "", "Luong", "");
        System.out.println(
                "+-----------+--------------------------------+---------------------------------------+-----------------------+");
    }

    static void printItem(Employee employee) {
        System.out.printf("|%9s  |%27s     |%30s         |%18.3f d   |\n", employee.getCode().toUpperCase(),
                employee.getName().toUpperCase(), employee.getMail().toLowerCase(), employee.getSalary());
    }

    static void printBot() {

        System.out.println(
                "+-----------+--------------------------------+---------------------------------------+-----------------------+");
    }

    // chuc nang 1
    static void ActionOne() {
        int check;
        String inName = null, inCode = null, inMail = null;
        double inSalary = 0;
        Employee employee;
        do {
            System.out.println("Nhap ten nhan vien (nhap \"q\" de dung nhap)");
            try {
                check = 1;
                inName = s.nextLine().trim();
                if (!inName.equalsIgnoreCase("q")) {
                    System.out.print("Ma nhan vien:");
                    inCode = s.nextLine().trim();
                    System.out.print("Email:");
                    inMail = s.nextLine().trim();
                    System.out.print("Luong:");
                    inSalary = Double.parseDouble(s.nextLine());
                    if (isExitCode(inCode)) {
                        System.out.println("Da co nhan vien voi ma nay.");
                        check = 0;
                    }
                } else {
                    check = -1;
                }
            } catch (Exception e) {
                System.out.printf("Co loi xay ra: %s\n", e.getLocalizedMessage());
                check = 0;
            }
            switch (check) {
                case -1:
                    break;
                case 0:
                    System.out.println("Moi nhap lai thong tin");
                    break;
                default:
                    employee = new Employee(inCode, inName, inMail, inSalary);
                    listEmployee.add(employee);
                    break;
            }
        } while (check != -1);
    }

    // chuc nang 2
    static void ActionTwo(boolean stop, int Number) {
        if (listEmployee.isEmpty()) {
            System.out.println("Khong co nhan vien nao");
        } else {
            printTitle();
            for (int i = 0; i < Number; i++) {
                printItem(listEmployee.get(i));
            }
            printBot();
        }
        if (stop) {
            pauseApp();
        }
    }

    // chuc nang 3
    static void ActionThree() {
        System.out.println("Tim nhan vien theo ma");
        System.out.print("Nhap ma nhan vien: ");
        String searchCode = s.nextLine().trim();
        boolean hasCode = false;
        for (Employee employee : listEmployee) {
            if (searchCode.equalsIgnoreCase(employee.getCode())) {
                printTitle();
                printItem(employee);
                printBot();
                hasCode = true;
                break;
            }
        }
        if (!hasCode) {
            System.out.println("Khong tim thay");
        }
        pauseApp();
    }

    // chuc nang 4
    static void actionFour() {
        System.out.println("Xoa nhan vien theo ma");
        System.out.print("Nhap ma nhan vien: ");
        String searchCode = s.nextLine().trim();
        boolean hasDeleted = false;
        for (int i = listEmployee.size() - 1; i >= 0; i--) {
            if (listEmployee.get(i).getCode().equalsIgnoreCase(searchCode)) {
                listEmployee.remove(i);
                hasDeleted = true;
                break;
            }
        }
        if (hasDeleted) {
            System.out.println("Da xoa xong");
        } else {
            System.out.println("Khong tim thay nhan vien can xoa");
        }
        pauseApp();
    }

    // chuc nang 5
    static void actionFive() {
        System.out.println("Cap nhat nhan vien theo ma");
        boolean listEmpty = listEmployee.isEmpty();
        if (listEmpty) {
            System.out.println("Khong co nhan vien");
            pauseApp();
        } else {
            System.out.println("Danh sach nhan vien:");
            ActionTwo(false, listEmployee.size());
            String inName = null, inCode = null, inMail = null;
            double inSalary = 0;
            int member = -1;
            System.out.print("Nhap ma nhan vien can sua:");
            inCode = s.nextLine().trim();
            if (!inCode.isEmpty()) {
                for (int i = 0; i < listEmployee.size(); i++) {
                    if (listEmployee.get(i).getCode().equalsIgnoreCase(inCode)) {
                        member = i;
                        break;
                    }
                }
                if (member == -1) {
                    System.out.println("Khong tim thay nhan vien. moi thuc hien lai.");
                } else {
                    try {
                        System.out.println("Ho Va Ten:");
                        inName = s.nextLine().trim();
                        System.out.println("Ma nhan vien (Nhap ma nhan vien moi de thay doi. neu khong doi an Enter):");
                        inCode = s.nextLine().trim();
                        System.out.println("Email:");
                        inMail = s.nextLine().trim();
                        System.out.println("Luong:");
                        inSalary = Double.parseDouble(s.nextLine());
                        if (inCode.isEmpty() | listEmployee.get(member).getCode().equalsIgnoreCase(inCode)) {
                            inCode = listEmployee.get(member).getCode();
                            listEmployee.get(member).setCode(inCode);
                            listEmployee.get(member).setName(inName);
                            listEmployee.get(member).setMail(inMail);
                            listEmployee.get(member).setSalary(inSalary);
                        } else {
                            if (!isExitCode(inCode)) {
                                listEmployee.get(member).setCode(inCode);
                                listEmployee.get(member).setName(inName);
                                listEmployee.get(member).setMail(inMail);
                                listEmployee.get(member).setSalary(inSalary);
                            } else {
                                System.out.println("Da co nhan vien voi ma nay.");
                            }
                        }
                    } catch (Exception e) {
                        System.out.printf("Co loi xay ra: %s\n", e.getLocalizedMessage());
                        System.out.println("Moi thuc hien lai.");
                    }
                }
            } else {
                System.out.println("Chua nhap ma nhan vien. moi thuc hien lai.");
            }
            pauseApp();
        }
    }

    // chuc nang 6
    static void actionSix() {
        double minPointSalary = 1, maxPointSalary = 0;
        System.out.println("Tim nhan vien theo khoang luong");
        do {
            try {
                System.out.print("Moi nhap muc luong thap nhat: ");
                minPointSalary = Double.parseDouble(s.nextLine());
                System.out.print("Moi nhap muc luong cao nhat: ");
                maxPointSalary = Double.parseDouble(s.nextLine());
            } catch (Exception e) {
                System.out.println("Loi.");
            }
        } while (minPointSalary > maxPointSalary);
        System.out.printf("Danh sach nhan vien co luong nam trong khoang tu %.3f den %.3f la:\n", minPointSalary,
                maxPointSalary);
        printTitle();
        for (Employee employee : listEmployee) {
            if (employee.getSalary() >= minPointSalary & employee.getSalary() <= maxPointSalary) {
                printItem(employee);
            }
        }
        printBot();
        pauseApp();
    }

    // chuc nang 7
    static void actionSeven() {
        if (listEmployee.size() <= 0) {
            System.out.println("Chua co nhan vien nao");
        } else {
            Collections.sort(listEmployee, new Comparator<Employee>() {
                @Override
                public int compare(Employee e1, Employee e2) {
                    String firstName1 = e1.getName().substring(e1.getName().lastIndexOf(" ")).trim().toLowerCase();
                    String lastName1 = e1.getName().substring(0, e1.getName().lastIndexOf(" ")).trim().toLowerCase();
                    String firstName2 = e2.getName().substring(e2.getName().lastIndexOf(" ")).trim().toLowerCase();
                    String lastName2 = e2.getName().substring(0, e2.getName().lastIndexOf(" ")).trim().toLowerCase();
                    if (firstName1.compareTo(firstName2) > 0) {
                        return 1;
                    } else if (firstName1.compareTo(firstName2) == 0) {
                        if (lastName1.compareTo(lastName2) > 0) {
                            return 1;
                        } else if (lastName1.compareTo(lastName2) == 0) {
                            return 0;
                        } else {
                            return -1;
                        }
                    } else {
                        return -1;
                    }
                }
            });
            System.out.println("Danh sach nhan vien da sap xep theo ten:");
            ActionTwo(false, listEmployee.size());
        }
        pauseApp();
    }

    // chuc nang 8
    static void actionEight(boolean print) {
        if (listEmployee.size() <= 0) {
            System.out.println("Chua co nhan vien nao");
        } else {
            Collections.sort(listEmployee, new Comparator<Employee>() {
                @Override
                public int compare(Employee e1, Employee e2) {
                    double salary1 = e1.getSalary();
                    double salary2 = e2.getSalary();
                    if (salary1 < salary2) {
                        return 1;
                    } else if (salary1 == salary2) {
                        return 0;
                    } else {
                        return -1;
                    }
                }
            });
            if (print) {
                System.out.println("Danh sach nhan vien da sap xep theo muc thu nhap:");
                ActionTwo(false, listEmployee.size());
            }
        }
        pauseApp();
    }

    // chuc nang 9
    static void actionNine() {
        actionEight(false);
        System.out.println("5 nhan vien co thu nhap cao nhat:");
        if (listEmployee.size() > 5) {
            ActionTwo(false, 5);
        } else {
            ActionTwo(false, listEmployee.size());
        }
        pauseApp();
    }
}
