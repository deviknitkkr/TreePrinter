# TreePrinter

I have created two classes for printing FilesStructure.

1. FileTreePrinter
```java
public class Main {

    public static void main(String[] args) {

        File file=new File(".");

        FileTreePrinter treePrinter=new FileTreePrinter(file);
        treePrinter.visitAndPrint();
        //  or
        //  StringBuilder sb=treePrinter.visitAndReturn();
        //  sout(sb);
    }
}
```
This code will produce below output.


``` txt
TreePrinter
├─.gitignore
├─.idea
│  ├─.gitignore
│  ├─compiler.xml
│  ├─jarRepositories.xml
│  ├─misc.xml
│  ├─uiDesigner.xml
│  └─vcs.xml
├─LICENSE
├─pom.xml
├─README.md
├─src
│  └─main
│     └─java
│        └─com
│           ├─demo
│           │  └─Main.java
│           └─devik
│              ├─Color.java
│              ├─file
│              │  ├─FileTreePrinter.java
│              │  └─FileTreePrinterColored.java
│              └─TreePrinter.java
├─.project
├─.settings
│  ├─org.eclipse.m2e.core.prefs
│  ├─org.eclipse.jdt.core.prefs
│  └─org.eclipse.jdt.apt.core.prefs
├─target
│  ├─classes
│  │  └─com
│  │     ├─devik
│  │     │  ├─file
│  │     │  │  ├─FileTreePrinter.class
│  │     │  │  └─FileTreePrinterColored.class
│  │     │  ├─TreePrinter.class
│  │     │  └─Color.class
│  │     └─demo
│  │        └─Main.class
│  ├─test-classes
│  ├─maven-status
│  │  └─maven-compiler-plugin
│  │     └─compile
│  │        └─default-compile
│  │           ├─createdFiles.lst
│  │           └─inputFiles.lst
│  ├─generated-sources
│  │  └─annotations
│  ├─maven-archiver
│  │  └─pom.properties
│  └─TreePrinter-1.0-SNAPSHOT.jar
└─.classpath
```


2. FileTreePrinterColored
```java
public class Main {

    public static void main(String[] args) {

        File file=new File("./src");

        FileTreePrinterColored treePrinter=new FileTreePrinterColored(file);
        treePrinter.visitAndPrint();
        //  or
        //  StringBuilder sb=treePrinter.visitAndReturn();
        //  sout(sb);
    }
}
```
This code will produce below output.

![image](https://user-images.githubusercontent.com/41135360/130220535-298ff8c5-3f87-46dc-a031-d8212e090e5b.png)

Also in case of FileTreePrinterColored you can set custom colors.
```java

public class Main {

    public static void main(String[] args) {

        File file=new File("./src");

        FileTreePrinterColored treePrinter=new FileTreePrinterColored(file);
        
        treePrinter.setFolderColor(Color.RED);
        treePrinter.setHiddenFolderColor(Color);
        treePrinter.setExecutableFileColor(Color);
        treePrinter.setNonExecutableFileColor(Color);
        //or
        treePrinter.setNonExecutableFileColor(Color.valueOf("color asci"));

        
        treePrinter.visitAndPrint();
        //  or
        //  StringBuilder sb=treePrinter.visitAndReturn();
        //  sout(sb);
    }
}
```

If you want to print other than file tree than you can use TreePrinter abstract class.
In that case you need to implement three methods.
```java

 Object obj;
        TreePrinter treePrinter=new TreePrinter(obj) {
            @Override
            public Object[] getChild(Object obj) {
                return new Object[0];
            }

            @Override
            public String getValue(Object obj) {
                return null;
            }

            @Override
            public boolean isLeaf(Object obj) {
                return false;
            }
        };
        // Here obj is the root of TreeStructure.
 ```
 
 for ie. you want to printBinary tree than you can do something like below...
 ```java

 Object obj; //here obj is root of Binary tree
        TreePrinter treePrinter=new TreePrinter(obj) {
            @Override
            public Object[] getChild(Object obj) {
                Node node=(Node)obj;
                return new Object[]{node.left,node.right};
            }

            @Override
            public String getValue(Object obj) {
                return ((Node)obj).getValue();
            }

            @Override
            public boolean isLeaf(Object obj) {
               Node node=(Node)obj;
                return node.left==null && node.right==null;
            }
        };
        // Here obj is the root of TreeStructure.
 ```
 
