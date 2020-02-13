/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package courses;

/**
 *
 * @author xperiaW
 */
public class Course {

    private String courseId;
    private String courseName;

    public Course() {
    }

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "\nCourse Id " + courseId + "\nCourse Name " + courseName; //To change body of generated methods, choose Tools | Templates.
    }

}
