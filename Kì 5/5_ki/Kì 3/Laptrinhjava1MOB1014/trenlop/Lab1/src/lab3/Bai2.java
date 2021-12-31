package lab3;

public class Bai2 {
    public static void main(String[] args) {
        System.out.println("Bang cuu chuong:");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("Bang %d:\n", i);
            for (int j = 1; j <= 10; j++) {

                System.out.printf("%2d x %2d = %d2\n", i, j, i * j);
            }
        }
    }
}