package Nick_Maven.Classes;

import java.util.*;

public class Student {

    private int id;
    private String surname;
    private String name;
    private String midName;
    private GregorianCalendar  birthdate;
    private String adress;
    private String phone;
    private String faculty;
    private int courseNumber;
    private String groupNumber;

    public Student(int id, String surname, String name, String midName, GregorianCalendar  birthdate, String adress,
                   String phone, String faculty, int courseNumber, String groupNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.midName = midName;
        this.birthdate = birthdate;
        this.adress = adress;
        this.phone = phone;
        this.faculty = faculty;
        this.courseNumber = courseNumber;
        this.groupNumber = groupNumber;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public GregorianCalendar  getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(GregorianCalendar  birthdate) {
        this.birthdate = birthdate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public int getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "Студент: " +
                "id =" + id +
                ", Фамилия =" + surname + '\'' +
                ", Имя =" + name + '\'' +
                ", Отчество =" + midName + '\'' +
                ", Дата рождения=" + birthdate +
                ", Адресс =" + adress + '\'' +
                ", Телефон =" + phone + '\'' +
                ", Факультет =" + faculty + '\'' +
                ", № Курса =" + courseNumber +
                ", Группа =" + groupNumber;
    }
}