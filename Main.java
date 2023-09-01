import java.util.Scanner;
import java.lang.Exception;

import static java.lang.Integer.parseInt;
import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите пример");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String[] str = input.split(" ");
        if (str.length < 3) {
            throw new Exception("т.к. строка не является математической операцией");
        }
        if (str.length > 3) {
            for(int i = 0; i < str.length; i++) {
                parseInt(str[i]);
                i++;
            }
            for(int i = 0; i < str.length; i++) {
                if (i < str.length - 1) {
                    if (str[i+1].equals("/") || str[i+1].equals("*") ||
                            str[i+1].equals("+") || str[i+1].equals("-")) {
                        i++;
                    } else {
                        throw new Exception(" ");
                    }
                }
            }
            throw new Exception("т.к. формат математической операции не удовлетворяет заданию" +
                    " - два операнда и один оператор (+, -, /, *)");
        }
        int x = 0, y = 0;
        try {
            x = parseInt(str[0]);
            y = parseInt(str[2]);
        } catch (NumberFormatException e) {
            System.out.println(" ");
        }

        if (!(0 < x && x < 11)) {
            throw new Exception("Значение перврго оператора не соответствует условию");
        }
        if (!(0 < y && y < 11)) {
            throw  new Exception("Значение второго оператора не соответствует условию");
        }

        switch (str[1]) {
            case "+":
                return String.valueOf(x + y);
            case "-":
                return String.valueOf(x - y);
            case "/":
                return String.valueOf(round(x / y));
            case "*":
                return String.valueOf(x * y);
            default:
                throw new Exception("Введён не корректный оператор!");
        }
    }
}