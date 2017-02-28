package dao.daoService;

import model.Course;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/18.
 */
@Remote
public interface CourseDao {
    public void add(Course course);
    public void updata(Course course);
    public void delete(Course course);
    public void delete(String courseid);

    public Course getCourseByID(String courseid);

    public List<Course> getCoursesByInstitutionID(String institutionid);

    public List<Course> getAllCourses();
}
