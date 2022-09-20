package HomeWorkExeption;

import java.util.Arrays;

/**
 * 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 * <p>
 * 2.Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
 * <p>
 * 3.Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив, каждый
 * элемент которого равен разности элементов двух входящих массивов в той же ячейке. Если длины массивов не равны,
 * необходимо как-то оповестить пользователя.
 * <p>
 * 4. Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
 * каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке. Если длины массивов
 * не равны, необходимо как-то оповестить пользователя. Важно: При выполнении метода единственное исключение, которое
 * пользователь может увидеть - RuntimeException, т.е. ваше.
 */
public class Lesson_1 {

    private static int[] arr1 = {1, 2, 3, 4,};
    private static int[] arr2 = {10, 0, 30, 40};

    public static void main(String[] args) {
        // Задание 1
       /*method1(12, 0); // ArithmeticException
        method2(); // FileNotFoundException
        method3(); // ArrayIndexOutOfBoundsException*/

        // Задание 2. Я не понял на какой код я должен посмотреть

        // задание 3
        //System.out.println(Arrays.toString(getDifferenceArrays(arr1, arr2)));

        // задание 4
        System.out.println(Arrays.toString(getDivArrays(arr1, arr2)));

    }


    private static void method1(int a, int b) {
        System.out.println(a / b);
    }


    /*private static void method2() {
        FileReader file = new FileReader("fileName");
    }*/
    private static void method3() {
        int[] arr = new int[5];
        System.out.println(arr[6]);
    }

    private static int[] getDifferenceArrays(int[] arr1, int[] arr2) {
        int[] arrRes = new int[arr1.length];
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов разные");
        }
        for (int i = 0; i < arr1.length; i++) {
            arrRes[i] = arr1[i] - arr2[i];
        }
        return arrRes;
    }

    private static int[] getDivArrays(int[] arr1, int[] arr2) {
        int[] arrRes = new int[arr1.length];
        if (arr1.length != arr2.length) {
            throw new RuntimeException("Длины массивов разные");
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0) {
                throw new RuntimeException("На ноль делить нельзя");
            }
            arrRes[i] = arr1[i] / arr2[i];
        }
        return arrRes;
    }
}
