package com.kristijan.pajtasev.model;

import java.io.File;
import java.io.Serializable;

/**
 * Created by kristijan on 09.11.14..
 */
public class LocalFolder implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String absolutePath;
    private boolean isDirectory;
    private boolean isLink;
    private String extension;

    public LocalFolder(File file) {
        name = file.getName().isEmpty() ? "/" : file.getName();
        absolutePath = file.getAbsolutePath();
        isDirectory = file.isDirectory();
//            isLink; // TODO: check this
        extension = absolutePath.indexOf(".")>= 0 ?
                absolutePath.substring(absolutePath.lastIndexOf("."), absolutePath.length()-1) : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    public boolean isDirectory() {
        return isDirectory;
    }

    public void setDirectory(boolean isDirectory) {
        this.isDirectory = isDirectory;
    }

    public boolean isLink() {
        return isLink;
    }

    public void setLink(boolean isLink) {
        this.isLink = isLink;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}