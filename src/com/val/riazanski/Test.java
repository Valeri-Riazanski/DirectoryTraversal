package com.val.riazanski;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        String pathName = "G:\\JAVA\\Dima";
        FileBuilder.traverseDirectory(pathName);
    }
}
