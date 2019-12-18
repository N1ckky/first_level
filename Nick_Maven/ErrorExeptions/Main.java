package Nick_Maven.ErrorExeptions;

import Nick_Maven.ErrorExeptions.ProjectPackage.Student;
import Nick_Maven.ErrorExeptions.ProjectPackage.Subject;

public class Main {

//    В университете есть несколько факультетов, в которых учатся студенты, объединенные в группы.
//    У каждого студента есть несколько учебных предметов по которым он получает оценки.
//    Необходимо реализовать иерархию студентов, групп и факультетов.
//
//    Посчитать средний балл по всем предметам студента
//    Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
//    Посчитать средний балл по предмету для всего университета

//    Релизовать следующие исключения:
//
//    Оценка ниже 0 или выше 10
//    Отсутсвие предметов у студента (должен быть хотя бы один)
//    Отсутствие студентов в группе
//    Отсутствие групп на факультете
//    Отсутствие факультетов в университете

    public static void main(String[] args) {

        String dash = "---------------------";
        String physicsFaculty = "Physics";
        String mathematicsFaculty = "Mathematics";
        String histSubject = "History";
        String mathSubject = "Math";

        Student[] studentsArray = new Student[]{

                new Student(physicsFaculty, "PH-1", "Kate Petrenko", new Subject[]{
                        new Subject(mathSubject, 5),
                        new Subject(histSubject, 2)
                }),
                new Student(physicsFaculty, "PH-1", "Nick Mazaev", new Subject[]{
                        new Subject(mathSubject, 4),
                        new Subject(histSubject, 9)
                }),
                new Student(physicsFaculty, "PH-1", "Petia Ivanov", new Subject[]{
                        new Subject(mathSubject, 3),
                        new Subject(histSubject, 0)
                }),
                new Student(physicsFaculty, "PH-1", "Maksim Trockiy", new Subject[]{
                        new Subject(mathSubject, 2),
                        new Subject(histSubject, 10)
                }),

// for test
//                new Student("Math", "MA-1", "Ivan Petrovich", new Subject[]{}),

                new Student(mathematicsFaculty, "MA-1", "Evgeniy Larik", new Subject[]{
                        new Subject(mathSubject, 4),
                        new Subject(histSubject, 7)
                }),
                new Student(mathematicsFaculty, "MA-1", "Alex Koval", new Subject[]{
                        new Subject(mathSubject, 9),
                        new Subject(histSubject, 6)
                }),
                new Student(mathematicsFaculty, "MA-1", "Roman Nikolaev", new Subject[]{
                        new Subject(mathSubject, 8),
                        new Subject(histSubject, 7)
                }),
                new Student("test", "test", "Test Student", new Subject[]{
                        new Subject(mathSubject, 10),
                        new Subject(histSubject, 10)
                }),
                new Student(mathematicsFaculty, "MA-1", "Roman Nikolaev", new Subject[]{
                        new Subject(mathSubject, 8),
                        new Subject(histSubject, 7)
                }),
        };

        String nameSortConditionSubject = "Math";
        String nameSortConditionGroup = "MA-1";
        String nameSortConditionFaculty = "Mathematics";
        String stringForCheckIfStudendHaveUnnamedField = "UNNAMED";

        System.out.println(dash);


        //    Посчитать средний балл по всем предметам студента
        int fooGrade = -666;
        INNER:
        for (Student student : studentsArray) {
            for (int j = 0; j < student.subject.length; j++) {
                if (student.subject[j].getNameSubject().equals(stringForCheckIfStudendHaveUnnamedField) ||
                        student.subject[j].getGrade() == fooGrade) {
                    continue INNER;
                }
            }
            if (student.getStudentName().equals(stringForCheckIfStudendHaveUnnamedField) ||
                    student.getGroupName().equals(stringForCheckIfStudendHaveUnnamedField) ||
                    student.getFacultyName().equals(stringForCheckIfStudendHaveUnnamedField)) {
                continue;
            }
            System.out.println("Average grades for All subjects for | "
                    + student.getStudentName() + ": " + student.getAllSubjectsAverageGrade() + ", From "
                    + student.getFacultyName() + ", group " + student.getGroupName());
        }

        System.out.println(dash);


        //    Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        double sumGrades = 0;
        double averageGrade = 0;
        int countGrades = 0;

        for (Student student1 : studentsArray) {
            if (student1.getSubjectGroupFacultyAverageGradeStudent(nameSortConditionSubject, nameSortConditionGroup, nameSortConditionFaculty) >= 0) {
                sumGrades += student1.getSubjectGroupFacultyAverageGradeStudent(nameSortConditionSubject, nameSortConditionGroup,
                        nameSortConditionFaculty);
                countGrades += 1;
            }
        }
        if (countGrades != 0)
            averageGrade = sumGrades / countGrades;
        System.out.println("Average rating for the subject: " + nameSortConditionSubject + ", in Group: " + nameSortConditionGroup
                + ", at the Faculty: " + nameSortConditionFaculty);
        System.out.println(dash + averageGrade + dash);
        System.out.println();


        //    Посчитать средний балл по предмету для всего университета
        sumGrades = 0;
        countGrades = 0;
        for (Student student : studentsArray) {
            if (student.getSubjectAverageGradeStudent(nameSortConditionSubject) >= 0) {
                sumGrades += student.getSubjectAverageGradeStudent(nameSortConditionSubject);
                countGrades += 1;
            }
        }
        if (countGrades != 0)
            averageGrade = sumGrades / countGrades;
        System.out.println("Average rating for the subject: " + nameSortConditionSubject + " at whole UNIVERSITY:");
        System.out.println(dash + averageGrade + dash);
    }
}
