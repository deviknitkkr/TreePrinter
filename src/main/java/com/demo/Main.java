package com.demo;

import com.devik.Color;
import com.devik.file.FileTreePrinter;
import com.devik.TreePrinter;
import com.devik.file.FileTreePrinterColored;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        File file=new File("./src");

        FileTreePrinterColored treePrinter=new FileTreePrinterColored(file);
        treePrinter.visitAndPrint();

    }
}
