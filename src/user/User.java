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
public abstract class User {

    protected String name;
    protected int ID;

    // default folders for every user object
    private ArrayList<String> folders = new ArrayList<String>(Arrays.asList(
            "Java"
    ));
    public static String schoolName = "Bilkent";

    public User() {
    }

    public User(String name, int ID) {
        this.name = name;
        this.ID = ID;
    }

    public abstract void addNewFolder(String folderName);

    public static String getSchoolName() {
        return schoolName;
    }

}
