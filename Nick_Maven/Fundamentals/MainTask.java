package Nick_Maven.Fundamentals;

import java.util.Scanner;

public class MainTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        //1.     Приветствовать любого пользователя при вводе его имени через командную строку.
        System.out.print("Пожалуйста введите Ваше имя: ");
        String name = in.nextLine();
        System.out.println("Привет, " + name + "!");

        //2.     Отобразить в окне консоли аргументы командной строки в обратном порядке.

        System.out.print("Введите любые аргументы: ");
        StringBuffer reverse = new StringBuffer(in.nextLine());
        System.out.println("Обратная последовательность: " + reverse.reverse());

        //3.     Вывести заданное количество случайных чисел с переходом и без перехода на новую строку

        int a = 0;
        int b = 100;
        System.out.println("Сколько случайных чисел вы хотите сгенерировать? ");
        int randomNumbers = in.nextInt();
        for (int i = 1; i <= randomNumbers; i++) {
            int rand = (a + (int) (Math.random() * b));
            System.out.println("Вывод с переходом: " + rand);
        }
        System.out.println();
        for (int i = 1; i <= randomNumbers; i++) {
            int rand = (a + (int) (Math.random() * b));
            System.out.print("Вывод без перехода: " + rand + " ");
        }
        System.out.println();

        //4. Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и вывести результат на консоль.

        Scanner newIn = new Scanner(System.in);
        int sum = 0;
        int composition = 1;
        System.out.print("Введите числа в командную строку через пробел: ");
        String numbersStr = newIn.nextLine();
        String[] numbersSplit = numbersStr.split(" ");
        for (int i = 0; i < numbersSplit.length; i++) {
            sum = sum + Integer.parseInt(numbersSplit[i]);
            composition = composition * Integer.parseInt(numbersSplit[i]);
        }
        System.out.println("Сумма введенных чисел: " + sum);
        System.out.println("Произведение введенных чисел: " + composition);

        //5.   Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.

        System.out.print("Введите число от 1 до 12: ");
        int mounth = newIn.nextInt();
        if (mounth == 1) System.out.println("Ваш месяц ЯНВАРЬ");
        else if (mounth == 2) System.out.println("Ваш месяц ФЕВРАЛЬ");
        else if (mounth == 3) System.out.println("Ваш месяц МАРТ");
        else if (mounth == 4) System.out.println("Ваш месяц АПРЕЛЬ");
        else if (mounth == 5) System.out.println("Ваш месяц МАЙ");
        else if (mounth == 6) System.out.println("Ваш месяц ИЮНЬ");
        else if (mounth == 7) System.out.println("Ваш месяц ИЮЛЬ");
        else if (mounth == 8) System.out.println("Ваш месяц АВГУСТ");
        else if (mounth == 9) System.out.println("Ваш месяц СЕНТЯБРЬ");
        else if (mounth == 10) System.out.println("Ваш месяц ОКТЯБРЬ");
        else if (mounth == 11) System.out.println("Ваш месяц НОЯБРЬ");
        else if (mounth == 12) System.out.println("Ваш месяц ДЕКАБРЬ");
        else {
            System.out.println("Вы ввели недопустимое число... Прощайте");
        }
    }
}

