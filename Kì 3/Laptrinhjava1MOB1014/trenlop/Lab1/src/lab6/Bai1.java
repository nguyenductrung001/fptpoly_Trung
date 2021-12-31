package lab6;

import java.util.Scanner;

/**
 * Bai1
 */
public class Bai1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("NHap ho ten:");
        String hoten = s.nextLine().toString().trim();
        String ho, dem, ten;
        ho = hoten.substring(0, hoten.indexOf(" ")).toUpperCase();
        dem = hoten.substring(hoten.indexOf(" ") + 1, hoten.lastIndexOf(" "));
        ten = hoten.substring(hoten.lastIndexOf(" ") + 1).toUpperCase();
        System.out.printf("Ho va ten: %s %s %s.\n", ho, dem, ten);
    }
}