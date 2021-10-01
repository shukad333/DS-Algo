package com.designpatterns.dp.design;

import java.util.HashMap;
import java.util.Map;

public class DesignInMemoryFileSystem {

    private Directory rootDir = new Directory("/");

    public void mkDir(String dir) {
        String[] d = dir.split("/");
        Directory curr = rootDir;
        for(int i=1;i<d.length;i++) {
            if(curr.directories.containsKey(d[i])) {
                curr = curr.directories.get(d[i]);
            }
            else {
                Directory directory = new Directory(d[i]);
                curr.directories.put(d[i],directory);
            }
        }
    }
}




class File {
    String fileName;
    String contents;

    public File(String fileName , String contents) {
        this.fileName = fileName;
        this.contents = contents;
    }

    public void addContentsToFile(String cont) {
        this.contents += cont;
    }
}


class Directory {
    String pathName;
    Map<String,File> files = new HashMap<>();
    Map<String,Directory> directories = new HashMap<>();

    public Directory(String pathName) {
        this.pathName = pathName;
    }

}