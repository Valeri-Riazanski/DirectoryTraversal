package com.val.riazanski;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileBuilder {
    //fields
    //constructors
    //methods
     public static void traverseDirectory(String pathName) throws IOException {
         List<String> list = new ArrayList<>();
        File file = new File(pathName);
        String[] dirList = file.list();
        Pattern pattern = Pattern.compile(".txt");
        for (int i = 0; i < Objects.requireNonNull(dirList).length; i++) {
                String currentPathName = pathName + File.separator + dirList[i];
                File metaFile = new File(currentPathName);
                if (metaFile.isFile()) {
                    Matcher matcher = pattern.matcher(dirList[i]);
                    System.out.println(currentPathName);
                    while (matcher.find()) {
                        System.out.println(dirList[i]);
                        Scanner scanner = new Scanner(metaFile, "windows-1251");
                        while (scanner.hasNext()) {
                            list.add(scanner.nextLine());
                        }
                        scanner.close();
                    }

            } else {
                traverseDirectory(currentPathName);
            }

        }

        List<String> sortedList = new ArrayList<>();
        for (String str : list) {
            char[] tempArray = str.toCharArray();
            Arrays.sort(tempArray);
            String sortedString = new String(tempArray);
            sortedList.add(sortedString);
        }
        PrintWriter writer = new PrintWriter(new FileWriter("G:\\JAVA\\Dima\\sortedFile.txt",true));
        for (String line : sortedList) {
            System.out.println(line);
            writer.println(line);
        }
        writer.close();
    }
}
