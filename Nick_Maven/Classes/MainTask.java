package Nick_Maven.Classes;
import java.util.*;

public class MainTask {

    public static void main(String[] args) {

//         Для выполнения достаточно выбрать одно задание.
//           Создать классы, спецификации которых приведены ниже. Определить конструкторы и методы setТип(), getТип(), toString().
//           Определить дополнительно методы в классе, создающем массив объектов. Задать критерий выбора данных и вывести эти данные на консоль.
//           В каждом классе, обладающем информацией, должно быть объявлено несколько конструкторов.
//
//            1. Student: id, Фамилия, Имя, Отчество, Дата рождения, Адрес, Телефон, Факультет, Курс, Группа.
//
//            Создать массив объектов. Вывести:
//
//            a) список студентов заданного факультета;
//
//            b) списки студентов для каждого факультета и курса;
//
//            c) список студентов, родившихся после заданного года;
//
//            d) список учебной группы.


        Student[] student = new Student[6];
        student[0] = new Student(1, "Petrenko", "Ekaterina", "Vladislavovna",
                new GregorianCalendar(1994, 8, 10), "Gomel", "+375(29)-192-00-01",
                "EF", 1, "E-11");
        student[1] = new Student(2, "Mazaev", "Nikolay", "Alehandrovich",
                new GregorianCalendar(1992, 3, 22), "Brest", "+375(29)-192-00-02",
                "FAIS", 2, "PE-21");
        student[2] = new Student(3, "Yakimovich", "Ilya", "Andreevich",
                new GregorianCalendar(1995, 1, 2), "Minsk", "+375(29)-192-00-03",
                "EK", 3, "BK-31");
        student[3] = new Student(4, "Yakimov", "Stanislav", "Igorevich",
                new GregorianCalendar(1993, 7, 7), "Mogilev", "+375(29)-192-00-04",
                "EF", 1, "E-11");
        student[4] = new Student(5, "Shilov", "Igor", "Valerievich",
                new GregorianCalendar(1994, 2, 12), "Gomel", "+375(29)-192-00-05",
                "FAIS", 2, "PE-21");
        student[5] = new Student(6, "Yakimovich", "Ilya", "Andreevich",
                new GregorianCalendar(1995, 11, 13), "Minsk", "+375(29)-192-00-06",
                "EK", 3, "BK-31");

        List list = new List();

        for (Student n : student) {
            list.addStudent(n);
        }

        System.out.println("Cписок студентов факультета EK:");
        list.listOutFaculty("EK");
        System.out.println();

        System.out.println("Cписок студентов факультета FAIS и 2-го курса:");
        list.listOutFacultyAndCurse("FAIS",2);
        System.out.println();

        System.out.println("Cписок студентов, родившихся после 1993 года:");
        list.listBirthAfter(new GregorianCalendar(1993,1,1));
        System.out.println();

        System.out.println("Список студентов группы E-11:");
        list.listOutGroup("E-11");
        System.out.println();

    }
}
