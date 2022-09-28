package HomeWorkExeption;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, разделенные пробелом:
 * Фамилия Имя Отчество датарождения номертелефона пол
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * дата_рождения - строка формата dd.mm.yyyy
 * номер_телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, вернуть код
 * ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.
 * Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных
 * не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и
 * создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно
 * неверно.
 * Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны
 * записаться полученные данные, вида
 * <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>
 * (*) Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * (*) При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь
 * должен увидеть стектрейс ошибки.
 * *Eсли данное задание вызывает много трудностей, можно сдать задание 4 из семинара 3 в качестве ДЗ
 */
public class Lesson_3 {

    private static String surname;
    private static String name;
    private static String patronymic;
    private static String date;
    private static String phoneNumber;
    private static String gender;
    private static String openStr = "<";
    private static String closeStr = ">";
    private final static int amountOfData = 6;
    private final static String patternDate = "([0-2]\\d|3[01])\\.(0\\d|1[0-2])\\.[12]\\d{3}";
    private final static String patternFoneNum = "(\\+?7|8)?\\d{10}";
    private final static String patternGender = "f|m";

    private static String[] str;
    private static List<String> dates;
    private static Scanner scanner = new Scanner(System.in);
    private static String resultStr;
    private static List<String> filesName = new ArrayList<>();
    private static String path;

    public static void main(String[] args) {

            inputData();
            formString();
            writeFile();
    }

    private static void inputData() {
        do {
            System.out.println("Введите ваши данные через пробел (Фамилия Имя Отчество дата рождения (dd.mm.yyyy) номер" +
                    " телефона пол): ");
            str = scanner.nextLine().trim().split("\\s+");
            if (!(str.length == amountOfData)) {
                System.out.println("Вы некорректно ввели свои данные, повторите попытку.\n");
            } else {
                surname = str[0];
                name = str[1];
                patronymic = str[2];
                date = getDates(patternDate);
                phoneNumber = getDates(patternFoneNum);
                gender = getDates(patternGender);
                break;
            }
        } while (!(str.length == amountOfData));
    }

    private static String getDates(String pattern) {
        for (String s : str) {
            if (s.matches(pattern)) {
                return s;
            }
        }
        return null;
    }

    private static void formString() {
        if (date == null || phoneNumber == null || gender == null) {
            System.out.println("Вы некорректно ввели свои данные, повторите попытку.\n");
            inputData();
        } else {
            resultStr = openStr + surname + closeStr + openStr + name + closeStr + openStr + patronymic + closeStr +
                    openStr + date + closeStr + openStr + phoneNumber + closeStr + openStr + gender + closeStr;
            filesName.add(surname);
        }
    }

    private static void writeFile() {
        path = "src/main/resources/" + surname;
        if (checkFileName()) {
            try (FileWriter fileWriter = new FileWriter(path, true)) {
                fileWriter.write(resultStr + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (FileWriter fileWriter = new FileWriter(path)) {
                fileWriter.write(resultStr + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean checkFileName() {
        for (String s : filesName) {
            if (surname.equals(s)) {
                return true;
            }
        }
        return false;
    }
}
