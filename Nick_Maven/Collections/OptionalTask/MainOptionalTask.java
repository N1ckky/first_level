package Nick_Maven.Collections.OptionalTask;
import java.io.*;
import java.util.Scanner;

public class MainOptionalTask {
    public static void main(String[] args) throws FileNotFoundException{
    AllOptionalTasks reading = new AllOptionalTasks();
    System.out.println("Optional tasks 1");
    reading.workingWithFile();
    System.out.println("\nOdditional task 2");
    System.out.printf("Введите любые данные для записи в стек: ");
    Scanner scanner = new Scanner(System.in);
    String stringRead = scanner.nextLine();
    reading.stackExample(stringRead);
    System.out.println("\nOdditional task 3");
    reading.foldersAndFiles();
    System.out.println("\nOdditional task 4");
    reading.workingWithPoemFile();

    }
}
