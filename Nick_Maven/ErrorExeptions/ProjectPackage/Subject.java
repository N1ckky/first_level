package Nick_Maven.ErrorExeptions.ProjectPackage;

public class Subject {
    private String nameSubject;
    private int grade;
    private int fooGrade = -666;
    private int upperLimitGrade = 10;
    private int upperNegativeLimitGrade = -10;
    private int downLimitGrade = 0;

    public Subject(String nameSubject, int grade) {
        super();
        try {
            if (grade >= downLimitGrade & grade <= upperLimitGrade)
                this.grade = grade;
            else throw new SubjectGradeAndNameException("Wrong subject GRADE was found. We correct it.");
            if (nameSubject.length() > 1)
                this.nameSubject = nameSubject;
            else throw new SubjectGradeAndNameException("You enter wrong subject NAME. We ignore it.");
        } catch (SubjectGradeAndNameException ex) {
            if (grade < downLimitGrade & grade >= upperNegativeLimitGrade) this.grade = Math.abs(grade);
            else this.grade = fooGrade;
        }
    }

    class SubjectGradeAndNameException extends Exception {
        SubjectGradeAndNameException(String message) {
            super(message);
            System.out.println(message);
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
