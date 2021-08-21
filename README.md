# TreePrinter
[![](https://jitpack.io/v/deviknitkkr/TreePrinter.svg)](https://jitpack.io/#deviknitkkr/TreePrinter)

To add this library to your project

### Maven
```xml


	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>



	<dependency>
	    <groupId>com.github.deviknitkkr</groupId>
	    <artifactId>TreePrinter</artifactId>
	    <version>Tag</version>
	</dependency>

```
I have created two classes for printing FilesStructure.

## 1.FileTreePrinter
```java
public class Main {

    public static void main(String[] args) {

        File file=new File("./src");

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
src
├─main
│  ├─java
│  │  └─com
│  │     ├─demo
│  │     │  └─Main.java
│  │     └─devik
│  │        ├─Color.java
│  │        ├─file
│  │        │  ├─FileTreePrinter.java
│  │        │  └─FileTreePrinterColored.java
│  │        └─TreePrinter.java
│  └─resources
└─test
   └─java

```


## 2.FileTreePrinterColored
```java
public class Main {

    public static void main(String[] args) {

        File file=new File("./src");

        FileTreePrinterColored treePrinter=new FileTreePrinterColored(file);
        treePrinter.visitAndPrint();
        //  or
        //  StringBuilder sb=treePrinter.visitAndReturn();
        //  System.out.println(sb);
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
        //  System.out.println(sb);
    }
}
```

If you want to print other than file tree than you can use **TreePrinter** abstract class.
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
 
 for ie. if you want to print BinaryTree than you can do something like below...
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
 
