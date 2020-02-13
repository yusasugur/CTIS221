/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author xperiaW
 */
public class Student extends User implements InterfaceUser {
    
    private ArrayList<String> folders = new ArrayList<String>(Arrays.asList(
            "Java", "Python", "Go"
    ));

    public ArrayList<String> getFolders() {
        return folders;
    }

    public Student() {
    }

    public Student(String name, int ID) {
        super(name, ID);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void addNewFolder(String folderName) {
        folders.add(folderName);    
    }

    @Override
    public int totalFolderCount() {
        return folders.size();
    }
    
}
