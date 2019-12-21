package Nick_Maven.ErrorExeptions.ProjectPackage;

import Nick_Maven.ErrorExeptions.ExceptionsPackage.MyExceptions.*;

public class Student extends Group {
    public Subject[] subject;
    private String studentName;

    public Student(String facultyName, String groupName, String studentName, Subject[] subject) {
        super(facultyName, groupName);
        try {
            if (studentName.length() <= 1) {
                throw new StudentNameException("Some of Students don't have name. I skip him");
            }
            this.studentName = studentName;
        } catch (StudentNameException ex) {
            this.setStudentName("UNNAMED");
        }
        try {
            if (subject.length < 1) {
                throw new SubjectCountException("Every student must have at least ONE SUBJECT! I add 'UNNAMED' " +
                        "with grade = 0");
            }
            this.subject = subject;
        } catch (SubjectCountException ex) {
            this.subject = new Subject[1];
            this.subject[0] = new Subject("UNNAMED", 0);
        }
        try {
            if (this.getGroupName().length() < 1) throw new GroupNameException("Every student must have group name! I skip him");
        } catch (GroupNameException ex) {
            this.setGroupName("UNNAMED");
        }
        try {
            if (this.getFacultyName().length() < 1) throw new FacultyNameException("Every student must have the faculty! I skip him");
        } catch (FacultyNameException ex4) {
            this.setFacultyName("UNNAMED");
        }
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getGrades() {
        String grades = "";
        for (Subject subject : this.subject) {
            grades += subject.getNameSubject() + "=" + subject.getGrade() + "; ";
        }
        return grades;
    }

    public double getAllSubjectsAverageGrade() {
        double sumGrades = 0;
        int countGrades = 0;
        for (Subject subject : this.subject) {
            sumGrades += subject.getGrade();
            countGrades += 1;
        }
        return sumGrades / countGrades;
    }

    public double getSubjectGroupFacultyAverageGradeStudent(String nameSubject, String nameGroup, String
            nameFaculty) {
        try {
            double sumGrades = 0;
            int countGrades = 0;
            for (Subject subject : this.subject) {
                if (subject.getNameSubject() == nameSubject
                        && this.getGroupName() == nameGroup
                        && this.getFacultyName() == nameFaculty) {
                    sumGrades += subject.getGrade();
                    countGrades += 1;
                }
            }
            return sumGrades / countGrades;
        } catch (ArithmeticException e) {
            throw (e);
        }
    }

    public double getSubjectAverageGradeStudent(String nameSubject) {
        try {
            double sumGrades = 0;
            int countGrades = 0;
            for (Subject subject : this.subject) {
                if (subject.getNameSubject() == nameSubject) {
                    sumGrades += subject.getGrade();
                    countGrades += 1;
                }
            }
            return sumGrades / countGrades;
        } catch (ArithmeticException e) {
            throw (e);
        }
    }

    @Override
    public String toString() {
        return "Name=" + studentName + "; Faculty=" + super.getFacultyName() + "; Group=" + super.getGroupName() + ", subjects: " + this.getGrades();
    }
}
