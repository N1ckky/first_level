package Nick_Maven.ErrorExeptions.ProjectPackage;

import Nick_Maven.ErrorExeptions.ExceptionsPackage.MyExceptions.*;

public class Subject {
    private String nameSubject;
    private int grade;
    private static final int FOO_GRADE = -666;
    private static final int UPPER_LIMIT_GRADE = 10;
    private static final int UPPER_NEGATIVE_LIMIT_GRADE = -10;
    private static final int DOWN_LIMIT_GRADE = 0;

    public Subject(String nameSubject, int grade) {
        super();
        try {
            if (grade >= DOWN_LIMIT_GRADE && grade <= UPPER_LIMIT_GRADE)
                this.grade = grade;
            else throw new SubjectGradeAndNameException("Wrong subject GRADE was found. We correct it.");
            if (nameSubject.length() > 1)
                this.nameSubject = nameSubject;
            else throw new SubjectGradeAndNameException("You enter wrong subject NAME. We ignore it.");
        } catch (SubjectGradeAndNameException ex) {
            if (grade < DOWN_LIMIT_GRADE & grade >= UPPER_NEGATIVE_LIMIT_GRADE) this.grade = Math.abs(grade);
            else this.grade = FOO_GRADE;
        }
    }

    public String getNameSubject() {
        return nameSubject;
    }

    public int getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Subject [nameSubject=" + nameSubject + ", grade=" + grade + "]";
    }
}
