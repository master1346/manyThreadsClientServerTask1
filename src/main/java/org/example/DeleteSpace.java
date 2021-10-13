package org.example;

public class DeleteSpace {
    public String deleteAllSpace(String str) {
        String newStr = str.replaceAll(" ","");
        return newStr;
    }
}
