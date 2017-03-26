package service;

import model.Course;
import model.Institution;
import model.StudCourse;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/19.
 */
@Remote
public interface InstitutionService {

    public boolean register(Institution institution);

    public boolean checkPassword(String institutionid, String password);

    public Institution getInstitutionByID(String institutionid);

    public boolean createCourse(Course course);
    public boolean updateCourse(Course course);

    public List<Course> getCourseByInstitution(String institution);

    public List<StudCourse> getStudCoursesByCourseID(String courseid);

    public Course getCourseByID(String courseid);

    public void saveGrades(List<StudCourse> list);

    public StudCourse getStudCourse(String studentid, String courseid);

    public void chooseCourse(String courseid);
    public void dropCourse(String courseid);

}
