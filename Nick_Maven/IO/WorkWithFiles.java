package Nick_Maven.IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class WorkWithFiles {
    private static final String INDENT_DASH = "|-----";
    private static final String INDENT_SPACE = "|     ";
    private static final int TAB_LEVEL = 0;

    private static List<String> arrayTree = new ArrayList<>();

    static void outputArrayTree(File mainPath) {
        File[] arr = mainPath.listFiles();
        readFilesTree(Objects.requireNonNull(arr), TAB_LEVEL);
        if (arrayTree.size() > 1) {
            if (arrayTree.get(1).length() == INDENT_SPACE.length())
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
        } else System.out.println("The selected \"" + arrayTree.get(0) + "\" folder is Empty");
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

    static void folderOrTxtCheck(String path) {
        arrayTree.add(path.substring(path.lastIndexOf('\\') + 1));
        File mainPath = new File(path);
        if (mainPath.exists() && mainPath.isDirectory()) {
            outputArrayTree(mainPath);
        } else if (mainPath.exists() && mainPath.getName().contains("txt")) {
            File mainTxt = new File(mainPath.getPath().substring(0, mainPath.getPath().lastIndexOf('\\') + 1));
            outputArrayTxtFile(mainTxt);
        }
    }

    static void outputArrayTxtFile(File mainTxt) {

        int folderCounter = 1;
        int fileCounter = 0;
        int totalFilesNameLength = 0;

        File[] arr = mainTxt.listFiles();
        readFilesTree(arr, TAB_LEVEL);

        if (arrayTree.size() > 1) {
            arrayTree.remove(0);
            for (int i = 0; i < arrayTree.size(); i++) {
                String s = arrayTree.get(i);
                if (s.equals(INDENT_SPACE)) {
                    arrayTree.remove(s);
                }
            }
            for (String s : arrayTree) {
                if (s.contains(INDENT_DASH)) {
                    folderCounter += 1;
                }
                if (s.contains(INDENT_SPACE)) {
                    fileCounter += 1;
                    totalFilesNameLength += (s.length() - INDENT_SPACE.length());
                }
                System.out.println(s);
            }

            System.out.println();

            if (fileCounter != 0)
                System.out.println("Average length of file names in this folder and subfolders: " + totalFilesNameLength / fileCounter);
            System.out.println("Total folders found: " + folderCounter);
            System.out.println("Total files found: " + fileCounter);
            if (folderCounter != 0)
                System.out.println("Average number of files: " + fileCounter / folderCounter);
        }
    }
}
