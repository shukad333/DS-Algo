package com.general.geeks.design;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class InMemoryFileSystem {

    public static void main(String[] args) {

        InMemoryFileSystem fileSystem = new InMemoryFileSystem();
        fileSystem.mkdir("/root/shu");
        fileSystem.addContentToFile("/root/shu/shu.txt","Just created this!");
        System.out.println(fileSystem.ls("/root/shu"));

    }

    private FileNode root;

    public InMemoryFileSystem() {
        root = new FileNode("");
    }

    public List<String> ls(String path) {
        return findNode(path).getList();
    }

//    public List<String> lsRecursive(String path) {
//        List<String> folders = findNode(path).getList();
//
//    }

    public void mkdir(String path) {
        findNode(path);
    }

    public void addContentToFile(String filePath, String content) {
        findNode(filePath).addContent(content);
    }

    public String readContentFromFile(String filePath) {
        return findNode(filePath).getContent();
    }

    //-- private method section --//
    private FileNode findNode(String path){

        String[] paths = path.split("/");
        FileNode curr = root;
        for(String file : paths) {
            if(file.length()==0)
                continue;

            curr.folders.putIfAbsent(file,new FileNode(file));
            curr = curr.folders.get(file);
            if(curr.isFile())
                break;
        }

        return curr;

//        String[] files = path.split("/");
//
//        FileNode cur = root;
//        for(String file : files){
//            if(file.length() == 0) continue;
//
//            cur.folders.putIfAbsent(file, new FileNode(file));
//            cur = cur.folders.get(file);
//
//            if(cur.isFile()) break;
//        }
//
//        return cur;
    }
}


class FileNode {
    TreeMap<String,FileNode> folders;
    StringBuilder content;
    String name;

    public FileNode(String name) {
        this.name = name;
        folders = new TreeMap<>();
        content = new StringBuilder();
    }

    public String getContent() {
        return content.toString();
    }

    public void addContent(String content) {

        this.content.append(content);

    }

    public boolean isFile() {
        return content.length()>0;
    }

    public List<String> getList() {
        List<String> files = new ArrayList<>();
        if(isFile()) {
            files.add(name);
        }
        else {

            files.addAll(folders.keySet());
        }
        return files;
    }

//    public List<String> getAllFilesRecursive(String path) {
//
//
//
//    }
}
