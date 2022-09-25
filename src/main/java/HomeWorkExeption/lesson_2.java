package HomeWorkExeption;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 1. Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное
 * значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно
 * запросить у пользователя ввод данных.
 * <p>
 * 2. Если необходимо, исправьте данный код
 * <p>
 * 3. Дан следующий код, исправьте его там, где требуется
 * <p>
 * 4. Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно
 * показаться сообщение, что пустые строки вводить нельзя.
 */

public class lesson_2 {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // задание 1
        System.out.println(getFloatNumber());

        // задание 2
        int d = 1;
        double[] intArray = {1.2, 35.5, 41.2, 4.2};
        if (d == 0) {
            throw new RuntimeException("На ноль делить нельзя");
        }
        double catchedRes1 = intArray[3] / (double) d;
        System.out.println("catchedRes1 = " + catchedRes1);

        // задание 3
        int a = 90;
        int b = 3;
        if (b == 0) {
            throw new RuntimeException("На ноль делить нельзя");
        } else {
            System.out.println(a / b);
        }
        printSum(23, 234);
        int[] abc = {1, 2};
        int index = 3;
        if (index > abc.length - 1) {
            throw new RuntimeException("В массиве нет такого значения");
        }
        abc[index] = 9;

        // задание 4
        input();
    }

    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }

    private static float getFloatNumber() {

        while (true) {
            System.out.println("Введите дробное число: ");
            String number = scanner.nextLine();
            if (Pattern.matches("^[\\+\\-]?[0-9]+[\\.][0-9]+$", number)) {
                return Float.parseFloat(number);
            }
        }
    }

    private static void input() {
        while (true) {
            System.out.println("Введите строку: ");
            String str = scanner.nextLine();
            if (str.isBlank()) {
                System.out.println("Строка не может быть пустой\n");
            } else {
                System.out.println(str);
                break;
            }
        }
    }
}