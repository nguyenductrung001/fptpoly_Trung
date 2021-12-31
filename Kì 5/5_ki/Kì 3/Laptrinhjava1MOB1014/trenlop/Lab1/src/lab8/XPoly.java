package lab8;

public class XPoly {
    public static final double sum(double... x) {
        double sum = 0;
        for (double num : x) {
            sum += num;
        }
        return sum;
    }

    public static final double min(double... x) {
        double min = x[0];
        for (double num : x) {
            min = num < min ? num : min;
        }
        return min;
    }

    public static final double max(double... x) {
        double max = x[0];
        for (double num : x) {
            max = num > max ? num : max;
        }
        return max;
    }

    public static final String toUpperFirstChar(String s) {
        String[] words = s.split(" ");
        String val = "";
        for (String word : words) {
            word = word.length() > 0 ? word.toUpperCase().charAt(0) + word.substring(1) : "";
            System.out.println(word);
            val += (word + " ");
        }
        return val.substring(0, val.length() - 1);
    }

}