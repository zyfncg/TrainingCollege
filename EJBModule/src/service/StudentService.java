package service;

import model.Course;
import model.Student;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by Zhang YF on 2016/12/28.
 */
@Remote
public interface StudentService {

    public boolean checkPassword(String studentid, String password);

    public List<Course> getAllCourses();

    public List<Course> getUnchooseCourses(String studendid);
//
//    public List<Course> getReserveCourses(String studentid);
//
    public List<Course> getStudyCourses(String studentid);

    public Student getStudentByID(String studentid);

    public void register(Student student);
}
