package Nick_Maven.IO;

import java.io.IOException;

import static Nick_Maven.IO.WorkWithFiles.folderOrTxtCheck;

public class MainTask {

    public static void main(String[] args) throws IOException {
//        for test
        String path = "src\\main\\java\\Nick_Maven\\IO\\TestFolder";
        String path2 = "src\\main\\java\\Nick_Maven\\IO\\HIM";
        String path3 = "src\\main\\java\\Nick_Maven\\IO\\TestFolder\\Main.txt";
        String path4 = "src\\main\\java\\Nick_Maven\\IO\\EmpFolder";
        folderOrTxtCheck(path4);
//        folderOrTxtCheck(args[0]);
    }
}
