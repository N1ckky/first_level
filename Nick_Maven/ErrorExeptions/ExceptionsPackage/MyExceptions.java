package Nick_Maven.ErrorExeptions.ExceptionsPackage;

public class MyExceptions {
    public static class SubjectGradeAndNameException extends Exception {
        public SubjectGradeAndNameException(String message) {
            super(message);
            System.out.println(message);
        }
    }

    public static class StudentNameException extends Exception {
        public StudentNameException(String message) {
            super(message);
            System.out.println(message);
        }
    }

    public static class SubjectCountException extends Exception {
        public SubjectCountException(String message) {
            super(message);
            System.out.println(message);
        }
    }

    public static class GroupNameException extends Exception {
        public GroupNameException(String message) {
            super(message);
            System.out.println(message);
        }
    }

    public static class FacultyNameException extends Exception {
        public FacultyNameException(String message) {
            super(message);
            System.out.println(message);
        }
    }
}
