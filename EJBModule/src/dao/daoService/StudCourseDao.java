package dao.daoService;

import model.Course;
import model.StudCourse;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/28.
 */
@Remote
public interface StudCourseDao {

    public void addStudCourse(StudCourse studCourse);
    public void updateStudCourse(StudCourse studCourse);
    public void deleteStudCourse(StudCourse studCourse);
    public void deleteStudCourse(String studentid, String courseid);

    public List<StudCourse> getAllCourses();
    public List<StudCourse> getCoursesByCourseID(String courseid);
    public List<StudCourse> getCoursesByState(String studentid,int state);

    public StudCourse getStudCourse(String studentid,String courseid);
    public List<StudCourse> getReserveCoursesByStudentID(String studentid);
    public List<StudCourse> getStudyCoursesByStudentID(String studentid);
    public List<StudCourse> getChooseCourseByStudentID(String studentid);
    public List<StudCourse> getDropCoursesByStudentID(String studentid);
    public List<Course> getUnchooseCoursesByStudentID(String studentid);

}
