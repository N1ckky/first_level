package Nick_Maven.IO;

import static Nick_Maven.IO.WorkWithFiles.outputArray;
import static Nick_Maven.IO.MyExceptions.IncorectPathException;

public class MainTask {

    public static void main(String[] args) throws IncorectPathException {
//        for test
        String path = "src\\main\\java\\Nick_Maven\\IO\\TestFolder";
        String path2 = "src\\main\\java\\Nick_Maven\\IO\\HIM";
        String path3 = "src\\main\\java\\Nick_Maven\\IO\\TestFolder\\Main.txt";
        String path4 = "src\\main\\java\\Nick_Maven\\IO\\EmpFolder";
        String path5 = "src\\main\\java\\Nick_Maven\\IO\\arguments.png";
        outputArray(path5);
//        folderOrTxtCheck(args[0]);
    }
}
