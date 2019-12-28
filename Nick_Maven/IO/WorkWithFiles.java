package Nick_Maven.IO;

import Nick_Maven.IO.MyExceptions.IncorectPathException;

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
    private static boolean isTxt = false;
    private static final String PATH_FOR_OUTPUT = "src\\main\\java\\Nick_Maven\\IO\\outputTree.txt";

    private static int folderCounter = 1;
    private static int fileCounter = 0;
    private static int totalFilesNameLength = 0;

    private static List<String> arrayTree = new ArrayList<>();

    static void outputArray(String path) throws IncorectPathException {
        File mainPath = new File(path);
        if (mainPath.exists() && mainPath.isDirectory()) {
            arrayTree.add(path.substring(path.lastIndexOf('\\') + 1));
        } else if (mainPath.exists() && mainPath.getName().contains("txt")) {
            mainPath = new File(mainPath.getPath().substring(0, mainPath.getPath().lastIndexOf('\\') + 1));
            isTxt = true;
            System.out.println("You enter path to .TXT file \n---------------------------");
        } else {
            throw new IncorectPathException("You send must enter path to FOLDER or to .TXT FILE");
        }

        File[] arr = mainPath.listFiles();
        readFilesTree(Objects.requireNonNull(arr), TAB_LEVEL);

        if (!isTxt) {
            if (arrayTree.size() > 1) {
                if (arrayTree.get(1).length() == INDENT_SPACE.length())
                    arrayTree.remove(1);

                for (String s : arrayTree) {
                    System.out.println(s);
                }
            } else System.out.println("The selected \"" + arrayTree.get(0) + "\" folder is Empty");
        } else {
            if (arrayTree.size() > 1) {
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
        fileWanisher(PATH_FOR_OUTPUT);
    }

    private static void fileWanisher(String outputFile) {
        File fileWanish = new File(outputFile);
        if (fileWanish.exists()) {
            fileWanish.delete();
        }
        for (String s : arrayTree) {
            try (FileWriter writer = new FileWriter(fileWanish, true)) {
                writer.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
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
