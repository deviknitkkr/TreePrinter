package com.devik.file;

import com.devik.Color;

import java.io.File;

import static com.devik.Color.*;

public class FileTreePrinterColored extends FileTreePrinter {
    private Color folderColor = BLUE;
    private Color hiddenFolderColor = YELLOW;
    private Color executableFileColor = GREEN;
    private Color nonExecutableFileColor = WHITE;

    public FileTreePrinterColored(Object root) {
        super(root);
    }

    @Override
    public String getValue(Object obj) {
        File file = (File) obj;
        if (file.isDirectory()) {

            if (file.isHidden())
                return hiddenFolderColor + super.getValue(obj) + RESET;

            return folderColor + super.getValue(obj) + RESET;

        } else if (file.canExecute())
            return executableFileColor + super.getValue(obj) + RESET;

        else
            return nonExecutableFileColor + super.getValue(obj) + RESET;
    }

    public void setFolderColor(Color folderColor) {
        this.folderColor = folderColor;
    }

    public void setHiddenFolderColor(Color hiddenFolderColor) {
        this.hiddenFolderColor = hiddenFolderColor;
    }

    public void setExecutableFileColor(Color executableFileColor) {
        this.executableFileColor = executableFileColor;
    }

    public void setNonExecutableFileColor(Color nonExecutableFileColor) {
        this.nonExecutableFileColor = nonExecutableFileColor;
    }
}
