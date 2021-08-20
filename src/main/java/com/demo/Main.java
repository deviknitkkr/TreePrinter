package com.demo;

import com.devik.FileTreePrinter;
import com.devik.TreePrinter;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File file=new File(".");

        TreePrinter treePrinter=new FileTreePrinter(file);

        System.out.println(treePrinter.visitAndReturn());
    }
}
