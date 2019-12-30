package Nick_Maven.IO;

public class MyExceptions {
    static class IncorectPathException extends Exception {
        public IncorectPathException(String message) {
            super(message);
            System.out.println(message);
        }
    }
}
