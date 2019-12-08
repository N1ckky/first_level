package Nick_Maven.Classes;

import java.util.*;

public class List {

    public Student[] studentlist = new Student[50];

    int i = 0;

    public void addStudent(Student student) {
        studentlist[i++] = student;
    }

    private void listOut(Student student) {
        System.out.print("id: " + student.getId() + ", ");
        System.out.print("surname: " + student.getSurname() + ", ");
        System.out.print("name: " + student.getName() + ", ");
        System.out.print("midName: " + student.getMidName() + ", ");
        System.out.print("birthdate: " + student.getBirthdate().get(Calendar.YEAR) + "-"
                + student.getBirthdate().get(Calendar.MONTH)
                + "-" + student.getBirthdate().get(Calendar.DAY_OF_MONTH) + ", ");
        System.out.print("adress: " + student.getAdress() + ", ");
        System.out.print("phone: " + student.getPhone() + ", ");
        System.out.print("faculty: " + student.getFaculty() + ", ");
        System.out.print("course number: " + student.getCourseNumber() + ", ");
        System.out.print("group number: " + student.getGroupNumber() + ".");
        System.out.println();
    }

    public void listOutFaculty(String faculty) {

        for (Student student : studentlist) {

            if ((student != null) && (student.getFaculty() == faculty)) {
                listOut(student);
            }
        }
    }



    public void listOutFacultyAndCurse(String faculty, int course) {

        for (Student student : studentlist) {

            if ((student != null) && (student.getFaculty() == faculty) && (student.getCourseNumber() == course)) {
                listOut(student);
            }
        }
    }

    public void listBirthAfter(GregorianCalendar birthdate) {

        for (Student student : studentlist) {
            if ((student != null) && (student.getBirthdate().get(Calendar.YEAR) > birthdate.get(Calendar.YEAR))) {
                listOut(student);
            }
        }
    }

    public void listOutGroup (String group) {

        for (Student student : studentlist) {
            if ((student != null) && (student.getGroupNumber()) == group) {
                listOut(student);
            }
        }
    }



}
