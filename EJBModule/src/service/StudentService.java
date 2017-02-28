package service;

import model.Course;
import model.StudCourse;
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

    public List<StudCourse> getStudyCourses(String studentid);

    public List<StudCourse> getReserveCourses(String studentid);

    public List<StudCourse> getDropCourses(String studentid);

    public Student getStudentByID(String studentid);

    public void reserveCourse(String studentid, String courseid);
    public void studyCourse(String studentid, String courseid);
    public void dropReserveCourse(String studentid, String courseid);
    public void dropStudyCourse(String studentid, String courseid);

    public boolean bindBankcard(String studentid, String bankcardid);

    public boolean deposit(String studentid,double money);
//    public void pay(String studentid,double money);

    public boolean register(Student student);
}
