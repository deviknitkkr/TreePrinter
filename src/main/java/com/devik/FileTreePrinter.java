package com.devik;

import java.io.File;
import java.io.IOException;

public class FileTreePrinter extends TreePrinter{

    public FileTreePrinter(Object root) {
        super(root);
    }

    @Override
    public Object[] getChild(Object obj) {
        File file=(File)obj;
        return file.listFiles();
    }

    @Override
    public String getValue(Object obj) {
        try {
            return ((File)obj).getCanonicalFile().getName();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ((File)obj).getName();
    }

    @Override
    public boolean isLeaf(Object obj) {
        return ((File)obj).isFile();
    }
}
