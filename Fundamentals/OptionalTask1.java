package Nick_Maven.Fundamentals;

import java.util.*;

public class OptionalTask1 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        //Для успешного выполнения задания достаточно реализовать 2-4 пункта.
        //
        //Задание. Ввести n чисел с консоли.

        String max;
        String min;
        System.out.print("Введите любые числа разной длины через пробел: ");
        String numbersStr = in.nextLine();
        String[] numbersSplit = numbersStr.split(" ");

        //1.     Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

        max = min = numbersSplit[0];
        for (int i = 0; i < numbersSplit.length; i++) {
            if (max.length() <= numbersSplit[i].length()) max = numbersSplit[i];
            if (min.length() >= numbersSplit[i].length()) min = numbersSplit[i];
        }
        System.out.println("Самое длинное число: " + max);
        System.out.println("Самое короткое число: " + min);

        //2.     Вывести числа в порядке возрастания (убывания) значений их длины.


        int[] arrayInInt = new int[numbersSplit.length];
        for (int i =0; i < numbersSplit.length; i++){
            arrayInInt[i] = Integer.parseInt(numbersSplit[i]);
        }

        int[] sortedUp = new int[arrayInInt.length];
        int[] sortedDwn = new int[arrayInInt.length];
        for (int i=0; i<arrayInInt.length; i++){
            sortedUp[i]=arrayInInt[i];
            sortedDwn[i]=arrayInInt[i];
        }

        int temp;
        for (int startIndex =0; startIndex<arrayInInt.length; startIndex++){
            int minIndex = startIndex;
            int maxIndex = startIndex;
            for (int currentIndex = startIndex+1; currentIndex<arrayInInt.length; currentIndex++){
                if (sortedUp[minIndex]>sortedUp[currentIndex]){
                    temp = sortedUp[minIndex];
                    sortedUp[minIndex] = sortedUp[currentIndex];
                    sortedUp[currentIndex] = temp;
                }
                if (sortedDwn[maxIndex]<sortedDwn[currentIndex]){
                    temp = sortedDwn[maxIndex];
                    sortedDwn[maxIndex] = sortedDwn[currentIndex];
                    sortedDwn[currentIndex] = temp;
                }
            }
        }

        System.out.print("Числа в порядке возрастания: ");
        for (int i = 0; i < sortedUp.length; i++) {
            System.out.print(sortedUp[i] + " ");
        }
        System.out.println();
        System.out.print("Числа в порядке убывания: ");
        for (int i = 0; i < sortedDwn.length; i++) {
            System.out.print(sortedDwn[i] + " ");
        }


        //3.     Вывести на консоль те числа, длина которых меньше (больше) средней длины по всем числам, а также длину.

        int tempLength = 0;
        for (int i = 0; i < numbersSplit.length; i++) {
            tempLength += numbersSplit[i].length();
        }
        int overageLength = tempLength/numbersSplit.length;
        System.out.println("\nВыводим те числа, длина которых меньше средней длины = " + overageLength);
        if (overageLength == 0) System.out.println("Нет ни одного числа, удовлетворяющих условию!");
        for (int i = 0; i < numbersSplit.length; i++) {
            if (overageLength >= numbersSplit[i].length()) System.out.println("Число: " + numbersSplit[i] + ", его длина: " + numbersSplit[i].length()+ "; ");
        }
        System.out.println("\nВыводим те числа, длина которых больше средней длины = " + overageLength);
        if (overageLength == 0) System.out.println("Нет ни одного числа, удовлетворяющих условию!");
        for (int i = 0; i < numbersSplit.length; i++) {
            if (overageLength < numbersSplit[i].length()) System.out.println("Число: " + numbersSplit[i] + ", его длина: " + numbersSplit[i].length()+ "; ");
        }

    }

}

