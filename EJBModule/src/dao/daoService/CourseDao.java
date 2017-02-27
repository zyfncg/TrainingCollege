package dao.daoService;

import model.Course;

import javax.ejb.Remote;
import java.util.List;

/**
 * Created by ZhangYF on 2017/2/18.
 */
@Remote
public interface CourseDao {
    public List<Course> getCoursesByInstitutionID(String institutionid);
    public List<Course> getAllCourses();
}
