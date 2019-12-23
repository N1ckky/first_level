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

    private static final String DASH = "---------------------";
    private static final String PHYSICS_FACULTY = "Physics";
    private static final String MATHEMATICS_FACULTY = "Mathematics";
    private static final String HIST_SUBJECT = "History";
    private static final String MATH_SUBJECT = "Math";
    private static final int FOO_GRADE = -666;

    private static final String NAME_SORT_CONDITION_SUBJECT = "Math";
    private static final String NAME_SORT_CONDITION_GROUP = "MA-1";
    private static final String NAME_SORT_CONDITION_FACULTY = "Mathematics";
    private static final String CHECK_IF_STUDEND_HAVE_UNNAMED_FIELD = "UNNAMED";


    public static void main(String[] args) {

        Student[] studentsArray = new Student[]{
                new Student(PHYSICS_FACULTY, "PH-1", "Kate Petrenko", new Subject[]{
                        new Subject(MATH_SUBJECT, 5),
                        new Subject(HIST_SUBJECT, 2)
                }),
                new Student(PHYSICS_FACULTY, "PH-1", "Nick Mazaev", new Subject[]{
                        new Subject(MATH_SUBJECT, 4),
                        new Subject(HIST_SUBJECT, 9)
                }),
                new Student(PHYSICS_FACULTY, "PH-1", "Petia Ivanov", new Subject[]{
                        new Subject(MATH_SUBJECT, 3),
                        new Subject(HIST_SUBJECT, 0)
                }),
                new Student(PHYSICS_FACULTY, "PH-1", "Maksim Trockiy", new Subject[]{
                        new Subject(MATH_SUBJECT, 2),
                        new Subject(HIST_SUBJECT, 10)
                }),

// for test
//                new Student("Math", "MA-1", "Ivan Petrovich", new Subject[]{}),

                new Student(MATHEMATICS_FACULTY, "MA-1", "Evgeniy Larik", new Subject[]{
                        new Subject(MATH_SUBJECT, 4),
                        new Subject(HIST_SUBJECT, 7)
                }),
                new Student(MATHEMATICS_FACULTY, "MA-1", "Alex Koval", new Subject[]{
                        new Subject(MATH_SUBJECT, 9),
                        new Subject(HIST_SUBJECT, 6)
                }),
                new Student(MATHEMATICS_FACULTY, "MA-1", "Ilya Valentinov", new Subject[]{
                        new Subject(MATH_SUBJECT, 8),
                        new Subject(HIST_SUBJECT, 7)
                }),
                new Student("test", "test", "Test Student", new Subject[]{
                        new Subject(MATH_SUBJECT, 10),
                        new Subject(HIST_SUBJECT, 10)
                }),
                new Student(MATHEMATICS_FACULTY, "MA-1", "Roman Nikolaev", new Subject[]{
                        new Subject(MATH_SUBJECT, 8),
                        new Subject(HIST_SUBJECT, 7)
                }),
        };

        System.out.println(DASH);


        //    Посчитать средний балл по всем предметам студента
        INNER:
        for (Student student : studentsArray) {
            if (student.getStudentName().equals(CHECK_IF_STUDEND_HAVE_UNNAMED_FIELD) ||
                    student.getGroupName().equals(CHECK_IF_STUDEND_HAVE_UNNAMED_FIELD) ||
                    student.getFacultyName().equals(CHECK_IF_STUDEND_HAVE_UNNAMED_FIELD)) {
            } else {
                for (int j = 0; j < student.subject.length; j++) {
                    if (student.subject[j].getNameSubject().equals(CHECK_IF_STUDEND_HAVE_UNNAMED_FIELD) ||
                            student.subject[j].getGrade() == FOO_GRADE) {
                    } else {
                        System.out.println("Average grades for All subjects for | "
                                + student.getStudentName() + ": " + student.getAllSubjectsAverageGrade() + ", From "
                                + student.getFacultyName() + ", group " + student.getGroupName());
                        break;
                    }
                }
            }
        }

        System.out.println(DASH);


        //    Посчитать средний балл по конкретному предмету в конкретной группе и на конкретном факультете
        double sumGrades = 0;
        double averageGrade = 0;
        int countGrades = 0;

        for (Student student1 : studentsArray) {
            if (student1.getSubjectGroupFacultyAverageGradeStudent(NAME_SORT_CONDITION_SUBJECT, NAME_SORT_CONDITION_GROUP, NAME_SORT_CONDITION_FACULTY) >= 0) {
                sumGrades += student1.getSubjectGroupFacultyAverageGradeStudent(NAME_SORT_CONDITION_SUBJECT, NAME_SORT_CONDITION_GROUP,
                        NAME_SORT_CONDITION_FACULTY);
                countGrades += 1;
            }
        }
        if (countGrades != 0)
            averageGrade = sumGrades / countGrades;
        System.out.println("Average rating for the subject: " + NAME_SORT_CONDITION_SUBJECT + ", in Group: " + NAME_SORT_CONDITION_GROUP
                + ", at the Faculty: " + NAME_SORT_CONDITION_FACULTY);
        System.out.println(DASH + averageGrade + DASH);
        System.out.println();


        //    Посчитать средний балл по предмету для всего университета
        sumGrades = 0;
        countGrades = 0;
        for (Student student : studentsArray) {
            if (student.getSubjectAverageGradeStudent(NAME_SORT_CONDITION_SUBJECT) >= 0) {
                sumGrades += student.getSubjectAverageGradeStudent(NAME_SORT_CONDITION_SUBJECT);
                countGrades += 1;
            }
        }
        if (countGrades != 0)
            averageGrade = sumGrades / countGrades;
        System.out.println("Average rating for the subject: " + NAME_SORT_CONDITION_SUBJECT + " at whole UNIVERSITY:");
        System.out.println(DASH + averageGrade + DASH);
    }
}
