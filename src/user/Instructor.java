/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import courses.Course;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 *
 * @author xperiaW
 */
public class Instructor extends User implements InterfaceUser {

    private int studentCount;
    private String fieldOfStudy;
    public static LinkedHashSet<Course> courses = new LinkedHashSet<Course>();
    private ArrayList<String> folders = new ArrayList<String>(Arrays.asList(
            "Crystal", "Rust", "Scala"
    ));

    public Instructor() {
    }

    public ArrayList<String> getFolders() {
        return folders;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Instructor(int studentCount, String fieldOfStudy, String name, int ID) {
        super(name, ID);
        this.studentCount = studentCount;
        this.fieldOfStudy = fieldOfStudy;
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
