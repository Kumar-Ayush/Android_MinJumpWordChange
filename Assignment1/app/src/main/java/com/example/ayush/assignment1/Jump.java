package com.example.ayush.assignment1;

/**
 * Created by ayush on 3/2/17.
 */

import java.util.List;

class Jump {

    private List<String> path;  //For storing path
    private String lastWord;  //For storing last word of path
    private int length;   //Length of the path.

    public Jump(List<String> path) {
        this.path=path;
    }

    public Jump(List<String> path, int length, String lastWord) {
        this.path=path;
        this.length=length;
        this.lastWord=lastWord;
    }
    public List<String> getPath() {
        return path;
    }
    public int getLength() {
        return length;
    }
    public String getLastWord() {
        return lastWord;
    }

    public void setPath(List<String> path) {
        this.path = path;
    }

    public void setLength(int length) {
        this.length = length;
    }
}