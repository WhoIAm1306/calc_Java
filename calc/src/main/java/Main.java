import java.io.PrintStream;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char function;
    static int result;

    public static void main(String[] args) {
        System.out.println("Введите выражение:");
        String input = scanner.nextLine();
        try {
            String[] example = input.split(" ");
            if (example.length>3){
                System.out.println("*Exception* Формат математической " +
                        "операции не удовлетворяет заданию - " +
                        "два операнда и один оператор (+, -, /, *)");
                System.exit(1);
            }
            if (example[1].equals("+")) {
                function = '+';
            }
            if (example[1].equals("-")) {
                function = '-';
            }
            if (example[1].equals("*")) {
                function = '*';
            }
            if (example[1].equals("/")) {
                function = '/';
            }

            String[] romanNum = {"нет", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
            int func_test = 0;
            for (String element : romanNum) {
                if (example[0].equals(element)) {
                    func_test = 1;
                    break;
                }
            }
            if (func_test == 1) {
                int num1n = input_rim.romanToNum(example[0]);
                int num2n = input_rim.romanToNum(example[2]);
                if ((num1n < 1 || num1n > 10) || (num2n < 1 || num2n > 10)) {
                    System.out.println("*Exception* Введите числа от I до X в одинаково системе счисления");
                    System.exit(1);
                }
                String resultRoman = null;
                int result = calc.arithmetic_func(num1n, num2n, function);
                try {
                    resultRoman = input_rim.numToRoman(result);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("*Exception*В римской системе нет отрицательных чисел ");
                    System.exit(1);
                }
                if (Objects.equals(resultRoman, "нет")) {
                    System.out.println("*Exception*В римской системе нет нуля");
                    System.exit(1);
                }
                System.out.println(example[0] + " " + function + " " + example[2] + " = " + resultRoman);
            } else {
                int num1r;
                int num2r;
                try {
                    num1r = Integer.parseInt(example[0]);
                    num2r = Integer.parseInt(example[2]);

                    if ((num1r < 1 || num1r > 10) || (num2r < 1 || num2r > 10)) {
                        System.out.println("*Exception* Введите числа от 1 до 10");
                        System.exit(1);
                    }
                    int result = calc.arithmetic_func(num1r, num2r, function);
                    System.out.println(num1r + " " + function + " " + num2r + " = " + result);
                } catch (NumberFormatException e) {
                    System.out.println(" *Exception*Используйте одну систему счисления!");
                }
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("*Exception* Cтрока не является математической операцией");
        }
    }
}