package Nick_Maven.Collections.OptionalTask;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class AllOptionalTasks {

//    Задания из раздела "Additional Unit" являются вспомогательными для курса "Коллекции".
//    В процессе изучения разделов курса рекомендуется решить 3-5 задач из списка.

//            1.   Ввести строки из файла, записать в список. Вывести строки в файл в обратном порядке.
//
//            2.   Ввести число, занести его цифры в стек. Вывести число, у которого цифры идут в обратном порядке.
//
//            3.   Создать список из элементов каталога и его подкаталогов.
//
//            4.   Занести стихотворение в список. Провести сортировку по возрастанию длин строк.

    void workingWithFile() {
        try {
            Files.readAllLines(Paths.get("src/main/java/Nick_Maven/Collections/OptionalTask/testRead.txt"));
            ArrayList<String> readedLines = new ArrayList<>(Files.readAllLines(Paths.get("src/main/java/Nick_Maven/Collections/OptionalTask/testRead.txt")));
            ArrayList<String> reverseLines = new ArrayList<String>(readedLines);

            System.out.println();
            System.out.println(readedLines);
            System.out.println();
            System.out.println(reverseLines);

            Files.write((Paths.get("src/main/java/Nick_Maven/Collections/OptionalTask/testReverse.txt")), reverseLines, Charset.defaultCharset());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void stackExample(String consoleRead) {
        Stack<String> stack = new Stack<>();
        String[] charArray = consoleRead.split("");
        for (int i = 0; i < consoleRead.length(); i++) {

            stack.push(charArray[i]);
        }
        System.out.println("What we have in STACK");
        System.out.println(stack);
        System.out.println("----------------------");
        System.out.println("Output from STACK");
        for (int i = 0; i < consoleRead.length(); i++) {

            System.out.print(stack.pop() + "");
        }
        System.out.println("----------------------");
        System.out.println("What's left in STACK");
        System.out.println(stack);
    }

    List<String> pathForSearch = new ArrayList<>();

    void foldersAndFiles() {
        try (Stream<Path> paths = Files.walk(Paths.get("src/"))) {
            pathForSearch = paths.filter(Files::isDirectory).map(x -> x.toString()).collect(Collectors.toList());
            for (int i = 0; i < pathForSearch.size(); i++) System.out.println(pathForSearch.get(i));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void workingWithPoemFile() {
        try {
            ArrayList<String> readedPoem = new ArrayList<>(Files.readAllLines(Paths.get("src/main/java/Nick_Maven/Collections/OptionalTask/Poem.txt")));
            ArrayList<String> sortedPoem = new ArrayList<>(readedPoem);
            System.out.println("\n----------------------");
            System.out.println("My readed Poem: ");
            System.out.println("----------------------\n");
            for (int i = 0; i < readedPoem.size(); i++) System.out.println(readedPoem.get(i));
            sortedPoem.sort((stringOne, stringTwo) -> stringTwo.length() - stringOne.length());
            System.out.println("\n----------------------");
            System.out.println("Reverse Poem");
            System.out.println("----------------------\n");
            Collections.reverse(sortedPoem);
            for (int i = 0; i < readedPoem.size(); i++) System.out.println(sortedPoem.get(i));
            Files.write((Paths.get("src/main/java/Nick_Maven/Collections/OptionalTask/sortedPoem.txt")), sortedPoem, Charset.defaultCharset());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

