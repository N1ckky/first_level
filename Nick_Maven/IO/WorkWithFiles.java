package Nick_Maven.IO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;




class WorkWithFiles {
    private static final String INDENT_DASH = "|-----";
    private static final String INDENT_SPACE = "|     ";
    private static final int TAB_LEVEL = 0;

    private static List<String> arrayTree = new ArrayList<>();

    static void outputArrayTree(String path) {
        arrayTree.add(path.substring(path.lastIndexOf('\\') + 1));
        File mainDirectory = new File(path);

        if (mainDirectory.exists() && mainDirectory.isDirectory()) {
            File[] arr = mainDirectory.listFiles();
            if (arr == null) throw new AssertionError();
            readFilesTree(arr, TAB_LEVEL);
            arrayTree.remove(1);
            File fileWanish = new File("src\\main\\java\\Nick_Maven\\IO\\outputTree.txt");
            if (fileWanish.exists()) {
                fileWanish.delete();
            }
            for (String s : arrayTree) {
                System.out.println(s);
                try (FileWriter writer = new FileWriter(fileWanish, true)) {
                    writer.write(s + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFilesTree(File[] arr, int level) {
        final String TAB = new String(new char[level]).replace("\0", "\t");
        for (File f : arr) {
            if (f.isFile()) {
                if (level != 0) {
                    arrayTree.add(TAB + INDENT_SPACE + f.getName());
                } else arrayTree.add(INDENT_SPACE + f.getName());
            } else if (f.isDirectory()) {
                if (level != 0) {
                    arrayTree.add(TAB + INDENT_SPACE);
                    arrayTree.add(TAB + INDENT_DASH + f.getName());
                } else {
                    arrayTree.add(INDENT_SPACE);
                    arrayTree.add(INDENT_DASH + f.getName());
                }
                readFilesTree(Objects.requireNonNull(f.listFiles()), level + 1);
            }
        }
    }
}
