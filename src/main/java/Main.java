import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Program Started");
        System.out.println("Enter Float Number");
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        // split by .
        String[] numbers = number.split("\\.");
        if (numbers[0].length() % 2 != 0) {
            numbers[0] = "0" + numbers[0];
        }
        String[] numbers1 = numbers[0].split("(?<=\\G.{2})");

        String[] numbers2;
        if (numbers.length > 1) {
            if (numbers[1].length() % 2 != 0) {
                numbers[1] = numbers[1] + "0";
            }
            numbers2 = numbers[1].split("(?<=\\G.{2})");
        } else {
            numbers2 = new String[1];
            numbers2[0] = "00";
        }

//        for (String num : numbers1) {
//            System.out.println(num);
//        }
//
//        System.out.println(".");
//        for (String num : numbers2) {
//            System.out.println(num);
//        }

        System.out.println(squareRoot(numbers1, numbers2));
        System.out.println("Program Ended");

    }

    public static String squareRoot(String[] str, String[] str2) {
        StringBuilder quotient = new StringBuilder();
        long divisor = 0;
        long dividend = 0;
        for (String s : str) {
            dividend = Integer.parseInt(dividend + s);
            long i = 9;
            while ((divisor * 10 + i) * i > dividend) {
                i--;
            }
            quotient.append(i);
            dividend = dividend - (divisor * 10 + i) * i;
            divisor = (divisor * 10 + i) + i;
        }
        quotient.append(".");
        for (int j = 0; j < 16; j++) {
            try {
                if (!str2[j].isEmpty())
                    dividend = Integer.parseInt(dividend + str2[j]);

            }catch (Exception e) {
                dividend = dividend * 100;
            }

            long i = 9;
            while ((divisor * 10 + i) * i > dividend) {
                i--;
            }
            quotient.append(i);
            dividend = dividend - (divisor * 10 + i) * i;
            divisor = (divisor * 10 + i) + i;
        }
        return quotient.toString();
    }
}
