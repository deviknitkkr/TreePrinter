package com.devik.file;

import com.devik.Color;

import java.io.File;

import static com.devik.Color.*;

public class FileTreePrinterColored extends FileTreePrinter{
    private Color folder_color= BLUE;
    private Color executable_file_color= GREEN;
    private Color non_executable_file_color= WHITE;

    public FileTreePrinterColored(Object root) {
        super(root);
    }

    @Override
    public String getValue(Object obj) {
        File file=(File)obj;
        if(file.isDirectory())
            return folder_color+super.getValue(obj)+RESET;
        else if(file.canExecute())
            return executable_file_color+super.getValue(obj)+RESET;
        else
            return non_executable_file_color+super.getValue(obj)+RESET;
    }

    public void setFolder_color(Color folder_color) {
        this.folder_color = folder_color;
    }

    public void setExecutable_file_color(Color executable_file_color) {
        this.executable_file_color = executable_file_color;
    }

    public void setNon_executable_file_color(Color non_executable_file_color) {
        this.non_executable_file_color = non_executable_file_color;
    }
}
