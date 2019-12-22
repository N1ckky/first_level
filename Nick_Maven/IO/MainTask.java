package Nick_Maven.IO;

import static Nick_Maven.IO.WorkWithFiles.outputArrayTree;

public class MainTask {

    public static void main(String[] args) {
//        for test
//        String path = "src\\main\\java\\Nick_Maven\\IO\\HIM";
//        outputArrayTree(path);
        outputArrayTree(args[0]);
    }
}
